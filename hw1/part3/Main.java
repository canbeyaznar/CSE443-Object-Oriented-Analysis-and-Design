public class Main {

    public static void main(String[] args) {

        System.out.println("-o-o-o-o-o-o-o-o-o-o- Question 3 Test Case -o-o-o-o-o-o-o-o-o-o-");

        System.out.println("First Component");
        ComponentClass component = new dec_suit();
        System.out.println(component.getDescription() + ", " + component.cost().getPrice() + "k TL, " + component.cost().getWeight() +" Kg");
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");


        System.out.println("Second Component");
        ComponentClass component2 = new ora_suit();
        component2 = new FlameThrower(component2);
        component2 = new AutoRifle(component2);
        System.out.println(component2.getDescription() + ", " + component2.cost().getPrice() + "k TL, " + component2.cost().getWeight() +" Kg");
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");

        System.out.println("Third Component");
        ComponentClass component3 = new tor_suit();
        component3 = new FlameThrower(component3);
        component3 = new AutoRifle(component3);
        component3 = new AutoRifle(component3);
        component3 = new Laser(component3);
        component3 = new RocketLauncher(component3);
        System.out.println(component3.getDescription() + ", " + component3.cost().getPrice() + "k TL, " + component3.cost().getWeight() +" Kg");

        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
    }


}
