/**
 * ModernPayment class for using ModernPayment interface's methods
 */
public class ModernPaymentClass implements ModernPayment{
    /**
     * @param cardNo --
     * @param amount --
     * @param destination --
     * @param installments --
     * @return returns nothing just implemented to show that it works
     */
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        System.out.println("Paying with pay method (Location: ModernPaymentClass)");
        return 0;
    }
}
