/**
 * TurboPayment interface given in pdf
 */
public interface TurboPayment {
    int payInTurbo(String turboCardNo, float turboAmount,
                   String destinationTurboOfCourse, String installmentsButInTurbo);
}
