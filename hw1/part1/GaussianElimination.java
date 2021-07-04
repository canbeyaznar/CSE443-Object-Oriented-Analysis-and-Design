/**
 * Gaussian Elimination class
 * @author Can BEYAZNAR
 */
public class GaussianElimination implements FunctionBehavior {

    private static final double EPSILON_VAL = 1e-10;
    private double[] result;
    /**
     *
     * @param Input_2D this is our user input
     * @throws Exception for error handling
     */
    @Override
    public void calculate(double[][] Input_2D) throws Exception {

        // for example 2x -3y+z = 6
        // x y and z are left side; 6 is a right side of array

        int leftSide_size = Input_2D[0].length - 1; // size of equations
        int rightSide_size = Input_2D.length;       // size of equations' result

        try{
            result = gaussian_elimination(Input_2D,leftSide_size,rightSide_size);
            //System.out.println(this.toString());
        }catch (ArithmeticException e){
            //System.out.println("Something went wrong while calling matrix_inversion method!!");
            myApp.app_print("Warning", "Something went wrong while calling matrix_inversion method!!");
        }

    }

    @Override
    public String toString() {
        String return_result = "";
        return_result += "\n-------------- Gaussian Elimination Result --------------\n";
        for(int i=0; i<result.length; i++){
            return_result += "| " + "X" + i + ": " + result[i];
            return_result += "|\n";
        }
        return_result += "\n----------------------------------------------------------------------\n";
        return return_result;
    }

    /**
     * This function will make gaussian elimination with using partial pivoting algorithm
     * @param Input_2D user input
     * @param equationSize row size
     * @param resultSize result column size
     * @return 1 dimensional result matrix which comes from back_substitution method
     * @throws Exception
     */
    private double[] gaussian_elimination(double[][] Input_2D, int equationSize, int resultSize ) throws Exception{
        partial_pivot(Input_2D, equationSize, resultSize);
        return (back_substitution(Input_2D, equationSize, resultSize));
    }

    /**
     *
     * @param Input_2D user input
     * @param equationSize row size
     * @param resultSize result column size
     * @throws Exception
     */
    private void partial_pivot(double[][] Input_2D, int equationSize, int resultSize ) throws Exception{
        int pivot = 0;
        // find pivot
        while(pivot < resultSize){
            int temp_max = pivot;
            int cur = pivot + 1;
            while(cur < resultSize){
                if( Math.abs(Input_2D[temp_max][pivot]) < Math.abs(Input_2D[cur][pivot]) ){
                    temp_max = cur;
                }
                cur += 1;
            }
            // swap matrix rows
            swap_row(Input_2D, pivot, temp_max);

            if(Math.abs(Input_2D[pivot][pivot]) <= EPSILON_VAL){
                myApp.app_print("Warning", "This equation can not solvable with gaussian elimination!");
                return;
            }
            else{
                cur = pivot + 1;
                while(cur < resultSize){
                    double temp = Input_2D[cur][pivot] / Input_2D[pivot][pivot];
                    // changing result part of matrix (rightside)
                    Input_2D[cur][equationSize] -= temp * Input_2D[pivot][equationSize];
                    int secondCur = pivot;
                    while(secondCur < resultSize){
                        Input_2D[cur][secondCur] -= temp * Input_2D[pivot][secondCur];
                        secondCur += 1;
                    }
                    cur += 1;
                }
            }
            pivot += 1;
        }
    }

    /**
     * get last result
     * @param Input_2D user input
     * @param equationSize row size
     * @param resultSize result column size
     * @return last result
     */
    private double[] back_substitution(double[][] Input_2D, int equationSize, int resultSize){
        double[] result = new double[resultSize];
        int i=resultSize-1, j;
        double each_total;
        //find each columns' result
        while(i >= 0){
            each_total = 0.0;
            j = i + 1;
            while(j < resultSize){
                each_total += Input_2D[i][j] * result[j];
                j += 1;
            }
            result[i] = (Input_2D[i][resultSize] - each_total) / Input_2D[i][i];
            i -= 1;
        }
        //for(i=0; i<result.length; i++)
            //System.out.println(result[i]);
        return result;
    }


    /**
     * Swapping row values of 2D matrix
     * @param Input_2D our input matrix
     * @param x1 first row
     * @param x2 second row
     */
    private void swap_row(double[][] Input_2D, int x1, int x2 ){
        double[] temp = Input_2D[x1];
        Input_2D[x1] = Input_2D[x2];
        Input_2D[x2] = temp;
    }
}
