/*
 * =========================================================
 *          TEMPLATE METHOD DESIGN PATTERN (UML)
 * =========================================================
 *
 *                 +----------------------+
 *                 |   AbstractClass      |
 *                 +----------------------+
 *                 | + templateMethod()   |  <-- final
 *                 +----------------------+
 *                 | # primitiveOp1()     |  <-- abstract
 *                 | # primitiveOp2()     |  <-- abstract
 *                 | # hook()             |  <-- optional
 *                 +----------------------+
 *                            ^
 *                            |
 *                         extends
 *                            |
 *        +-----------------------------------------------+
 *        |                                               |
 * +------------------------+              +------------------------+
 * |   ConcreteClassA       |              |   ConcreteClassB       |
 * +------------------------+              +------------------------+
 * | + primitiveOp1()       |              | + primitiveOp1()       |
 * | + primitiveOp2()       |              | + primitiveOp2()       |
 * | + hook() (optional)    |              | (inherits hook)       |
 * +------------------------+              +------------------------+
 *
 * =========================================================
 * Roles:
 * AbstractClass  -> Defines template method (algorithm)
 *                  and abstract steps
 * ConcreteClass  -> Implements specific steps
 * Hook           -> Optional override point
 * =========================================================
 */

public class TemplatePattern {
    
}


abstract class BaseGameLoader {

    public void load() {
        byte[] data = loadLocalData();
        createObjects(data);
        downloadAdditionalFiles();
        cleanTempFiles();
        initializeProfiles();
    }

    abstract byte[] loadLocalData();

    abstract void createObjects(byte[] data);

    abstract void downloadAdditionalFiles();

    abstract void initializeProfiles();

    protected void cleanTempFiles() {
        System.out.println("Cleaning temporary files...");
        // Some Common Code...
    }

}


class DiabloLoader extends BaseGameLoader {

    @Override
    public byte[] loadLocalData() {
        System.out.println("Loading Diablo files...");
        // Some Diablo Code...
        return new byte[0];
    }

    @Override
    public void createObjects(byte[] data) {
        System.out.println("Creating Diablo objects...");
        // Some Diablo Code...
    }

    @Override
    public void downloadAdditionalFiles() {
        System.out.println("Downloading Diablo sounds...");
        // Some Diablo Code...
    }

    @Override
    public void initializeProfiles() {
        System.out.println("Loading Diablo profiles...");
        // Some Diablo Code...
    }

}

class WorldOfWarcraftLoader extends BaseGameLoader {

    @Override
    public byte[] loadLocalData() {
        System.out.println("Loading local WoW files...");
        // Some Warcraft Code...
        return new byte[0];
    }

    @Override
    public void createObjects(byte[] data) {
        System.out.println("Creating WoW objects...");
        // Some Warcraft Code...
    }

    @Override
    public void downloadAdditionalFiles() {
        System.out.println("Downloading WoW sounds...");
        // Some Warcraft Code...
    }

    @Override
    public void initializeProfiles() {
        System.out.println("Loading WoW profiles...");
        // Some Warcraft Code...
    }

}