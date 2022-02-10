import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game{
    JFrame f;
    public static String name;
    JLabel author,icon,label;
    JTextField nick;
    JButton startButton, exitButton;
    public static Player player;
    public static int round=1;

    ////////////////////////////////////////////MAIN
    public static void main(String[] args) {
        new Game();
    }

    /////////Screen 1
    public Game()
    {
        f=new JFrame("Retro King");
        label=new JLabel("Enter your nickname:");
        label.setForeground(Color.WHITE);
        Font myFont = new Font("Serif", Font.BOLD, 30);
        label.setFont(myFont);
        label.setBounds(150,200,300,40);

        nick = new JTextField();
        nick.setFont(myFont);
        nick.setBounds(130,250,320,60);

        Font myFont2 = new Font("Serif",Font.BOLD,25);
        startButton= new JButton("Start");
        startButton.setFont(myFont2);
        startButton.setFocusable(false);
        startButton.setBounds(190,350,180,50);

        exitButton= new JButton("Exit");
        exitButton.setFont(myFont2);
        exitButton.setFocusable(false);
        exitButton.setBounds(190,430,180,50);

        author=new JLabel("Author: Oliwia Milewska");
        author.setForeground(Color.WHITE);
        author.setBounds(420,530,150,20);

        icon= new JLabel(new ImageIcon("title.png"));
        icon.setBounds(90,-40,400,300);

        player=new Player(name);

        ///////Exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        //////Start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nick.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select your nickname.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    name=nick.getText();
                    new Fight(16,10);
                    f.dispose();
                }
            }
        });

        ImageIcon image = new ImageIcon("icon.jpg");
        f.setIconImage(image.getImage());
        f.add(icon);
        f.add(author);
        f.add(label);
        f.add(nick);
        f.add(startButton);
        f.add(exitButton);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(new Color(0,65,137));
    }
}
