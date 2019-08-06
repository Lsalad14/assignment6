import java.util.Scanner;


public class Analyzer {
	public static final int DELAY_BETWEEN_REQUESTS = 1;
	public static final int NUMBER_OF_CYCLINDERS = 1024;
	public static final int SWEEP_TIME = 30;
	private Requests requests = new Requests();

	
	private void process(int numberOfRequests) {
		for (int index = 0; index < 2; index++) {
			RequestGenerator generator = new RequestGenerator(requests, numberOfRequests);
			Scheduler scheduler = AlgorithmFactory.instance().getScheduler(index, requests, numberOfRequests);
			generator.start();
			scheduler.start();
			try {
				generator.join();
				scheduler.join();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) {
		System.out.print("Enter number of requests: ");
		Scanner scanner = new Scanner(System.in);
		int numberOfRequests = scanner.nextInt();
		scanner.close();
		new Analyzer().process(numberOfRequests);
	}

}
