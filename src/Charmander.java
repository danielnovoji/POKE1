public class Charmander extends FirePokemon {


    public Charmander(String pokemonName, int pokemonType, int level, boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[] abilities) {
        super(pokemonName, pokemonType, level, canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);
    }

    public void everyRoundPassed(){}

    public boolean evolve(int ap, int hp) {
        boolean hasEvolved=true;
        if (getLevel()==Constants.LVL_ONE){
          if (pokemonCanEvolve(hp, ap)) {
                     newStats("Charmeleon",2,true,90,60);
                      removeHP(hp);
                      removeAP(ap);
                      addAttack(new Attack("Flame Tail",40,30,50));
                  }    else {
                                 System.out.println("Not enough points to evolve! (20 HP and 25 AP required!) ");
                                 hasEvolved =false;
                             }
        } else if(getLevel()==Constants.LVL_TWO) {
            if (pokemonCanEvolve(hp, ap)) {
                newStats("Charizard",3,false,130,80);
                removeHP(hp);
                removeAP(ap);
                addAttack(new Attack("Fairy Blast",50,50,50));
            }    else {
                System.out.println("Not enough points to evolve! (30 HP and 40 AP required!) ");
                hasEvolved=false;
            }
        }

        return hasEvolved;
    }

}


