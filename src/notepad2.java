import javax.swing.*;
import java.io.*;

public class notepad2 {
    public static void main(String[] args)  {
        // Öppna fil för läsning

                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                String filename;
                if (result == JFileChooser.APPROVE_OPTION) {
                    filename = fc.getSelectedFile().getAbsolutePath();
                } else {
                    filename = "exempel.txt";
                }

                FileReader fr = null;
        try {
            fr = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader inFile = new BufferedReader(fr);

        //Öppna fil för skrivning
        String filename2 = filename+"Copy";
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outFile = new PrintWriter(bw);

        // Läs in filen
        String line;
        try {
            while ((line = inFile.readLine() ) != null) {
                outFile.println(line);
            }
            inFile.close();
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}