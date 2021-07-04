/**
 * this is my component class
 * weights and costs of the items (weapons and suits) will be counted in this class
 * @author Can BEYAZNAR
 */
public abstract class ComponentClass {

    String description = "Unknown Component";

    public String getDescription() {
        return description;
    }

    public abstract ItemClass cost();

}
