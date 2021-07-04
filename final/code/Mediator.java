/**
 * This is mediator class for mediator design pattern
 * Here, the relationships that will occur between users will be applied.
 * For example, the collision of two people, people walking, all people's information is kept here.
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Mediator implements MediatorInterface {

    // All people will be here
    private ArrayList<PersonClass> people = new ArrayList<>();

    // our constant parameters
    private final double Z = 0.5;
    private final double R = 0.6;

    // This will be used after calculating the probability of disease transmission.
    // Random float numbers will be taken. If this number is less than P, a healthy person is infected.
    private Random rand = new Random();

    /**
     * As many people as population_count are created and added to the people arraylist.
     * A random individual is infected with the disease.
     * @param population_count the number of people we want to create
     */
    @Override
    public void createPopulation(int population_count) {
        MapInformations_Class mapInformations_class = new MapInformations_Class();
        int random_patient_person = random(0,population_count - 1 );
        for(int i=0; i < population_count; i++){
            this.addPerson(new PersonClass(this, mapInformations_class,i));
        }
        this.getPeople().get(random_patient_person).setState("patient");
        // the first infected will not die to continue infecting people
        this.getPeople().get(random_patient_person).setRemainingTimeForDeath((int) (100 * (1-Z)));

        /*
        // For Fun !!
        for(int i=0; i<100; i++){
            this.getPeople().get(i).setState("patient");
            this.getPeople().get(i).setRemainingTimeForDeath((int) (100 * (1-Z)));
        }*/
    }

    /**
     * Add person to people arraylist
     * @param person person
     */
    @Override
    public void addPerson(PersonClass person) {
        this.people.add(person);
    }

    /**
     * get people arraylist
     * @return returns people arraylist
     */
    @Override
    public ArrayList<PersonClass> getPeople() {
        return this.people;
    }

    /**
     * get number of people
     * @return number of people
     */
    @Override
    public int getPeopleCount() {
        return this.people.size();
    }


    /**
     * If individuals collide, this method is called.
     * And the method works according to the state of the individuals (sickly, healthy, etc.).
     * @param Person1_index first person ID
     * @param Person2_index second person ID
     */
    @Override
    public void PersonCollide(int Person1_index, int Person2_index) {

        PersonClass person1 = this.people.get(Person1_index);
        PersonClass person2 = this.people.get(Person2_index);

        boolean isOnlyOnePatient = this.XOR(person1.getState().equals("patient"), person2.getState().equals("patient"));
        int wait_c_max = Math.max(person1.getC(), person2.getC());
        int min_distance = Math.min(person1.getD(), person2.getD());

        // if there is only one patient
        if(isOnlyOnePatient){
            System.out.println("patient detected");

            // calculate disease transmission rate for healthy individual
            double getSickProbability = Math.min( R * (1 + wait_c_max/10) *  person1.getMask() * person2.getMask() * (1-min_distance/10),1 );

            PersonClass healthyPerson;
            if(person1.getState().equals("healthy"))
                healthyPerson = person1;
            else
                healthyPerson = person2;

            // and generate a random number,
            // if that random number is less than the transmission rate, infect the disease.
            // You can think of this method as rolling dice.
            double random_value_for_getSickChance = rand.nextFloat();

            // for example if random_value_for_getSickChance is 50
            // and getSickProbability is 60 the healthy person will get the virus
            // but if random_value_for_getSickChance > getSickProbability he/she will not get the virus
            if(random_value_for_getSickChance < getSickProbability){

                healthyPerson.setState("patient");
                healthyPerson.setRemainingTimeForDeath((int) ((1-this.Z) * 100));

            }

        }

        // make the state of both collide
        person1.setCollidedPersonID(Person2_index);
        person2.setCollidedPersonID(Person1_index);

        // and set the time they should wait
        person1.PersonCollide(wait_c_max);
        person2.PersonCollide(wait_c_max);

        System.out.println("person1 : "+person1.toString());
        System.out.println("person2 : "+person2.toString());

    }

    /**
     * checks whether two individuals collide.
     * If it collides, the ID of the person with whom the two individuals collided is sent and the method ends.
     * ******************************************************************************************
     * **************** NOTE: here if either of them has a collide state, ***********************
     * **** the collision is ignored (as requested in the assignment) and false is returned. ****
     * ******************************************************************************************
     * @param Person_index ID of the individual controlling the collision
     * @return if there is collide between two individuals return true
     */
    @Override
    public boolean isPersonCollide(int Person_index) {

        PersonClass person1 = this.people.get(Person_index);
        if(person1.getState().equals("collide")){
            return false;
        }
        for(int i=0; i<this.people.size(); i++){
            PersonClass person2 = this.people.get(i);



            if((person2.getPersonID() != person1.getPersonID()) &&
                    !person2.getState().equals("collide") &&
                    person1.getCollidedPersonID() != person2.getPersonID()){
                int X1 = person1.getX();
                int Y1 = person1.getY();

                int X2 = person2.getX();
                int Y2 = person2.getY();
                if(     X1 < X2 + 5 &&
                        X1 + 5 > X2 &&
                        Y1 < Y2 + 5 &&
                        Y1 + 5 > Y2     ){

                    System.out.println("collide at X: "+ person1.getX()+ " Y: "+person1.getY() + " P1_ID: "+
                            person1.getPersonID() +" P2_ID: "+person2.getPersonID());
                    person1.setCollidedPersonID(person2.getPersonID());
                    person2.setCollidedPersonID(person1.getPersonID());
                    //PersonCollide(person1.getPersonID(), person2.getPersonID());

                    return true;
                }


            }
        }
        return false;

    }

    /**
     * Removes the collide state of two individuals.
     * And it returns to their old state.
     * @param Person1_index first person ID
     * @param Person2_index second person ID
     */
    @Override
    public void removeCollide(int Person1_index, int Person2_index) {

        System.out.println("removeCollide "+ Person1_index +" "+Person2_index);
        PersonClass person1 = this.people.get(Person1_index);
        PersonClass person2 = this.people.get(Person2_index);

        person1.removeCollide();
        person2.removeCollide();

    }

    /**
     * Calls the individual's walking method in the person_index index.
     * @param person_index person ID
     */
    @Override
    public void PersonWalk(int person_index) {
        this.people.get(person_index).PersonWalk();
    }

    /**
     * Draws the individual in the person_index index using g.
     * @param g graphics class
     * @param person_index person ID
     */
    @Override
    public void DrawPerson(Graphics g, int person_index) {

        PersonClass person = this.people.get(person_index);
        if(!person.getState().equals("dead")){
            g.setColor(person.getColor());
            g.fillRect(person.getX(),person.getY(), 5,5);
        }

    }

    /**
     * It counts the state of the individuals and returns them.
     * @return information string
     */
    @Override
    public String GetPeopleInformations() {

        int healthyCount = 0;
        int patientCount = 0;
        int deadCount = 0;
        int CollideCount = 0;

        for(int i=0; i<this.people.size(); i++){

            String temp_state = this.people.get(i).getState();
            if(temp_state.equals("healthy"))
                healthyCount++;
            else if(temp_state.equals("patient"))
                patientCount++;
            else if(temp_state.equals("dead"))
                deadCount++;
            else if(temp_state.equals("collide"))
                CollideCount++;
        }
        return "Total person count "+this.people.size()+"\nHealthy count: "+healthyCount
                +"\nPatient count: " +patientCount + "\nDead count: "+ deadCount+"\ncollide count: "+CollideCount;

    }

    /**
     * Standard XOR algorithm
     * @param A input A
     * @param B input B
     * @return boolean value
     */
    private boolean XOR(boolean A, boolean B){
        return ( !(A && B) && (A || B));
    }

    /**
     * get random value [min, max]
     * @param min minimum value
     * @param max maximum value
     * @return returns random int value
     */
    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }


}
