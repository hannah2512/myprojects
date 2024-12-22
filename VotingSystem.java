import java.util.Scanner;

public class VotingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables to store votes for each party
        int bjpVotes = 0;
        int congressVotes = 0;
        int otherVotes = 0;

        System.out.println("Voting system of India");
        System.out.println("Parties:");
        System.out.println("1. BJP");
        System.out.println("2. Congress");
        System.out.println("3. Other Parties");

        while (true) {
            System.out.println("\nEnter the name of the state (type DONE to finish voting): ");
            String state = scanner.nextLine();

            // ends the program when DONE is the input 
            if ("DONE".equals(state)) {
                break;
            }

            System.out.println("choose a party of your choice " + state + ":");
            System.out.println("1. BJP");
            System.out.println("2. Congress");
            System.out.println("3. Other Parties");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                bjpVotes++;
                System.out.println("You voted for BJP in " + state + ".");
            } else if (choice == 2) {
                congressVotes++;
                System.out.println("You voted for Congress in " + state + ".");
            } else if (choice == 3) {
                otherVotes++;
                System.out.println("You voted for Other Parties in " + state + ".");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        // Displaying the results of the voting 
        System.out.println("\nVoting Results:");
        System.out.println("BJP Votes: " + bjpVotes);
        System.out.println("Congress Votes: " + congressVotes);
        System.out.println("Other Parties Votes: " + otherVotes);

        // checking which party has got maximum votes to win
        if (bjpVotes > congressVotes && bjpVotes > otherVotes) {
            System.out.println("BJP won ");
        } else if (congressVotes > bjpVotes && congressVotes > otherVotes) {
            System.out.println("congress won");
        } else if (otherVotes > bjpVotes && otherVotes > congressVotes) {
            System.out.println("other parties won");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}



 

