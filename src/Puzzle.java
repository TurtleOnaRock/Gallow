import java.util.Scanner;

public class Puzzle {

    private String word;
    private char[] secret;

    public Puzzle (String word)
    {
        this.word = word;
        this.secret = new char[word.length()];
        for (int i = 0; i < secret.length; i++)
            this.secret[i] = Constants.MASK_SIGN;
    }

    public boolean includes(char c)
    {
        boolean result = false;
        for (int i = 0; i < this.secret.length; i++) {
            if (this.word.charAt(i) == c) {
                result = true;
                return result;
            }
        }
        return result;
    }

    public void update (char c)
    {
        for (int i = 0; i < this.secret.length; i++) {
            if (this.word.charAt(i) == c) {
                this.secret[i] = c;
            }
        }
    }

    public boolean isSecret()
    {
        for( int i = 0; i < this.secret.length; i++){
            if(this.secret[i] == '_')
                return true;
        }
        return false;
    }

    public String getWord()
    {
        return this.word;
    }

    public String getMask()
    {
        StringBuilder mask = new StringBuilder();
        for(int i = 0; i < this.secret.length; i++){
            mask.append(this.secret[i]);
        }
        return mask.toString();
    }
}
