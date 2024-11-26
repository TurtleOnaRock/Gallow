import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class Dictionary {

    private List<String> dictionary;
    private final Random numGenerator;

    public Dictionary(Path dict, long seed) {
        try {
            this.dictionary = Files.readAllLines(dict);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.numGenerator = new Random(seed);
    }

    public String getWord(){
        return this.dictionary.get(this.numGenerator.nextInt(34011));
    }

}