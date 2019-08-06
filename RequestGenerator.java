
public class RequestGenerator extends Thread {
	private Requests requests;
	private int numberOfRequests;

	
	public RequestGenerator(Requests requests, int maximumRequests) {
		this.requests = requests;
		this.numberOfRequests = maximumRequests;
	}


	/*public void run() {
		for (int index = 0; index < numberOfRequests; index++) {
			requests.add(Integer.valueOf(((int) (Math.random() * 10000)) % Analyzer.NUMBER_OF_CYCLINDERS));
			try {
				Thread.sleep(Integer.valueOf(((int) (Math.random() * 10000)) % Analyzer.DELAY_BETWEEN_REQUESTS));
			} catch (InterruptedException ie) {

			}
		}
	}*/
	
	
	public void run() {
		//The drive is currently serving a request at cylinder 2150
		
		requests.add(2069);
		requests.add(1212);
		requests.add(2296);
		requests.add(2800);
		requests.add(544);
		requests.add(1618);
		requests.add(356);
		requests.add(1523);
		requests.add(4965);
		requests.add(3681);
		
	}
	
	
	
	
	
	
}
