
import java.util.Random;

public class Attack {
    private String attackName;
    private int apCost;
    private int minDamageToOpponent;
    private int maxDamageToOpponent;

    public Attack(String attackName, int apCost, int minDamageToOpponent, int maxDamageToOpponent) { //O(1)
        this.attackName = attackName;
        this.apCost = apCost;
        this.minDamageToOpponent = minDamageToOpponent;
        this.maxDamageToOpponent = maxDamageToOpponent;
    }

    public int minMaxDamageRandomizer (){ //O(1)
        Random random= new Random();
        int damageForOpponent = 0;
        if (this.minDamageToOpponent==this.maxDamageToOpponent){
           damageForOpponent = this.maxDamageToOpponent;
        }else {
              damageForOpponent=this.minDamageToOpponent + random.nextInt(this.maxDamageToOpponent - this.minDamageToOpponent + 1);
        }

      return damageForOpponent;
    }


    @Override
    public String toString() { //O(1)
        return "Attack names: " + this.attackName + " AP cost: " + this.apCost + " Damage Range: "
                +this.minDamageToOpponent + "-" + this.maxDamageToOpponent;
    }

    public int getApCost() {
        return apCost;
    } //O(1)
}

