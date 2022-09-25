import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException{
        task1Method();
    }

    public static void task1Method() throws IOException {
        File file1 = new File(System.getProperty("user.dir") + File.separator + "File1.txt");
        file1.createNewFile();
        FileInputStream fileReader = new FileInputStream(file1);
        File file2 = new File(System.getProperty("user.dir") + File.separator + "File2.txt");
        FileWriter fileWriter = new FileWriter(file2);

        HashSet<Character> specials = new HashSet<>();
        specials.add(';'); specials.add(':'); specials.add('-');
        specials.add('.'); specials.add(','); specials.add('?');
        specials.add('!'); specials.add('('); specials.add(')');
        specials.add('['); specials.add(']');

        ArrayList<String> words = new ArrayList<>();
        String word = "";
        while (fileReader.read() != -1) {
            System.out.println((char) fileReader.read());
            if (!specials.contains((char) (fileReader.read()))) {
                word += (char) fileReader.read();
                if ((char) fileReader.read() == ' ') {
                    words.add(word);
                    word = "";
                }
            }
        }
        System.out.println(words);
    }
}