/**
 * @author Can BEYAZNAR
 * 161044038
 *
 * GUI test class
 *
 */
public class Main {

    public static void main(String[] args) {
        ModelInterface modelInterface = new PersonModel(500);
        new PersonController(modelInterface);
    }
}
