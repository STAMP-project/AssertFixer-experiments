/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 17.09.18
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
class Sqrt {
    static double delta;
    static double arg;

    Sqrt(double arg, double delta) {
        this.arg = arg;
        this.delta = delta;
    }

    static double average(double x, double y) {
        return (x + y) / 2.0;
    }

    static boolean good(double guess, double x) {
        return Math.abs(guess * guess - x) < delta;
    }

    static double improve(double guess, double x) {
        return average(guess, x / guess);
    }

    static double iter(double guess, double x) {
        if (good(guess, x))
            return guess;
        else
            return iter(improve(guess, x), x);
    }

    public static double calc() {
        return iter(1.0, arg);
    }
}

class Program {
    public static void main(String[] args) {

        double value = Double.parseDouble(args[0]);
        double accuracy = Double.parseDouble(args[1]);
        Sqrt sqrt = new Sqrt(value,accuracy);
        double result = Sqrt.calc();
        System.out.println("Sqrt of " + value + "=" + result);
    }
    public static double sqrt(double value, double accuracy){
        Sqrt sqrt = new Sqrt(value,accuracy);
        double result = Sqrt.calc();
        return result;
    }
}
