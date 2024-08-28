public class Room {
    private final String roomName;
    private double pricePerNight;


    public Room(String roomName) {
        this.roomName = roomName;
        pricePerNight = 1299.00;
    }


    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }


    public String getRoomName() {
        return this.roomName;
    }
}
