package com.iteration21.udemy.spring;

import static org.junit.Assert.assertTrue;

import com.iteration21.udemy.spring.s01.ComplexBusinessServiceV1;
import com.iteration21.udemy.spring.s01.v02.BubbleSortAlghoritm;
import com.iteration21.udemy.spring.s01.v02.ComplexBusinessServiceV2;
import com.iteration21.udemy.spring.s01.v02.SortingAlgorithm;
import org.junit.Test;


public class AppTest 
{

    public static final boolean VIDEO_DONE = true;
    public static final boolean VIDEO_NOT_DONE = false;

    @Test
    public void soILikeToHaveCD() {

        assertTrue(false);
        //next for local postgres setup: https://devcenter.heroku.com/articles/heroku-postgresql#local-setup
        //local or in docker :P? maybe docker compose? my pet project should have all in place..
    }

    @Test
    public void soILikeToHaveCI() {
        //i21c KONFIGURUJE Continuous Delivery $ Continuous Integration
        //  in
        //      .travis.yml:2
        //  adding
        //      before_install:
        //          - chmod +x mvnw
        //   helps, s: https://github.com/travis-ci/travis-ci/issues/6298
        //  another solution would be to execute git update-index --chmod=+x mvnw
        //  but I see its in place already.. -rwxr-xr-x 1 Darius 197121 7346 Sep 28 17:39 mvnw*

    }

    @Test
    public void video02() {
        //i21c WSTĘP
        //==========
        //3 warstwowa aplikacja (layers)
        //różnica pomiędzy DEPENDANT a DEPENDANCY
        //kto kogo woła: web woła > business woła > data
        //warstwa biznesu jest zależna -DEPENDANT ON- od warstwy danych (data layer/wywołuje data API)
        //warstwa danych jest zależnością -DEPENDANCY OF- konieczną dla warstwy biznesowej

        //i21c SREDNIWIECZE
        //==================
        //przed springiem bylo TIGHT COUPLING
        ComplexBusinessServiceV1 complexBusinessServiceV1 = new ComplexBusinessServiceV1();

        //i21c BAROK
        //===========
        //teraz dzieki uzyciu konstruktora mozemy parametryzowac w runtime - alecala prace wykonujemy sami i zaciemnia to kod
        SortingAlgorithm sortingAlgorithm = new BubbleSortAlghoritm();
        ComplexBusinessServiceV2 complexBusinessServiceV2 = new ComplexBusinessServiceV2(sortingAlgorithm);
        //niby ok ale dlaczego musialem wywlec flaki na zewnatrz i wskazac jakiego sortowania uzyc przy tym wywolaniu,
        //nie ladniej byloby ukryc ta informacje gdzies w srodku?

        //=> SPRING instantiates objects and populate dependancies automatically
        //=> it's still programmers job to manage dependancies so that SPRING knows what to instantiate..
        assertTrue(VIDEO_DONE);
    }

    @Test
    public void video01()
    {
        //i21c INTRO DO KURSU
        //===================
        //src: https://github.com/in28minutes/spring-master-class
        //opis tego co znajdzie sie w kursie
        assertTrue(VIDEO_DONE);
    }
}
