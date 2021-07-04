/**
 * @author Can Beyaznar
 * Abstract class for phone models
 */
public abstract class Phone {

    protected String name;
    protected DisplayInterface Display;
    protected BatteryInterface Battery;
    protected CPUandRamInterface CPUandRam;
    protected StorageInterface Storage;
    protected CameraInterface Camera;
    protected CaseInterface Case;

    /**
     * The values of these parameters will be determined by the model of the phone.
     * These values are features that will not change depending on the phone model.
     */
    protected String DisplayContruct;
    protected String BatteryContruct;
    protected String CPUandRamContruct;
    protected String StorageContruct;
    protected String CameraContruct;
    protected String CaseContruct;

    abstract void MakePhone();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        //attachDisplay();
        //return null;

        StringBuffer result = new StringBuffer();
        result.append("\n-o-o-o-o-o-o-o-o-o-o-o-o-o-\n");
        result.append("Model Name : ");
        result.append(name + "\n");

        result.append("\nDisplay: \n");
        result.append(DisplayContruct);
        if(Display != null){
            result.append(Display.toString());
            result.append("\n");
        }
        result.append("\nBattery: \n");
        result.append(BatteryContruct);
        if(Battery != null){
            result.append(Battery.toString());
            result.append("\n");
        }
        result.append("\nCPU and Ram: \n");
        result.append(CPUandRamContruct);
        if(CPUandRam != null){
            result.append(CPUandRam.toString());
            result.append("\n");
        }
        result.append("\nStorage: \n");
        result.append(StorageContruct);
        if(Storage != null){
            result.append(Storage.toString());
            result.append("\n");
        }
        result.append("\nCamera: \n");
        result.append(CameraContruct);
        if(Camera != null){

            result.append(Camera.toString());
            result.append("\n");
        }
        result.append("\nCase: \n");
        result.append(CaseContruct);
        if(Case != null){
            result.append(Case.toString());
            result.append("\n");
        }
        result.append("\n-o-o-o-o-o-o-o-o-o-o-o-o-o-\n");
        return result.toString();
    }
}
