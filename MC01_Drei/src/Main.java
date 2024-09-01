import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  To do:
 *  1. Fix hotel room
 */
public class Main {
    private static ArrayList<Hotel> hotelList = new ArrayList<>();

    public static void main(String[] args) {
        int userOption;
        Scanner scanner = new Scanner(System.in);

        displayHRS();
        do {
            while (true) {
                displayOptions();

                try {
                    System.out.print("Please enter an integer option: ");
                    userOption = scanner.nextInt();
                    if (userOption >= 1 && userOption <= 5) {
                        break; // Exit the loop if input is valid and within range
                    } else {
                        System.out.println("Option out of range. Please enter 1 - 5.");
                        printHyp();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    printHyp();
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }

            switch (userOption) {
                case 1:
                    printHyp();
                    System.out.println("!! [HOTEL CREATION] !!");
                    createHotel(scanner);
                    break;
                case 2:
                    printHyp();
                    System.out.println("!! [HOTEL VIEWING] !!");
                    viewHotel(scanner);
                    break;
                case 3:
                    printHyp();
                    System.out.println("!! [MANAGE HOTEL] !!\n");
                    manageHotel(scanner);
                    break;
                case 4:
                    printHyp();
                    System.out.println("!! [BOOKING SIMULATION] !!");
                    simulateBooking(scanner);
                    break;
                case 5:
                    printHyp();
                    System.out.println("!! [EXIT SUCCESS] !!"); // edit
                    printHyp();
                    break;
            }
        } while(userOption != 5);
    }

    public static void printHyp() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * displayHRS method that prints/display a 3D text of the String 'HOTEL RESERVATION'
     *
     */
    public static void displayHRS() {
        printHyp();
        System.out.println(" /$$   /$$  /$$$$$$  /$$$$$$$$ /$$$$$$$$ /$$             /$$$$$$$  /$$$$$$$$  /$$$$$$  /$$$$$$$$ /$$$$$$$  /$$    /$$  /$$$$$$  /$$$$$$$$ /$$$$$$  /$$$$$$  /$$   /$$      ");
        System.out.println("| $$  | $$ /$$__  $$|__  $$__/| $$_____/| $$            | $$__  $$| $$_____/ /$$__  $$| $$_____/| $$__  $$| $$   | $$ /$$__  $$|__  $$__/|_  $$_/ /$$__  $$| $$$ | $$      ");
        System.out.println("| $$  | $$| $$  \\ $$   | $$   | $$      | $$            | $$  \\ $$| $$      | $$  \\__/| $$      | $$  \\ $$| $$   | $$| $$  \\ $$   | $$     | $$  | $$  \\ $$| $$$$| $$      ");
        System.out.println("| $$$$$$$$| $$  | $$   | $$   | $$$$$   | $$            | $$$$$$$/| $$$$$   |  $$$$$$ | $$$$$   | $$$$$$$/|  $$ / $$/| $$$$$$$$   | $$     | $$  | $$  | $$| $$ $$ $$      ");
        System.out.println("| $$__  $$| $$  | $$   | $$   | $$__/   | $$            | $$__  $$| $$__/    \\____  $$| $$__/   | $$__  $$ \\  $$ $$/ | $$__  $$   | $$     | $$  | $$  | $$| $$  $$$$      ");
        System.out.println("| $$  | $$| $$  | $$   | $$   | $$      | $$            | $$  \\ $$| $$       /$$  \\ $$| $$      | $$  \\ $$  \\  $$$/  | $$  | $$   | $$     | $$  | $$  | $$| $$\\  $$$      ");
        System.out.println("| $$  | $$|  $$$$$$/   | $$   | $$$$$$$$| $$$$$$$$      | $$  | $$| $$$$$$$$|  $$$$$$/| $$$$$$$$| $$  | $$   \\  $/   | $$  | $$   | $$    /$$$$$$|  $$$$$$/| $$ \\  $$      ");
        System.out.println("|__/  |__/ \\______/    |__/   |________/|________/      |__/  |__/|________/ \\______/ |________/|__/  |__/    \\_/    |__/  |__/   |__/   |______/ \\______/ |__/  \\__/      ");
        printHyp();
    }

    /**
     * displayOptions method that displays the user options
     *
     */
    public static void displayOptions() {
        System.out.println("!! [MAIN MENU OPTIONS] !!\n");
        System.out.println("(1) CREATE HOTEL");
        System.out.println("(2) VIEW HOTEL");
        System.out.println("(3) MANAGE HOTEL");
        System.out.println("(4) SIMULATE BOOKING");
        System.out.println("(5) EXIT PROGRAM");
        printHyp();
    }

    /**
     * isHotelNameValid method that checks if a given hotel name input is already existing or not
     *
     * @param hotelName String that holds the hotel name
     * @return false if hotel name already exist, otherwise false
     */
    public static boolean isHotelNameValid(String hotelName) {
        for (int i = 0; i < hotelList.size(); i++) {
            if (hotelList.get(i).getHotelName().equals(hotelName)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     */
    public static void displayHotelList() {
        System.out.println("\n-- HOTEL LIST --");
        for (int i = 0; i < hotelList.size(); i++) {
            System.out.println(hotelList.get(i).getHotelName());
        }

    }

    public static int getHotelIndex(String hotelName) {
        for (int i = 0; i < hotelList.size(); i++) {
            if (hotelList.get(i).getHotelName().equals(hotelName)) {
                return i; // hotel index
            }
        }
        return -1;
    }

    public static void highLevelInfo(int hotelIndex) {
        System.out.println("Hotel Name: " + hotelList.get(hotelIndex).getHotelName());
        System.out.println("Total Rooms: " + hotelList.get(hotelIndex).getHotelRooms().size());
        System.out.println("Estimated Earnings: " + hotelList.get(hotelIndex).getTotalEarnings());
    }

    public static void createHotel(Scanner scanner) {
        String hotelName = "";
        int numRooms = 0;
        boolean isValid = false;
        boolean isNumValid = false;

        System.out.println();
        scanner.nextLine(); // buffer
        while (!isValid) {
            System.out.print("Enter hotel name: ");
            hotelName = scanner.nextLine();

            System.out.println(); // newline

            if (isHotelNameValid(hotelName)) {
                isValid = true;
            } else {
                System.out.println("Hotel name already exists. Please enter a different name.");
            }
            printHyp();
        }

        while (!isNumValid) {
            try {
                System.out.print("Enter number of rooms [1-50]: ");
                numRooms = scanner.nextInt();
                if (numRooms >= 1 && numRooms <= 50) {
                    isNumValid = true;
                } else {
                    System.out.println("Option out of range. Please enter 1 - 50.");
                    printHyp();
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                printHyp();
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        hotelList.add(new Hotel(hotelName, numRooms));
        System.out.println("!!SUCCESSFULLY CREATED [HOTEL " + hotelName + "] WITH " + numRooms + " ROOMS!!\n");
        displayHotelList();
        printHyp();
    }

    public static void viewHotel(Scanner scanner) {
        int viewOptions;
        int lowLevelOption;
        boolean isValid = false;
        String chosenHotel = "";

        if (!(hotelList.isEmpty())) {
            displayHotelList();
            scanner.nextLine(); // buffer

            while (!isValid) {
                System.out.print("Hotel to view: ");
                chosenHotel = scanner.nextLine();
                System.out.println(); // new line

                if (!(isHotelNameValid(chosenHotel))) {
                    isValid = true;
                } else {
                    System.out.println("Hotel does not exist.");
                }
            }

            while (true) {
                System.out.println("!! [VIEW HOTEL OPTIONS] !! ");
                System.out.println("(1) HIGH-LEVEL INFORMATION");
                System.out.println("(2) LOW-LEVEL INFORMATION");
                System.out.print("Please enter an integer option: ");

                try {
                    viewOptions = scanner.nextInt();
                    if (viewOptions >= 1 && viewOptions <= 2) {
                        break; // Exit the loop if input is valid and within range
                    } else {
                        System.out.println("Option out of range. Please enter 1 or 2.");
                        printHyp();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    printHyp();
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }

            if (viewOptions == 1) {
                highLevelInfo(getHotelIndex(chosenHotel));
            } else {
                while (true) {
                    System.out.println("LOW-LEVEL INFORMATION OPTIONS");
                    System.out.println("(1) ROOM AVAILABILITY FOR A SELECTED DATE");
                    System.out.println("(2) ROOM INFO AND AVAILABILITY FOR THE MONTH");
                    System.out.println("(3) RESERVATION INFORMATION");
                    try {
                        System.out.println("Please enter an integer option: ");
                        lowLevelOption = scanner.nextInt();
                        if (lowLevelOption >= 1 && lowLevelOption <= 3) {
                            break; // Exit the loop if input is valid and within range
                        } else {
                            System.out.println("Option out of range. Please enter 1 - 3.");
                            printHyp();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        printHyp();
                        scanner.next(); // Clear the invalid input from the scanner
                    }
                }

                /*
                switch(lowLevelOption) {
                    case 1:
                        break;
                }

                */

            }
        } else {
            System.out.println("WARNING: No Hotel(s) Found");
            printHyp();
        }
    }


    public static void manageHotel(Scanner scanner) {
        int manageOptions = 0;
        int hotelIndex = -1;
        int numRooms = 0;
        double newBasePrice = 0.0;
        boolean isValid = false;
        boolean isNameValid = false;
        boolean isRoomValid;
        String chosenHotel = "";
        String newHotelName = "";
        String roomName;
        String deleteHotel = "";


        if (!(hotelList.isEmpty())) {
            displayHotelList();
            scanner.nextLine(); // buffer

            while(!isValid) {
                System.out.print("\nHotel to manage: ");
                chosenHotel = scanner.nextLine();

                if (!(isHotelNameValid(chosenHotel))) {
                    hotelIndex = getHotelIndex(chosenHotel);
                    isValid = true;
                } else {
                    System.out.println("WARNING: Hotel Does Not Exist.");
                }
            }

            do {
                while (true) {
                    printHyp();
                    System.out.println("[MANAGING HOTEL " + chosenHotel + "]");
                    System.out.println("(1) Change Hotel Name");
                    System.out.println("(2) Add Hotel Room(s)");
                    System.out.println("(3) Remove Hotel Room");
                    System.out.println("(4) Update Base Price");
                    System.out.println("(5) Remove Reservation");
                    System.out.println("(6) Delete Hotel");
                    System.out.println("(7) Main Menu\n");
                    try {
                        System.out.print("Please enter an integer option: ");
                        manageOptions = scanner.nextInt();
                        System.out.println(); // new line
                        if (manageOptions >= 1 && manageOptions <= 7) {
                            break;
                        } else {
                            System.out.println("Option out of range. Please enter 1 - 7.");
                            printHyp();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        printHyp();
                        scanner.next(); // Clear the invalid input from the scanner
                    }
                }

                printHyp();
                switch (manageOptions) {
                    case 1:
                        System.out.println("-- CHANGING HOTEL NAME --\n");
                        scanner.nextLine(); // buffer
                        while (!isNameValid) {
                            System.out.print("New Hotel Name: ");
                            newHotelName = scanner.nextLine();
                            System.out.println();
                            if (isHotelNameValid(newHotelName)) {
                                System.out.println("PROMPT: Hotel Name Change Success!");
                                isNameValid = true;
                                chosenHotel = newHotelName;
                            } else {
                                System.out.println("WARNING: Hotel Name Already Exist!");
                            }
                        }
                        hotelList.get(hotelIndex).setHotelName(newHotelName);
                        break;
                    case 2:
                        if (hotelList.get(hotelIndex).getHotelRooms().size() < 50) {
                            System.out.println("-- ADDING HOTEL ROOM(S) --\n");

                            while (true) {
                                try {
                                    System.out.println("Current Hotel Rooms: " + hotelList.get(hotelIndex).getHotelRooms().size());
                                    System.out.print("Rooms To Add: ");
                                    numRooms = scanner.nextInt();
                                    System.out.println();
                                    if (numRooms >= 1 && numRooms + hotelList.get(hotelIndex).getHotelRooms().size() <= 50) {
                                        hotelList.get(hotelIndex).addHotelRooms(numRooms);
                                        System.out.println("PROMPT: Room Addition Success!");
                                        break; // Exit the loop if input is valid and within range
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid integer.");
                                    printHyp();
                                    scanner.next(); // Clear the invalid input from the scanner
                                }
                            }
                        } else {
                            System.out.println("WARNING: Already Reached Maximum Of 50 Rooms.");
                        }
                        break;
                    case 3:
                        System.out.println("-- REMOVING HOTEL ROOM --\n");
                        scanner.nextLine(); // buffer
                        hotelList.get(hotelIndex).displayHotelRooms(); // display list of hotel rooms
                        isRoomValid = false;
                        while (!(isRoomValid)) {
                            System.out.print("Enter room to delete: ");
                            roomName = scanner.nextLine();
                            if(hotelList.get(hotelIndex).isRoomValid(roomName)) {
                                hotelList.get(hotelIndex).removeRoom(hotelList.get(hotelIndex).getRoomIndex(roomName));
                                System.out.println("PROMPT: Room Removal Success!");
                                isRoomValid = true;
                            }
                            System.out.println(); // newline
                        }

                        System.out.println("\n[UPDATED LIST OF ROOMS]");
                        hotelList.get(hotelIndex).displayHotelRooms(); // display list of hotel rooms

                        break;
                    case 4: // check if base price updates
                        System.out.println("-- UPDATING BASE PRICE --\n");

                        while (true) {
                            try {
                                System.out.print("Enter new base price: ");
                                newBasePrice = scanner.nextDouble();
                                if (newBasePrice >= 100) {
                                    for (int i = 0; i < hotelList.get(hotelIndex).getHotelRooms().size(); i++) {
                                        hotelList.get(hotelIndex).getHotelRooms().get(i).setPricePerNight(newBasePrice);
                                    }
                                    System.out.println("PROMPT: Base Price Update Success!");
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a price >= 100.");
                                printHyp();
                                scanner.next(); // Clear the invalid input from the scanner
                            }
                        }
                        break;
                    case 5:
                        System.out.println("-- REMOVING RESERVATION --");
                        // display reservation list? optional
                        // name
                        // check-in date
                        // check-out date
                        break;
                    case 6:
                        System.out.println("-- DELETING HOTEL");

                        System.out.print("Delete Hotel [Y / N]: ");
                        scanner.nextLine(); // buffer
                        deleteHotel = scanner.nextLine();

                        if (deleteHotel.equals("Y") || deleteHotel.equals("y")) {
                            manageOptions = 7;
                            System.out.println("PROMPT: Hotel Deletion Success!");
                            hotelList.remove(hotelIndex);
                        } else if (deleteHotel.equals("N") || deleteHotel.equals("n")) {
                            System.out.println("PROMPT: Hotel Deletion Cancelled!");
                        } else {
                            System.out.println("WARNING: Invalid Input!");
                        }
                        printHyp();
                        break;
                }
            } while (manageOptions != 7);
        } else {
            System.out.println("WARNING: No Hotel(s) Found");
            printHyp();
        }
    }

    public static void simulateBooking(Scanner scanner) {
        String chosenHotel;
        String chosenRoom;
        String guestName; //
        int checkInDay; //
        int checkOutDay; //
        int hotelIndex;
        int roomIndex;
        int reservationIndex;

        boolean isHotelValid;

        // to use
        boolean isRoomValid;
        boolean isDateValid;
        boolean isInValid;
        boolean isOutValid;


        if (!(hotelList.isEmpty())) {
            displayHotelList();
            isHotelValid = false;
            hotelIndex = -1;

            while(!isHotelValid) {
                chosenHotel = "";
                System.out.print("\nHotel Choice: ");
                scanner.nextLine(); // buffer
                chosenHotel = scanner.nextLine();

                if (!(isHotelNameValid(chosenHotel))) {
                    hotelIndex = getHotelIndex(chosenHotel);
                    isHotelValid = true;
                } else {
                    System.out.println("WARNING: Hotel Does Not Exist.");
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }
            printHyp();

            System.out.println("Booking @Hotel " + hotelList.get(hotelIndex).getHotelName() + "\n");

            // display room
            hotelList.get(hotelIndex).displayHotelRooms();

            // for the room input - edit
            isRoomValid = false;
            roomIndex = -1;
            while(!isRoomValid) {
                try {
                    System.out.print("Selected Room: ");
                    chosenRoom = scanner.nextLine();
                    System.out.println(); // newline
                    if (hotelList.get(hotelIndex).isRoomValid(chosenRoom)) {
                        roomIndex = hotelList.get(hotelIndex).getRoomIndex(chosenRoom);
                        isRoomValid = true;
                    } else {
                        System.out.println("WARNING: Room Does Not Exist.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                }
                printHyp();
            }

            System.out.println("Guest Information");
            guestName = "";
            System.out.print("Guest name: ");
            guestName = scanner.nextLine();

            do {
                isDateValid = false;
                isInValid = false;
                checkInDay = -1;
                while (!isInValid) {
                    try {
                        System.out.print("Check-in day: ");
                        checkInDay = scanner.nextInt();
                        if (checkInDay >= 1 && checkInDay <= 30) {
                            isInValid = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a new day.");
                        printHyp();
                        scanner.next(); // Clear the invalid input from the scanner
                    }
                }

                isOutValid = false;
                checkOutDay = -1;
                while (!isOutValid) {
                    try {
                        System.out.print("\nCheck-out day: ");
                        checkOutDay = scanner.nextInt();
                        if (checkOutDay > checkInDay && checkOutDay <= 31) {
                            isOutValid = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a new day.");
                        printHyp();
                        scanner.next(); // Clear the invalid input from the scanner
                    }
                }

                reservationIndex = -1;
                if (hotelList.get(hotelIndex).isReservationValid(roomIndex, checkInDay, checkOutDay)) {
                    isDateValid = true;
                    Room roomInfo = hotelList.get(hotelIndex).getHotelRooms().get(roomIndex);

                    hotelList.get(hotelIndex).getHotelRooms().get(roomIndex).updateDayStatus(checkInDay, checkOutDay, true);
                    hotelList.get(hotelIndex).makeReservation(guestName, checkInDay, checkOutDay, roomInfo);

                    printHyp();
                    reservationIndex = hotelList.get(hotelIndex).getReservationIndex(guestName, checkInDay, checkOutDay);
                    hotelList.get(hotelIndex).getReservationList().get(reservationIndex).getReservationInfo();
                }

            } while(isDateValid != true);

        } else {
            System.out.println("WARNING: No Hotel(s) Found");
        }
        printHyp();
    }

}