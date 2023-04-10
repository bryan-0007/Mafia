package com.mycompany.poo_projeto_v2;

import com.mycompany.poo_projeto_v2.Mafioso;

public class UnderBoss extends Mafioso {
    
    private int capital;//dinheiro do underBoss
    
    public UnderBoss(String nome, int ccid){
        super(nome,ccid);
        this.capital = 200;
    }
    
    //////////////////////////////////////////////GETTER E SETTERS////////////////////////////

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {//retorna o nome do UnderBoss, os seus traços de personaliadde e a sua classe
        String texto = "";
        texto += "\nNome: "+ getNome() + "\nCCID= " + getCcid();
        texto += "\nLealdade: "+ getLealdade() + "\nMusculo: " + getMusculo() + "\nInteligencia: " + getInteligencia() + "\nEstratega: " + getEstratega() + "\nCarisma: " + getCarisma();
        texto += "\nClasse: UnderBoss\n";
        return texto;
    }
}
