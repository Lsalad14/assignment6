import java.util.Comparator;
import java.util.ListIterator;

/**
 * Implementation of the circular look algorithm
 * @author Dan Vail
 * */

public class CLook extends Scheduler {

	private Direction direction;

	private enum Direction {
		UP, DOWN
	};

	public CLook(Requests requests, int numberOfRequests) {
		super(requests, numberOfRequests);
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

		if (direction == Direction.UP) {
			tempRequests.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer integer1, Integer integer2) {
					return integer1.compareTo(integer2);
				}
			});
			Integer lastRequest = tempRequests.get(tempRequests.size() - 1);
			if (lastRequest.compareTo(currentPosition) >= 0) {
				ListIterator<Integer> iterator = tempRequests.listIterator();
				boolean finished = false;
				while (!finished) {
					Integer nextRequest = iterator.next();
					if (nextRequest.compareTo(currentPosition) >= 0) {
						iterator.remove();
						processed++;
						int distance = nextRequest - currentPosition;
						traveledDistance += distance;
						time += sleep(Math.abs(distance));
						currentPosition = nextRequest;
						finished = true;
					}
				}
			} else direction = Direction.DOWN;
		} else {
			tempRequests.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer integer1, Integer integer2) {
					return integer2.compareTo(integer1);
				}

			});
			Integer lastRequest = tempRequests.get(tempRequests.size() - 1);
			if (lastRequest.compareTo(currentPosition) >= 0) {
				ListIterator<Integer> iterator = tempRequests.listIterator();
				boolean finished = false;
				while (!finished) {
					Integer nextRequest = iterator.next();
					if (nextRequest.compareTo(currentPosition) >= 0) {
						iterator.remove();
						processed++;
						int distance = nextRequest - currentPosition;
						traveledDistance += distance;
						time += sleep(Math.abs(distance));
						currentPosition = nextRequest;
						finished = true;
					}
				}
			} else direction = Direction.UP;
		}

		// sort the requests in ascending order of cylinder numbers
		// if direction is up
		// process the smallest request greater than or
		// equal to the current head position
		// update statistics
		// if there is no such request change direction
		// otherwise,
		// process the largest request smaller than or
		// equal to the current head position
		// update statistics
		// if there is no such request change direction
	}

	@Override
	public String getAlgorithmName() {
		return "CLook";
	}
}