package com.mycompany.poo_projeto_v2;

public class Consiglieri extends Mafioso{
    
    
    public Consiglieri(String name,int ccid){
        super(name,ccid);//vai buscar o nome e o seu ccid a sua super classe
    }
    
    @Override
    public String toString() {//retorna o nome do consiglier, o seu ccid, a sua personalidade, a probabiliade de ir preso e a sua classe
        String texto = "";
        texto += "\nNome: "+ getNome() + "\nCCID: " + getCcid();
        texto += "\nLealdade: "+ getLealdade() + "\nMusculo: " + getMusculo() + "\nInteligencia: " + getInteligencia() + "\nEstratega: " + getEstratega() + "\nCarisma: " + getCarisma();
        texto += "\nProbabilidade de ir preso: " + getProb_preso();
        texto += "\nInformador: " + isInformador();
        texto += "\nClasse: Consiglieri\n";
        return texto;
    }
    
}
