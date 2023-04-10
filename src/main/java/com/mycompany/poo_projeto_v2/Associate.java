package com.mycompany.poo_projeto_v2;

public class Associate extends Mafioso{
 
    public Associate(String name,int ccid){
        super(name,ccid);//chamamento da super classe para ir buscar o nome e o seu ccid
    }

    public String toString() {//retorna o nome, o ccid, a personalidade, a probabilidade de ir preso e a sua classe
        String texto = "";
        texto += "\nNome: "+ getNome() + "\nCCID: " + getCcid();
        texto += "\nLealdade: "+ getLealdade() + "\nMusculo: " + getMusculo() + "\nInteligencia: " + getInteligencia() + "\nEstratega: " + getEstratega() + "\nCarisma: " + getCarisma();
        texto += "\nProbabilidade de ir preso: " + getProb_preso();
        texto += "\nInformador: " + isInformador();
        texto += "\nClasse: Associate\n";
        return texto;
    }
  
}
