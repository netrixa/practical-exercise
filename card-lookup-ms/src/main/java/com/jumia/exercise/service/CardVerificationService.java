package com.jumia.exercise.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jumia.exercise.domain.Card;
import com.jumia.exercise.dto.CardDto;
import com.jumia.exercise.dto.Payload;
import com.jumia.exercise.repo.CardRepository;



@Service
public class CardVerificationService {

	private static final String CARD_LOOKUP_API_URL = "https://lookup.binlist.net/";

	private static final Logger LOGGER = LoggerFactory.getLogger(CardVerificationService.class);

	/**
	 * 
	 * @param cardBIN
	 * @return
	 */
	@Autowired
	private CardRepository cardRepository;

	public CardDto verify(String cardBIN) {

		// first check if cardBIN already exist in database	
		Card card = this.cardRepository.findByCardBIN(cardBIN);
		LOGGER.info("Card In Repositpry {}",card);
		if (card == null) { //Card does not exist, so make API call
			// make API call
			card = this.doCardLookUp(cardBIN);
			if (card != null) {
				// persist card-look up details
				card.setCardBIN(cardBIN);
				LOGGER.info("Card Instance {}",card);
				this.cardRepository.saveAndFlush(card);
			}else{
				LOGGER.info("Card Instance >>> {}",card);
			}
		}
		
		Payload payload=new Payload();
		boolean status=false;
		if(card!=null){
			payload.setBank(card.getBank().getName());
			payload.setScheme(card.getScheme());
			payload.setType(card.getType());
			status=true;
		}
		CardDto cardDto=new CardDto();
		cardDto.setStatus(status);
		cardDto.setPayload(payload);
		return cardDto;
	}

	/**
	 * Third party API Call
	 * @param cardBIN
	 * @return
	 */
	public Card doCardLookUp(String cardBIN) {

		try {
			LOGGER.info(">> CardBIN: {}", cardBIN);
			//Create an object of RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Card> response = restTemplate.getForEntity(CARD_LOOKUP_API_URL.concat(cardBIN), Card.class);
			LOGGER.info("Response{}", response.toString());
			return response.getBody();
		} catch (Exception e) {
			LOGGER.error("Exception occured {}", e.getMessage());
		}

		return null;
	}
}
