public class FlameThrower extends  WeaponsDecorator{

    ComponentClass component;

    public FlameThrower(ComponentClass new_component){
        this.component = new_component;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", FlameThrower";
    }

    @Override
    public ItemClass cost() {
        return new ItemClass(50 + component.cost().getPrice(), 2 + component.cost().getWeight());
    }
}
