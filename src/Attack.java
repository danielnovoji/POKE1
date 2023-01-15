import java.util.Arrays;
import java.util.Random;

public class Attack {
    private String attackName;
    private int apCost;
    private int minDamageToOpponent;
    private int maxDamageToOpponent;

    public Attack(String attackName, int apCost, int minDamageToOpponent, int maxDamageToOpponent) {
        this.attackName = attackName;
        this.apCost = apCost;
        this.minDamageToOpponent = minDamageToOpponent;
        this.maxDamageToOpponent = maxDamageToOpponent;
    }

    public int minMaxDamageRandomizer (){
        Random random= new Random();
        return random.nextInt(this.minDamageToOpponent) + this.maxDamageToOpponent;
    }


    @Override
    public String toString() {
        return "Attack names: " + this.attackName + " AP cost: " + this.apCost + " Damage Range: "
                +this.minDamageToOpponent + "-" + this.maxDamageToOpponent;
    }

    public int getApCost() {
        return apCost;
    }
}

