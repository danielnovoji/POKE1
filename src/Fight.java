
import java.util.Random;
import java.util.Scanner;

public class Fight {
    private Pokemon createPokemon() { //O(1)
        Random random = new Random();

        String pokemon = Constants.POKEMON_NAMES[random.nextInt(6)];
        Pokemon summonPokemon = null;
                switch (pokemon) {
                    case Constants.BLITZLE -> summonPokemon =  new Blitzle("Blitzle",Constants.ELECTRIC_POKEMON, Constants.STARTING_LEVEL, true, 90, 35, 90, 26,
                            new Attack[]{new Attack("Kick", Constants.KICK_COST, Constants.KICK_DAMAGE, Constants.KICK_DAMAGE), new Attack("Flop", 20, 20, 25)});

                    case Constants.CHARMANDER -> summonPokemon = new Charmander("Charmander", Constants.FIRE_POKEMON, Constants.STARTING_LEVEL, true, 80, 40, 80, 30,
                            new Attack[]{Constants.KICK, new Attack("Scratch", 15, 25, 30)});

                    case Constants.MOLTRES -> summonPokemon = new Moltres("Moltres", Constants.FIRE_POKEMON, Constants.STARTING_LEVEL, false, 120, 60, 120, 45,
                            new Attack[]{Constants.KICK, new Attack("Assisting Heater", 30, 10, 60),
                                    new Attack("Fire Wing", 30, 30, 30)});
                    case Constants.SALANDIT -> summonPokemon = new Salandit("Salandit", Constants.FIRE_POKEMON, Constants.STARTING_LEVEL, true, 100, 60, 100, 45,
                            new Attack[]{Constants.KICK, new Attack("Live Coal", 10, 1, 25)});

                    case Constants.ELECTABUZZ -> summonPokemon =  new Electabuzz("Electabuzz", Constants.ELECTRIC_POKEMON, Constants.STARTING_LEVEL, true, 30, 100, 30, 75,
                            new Attack[]{Constants.KICK, new Attack("Thunder", 60, 40, 50)});

                    case Constants.PICHU -> summonPokemon = new Pichu("Pichu", Constants.ELECTRIC_POKEMON, Constants.STARTING_LEVEL, true, 40, 30, 40, 22,
                            new Attack[]{Constants.KICK, new Attack("Quick Attack", 5, 10, 10)});
        }
       return summonPokemon;
    }

    private String playerTurn(int indexPlayer){ //O(1)
        String playerTurn = "Player 2:";
        if (indexPlayer==Constants.PLAYER_ONE){
            playerTurn = "Player 1:";
        }
        return playerTurn;
    }

    public void initGame() { //O(n^2)
        System.out.println("\nWelcome to the Pokemon fight game! " +
                "Every round that the person plays will receive 0-4HP and 0-4AP! \nThe electric pokemon has the ability to use a special ability which grants him full HP and full AP only once! \n" +
                "The fire pokemon has the ability to damage his enemy twice with a random ability, in return his HP is cut in half and his AP will deplete! \n ");
        Random random= new Random();
        int userChoice;
        int indexOfPokemon= 0;
        Scanner scanner = new Scanner(System.in);
        Pokemon [] selectedPokemons = new Pokemon[2];
        for (int i = 0; i<selectedPokemons.length; i++) {
            selectedPokemons[i] = createPokemon();

        }
        boolean playerFinishedTurn= true;
        boolean usedElectricSpecialAttack=true;

        while(selectedPokemons[Constants.PLAYER_ONE].isAlive() && selectedPokemons[Constants.PLAYER_TWO].isAlive()){
            System.out.println(playerTurn(Constants.PLAYER_ONE)+selectedPokemons[Constants.PLAYER_ONE]);
            System.out.println("---------------------------");
            System.out.println(playerTurn(Constants.PLAYER_TWO)+selectedPokemons[Constants.PLAYER_TWO]);
            System.out.println(playerTurn(indexOfPokemon) + " it's your turn!");
            do {
                System.out.println("Options: \n" +
                        "1) Attack your Opponent. \n" +
                        "2) Wait. (Waiting will award you a random bonus!) \n" +
                        "3) Evolve your Pokemon. \n" +
                        "4) Special Action. (This option depends on the type of pokemon, more information above!)" );
                userChoice= scanner.nextInt();

            } while (userChoice>4||userChoice<1);
            switch (userChoice){
                case Constants.ATTACK_SELECTION ->
                attack(selectedPokemons, indexOfPokemon);
                case Constants.WAIT_SELECTION -> waitOption(selectedPokemons[indexOfPokemon]);
                case Constants.EVOLVE_SELECTION -> evolve(selectedPokemons[indexOfPokemon]);
                case Constants.SPECIAL_ATTACK -> {
                    if (selectedPokemons[indexOfPokemon].isFirePokemon()){
                        specialAttack(selectedPokemons,indexOfPokemon);
                    } else {
                        if (usedElectricSpecialAttack) {
                            usedElectricSpecialAttack = false;
                             specialAttack(selectedPokemons,indexOfPokemon);
                            playerFinishedTurn = true;
                    }else {
                            System.out.println("You have already used your special ability! you cannot use it again.");
                        }
                    }
                }
            }
            selectedPokemons[indexOfPokemon].addHP(random.nextInt(5));
            selectedPokemons[indexOfPokemon].addAP(random.nextInt(5));
            if (indexOfPokemon==Constants.PLAYER_ONE) {
                indexOfPokemon=Constants.PLAYER_TWO;
            } else {
                indexOfPokemon=Constants.PLAYER_ONE;
            }


        }


    }



