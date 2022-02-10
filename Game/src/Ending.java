import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ending {

    JFrame f;
    JPanel panel;
    JLabel question,introduction,icon,image;
    JButton ok,buttonA,buttonB,buttonC,buttonD;
    int number;

    public Ending()
    {
        f=new JFrame("Retro King");

        icon=new JLabel(new ImageIcon("ring.png"));
        icon.setBounds(210,-10,150,150);
        f.add(icon);

        introduction=new JLabel("<html>After fighting all the frightening creatures and defeating their King,<br> you have to answer final logic question to become The King of the Continent.</br><br> Are you ready?</br>");
        introduction.setFont(new Font("Serif", Font.BOLD, 30));
        introduction.setForeground(Color.WHITE);
        introduction.setBounds(90,90,450,400);
        f.add(introduction);

        ok=new JButton("Let's do this!");
        ok.setFont(new Font("Serif", Font.BOLD, 25));
        ok.setBounds(160,470,260,40);
        ok.setFocusable(false);
        f.add(ok);

        image=new JLabel(new ImageIcon("cards.PNG"));
        image.setBounds(140,200,300,90);
        image.setVisible(false);
        f.add(image);

        /// Buttons for answers
        buttonA=new JButton();
        buttonA.setFont(new Font("Serif", Font.BOLD, 25));
        buttonA.setBounds(30,400,110,40);
        buttonA.setFocusable(false);
        buttonA.setVisible(false);
        f.add(buttonA);

        buttonB=new JButton();
        buttonB.setFont(new Font("Serif", Font.BOLD, 25));
        buttonB.setBounds(170,400,110,40);
        buttonB.setFocusable(false);
        buttonB.setVisible(false);
        f.add(buttonB);

        buttonC=new JButton();
        buttonC.setFont(new Font("Serif", Font.BOLD, 25));
        buttonC.setBounds(310,400,110,40);
        buttonC.setFocusable(false);
        buttonC.setVisible(false);
        f.add(buttonC);

        buttonD=new JButton();
        buttonD.setFont(new Font("Serif", Font.BOLD, 25));
        buttonD.setBounds(450,400,110,40);
        buttonD.setFocusable(false);
        buttonD.setVisible(false);
        f.add(buttonD);

        panel=new JPanel();
        panel.setFont(new Font("Serif", Font.BOLD, 30));
        panel.setBorder(BorderFactory.createTitledBorder("<html><font color='white'>Final stage</font></html>"));
        panel.setBackground(new Color(0,65,137));
        panel.setBounds(30,20,540,300);
        panel.setVisible(false);
        f.add(panel);

        //number=(int)(Math.random()*(3));
        number=2;
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                icon.setVisible(false);
                introduction.setVisible(false);
                ok.setVisible(false);
                buttonA.setVisible(true);
                buttonB.setVisible(true);
                buttonC.setVisible(true);
                buttonD.setVisible(true);
                panel.setVisible(true);
                switch (number) {
                    case 0:
                        question=new JLabel("<html><font color='white'><br>There are three people(Alex, Cody, Brook)" +
                                ",one of whom is a knight, one a knave" +
                                "<br>and one a spy.Knight always tells the truth, the knave always lies and the spy can" +
                                "<br> either lie or tell the truth.</br>"+
                                "<br>Alex says: 'Cody is a knave'</br>"+
                                "<br>Cody says: 'Alex is a knight'</br>"+
                                "<br>Brook says: 'I am a spy'</br>"+
                                "<br>Who is the knight?</br>");
                        question.setFont(new Font("Serif", Font.BOLD, 15));
                        buttonA.setText("Alex");
                        buttonB.setText("Cody");
                        buttonC.setText("Brook");
                        buttonD.setText("No one");
                        break;
                    case 1:
                        question=new JLabel("<html><font color='white'><br>There were ten horse carriages on the market.<br>" +
                                "Customers bought all except one of them." +
                                "<br>How many horse carriages remain in the shop?");
                        question.setFont(new Font("Serif", Font.BOLD, 25));
                        buttonA.setText("1");
                        buttonB.setText("0");
                        buttonC.setText("10");
                        buttonD.setText("9");
                        break;
                    case 2:
                        question=new JLabel("<html><font color='white'><br>Some old man was thinking of one of the five cards that he is showing to you.<br>" +
                                " You have to find out which one is it." +
                                "Here are some clues:" +
                                "<br>1) The value of my card is a prime number." +
                                "<br>2) The values of my two neighbours add up to a multiple of 3</br>"+
                                "<br>3) My card is next to a card which is next to the 2 of hearts");
                        question.setFont(new Font("Serif", Font.BOLD, 16));
                        image.setVisible(true);
                        buttonA.setText("2H");
                        buttonB.setText("7C");
                        buttonC.setText("7D");
                        buttonD.setText("4H");
                        break;
                }
                question.setVisible(true);
                panel.add(question);
            }
        });

        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Ending2();
            }
        });
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You lost! Start the game again.", "Defeat", JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                new Game();
            }
        });
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You lost! Start the game again.", "Defeat", JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                new Game();
            }
        });
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You lost! Start the game again.", "Defeat", JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                new Game();
            }
        });

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
