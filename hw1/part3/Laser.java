/**
 * @author Can BEYAZNAR
 */
public class Laser extends WeaponsDecorator {

    ComponentClass component;

    public Laser(ComponentClass new_component){
        this.component = new_component;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", FlameThrower";
    }

    @Override
    public ItemClass cost() {
        return new ItemClass(200 + component.cost().getPrice(), 5.5 + component.cost().getWeight());
    }
}
