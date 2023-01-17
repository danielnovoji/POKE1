public abstract class ElectricPokemon extends Pokemon {
    private int electricity;

    public ElectricPokemon(String pokemonName, int pokemonType, int level, boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack[] abilities) {
        super(pokemonName, pokemonType, level,canEvolve, maxHP, maxAP, currentHP, currentAP, abilities);
        this.electricity = 0;
    }


    public void charge() {
        this.electricity += 5;
    }
    public void attackWithCharge (Attack attack){ //might be needed to be changed
        if (this.electricity>0) {
            int damageOpponent = attack.minMaxDamageRandomizer();
            damageOpponent += (damageOpponent*(this.electricity/100));
            removeHP(damageOpponent);
        }
    }

    @Override
    public void attackSpecialty() {}
    public int attackSpecialty(Attack attack) {
        int damageOpponent = 0;
        if (this.electricity>0) {
            damageOpponent = attack.minMaxDamageRandomizer();
            damageOpponent += (damageOpponent*(this.electricity/100));
        }
        return damageOpponent;
    }
    public void everyRoundPassed(){
        charge();
        hpCheckerForChargeAttack();
    }

    private void hpCheckerForChargeAttack () {
        if (!isEnoughHP()) {
            this.electricity=0;
            System.out.println("You have less than 20% of your max HP, your charge has been reset.");
        }
    }
    @Override
    public String toString() {
        return super.toString()+ " Electricity Charge: " + this.electricity;
    }
}
