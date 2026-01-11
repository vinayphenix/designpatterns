/*
 * =========================================================
 *              MEDIATOR DESIGN PATTERN (UML)
 * =========================================================
 *
 *                    +------------------+
 *                    |    Mediator      |
 *                    +------------------+
 *                    | + notify(c, msg) |
 *                    +------------------+
 *                              ^
 *                              |
 *                        implements
 *                              |
 *              +-------------------------------+
 *              |     ConcreteMediator          |
 *              +-------------------------------+
 *              | - colleagueA                  |
 *              | - colleagueB                  |
 *              +-------------------------------+
 *              | + notify(c, msg)              |
 *              +-------------------------------+
 *                       ^            ^
 *                       |            |
 *                       | uses       | uses
 *                       |            |
 *        +--------------------+   +--------------------+
 *        |     Colleague      |   |     Colleague      |
 *        +--------------------+   +--------------------+
 *        | - mediator         |
 *        +--------------------+
 *        | + send(msg)        |
 *        | + receive(msg)     |
 *        +--------------------+
 *                       ^
 *                       |
 *                    extends
 *                       |
 *        +--------------------------+   +--------------------------+
 *        |  ConcreteColleagueA      |   |  ConcreteColleagueB      |
 *        +--------------------------+   +--------------------------+
 *        | + receive(msg)           |   | + receive(msg)           |
 *        +--------------------------+   +--------------------------+
 *
 * =========================================================
 * Roles:
 * Mediator          -> Defines communication interface
 * ConcreteMediator  -> Handles interaction logic
 * Colleague         -> Communicates via mediator
 * ConcreteColleague -> Implements specific behavior
 * =========================================================
 */

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MediatorPattern {
    
}

interface Mediator {

    void login();

    void forgotPass();

}

interface Component {

    void setMediator(Mediator mediator);

    String getName();

}

class Dialog implements Mediator {

    private final JTextField userTextBox = new JTextField();
    private final JTextField passTextBox = new JTextField();
    private final LoginButton loginButton = new LoginButton();
    private final ForgotPasswordButton passwordButton = new ForgotPasswordButton();

    public Dialog() {
        loginButton.setMediator(this);
        passwordButton.setMediator(this);
    }

    @Override
    public void login() {
        System.out.println("Logging in...");
        String username = userTextBox.getText();
        String password = passTextBox.getText();
        // validate username and password
        // logs in the user or pops error message
    }

    @Override
    public void forgotPass() {
        System.out.println("Generating new Password...");
        String username = userTextBox.getText();
        // generate new pass for the user
        // send mail to this username with new pass
    }

    public void enterUsername(String username) {
        userTextBox.setText(username);
    }

    public void enterPassword(String password) {
        passTextBox.setText(password);
    }

    public void simulateLoginClicked() {
        loginButton.fireActionPerformed(new ActionEvent(this, 0, "login"));
    }

    public void simulateForgotPassClicked() {
        passwordButton.fireActionPerformed(new ActionEvent(this, 0, "forgot pass"));
    }

}

class ForgotPasswordButton extends JButton implements Component {

    private Mediator mediator;

    public ForgotPasswordButton() {
        super("Forgot Password?");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.forgotPass();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "ForgotPasswordButton";
    }

}

class LoginButton extends JButton implements Component {

    private Mediator mediator;

    public LoginButton() {
        super("Log In");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.login();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "LoginButton";
    }

}