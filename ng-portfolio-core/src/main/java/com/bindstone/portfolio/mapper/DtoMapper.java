package com.bindstone.portfolio.mapper;

public interface DtoMapper<T, M> {

    M toDto(T object);

    T fromDto(M mappedObject);

}
