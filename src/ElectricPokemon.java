public abstract class ElectricPokemon extends Pokemon {
    private int electricity;

    public ElectricPokemon(String pokemonName, int pokemonType, int level, boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[] abilities) { //O(1)
        super(pokemonName, pokemonType, level,canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);
        this.electricity = 0;
    }


    public void charge() { //O(1)
        this.electricity += 5;
    }

    @Override
    public void attackSpecialty() {} //O(1)
    public int attackSpecialty(Attack attack) { //O(1)
        int damageOpponent = 0;
        damageOpponent = attack.minMaxDamageRandomizer();
        if (this.electricity>0) {
            damageOpponent += (damageOpponent*(this.electricity/100));
        }
        return damageOpponent;
    }
    public void everyRoundPassed(){ //O(1)
        charge();
        hpCheckerForChargeAttack();
    }
    public void everyRoundPassedOpponent() {
        hpCheckerForChargeAttack();
    } //O(1)

    private void hpCheckerForChargeAttack () { //O(1)
        if (!isEnoughHP()) {
            this.electricity=0;
            System.out.println("You have less than 20% of your max HP, your charge has been reset.");
        }
    }
    @Override
    public String toString() {
        return super.toString()+ " Electricity Charge: " + this.electricity;
    } //O(1)
}
