/**
 * dec suit
 * @author Can BEYAZNAR
 */
public class dec_suit extends ComponentClass {

    public dec_suit(){
        description = "Dec Suit";
    }

    @Override
    public ItemClass cost() {
        return new ItemClass(500.0, 25);
    }
}
