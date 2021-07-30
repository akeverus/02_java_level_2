import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class SortFile {

    static String fileName = "random_string.txt";

    public static void main(String[] args) {
        getFileWithRandomString(10000000, 10);
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.sorted().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileWithRandomString (int rows, int length) {
        try (PrintWriter writer = new PrintWriter(fileName, "UTF-8")) {
            for (int i = 0; i < rows; i++) {
                writer.println(getRandomString(length));
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static String getRandomString(int length){

        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random random = new Random();
        StringBuilder subString = new StringBuilder();

        for(int i = 0; i < length; i++){
            int number = random.nextInt(str.length());
            subString.append(str.charAt(number));
        }
        return subString.toString();
    }
}
