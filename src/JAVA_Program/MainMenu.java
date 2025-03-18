package JAVA_Program;

import JAVA_Program.BlindMansBluff.BlindMansBluff;
import JAVA_Program.GuessTheNumber.GuessTheNumber;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        boolean isPlaying = true;
        Character Continue = 'Y';
        Scanner GameSelector = new Scanner(System.in);
        while (isPlaying == true) {
            if (Continue == 'N') {
                isPlaying = false;
            } else if (Continue == 'Y') {
                isPlaying = true;
            }
//        HANDLED INSIDE INDEX.HTML
//        System.out.println("==========================\nWelcome To The Game Show!" +
//                "\n==========================\n" +
//                "enter 0 To Exit\n" +
//                "enter 1 To Play \"Guess The Number\"\n" +
//                "enter 2 To Play \"Blind Man's Bluff\"");
        int GameSelect = GameSelector.nextInt();
            if(GameSelect == 0){
                System.out.println("Thanks For Playing! Code By: Rashidi Alleyne");
                System.exit(0);
            }
            if (GameSelect == 1) {
                GuessTheNumber GTN = new GuessTheNumber();
                GTN.main(args);
                System.out.println("Would You Like To Return To Menu? (Y/N)");
                Scanner Choice = new Scanner(System.in);
                Continue = Choice.next().charAt(0);
                if (Continue == 'N') {
                    isPlaying = false;
                } else if (Continue == 'Y') {
                    isPlaying = true;
                }
            }
                if (GameSelect == 2) {
                    BlindMansBluff CardGame = new BlindMansBluff();
                    CardGame.main(args);
                    System.out.println("Would You Like To Return To Menu? (Y/N)");
                    Scanner Choice = new Scanner(System.in);
                    Continue = Choice.next().charAt(0);
                    if (Continue == 'N') {
                        isPlaying = false;
                    } else if (Continue == 'Y') {
                        isPlaying = true;
                    }
                }
        }
    }
}








