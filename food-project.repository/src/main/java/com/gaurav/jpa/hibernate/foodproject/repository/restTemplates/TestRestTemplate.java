package com.gaurav.jpa.hibernate.foodproject.repository.restTemplates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component  // un-comment to let spring run this class through command line runner
public class TestRestTemplate implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(TestRestTemplate.class);

    @Autowired
    RestTemplateBuilder restTemplateBuilder;


    @Override
    public void run(String... args) throws Exception {

        RestTemplate restTemplate = restTemplateBuilder.build();
        Quote quote = restTemplate.getForObject(
                "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        logger.info(quote.toString());

    }
}
