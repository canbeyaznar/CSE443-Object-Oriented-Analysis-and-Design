/**
 * Phone model class for I-I-AmanIflas
 */
public class PhoneModel_IIAmanIflas extends Phone{

    PhoneHardwareFactory phoneHardwareFactory;

    public PhoneModel_IIAmanIflas(PhoneHardwareFactory _phoneHardwareFactory){
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

        DisplayContruct =   "4.5 inches,\n";

        BatteryContruct =   "16h,\n" +
                "2000mAh,\n";
        CPUandRamContruct = "2.2GHz,\n" +
                "4GB,\n";

        StorageContruct =   "MicroSD\n" +
                "support, 16GB,\n";

        CameraContruct =    "8Mp front,\n" +
                "5Mp rear,\n";
        CaseContruct =  "143x69x7.3 mm\n" +
                "waterproof,\nplastic,\n";


    }
}
