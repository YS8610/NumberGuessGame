import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args) {
        int lowerBound = 0;
        int upperBound = 100;
        Random random = new Random();
        int randNo = random.nextInt(upperBound)+lowerBound;
        
        System.out.println("Number Guessing Game");
        System.out.printf("Random number from %d - %d is picked!!\n",lowerBound+1,upperBound-1);
        System.out.println("Please pick a number...");

        Scanner scan = new Scanner(System.in);
        int playerGuess;

        while (true){
            try {
                playerGuess = Integer.parseInt(scan.next());
                if (playerGuess<lowerBound || playerGuess>upperBound){
                    System.out.println("Number given must be within " + lowerBound + " and " + upperBound);
                }
                else if (playerGuess==lowerBound || playerGuess==upperBound){
                    System.out.printf("Wrong input. Pls pick a number between %d and %d again\n",lowerBound,upperBound);
                }
                else if (playerGuess>randNo){
                    upperBound = playerGuess;
                    System.out.printf("Secret number is between %d and %d \n",lowerBound,upperBound);
                }
                else if(playerGuess<randNo){
                    lowerBound = playerGuess;
                    System.out.printf("Secret number is between %d and %d \n",lowerBound,upperBound);
                }
                else{
                    System.out.println("You have picked the secret number...");
                    scan.close();
                    break;
                }
            } 
            catch (IllegalArgumentException e) {
                System.out.printf("Only number are accepted. Pls pick a number between %d and %d again\n",lowerBound,upperBound);
            }
        }
    }
}
