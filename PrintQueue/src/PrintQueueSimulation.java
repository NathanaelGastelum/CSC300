import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PrintQueueSimulation {
    private Queue<Job> waitQueue;
    private int totalWaitTime;
    private Queue<Job> finishedQueue;
    private int currentTime = 0;
    private Printer[] printer;
    private Random randy;
    private int numberOfPrinters;
    private int numberOfPrintJobs;


    public PrintQueueSimulation (int numberOfPrinters,int numberOfPrintJobs, int seed) {
        randy = new Random(seed);
        this.numberOfPrintJobs = numberOfPrintJobs;
        waitQueue = new PriorityQueue<>(numberOfPrintJobs);
        finishedQueue = new PriorityQueue<>(numberOfPrintJobs);
        this.numberOfPrinters = numberOfPrinters;
        printer = new Printer[numberOfPrinters];

        for(int i = 0; i < numberOfPrinters; i++)
            printer[i] = new Printer("Printer" +i);
    }

    public void simulate() {
        int jobTime, priority;
        int jobCount = 1;
        Job tempJob;
        boolean flagDone = false;

        while (!flagDone) {

            if(currentTime%100 == 0 && jobCount <= numberOfPrintJobs) {
                jobTime = randy.nextInt(991) +10;
                priority = randy.nextInt(10) + 1;
                tempJob = new Job(currentTime, jobTime, priority);
                waitQueue.add(tempJob);
                jobCount++;
            }

            for(int i = 0; i <numberOfPrinters; i++) {
                tempJob = printer[i].getPrintJob();
                if(tempJob != null) {
                    if((currentTime - tempJob.getStartTime()) == tempJob.getTimeForTheJob()) {
                        tempJob.setEndTime(currentTime);
                        finishedQueue.add(tempJob);
                        printer[i].setPrintJob(null);
                        printer[i].setStartIdleTime(currentTime);
                    }
                }
            }

            for(int i = 0; i< numberOfPrinters; i++) {
                if(printer[i].getPrintJob() == null) {
                    if(!waitQueue.isEmpty()) {
                        tempJob = waitQueue.remove();
                        tempJob.setStartTime(currentTime);
                        printer[i].setPrintJob(tempJob);
                        printer[i].setStartInUseTime(currentTime);
                        totalWaitTime = totalWaitTime + (currentTime - tempJob.getArrivalTime());
                    }
                }
            }
            currentTime++;

            if((jobCount > numberOfPrintJobs) & waitQueue.isEmpty()) {
                flagDone = true;
                for(int i = 0; i <numberOfPrinters; i++) {
                    if (printer[i].getPrintJob() != null) {
                        flagDone = false;
                        break;
                    }
                }
            }
        }
        displayStatistics();
    }

    public void displayStatistics() {
        System.out.printf("\nSimulation Results \nSimulation with %d printers lasted %d seconds processed %d jobs \n", numberOfPrinters, currentTime, numberOfPrintJobs);
        double averageTimeInQueue = (double) totalWaitTime / numberOfPrintJobs;
        System.out.printf("The average time in the wait queue for a job is %4.2f seconds\n", averageTimeInQueue);

        System.out.printf("\nPrinter Statistics \n%10s \t%-10s %-10s %-10s \n%10s \t%-10s %-10s %-10s", "", "Jobs", "Time", "Time", "Name", "Processed", "In Use", "Idle");
        for(int i = 0; i < numberOfPrinters; i++) {
            System.out.printf("\n%10s \t%-10s %-10s %-10s", printer[i].getPrinterName(), printer[i].getTotalJobsProcessed(), printer[i].getTotalInUseTime(), printer[i].getTotalIdleTime(currentTime));
        }

        Job tempJob;
        System.out.println("\n\nJob Statistics \nJob No. \tPriority \tWait Time \tLength Of Job");
        for(int i = 0; i < numberOfPrintJobs; i++) {
            tempJob = finishedQueue.remove();
            System.out.printf("%4d %9d %15d %15d \n", tempJob.getID(), tempJob.getPriority(),tempJob.getWaitTime(), tempJob.getTimeForTheJob());
        }
    }
}