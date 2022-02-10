import javax.swing.*;
import java.awt.*;

public class Ending2 {
    JFrame f;
    JLabel background,castle,iconKnight,victory,statistics,frame;
    JLayeredPane panel;
    public Ending2(){

        f=new JFrame("Retro King");

        background= new JLabel(new ImageIcon("valley.jpg"));
        background.setBounds(0,0,600,600);
        f.add(background);

        castle= new JLabel(new ImageIcon("castle.png"));
        castle.setBounds(280,180,200,200);
        f.add(castle);

        iconKnight=new JLabel(new ImageIcon("knightSmall.png"));
        iconKnight.setBounds(370,420,50,50);
        f.add(iconKnight);

        victory=new JLabel(new ImageIcon("victory.gif"));
        victory.setBounds(50,10,500,200);
        f.add(victory);

        /*
        statistics=new JLabel(Game.player.toString());
        statistics.setBounds(30,100,200,500);
        statistics.setFont(new Font("Serif", Font.BOLD, 20));
        statistics.setForeground(Color.BLACK);
        f.add(statistics); */

        panel= new JLayeredPane();
        panel.setBounds(0,0,600,600);

        panel.add(background, Integer.valueOf(0));
        panel.add(castle, Integer.valueOf(1));
        panel.add(iconKnight, Integer.valueOf(2));
        f.add(panel);

        ImageIcon image = new ImageIcon("icon.jpg");
        f.setIconImage(image.getImage());
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(new Color(0,65,137));
    }
}
