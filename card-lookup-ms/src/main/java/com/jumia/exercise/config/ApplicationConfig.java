package com.jumia.exercise.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories(basePackages = "com.jumia.exercise.repo")
@org.springframework.boot.autoconfigure.domain.EntityScan(basePackages = "com.jumia.exercise.domain")
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
    
}
