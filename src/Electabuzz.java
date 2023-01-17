public class Electabuzz extends ElectricPokemon {


    public Electabuzz(String pokemonName, int pokemonType, int level, boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[] abilities) {
        super(pokemonName, pokemonType, level, canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);
    }

    @Override
    public boolean evolve(int hp, int ap) {
        boolean hasEvolved = true;
        if (getLevel() == Constants.LVL_ONE) {
            if (pokemonCanEvolve(hp, ap)) {
                newStats("Electivire", 2, false, 35, 120);
                removeHP(hp);
                removeAP(ap);
                addAttack(new Attack("Thunder Punch", 80, 50, 120));
            } else {
                System.out.println("Not enough points to evolve! (20 HP and 25 AP required!) ");
                hasEvolved = false;
            }
        } else if (getLevel() == Constants.LVL_TWO) {
            System.out.println("You've reached max level! ");
            hasEvolved = false;
        }
        return hasEvolved;
    }

}