    private boolean attack (Pokemon [] selectedPokemon, int indexOfPlayer) { //O(1)
        boolean playerFinishedTurn =false;
        printAbilities(selectedPokemon[indexOfPlayer]);
        int userChoice=userChoice(selectedPokemon[indexOfPlayer]);
        int costAp = selectedPokemon[indexOfPlayer].getAbilities()[userChoice-1].getApCost();
        if (selectedPokemon[indexOfPlayer].attackByAPCost(costAp)){
            if (selectedPokemon[indexOfPlayer].isFirePokemon()) {
                        int selfDamage = selfDamage();
                        if(selfDamage>0){
                            selectedPokemon[indexOfPlayer].removeHP(selfDamage);
                            System.out.println("You've received self damage of " + selfDamage + " HP.");
                        }

            } else {


            }
        }else {
            System.out.println("Not enough AP to use the ability! ");
        }


    }




    private void printAbilities (Pokemon player) { //O(n)
        System.out.println("Your abilities are: ");
        for (int i=0; i<player.getAbilities().length; i++){
            System.out.println((i+1)+" )"+player.getAbilities()[i]);
    }}
    private int userChoice (Pokemon player) { //O(n)
        Scanner scanner= new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("Choose the ability you want to use: ");
            userChoice=scanner.nextInt();
    } while (userChoice<1 || userChoice>player.getAbilities().length );
        return userChoice;
    }





    private void waitOption (Pokemon player) {  //O(1)
        Random random= new Random();
        int bonusRandomizer = random.nextInt(4)+1;
        switch (bonusRandomizer){
            case Constants.RANDOM_HP-> {
            int hpReceived=random.nextInt(31)+5;
                player.addHP(hpReceived);
                System.out.println("You've received " + hpReceived + "HP as bonus for waiting!");}

            case Constants.RANDOM_AP -> {
                int apReceived = random.nextInt(40)+1;
                player.addAP(apReceived);
                System.out.println("You've received " + apReceived + "AP as bonus for waiting!"); }

            case Constants.TRIPLE_DAMAGE ->{
                 player.setPokemonBaseDamage(Constants.TRIPLE_DAMAGE);
                 System.out.println("You've received 3X damage on your next attack as bonus for waiting! (Lasts only for one round!) ");
            }

        }

    }
    private boolean evolve (Pokemon  player, int indexOfPlayer) { // O(1)
        boolean  playerFinishedTurn = false;
        if (!player.isCanEvolve()){
            System.out.println("You can't evolve since you've reached your final level! ");
        }else {
            switch (player.getLevel()) {
                case Constants.LVL_ONE ->
                    playerFinishedTurn = player.evolve(Constants.HP_FOR_LVL_TWO, Constants.AP_FOR_LVL_TWO);
                case Constants.LVL_TWO ->
                    playerFinishedTurn = player.pokemonCanEvolve(Constants.HP_FOR_LVL_THREE, Constants.AP_FOR_LVL_THREE);
                case Constants.LVL_THREE ->  System.out.println("You've reached max level! ");

            }
        }
        return  playerFinishedTurn ;
    }
    private void specialAttack (Pokemon [] selectedPokemon, int indexOfPlayer) {
        Random random = new Random();
        int abilityIndex;
        if (selectedPokemon[indexOfPlayer].isFirePokemon()) {
            abilityIndex= random.nextInt(selectedPokemon[indexOfPlayer].getAbilities().length);
            int damageOpponent= selectedPokemon[indexOfPlayer].getAbilities()[abilityIndex].minMaxDamageRandomizer();
            System.out.println("You've damaged "+damageOpponent + "to your opponent");
            if (indexOfPlayer==Constants.PLAYER_ONE){
                  selectedPokemon[Constants.PLAYER_TWO].removeHP(damageOpponent*2);
            }else {
                selectedPokemon[Constants.PLAYER_ONE].removeHP(damageOpponent*2);
            }
            System.out.println("You've dealt " + damageOpponent+ "HP to your opponent using your special ability! \n" +
                    "your HP has been halved and ap has been reset!");
            selectedPokemon[indexOfPlayer].resetAP();
            selectedPokemon[indexOfPlayer].makeHalfHP();


        } else {
       selectedPokemon[indexOfPlayer].addMaxHP();
        selectedPokemon[indexOfPlayer].addMaxAP();
            System.out.println("You've refilled your HP and AP! ");
        }

    }

    private Pokemon getWinner (Pokemon[] player, int indexOfPlayer) { // O(1)
        if (indexOfPlayer == Constants.PLAYER_ONE) {
                player[Constants.PLAYER_TWO].printName();
                System.out.println( " Has won the game!");
            }
        else {
            player[Constants.PLAYER_ONE].printName();
            System.out.println(" Has won the game!");

        }
        return player[indexOfPlayer];
    }

}

