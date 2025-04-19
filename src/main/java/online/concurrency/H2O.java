package online.concurrency;

public class H2O {
    public H2O() {

    }

    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        h2O.oxygen(() -> System.out.println("O"));
        h2O.hydrogen(() -> System.out.println("H"));

    }
    Object l = new Object();
    int h = 0;
    int o = 0;
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (true) {
            synchronized (l){
                while (h > 2){
                    l.wait();
                }
                // releaseHydrogen.run() outputs "H". Do not change or remove this line.
                releaseHydrogen.run();
                h++;
                // finish the one
                if (h>=2 && o>=1) {
                    h = 0;
                    o = 0;
                }
                l.notifyAll();
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (true) {
            synchronized (l){
                while (o > 1){
                    l.wait();
                }
                // releaseOxygen.run() outputs "O". Do not change or remove this line.
                releaseOxygen.run();
                o++;
                // finish the one
                if (h>=2 && o>=1) {
                    h = 0;
                    o = 0;
                }
                l.notifyAll();
            }
        }

    }
}
