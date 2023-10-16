package GuessTheNumber;

import java.util.*;

public class GuessTheNumber {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Difficulty? Easy(E) Medium(M) Hard(H)");
        if(scan.next().charAt(0) == 'E'){
            CreateGuessTheNumber GTN10 = new CreateGuessTheNumber(10);
            GTN10.Start();
            GTN10.Play();
        }else if((scan.next().charAt(0) == 'M')){
        CreateGuessTheNumber GTN20 = new CreateGuessTheNumber(20);
        GTN20.Start();
        GTN20.Play();
        }else if((scan.next().charAt(0) == 'H')){
        CreateGuessTheNumber GTN30 = new CreateGuessTheNumber(30);
        GTN30.Start();
        GTN30.Play();
    }


        /*boolean PlayAgain = true;
        while (PlayAgain == true) {
            Character PlayAgainQuestion = 'Y';

            System.out.println("\n===============================\nWelcome to Guess The Number!\n===============================\n Enter your guess?");
            while (userguess != chosennum) {
                userguess = scan.nextInt();
                if (userguess < chosennum) System.out.println("Sorry Chief, that aint it, too low, try again");
                if (userguess > chosennum) System.out.println("Sorry Chief, that aint it, too high try again");
                if (userguess == chosennum) break;
            }
            wincount++;
            System.out.println("\n===============================\nYou guessed it chief, congratulations!");
            System.out.println("\n===============================\nWould You like to play again? (Y/N)");
            PlayAgainQuestion = scan.next().charAt(0);
            if(PlayAgainQuestion == 'N'){
                PlayAgain = false;
            }else if(PlayAgainQuestion == 'Y'){
                PlayAgain = true;
            }
            chosennum = rand.nextInt(11);
        }*/
    }
}
