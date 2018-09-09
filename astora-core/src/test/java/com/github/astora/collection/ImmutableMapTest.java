package com.github.astora.collection;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ImmutableMapTest {

    private ImmutableMap<String, String> underTest;
    private Map<String, String> target = new HashMap<>();

    @Before
    public void setUp() {
        target = new HashMap<>();
        target.put("a", "x");
        target.put("b", "y");
        target.put("c", "z");

        underTest = ImmutableMap.wrap(target);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenWrappingNullMap() {
        ImmutableMap.wrap(null);
    }

    @Test
    public void shouldWrapTargetWhenArgumentIsImmutableSet() {
        ImmutableMap<String, String> result = ImmutableMap.wrap(underTest);
        assertSame(((ImmutableMap.ImmutableMapDelegate) underTest).target,
                ((ImmutableMap.ImmutableMapDelegate) result).target);
    }

    @Test
    public void shouldReturnEntrySet() {
        ImmutableSet<Map.Entry<String, String>> result = underTest.entrySet();
        Map<String, String> resultMap = result.stream().collect(
                Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        assertEquals(3, resultMap.size());
        assertEquals("x", resultMap.get("a"));
        assertEquals("y", resultMap.get("b"));
        assertEquals("z", resultMap.get("c"));
    }

    @Test
    public void shouldReturnKeys() {
        ImmutableSet<String> result = underTest.keySet();

        assertEquals(3, result.size());
        assertEquals(true, result.contains("a"));
        assertEquals(true, result.contains("b"));
        assertEquals(true, result.contains("c"));
    }

    @Test
    public void shouldReturnValues() {
        ImmutableCollection<String> values = underTest.values();

        assertEquals(3, values.size());
        assertEquals(true, values.contains("x"));
        assertEquals(true, values.contains("y"));
        assertEquals(true, values.contains("z"));
    }

    @Test
    public void shouldReturnSize() {
        assertEquals(3, underTest.size());
    }

    @Test
    public void shouldReturnIsEmptyFlag() {
        assertEquals(false, underTest.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenKeyIsPresent() {
        assertEquals(true, underTest.containsKey("a"));
    }

    @Test
    public void shouldReturnFalseWhenKeyIsAbsent() {
        assertEquals(false, underTest.containsKey("x"));
    }

    @Test
    public void shouldReturnTrueWhenValueIsPresent() {
        assertEquals(true, underTest.containsValue("z"));
    }

    @Test
    public void shouldReturnFalseWhenValueIsAbsent() {
        assertEquals(false, underTest.containsValue("c"));
    }

    @Test
    public void shouldReturnValueForExistingKey() {
        assertEquals("y", underTest.get("b"));
    }

    @Test
    public void shouldReturnNullWhenKeyIsAbsent() {
        assertEquals(null, underTest.get("x"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowExceptionWhenPutting() {
        underTest.put("d", "q");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowExceptionWhenRemoving() {
        underTest.remove("a");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowExceptionWhenPuttingAll() {
        underTest.putAll(new HashMap<>());
    }

    @Test(expected =  UnsupportedOperationException.class)
    public void shouldThrowExceptionWhenClearing() {
        underTest.clear();
    }

    @Test
    public void shouldReturnStringRepresentation() {
        assertEquals("ImmutableMap{target={a=x, b=y, c=z}}", underTest.toString());
    }

    @Test
    public void shouldReturnSameHashCodeAsTarget() {
        assertEquals(target.hashCode(), underTest.hashCode());
    }

    @Test
    public void shouldReturnTrueWhenImmutableMapsAreEqual() {
        assertEquals(true, underTest.equals(ImmutableMap.wrap(target)));
    }

    @Test
    public void shouldReturnFalseWhenImmutableMapsAreNotEqual() {
        Map<String, String> tmp = new HashMap<>(target);
        tmp.remove("a");

        assertEquals(false, underTest.equals(ImmutableMap.wrap(tmp)));
    }

    @Test
    public void shouldReturnTrueWhenComparingSameInstance() {
        assertEquals(true, underTest.equals(underTest));
    }

    @Test
    public void shouldReturnTrueWhenMapsAreEqual() {
        assertEquals(true, underTest.equals(target));
    }

    @Test
    public void shouldReturnFalseWhenMapsAreNotEqual() {
        Map<String, String> tmp = new HashMap<>(target);
        tmp.remove("b");

        assertEquals(false, underTest.equals(target));
    }

    @Test
    public void shouldReturnFalseWhenComparingNullElement() {
        assertEquals(false, underTest.equals(null));
    }
}

