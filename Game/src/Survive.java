import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Survive {
    JFrame f;
    JLabel trophy,label;
    JButton nextGame,exit;

    public Survive()
    {
        f=new JFrame("Retro King");

        trophy= new JLabel(new ImageIcon("trophy.png"));
        trophy.setBounds(135,150,300,300);
        f.add(trophy);

        label=new JLabel("<html>You survived <font color='orange'>"+Game.round+"</font> rounds!</html>");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setBounds(90,70,450,90);
        f.add(label);

        //Starting a new game
        nextGame=new JButton("Start a new game");
        nextGame.setBounds(90,490,200,40);
        nextGame.setFont(new Font("Serif", Font.BOLD, 20));
        nextGame.setFocusable(false);
        f.add(nextGame);
        nextGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Game();
            }
        });

        //Closing button
        exit=new JButton("Exit");
        exit.setBounds(310,490,200,40);
        exit.setFont(new Font("Serif", Font.BOLD, 20));
        exit.setFocusable(false);
        f.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        //Frame options
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
