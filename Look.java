import java.util.Comparator;
import java.util.ListIterator;


public class Look extends Scheduler {
	private Direction direction;

	private enum Direction {
		UP, DOWN
	};

	
	public Look(Requests requests, int numberOfRequests) {
		super(requests, numberOfRequests);
	}

	public void initialize() {
		currentPosition = 2150;
		direction = Direction.UP;
	}

	@Override
	public void processNextRequest() {

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
			} else {
				direction = Direction.DOWN;
			}
		} else {
			tempRequests.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer integer1, Integer integer2) {
					return integer2.compareTo(integer1);
				}

			});
			Integer lastRequest = tempRequests.get(tempRequests.size() - 1);
			if (lastRequest.compareTo(currentPosition) <= 0) {
				ListIterator<Integer> iterator = tempRequests.listIterator();
				boolean finished = false;
				while (!finished) {
					Integer nextRequest = iterator.next();
					if (nextRequest.compareTo(currentPosition) <= 0) {
						iterator.remove();
						processed++;
						int distance = currentPosition - nextRequest;
						traveledDistance += distance;
						time += sleep(Math.abs(distance));
						currentPosition = nextRequest;
						finished = true;
					}
				}
			} else {
				direction = Direction.UP;
			}
		}

	}

	@Override
	public String getAlgorithmName() {
		return "Look";
	}
}
