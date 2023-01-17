public class Salandit extends FirePokemon {


    public Salandit(String pokemonName, int pokemonType, int level, boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[] abilities) {
        super(pokemonName, pokemonType, level, canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);
    }


    @Override
    public boolean evolve(int hp, int ap) {
        boolean hasEvolved=true;
        if (getLevel()==Constants.LVL_ONE){
            if (pokemonCanEvolve(hp, ap)) {
                newStats("Salazzle",2,false,160,80);
                removeHP(hp);
                removeAP(ap);
                addAttack(new Attack("Fire Claws",25,0,50));
            }    else {
                System.out.println("Not enough points to evolve! (20 HP and 25 AP required!) ");
                hasEvolved =false;
            }
        } else if(getLevel()==Constants.LVL_TWO) {
            System.out.println("You've reached max level!");
        }

        return hasEvolved;
    }

    @Override
    public void everyRoundPassed() {

    }

}

