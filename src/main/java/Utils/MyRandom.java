package Utils;
import java.util.Random;

/**
 * Created by makovskiy on 21.11.2014.
 */
public class MyRandom {
    public static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
