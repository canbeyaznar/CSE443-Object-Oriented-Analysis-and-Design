/**
 * @author Can BEYAZNAR
 */
public class RocketLauncher extends WeaponsDecorator {
    ComponentClass component;

    public RocketLauncher(ComponentClass new_component){
        this.component = new_component;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", FlameThrower";
    }

    @Override
    public ItemClass cost() {
        return new ItemClass(150 + component.cost().getPrice(), 7.5 + component.cost().getWeight());
    }
}

