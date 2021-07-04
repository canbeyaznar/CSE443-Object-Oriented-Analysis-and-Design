/**
 * Phone model class for Iflas Deluxe
 */
public class PhoneModel_IflasDeluxe extends Phone{
    private PhoneHardwareFactory phoneHardwareFactory;

    public PhoneModel_IflasDeluxe(PhoneHardwareFactory _phoneHardwareFactory){
        this.phoneHardwareFactory = _phoneHardwareFactory;
    }

    @Override
    void MakePhone() {
        System.out.println("Preparing " + name);
        Display = phoneHardwareFactory.createDisplay();
        Battery = phoneHardwareFactory.createBattery();
        CPUandRam = phoneHardwareFactory.createCPUandRam();
        Storage = phoneHardwareFactory.createStorage();
        Camera = phoneHardwareFactory.createCamera();
        Case = phoneHardwareFactory.createCase();

        DisplayContruct =   "5.3 inches,\n";

        BatteryContruct =   "20h,\n" +
                            "2800mAh\n";
        CPUandRamContruct = "2.2GHz,\n" +
                            "6GB,\n";

        StorageContruct =   "MicroSD support,\n" +
                            "32GB,\n";

        CameraContruct =    "12Mp front,\n" +
                            "5Mp rear,";
        CaseContruct =  "149x73x7.7 mm\n" +
                "waterproof,\n" +
                "aluminum,\n";


    }

}
