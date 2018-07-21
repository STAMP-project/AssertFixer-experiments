package tech.spring.structure.scaffold.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ConditionalTypeTest {

    @Test
    public void testConditionalTypes() {
        assertEquals("Conditional type include not as expected!", ConditionalType.INCLUDE, ConditionalType.valueOf("INCLUDE"));
        assertEquals("Conditional type filter not as expected!", ConditionalType.FILTER, ConditionalType.valueOf("FILTER"));
        assertEquals("Conditional type disallow not as expected!", ConditionalType.DISALLOW, ConditionalType.valueOf("DISALLOW"));
        assertEquals("Conditional type reset not as expected!", ConditionalType.RESET, ConditionalType.valueOf("RESET"));
    }

}
