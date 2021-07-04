/**
 * The TrafficLight_Class class holds 3 states (red, yellow and green light).
 * And it shows the current state with the parameter named state.
 * Thus, the traffic light works with the determined timeouts and the states of the lights change.
 */
public class TrafficLight_Class {

    private State RedLight;
    private State GreenLight;
    private State YellowLight;

    private State state;

    private int TimeOut;

    /**
     * Constructor class
     * first state is Red
     */
    public TrafficLight_Class(){
        RedLight = new RED_STATE(this);
        GreenLight = new GREEN_STATE(this);
        YellowLight = new YELLOW_STATE(this);
        state = RedLight;
        TimeOut = 15;

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

    public void setTimeOut(int timeOut) {
        TimeOut = timeOut;
    }

    public int getTimeOut() {
        return TimeOut;
    }

    public State getGreenLight() {
        return GreenLight;
    }

    public State getRedLight() {
        return RedLight;
    }

    public State getState() {
        return state;
    }

    public State getYellowLight() {
        return YellowLight;
    }


    public void setState(State state) {
        this.state = state;
        //state.countdown_time(switch_time);
    }
}
