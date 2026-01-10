/*
                 <<Abstract Product>>
                +------------------+
                |      Burger      |
                +------------------+
                | +prepare()       |
                +---------^--------+
                          |
          -----------------------------------
          |                                 |
+---------------------+       +---------------------+
|     VegBurger       |       |   ChickenBurger     |
+---------------------+       +---------------------+
| +prepare()          |       | +prepare()          |
+---------------------+       +---------------------+


                 <<Abstract Product>>
                +------------------+
                |      Pizza       |
                +------------------+
                | +bake()          |
                +---------^--------+
                          |
          -----------------------------------
          |                                 |
+---------------------+       +---------------------+
|     VegPizza        |       |   ChickenPizza      |
+---------------------+       +---------------------+
| +bake()             |       | +bake()             |
+---------------------+       +---------------------+


                <<Abstract Factory>>
                +---------------------------+
                |        Restraunt          |
                +---------------------------+
                | +createBurger() : Burger  |
                | +createPizza()  : Pizza   |
                | +orderBurger()            |
                +-------------^-------------+
                              |
          ---------------------------------------------
          |                                           |
+---------------------------+       +---------------------------+
|   VegBurgerRestraunt      |       | ChickenBurgerRestraunt    |
+---------------------------+       +---------------------------+
| +createBurger() : Burger  |       | +createBurger() : Burger  |
| +createPizza()  : Pizza   |       | +createPizza()  : Pizza   |
+---------------------------+       +---------------------------+

Key:
- Factory creates a FAMILY of related objects
- Veg → VegBurger + VegPizza
- Chicken → ChickenBurger + ChickenPizza
*/


public class AbstractFactory {
    
}

interface  Burger {

    public void prepare();

}

class VegBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("preparing veg burger");
    }

}

class ChickenBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("preparing veg burger");
    }
}


interface  Pizza {

    public void bake();

}

class VegPizza implements Pizza {

    @Override
    public void bake() {
        System.out.println("baking veg burger");
    }

}

class ChickenPizza implements Pizza {
    @Override
    public void bake() {
        System.out.println("baking veg burger");
    }
}


abstract class  Restraunt {
    protected abstract Burger createBurger();
    protected abstract Pizza createPizza();
    public void  orderburger() {
        Burger burger = createBurger();
        burger.prepare();
    }
}

class VegRestraunt extends Restraunt {
    protected Burger createBurger() {
        return new VegBurger();
    }

    protected Pizza createPizza() {
        return new VegPizza();
    }
}


class ChickenRestraunt extends Restraunt {
    protected Burger createBurger() {
        return new ChickenBurger();
    }

    protected Pizza createPizza() {
        return new ChickenPizza();
    }
}