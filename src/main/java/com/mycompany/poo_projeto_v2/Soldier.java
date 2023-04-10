package com.mycompany.poo_projeto_v2;

import com.mycompany.poo_projeto_v2.Mafioso;


public class Soldier extends Mafioso{
    
    public Soldier(String name, int ccid){
        super(name,ccid); 
    }
    
    @Override
    public String toString() {//devolve o nome do soldier, o seu ccid,a sua personalidae,probabilidade de ir preso e a sua classe
        String texto = "";
        texto += "\nNome: "+ getNome() + "\nCCID= " + getCcid();
        texto += "\nLealdade: "+ getLealdade() + "\nMusculo: " + getMusculo() + "\nInteligencia: " + getInteligencia() + "\nEstratega: " + getEstratega() + "\nCarisma: " + getCarisma();
        texto += "\nProbabilidade de ir preso: " + getProb_preso();
        texto += "\nInformador: " + isInformador();
        texto += "\nClasse: Soldier\n";
        return texto;
    }
}
