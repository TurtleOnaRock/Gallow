import java.util.*;

public class Game {

    private final Puzzle puzzle;
    private final HangedMan man;
    private final Set<Character> usedLetters;

    public Game (String word){
        this.puzzle = new Puzzle(word);
        this.man = new HangedMan();
        this.usedLetters = new HashSet<>();
    }

    public void play()
    {
       char currentChar;

        while (puzzle.isSecret() && man.isAlive()) {

            System.out.println(Constants.SPACE);

            GallowRender.showMistakes(man.getStage());

            System.out.println(puzzle.getMask());

            GallowRender.showGallow(man.getStage());

            currentChar = this.getValidChar();

            this.usedLetters.add(currentChar);

            if (this.puzzle.includes(currentChar)) {
                this.puzzle.update(currentChar);
            } else {
                this.man.up();
            }
        }
        System.out.println(Constants.SPACE);
        System.out.println(Constants.OPEN_SECRET + this.puzzle.getWord());
        if (this.man.isAlive()) {
            System.out.println(Constants.WIN_MSG);
            GallowRender.showWin();
        } else {
            System.out.println(Constants.LOSE_MSG);
            GallowRender.showLose();
        }
    }

    private static boolean isNotRussian (char letter)
    {
        return  !( ((letter >= 'а') && (letter <= 'я')) || letter == 'ё');
    }

    private  boolean isUsed(char letter)
    {
        return this.usedLetters.contains(letter);
    }

    private char getValidChar()
    {
        CharFinder in = new CharFinder();
        char letter;
        do {
            System.out.print(Constants.WRITE_LETTER);

            letter = in.getChar();

            if (isNotRussian(letter)) {
                System.out.println(Constants.ALPHABET_ERROR);
            }

            if (isUsed(letter)) {
                System.out.println(Constants.DOUBLE_USED_LETTER);
            }

        } while (isNotRussian(letter) || isUsed(letter));
        return letter;
    }
}