/**
 * @author Can BEYAZNAR
 */
public class ora_suit extends ComponentClass {
    public ora_suit(){
        description = "Ora Suit";
    }

    @Override
    public ItemClass cost() {

        return new ItemClass(1500, 30);
    }
}
