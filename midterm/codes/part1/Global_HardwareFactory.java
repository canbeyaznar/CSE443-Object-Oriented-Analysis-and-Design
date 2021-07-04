/**
 * @author Can Beyaznar
 * The class used to get the features phones have in the Global.
 */
public class Global_HardwareFactory implements PhoneHardwareFactory {
    @Override
    public DisplayInterface createDisplay() {
        return new Display_24Bit();
    }

    @Override
    public BatteryInterface createBattery() {
        return new BatteryLithium_Cobalt();
    }

    @Override
    public CPUandRamInterface createCPUandRam() {
        return new CPURAM_Core_2();
    }

    @Override
    public StorageInterface createStorage() {
        return new Storage_32GB();
    }

    @Override
    public CameraInterface createCamera() {
        return new Camera_Opt_zoom_2x();
    }

    @Override
    public CaseInterface createCase() {
        return new Case_Waterproof_50cm();
    }
}
