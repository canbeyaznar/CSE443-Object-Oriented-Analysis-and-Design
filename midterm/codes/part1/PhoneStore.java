/**
 * @author Can Beyaznar
 * our abstract class from which we will receive orders from the user
 */
public abstract class PhoneStore {

    /**
     *  this class prepares the phone for customer
     * @param type phone model
     * @return returns phone class that customer wants
     */
    public Phone orderPhone(String type){
        Phone phone;
        phone = createPhone(type);
        phone.MakePhone();
        System.out.println("Making a " + phone.getName() );
        return phone;
    }

    /**
     *
     * @param item phone model
     * @return returns phone class that customer wants
     */
    protected abstract Phone createPhone(String item);

}
