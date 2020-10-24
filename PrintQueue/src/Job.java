public class Job implements Comparable<Job> {

    private int arrivalTime;
    private int timeForTheJob;
    private int priority;

    private int ID;
    private static int jobCount = 0;

    private int startTime, waitTime, endTime;


    public Job(int arrivalTime, int timeForTheJob, int priority) {
        this.ID = jobCount++;
        this.arrivalTime = arrivalTime;
        this.timeForTheJob = timeForTheJob;
        this.priority = priority;
    }

    @Override
    public int compareTo(Job o) {
        return 0;
    }

    public int getID() {
        return ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTimeForTheJob() {
        return timeForTheJob;
    }

    public void setTimeForTheJob(int timeForTheJob) {
        this.timeForTheJob = timeForTheJob;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
        this.waitTime = getStartTime() - getArrivalTime();
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getWaitTime() {
        return waitTime;
    }
}