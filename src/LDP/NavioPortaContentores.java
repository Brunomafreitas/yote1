/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LDP;

/**
 *
 * @author senho
 */
public class NavioPortaContentores extends Navio {
    int noMaxContentores;
    
    public NavioPortaContentores(String matricula){
        super(matricula);
    }
    
    public int getNoMaxContentores(){
        return noMaxContentores;
    }
    
    public void setNoMaxContentores(int noMaxContentores){
        this.noMaxContentores = noMaxContentores;
    }
    
}
