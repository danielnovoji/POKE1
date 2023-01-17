public class Moltres extends FirePokemon {


    public Moltres(String pokemonName, int pokemonType, int level, boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[] abilities) {
        super(pokemonName, pokemonType, level, canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);

    }

    @Override
    public boolean evolve(int hp, int ap) {
        boolean hasEvolved=false;
        System.out.println("You can't evolve since you reached your final level!");
        return hasEvolved;
    }

    @Override
    public void everyRoundPassed() {

    }
}
