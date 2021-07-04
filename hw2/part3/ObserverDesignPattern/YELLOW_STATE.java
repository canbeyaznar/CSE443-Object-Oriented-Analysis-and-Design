/**
 * Yellow light state
 */
public class YELLOW_STATE implements State {

    private TrafficLight_Class trafficLight_class;
    private int timeout;

    /**
     *
     * @param trafficLight_class traffic light
     */
    public YELLOW_STATE(TrafficLight_Class trafficLight_class){
        this.trafficLight_class = trafficLight_class;
        timeout = 3;
    }



    @Override
    public void SwitchStateToRed() {
        System.out.println("Yellow state switching to red");
        trafficLight_class.setState(trafficLight_class.getRedLight());
        trafficLight_class.setTimeOut(timeout);
    }

    @Override
    public void SwitchStateToGreen() {
        // can not change
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
        return "YELLOW_STATE";
    }

    /**
     * counts timeout down to 0
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
