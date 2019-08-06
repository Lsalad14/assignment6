import java.util.Comparator;
import java.util.ListIterator;
import java.util.Vector;

public class SSTF extends Scheduler {

	private Direction direction;

	/**
	 * Stores the Requests object and number of requests.
	 *
	 * @param requests
	 * @param numberOfRequests
	 */
	public SSTF(Requests requests, int numberOfRequests) {
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
		Vector<Integer> sortedVector = sort(tempRequests);
		ListIterator<Integer> iterator = tempRequests.listIterator();
		boolean finished = false;
		while(!finished) {
			Integer nextRequest = iterator.next();
			iterator.remove();
			processed++;
			int distance = nextRequest - currentPosition;
			traveledDistance += distance;
			time += sleep(Math.abs(distance));
			currentPosition = nextRequest;
			finished = true;
		}
	}

	public Vector<Integer> sort(Vector<Integer> v) {
		int lowest = -1;
		Vector<Integer> sortedVector = new Vector<>();
		sortedVector.add(v.get(1));
		ListIterator<Integer> iterator = v.listIterator();
		while (iterator.hasNext()) {
			int val1 = iterator.next();
			int distance = Integer.MAX_VALUE;
			for (int i : v) {
				int temp = Math.abs(i - val1);
				if (temp < distance) {
					distance = temp;
					lowest = i;
				}
			}
			if (lowest != -1)
				sortedVector.add(lowest);
		}
		return sortedVector;
	}

	@Override
	public String getAlgorithmName() {
		return "Shortest Seek Time First";
	}
}
