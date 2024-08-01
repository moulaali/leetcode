package elevator;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        /*testStationary();
        testInMotionCloser();
        testInMotionSameCost();*/
        testInMotionOppositeDirection();
    }

    static void testInMotionOppositeDirection() {
        System.out.println("---- testInMotionOppositeDirection ----");
        List<Elevator> elevators = new ArrayList<>();
        elevators.add(new Elevator(0, 0));  // id and next params
        List<Integer> destinations = new ArrayList<>();
        destinations.add(0);
        elevators.add(new Elevator(1, 6, State.DOWN, destinations));
        elevators.add(new Elevator(2, 10));

        ElevatorController controller = new ElevatorController(elevators);

        // picks 2 even though it 3 floors farther and 1 is only 1 floor closer
        controller.handleRequest(new Request(7, Direction.UP));
    }

    static void testInMotionSameCost() {
        System.out.println("---- testInMotionSameCost ----");
        List<Elevator> elevators = new ArrayList<>();
        elevators.add(new Elevator(0, 0));  // id and next params
        List<Integer> destinations = new ArrayList<>();
        destinations.add(2);
        elevators.add(new Elevator(1, 7, State.DOWN, destinations));
        elevators.add(new Elevator(2, 3));

        ElevatorController controller = new ElevatorController(elevators);

        // Test case 3 : in motion. prefer the closer one on way even if the delta/cost is same
        controller.handleRequest(new Request(5, Direction.DOWN));  // picks 1, dest [2,5]
    }

    static void testStationary() {
        System.out.println("---- testStationary ----");
        List<Elevator> elevators = new ArrayList<>();
        elevators.add(new Elevator(0, 0));  // id and next params
        elevators.add(new Elevator(1, 7));
        elevators.add(new Elevator(2, 11));

        ElevatorController controller = new ElevatorController(elevators);

        // Test case 1 : stationary pick the closest one
        controller.handleRequest(new Request(6, Direction.UP));  // picks 1
        controller.handleRequest(new Request(2, Direction.UP));  // picks 0
    }

    static void testInMotionCloser() {
        System.out.println("---- testInMotion ----");
        List<Elevator> elevators = new ArrayList<>();
        elevators.add(new Elevator(0, 0));  // id and next params
        elevators.add(new Elevator(1, 7));
        elevators.add(new Elevator(2, 11));

        ElevatorController controller = new ElevatorController(elevators);

        // Test case 2 : in motion. prefer the closer one on way
        controller.handleRequest(new Request(5, Direction.UP));  // picks 1, destinations = [5]
        controller.handleRequest(new Request(6, Direction.UP));  // picks 1, destinations = [5, 6]
    }
}