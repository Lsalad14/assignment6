import java.util.Random;

/**
 * Class made for producing requests
 * Programmer: Daniel Vail
 * Date: July 9th, 2019
 */
public class Producer implements Runnable{

    private final int DELAY_BETWEEN_REQUESTS;
    private Requests requests;

    public Producer(int delay, Requests req) {
        DELAY_BETWEEN_REQUESTS = delay;
        requests = req;
    }

    public void run() {
        try {
            Random rand = new Random();
            for (int i = 1; i <= 25; i++) {
                System.out.println("Request generated: " + i);
                requests.add(i);
                if (i % 2 == 0)
                    Thread.sleep(DELAY_BETWEEN_REQUESTS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}