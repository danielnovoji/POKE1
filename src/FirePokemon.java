import java.util.Random;

public abstract class FirePokemon extends Pokemon {


    public FirePokemon(String pokemonName, int pokemonType, int level,boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[] abilities) { //O(1)
        super(pokemonName, pokemonType, level,canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);
    }

    public void selfDamage() { //O(1)
        Random random = new Random();
        int selfDamagePercentage;
        selfDamagePercentage = random.nextInt(4)+1;
        if (selfDamagePercentage==Constants.TWENTY_FIVE_PERCENT) {
            selfDamagePercentage=random.nextInt(8)+3;
            removeHP(selfDamagePercentage);
            System.out.println("You've received self damage of " +selfDamagePercentage + "HP.");
        }
    }

    @Override
    public void attackSpecialty() { selfDamage();} //O(1)
    public void everyRoundPassedOpponent(){} //O(1)
    public int attackSpecialty(Attack attack) {
        return attack.minMaxDamageRandomizer();
    } //O(1)
}

