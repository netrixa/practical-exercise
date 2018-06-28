package com.jumia.exercise.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.exercise.dto.CardDto;
import com.jumia.exercise.service.CardVerificationService;

@RestController
public class CardResource {

	@Autowired 
	private CardVerificationService cardVerificationService;
	
	/**
	 * 
	 * @param cardNo	Card BIN
	 * @return			Card verification details
	 */
	@GetMapping(value="card-scheme/verify/{cardBIN}",produces=MediaType.APPLICATION_JSON_VALUE)
	public CardDto verify(@PathVariable String cardBIN){
		
		
		return this.cardVerificationService.verify(cardBIN);
	}
}
