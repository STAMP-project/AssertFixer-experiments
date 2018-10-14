package com.techmisal.easy;

import org.junit.Assert;
import org.junit.Test;

public class TransposeMatrixTest {


    TransposeMatrix transposeMatrix = new TransposeMatrix();

    @Test
    public void testTransposeMatrix(){

        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] B = {{1,4,7},{2,5,8},{3,6,9}};




        Assert.assertEquals(B,transposeMatrix.transpose(A));

    }


}
