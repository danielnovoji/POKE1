public abstract class Pokemon {
    private String pokemonName;
    private int pokemonType;
    private int level;

    private int maxHP;
    private int maxAP;
    private int currentHP;
    private int currentAP;
    private Attack [] abilities;
    private int pokemonBaseDamage;
    private boolean canEvolve;
    private int counterTriple;



    public Attack[] getAbilities() {
        return abilities;
    } //O(1)

    public Pokemon(String pokemonName, int pokemonType, int level,boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack [] abilities) {  // O(1)
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.level = level;
        this.maxHP = maxHP;
        this.maxAP = maxAP;
        this.currentHP = currentHP;
        this.currentAP = currentAP;
        this.abilities = abilities;
        this.pokemonBaseDamage=1;
        this.canEvolve=canEvolve;
        this.counterTriple = 0;
    }
    public void plusCounterTriple(){ //O(1)
        this.counterTriple++;
    }

    public void printName(){ // O(1)
        System.out.print(this.pokemonName);
    } //O(1)


    public boolean isFirePokemon () { //O(1)
        boolean isFire = true;
        if (this.pokemonType==Constants.ELECTRIC_POKEMON) {
            isFire=false;
        }
        return isFire;
    }

    public boolean attackByAPCost (int attackCost) { //O(1)
        boolean isEnoughAP=true;
        if (this.currentAP<attackCost) {
            isEnoughAP=false;
        }
        return isEnoughAP;
    }

    public void addHP (int hp) { //O(1)
        if (this.currentHP+hp > this.maxHP) {
            this.currentHP = this.maxHP;
        }else {
            this.currentHP+=hp;
        }
    }
    public void addAP (int ap) { //O(1)
        if (this.currentAP+ap > maxAP) {
            this.currentAP = maxAP;
        } else {
            this.currentAP += ap;
        }
    }
    public void removeHP (int hp){ //O(1)
        if (this.currentHP - hp < 0) {
            this.currentHP=0;
        } else {
            this.currentHP -= hp;
        }
    }
    public void removeAP (int ap){ //O(1)
        if (attackByAPCost(ap)){
            this.currentAP -=ap;
        }
    }
    public boolean isAlive() { //O(1)
        boolean isAlive = false;
        if (this.currentHP > 0){
            isAlive=true;
        }
        return isAlive;
    }
    public void resetAP () {
        this.currentAP=0;
    } //O(1)
    public void makeHalfHP () {
        this.currentHP /=2 ;
    } //O(1)
    public void addMaxHP () {
        this.currentHP = this.maxHP;
    } //O(1)
    public void addMaxAP () {
        this.currentAP=this.maxAP;
    } //O(1)

    @Override
    public String toString() { //O(1)
        return  " " + this.pokemonName+ " "  + "Pokemon Type: " + printPokemonType() + " " + "Current level: " + this.level + " " +
                "Current HP: " + this.currentHP + "/" + this.maxHP + " Current AP: " + this.currentAP + "/" + this.maxAP;
    }
    private String printPokemonType () { //O(1)
        String printType= "Fire Pokemon";
        if (this.pokemonType==Constants.ELECTRIC_POKEMON) {
            printType= "Electric Pokemon";
        }
        return printType;
    }

    public int getPokemonBaseDamage() { //O(1)
        return pokemonBaseDamage;
    } //O(1)

    public void setPokemonBaseDamage(int pokemonBaseDamage) {
        this.pokemonBaseDamage = pokemonBaseDamage;
    } //O(1)

    public boolean pokemonCanEvolve (int hp, int ap) { //O(1)
        boolean allowedToEvolve= false;
        if (this.currentHP>=hp && this.currentAP>=ap) {
            allowedToEvolve=true;
        }
        return allowedToEvolve;
    }
    public abstract boolean evolve(int hp, int ap); //O(1)
    public void newStats(String pokemonName, int level,boolean canEvolve, int maxHP, int maxAP) { //O(1)
        this.pokemonName = pokemonName;
        this.level = level;
        this.maxHP = maxHP;
        this.maxAP = maxAP;
        this.pokemonBaseDamage = 1 ;
        this.canEvolve=canEvolve;
    }
    public int getLevel() {
        return level;
    } //O(1)

    public boolean isCanEvolve() {
        return canEvolve;
    } //O(1)
    public void addAttack (Attack ability) { //O(1)
        Attack [] attacks = new Attack[this.abilities.length+1];
        for (int i = 0 ;i < this.abilities.length; i++){
            attacks[i] = this.abilities[i];
        }
        attacks[attacks.length-1]=ability;
        this.abilities=attacks;
    }
    public boolean isEnoughHP () { //O(1)
        boolean isEnough = true;
        if (this.currentHP<(this.maxHP*0.2)){
            isEnough=false;
        }
        return isEnough;
    }
    public abstract void everyRoundPassed(); //O(1)
    public abstract void everyRoundPassedOpponent(); //O(1)
    public abstract void attackSpecialty (); //O(1)
    public abstract int attackSpecialty (Attack attack); //O(1)

    public int getCounterTriple() { //O(1)
        return counterTriple;
    }

    public void setCounterTriple(int counterTriple) {
        this.counterTriple = counterTriple;
    }
}


