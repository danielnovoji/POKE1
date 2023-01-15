import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Fight fight = new Fight();
        fight.initGame();


//        Pokemon[] pokemons = Fight.initPokemonGame();
//        Pokemon[] pokemonsInFight = initPokemonGameInFights(pokemons);
//        //Every round
//        System.out.println("Welcome to our pokemon game!");
//        System.out.println("The pokemon for user 1 is: " + pokemonsInFight[0]);
//        System.out.println("The pokemon for user 2 is: " + pokemonsInFight[1]);
//        System.out.println("User 1 its you turn please chose from table");
//        boolean gameOver = false;
//        String user = "Player one";
//        int currentPokemon = 0;
//        int secondPokemon = 1;
//        boolean isPlayerOnePlay = true;
//        boolean isFinishTheTurn;
//        while (!gameOver) {
//            System.out.println("User : " + user);
//            System.out.println("Your pokemon: " + pokemonsInFight[currentPokemon]);
//            System.out.println("Please choose what do to");
//            System.out.println("1) for attack");
//            System.out.println("2) for hold");
//            System.out.println("3) for development");
//            System.out.println("4) for special action");
//            int move = scanner.nextInt();
//            isFinishTheTurn = startMove(move, pokemonsInFight, currentPokemon, secondPokemon);
//            if (isFinishTheTurn) {
//                if (isPlayerOnePlay) {
//                    user = "Player Two";
//                    currentPokemon = 1;
//                } else {
//                    user = "Player One";
//                    currentPokemon = 0;
//                    isPlayerOnePlay = true;
//                }
//            }
//            //Check health points
//        }
//
//    }
//
//    private static boolean startMove(int move, Pokemon[] pokemonsInFight, int pokemon, int secondPokemon) {
//        switch (move) {
//            case 1: {
//                System.out.println("Choose which attack");
//                System.out.println("1) kick");
//                System.out.println("2) special attack");
//                int moveAttack = scanner.nextInt();
//                if(moveAttack == 1) {
//                    pokemonsInFight[pokemon].kickAttack(pokemonsInFight[secondPokemon]);
//                } else {
//
//                }
//            }
//        }
//        return true;
//    }
//
//    public static Pokemon[] initPokemonGameInFights(Pokemon[] pokemons) {
//        Random rand = new Random();
//        int randPokemonOne = rand.nextInt(pokemons.length);
//        int randPokemonTwo = rand.nextInt(pokemons.length);
//        Pokemon[] pokemonsInFight = new Pokemon[2];
//        pokemonsInFight[0] = pokemons[randPokemonOne];
//        pokemonsInFight[1] = pokemons[randPokemonTwo];
//
//        return pokemonsInFight;
//    }


    }
}