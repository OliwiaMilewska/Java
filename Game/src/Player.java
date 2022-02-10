public class Player{
    String nickname;
    int health=15;
    int strength;
    int hearts=3;
    int healthPotions=3;
    int money=100;
    String weapon="knife";

    public Player(String aNick)
    {
        nickname=aNick;
        strength=(int)(Math.random()*(15-10+1)+10);
    }

    @Override
    public String toString() {
        return "<html>nickname=" + nickname + "<br>" +
                "health=" + health + "<br>" +
                "strength=" + strength + "<br>" +
                "hearts=" + hearts + "<br>" +
                "healthPotions=" + healthPotions + "<br>" +
                "money=" + money + "<br>" +
                "weapon=" + weapon+"</html>";
    }
}
