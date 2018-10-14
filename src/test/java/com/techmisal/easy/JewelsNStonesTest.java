package com.techmisal.easy;


        import com.techmisal.easy.JewelsNStones;
        import org.junit.Assert;
        import org.junit.Test;


public class JewelsNStonesTest {


    private JewelsNStones jewelsNStones = new JewelsNStones();


    @Test
    public void testJewelsNStones() {


        Assert.assertEquals(3, jewelsNStones.numJewelsInStones("aA", "aAAbbbb"));
        Assert.assertEquals(0, jewelsNStones.numJewelsInStones("z", "ZZ"));


    }


}
