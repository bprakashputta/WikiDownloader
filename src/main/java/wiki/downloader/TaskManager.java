package wiki.downloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskManager {

    private int threadCount;
    private ExecutorService executorService;

    public TaskManager(int threadCount){
        this.threadCount = threadCount;
        this.executorService = Executors.newFixedThreadPool(threadCount);
    }

    public void waitTillQueueIsFreeAndAddTask(Runnable runnable){
        while(getQueueSize() >= threadCount)
        {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        addTask(runnable);
    }

    private int getQueueSize(){
        ThreadPoolExecutor executor = (ThreadPoolExecutor)(executorService);
        return executor.getQueue().size();
    }

    private void addTask(Runnable runnable){
        this.executorService.submit(runnable);
    }

    //To test the taskManager
    //public static void main(String[] args) {
    //    TaskManager taskManager = new TaskManager(10);
    //    for(int i=0;i<10;i++)
    //    {
    //        WikiDownloader wikiDownloader = new WikiDownloader();
    //        taskManager.waitTillQueueIsFreeAndAddTask(wikiDownloader);
    //    }
    //}
}
