package JAVA_Program.GuessTheNumber;

import java.util.Random;
import java.util.Scanner;

public class CreateGuessTheNumber {
    public int UserGuess;
    public int WinCount;
    private final int range;
    public int ChosenNum;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    public CreateGuessTheNumber(int x){
        range = x;
        UserGuess = 0;
        WinCount = 0;
        ChosenNum = rand.nextInt(x + 1);
    }
    public int getRange(){
        return this.range;
    }
    public void Start(){
            System.out.println("===============================\nWelcome to Guess The Number!\n===============================\nYour selected range is 1 to " + this.getRange());
    }

    public void Play(){
        boolean PlayAgain = true;
        while (PlayAgain == true) {
            Character PlayAgainQuestion;
            System.out.println("Enter your guess?");
            while (UserGuess != ChosenNum) {
                UserGuess = scan.nextInt();
                if (UserGuess < ChosenNum) System.out.println("Sorry Chief, that aint it, too low, try again");
                if (UserGuess > ChosenNum) System.out.println("Sorry Chief, that aint it, too high try again");
                if (UserGuess == ChosenNum) break;
            }
            WinCount++;
            System.out.println("\n===============================\nYou guessed it chief, congratulations!");
            System.out.println("\n===============================\nWould You like to play again? (Y/N)");
            PlayAgainQuestion = scan.next().charAt(0);
            if ((PlayAgainQuestion == 'N')||(PlayAgainQuestion =='n')) {
                PlayAgain = false;
            } else if ((PlayAgainQuestion == 'Y')||(PlayAgainQuestion == 'y')) {
                PlayAgain = true;
            }
                ChosenNum = rand.nextInt(getRange() + 1);
            }
        System.out.println("Thanks For Playing! You won: " + WinCount + " times!");
        }
    }

