import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Game {

    private static final String HELLO_MSG = "Hello my friend!";
    private static final String INTRODUCTION_QUESTION = "Would you like to play \"Gallow\"? Press Any bottom or write \"exit\" to quit.";
    private static final String LOSE_MSG = "\nYOU ARE LOSE!!!";
    private static final String WIN_MSG = "\nYOU ARE WIN!!!";
    private static final String WORD_SOURCE = "./russian-nouns.txt";
    private static final String ERROR_MSG_FILE = "There is no dictionary :(";
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String ALPHABET_ERROR = "Wrong letter was used! Check language or CAPS lock";
    private static final String DOUBLE_USED_LETTER = "This letter was used! Try the another one!";
    private static final String FORGOTTEN_LETTER = "You have forgotten write a letter";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Dictionary dict;

        // create dictionary based on path in WORD_SOURCE else quit the Game;
        Path ws = Paths.get(WORD_SOURCE);
        if(Files.exists(ws)) {
            dict = new Dictionary(ws, System.currentTimeMillis());
        }
        else {
            System.out.println(ERROR_MSG_FILE);
            return;
        }

        // Invitation into the Game;
        System.out.print(HELLO_MSG);

        // Game's loop;
        while(true) {
            // Play or leave?
            System.out.println(INTRODUCTION_QUESTION);

            String gate = in.nextLine();
            if(gate.equals("exit"))
                return;

            //take a word and make it as a secret
            Puzzle puzzle = new Puzzle(dict.getWord());

            //init/renew the Gallow
            Gallows.init();

            //init/renew the counterOfErrors
            Counter counterOfErrors = new Counter();

            //init/renew the alphabet
            char[] abc = ALPHABET.toCharArray();
            Set<Character> alphabet = new HashSet<>();
            for(int i = 0; i< abc.length; i++){
                alphabet.add(abc[i]);
            }

            //init/renew the set of used letter
            Set<Character> usedLetters = new HashSet<>();

            //make a link for a current letter
            Character currentChar = '!';

            while(puzzle.isSecret() && counterOfErrors.check()) {

                System.out.println();
                counterOfErrors.show();
                puzzle.show();
                Gallows.draw();

                // take a valid and first used letter
                do{
                    System.out.print("Write a letter: ");
                    try {
                        currentChar = in.nextLine().charAt(0);
                    } catch(Exception e) {
                        System.out.println(FORGOTTEN_LETTER);
                        continue;
                    }
                    if (!alphabet.contains(currentChar))
                        System.out.println(ALPHABET_ERROR);
                    if (usedLetters.contains(currentChar))
                        System.out.println(DOUBLE_USED_LETTER);
                }while (!alphabet.contains(currentChar) || usedLetters.contains(currentChar));

                usedLetters.add(currentChar);
                if (puzzle.includes(currentChar)) {
                    puzzle.update(currentChar);
                } else {
                    counterOfErrors.up();
                    Gallows.up();
                }
            }

            if (!counterOfErrors.check()) {
                System.out.println(LOSE_MSG);
                puzzle.showSecret();
                Gallows.drawLose();
            } else {
                System.out.println(WIN_MSG);
                puzzle.showSecret();
                Gallows.drawWin();
            }
        }
    }
}