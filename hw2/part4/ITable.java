/**
 * Our ITable interface for Proxy Design Pattern
 */
public interface ITable {
    public Object getElementAt(int row, int column);
    public void setElementAt(int row, int column, Object o);
    public int getNumberOfRows();
    public int getNumberOfColumns();
}
