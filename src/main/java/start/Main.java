package start;

import presentation.controller.Controller;
import presentation.view.View;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 20, 2021
 */
public class Main {
    /**
     * Clasa Main este cea care contine metoda statica main care porneste executia programului
     * @param args
     */
    public static void main(String[] args) {
        View view = new View();
        view.setVisible(true);
        Controller c = new Controller(view);
    }
}
