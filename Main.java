import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View bookings");
            System.out.println("4. Exit\n");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter room category (Single, Double, Suite): ");
                    String category = scanner.nextLine();
                    List<Room> availableRooms = hotel.searchRooms(category);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms in this category.");
                    } else {
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter number of nights: ");
                    int nights = scanner.nextInt();
                    Booking booking = hotel.makeReservation(guestName, roomNumber, nights);
                    if (booking != null) {
                        System.out.println("Reservation successful!");
                        System.out.println(booking);

                        System.out.print("Proceed to payment of $" + booking.getTotalCost() + "? (yes/no): ");
                        scanner.nextLine();  // Consume newline
                        String paymentConfirmation = scanner.nextLine();
                        if (paymentConfirmation.equalsIgnoreCase("yes")) {
                            boolean paymentSuccessful = Payment.processPayment(booking.getTotalCost());
                            if (paymentSuccessful) {
                                System.out.println("Payment successful!");
                            } else {
                                System.out.println("Payment failed.");
                            }
                        }
                    } else {
                        System.out.println("Room is not available.");
                    }
                    break;

                case 3:
                    hotel.viewBookings();
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
