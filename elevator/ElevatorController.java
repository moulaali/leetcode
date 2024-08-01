package elevator;

import java.util.*;

class ElevatorController {
    private List<Elevator> elevators;

    public ElevatorController(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public void handleRequest(Request request) {
        Elevator chosenElevator = pickBestElevator(request);
        chosenElevator.acceptRequest(request);
        System.out.println("New state of elevator " + chosenElevator);
    }

    private Elevator pickBestElevator(Request request) {
        Elevator picked = elevators.stream()
                .min((e1, e2) -> {
                    int cost1 = getCost(e1, request);
                    int cost2 = getCost(e2, request);
                    return Integer.compare(cost1, cost2);
                })
                .get();
        System.out.println("picked elevator : \n " + picked + " for request " + request);
        return picked;
    }

    private int getCost(Elevator elevator, Request request) {
        int currentFloor = elevator.getNext();
        State state = elevator.getState();

        // if stationary, cost is the delta
        if (state == State.STATIONARY) {
            return Math.abs(currentFloor - request.getFloor());
        }

        boolean onWayUp = (elevator.getState() == State.UP && currentFloor <= request.getFloor());
        boolean onWayDown = (elevator.getState() == State.DOWN && currentFloor >= request.getFloor());
        boolean isOnTheWay = (elevator.sameDirection(request) &&
                (onWayUp || onWayDown));

        if (isOnTheWay) {
            return Math.abs(currentFloor - request.getFloor()) - 1; // Prioritize on the way
        } else {
            return Math.abs(currentFloor - request.getFloor()) + 1; // Penalize not on the way
        }
    }
}
