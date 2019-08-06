import java.util.ListIterator;

public class FCFS extends Scheduler {

	private Direction direction;

	/**
	 * Stores the Requests object and number of requests.
	 *
	 * @param requests
	 * @param numberOfRequests
	 */
	public FCFS(Requests requests, int numberOfRequests) {
		super(requests, numberOfRequests);
	}

	private enum Direction {
		UP, DOWN
	}

	@Override
	public void initialize() {
		currentPosition = 0;
		direction = Direction.UP;
	}

	@Override
	public void processNextRequest() {
		int traveledDistance = 0;
		int time = 0;
		Integer lastRequest = tempRequests.get(tempRequests.size() -1);
		ListIterator<Integer> iterator = tempRequests.listIterator();
		boolean finished = false;
		while (!finished) {
			Integer nextRequest = iterator.next();
			direction = lastRequest.compareTo(currentPosition) <= 0 ? Direction.DOWN : Direction.UP;
			processed++;
			int distance = Math.abs(nextRequest - currentPosition);
			traveledDistance += distance;
			time += sleep(Math.abs(distance));
			currentPosition = nextRequest;
			finished = true;
		}
	}

	@Override
	public String getAlgorithmName() {
		return "First Come First Serve";
	}
}
