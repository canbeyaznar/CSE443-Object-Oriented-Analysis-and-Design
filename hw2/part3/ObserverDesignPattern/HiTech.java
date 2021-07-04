import java.util.ArrayList;

/**
 * Camera class which is subject
 * TrafficLight_Class will get updates with registering this class
 */
public class HiTech implements Subject{
    private ArrayList<Observer> observer_list;
    private boolean flag;

    public HiTech(){
        observer_list = new ArrayList<>();
    }

    /**
     *
     * @param flag if flag is true it must change green light timeout to 90
     *             else it will be 60
     */
    public void changeDetected(boolean flag){
        System.out.println("Change detected");
        this.flag = flag;
        this.notifyObservers();
    }

    /**
     *
     * @param o new observer
     */
    @Override
    public void registerObserver(Observer o) {
        observer_list.add(o);
    }

    /**
     *
     * @param o remover observer
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observer_list.indexOf(o);
        if(i >= 0){
            observer_list.remove(i);
        }
    }

    /**
     * this method will called after changeDetected method called
     * and it will update green light timeout
     */
    @Override
    public void notifyObservers() {
        for(int i=0; i<observer_list.size(); i++){
            Observer observer = (Observer) observer_list.get(i);
            observer.update(flag);
        }
    }
}
