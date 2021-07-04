/**
 * The ClockwiseIterator class takes the 2-dimensional array from the user and converts it into a spiral clockwise array.
 * And when you want to access it, it is used as an iterator.
 */

import java.util.ArrayList;

public class ClockwiseIterator implements myIterator {

    private ArrayList<Integer> arr_list;
    private int index;
    private int length;

    /**
     * Converts the user's input into a clockwise spiral array.
     * @param arr_2d user 2D array
     */
    public ClockwiseIterator(int[][] arr_2d){
        arr_list = new ArrayList<>();
        int row_size = arr_2d.length;
        int column_size = arr_2d[0].length;
        int cur_row =0, cur_col=0;
        int i;

        while(cur_row < row_size && cur_col < column_size){

            for(i = cur_col; i<column_size; i++){
                arr_list.add(arr_2d[cur_row][i]);
            }
            cur_row++;

            for(i=cur_row; i<row_size; i++){
                arr_list.add(arr_2d[i][column_size-1]);
            }
            column_size--;

            if(cur_row<row_size){
                for(i=column_size-1; i>= cur_col; i--){
                    arr_list.add(arr_2d[row_size-1][i]);
                }
                row_size--;
            }
            if(cur_col<column_size){
                for(i=row_size-1; i>= cur_row; i--){
                    arr_list.add(arr_2d[i][cur_col]);
                }
                cur_col++;
            }

        }
        index = 0;
        length = arr_list.size();
    }

    /**
     *
     * @return returns true if there is another element left
     */
    @Override
    public boolean hasNext() {
        if(index >= length)
            return false;
        return true;
    }

    /**
     *
     * @return returns next element
     */
    @Override
    public Object next() {
        int temp = arr_list.get(index);
        //System.out.println(temp);
        index++;
        return temp;
    }
}
