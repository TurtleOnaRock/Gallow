import java.util.Scanner;

public class CharFinder {

    private  Scanner in;

    public CharFinder()
    {
        this.in = new Scanner(System.in);
    }

    public char getChar()
    {
        while(true) {
            String line = this.in.nextLine();
            if (line.length() == 1) {
                return line.charAt(0);
            } else {
                System.out.print(Constants.ONE_LETTER_REQUEST);
            }
        }
    }

}
