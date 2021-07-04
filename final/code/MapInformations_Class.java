/**
 * This is a class where general information is kept.
 * Here, the features of the map contain
 * the features that users will have (maximum speed, maximum social distance, etc.).
 * Thus, when there is a change, these features can be changed from a single point.
 * In the project, this class will be used only once and all persons will reference this class.
 */
public class MapInformations_Class {

    public int getMAP_HEIGHT() {
        return 600;
    }

    public int getMAP_WIDTH() {
        return 1000;
    }

    public int getMAX_C() {
        return 5;
    }

    public int getMAX_D() {
        return 9;
    }

    public int getMAX_SPEED() {
        return 500;
    }

}
