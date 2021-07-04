/**
 * Green light state
 */
public class GREEN_STATE implements State {

    private TrafficLight_Class trafficLight_class;
    private int timeout_x;

    /**
     *
     * @param trafficLight_class traffic light
     */
    public GREEN_STATE(TrafficLight_Class trafficLight_class){
        this.trafficLight_class = trafficLight_class;
        timeout_x = 60;
    }

    public void setTimeout_x(int timeout_x) {
        this.timeout_x = timeout_x;
    }

    @Override
    public String toString() {
        return "GREEN_STATE";
    }

    @Override
    public void SwitchStateToRed() {
        // can not do that
    }

    @Override
    public void SwitchStateToGreen() {
        // can not do that
    }

    @Override
    public void SwitchStateToYellow() {
        System.out.println("Green State switching with yellow");
        trafficLight_class.setState(trafficLight_class.getYellowLight());
        trafficLight_class.setTimeOut(timeout_x);
    }

    /**
     * updates new time out for green light
     * This method is filled in only in the green state class.
     * @param timeout new timeout
     *
     */
    @Override
    public void ChangeTimeout(int timeout) {
        this.timeout_x = timeout;
    }

    /**
     * counts time
     */
    @Override
    public void countTime() {
        int temp = this.timeout_x;
        for(int i=this.timeout_x; i>=0; i--){
            System.out.println("Current state: "+this.toString() + " Remaining time: "+ temp);
            trafficLight_class.setTimeOut(--temp);
        }
    }

}
