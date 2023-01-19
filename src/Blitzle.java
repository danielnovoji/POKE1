public class Blitzle extends ElectricPokemon {


    public Blitzle(String pokemonName, int pokemonType, int level, boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack [] abilities) {
        super(pokemonName, pokemonType, level, canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);
    }

    @Override
    public boolean evolve(int hp, int ap) { //O(1)
        boolean evolved=true;
        if (getLevel()==Constants.LVL_ONE){
            if (pokemonCanEvolve(hp, ap)) {
                newStats("Zebstrika",2,false,100,50);
                removeHP(hp);
                removeAP(ap);
                addAttack(new Attack("Zap Kick",30,30,35));
            }    else {
                System.out.println("Not enough points to evolve! (20 HP and 25 AP required!) ");
                evolved =false;
            }
        } else if (getLevel()==Constants.LVL_TWO) {
            System.out.println("You've reached max level!");
        }
        return evolved;
    }


}
