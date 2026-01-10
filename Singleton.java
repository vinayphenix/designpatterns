/*
                +--------------------------+
                |        Singleton         |
                +--------------------------+
                | - static instance        |
                +--------------------------+
                | - Singleton()            |
                +--------------------------+
                | + getInstance() : Singleton |
                +--------------------------+

Notes:
- Constructor is private
- Only one instance exists
- Global access point via getInstance()
*/


public class Singleton {

    public static volatile Singleton instance;
    public int data;

    private Singleton(int data) {
        this.data = data;
    }

    public static Singleton getInstance(int data) {
        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (instance == null) {
                    instance = result = new Singleton(data);
                }
            }
        }
        return instance;
    }
}