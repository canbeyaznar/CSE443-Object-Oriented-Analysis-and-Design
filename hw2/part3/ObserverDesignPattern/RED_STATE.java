/**
 * Red light state
 */
public class RED_STATE implements State {

    private TrafficLight_Class trafficLight_class;
    private int timeout;

    /**
     *
     * @param trafficLight_class traffic light
     */
    public RED_STATE(TrafficLight_Class trafficLight_class){
        this.trafficLight_class = trafficLight_class;
        timeout = 15;
    }

    @Override
    public void SwitchStateToRed() {
        // can not change
    }

    @Override
    public void SwitchStateToGreen() {
        System.out.println("Red state switching to green");
        trafficLight_class.setState(trafficLight_class.getGreenLight());
        trafficLight_class.setTimeOut(timeout);
    }

    @Override
    public void SwitchStateToYellow() {
        // can not change
    }
    @Override
    public void ChangeTimeout(int timeout) {
        // can not change
    }
    @Override
    public String toString() {
        return "RED_STATE";
    }


    /**
     * counts time
     */
    @Override
    public void countTime() {
        int temp = this.timeout;
        for(int i=this.timeout; i>=0; i--){
            System.out.println("Current state: "+this.toString() + " Remaining time: "+ temp);
            trafficLight_class.setTimeOut(--temp);
        }
    }
}
