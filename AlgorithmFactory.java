
public class AlgorithmFactory {
	private static AlgorithmFactory algorithmFactory;

	
	private AlgorithmFactory() {
	}

	
	public static AlgorithmFactory instance() {
		if (algorithmFactory == null) {
			algorithmFactory = new AlgorithmFactory();
		}
		return algorithmFactory;
	}


	public Scheduler getScheduler(int index, Requests requests, int numberOfRequests) {
		switch (index) {
		case 0:
			return new Look(requests, numberOfRequests);
		case 1:
			return new CLook(requests, numberOfRequests);
		//case 3:
			//return new FCFS(requests, numberOfRequests);
		//case 4:
			//return new SSTF(requests, numberOfRequests);
		}
		return null;
	}
}
