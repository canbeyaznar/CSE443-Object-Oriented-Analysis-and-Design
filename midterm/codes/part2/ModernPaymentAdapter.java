/**
 * The ModernPaymentAdapter class was created to use the functions found in the TurboPayment interface.
 * Thus, functions can be called without making any changes to the TurboPayment interface.
 */
public class ModernPaymentAdapter implements TurboPayment {

    private ModernPaymentClass modernPaymentClass;

    /**
     *
     * @param _modernPaymentClass our modernPaymentClass parameter
     */
    public ModernPaymentAdapter(ModernPaymentClass _modernPaymentClass){
        this.modernPaymentClass = _modernPaymentClass;
    }

    /**
     * @param turboCardNo --
     * @param turboAmount --
     * @param destinationTurboOfCourse --
     * @param installmentsButInTurbo --
     * @return returns nothing just implemented to show that it works
     */
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        System.out.println("Converting turbo to modern payment with adapter class");
        System.out.println("Paying with payInTurbo method (Location: ModernPaymentAdapter)");
        modernPaymentClass.pay(turboCardNo, turboAmount, destinationTurboOfCourse,installmentsButInTurbo);
        return 0;
    }
}
