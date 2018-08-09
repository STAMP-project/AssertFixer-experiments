package ru.job4j.fitcalculator;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitcalculatorTest {

    @Test
    public void manWeight() {
        Fitcalculator fit = new Fitcalculator();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    @Test
    public void womanWeight() {
        Fitcalculator fit = new Fitcalculator();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}