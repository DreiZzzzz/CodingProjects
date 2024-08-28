public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room roomInfo;
    private double totalPrice;
    private int numDays;

    public Reservation(String guestName, int checkInDate, int checkOutDate, Room roomInfo) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomInfo = roomInfo;
    }

    public double getTotalPrice() {
        numDays = checkOutDate - checkInDate;

        return numDays * roomInfo.getPricePerNight();
    }
}
