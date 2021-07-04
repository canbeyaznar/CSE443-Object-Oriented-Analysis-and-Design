/**
 * The TrafficLight_Class class holds 3 states (red, yellow and green light).
 * And it shows the current state with the parameter named state.
 * Thus, the traffic light works with the determined timeouts and the states of the lights change.
 *
 *
 * In addition, the TrafficLight_Class
 * class should follow the notifications
 * from the camera to be aware of the traffic.
 * Therefore, he must enroll in the Hitech class and use the Observer class to do this.
 * And it should keep the hitech class as a parameter.
 */
public class TrafficLight_Class implements Observer {

    private State RedLight;
    private State GreenLight;
    private State YellowLight;

    private State state;

    private HiTech hiTech;

    private int TimeOut;

    /**
     *
     * @param hiTech camera class used to be aware of the traffic situation
     */
    public TrafficLight_Class(HiTech hiTech){
        this.hiTech = hiTech;
        RedLight = new RED_STATE(this);
        GreenLight = new GREEN_STATE(this);
        YellowLight = new YELLOW_STATE(this);
        state = RedLight;
        TimeOut = 0;
        hiTech.registerObserver(this);
    }

    /**
     * it simulates the traffic light with calling all the states
     * and waits each timeouts of each state
     */
    public void Run_TrafficLight(){
        state.SwitchStateToGreen();
        state.countTime();
        state.SwitchStateToYellow();
        state.countTime();
        state.SwitchStateToRed();
        state.countTime();
        state.SwitchStateToGreen();
    }

    public void SwitchToRed(){
        state.SwitchStateToRed();
    }

    public void SwitchToYellow(){
        state.SwitchStateToYellow();
    }

    public void SwitchToGreen(){
        state.SwitchStateToGreen();
    }

    public State getGreenLight() {
        return GreenLight;
    }
    public State getRedLight() {
        return RedLight;
    }
    public State getYellowLight() {
        return YellowLight;
    }

    public HiTech getHiTech() {
        return hiTech;
    }

    public State getState() {
        return state;
    }

    public int getTimeOut() {
        return TimeOut;
    }

    public void setGreenLight(State greenLight) {
        GreenLight = greenLight;
    }

    public void setHiTechStatus(boolean flag) {
        this.hiTech.changeDetected(flag);
    }

    public void setRedLight(State redLight) {
        RedLight = redLight;
    }

    public void setTimeOut(int timeOut) {
        TimeOut = timeOut;
    }

    public void setYellowLight(State yellowLight) {
        YellowLight = yellowLight;
    }

    public void setState(State state) {
        this.state = state;
    }


    /**
     * this method will updates the green light's timeout
     * @param TrafficStatus if it is true, timeout of green light will be 90
     *                      else it will be 60
     */
    @Override
    public void update(boolean TrafficStatus) {
        if(TrafficStatus){
            System.out.println("Green light time out changed to 90");
            GreenLight.ChangeTimeout(90);
        }
        else {
            System.out.println("Green light time out changed to 60");
            GreenLight.ChangeTimeout(60);
        }
    }
}
