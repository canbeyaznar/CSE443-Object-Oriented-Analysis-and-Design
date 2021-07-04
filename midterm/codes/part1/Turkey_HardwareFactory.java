/**
 * @author Can Beyaznar
 * The class used to get the features phones have in the Turkey.
 */
public class Turkey_HardwareFactory implements PhoneHardwareFactory {
    @Override
    public DisplayInterface createDisplay() {
        return new Display_32bit();
    }

    @Override
    public BatteryInterface createBattery() {
        return new BatteryLithium_Boron();
    }

    @Override
    public CPUandRamInterface createCPUandRam() {
        return new CPURAM_Core_8();
    }

    @Override
    public StorageInterface createStorage() {
        return new Storage_128GB();
    }

    @Override
    public CameraInterface createCamera() {
        return new Camera_Opt_zoom_4x();
    }

    @Override
    public CaseInterface createCase() {
        return new Case_Waterproof_2m();
    }
}
