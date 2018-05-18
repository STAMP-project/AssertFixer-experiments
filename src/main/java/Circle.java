/**
 * @author Pavel Belov
 * http://www.shtanyuk.tk/edu/nniit/java-new/labs/labs1.html
 * Lab №1 Task 6
 * "Earth and rope" and "Waterpool" puzzles
 */

public class Circle {
    private double Radius;          //radius of a circle R
    private double Ference;         //circumference С = 2 * PI * R
    private double Area;            //area S = pi * R * R

    //set of setters and getters for tasks "earth and rope" and "waterpool"
    public void setRadius(double Radius) {
        this.Radius = Radius;
        this.Ference = 2 * Math.PI * Radius;
        this.Area = Math.PI * Radius * Radius;
    }

    public void setFerence(double Ference)
    {
        this.Ference = Ference;
        this.Radius =  Ference / (2 * Math.PI);
        this.Area = Math.PI * this.Radius * this.Radius;
    }

    public void setArea(double Area)
    {
        this.Area    = Area;
        this.Radius = Math.sqrt(Area / Math.PI);
        this.Ference = 2 * this.Radius * this.Radius;
    }

    public double getRadius() {
        return Radius;
    }

    public double getFerence()
    {
        return Ference;
    }

    public double getArea()
    {
        return Area;
    }
}

class CircleDemonstration {
    public static void main(String args[])
    {
        //Earth and rope task
        Circle earth = new Circle();
        Circle rope = new Circle();

        double delta;                                       //Gap

        earth.setRadius(6371000);                           //Radius of the Earth
        rope.setFerence(earth.getFerence() + 1);            //Radius of the rope

        delta = rope.getRadius() - earth.getRadius();       //Answer is area of the rope minus area of the Earth
        System.out.println("Earth and rope task.");
        System.out.printf("Gap: %.2f meters\n", delta );

        //Waterpool task

        Circle pool = new Circle();
        Circle fence = new Circle();

        double roadPrice = 1000.0;
        double fencePrice = 2000.0;

        pool.setRadius(3);                                  //Radius of the waterpool
        fence.setRadius(4);                                 //Radius of the fence

        double roadFullPrice = roadPrice * (fence.getArea() - pool.getArea());  //price of road
        double fenceFullPrice = fencePrice * fence.getFerence();
        double materialsFullPrice = roadFullPrice + fenceFullPrice;

        System.out.println("Waterpool task.");
        System.out.printf("Price of materials for road: %.1f rubles\n", roadFullPrice);
        System.out.printf("Price of materials for fence and road: %.1f rubles\n", materialsFullPrice);
    }
}