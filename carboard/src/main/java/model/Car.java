package model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;

    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "carBody_id")
    private CarBody carBody;

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name='" + name + '\'' + ", transmissionId=" + transmission.getName() + ", engineId=" + engine.getName() + ", carBodyId=" + carBody.getName() + '}';
    }

    public Car() {

    }

    public Car(int id, String name, Transmission transmission, Engine engine, CarBody carBody) {
        this.id = id;
        this.name = name;
        this.transmission = transmission;
        this.engine = engine;
        this.carBody = carBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }
}
