import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private ArrayList<Room> hotelRooms;
    private ArrayList<Reservation> reservationList;

    public Hotel(String hotelName, int numRooms) {
        this.hotelName = hotelName;
        this.hotelRooms = new ArrayList<Room>(numRooms);
        this.reservationList = new ArrayList<Reservation>();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<Room> getHotelRooms() {
        return hotelRooms;
    }

    public double getTotalEarnings() {
        double totalEarnings = 0.00;

        for (int i = 0; i < reservationList.size(); i++) {
            totalEarnings += reservationList.get(i).getTotalPrice();
        }

        return totalEarnings;
    }
}
