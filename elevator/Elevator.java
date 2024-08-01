package elevator;

import java.util.ArrayList;
import java.util.List;



class Elevator {
    private int id;
    private int next;
    private State state = State.STATIONARY;
    private List<Integer> destinations;

    public Elevator(int id, int next) {
        this.id = id;
        this.next = next;
        destinations = new ArrayList<>();
    }

    public Elevator(int id, int next, State state, List<Integer> destinations) {
        this.id = id;
        this.next = next;
        this.destinations = destinations;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;

    }

    public State getState() {
        return state;
    }

    List<Integer> getDestinations() {
        return destinations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("idx " + id + ", ");
        sb.append("dest " + destinations + ", ");
        sb.append("state " + state + ", ");
        sb.append("next " + next + "\n");

        return sb.toString();
    }

    public void acceptRequest(Request request) {
        // Accept the request and update the state
        this.destinations.add(request.getFloor());
        if (getState() == State.STATIONARY) {
            this.state = getDirection(request);
        }
    }

    private State getDirection(Request request) {
        if (request.getFloor() > next) {
            return State.UP;
        } else {
            return State.DOWN;
        }
    }

    // Is elevator same direction as request
    public boolean sameDirection(Request request) {
        boolean s1 = (this.state == State.UP && request.getDirection() == Direction.UP);
        boolean s2 = (this.state == State.DOWN && request.getDirection() == Direction.DOWN);

        return s1 || s2;
    }
}