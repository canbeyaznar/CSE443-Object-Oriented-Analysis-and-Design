/**
 *
 * @author Can Beyaznar
 *
 * test class
 *
 * NOTE: Only the data in the first line will be read from the input file.
 * And the file must not contain characters.
 * Example: 0.672957 -0.453061 -0.835088 0.980334 0.972232 0.640295 0.7916199
 *
 */

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if(args.length != 0){
            String input = args[0];
            DiscreteTransformTemplate X = new DFT_WithHook();
            X.solve(input, "DFT_Output.txt");


            X = new DCT_WithHook();
            X.solve(input, "DCT_Output.txt");
        }
        else{
            System.out.println("Please enter your input file");
        }
    }

}
