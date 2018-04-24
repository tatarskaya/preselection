package task2_3.speedOf;

public class MeasureTime {
    private long start;
    private long finish;
    private long count;

    public void start() {
        this.start = System.nanoTime();
    }

    public void finish() {
        this.finish = System.nanoTime();
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getDuration() {
        return (finish - start)/count;
    }

}
