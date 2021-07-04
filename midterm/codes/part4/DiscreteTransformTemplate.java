/**
 * @author Can Beyaznar
 * It is an abstract class.
 * Since the methods used for DCT and DFT are the same, the template design pattern is used.
 * Common functions are implemented in our template class. Functions with different content (such as calculation) remain abstract.
 */
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DiscreteTransformTemplate {

    /**
     * The function the user should call. Since the operations to be done for DFT and DCT are the same here,
     * these operations are applied in a common method.
     * @param FileName user input file name
     * @param OutputFilename user output file name
     * @throws IOException throws exception if something went wrong (can not open file ).
     */
    public final void solve(String FileName, String OutputFilename) throws IOException {
        ArrayList<Double> input = readInputFromFile(FileName);
        ArrayList<Double> result = makeTransform(input);
        writeToFile(result, OutputFilename);
        if(userWants_Display_TimeofExecution()){
            Display_TimeofExecution();
        }
    }

    /**
     * NOTE: This metod will read only a single line from file
     *
     * @param FileName user input file name
     * @return Returns numbers read from the file in ArrayList form
     */
    private final ArrayList<Double> readInputFromFile(String FileName){
        ArrayList<Double> input_result = new ArrayList<Double>();
        try {
            RandomAccessFile file = new RandomAccessFile(FileName, "r");
            String str = file.readLine();
            if(str == null)
                return null;
            String[] x = str.split("\t+");

            for(int i=0; i<x.length; i++){
                input_result.add(Double.parseDouble(x[i]));
                //System.out.println(input_result.get(i));
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(input_result.size() == 0)
            return null;
        return input_result;
    }

    /**
     * Abstract function with DCT and DFT operations.
     * @param input user input that read from file
     * @return returns calculated DFT or DCT result
     */
    public abstract ArrayList<Double> makeTransform(ArrayList<Double> input);

    /**
     * Writes ArrayList elements to the output file.
     * These values are calculated in makeTransform method.
     * It is a common method as this function is the same for DCT and DFT.
     * @param input Calculated DFT or DCT result with ArrayList form
     * @param FileName Output file name that user gave us
     * @throws IOException throws exception if something wents wrong
     */
    private final void writeToFile(ArrayList<Double> input, String FileName) throws IOException {
        if(input == null){
            System.out.println("Input array is empty");
            return;
        }

        try {

            String output_str = "";
            FileWriter writer = new FileWriter(FileName);
            DecimalFormat df2 = new DecimalFormat("#.###");
            for (int i = 0; i < input.size(); i++){
                //System.out.println(input.get(i));
                output_str += df2.format(input.get(i)) + "\t";
            }
            writer.write(output_str);
            writer.close();
        }catch (IOException e){
            System.out.println("An error occured while writing output to the output file");
            e.printStackTrace();
        }
    }

    /**
     * Here, the time of execution value is empty because it is not shown as default.
     * It will only be called in the DFT class if the user wants it.
     */
    public void Display_TimeofExecution(){
        // Empty Method
    }
    /**
     * Here, the time of execution value is empty because it is not shown as default.
     * Therefore, the user was not asked if he/she wanted to see this value.
     * @return returns flase because only DFT class can show Time of execution value
     */
    public boolean userWants_Display_TimeofExecution(){
        return false;
    }

}
