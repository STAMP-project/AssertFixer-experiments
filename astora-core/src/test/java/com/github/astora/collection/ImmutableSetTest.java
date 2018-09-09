package com.github.astora.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ImmutableSetTest {

    private ImmutableSet<String> underTest;
    private Set<String> target;

    @Before
    public void setUp() {
        target = new HashSet<>(Arrays.asList("a", "b", "c"));
        underTest = ImmutableSet.wrap(target);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenWrappingNullSet() {
        ImmutableSet.wrap(null);
    }

    @Test
    public void shouldWrapTargetWhenArgumentIsImmutableSet() {
        ImmutableSet<String> result = ImmutableSet.wrap(underTest);
        assertSame(((ImmutableSet.ImmutableSetDelegate) underTest).target,
                ((ImmutableSet.ImmutableSetDelegate) result).target);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailToAddElement() {
        underTest.add("d");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailToAddMultipleElements() {
        underTest.addAll(Arrays.asList("e", "f"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailToClear() {
        underTest.clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailToRemoveElement() {
        underTest.remove("a");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailToRemoveMultipleElements() {
        underTest.removeAll(Arrays.asList("a", "c"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailToRemoveElementViaIterator() {
        ImmutableIterator<String> iterator = underTest.iterator();

        assertEquals(true, iterator.hasNext());
        assertNotNull(iterator.next());
        iterator.remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailToRetainAll() {
        underTest.retainAll(Arrays.asList("a", "c"));
    }

    @Test
    public void shouldReturnSetSize() {
        assertEquals(3, target.size());
        assertEquals(3, underTest.size());
    }

    @Test
    public void shouldReturnEmptyFlag() {
        assertEquals(false, target.isEmpty());
        assertEquals(false, underTest.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenContainsElement() {
        assertEquals(true, target.contains("a"));
        assertEquals(true, underTest.contains("a"));
    }

    @Test
    public void shouldReturnTrueWhenContainsAllElements() {
        assertEquals(true, target.containsAll(Arrays.asList("a", "c")));
        assertEquals(true, underTest.containsAll(Arrays.asList("a", "c")));
    }

    @Test
    public void shouldConvertToArray() {
        Object[] array = target.toArray();
        Object[] result = underTest.toArray();

        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);

        assertArrayEquals(array, result);
    }

    @Test
    public void shouldConvertToSpecifiedArray() {
        Object[] array = target.toArray(new String[5]);
        Object[] result = underTest.toArray(new String[5]);

        assertEquals(5, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
        assertEquals(null, result[3]);
        assertEquals(null, result[4]);

        assertArrayEquals(array, result);
    }

    @Test
    public void shouldConvertToString() {
        assertEquals("ImmutableSet{target=[a, b, c]}", underTest.toString());
    }

    @Test
    public void shouldReturnTrueWhenImmutableSetsAreEqual() {
        assertEquals(true, underTest.equals(ImmutableSet.wrap(new HashSet<>(Arrays.asList("a", "b", "c")))));
    }

    @Test
    public void shouldReturnTrueWhenComparingSameInstance() {
        assertEquals(true, underTest.equals(underTest));
    }

    @Test
    public void shouldReturnFalseWhenImmutableSetsAreNotEqual() {
        assertEquals(false, underTest.equals(ImmutableSet.wrap(new HashSet<>(Arrays.asList("b", "c")))));
    }

    @Test
    public void shouldReturnTrueWhenComparingDifferentTypeTarget() {
        assertEquals(true, underTest.equals(new HashSet<>(Arrays.asList("a", "b", "c"))));
    }

    @Test
    public void shouldReturnFalseWhenComparingNullElement() {
        assertEquals(false, underTest.equals(null));
    }

    @Test
    public void shouldProduceSameHashCodeAsTarget() {
        assertEquals(target.hashCode(), underTest.hashCode());
    }
}
