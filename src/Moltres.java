public class Moltres extends FirePokemon {


    public Moltres(String pokemonName, int pokemonType, int level, boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[] abilities) { //O(1)
        super(pokemonName, pokemonType, level, canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);

    }

    @Override
    public boolean evolve(int hp, int ap) { //O(1)
        boolean hasEvolved=false;
        System.out.println("You can't evolve since you reached your final level!");
        return hasEvolved;
    }

    @Override
    public void everyRoundPassed() { //O(1)

    }
}
