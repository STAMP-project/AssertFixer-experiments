package ru.job4j.departaments;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortTest {

    @Test
    public void whenSortAscendingOne() {
        Sort test = new Sort();
        String[] departaments = new String[]{"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        ArrayList<String> result = new ArrayList<>();
        result.add("K1");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK2");
        result.add("K2");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK1");
        result.add("K2\\SK1\\SSK2");
        assertThat(test.sor(departaments), is(result));
    }

    @Test
    public void whenSortAscendingTwo() {
        Sort test = new Sort();
        String[] departaments = new String[]{"K2\\SK2", "K2\\SK2\\SSK1", "K2\\SK2\\SSK2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK3", "K3"};
        ArrayList<String> result = new ArrayList<>();
        result.add("K1");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK1\\SSK3");
        result.add("K1\\SK2");
        result.add("K2");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK1");
        result.add("K2\\SK1\\SSK2");
        result.add("K2\\SK2");
        result.add("K2\\SK2\\SSK1");
        result.add("K2\\SK2\\SSK2");
        result.add("K3");
        assertThat(test.sor(departaments), is(result));
    }

    @Test
    public void whenSortInDicreasingOrderOne() {
        Sort test = new Sort();
        String[] departaments = new String[]{"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        ArrayList<String> result = new ArrayList<>();
        result.add("K2");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK2");
        result.add("K2\\SK1\\SSK1");
        result.add("K1");
        result.add("K1\\SK2");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK1\\SSK1");
        assertThat(test.sortInDicreasingOrder(departaments), is(result));
    }

    @Test
    public void whenSortInDicreasingOrderTwo() {
        Sort test = new Sort();
        String[] departaments = new String[]{"K2\\SK2", "K2\\SK2\\SSK1", "K2\\SK2\\SSK2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK3", "K3"};
        ArrayList<String> result = new ArrayList<>();
        result.add("K3");
        result.add("K2");
        result.add("K2\\SK2");
        result.add("K2\\SK2\\SSK2");
        result.add("K2\\SK2\\SSK1");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK2");
        result.add("K2\\SK1\\SSK1");
        result.add("K1");
        result.add("K1\\SK2");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK3");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK1\\SSK1");
        assertThat(test.sortInDicreasingOrder(departaments), is(result));
    }
}
