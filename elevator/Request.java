package elevator;



// Request from user
class Request {
    private final int floor;
    private final Direction direction;

    Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    int getFloor() {
        return floor;
    }

    Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("floor=").append(floor);
        sb.append(", direction='").append(direction);

        return sb.toString();
    }
}
