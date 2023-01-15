import java.util.Random;

public abstract class FirePokemon extends Pokemon {


    public FirePokemon(String pokemonName, int pokemonType, int level,boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[] abilities) {
        super(pokemonName, pokemonType, level,canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);
    }

    public void selfDamage() {
        Random random = new Random();
        int selfDamagePercentage;
        selfDamagePercentage = random.nextInt( 4)+1;
        if (selfDamagePercentage==4) {
            selfDamagePercentage=random.nextInt(7)+3;
            removeHP(selfDamagePercentage);
            System.out.println("You've received self damage of " +selfDamagePercentage + "HP.");
        }
    }

    }

