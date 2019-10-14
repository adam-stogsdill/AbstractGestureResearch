import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;


public class Main {
    static FileWriter fileWriter;
    static BufferedWriter out;

    public static void print(String str) throws IOException{
        out.write(str);
        out.newLine();
    }

    public static final String[] ITEMS_ARRAY =
            {"Word"};
    public static ArrayList<JButton> buttons = new ArrayList<JButton>();


    public static void main(String[] args){
        FlowLayout flowLayout = new FlowLayout();
        try {
            fileWriter = new FileWriter(new File("AnnotationTimeStamps.txt"), true);
            out = new BufferedWriter(fileWriter);
        }catch(IOException f){
            f.printStackTrace();
        }
        JFrame j = new JFrame();
        for(int i = 0; i < ITEMS_ARRAY.length; i++) {
            JButton jb = new JButton(ITEMS_ARRAY[i]);

            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        Main.print(String.valueOf(LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":"
                                + LocalTime.now().getSecond() + " " + jb.getText()));
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }
            });
            buttons.add(jb);
            j.add(jb);

        }
        JButton close = new JButton("CLOSE");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    out.flush();
                }catch(IOException n){
                    n.printStackTrace();
                }
                System.exit(0);
            }
        });
        j.add(close);
        j.setSize(500,500);
        j.setLayout(flowLayout);
        j.setVisible(true);

    }
}
