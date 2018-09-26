package com.bindstone.portfolio.mapper.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class CurrencyDto {

    private Long id;
    private String iso;
    private String name;
    private BigDecimal exchange;

}
