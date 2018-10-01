package com.iteration21.udemy.spring.s01;

import com.iteration21.udemy.spring.s01.v02.BubbleSortAlghoritm;
import com.iteration21.udemy.spring.s01.v02.SortingAlgorithm;

public class ComplexBusinessServiceV1 {

    //i21c direct instantiations, error: what if we like to use another sorting alhhoritm? -> new dirct instantiation -> TIHGT coupling
    //i21c good code considered have loose coupling
    SortingAlgorithm sortingAlgorithm = new BubbleSortAlghoritm();
}
