/**
 * @author Can Beyaznar
 * Test class
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("pay test with modernPaymentClass");
        ModernPaymentClass modernPaymentClass = new ModernPaymentClass();
        modernPaymentClass.pay("545",100, "Isbank", "EFT");
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");

        System.out.println("payInTurbo test with turboPaymentClass");
        TurboPaymentClass turboPaymentClass = new TurboPaymentClass();
        turboPaymentClass.payInTurbo("700", 23, "AABANK", "EFT");
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");


        System.out.println("payInTurbo test with modernAdapter");
        TurboPayment modernAdapter = new ModernPaymentAdapter(modernPaymentClass);
        modernAdapter.payInTurbo("630 ",29,"Vakif","EFT");
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
    }
}
