import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonRedactor extends JFrame {
    private JPanel mainPanel;
    private JButton openButton;
    private JButton saveButton;
    private JEditorPane jsonPole;

    public JsonRedactor(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String soderjimoe = new String (Files.readAllBytes(Paths.get("fruit.json")));
                    jsonPole.setText(soderjimoe);
                } catch (IOException e1) {
                   System.out.println("Ошибка при открытии!");
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String izPolia = jsonPole.getText();
                    Writer writer = new FileWriter("fruit.json", false);
                    writer.write(izPolia);
                    writer.flush();


                } catch (IOException e1) {
                    System.out.println("Ошибка при сохранении!");
                }
            }
        });
    }
}
