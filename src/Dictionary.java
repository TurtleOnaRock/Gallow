import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class Dictionary {

    private List<String> dictionary;
    private final Random numGenerator;
    private final int volume;

    public Dictionary(Path pathToDictionary)
    {
        try {
            this.dictionary = Files.readAllLines(pathToDictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.numGenerator = new Random(System.currentTimeMillis());
        this.volume = dictionary.size();
    }

    public String getWord()
    {
        return this.dictionary.get(this.numGenerator.nextInt(volume));
    }
}