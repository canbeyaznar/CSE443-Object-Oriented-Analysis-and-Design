/**
 * TurboPayment class for using TurboPayment interface's methods
 */
public class TurboPaymentClass implements TurboPayment{
    /**
     * @param turboCardNo --
     * @param turboAmount --
     * @param destinationTurboOfCourse --
     * @param installmentsButInTurbo --
     * @return returns nothing just implemented to show that it works
     */
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        System.out.println("Paying with payInTurbo method (Location : TurboPaymentClass)");
        return 0;
    }
}
