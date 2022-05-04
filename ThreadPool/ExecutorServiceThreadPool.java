import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 6; ++i) {
            Task task = new Task(i);
            pool.submit(task);
        }

        pool.shutdown();
        while (!pool.isTerminated()) {}
        System.out.println("Finished");
    }
}
