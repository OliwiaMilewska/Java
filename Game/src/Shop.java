import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shop {

    JFrame f;
    JLabel label,label2,money,iconSword,iconBow,iconSpear,swordPrice,bowPrice,
            spearPrice, iconHeart,iconHealthPotion,iconHealth,heartPrice,
            healthPotionPrice,helathPrice,label3,iconStrength,label4,
            StrengthPrice, description, hearts,heartsIcon;
    JButton heartButton,healthPotionButton,healthButton,nextButton,StrengthButton;
    public static JButton swordButton,bowButton,spearButton;
    JPanel panel;
    public static int swordCount=0, bowCount=0,spearCount=0;

    public Shop()
    {
        f=new JFrame("Retro King");

        label=new JLabel();
        label.setText("Sword & Shield");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Serif", Font.BOLD, 50));
        label.setBounds(120,20,400,60);
        f.add(label);
        label2=new JLabel();
        label2.setText("Shop");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Serif", Font.BOLD, 20));
        label2.setBounds(270,60,400,60);
        f.add(label2);

        money=new JLabel();
        money.setText("Your money: "+Game.player.money+"$");
        money.setForeground(Color.WHITE);
        money.setFont(new Font("Serif", Font.BOLD, 25));
        money.setBounds(30,115,400,40);
        f.add(money);

        //Hearts
        hearts=new JLabel("Your hearts: ");
        hearts.setBounds(280,115,400,40);
        hearts.setForeground(Color.WHITE);
        hearts.setFont(new Font("Serif", Font.BOLD, 25));
        f.add(hearts);

        if (Game.player.hearts==3) heartsIcon= new JLabel(new ImageIcon("heart3.png"));
        else if (Game.player.hearts==2) heartsIcon= new JLabel(new ImageIcon("heart2.png"));
        else heartsIcon= new JLabel(new ImageIcon("heart1.png"));
        heartsIcon.setBounds(420,115,150,50);
        f.add(heartsIcon);

        //box
        description=new JLabel("<html><font color='white'>Drag your mouse to the picture to see the description</font></html>");
        description.setFont(new Font("Serif", Font.BOLD, 15));
        panel=new JPanel();
        panel.setFont(new Font("Serif", Font.BOLD, 30));
        panel.setBorder(BorderFactory.createTitledBorder("<html><font color='white'>Description</font></html>"));
        panel.setBackground(new Color(0,65,137));
        panel.setBounds(30,540,540,100);
        f.add(panel);
        panel.add(description);

        /////////Sword
        iconSword=new JLabel(new ImageIcon("sword.png"));
        iconSword.setBounds(80,180,60,60);
        f.add(iconSword);

        swordPrice=new JLabel();
        swordPrice.setText("300$");
        swordPrice.setForeground(Color.WHITE);
        swordPrice.setFont(new Font("Serif", Font.BOLD, 20));
        swordPrice.setBounds(80,250,60,20);
        f.add(swordPrice);

        swordButton=new JButton("buy");
        swordButton.setBounds(150,210,70,30);
        swordButton.setFont(new Font("Serif", Font.BOLD, 12));
        swordButton.setFocusable(false);
        if (swordCount==1) swordButton.setEnabled(false);
        f.add(swordButton);

        swordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.player.money-=300;
                if(Game.player.money>=0)
                {
                    money.setText("Your money: "+Game.player.money+"$");
                    swordButton.setEnabled(false);
                    Game.player.weapon="Sword";
                    Game.player.strength+=7;
                    swordCount++;
                }
                else
                {
                    Game.player.money+=300;
                    JOptionPane.showMessageDialog(null, "Unfortunately, You don't have enough money to buy a sword.", "Win", JOptionPane.INFORMATION_MESSAGE);
                    money.setText("Your money: "+Game.player.money+"$");
                }
            }
        });

        iconSword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                description.setText("<html><font color='white'>Sword is a weapon with a long blade for cutting or thrusting that is often used as<br>" +
                        " a symbol of honor or authority.<br>This one is called 'Arthur' and will give you +7 to your attack.</font></html>");
                panel.add(description);
            }
        });
        iconSword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                description.setText(" ");
                panel.add(description);
            }
        });

        /////////Bow
        iconBow=new JLabel(new ImageIcon("bow.png"));
        iconBow.setBounds(250,180,60,60);
        f.add(iconBow);

        bowPrice=new JLabel();
        bowPrice.setText("380$");
        bowPrice.setForeground(Color.WHITE);
        bowPrice.setFont(new Font("Serif", Font.BOLD, 20));
        bowPrice.setBounds(250,250,60,20);
        f.add(bowPrice);

        bowButton=new JButton("buy");
        bowButton.setBounds(320,210,70,30);
        bowButton.setFont(new Font("Serif", Font.BOLD, 12));
        bowButton.setFocusable(false);
        if (bowCount==1) bowButton.setEnabled(false);
        f.add(bowButton);

        bowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.player.money-=380;
                if(Game.player.money>=0)
                {
                    money.setText("Your money: "+Game.player.money+"$");
                    bowButton.setEnabled(false);
                    Game.player.weapon="Bow";
                    Game.player.strength+=8;
                    bowCount++;
                }
                else
                {
                    Game.player.money+=380;
                    JOptionPane.showMessageDialog(null, "Unfortunately, You don't have enough money to buy a bow.", "Win", JOptionPane.INFORMATION_MESSAGE);
                    money.setText("Your money: "+Game.player.money+"$");
                }
            }
        });

        iconBow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                description.setText("<html><font color='white'>Bow is used to propel an arrow and that is made of a strip of<br>" +
                        "flexible material with a cord connecting the two ends and holding the strip bent.<br>Bow is giving you +8 to your attack.</font></html>");
                panel.add(description);
            }
        });
        iconBow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                description.setText(" ");
                panel.add(description);
            }
        });

        /////////Spear
        iconSpear=new JLabel(new ImageIcon("spear.png"));
        iconSpear.setBounds(420,180,60,60);
        f.add(iconSpear);

        spearPrice=new JLabel();
        spearPrice.setText("450$");
        spearPrice.setForeground(Color.WHITE);
        spearPrice.setFont(new Font("Serif", Font.BOLD, 20));
        spearPrice.setBounds(420,250,60,20);
        f.add(spearPrice);

        spearButton=new JButton("buy");
        spearButton.setBounds(490,210,70,30);
        spearButton.setFont(new Font("Serif", Font.BOLD, 12));
        spearButton.setFocusable(false);
        if (Game.player.weapon=="Spear") spearButton.setEnabled(false);
        f.add(spearButton);

        spearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.player.money-=450;
                if(Game.player.money>=0)
                {
                    money.setText("Your money: "+Game.player.money+"$");
                    spearButton.setEnabled(false);
                    Game.player.weapon="Spear";
                    Game.player.strength+=9;
                    spearCount++;
                }
                else
                {
                    Game.player.money+=450;
                    JOptionPane.showMessageDialog(null, "Unfortunately, You don't have enough money.", "Win", JOptionPane.INFORMATION_MESSAGE);
                    money.setText("Your money: "+Game.player.money+"$");
                }
            }
        });

        iconSpear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                description.setText("<html><font color='white'>Spear is a thrusting or throwing weapon with long shaft and sharp head or blade.<br>" +
                        "Spear is giving you +9 to your attack.</font></html>");
                panel.add(description);
            }
        });
        iconSpear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                description.setText(" ");
                panel.add(description);
            }
        });

        /////////Heart
        iconHeart=new JLabel(new ImageIcon("heart.png"));
        iconHeart.setBounds(70,320,60,60);
        f.add(iconHeart);

        heartPrice=new JLabel();
        heartPrice.setText("600$");
        heartPrice.setForeground(Color.WHITE);
        heartPrice.setFont(new Font("Serif", Font.BOLD, 20));
        heartPrice.setBounds(80,390,60,20);
        f.add(heartPrice);

        heartButton=new JButton("buy");
        heartButton.setBounds(170,350,70,30);
        heartButton.setFont(new Font("Serif", Font.BOLD, 12));
        heartButton.setFocusable(false);
        f.add(heartButton);

        heartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.player.money-=500;
                if(Game.player.money>=0)
                {
                    money.setText("Your money: "+Game.player.money+"$");
                    Game.player.hearts+=1;
                }
                else
                {
                    Game.player.money+=500;
                    JOptionPane.showMessageDialog(null, "Unfortunately, You don't have enough money.", "Win", JOptionPane.INFORMATION_MESSAGE);
                    money.setText("Your money: "+Game.player.money+"$");
                }
            }
        });

        iconHeart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                description.setText("<html><font color='white'>You can add one heart so you get one more chance to win.</font></html>");
                panel.add(description);
            }
        });
        iconHeart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                description.setText(" ");
                panel.add(description);
            }
        });

        /////////Health potion
        iconHealthPotion=new JLabel(new ImageIcon("healthpotion.png"));
        iconHealthPotion.setBounds(230,320,100,60);
        f.add(iconHealthPotion);

        healthPotionPrice=new JLabel();
        healthPotionPrice.setText("200$");
        healthPotionPrice.setForeground(Color.WHITE);
        healthPotionPrice.setFont(new Font("Serif", Font.BOLD, 20));
        healthPotionPrice.setBounds(250,390,60,20);
        f.add(healthPotionPrice);

        healthPotionButton=new JButton("buy");
        healthPotionButton.setBounds(320,350,70,30);
        healthPotionButton.setFont(new Font("Serif", Font.BOLD, 12));
        healthPotionButton.setFocusable(false);
        f.add(healthPotionButton);

        healthPotionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.player.money-=200;
                if(Game.player.money>=0)
                {
                    money.setText("Your money: "+Game.player.money+"$");
                    Game.player.healthPotions+=1;
                }
                else
                {
                    Game.player.money+=200;
                    JOptionPane.showMessageDialog(null, "Unfortunately, You don't have enough money.", "Win", JOptionPane.INFORMATION_MESSAGE);
                    money.setText("Your money: "+Game.player.money+"$");
                }
            }
        });

        iconHealthPotion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                description.setText("<html><font color='white'>A health potion will instantly restore 10-20 health points upon purchase.</font></html>");
                panel.add(description);
            }
        });
        iconHealthPotion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                description.setText(" ");
                panel.add(description);
            }
        });

        /////////Health +5
        iconHealth=new JLabel(new ImageIcon("health.png"));
        iconHealth.setBounds(420,320,60,60);
        f.add(iconHealth);
        label3=new JLabel();
        label3.setText("+5");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Serif", Font.BOLD, 20));
        label3.setBounds(460,322,400,60);
        f.add(label3);

        helathPrice=new JLabel();
        helathPrice.setText("100$");
        helathPrice.setForeground(Color.WHITE);
        helathPrice.setFont(new Font("Serif", Font.BOLD, 20));
        helathPrice.setBounds(420,390,60,20);
        f.add(helathPrice);

        healthButton=new JButton("buy");
        healthButton.setBounds(500,350,70,30);
        healthButton.setFont(new Font("Serif", Font.BOLD, 12));
        healthButton.setFocusable(false);
        f.add(healthButton);

        healthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.player.money-=100;
                if(Game.player.money>=0)
                {
                    money.setText("Your money: "+Game.player.money+"$");
                    Game.player.health+=5;
                }
                else
                {
                    Game.player.money+=100;
                    JOptionPane.showMessageDialog(null, "Unfortunately, You don't have enough money.", "Win", JOptionPane.INFORMATION_MESSAGE);
                    money.setText("Your money: "+Game.player.money+"$");
                }
            }
        });

        iconHealth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                description.setText("<html><font color='white'>Increasing your health +5.</font></html>");
                panel.add(description);
            }
        });
        iconHealth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                description.setText(" ");
                panel.add(description);
            }
        });

        /////Strength
        iconStrength=new JLabel(new ImageIcon("strength.png"));
        iconStrength.setBounds(70,440,60,60);
        f.add(iconStrength);
        label4=new JLabel();
        label4.setText("+5");
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Serif", Font.BOLD, 20));
        label4.setBounds(130,440,60,60);
        f.add(label4);

        StrengthPrice=new JLabel();
        StrengthPrice.setText("300$");
        StrengthPrice.setForeground(Color.WHITE);
        StrengthPrice.setFont(new Font("Serif", Font.BOLD, 20));
        StrengthPrice.setBounds(80,505,60,20);
        f.add(StrengthPrice);

        StrengthButton=new JButton("buy");
        StrengthButton.setBounds(170,470,70,30);
        StrengthButton.setFont(new Font("Serif", Font.BOLD, 12));
        StrengthButton.setFocusable(false);
        f.add(StrengthButton);

        StrengthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.player.money-=300;
                if(Game.player.money>=0)
                {
                    money.setText("Your money: "+Game.player.money+"$");
                    Game.player.strength+=5;
                }
                else
                {
                    Game.player.money+=300;
                    JOptionPane.showMessageDialog(null, "Unfortunately, You don't have enough money.", "Win", JOptionPane.INFORMATION_MESSAGE);
                    money.setText("Your money: "+Game.player.money+"$");
                }
            }
        });

        iconStrength.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                description.setText("<html><font color='white'>Increasing your strength +5.</font></html>");
                panel.add(description);
            }
        });
        iconStrength.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                description.setText(" ");
                panel.add(description);
            }
        });

        /////Next round
        nextButton=new JButton("Go to the next round!");
        nextButton.setBounds(300,470,260,40);
        nextButton.setFont(new Font("Serif", Font.BOLD, 25));
        nextButton.setFocusable(false);
        f.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                if(Game.round<=3) new Fight(25,15);
                else if(Game.round >3 && Game.round <=5) new Fight(35,25);
                else if(Game.round >5 && Game.round <=7) new Fight(40,30);
                else new Fight2(60,45);
            }
        });

        /////////////////Frame options
        ImageIcon image = new ImageIcon("icon.jpg");
        f.setIconImage(image.getImage());
        f.setSize(600,700);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(new Color(0,65,137));
    }
}
