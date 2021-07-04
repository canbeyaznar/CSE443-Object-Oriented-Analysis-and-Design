/**
 * This is my GUI class
 * @author Can BEYAZNAR
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.concurrent.Flow;

public class myApp extends JFrame {
    private JPanel mainPanel;
    private JTextField file_path;
    private JButton button1;
    private JButton get_filepath_button;
    private JComboBox method_types;
    private JTextPane UserMatrixDisplay;

    private MethodTypes methods = new MethodTypes();
    private double[][] Input_2D;
    public myApp () {

        mainPanel.setPreferredSize(new Dimension(700,500));
        file_path.setSize(80,80);
        for(int i=0; i<methods.getsize(); i++)
            method_types.addItem(methods.getMethod_types_list()[i]);


        get_filepath_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file_path_input = file_path.getText();
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(
                            file_path_input));
                    String user_matrix_str = new String();
                    String line = reader.readLine();

                    while (line != null) {
                        user_matrix_str += line + "\n";
                        //System.out.println(line);

                        line = reader.readLine();
                    }
                    reader.close();

                    //System.out.println(user_matrix_str);
                    boolean control = string_to_doublearr(user_matrix_str);
                    if(control == false){
                        return;
                    }
                    else{
                        String set_string = new String("Your input : \n");
                        for(int i=0; i<Input_2D.length; i++){

                            for(int j=0; j<Input_2D[i].length; j++){
                                set_string += "[X" + i + j + "]: " +Input_2D[i][j]+ "   ";
                            }
                            set_string += "\n";
                        }
                        UserMatrixDisplay.setText(set_string);
                    }
                } catch (IOException x) {
                    app_print("Warning","ERROR: File could not be opened. Please make sure your file path." +
                            "\nThe file path must absolute\nexample: C:\\Users\\canbe\\IdeaProjects\\LinearSolverDeluxe_Proje\\src\\matrix_input" );
                    x.printStackTrace();
                }

                //Input_2D = new double[][];
            }
        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Input_2D == null){
                    app_print("Warning","ERROR: Please first define your matrix by entering your file." );
                    return;
                }else{
                    String method = (String) method_types.getSelectedItem();

                    // copy the user matrix
                    double[][] temp_matrix = new double[Input_2D.length][Input_2D[0].length];
                    for(int i =0; i<Input_2D.length; i++){
                        for(int j=0; j<Input_2D[i].length; j++){
                            temp_matrix[i][j] = Input_2D[i][j];
                        }
                    }
                    if(method == "Gaussian Elimination"){
                        FunctionBehavior functionBehavior = new GaussianElimination();
                        LinearSolverDeluxe x = new LinearSolverDeluxe(functionBehavior);
                        try {
                            x.calculate_equations(temp_matrix);
                            app_print("Result",x.toString() );
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                        //System.out.println(x.toString());
                    }
                    else if(method == "Matrix Inversion"){
                        FunctionBehavior functionBehavior = new MatrixInversion();
                        LinearSolverDeluxe x = new LinearSolverDeluxe(functionBehavior);

                        try {
                            x.calculate_equations(temp_matrix);
                            app_print("Result",x.toString() );
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                        //System.out.println(x.toString());
                    }
                    else{
                        app_print("Warning","UNEXPECTED ERROR: UNKNOWN METHOD TYPE" );
                    }

                }

            }
        });
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("myApp");
        frame.setContentPane(new myApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }


    public boolean string_to_doublearr(String input){

        // file control
        for(int i=0; i<input.length(); i++){
            if( !( (  (input.charAt(i) >= '0')  && (input.charAt(i) <= '9')   ) ||
                    (input.charAt(i) == ' ') || (input.charAt(i) == '\n') || (input.charAt(i) == '.')  ) ){
                System.out.println("Please make sure that your input file is correct format!!");
                app_print("Warning","Please make sure that your input file is correct format!!" );
                return false;
            }
        }
        // Input_2D initialize part
        // counting values for allocation
        String[] columns = input.split("\n");
        int columnsize = columns.length;
        int rowsize = 0;

        ArrayList<Double> values_arr = new ArrayList<Double>();

        for(int i = 0; i<columns.length; i++){
            String[] values = columns[i].split(" ");
            int valueCount = 0;

            for(int j = 0; j<values.length; j++){

                try{
                    double val = Double.parseDouble(values[j]);
                    valueCount += 1;
                    values_arr.add(val);
                    //System.out.println(values[j]);
                }catch(NumberFormatException e){
                    // it is empty space
                    // we will ignore it
                }
            }
            if(i == 0)
                rowsize = valueCount;
            else{
                if(valueCount != rowsize){
                    //System.out.println("Number of values must be same at each column!!");
                    app_print("Warning","Number of values must be same at each column!!" );
                    return false;
                }
            }

        }

        Input_2D = new double[columnsize][rowsize];
        int i,j,k=0;

        for(i=0; i<columnsize; i++){
            for(j=0; j<rowsize; j++){
                Input_2D[i][j] = values_arr.get(k);
                k += 1;
            }
        }
        return true;
    }

    public static void app_print(String title, String message){
        int error = JOptionPane.CLOSED_OPTION;
        if("Warning".equals(title))
            error = JOptionPane.ERROR_MESSAGE;
        else
            error = JOptionPane.CLOSED_OPTION;
        JOptionPane.showMessageDialog(new JFrame(),
                message,
                title,
                error);
    }

}
