/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author montse
 */
public class Player {
    static int MAXLEVEL=10;
    private String name;
    private int level;
    private boolean dead=true;
    private BadConsequence pendingBadConsequence= new BadConsequence("vacio",0,0,0);;
    private ArrayList <Treasure> hiddenTreasures = new ArrayList();
    private ArrayList <Treasure> visibleTreasures = new ArrayList();
    
    public Player(String name){
        this.name=name;
    }
    public String getName(){return name;}
    
    private void bringToLife(){
        dead=false;
        level = 1;
        hiddenTreasures.clear();
        visibleTreasures.clear();
    }
    private int getCombatLevel(){
        int combatLevel=level;
        
        for(Treasure v: visibleTreasures){
            combatLevel+=v.getBonus();
        }
        
        return combatLevel;
    }
    private void incrementLevels(int l){
        level += l;
    }
    private void decrementLevels(int l){
        level -= l;
        if(level < 1){
            level = 1;
        }
    }
    private void setPendingBadConsequence(BadConsequence b){
       pendingBadConsequence = new BadConsequence(b);
    }
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        Treasure treasure;

        CardDealer dealer;
        dealer = CardDealer.getInstance();
        for(int i=0; i<nTreasures; i++){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);

        BadConsequence pendingBad;
        pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    private int howManyVisibleTreasures(TreasureKind tKind){
        int contador=0;      
        for(Treasure v :visibleTreasures){
            if(v.getType() == tKind){
                contador+=1;
            }
        }  
        return contador;
    }
    private void dieIfNoTreasures(){
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()){
            dead = true;
        }
    }
    public boolean isDead(){
        return dead;
    }
    public ArrayList <Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    public ArrayList <Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    public CombatResult combat(Monster m){
        CombatResult combat;
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        if(myLevel>monsterLevel){
            applyPrize(m);
            if(level == MAXLEVEL)
                combat = CombatResult.WINGAME;
            else
                combat = CombatResult.WIN;
        }
        else{
            applyBadConsequence(m);
            combat = CombatResult.LOSE;
        }
        return combat;
    }
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        dieIfNoTreasures();
    }
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        dieIfNoTreasures();
    }
    public boolean validState(){
        if(pendingBadConsequence.isEmpty() && hiddenTreasures.size() <= 4)
            return true;
        else
            return false;
    }
    public void initTreasures(){
    }
    public int getLevels(){
        return level;
    }
    public void discardAllTreasures(){
        for(Treasure t:visibleTreasures){
            discardVisibleTreasure(t);
        }
        
        for(Treasure t:hiddenTreasures){
            discardHiddenTreasure(t);
        }
    }
    public boolean canMakeTreasureVisible(Treasure t){
        boolean posible = true;
        int numManos=0;
        for(int i=0; i<visibleTreasures.size() && posible; i++){
            if(t.getType() == TreasureKind.HELMET){
                if(visibleTreasures.get(i).getType() == TreasureKind.HELMET){
                    posible = false;
                }
            }
            if(t.getType() == TreasureKind.ARMOR){
                if(visibleTreasures.get(i).getType() == TreasureKind.ARMOR){
                    posible = false;
                }
            }
            if(t.getType() == TreasureKind.SHOES){
                if(visibleTreasures.get(i).getType() == TreasureKind.SHOES){
                    posible = false;
                }
            }
            if(t.getType() == TreasureKind.BOTHHANDS){
                if(visibleTreasures.get(i).getType() == TreasureKind.ONEHAND ||
                       visibleTreasures.get(i).getType() == TreasureKind.BOTHHANDS){
                    posible = false;
                }
            }
            if(t.getType() == TreasureKind.ONEHAND){
                if(visibleTreasures.get(i).getType() == TreasureKind.ONEHAND){
                    numManos++;
                    if(numManos >=2){
                        posible = false;
                    }
                }
                if(visibleTreasures.get(i).getType() == TreasureKind.BOTHHANDS){
                    posible = false;
                }
            }
        }
        return posible;
    }
    public void makeTreasureVisible(Treasure t){
        boolean canI = canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
}
