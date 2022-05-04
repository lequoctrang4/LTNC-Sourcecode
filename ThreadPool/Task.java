public class Task implements Runnable {
    int id;
    
    Task (int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing task: " + id);
        taskMessage();
        System.out.println(Thread.currentThread().getName() + " terminated task: " + id);
    }

    private void taskMessage() {
        try {
            Thread.sleep(1000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

