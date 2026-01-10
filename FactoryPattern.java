/*
                +----------------------+
                |       Product        |  <<interface>>
                +----------------------+
                | +use()               |
                +----------^-----------+
                           |
          -----------------------------------------
          |                                       |
+----------------------+           +----------------------+
|   ConcreteProductA   |           |   ConcreteProductB   |
+----------------------+           +----------------------+
| +use()               |           | +use()               |
+----------------------+           +----------------------+

                +----------------------+
                |        Factory       |
                +----------------------+
                | +createProduct(type) |
                +----------^-----------+
                           |
                +----------------------+
                |   ConcreteFactory    |
                +----------------------+
                | +createProduct(type) |
                +----------------------+

Flow:
Client → Factory → Product
*/


public class FactoryPattern {

    public static void main(String[] args) {

        Restraunt vegRestraunt = new VegBurgerRestraunt();
        vegRestraunt.orderburger();


        Restraunt chickRestraunt = new ChickenBurgerRestraunt();
        chickRestraunt.orderburger();

        
    }
    
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


abstract class  Restraunt {
    protected abstract Burger createBurger();
    public void  orderburger() {
        Burger burger = createBurger();
        burger.prepare();
    }
}

class VegBurgerRestraunt extends Restraunt {
    protected Burger createBurger() {
        return new VegBurger();
    }
}


class ChickenBurgerRestraunt extends Restraunt {
    protected Burger createBurger() {
        return new ChickenBurger();
    }
}