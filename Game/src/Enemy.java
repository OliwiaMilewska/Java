public abstract class Enemy {
    int health=1,defense, strength;

    public Enemy(int max, int min)
    {
        health=(int)(Math.random()*(max-min+1)+min);
        defense=(int)(Math.random()*(max-min+1)+min);
        strength=(int)(Math.random()*(max-min+1)+min);
    }
}
