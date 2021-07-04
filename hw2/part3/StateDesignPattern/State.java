/**
 * State interface for red, yellow and green light
 */
public interface State {

    public void SwitchStateToRed();
    public void SwitchStateToGreen();
    public void SwitchStateToYellow();
    public void countTime();

}
