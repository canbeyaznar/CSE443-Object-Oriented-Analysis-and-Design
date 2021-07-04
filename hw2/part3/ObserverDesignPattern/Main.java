/**
 * This only includes the test part of the observer design pattern
 * @author Can BEYAZNAR
 */
public class Main {

    public static void main(String[] args) {
        HiTech hiTech = new HiTech();
        TrafficLight_Class trafficLight_class = new TrafficLight_Class(hiTech);
        trafficLight_class.Run_TrafficLight();
        trafficLight_class.setHiTechStatus(true);
        trafficLight_class.Run_TrafficLight();
    }

}
