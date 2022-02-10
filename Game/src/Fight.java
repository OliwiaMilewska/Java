import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fight{

    int number;
    JFrame f;
    JLabel iconKnight,iconQ,iconE,enemy,playername,statisticsEnemy,statisticsPlayer,iconHearts,round,potion;
    JButton fight,attack,drink;
    String who;
    Font myFont = new Font("Serif", Font.BOLD, 30);
    Font myFontSmall = new Font("Serif", Font.BOLD, 20);
    Death death;
    Zombie zombie;
    Vampire vampire;
    Werewolf werewolf;


    public Fight(int max, int min)
    {
        death=new Death(max,min);
        zombie=new Zombie(max,min);
        vampire=new Vampire(max,min);
        werewolf=new Werewolf(max,min);

        f=new JFrame("Retro King");

        fight= new JButton("Fight!");
        fight.setBounds(190,250,180,50);
        fight.setFocusable(false);
        f.add(fight);

        iconKnight=new JLabel(new ImageIcon("knight.png"));
        iconKnight.setBounds(-30,200,300,410);
        f.add(iconKnight);

        iconQ=new JLabel(new ImageIcon("qm.png"));
        iconQ.setBounds(300,-80,300,410);
        f.add(iconQ);

        round=new JLabel("Round "+Game.round);
        round.setBounds(220,10,300,40);
        round.setFont(myFont);
        round.setForeground(Color.WHITE);
        f.add(round);

        enemy=new JLabel();
        enemy.setBounds(45,20,300,40);
        enemy.setFont(myFont);
        f.add(enemy);

        playername=new JLabel();
        playername.setBounds(280,320,300,40);
        playername.setFont(myFont);
        f.add(playername);

        potion=new JLabel("Potions: "+Game.player.healthPotions);
        potion.setBounds(400,510,300,40);
        potion.setFont(myFontSmall);
        potion.setForeground(Color.white);
        potion.setVisible(false);
        f.add(potion);

        attack=new JButton("Attack!");
        attack.setFont(myFontSmall);
        attack.setBounds(230,470,100,40);
        attack.setVisible(false);
        attack.setFocusable(false);
        f.add(attack);

        drink=new JButton("Drink health potion");
        drink.setFont(myFontSmall);
        drink.setBounds(330,470,250,40);
        drink.setVisible(false);
        drink.setFocusable(false);
        f.add(drink);

        statisticsPlayer=new JLabel("<html>Attack: "+Game.player.strength+"<br>Health: "+Game.player.health+"<br>Weapon: "+Game.player.weapon+"</hmtl>");
        statisticsPlayer.setVisible(false);
        statisticsPlayer.setBounds(280,360,300,80);
        statisticsPlayer.setFont(myFontSmall);
        statisticsPlayer.setForeground(Color.WHITE);
        f.add(statisticsPlayer);

        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fight.setVisible(false);
                iconQ.setVisible(false);
                statisticsPlayer.setVisible(true);
                attack.setVisible(true);
                drink.setVisible(true);
                number=(int)(Math.random()*(4));
                potion.setVisible(true);
                //Selecting an enemy
                if(number==0)
                {
                    who="Werewolf";
                    iconE= new JLabel(new ImageIcon("werewolf.png"));
                    statisticsEnemy=new JLabel("<html>Attack: "+werewolf.strength+"<br>Health: "+werewolf.health);
                    doLabels();
                }
                if(number==1)
                {
                    who="Death";
                    iconE= new JLabel(new ImageIcon("death.png"));
                    statisticsEnemy=new JLabel("<html>Attack: "+death.strength+"<br>Health: "+death.health);
                    doLabels();
                }
                if(number==2)
                {
                    who="Zombie";
                    iconE= new JLabel(new ImageIcon("zombie.png"));
                    statisticsEnemy=new JLabel("<html>Attack: "+zombie.strength+"<br>Health: "+zombie.health);
                    doLabels();
                }
                if(number==3)
                {
                    who="Vampire";
                    iconE= new JLabel(new ImageIcon("vampire.png"));
                    statisticsEnemy=new JLabel("<html>Attack: "+vampire.strength+"<br>Health: "+vampire.health);
                    doLabels();
                }
                enemy.setText(who);
                enemy.setForeground(Color.WHITE);
                playername.setText(Game.name);
                playername.setForeground(Color.WHITE);

                ///Hearts
                if(Game.player.hearts==3)
                {
                    iconHearts=new JLabel(new ImageIcon("heart3.png"));
                    iconHearts.setBounds(42,210,150,50);
                    f.add(iconHearts);
                }
                else if(Game.player.hearts==2)
                {
                    iconHearts=new JLabel(new ImageIcon("heart2.png"));
                    iconHearts.setBounds(42,210,150,50);
                    f.add(iconHearts);
                }
                else
                {
                    iconHearts=new JLabel(new ImageIcon("heart1.png"));
                    iconHearts.setBounds(42,210,150,50);
                    f.add(iconHearts);
                }
            }
        });

        attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (number) {
                    case 0:
                        werewolf.health -= Game.player.strength;
                        statisticsEnemy.setText("<html>Attack: " + werewolf.strength + "<br>Health: " + werewolf.health);
                        if(werewolf.health>0) Game.player.health -= werewolf.strength;
                        checking();
                        break;
                    case 1:
                        death.health-=Game.player.strength;
                        statisticsEnemy.setText("<html>Attack: "+death.strength+"<br>Health: "+death.health);
                        if(death.health>0) Game.player.health-= death.strength;
                        checking();
                        break;
                    case 2:
                        zombie.health-=Game.player.strength;
                        statisticsEnemy.setText("<html>Attack: "+zombie.strength+"<br>Health: "+zombie.health);
                        if(zombie.health>0) Game.player.health-= zombie.strength;
                        checking();
                        break;
                    case 3:
                        vampire.health-=Game.player.strength;
                        statisticsEnemy.setText("<html>Attack: "+vampire.strength+"<br>Health: "+vampire.health);
                        if(vampire.health>0) Game.player.health-= vampire.strength;
                        checking();
                        break;
                }
            }
        });

        drink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Game.player.healthPotions>0)
                {
                    Game.player.health+=(int)(Math.random()*(20-10+1)+10);
                    Game.player.healthPotions--;
                    statisticsPlayer.setText("<html>Attack: "+Game.player.strength+"<br>Health: "+Game.player.health+"<br>Weapon: "+Game.player.weapon+"</hmtl>");
                    potion.setText("Potions: "+Game.player.healthPotions);
                }
                else
                {
                    drink.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "You are out of potions", "Lost", JOptionPane.INFORMATION_MESSAGE);
                }
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

    public void checking()
    {
        if(werewolf.health<=0 || death.health<=0 || zombie.health<=0 || vampire.health<=0)
        {
            JOptionPane.showMessageDialog(null, "You won! First round is over", "Win", JOptionPane.INFORMATION_MESSAGE);
            f.dispose();
            if(Game.round<=3) Game.player.money+=(int)(Math.random()*(400-200+1)+100);
            else if(Game.round >3 && Game.round <=5) Game.player.money+=(int)(Math.random()*(600-300+1)+200);
            else Game.player.money+=(int)(Math.random()*(800-500+1)+300);

            Game.round++;
            new Shop();
        }
        else if(Game.player.health<0)
        {
            Shop.swordCount=0;
            Shop.bowCount=0;
            Shop.spearCount=0;
            int choice = JOptionPane.showOptionDialog(null, "You have lost :c", "Defeat", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            Game.round=1;
            if(Game.player.hearts>1)
            {
                Game.player.hearts--;
                Game.player.health=20;
                Game.player.strength=25;
                Game.player.money+=100;
                Game.round=1;
                if (choice == JOptionPane.YES_OPTION)
                {
                    f.dispose();
                    Game.player.money+=200;
                    new Shop();
                }
            }
            else
            {
                if (choice == JOptionPane.YES_OPTION)
                {
                    f.dispose();
                    new Survive();
                }
            }
        }
        else
        {
            attack.setEnabled(false);
            statisticsPlayer.setText("<html>Attack: "+Game.player.strength+"<br><font color='red'>Health: "+Game.player.health+"</font><br>Weapon: "+Game.player.weapon+"</hmtl>");
            JOptionPane.showMessageDialog(null, "Your enemy attacked you.", "Attack", JOptionPane.INFORMATION_MESSAGE);
            statisticsPlayer.setForeground(Color.WHITE);
            statisticsPlayer.setText("<html>Attack: "+Game.player.strength+"<br>Health: "+Game.player.health+"<br>Weapon: "+Game.player.weapon+"</hmtl>");
            attack.setEnabled(true);
        }
    }

    public void doLabels()
    {
        iconE.setBounds(300,-50,300,410);
        f.add(iconE);
        statisticsEnemy.setBounds(50,60,300,60);
        statisticsEnemy.setFont(myFontSmall);
        statisticsEnemy.setForeground(Color.WHITE);
        f.add(statisticsEnemy);
    }
}
