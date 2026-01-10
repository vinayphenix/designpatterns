/*
                <<Product>>
                +----------------------+
                |        Product       |
                +----------------------+
                | - partA              |
                | - partB              |
                | - partC              |
                +----------------------+
                | +toString()          |
                +----------------------+


                <<Builder>>
                +----------------------+
                |    ProductBuilder    |  <<interface>>
                +----------------------+
                | +buildPartA()        |
                | +buildPartB()        |
                | +buildPartC()        |
                | +getResult():Product |
                +-----------^----------+
                            |
          ------------------------------------------
          |                                        |
+---------------------------+        +---------------------------+
|   ConcreteBuilderA        |        |   ConcreteBuilderB        |
+---------------------------+        +---------------------------+
| - product : Product       |        | - product : Product       |
+---------------------------+        +---------------------------+
| +buildPartA()             |        | +buildPartA()             |
| +buildPartB()             |        | +buildPartB()             |
| +buildPartC()             |        | +buildPartC()             |
| +getResult():Product      |        | +getResult():Product      |
+---------------------------+        +---------------------------+


                <<Director>>
                +----------------------+
                |       Director       |
                +----------------------+
                | - builder            |
                +----------------------+
                | +construct()         |
                +----------------------+

Flow:
Client → Director → Builder → Product
*/

public class BuilderPattern {

}

class Car {

    private final int id;
    private final int height;
    private final String brand;
    private final String model;
    private final String color;
    private final String engine;
    private final int nbrOfDoors;

    Car(int id, String brand, String model, String color, int height, String engine, int nbrOfDoors) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.height = height;
        this.engine = engine;
        this.nbrOfDoors = nbrOfDoors;
    }

    @Override
    public String toString() {
        return """
                Car {
                    id=%s,
                    height=%s,
                    brand=%s,
                    model=%s,
                    color=%s,
                    engine=%s,
                    nbrOfDoors=%s
                }""".formatted(id, height, brand, model, color, engine, nbrOfDoors);
    }

}

interface Builder {

    Builder id(int id);

    Builder brand(String brand);

    Builder model(String model);

    Builder color(String color);

    Builder height(int height);

    Builder engine(String engine);

    Builder nbrOfDoors(int nbrOfDoors);

}

class CarBuilder implements Builder {

    private int id;
    private int height;
    private String brand;
    private String model;
    private String color;
    private String engine;
    private int nbrOfDoors;

    @Override
    public CarBuilder id(int id) {
        this.id = id;
        return this;
    }

    @Override
    public CarBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarBuilder color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarBuilder height(int height) {
        this.height = height;
        return this;
    }

    @Override
    public CarBuilder engine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public CarBuilder nbrOfDoors(int nbrOfDoors) {
        this.nbrOfDoors = nbrOfDoors;
        return this;
    }

    public Car build() {
        return new Car(id, brand, model, color, height, engine, nbrOfDoors);
    }

}

class Director {
    public void buildBugatti(Builder builder) {
        builder.brand("Bugatti")
                .color("Blue")
                .nbrOfDoors(2)
                .engine("8L")
                .height(115);
    }

    public void buildLambo(Builder builder) {
        builder.brand("Lamborghini")
                .model("Aventador")
                .color("Yellow")
                .height(120);
    }
}
