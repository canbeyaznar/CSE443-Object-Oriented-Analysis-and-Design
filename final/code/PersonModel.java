/**
 * Model class working in thread form
 */

import javax.swing.*;
import java.util.ArrayList;

public class PersonModel implements ModelInterface, Runnable {

    private ArrayList<PersonObserver> personObservers = new ArrayList<>();
    private int Population;
    private int patient_count;
    private boolean isStop = true;
    private MediatorInterface mediator;
    private int passed_time = 0;

    /**
     * get population count in constructor
     * @param people_count population
     */
    public PersonModel(int people_count){
        this.Population = people_count;

    }

    /**
     * Create map and mediator class
     */
    @Override
    public void initialize() {

        mediator = new Mediator();
        this.mediator.createPopulation(this.Population);
    }


    /**
     * resume
     */
    @Override
    public void on() {
        this.isStop=false;
    }

    /**
     * pause
     */
    @Override
    public void off() {
        this.isStop=true;
    }

    /**
     * get people array list
     * @return people array list
     */
    @Override
    public ArrayList<PersonClass> getPeople() {
        return this.mediator.getPeople();
    }

    /**
     *
     * @return mediator
     */
    @Override
    public MediatorInterface getMediator() {
        return this.mediator;
    }

    /**
     * print informations to textpane
     * @param textPane text pane
     */
    @Override
    public void printInformations(JTextPane textPane) {

        String res = this.mediator.GetPeopleInformations();
        res += "\nPassed Time : "+this.passed_time;
        textPane.setText(res);
    }

    /**
     * @param o observer
     */
    @Override
    public void registerObserver(PersonObserver o) {
        personObservers.add(o);
    }

    /**
     * @param o observer
     */
    @Override
    public void removeObserver(PersonObserver o) {
        int i = personObservers.indexOf(o);
        if (i >= 0) {
            personObservers.remove(i);
        }
    }

    /**
     * notify all observers
     */
    @Override
    public void notifyObserver() {
        for(int i=0; i<personObservers.size(); i++){
            personObservers.get(i).updatePerson();
        }
    }


    /**
     * Call notifyObserver method every 1 seconds.
     * Thus, as a second passes, individuals will move.
     */
    @Override
    public void run() {
        while(true){
            if(!this.isStop){
                this.notifyObserver();
                try {
                    Thread.sleep(1000);
                    passed_time += 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // sleep for this.isStop control
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
