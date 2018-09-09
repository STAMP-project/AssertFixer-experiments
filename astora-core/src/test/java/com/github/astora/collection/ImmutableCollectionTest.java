package com.github.astora.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ImmutableCollectionTest {

    private ImmutableCollection<String> underTest;
    private List<String> target;

    @Before
    public void setUp() {
        target = Arrays.asList("a", "b", "c");
        underTest = ImmutableCollection.wrap(target);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenWrappingNullCollection() {
        ImmutableCollection.wrap(null);
    }

    @Test
    public void shouldWrapTargetWhenArgumentIsImmutableCollection() {
        ImmutableCollection<String> result = ImmutableCollection.wrap(underTest);
        assertSame(((ImmutableCollection.ImmutableCollectionDelegate) underTest).target,
                ((ImmutableCollection.ImmutableCollectionDelegate) result).target);
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
        assertEquals("a", iterator.next());

        iterator.remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailToRetainAll() {
        underTest.retainAll(Arrays.asList("a", "c"));
    }

    @Test
    public void shouldReturnCollectionSize() {
        assertEquals(3, underTest.size());
        assertEquals(3, target.size());
    }

    @Test
    public void shouldReturnEmptyFlag() {
        assertEquals(false, underTest.isEmpty());
        assertEquals(false, target.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenContainsElement() {
        assertEquals(true, underTest.contains("a"));
        assertEquals(true, target.contains("a"));
    }

    @Test
    public void shouldReturnTrueWhenContainsAllElements() {
        assertEquals(true, underTest.containsAll(Arrays.asList("a", "c")));
        assertEquals(true, target.containsAll(Arrays.asList("a", "c")));
    }

    @Test
    public void shouldConvertToArray() {
        Object[] result = underTest.toArray();
        Object[] array = target.toArray();

        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);

        assertArrayEquals(array, result);
    }

    @Test
    public void shouldConvertToSpecifiedArray() {
        Object[] result = underTest.toArray(new String[5]);
        Object[] array = target.toArray(new String[5]);

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
        assertEquals("ImmutableCollection{target=[a, b, c]}", underTest.toString());
    }

    @Test
    public void shouldReturnTrueWhenImmutableCollectionsAreEqual() {
        assertEquals(true, underTest.equals(ImmutableCollection.wrap(Arrays.asList("a", "b", "c"))));
    }

    @Test
    public void shouldReturnTrueWhenComparingSameInstance() {
        assertEquals(true, underTest.equals(underTest));
    }

    @Test
    public void shouldReturnFalseWhenImmutableCollectionsAreNotEqual() {
        assertEquals(false, underTest.equals(ImmutableCollection.wrap(Arrays.asList("b", "c"))));
    }

    @Test
    public void shouldReturnTrueWhenComparingDifferentTypeTarget() {
        assertEquals(true, underTest.equals(Arrays.asList("a", "b", "c")));
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
