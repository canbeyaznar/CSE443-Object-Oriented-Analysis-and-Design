/**
 * @author Can Beyaznar
 * The class used to get the features phones have in the eu.
 */
public class EU_HardwareFactory implements PhoneHardwareFactory {
    @Override
    public DisplayInterface createDisplay() {
        return new Display_24Bit();
    }

    @Override
    public BatteryInterface createBattery() {
        return new BatteryLithium_Ion();
    }

    @Override
    public CPUandRamInterface createCPUandRam() {
        return new CPURAM_Core_4();
    }

    @Override
    public StorageInterface createStorage() {
        return new Storage_64GB();
    }

    @Override
    public CameraInterface createCamera() {
        return new Camera_Opt_zoom_3x();
    }

    @Override
    public CaseInterface createCase() {
        return new Case_Waterproof_1m();
    }
}
