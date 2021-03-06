/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Minim
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badconsequence;
    private int levelAgainstCultistPlayer;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        combatLevel = level;
        this.prize = prize;
        badconsequence = bc;
        levelAgainstCultistPlayer=0;
    }
    
    
    public Monster(String name, int level, BadConsequence bc, Prize prize, int lC){
        this.name = name;
        combatLevel = level;
        this.prize = prize;
        badconsequence = bc;
        levelAgainstCultistPlayer=lC;
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return combatLevel + levelAgainstCultistPlayer;
    }
    
    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }
    
    //EXAMEN
    public int getCombatLevel(Player aPlayer){
        return getCombatLevel();
    }
    
    public int getCombatLevelAgainstCultistPlayer(Player aPlayer){
        return combatLevel + levelAgainstCultistPlayer;
    }
    
    //EXAMEN
    
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    public BadConsequence getBadConsequence() {
        return badconsequence;
    }
    //toString
    @Override
    public String toString(){
        return "\nCARTA DE MONSTRUO" 
                + "\nNombre: " + name
                + "\nNivel de combate: "+ Integer.toString(combatLevel)
                + "\nPremio: " + prize.toString()
                + "\nMal rollo: " + badconsequence.toString();
    }
}
