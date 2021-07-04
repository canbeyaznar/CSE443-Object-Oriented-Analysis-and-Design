/**
 * Model interface
 */

import javax.swing.JTextPane;
import java.util.ArrayList;

public interface ModelInterface  {


    void initialize();
    void on() throws InterruptedException;
    void off();

    ArrayList<PersonClass> getPeople();
    MediatorInterface getMediator();

    void printInformations(JTextPane textPane);

    void registerObserver(PersonObserver o);
    void removeObserver(PersonObserver o);
    void notifyObserver();

}
