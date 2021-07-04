/**
 * Mediator interface
 * The definition of the methods is explained in the mediator class.
 */

import java.awt.Graphics;
import java.util.ArrayList;

public interface MediatorInterface {

    void createPopulation(int population_count);
    void addPerson(PersonClass person);

    ArrayList<PersonClass> getPeople();

    int getPeopleCount();


    void PersonCollide(int Person1_index, int Person2_index);
    boolean isPersonCollide(int Person_index);
    void removeCollide(int Person1_index, int Person2_index);

    void PersonWalk(int person_index);

    void DrawPerson(Graphics g, int person_index);
    String GetPeopleInformations();


}
