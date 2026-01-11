/*
 * =========================================================
 *              COMMAND DESIGN PATTERN (UML)
 * =========================================================
 *
 *        +-----------+           +----------------+
 *        |  Client   |---------->|    Command     |
 *        +-----------+           +----------------+
 *                                        ^
 *                                        |
 *                              implements|
 *                                        |
 *              +-------------------------+-------------------------+
 *              |                                                   |
 *   +----------------------+                        +----------------------+
 *   | ConcreteCommandA     |                        | ConcreteCommandB     |
 *   +----------------------+                        +----------------------+
 *   | - receiver: Receiver |                        | - receiver: Receiver |
 *   +----------------------+                        +----------------------+
 *   | + execute()          |                        | + execute()          |
 *   +----------------------+                        +----------------------+
 *              |                                                   |
 *              | delegates                                         | delegates
 *              v                                                   v
 *        +--------------------+                         +--------------------+
 *        |     Receiver       |                         |     Receiver       |
 *        +--------------------+                         +--------------------+
 *        | + actionA()        |                         | + actionB()        |
 *        +--------------------+                         +--------------------+
 *
 *        +-------------------+
 *        |     Invoker       |
 *        +-------------------+
 *        | - command         |
 *        +-------------------+
 *        | + setCommand()    |
 *        | + invoke()        |
 *        +-------------------+
 *
 * =========================================================
 * Roles:
 * Client   -> Creates and assigns commands
 * Command  -> Declares execute()
 * Concrete -> Implements command and calls receiver
 * Receiver -> Performs the actual operation
 * Invoker  -> Triggers the command
 * =========================================================
 */

public class CommandPattern {

    public static void main(String[] args) {
        Room room = new Room();
        room.setCommand(new OpenCloseCurtainsCommand(room.getCurtains()));
        room.executeCommand();
        System.out.println(room.curtainsOpen());

        System.out.println("==========================================");

        FloorLamp lamp = new FloorLamp();
        lamp.setCommand(new SwitchLightsCommand(lamp.getLight()));
        lamp.executeCommand();
        System.out.println(lamp.isLightOn());
    }

}

interface Command {

    void execute();

}

record OpenCloseCurtainsCommand(Curtains curtains) implements Command {

    @Override
    public void execute() {
        curtains.openClose();
    }

}

record SwitchLightsCommand(Light light) implements Command {

    @Override
    public void execute() {
        light.switchLights();
    }

}

abstract class Component {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

}

class FloorLamp extends Component {

    private final Light light;

    public FloorLamp() {
        this.light = new Light();
    }

    public Light getLight() {
        return light;
    }

    public boolean isLightOn() {
        return light.isSwitchedOn();
    }

}

class Room extends Component {

    private final Curtains curtains;

    public Room() {
        this.curtains = new Curtains();
    }

    public Curtains getCurtains() {
        return curtains;
    }

    public boolean curtainsOpen() {
        return curtains.isOpen();
    }

}

class Light {

    private boolean switchedOn = false;

    public void switchLights() {
        switchedOn = !switchedOn;
    }

    public boolean isSwitchedOn() {
        return switchedOn;
    }

}

class Curtains {

    private boolean open = false;

    public void openClose() {
        open = !open;
    }

    public boolean isOpen() {
        return open;
    }

}