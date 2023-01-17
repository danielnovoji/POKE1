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



    public Attack[] getAbilities() {
        return abilities;
    }

    public Pokemon(String pokemonName, int pokemonType, int level,boolean canEvolve, int maxHP, int maxAP, int currentHP, int currentAP, Attack [] abilities) {
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
    }

    public void kickAttack (Pokemon affectedPokemon) {
        affectedPokemon.currentHP -=Constants.KICK_ATTACK;

    }
    public boolean isFirePokemon () {
        boolean isFire = true;
        if (this.pokemonType==Constants.ELECTRIC_POKEMON) {
            isFire=false;
        }
        return isFire;
    }

    public boolean attackByAPCost (int attackCost) {
        boolean isEnoughAP=true;
        if (this.currentAP<attackCost) {
            isEnoughAP=false;
        }
        return isEnoughAP;
    }

    public void addHP (int hp) {
        if (this.currentHP+hp > this.maxHP) {
            this.currentHP = this.maxHP;
        }else {
            this.currentHP+=hp;
        }
    }
    public void addAP (int ap) {
        if (this.currentAP+ap > maxAP) {
            this.currentAP = maxAP;
        } else {
            this.currentAP += ap;
        }
    }
    public void removeHP (int hp){
        if (this.currentHP - hp < 0) {
            this.currentHP=0;
        } else {
            this.currentHP -= hp;
        }
    }
    public void removeAP (int ap){
        if (attackByAPCost(ap)){
            this.currentAP -=ap;
        }
    }
    public boolean isAlive() {
        boolean isAlive = false;
        if (this.currentHP > 0){
            isAlive=true;
        }
        return isAlive;
    }
    public void resetAP () {
        this.currentAP=0;
    }
    public void makeHalfHP () {
        this.currentHP /=2 ;
    }
    public void addMaxHP () {
        this.currentHP = this.maxHP;
    }
    public void addMaxAP () {
        this.currentAP=this.maxAP;
    }

    @Override
    public String toString() {
        return  " " + this.pokemonName+ " "  + "Pokemon Type: " + printPokemonType() + " " + "Current level: " + this.level + " " +
                "Current HP: " + this.currentHP + "/" + this.maxHP + " Current AP: " + this.currentAP + "/" + this.maxAP;
    }
    private String printPokemonType () {
        String printType= "Fire Pokemon";
        if (this.pokemonType==Constants.ELECTRIC_POKEMON) {
            printType= "Electric Pokemon";
        }
        return printType;
    }

    public int getPokemonBaseDamage() {
        return pokemonBaseDamage;
    }

    public void setPokemonBaseDamage(int pokemonBaseDamage) {
        this.pokemonBaseDamage = pokemonBaseDamage;
    }

    public boolean pokemonCanEvolve (int hp, int ap) {
        boolean allowedToEvolve= false;
        if (this.currentHP>=hp && this.currentAP>=ap) {
            allowedToEvolve=true;
        }
        return allowedToEvolve;
    }
    public abstract boolean evolve(int hp, int ap);
    public void newStats(String pokemonName, int level,boolean canEvolve, int maxHP, int maxAP) {
        this.pokemonName = pokemonName;
        this.level = level;
        this.maxHP = maxHP;
        this.maxAP = maxAP;
        this.pokemonBaseDamage = 1 ;
        this.canEvolve=canEvolve;
    }
    public int getLevel() {
        return level;
    }

    public boolean isCanEvolve() {
        return canEvolve;
    }
    public void addAttack (Attack ability) {
        Attack [] attacks = new Attack[this.abilities.length+1];
        for (int i = 0 ;i < this.abilities.length; i++){
            attacks[i] = this.abilities[i];
        }
        attacks[attacks.length-1]=ability;
        this.abilities=attacks;
    }
    public boolean isEnoughHP () {
        boolean isEnough = true;
        if (this.currentHP<(this.maxHP*0.2)){
            isEnough=false;
        }
        return isEnough;
    }
    public abstract void everyRoundPassed();
    public abstract void attackSpecialty ();
    public abstract int attackSpecialty (Attack attack);

}


