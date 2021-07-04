/**
 * Auto Rifle class
 * @author Can BEYAZNAR
 */
public class AutoRifle extends WeaponsDecorator {
    ComponentClass component;

    public AutoRifle(ComponentClass new_component){
        this.component = new_component;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", FlameThrower";
    }

    @Override
    /**
     * sum with component price and weight
     */
    public ItemClass cost() {
        return new ItemClass(30 + component.cost().getPrice(), 1.5 + component.cost().getWeight());
    }
}
