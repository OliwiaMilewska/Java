import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fight2 {
    int number;
    JFrame f;
    JLabel iconKnight,iconQ,iconE,enemy,playername,statisticsEnemy,statisticsPlayer,iconHearts,round,potion;
    JButton fight,attack,drink;
    String who;
    Font myFont = new Font("Serif", Font.BOLD, 30);
    Font myFontSmall = new Font("Serif", Font.BOLD, 20);
    Death deathKing;
    Zombie zombieKing;
    Vampire vampireKing;
    Werewolf werewolfKing;

    public Fight2(int max,int min)
    {
        deathKing=new DeathKing(max,min);
        zombieKing=new ZombieKing(max,min);
        vampireKing=new VampireKing(max,min);
        werewolfKing=new WerewolfKing(max,min);

        f=new JFrame("Retro King");

        iconKnight=new JLabel(new ImageIcon("knight.png"));
        iconKnight.setBounds(-30,200,300,410);
        f.add(iconKnight);

        fight= new JButton("Fight!");
        fight.setBounds(190,250,180,50);
        fight.setFocusable(false);
        f.add(fight);

        iconQ=new JLabel(new ImageIcon("qm.png"));
        iconQ.setBounds(300,-80,300,410);
        f.add(iconQ);

        round=new JLabel("Final round!");
        round.setBounds(220,10,300,40);
        round.setFont(myFont);
        round.setForeground(Color.WHITE);
        f.add(round);

        enemy=new JLabel();
        enemy.setBounds(20,20,300,40);
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

                //Selecting an enemy
                if(number==0)
                {
                    who="Werewolf King";
                    iconE= new JLabel(new ImageIcon("werewolf.png"));
                    statisticsEnemy=new JLabel("<html>Attack: "+werewolfKing.strength+"<br>Health: "+werewolfKing.health);
                    doLabels();
                }
                if(number==1)
                {
                    who="Death King";
                    iconE= new JLabel(new ImageIcon("death.png"));
                    statisticsEnemy=new JLabel("<html>Attack: "+deathKing.strength+"<br>Health: "+deathKing.health);
                    doLabels();
                }
                if(number==2)
                {
                    who="Zombie King";
                    iconE= new JLabel(new ImageIcon("zombie.png"));
                    statisticsEnemy=new JLabel("<html>Attack: "+zombieKing.strength+"<br>Health: "+zombieKing.health);
                    doLabels();
                }
                if(number==3)
                {
                    who="Vampire King";
                    iconE= new JLabel(new ImageIcon("vampire.png"));
                    statisticsEnemy=new JLabel("<html>Attack: "+vampireKing.strength+"<br>Health: "+vampireKing.health);
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
                        werewolfKing.health -= Game.player.strength;
                        statisticsEnemy.setText("<html>Attack: " + werewolfKing.strength + "<br>Health: " + werewolfKing.health);
                        if(werewolfKing.health>0) Game.player.health -= werewolfKing.strength;
                        checking();
                        break;
                    case 1:
                        deathKing.health-=Game.player.strength;
                        statisticsEnemy.setText("<html>Attack: "+deathKing.strength+"<br>Health: "+deathKing.health);
                        if(deathKing.health>0) Game.player.health-= deathKing.strength;
                        checking();
                        break;
                    case 2:
                        zombieKing.health-=Game.player.strength;
                        statisticsEnemy.setText("<html>Attack: "+zombieKing.strength+"<br>Health: "+zombieKing.health);
                        if(zombieKing.health>0) Game.player.health-= zombieKing.strength;
                        checking();
                        break;
                    case 3:
                        vampireKing.health-=Game.player.strength;
                        statisticsEnemy.setText("<html>Attack: "+vampireKing.strength+"<br>Health: "+vampireKing.health);
                        if(vampireKing.health>0) Game.player.health-= vampireKing.strength;
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
        if(werewolfKing.health<=0 || deathKing.health<=0 || zombieKing.health<=0 || vampireKing.health<=0)
        {
            JOptionPane.showMessageDialog(null, "You won with "+who+"! Now you need to answer some logic riddles to win the game.", "Win", JOptionPane.INFORMATION_MESSAGE);
            f.dispose();
            new Ending();
        }
        else if(Game.player.health<0)
        {

            int choice = JOptionPane.showOptionDialog(null, "You have lost :c", "Defeat", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if(Game.player.hearts>1)
            {
                Game.player.hearts--;
                Game.player.health=50;
                Game.player.money+=300;
                if (choice == JOptionPane.YES_OPTION)
                {
                    f.dispose();
                    Game.round=6;
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
