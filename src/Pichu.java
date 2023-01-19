public class Pichu extends ElectricPokemon {


    public Pichu(String pokemonName, int pokemonType, int level, boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[]abilities) { //O(1)
        super(pokemonName, pokemonType, level, canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);
    }

    @Override
    public boolean evolve(int hp, int ap) { //O(1)
        boolean hasEvolved=true;
        if (getLevel()==Constants.LVL_ONE){
            if (pokemonCanEvolve(hp, ap)) {
                newStats("Pikachu",2,true,50,40);
                removeHP(hp);
                removeAP(ap);
                addAttack(new Attack("Electro Ball",10,30,40));
            }    else {
                System.out.println("Not enough points to evolve! (20 HP and 25 AP required!) ");
                hasEvolved =false;
            }
        } else if(getLevel()==Constants.LVL_TWO) {
            if (pokemonCanEvolve(hp, ap)) {
                newStats("Raichu",3,false,160,80);
                removeHP(hp);
                removeAP(ap);
                addAttack(new Attack("Electric Surfer",60,20,120));
            }    else {
                System.out.println("Not enough points to evolve! (30 HP and 40 AP required!) ");
                hasEvolved=false;
            }
        }

        return hasEvolved;
    }

    }

