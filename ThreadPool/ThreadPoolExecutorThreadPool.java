import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorThreadPool {
    public static void main(String[] args) {
        int corePoolSize = 3;
        int maximumPoolSize = 6;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);
        
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);

        for (int i = 0; i < 6; ++i) {
            threadPoolExecutor.execute(new Task(i));
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {}
        System.out.println("Finished"); 
    }
}


