package com.jumia.exercise.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumia.exercise.domain.Card;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	
	public Card findByCardBIN(String cardBIN);
}
