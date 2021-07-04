import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Discrete Fourier Transform class
 */
public class DFT_WithHook extends DiscreteTransformTemplate {

    private double timeOfExecution; // time of execution parameter that user wants
    public DFT_WithHook(){
        // empty constructor
    }

    /**
     *
     * @param input user input that read from file
     * @return returns DFT result with ArrayList form
     * https://en.wikipedia.org/wiki/Discrete_Fourier_transform
     */
    @Override
    public ArrayList<Double> makeTransform(ArrayList<Double> input) {

        long startTime = System.nanoTime();
        if(input == null){
            long endTime = System.nanoTime();
            this.timeOfExecution = (double) (endTime - startTime)/1000000  ; // milisecond
            return null;
        }

        ArrayList<Double> result = new ArrayList<>();
        int halfn = input.size()/2;

        ArrayList<Double> real_arr = new ArrayList<>();
        ArrayList<Double> imaginary_arr = new ArrayList<>();

        // parsing the input array as real and imaginary array
        int cur = 0;
        for(int i=0; i<halfn; i++){
            real_arr.add(input.get(2*i));
            imaginary_arr.add(input.get((2*i) + 1));
            cur += 1;
        }
        int n = real_arr.size();
        for (int i = 0; i < n; i++) {  // For each output element
            double real_sum = 0;
            double imaginary_sum = 0;
            for (int j = 0; j < n; j++) {  // For each input element
                double angle = (2 * Math.PI * i * j) / n;
                real_sum += (real_arr.get(j) * Math.cos(angle)) + (imaginary_arr.get(j) * Math.sin(angle));
                imaginary_sum += (real_arr.get(j) * Math.sin(angle) * (-1)) + (imaginary_arr.get(j) * Math.cos(angle));
            }
            result.add(real_sum);
            result.add(imaginary_sum);
        }

        long endTime = System.nanoTime();
        this.timeOfExecution = (double) (endTime - startTime)/1000000  ; // time of execution with milisecond type
        return result;

        /*
        int n = input.size();
        if(n % 2 != 0 || n == 0){
            System.out.println("Number of values in file must be even number for Discrete Fourier Transform");
            return null;
        }
        ArrayList<Double> result = new ArrayList<Double>();
        int half_n = (n/2);
        for(int i=0; i<half_n; i++ ){
            double real_num = 0;
            double imaginary_num = 0;
            for(int j=0; j<half_n; j++){
                double angle = 2 * Math.PI * j * i / half_n;
                real_num += input.get(j) * Math.cos(angle) + input.get(j + 1) * Math.sin(angle);
                imaginary_num += (input.get(j) * Math.sin(angle) * (-1)) + (input.get(j + 1) * Math.cos(angle));
            }
            result.add(real_num);
            result.add(imaginary_num);
        }


        long endTime = System.nanoTime();
        this.timeOfExecution = (double) (endTime - startTime)/1000000  ; // milisecond
        return result;*/
    }

    /**
     * method for printing time of execution
     */
    @Override
    public void Display_TimeofExecution() {
        System.out.println("Time of Execution : " + timeOfExecution + " ms");
    }

    /**
     * The user is asked if he wants to see the time of execution value.
     * @return return the request from the user in boolean type
     */
    @Override
    public boolean userWants_Display_TimeofExecution() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets user input for time of execution value.
     * @return user input with string form
     */
    private String getUserInput() {
        String userInput = null;
        System.out.print("Do you want to display time of execution? (y/n) ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            userInput = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }
        if (userInput == null) {
            return "no";
        }
        return userInput;
    }
}
