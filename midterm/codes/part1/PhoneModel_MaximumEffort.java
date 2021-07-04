/**
 * Phone model class for Maximum Effort
 */
public class PhoneModel_MaximumEffort extends  Phone{

    private PhoneHardwareFactory phoneHardwareFactory;

    public PhoneModel_MaximumEffort(PhoneHardwareFactory _phoneHardwareFactory){
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
        
        DisplayContruct =   "5.5 inches,\n";

        BatteryContruct =   "27h,\n" +
                            "3600mAh\n";
        CPUandRamContruct = "2.8GHz,\n" +
                            "8GB,\n";

        StorageContruct =   "MicroSD support,\n" +
                            "64GB,\n";

        CameraContruct =    "12Mp front,\n" +
                            "8Mp rear,";

        CaseContruct =  "151x73x7.7 mm,\n" +
                        "dustproof,\n" +
                        "waterproof,\n" +
                        "aluminum,\n";
    }


}
