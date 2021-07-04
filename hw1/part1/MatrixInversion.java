
/**
 * Matrix Inversion with using Gaussian Elimination
 *
 * @author Can Beyaznar
 */

public class MatrixInversion implements FunctionBehavior {

    private static final double EPSILON_VAL = 1e-10;
    private double[][] result;
    /**
     *
     * @param Input_2D user input
     */
    @Override
    public void calculate(double[][] Input_2D) {
        try{
            result = matrix_inversion(Input_2D);
            //System.out.println(this.toString());

        }catch (ArithmeticException e){
            myApp.app_print("Warning", "Something went wrong while calling matrix_inversion method!!");
            //System.out.println("Something went wrong while calling matrix_inversion method!!");
        }
    }

    /**
     *
     * @return the result array
     */
    @Override
    public String toString() {
        String return_result = "";

        return_result += "\n-------------- Matrix Inversion Result --------------\n";
        for(int i=0; i<result.length; i++){
            return_result += "| ";
            for(int j=0; j<result.length; j++){
                return_result += "X" + i + j + ": " + result[i][j] + " ";
            }
            return_result += "|\n";
        }
        return_result += "\n----------------------------------------------------------------------\n";
        return return_result;
    }

    /**
     *
     * @param Input_2D user input
     * @return the inverted 2D matrix
     */
    private double[][] matrix_inversion(double[][] Input_2D){

        // initializing parameters
        int row_size = Input_2D.length;
        double[][] X_matrix = new double[row_size][row_size];
        double[][] B_matrix = new double[row_size][row_size];
        int[] index_arr = new int[row_size];
        int i,j,k;


        for(i=0; i<row_size; i++){
            B_matrix[i][i] = 1; // initialize identity matrix
            index_arr [i] = i; // initialize index_arr for gaussian elimination
        }

        // Thanks to gaussian elimination, we dont have to
        // apply determinant and cofactor operation to matrix
        gaussian_elim(Input_2D, index_arr);

        // update the ratios after gaussian elimination
        for (i=0; i<row_size-1; i++) {
            for ( j=i+1; j<row_size; j++){
                for (k=0; k<row_size; k++){
                    B_matrix[index_arr[j]][k] -= Input_2D[index_arr[j]][i] * B_matrix[index_arr[i]][k];
                }
            }
        }

        // find result with using backward substitution
        for ( i=0; i<row_size; i++)
        {
            // if this equation is not solvable give an error message to screen
            if(Input_2D[index_arr[row_size-1]][row_size-1] == EPSILON_VAL ||
                    Input_2D[index_arr[row_size-1]][row_size-1] == 0.0 ||
                    "NaN".equals(""+ Input_2D[index_arr[row_size-1]][row_size-1]) ){
                    myApp.app_print("Warning", "This equation can not solvable with matrix inversion!");
                    throw new ArithmeticException("This equation can not solvable with matrix inversion!");
            }
            else{
                X_matrix[row_size-1][i] = B_matrix[index_arr[row_size-1]][i]/Input_2D[index_arr[row_size-1]][row_size-1];
            }

            for ( j=row_size-2; j>=0; j--)
            {
                X_matrix[j][i] = B_matrix[index_arr[j]][i];
                for (k=j+1; k<row_size; k++)
                {
                    X_matrix[j][i] -= Input_2D[index_arr[j]][k]*X_matrix[k][i];
                }
                X_matrix[j][i] /= Input_2D[index_arr[j]][j];
            }
        }
        return X_matrix;
    }

    /**
     * Gaussian elimination with partial pivoting
     * @param Input_2D user input
     * @param index_arr order of pivot values
     */
    private void gaussian_elim(double[][] Input_2D, int[] index_arr){
        int index_size = index_arr.length;
        double cur[] = new double[index_size];
        int i,j,k,temp=0;

        // Find factors
        for(i=0; i<index_size; i++){
            double x1 = 0;
            for(j=0; j<index_size; j++){
                double x0 = Math.abs(Input_2D[i][j]);
                if(x0 > x1) {
                    x1 = x0; // update new x1
                }
            }
            cur[i] = x1;
        }

        for(i=0; i<index_size-1; i++ ){
            double y1 = 0;
            for(j=i; j<index_size; j++){
                double y0 = Math.abs(Input_2D[index_arr[j]][i] );
                y0 = y0 / cur[index_arr[j]];
                if(y0 > y1){
                    y1 = y0;
                    temp = j;
                }
            }

            int temp_j = index_arr[i];
            index_arr[i] = index_arr[temp];
            index_arr[temp] = temp_j;
            for(j=i+1; j<index_size; j++){
                double dbl_tmp = Input_2D[index_arr[j]][i] / Input_2D[index_arr[i]][i];
                Input_2D[index_arr[j]][i] = dbl_tmp;
                for(k = i+1; k<index_size; k++){
                    Input_2D[index_arr[j]][k] -= dbl_tmp*Input_2D[index_arr[i]][k];
                }
            }

        }



    }


}
