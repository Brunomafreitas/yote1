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
public class NavioPetroleiro extends Navio{
    
    private float capacidadeCarga;
    
    public NavioPetroleiro(String matricula){
        super(matricula);
    }
    
    public float getCapacidadeCarga(){
        return capacidadeCarga;
    }
    public void setCapacidadeCarga(float capacidadeCarga){
        this.capacidadeCarga = capacidadeCarga;
    }
    
}
