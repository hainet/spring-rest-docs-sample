package com.hainet.spring.rest.docs.sample.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalDate;

@Value
public class CreditCard {

    private int id;

    private String number;

    private String holder;

    @JsonFormat(pattern = "yyyy/MM")
    private LocalDate goodThru;

    private String securityCode;

    private String securePassword;
}
