import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Launcher {

        public static void main(String[] args)
        {
            Dictionary dictionary = null;

            while (playOrLeave()) {
                if (dictionary == null) {
                    dictionary = getDictionary(Constants.PATH_TO_DICTIONARY);
                    if (dictionary == null){
                        System.out.println(Constants.NO_DICTIONARY);
                        return;
                    }
                }
                Game game = new Game(dictionary.getWord());
                game.play();
            }
        }

        private static boolean playOrLeave()
        {
            CharFinder in = new CharFinder();
            char answer;

            do {
                System.out.print(Constants.INTRODUCTION_QUESTION);
                answer = in.getChar();
            } while (answer != 'д' && answer != 'н');

            return (answer == 'д');
        }

        private static Dictionary getDictionary(String pathToFile)
        {
            Dictionary dictionary;
            Path wordSource = Paths.get(pathToFile);
            if (Files.exists(wordSource)) {
                dictionary = new Dictionary(wordSource);
            } else {
                System.out.println(Constants.ERROR_FILE);
                return null;
            }
            return dictionary;
        }
}
