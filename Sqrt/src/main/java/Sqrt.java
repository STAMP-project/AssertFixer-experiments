/**
 * @author Belov Pavel
 * Lab №1 Task 2
 * Calculate the square root and add the accuracy of calculations.
 * "http://shtanyuk.tk/programs/java/html/01-intro-Sqrt.html"
 */

public class Sqrt {
    double delta=0.00000001;
    double arg;

    Sqrt(double arg, double delta) {
        this.arg=arg;
        this.delta=delta;
    }
    double average(double x,double y) {
        return (x+y)/2.0;
    }
    boolean good(double guess,double x) {
        return Math.abs(guess*guess-x)<delta;
    }
    double improve(double guess,double x) {
        return average(guess,x/guess);
    }
    double iter(double guess, double x) {
        if(good(guess,x))
            return guess;
        else
            return iter(improve(guess,x),x);
    }
    public double calc() {
        return iter(1.0,arg);
    }
}

class Program
{
    public static void main(String[] args)
    {
        double val = Double.parseDouble(args[0]);           //variable from arguments
        double delta = Double.parseDouble(args[0]);         //accuracy
        Sqrt sqrt = new Sqrt(val, delta);
        double result = sqrt.calc();
        System.out.println("Sqrt of " + val + "=" + result);
    }
}