public class Printer {

    private String printerName;
    private Job printJob;
    private int startIdleTime, startInUseTime, totalIdleTime, totalInUseTime, totalJobsProcessed;

    public Printer(String printerName) {
        this.printerName = printerName;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public Job getPrintJob() {
        return printJob;
    }

    public void setPrintJob(Job printJob) {
        this.printJob = printJob;
    }

    public void setStartInUseTime(int startInUseTime) {
        this.startInUseTime = startInUseTime;
        totalJobsProcessed++;
    }

    public void setStartIdleTime(int startIdleTime) {
        this.startIdleTime = startIdleTime;
        totalInUseTime += (startIdleTime - startInUseTime);
    }

    public int getTotalIdleTime(int currentTime) {
        return currentTime - totalInUseTime;
    }

    public int getTotalInUseTime() {
        return totalInUseTime;
    }

    public int getTotalJobsProcessed() {
        return totalJobsProcessed;
    }
}