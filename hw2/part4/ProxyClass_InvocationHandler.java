import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Proxy Class for proxy design pattern
 * This class will use ITable class and it should use the DataBaseTable class' methods
 */
public class ProxyClass_InvocationHandler implements InvocationHandler {

    private ITable iTable;

    /**
     * constructor method
     * @param proxy User proxy input
     */
    public ProxyClass_InvocationHandler(ITable proxy){
        this.iTable = proxy;
    }

    /**
     *
     * @param proxy proxy
     * @param method method that we call
     * @param args parameters
     * @return the result
     * @throws Throwable if user calls wrong method throw exception
     */
    @Override
    public synchronized Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().startsWith("get")) {
                System.out.println("getElementAt() method called by "+ Thread.currentThread().getName());
                Object x = method.invoke(this.iTable, args);
                return x;
            }
            else if(method.getName().startsWith("set")){
                System.out.println("setElementAt method called by " + Thread.currentThread().getName());
                return method.invoke(this.iTable, args);
            }

            else {
                throw new IllegalAccessException();
            }
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
