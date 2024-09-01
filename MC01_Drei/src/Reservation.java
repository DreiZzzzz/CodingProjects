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

    public String getGuestName() {
        return this.guestName;
    }

    public int getCheckInDate() {
        return this.checkInDate;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalPrice() {
        numDays = checkOutDate - checkInDate;

        return numDays * roomInfo.getPricePerNight();
    }

    public void getReservationInfo() {
        System.out.println("Guest name: " + this.guestName);
        System.out.println("Room: " + this.roomInfo.getRoomName());
        System.out.println("Check-In Day: " + this.checkInDate);
        System.out.println("Check-Out Day: " + this.checkOutDate);
        System.out.println("Price Per Night: " + this.roomInfo.getPricePerNight());
        System.out.println("Total Price: " + this.getTotalPrice());
    }
}
