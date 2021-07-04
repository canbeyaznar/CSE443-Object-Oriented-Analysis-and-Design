/**
 * @author Can Beyaznar
 * Test class
 */
public class Main {

    public static void main(String[] args) {


        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("-o-o-o-o-o-Phone model test for Turkey-o-o-o-o-o-");
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");

        PhoneStore TRStore = new Turkey_PhoneStore();
        Phone phone_maximumeffort = TRStore.orderPhone("MaximumEffort");
        System.out.println(phone_maximumeffort.toString());

        TRStore = new Turkey_PhoneStore();
        Phone phone_IflasDeluxe = TRStore.orderPhone("IflasDeluxe");
        System.out.println(phone_IflasDeluxe.toString());

        TRStore = new Turkey_PhoneStore();
        Phone phone_AmanIflas = TRStore.orderPhone("I-I-Aman-Iflas");
        System.out.println(phone_AmanIflas.toString());

        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");

        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("-o-o-o-o-o-Phone model test for EU-o-o-o-o-o-");
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");

        PhoneStore EuStore = new EU_PhoneStore();
        phone_maximumeffort = EuStore.orderPhone("MaximumEffort");
        System.out.println(phone_maximumeffort.toString());

        EuStore = new EU_PhoneStore();
        phone_IflasDeluxe = EuStore.orderPhone("IflasDeluxe");
        System.out.println(phone_IflasDeluxe.toString());

        EuStore = new EU_PhoneStore();
        phone_AmanIflas = EuStore.orderPhone("I-I-Aman-Iflas");
        System.out.println(phone_AmanIflas.toString());

        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");

        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("-o-o-o-o-o-Phone model test for Global-o-o-o-o-o-");
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");

        PhoneStore GlobalStore = new Global_PhoneStore();
        phone_maximumeffort = GlobalStore.orderPhone("MaximumEffort");
        System.out.println(phone_maximumeffort.toString());

        GlobalStore = new Global_PhoneStore();
        phone_IflasDeluxe = GlobalStore.orderPhone("IflasDeluxe");
        System.out.println(phone_IflasDeluxe.toString());

        GlobalStore = new Global_PhoneStore();
        phone_AmanIflas = GlobalStore.orderPhone("I-I-Aman-Iflas");
        System.out.println(phone_AmanIflas.toString());

        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");

    }

}
