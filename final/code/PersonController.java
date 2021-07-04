/**
 * The control class to be used when showing individuals in the map.
 */
public class PersonController implements ControllerInterface {

    private ModelInterface personModel;
    private CoronaGame_GUI view;

    /**
     * model interface to be used
     * @param modelInterface model interface
     */
    public PersonController(ModelInterface modelInterface){
        this.personModel = modelInterface;
        this.view = new CoronaGame_GUI(this,this.personModel);
        this.view.CreateView();
        this.view.createControls();
        this.personModel.initialize();

        // The program must be multithreaded for the start stop buttons to work. so the model runs on one thread.
        new Thread((PersonModel) this.personModel).start();
    }

    /**
     * calls model on method
     */
    @Override
    public void start_controller() {
        try {
            this.personModel.on();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * calls model off method
     */
    @Override
    public void stop_controller() {
        this.personModel.off();
    }
}
