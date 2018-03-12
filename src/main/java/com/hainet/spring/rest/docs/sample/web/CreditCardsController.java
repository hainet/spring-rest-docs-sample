package com.hainet.spring.rest.docs.sample.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hainet.spring.rest.docs.sample.domain.entity.CreditCard;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CreditCardsController {

    private final ObjectMapper objectMapper;

    public CreditCardsController(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/creditcards/{id}")
    public ResponseEntity<String> creditCards(@PathVariable final int id) throws JsonProcessingException {
        final val creditCard = new CreditCard(
                id,
                "1234-5678-9012-3456",
                "HAINE TAKANO",
                LocalDate.of(2020, 12, 31),
                "123",
                "12345"
        );

        return new ResponseEntity<>(objectMapper.writeValueAsString(creditCard), HttpStatus.OK);
    }
}
