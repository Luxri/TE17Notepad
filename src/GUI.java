import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUI {
    private JPanel titel;
    private JTextArea textArea1;
    private JButton openbutton;
    private JButton savebutton;
    private JButton helpbutton;
    String filename;


    public static void main(String[] args) {
        JFrame frame = new JFrame("TE17Notepad");
        frame.setContentPane(new GUI().titel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public GUI() {
        openbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                BufferedReader inFile = new BufferedReader(fr);

                try {
                    String line = "";
                    while ((line = inFile.readLine()) != null) {
                        textArea1.append(line + "\n");
                    }

                    inFile.close();


                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Filename = JOptionPane.showInputDialog(null, "Filename?");
                FileWriter fw = null;
                File newFile = new File(Filename);
                try {
                    fw = new FileWriter(Filename);

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter outfile = new PrintWriter(bw);


                        String line;
                        line = textArea1.getText();
                        outfile.println(line);
                        outfile.flush();
                        outfile.close();
                        JOptionPane.showMessageDialog(null, "File saved");
                    }
                });
        helpbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"You don't require help, trust me.");

            }
        });
    }
}
