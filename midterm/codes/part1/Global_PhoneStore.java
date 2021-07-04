/**
 * @author Can BEYAZNAR
 * We will take phone orders that are included with this class of GLOBAL
 */
public class Global_PhoneStore extends PhoneStore{

    /**
     *
     * @param item phone model
     * @return returns phone that customer wants (for Global phone store)
     */
    @Override
    protected Phone createPhone(String item) {
        Phone phone = null;
        PhoneHardwareFactory phonefactory = new Global_HardwareFactory();

        if(item.equals("MaximumEffort")){
            phone = new PhoneModel_MaximumEffort(phonefactory);
            phone.setName("MaximumEffort");
        }
        else if(item.equals("IflasDeluxe")){
            phone = new PhoneModel_IflasDeluxe(phonefactory);
            phone.setName("IflasDeluxe");
        }
        else if(item.equals("I-I-Aman-Iflas")){
            phone = new PhoneModel_IIAmanIflas(phonefactory);
            phone.setName("I-I-Aman-Iflas");
        }
        return phone;
    }
}
