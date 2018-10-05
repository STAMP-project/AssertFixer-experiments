package ru.job4j.sorting.departments;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentsBookTest {
    @Test
    public void whenDepartmentsSortedInAscendingOrderThenSortedArray() {
        String[] departments = {
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
        };
        String[] sortedMassive = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        DepartmentsBook book1 = new DepartmentsBook();
        String[] actual = book1.sortDepartmentsInAscending(departments);
        assertThat(actual, is(sortedMassive));
    }

    @Test
    public void whenDepartmentsSortedInDescendingOrderThenSortedArray() {
        String[] departments = {
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        String[] sortedMassive = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"};
        DepartmentsBook book1 = new DepartmentsBook();
        String[] actual = book1.parse(departments);
        actual = book1.sortDepartmentsInDescending(actual);
        assertThat(actual, is(sortedMassive));
    }
}