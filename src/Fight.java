import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Fight {
    private String [] pokemonNames = new String[]{"Electabuzz","Pichu","Blitzle", "Charmander", "Salandit", "Moltres"};

//    private Pokemon [] secondDevelopment = new Pokemon[] { new Charmeleon("Charmeleon", Constants.FIRE_POKEMON, 2,90,60,90,45,
//            new Attack[]{new Attack("Flame Tail", 40,30,50)}),
//            new Salazzler("Salazzler" , Constants.FIRE_POKEMON, 2, 160,80,160, 60,
//                    new Attack[] {new Attack("Fire Claws", 25 , 0,50)}),};
    private Pokemon createPokemon(){
        Random random=new Random();
        String pokemon = pokemonNames [random.nextInt(6)];
        Pokemon pokemon1 = new Blitzle("Blitzle", Constants.ELECTRIC_POKEMON, 1 ,true, 90, 35,90,26,
                new Attack[]{new Attack("Kick", 0, 2 ,2),new Attack("Flop", 20,20,25)});
        switch (pokemon){
            case "Charmander" -> pokemon1 = new Charmander("Charmander", Constants.FIRE_POKEMON, 1,true,80,40,80,30,
                    new Attack[]{new Attack("Kick", 0, 2 ,2), new Attack("Scratch", 15,25,30)});
            case "Moltres" -> pokemon1= new Moltres("Moltres", Constants.FIRE_POKEMON, 1 ,false, 120, 60 ,120, 45,
                    new Attack[]{new Attack("Kick", 0, 2 ,2),new Attack("Assisting Heater", 30, 10,60), new Attack("Fire Wing", 30,30,30 )});
            case "Salandit" -> pokemon1=  new Salandit("Salandit", Constants.FIRE_POKEMON, 1,true,100,60,100, 45,
                    new Attack[]{new Attack("Kick", 0, 2 ,2),new Attack("Live Coal", 10,0,25)});
            case "Electabuzz" -> pokemon1=new Electabuzz("Electabuzz", Constants.ELECTRIC_POKEMON, 1,true, 30,100, 30, 75,
                    new Attack[]{new Attack("Kick", 0, 2 ,2), new Attack("Thunder", 60,40,50)});
            case "Pichu" ->pokemon1= new Pichu("Pichu", Constants.ELECTRIC_POKEMON, 1,true, 40,30,40,22,
                    new Attack[]{new Attack("Kick", 0, 2 ,2),new Attack("Quick Attack", 5,10,10)});
        }
       return pokemon1;
    }

    private String playerTurn(int indexPlayer){
        String playerTurn = "Player 2:";
        if (indexPlayer==Constants.PLAYER_ONE){
            playerTurn = "Player 1:";
        }
        return playerTurn;
    }

    public void initGame() {

        System.out.println("Welcome to the Pokemon fight game! " +
                "Every round that passes you will receive 4HP and 4AP! \n ");
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
                        "4) Special Action.");
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
                            specialAttack(selectedPokemons,indexOfPokemon);
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
    private void attack (Pokemon [] selectedPokemon, int indexOfPlayer) {
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
    public int selfDamage() {
        Random random = new Random();
        int  selfDamage = 0;
        int selfDamagePercentage;
        selfDamagePercentage = random.nextInt( 4)+1;
        if (selfDamagePercentage==4) { //MAKE 4 FINAL!!!!!!!!!!!!!!!!!!!!!!!!!!
            selfDamage=random.nextInt(7)+3;
        }
        return selfDamage;
    }



    private void printAbilities (Pokemon player) {
        System.out.println("Your abilities are: ");
        for (int i=0; i<player.getAbilities().length; i++){
            System.out.println((i+1)+" )"+player.getAbilities()[i]);
    }}
    private int userChoice (Pokemon player) {
        Scanner scanner= new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("Choose the ability you want to use: ");
            userChoice=scanner.nextInt();
    } while (userChoice<1 || userChoice>player.getAbilities().length );
        return userChoice;
    }





    private void waitOption (Pokemon player) {
        Random random= new Random();
        int bonusRandomizer = random.nextInt(4)+1;
        switch (bonusRandomizer){
            case Constants.RANDOM_HP-> {
            int hpReceived=random.nextInt(31)+5;
                player.addHP(hpReceived);
                System.out.println("You've received " + hpReceived + "HP.");}

            case Constants.RANDOM_AP -> {
                int apReceived = random.nextInt(40)+1;
                player.addAP(apReceived);
                System.out.println("You've received " + apReceived + "AP."); }

            case Constants.TRIPLE_DAMAGE ->{
                 player.setPokemonBaseDamage(3);
                 System.out.println("You've received 3X damage on your next attack! (Lasts only for one round!) ");
            }

        }

    }
    private void evolve (Pokemon player) {
        if (player.isCanEvolve()){

        } else {
            System.out.println("You've reached your final level! ");
        }
    }
    private void specialAttack (Pokemon [] selectedPokemon, int indexOfPlayer) {
        Random random = new Random();
        int abilityIndex;
        if (selectedPokemon[indexOfPlayer].isFirePokemon()) {
            abilityIndex= random.nextInt(selectedPokemon[indexOfPlayer].getAbilities().length);
            int damageOpponent= selectedPokemon[indexOfPlayer].getAbilities()[abilityIndex].minMaxDamageRandomizer();
            System.out.println("##########"+damageOpponent);
            if (indexOfPlayer==Constants.PLAYER_ONE){
                  selectedPokemon[Constants.PLAYER_TWO].removeHP(damageOpponent*2);
            }else {
                selectedPokemon[Constants.PLAYER_ONE].removeHP(damageOpponent*2);
            }
            selectedPokemon[indexOfPlayer].resetAP();
            selectedPokemon[indexOfPlayer].makeHalfHP();


        } else {
       selectedPokemon[indexOfPlayer].addMaxHP();
        selectedPokemon[indexOfPlayer].addMaxAP();
            System.out.println("You've refilled your HP and AP! ");
        }
        System.out.println(selectedPokemon[Constants.PLAYER_ONE]);
        System.out.println(selectedPokemon[Constants.PLAYER_TWO]);
    }
    private void initAbility () {

    }

}

