import java.util.Vector;

/**
 * Class for consuming the requests made by the producer
 * Programmer: Dan Vail (danielhvail@live.com)
 * Date: July 9th, 2019
 */
public class Consumer implements Runnable{

    private Requests requests;
    private int SLEEP_TIME;

    public Consumer(int sleepTime, Requests req) {
        requests = req;
        SLEEP_TIME = sleepTime;
    }

    public void run() {
		Vector<Integer> req = requests.get(true);
    	for(Integer integer : req) {
			System.out.println(integer.toString());
		}
    }

}
