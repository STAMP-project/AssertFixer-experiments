package org.powerflows.dmn.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class DecsionTest {

    @Test
    public void shouldCreate() {
        final Decision decision = Decision.builder()
                .hitPolicy(HitPolicy.ANY)
                .id("someId")
                .name("test")
                .withInputs(inputs -> {
                    inputs
                            .add()
                            .description("description")
                            .name("name-1")
                            .build();
                })
                .withOutputs(outputs -> {
                    outputs
                            .add()
                            .description("decription")
                            .name("name-1")
                            .build();

                })
                .withRules(rules -> {

                })
                .build();


        assertNotNull(decision);
        assertEquals(1, decision.getInputs().size());
        assertEquals(1, decision.getOutputs().size());

    }
}
