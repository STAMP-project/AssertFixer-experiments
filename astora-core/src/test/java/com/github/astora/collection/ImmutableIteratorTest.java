package com.github.astora.collection;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class ImmutableIteratorTest {

    private ImmutableIterator<String> underTest;
    private List<String> target;

    @Before
    public void setUp() {
        target = Arrays.asList("a", "b", "c");
        underTest = ImmutableIterator.wrap(target.iterator());
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenWrappingNullIterator() {
        ImmutableIterator.wrap(null);
    }

    @Test
    public void shouldWrapTargetWhenArgumentIsImmutableIterator() {
        ImmutableIterator<String> result = ImmutableIterator.wrap(underTest);
        assertSame(((ImmutableIterator.ImmutableIteratorDelegate) underTest).target,
                ((ImmutableIterator.ImmutableIteratorDelegate) result).target);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailToRemoveElement() {
        assertEquals(true, underTest.hasNext());
        assertEquals("a", underTest.next());
        underTest.remove();
    }

    @Test
    public void shouldProduceSameHashCodeAsTarget() {
        Iterator<String> iterator = target.iterator();
        assertEquals(iterator.hashCode(), ImmutableIterator.wrap(iterator).hashCode());
    }

    @Test
    public void shouldConvertToString() {
        String result = underTest.toString();

        assertThat(result, CoreMatchers.startsWith("ImmutableIterator{target=java.util.AbstractList$Itr@"));
        assertThat(result, CoreMatchers.endsWith("}"));
    }

    @Test
    public void shouldReturnTargetEquality() {
        assertEquals(false, underTest.equals(ImmutableIterator.wrap(Arrays.asList("a", "b", "c").iterator())));
    }

    @Test
    public void shouldReturnTrueWhenComparingSameInstance() {
        assertEquals(true, underTest.equals(underTest));
    }

    @Test
    public void shouldReturnTargetEqualityWhenComparingDifferentTypeTarget() {
        assertEquals(false, underTest.equals(Arrays.asList("a", "b", "c").iterator()));
    }

    @Test
    public void shouldReturnFalseWhenComparingNullElement() {
        assertEquals(false, underTest.equals(null));
    }
}
