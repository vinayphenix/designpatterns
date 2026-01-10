/*
                <<Prototype>>
                +----------------------+
                |      Prototype       |  <<interface>>
                +----------------------+
                | +clone() : Prototype |
                +----------^-----------+
                           |
          -----------------------------------------
          |                                       |
+---------------------------+       +---------------------------+
|   ConcretePrototypeA      |       |   ConcretePrototypeB      |
+---------------------------+       +---------------------------+
| - field1                  |       | - field1                  |
| - field2                  |       | - field2                  |
+---------------------------+       +---------------------------+
| +clone()                  |       | +clone()                  |
+---------------------------+       +---------------------------+


                <<Client>>
                +----------------------+
                |        Client        |
                +----------------------+
                | - prototype          |
                +----------------------+
                | +createClone()       |
                +----------------------+

Flow:
Client → Prototype → clone()
*/

import java.util.HashMap;
import java.util.Map;

public class PrototypePattern {

}

abstract class Vehicle {

    private final String brand;
    private final String model;
    private final String color;

    public Vehicle(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    protected Vehicle(Vehicle vehicle) {
        this.brand = vehicle.brand;
        this.model = vehicle.model;
        this.color = vehicle.color;
    }

    public abstract Vehicle clone();

}

class Bus extends Vehicle {

    private final int doors;

    public Bus(String brand, String model, String color, int doors) {
        super(brand, model, color);
        this.doors = doors;
    }

    private Bus(Bus bus) {
        super(bus);
        this.doors = bus.doors;
    }

    @Override
    public Bus clone() {
        return new Bus(this);
    }

}

class Car extends Vehicle {

    private final int topSpeed;

    public Car(String brand, String model, String color, int topSpeed) {
        super(brand, model, color);
        this.topSpeed = topSpeed;
    }

    private Car(Car car) {
        super(car);
        this.topSpeed = car.topSpeed;
    }

    @Override
    public Car clone() {
        return new Car(this);
    }

}

class VehicleCache {

    private final Map<String, Vehicle> cache = new HashMap<>();

    public VehicleCache() {
        Car car = new Car("Bugatti", "Chiron", "Blue", 261);
        Bus bus = new Bus("Mercedes", "Setra", "White", 48);

        cache.put("Bugatti Chiron", car);
        cache.put("Mercedes Setra", bus);
    }

    public Vehicle get(String key) {
        return cache.get(key).clone();
    }
}