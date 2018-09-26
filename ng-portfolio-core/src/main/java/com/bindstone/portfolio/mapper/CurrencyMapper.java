package com.bindstone.portfolio.mapper;

import com.bindstone.portfolio.entity.Currency;
import com.bindstone.portfolio.mapper.dto.CurrencyDto;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper implements DtoMapper<Currency, CurrencyDto> {

    @Override
    public CurrencyDto toDto(Currency currency) {
        Validate.notNull(currency);
        return CurrencyDto.builder()
                .id(currency.getId())
                .iso(currency.getIso())
                .name(currency.getName())
                .exchange(currency.getExchange())
                .build();
    }

    @Override
    public Currency fromDto(CurrencyDto currencyDto) {
        Validate.notNull(currencyDto);
        return Currency.builder()
                .id(currencyDto.getId())
                .iso(currencyDto.getIso())
                .name(currencyDto.getName())
                .exchange(currencyDto.getExchange())
                .build();
    }
}
