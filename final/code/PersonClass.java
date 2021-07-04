/**
 * The class in which individuals' information is kept.
 * Apart from this information, it also uses the mediator class and the MapInformations_Class class.
 */

import java.awt.Color;

public class PersonClass {
    private int personID;
    private int x;
    private int y;
    private int speed;
    private String state;
    private String direction;
    private Color color;

    private String oldState = "none";
    private int C;
    private int C_Wait = -1;
    private int D;
    private double mask;
    private int CollidedPersonID =-1;
    private int remainingTimeForDeath = 0;

    private MediatorInterface mediator;
    private MapInformations_Class mapInformations;

    /**
     * Person constructor
     * When creating individuals, the information of individuals is randomly
     * adjusted according to the parameters found in mapInformations.
     * Wearing a mask, x and y coordinates, speed, direction, etc. specifications.
     * @param mediator mediator class
     * @param mapInformations mapInformations class
     * @param id person id
     */
    public PersonClass(MediatorInterface mediator, MapInformations_Class mapInformations, int id){
        this.mediator = mediator;
        this.mapInformations = mapInformations;

        this.personID = id;
        this.x = random(0, this.mapInformations.getMAP_WIDTH()-1);
        this.y = random(0, this.mapInformations.getMAP_HEIGHT()-1);
        this.speed = random(1,this.mapInformations.getMAX_SPEED());
        this.C = random(1,this.mapInformations.getMAX_C());
        this.D = random(0, this.mapInformations.getMAX_D());

        this.state = "healthy";
        this.direction = which_way(random(0,3));

        int isMask = random(0,1);
        if(isMask == 1)
            this.mask = 1.0;
        else
            this.mask = 0.2;
        this.color = Color.GREEN;

    }

    /**
     * The method that works in the background for individuals to walk.
     * Here, with the help of the mediator class,
     * operations such as collision between two individuals,
     * reducing the time remaining after the collision,
     * and reducing the time remaining to die if sick are controlled.
     */
    public void PersonWalk(){

        // if person is healthy
        if(this.state.equals("healthy")){

            // is there any collide with person ?
            boolean isCollide = this.mediator.isPersonCollide(this.personID);
            if(isCollide){
                this.mediator.PersonCollide(this.getPersonID(), this.getCollidedPersonID());
            }
            else{
                this.walk();
            }
        }

        // if person is patient
        else if(this.state.equals("patient")){

            // is there any collide with person ?
            boolean isCollide = mediator.isPersonCollide(this.personID);
            if(isCollide){
                mediator.PersonCollide(this.personID, this.CollidedPersonID);
            }
            else{
                this.walk();

                // reduce remaining death time
                this.remainingTimeForDeath -= 1;
                if(remainingTimeForDeath <= 0){
                    this.state = "dead";
                }

            }

        }

        // if person is collide
        else if(this.state.equals("collide")){
            // reduce C_Wait
            System.out.println("Remaining C : " + this.C_Wait + " id: "+this.personID);
            this.C_Wait = this.C_Wait - 1;
            if(this.C_Wait <= 0 ){
                mediator.removeCollide(this.personID, this.CollidedPersonID);
            }
        }


        else{
            // empty
        }



    }

    /**
     * apply collide state to individual
     * @param C_Wait time an individual has to wait
     */
    public void PersonCollide(int C_Wait){
        this.C_Wait = C_Wait;
        this.oldState = this.state;
        this.setState("collide");
        this.direction = this.which_way(random(0,3));
    }

    /**
     * remove person's collide state and set old state
     */
    public void removeCollide(){
        this.C_Wait = -1;
        this.setState(this.oldState);
    }

    /**
     * simple walk algorithm
     * change its position depending on the individual's speed.
     * if it moves off the map, reposition it.
     */
    private void walk(){
        int new_x = this.x;
        int new_y = this.y;

        if(direction.equals("up")){
            new_y = this.y + this.speed;
        }
        else if(direction.equals("left")){
            new_x = this.x - this.speed;
        }
        else if(direction.equals("down")){
            new_y = this.y - this.speed;
        }
        else{ // right
            new_x = this.x + this.speed;
        }

        if((new_x < 0 || new_x >= this.mapInformations.getMAP_WIDTH()) || (new_y < 0 || new_y >= this.mapInformations.getMAP_HEIGHT())){
            this.setX(random(0, this.mapInformations.getMAP_WIDTH()));
            this.setY(random(0, this.mapInformations.getMAP_HEIGHT()));
            this.direction = which_way(random(0,3));
        }else{
            this.setX(new_x);
            this.setY(new_y);
        }
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

    /**
     *
     * @param way int way value
     * @return returns way string
     */
    private String which_way(int way){
        switch (way){
            case 0:
                return "left";
            case 1:
                return "up";
            case 2:
                return "right";
            case 3:
                return  "down";
        }
        return null;
    }

    /**
     * sets the ID of the individual with whom it collides.
     * @param collidedPersonID collided person ID
     */
    public void setCollidedPersonID(int collidedPersonID) {
        this.CollidedPersonID = collidedPersonID;
    }



    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getC() {
        return this.C;
    }

    public int getD() {
        return D;
    }

    public int getPersonID() {
        return this.personID;
    }

    public String getState() {
        return this.state;
    }

    public Color getColor() {
        return this.color;
    }

    public int getCollidedPersonID() {
        return CollidedPersonID;
    }

    public double getMask() {
        return mask;
    }

    /**
     * backup old state and set new state
     * @param state state
     */
    public void setState(String state) {
        this.oldState = this.state;
        this.state = state;
        if(this.state.equals("patient"))
            this.color = Color.RED;
        else if(this.state.equals("healthy"))
            this.color = Color.GREEN;
        else if(this.state.equals("collide"))
            this.color = Color.WHITE;
        else{
            this.state = "healthy";
            this.color = Color.GREEN;
        }
    }

    /**
     * set remaining time for death
     * @param remainingTimeForDeath remaining time for death
     */
    public void setRemainingTimeForDeath(int remainingTimeForDeath) {
        this.remainingTimeForDeath = remainingTimeForDeath;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        String res = "";
        res += "id: "+ this.personID + " Direction " + this.direction + " x: " +this.x +" y: "+ this.y +" color: " + this.color.toString();
        res += "state : "+this.state+" CollidedPersonID: "+this.CollidedPersonID + " C_wait: "+this.C_Wait;
        return res;
    }


}
