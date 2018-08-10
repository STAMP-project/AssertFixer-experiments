package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter(70, 60);
        int result = converter.rubleToEuro(1);
        assertThat(result, is(70));
    }

    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter(70, 60);
        int result = converter.euroToRuble(70);
        assertThat(result, is(1));
    }

    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter(70, 60);
        int result = converter.rubleToDollar(1);
        assertThat(result, is(60));
    }

    @Test
    public void when1DollarTo60Ruble() {
        Converter converter = new Converter(70, 60);
        int result = converter.dollarToRuble(60);
        assertThat(result, is(1));
    }
}
