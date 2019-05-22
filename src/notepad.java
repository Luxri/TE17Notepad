import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class notepad {
    public static void main (String[] args) {
        String filename = "exempel.txt";
        FileReader fr = null;
        try {
            fr = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader inFile = new BufferedReader(fr);
        String line;

        try {
            while ((line = inFile.readLine() ) != null ){
                System.out.println(line);
            }
            inFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
