import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        System.out.println("Welcome to the Railway Reservation System");

        while (true) {
            System.out.println("1. Check Available Trains");
            System.out.println("2. Check Seat Availability");
            System.out.println("3. Book a Ticket");
            System.out.println("4. Cancel a Ticket");
            System.out.println("5. Display Ticket Details");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter source station: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter destination station: ");
                    String destination = scanner.nextLine();
                    reservationSystem.displayAvailableTrains(source, destination);
                    break;
                case 2:
                    System.out.print("Enter the train number to check seat availability: ");
                    int trainNumberToCheck = scanner.nextInt();
                    int availableSeats = reservationSystem.checkSeatAvailability(trainNumberToCheck);
                    if (availableSeats != -1) {
                        System.out.println("Available seats for Train " + trainNumberToCheck + ": " + availableSeats);
                    } else {
                        System.out.println("Train not found. Please enter a valid train number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the train number to book a ticket: ");
                    int trainNumberToBook = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    reservationSystem.bookTicket(trainNumberToBook, passengerName);
                    break;
                case 4:
                    System.out.print("Enter the train number to cancel a ticket: ");
                    int trainNumberToCancel = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter passenger name: ");
                    String passengerNameToCancel = scanner.nextLine();
                    reservationSystem.cancelTicket(trainNumberToCancel, passengerNameToCancel);
                    break;
                case 5:
                    System.out.print("Enter the train number to display ticket details: ");
                    int trainNumberToDisplay = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter passenger name: ");
                    String passengerNameToDisplay = scanner.nextLine();
                    reservationSystem.displayTicketDetails(trainNumberToDisplay, passengerNameToDisplay);
                    break;
                // Add cases for other functionalities
                case 6:
                    System.out.println("Exiting. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
