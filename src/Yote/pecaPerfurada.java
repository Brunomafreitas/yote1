/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yote;

/**
 *
 * @author senho
 */
public class pecaPerfurada extends peca{
     private pecaPerfurada next;
    public pecaPerfurada(Posicao pos, String nome) {
        super(pos, nome);
    }
    public pecaPerfurada( String nome){
        super(nome);
      
    }
    
    public pecaPerfurada( pecaPerfurada next){
        super(next);
      
    }
    public pecaPerfurada getNext(){
        return next;
    }
    
    public void setNext(pecaPerfurada c){
        next = c;
    }
}
