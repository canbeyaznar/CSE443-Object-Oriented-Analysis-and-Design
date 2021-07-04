/**
 * @author Can Beyaznar
 *
 * This interface is used to obtain the variable properties of the phone.
 * Turkey, 3 different classes so that the EU and globally will use this method in interfaces.
 *
 */
public interface PhoneHardwareFactory {

    DisplayInterface createDisplay();
    BatteryInterface createBattery();
    CPUandRamInterface createCPUandRam();
    StorageInterface createStorage();
    CameraInterface createCamera();
    CaseInterface createCase();
}
