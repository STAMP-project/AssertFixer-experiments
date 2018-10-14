package com.techmisal.easy;

import com.techmisal.easy.UniqueMorseRepresentation;
import org.junit.Assert;
import org.junit.Test;

public class UniqueMorseRepresentationTest {


    private UniqueMorseRepresentation uniqueMorseRepresentation = new UniqueMorseRepresentation();


    @Test
    public void testUniqueMorseRepresentation(){


        String[] words = {"gin", "zen", "gig", "msg"};
        Assert.assertEquals(2,uniqueMorseRepresentation.uniqueMorseRepresentations(words));


    }




}
