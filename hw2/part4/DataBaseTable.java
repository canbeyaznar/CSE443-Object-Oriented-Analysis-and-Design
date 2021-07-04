/**
 * The class for database operations.
 * This class will be used indirectly.
 * We assume we only know method names.
 */
public class DataBaseTable implements ITable{

    private int[][] arr;

    public DataBaseTable(int[][] arr_2d){
        arr = arr_2d;
    }

    @Override
    public Object getElementAt(int row, int column) {
        return arr[row][column];
    }

    @Override
    public void setElementAt(int row, int column, Object o) {
        arr[row][column] = (Integer) o;
    }

    @Override
    public int getNumberOfRows() {
        return arr.length;
    }

    @Override
    public int getNumberOfColumns() {
        return arr[0].length;
    }
}
