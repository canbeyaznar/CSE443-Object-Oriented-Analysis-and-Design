import java.lang.reflect.Proxy;

/**
 * In this class, a test has been prepared for the option A of the 4th question.
 * A total of 6 threads are used, with 3 writer and 3 reader threads.
 * These are working synchronously. And they are waiting for each other.
 * To run the test, a sample array is created and the getElementAt () and setElementAt () methods are called.
 * The output of each running thread is written in detail.
 */
public class DriveClass {

    // All the threads will use this class parameter
    private static ITable driveProxy;

    // initialize unique inputs for threads
    private static int[] row_inputs = {0,1,2};
    private static int[] column_inputs = {0,1,2};
    private static int[] value_inputs = {99,98,97};

    // Reader threads and writer threads
    private static Thread[] thread_reader = new Thread[3];
    private static Thread[] thread_writer = new Thread[3];

    // our input array
    private static int[][] arr;

    public void Test(){

        // initialize the array
        arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println("Our array is: ");
        printArray(arr);

        ITable mytable = new DataBaseTable(arr);
        driveProxy = getReaderProxy(mytable);

        // initialize reader and writer threads
        thread_reader = new Thread[3];
        thread_writer = new Thread[3];

        int i;
        for(i=0; i<3; i++){

            thread_reader[i] = new Thread(DriveClass::getMethod_withThread);
            thread_writer[i] = new Thread(DriveClass::setMethod_withThread);
        }

        // Start all threads
        for(i=0; i<3; i++){
            thread_reader[i].start();
            thread_writer[i].start();
        }
    }

    /**
     * Call the getMethod_withThread() method for thread
     */
    private synchronized static void getMethod_withThread(){
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-getMethod_withThread()-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        int cur_thread_index = find_thread_index_in_threadarr(thread_reader, Thread.currentThread());
        System.out.println("(" + Thread.currentThread().getName() + ") getElementAt() row : "+row_inputs[cur_thread_index]+ " column : " + column_inputs[cur_thread_index]  );
        int value = (Integer) driveProxy.getElementAt(row_inputs[cur_thread_index],column_inputs[cur_thread_index]);
        System.out.println("(" + Thread.currentThread().getName() + ") The value is " + value);
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
    }

    /**
     * Call the setMethod_withThread() method for thread
     */
    private synchronized static void setMethod_withThread(){
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-setMethod_withThread()-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        int cur_thread_index = find_thread_index_in_threadarr(thread_writer, Thread.currentThread());
        driveProxy.setElementAt(row_inputs[cur_thread_index],column_inputs[cur_thread_index],  value_inputs[cur_thread_index]);
        System.out.println("(" + Thread.currentThread().getName() + ") Changed value in row "+row_inputs[cur_thread_index]+ " column " + column_inputs[cur_thread_index]);
        System.out.println("(" + Thread.currentThread().getName() + ") The current array after setElementAt() method");
        printArray(arr);
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
    }

    /**
     * Find which thread is running in given thread array
     * Compare with thread names
     * @param ThreadArr Thread array that we initialize (There should be reader or writer thread array)
     * @param thread Thread that we searched
     * @return return thread index found in ThreadArr
     */
    private synchronized static int find_thread_index_in_threadarr(Thread[] ThreadArr, Thread thread){
        for(int i =0; i<ThreadArr.length; i++){
            if(ThreadArr[i].getName().equals(thread.getName())){
                return i;
            }
        }
        return -1;
    }

    /**
     * Prints the given 2 Dimensional array
     * @param arr2d user 2-D array
     */
    private static void printArray(int[][] arr2d){
        for(int i=0; i<arr2d.length; i++){
            for(int j=0; j<arr2d[0].length; j++){
                System.out.print(arr2d[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param iTable our interface for proxy DP
     * @return return proxy instance
     */
    private ITable getReaderProxy(ITable iTable){
        return (ITable) Proxy.newProxyInstance(iTable.getClass().getClassLoader(), iTable.getClass().getInterfaces(),
                new ProxyClass_InvocationHandler(iTable));
    }
}
