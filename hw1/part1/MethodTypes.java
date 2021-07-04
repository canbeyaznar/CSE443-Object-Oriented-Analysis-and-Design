/**
 * This class' parameters will contain only constant strings
 * These strings are our function names, Gaussian elimination, matrix inversion...
 * If we want to add new method type we should add it to method_types_list
 * @author Can BEYAZNAR
 */
public class MethodTypes {

    private String[] method_types_list = {"Gaussian Elimination", "Matrix Inversion"} ;

    public MethodTypes(){
        /*Empty constructor*/
    }

    public String[] getMethod_types_list() {
        return method_types_list;
    }
    public int getsize(){
        return method_types_list.length;
    }
}
