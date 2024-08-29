import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    private String hotelName;
    private ArrayList<Room> hotelRooms;
    private ArrayList<Reservation> reservationList;

    public Hotel(String hotelName, int numRooms) {
        this.hotelName = hotelName;
        this.hotelRooms = new ArrayList<Room>(numRooms);
        this.reservationList = new ArrayList<Reservation>();
        initializeHotelRooms(numRooms);
    }

    public void initializeHotelRooms(int numRooms) {
        String temp = "A";

        for (int i = 1; i <= numRooms; i++) {
            hotelRooms.add(new Room(temp + i));
        }
    }

    public boolean addHotelRooms(int numRooms) {
        String temp = "A";
        int totalRooms = numRooms + this.hotelRooms.size();

        if (totalRooms <= 50) {
            for (int i = this.hotelRooms.size() + 1; i <= totalRooms; i++) {
                hotelRooms.add(new Room(temp + i));
            }
            return true ;
        }
        return false;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<Room> getHotelRooms() {
        return this.hotelRooms;
    }

    public void displayHotelRooms() {
        StringBuilder hotelRooms = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < this.hotelRooms.size(); i++) {
            if (counter == 10) {
                hotelRooms.append("\n");
                counter = 0; // reset
            }
            hotelRooms.append(this.hotelRooms.get(i).getRoomName());
            hotelRooms.append("\t\t");
            counter++;
        }
        System.out.println("CURRENT HOTEL ROOMS: " + this.hotelRooms.size());
        System.out.println(hotelRooms);
    }

    public double getTotalEarnings() {
        double totalEarnings = 0.00;

        for (int i = 0; i < reservationList.size(); i++) {
            totalEarnings += reservationList.get(i).getTotalPrice();
        }
        return totalEarnings;
    }

    public boolean isRoomValid(String roomName) {
        for (int i = 0; i < this.hotelRooms.size(); i++) {
            if (this.hotelRooms.get(i).getRoomName().equals(roomName)) {
                return true;
            }
        }
        return false;
    }

    public int getRoomIndex(String roomName) {
        for (int i = 0; i < this.hotelRooms.size(); i++) {
            if (this.hotelRooms.get(i).getRoomName().equals(roomName)) {
                return i; // return index where room is found
            }
        }
        return -1; // if room is not found
    }

    public void removeRoom(int roomIndex) {
        this.hotelRooms.remove(roomIndex);
    }
}
