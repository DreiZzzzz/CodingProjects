public class Room {
    private final String roomName;
    private double pricePerNight;
    private boolean[] dayStatus;


    public Room(String roomName) {
        this.roomName = roomName;
        pricePerNight = 1299.00;
        setDefaultStatus(31);
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean getDayStatus(int day) {
        return this.dayStatus[day];
    }

    public void setDefaultStatus(int numDays) {
        dayStatus = new boolean[numDays];
        for (int i = 0; i < dayStatus.length; i++) {
            dayStatus[i] = false;
        }
    }

    public void updateDayStatus(int checkInDay, int checkOutDay, boolean status) {
        for (int i = checkInDay - 1; i < checkOutDay -1; i++) {
            dayStatus[i] = status;
        }
    }

    public void roomDayStatus(int day) {
        if (dayStatus[day - 1]) {
            System.out.println("Day " + day + ": booked");
        } else {
            System.out.println("Day " + day + ": available");
        }
    }

    public void monthDayStatus() {
        for (int i = 1; i <= 31; i++) {
            roomDayStatus(i);
        }
    }

    public String getRoomName() {
        return this.roomName;
    }


}
