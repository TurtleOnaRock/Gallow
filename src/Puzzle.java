import java.util.Scanner;

public class Puzzle {

    private String word;
    private char[] secret;

    public Puzzle (String word) {
        this.word = word;
        this.secret = new char[word.length()];
        for (int i = 0; i < secret.length; i++)
            this.secret[i] = '_';
    }

    public boolean includes(char c) {
        boolean result = false;
        for (int i = 0; i < this.secret.length; i++) {
            if (this.word.charAt(i) == c) {
                result = true;
                return result;
            }
        }
        return result;
    }

    public void update (char c){
        for (int i = 0; i < this.secret.length; i++) {
            if (this.word.charAt(i) == c) {
                this.secret[i] = c;
            }
        }
    }

    public void show () {
        System.out.print("Secret word: ");
        for(int i = 0; i < this.secret.length; i++)
            System.out.print(secret[i]);
        System.out.println();
    }

    public boolean isSecret() {
        for( int i = 0; i < this.secret.length; i++){
            if(this.secret[i] == '_')
                return true;
        }
        return false;
    }

    public String getWord(){
        return this.word;
    }

    public void showSecret(){
        System.out.println("The sercet word was " + word);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Puzzle puz = new Puzzle(in.nextLine());
        char symbol = '_';

        System.out.println("The secret word is : " + puz.getWord());

        while (puz.isSecret()){
            puz.show();
            System.out.print("Write a letter: ");
            symbol = in.next().charAt(0);
            System.out.printf("Your symbol is %c\n", symbol);
            System.out.println(puz.includes(symbol));
        }
        System.out.println("You win!!! and the secret word was ");
        puz.show();
    }
}
