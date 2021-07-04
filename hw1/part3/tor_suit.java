/**
 * @author Can BEYAZNAR
 */
public class tor_suit extends ComponentClass {

    public tor_suit(){
        description = "Tor Suit";
    }

    @Override
    public ItemClass cost() {
        return new ItemClass(5000, 50);
    }
}
