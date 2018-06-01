package io.caiwan.utils.test;


import lombok.Getter;
import lombok.Setter;

public class DummyVariousAccessFieldsDto {

    @Getter
    @Setter
    private Object bothSetAndGet;

    @Setter
    private Object setOnly;

    @Getter
    private Object getOnly;

}
