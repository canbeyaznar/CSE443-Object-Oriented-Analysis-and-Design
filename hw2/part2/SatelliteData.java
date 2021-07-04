/**
 * This class takes the 2D array from the user and is used to convert it to an iterator.
 */
public class SatelliteData implements createiter {

    private int[][] arr_2d;

    /**
     *
     * @param user_2d user 2D array
     */
    public SatelliteData(int[][] user_2d){
        this.arr_2d = user_2d;
    }

    /**
     *
     * @return It returns the ClockwiseIterator class, which converts the array provided by the user into a spiral clockwise array.
     */
    @Override
    public myIterator createIterator() {
        return new ClockwiseIterator(this.arr_2d);
    }
}
