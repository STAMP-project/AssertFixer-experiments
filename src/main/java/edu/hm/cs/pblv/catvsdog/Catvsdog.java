package edu.hm.cs.pblv.catvsdog;


import java.nio.file.Path;

public class Catvsdog {
    private final Path image;

    public Catvsdog(Path image)
    {
        this.image = image;
    }

    public String getResult()
    {
        int[] result = DummyKI(this.image);
        if(result[0] > result[1])
        {
            return "Cat";
        }
        else if(result[0] < result[1])
        {
            return "Dog";
        }
        else
        {
            return "none";
        }
    }

    private int[] DummyKI(Path image)
    {
        int[] result = new int[2];
        result[0] = Math.random() < 0.5 ? 0 : 1;
        result[1] = Math.random() < 0.5 ? 0 : 1;
        return result;
    }
}
