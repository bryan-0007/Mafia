package com.mycompany.poo_projeto_v2;
import java.util.*;

public class Caporegime extends Mafioso {
    private ArrayList<Soldier> soldiers;//arraylist onde contem os soldiers de cada caporegime
    
    
    public Caporegime(String name, int ccid){
        super(name,ccid);//vai buscar o nome e o seu ccid a sua super classe
        soldiers=new ArrayList<>();//inicializa a arraylist soldiers
    }
    
    ///////////////////////////////////////////////GETTER/////////////////////////////////7

    public ArrayList<Soldier> getSoldiers() {//vai buscar os soldados dentro da arraylist soldiers
        return soldiers;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////

    public void addSoldiers(Soldier soldier){//adiciona soldados ao arraylist soldiers
        soldiers.add(soldier);
    }
    
    @Override
    public String toString() {//devole o nome do caporegime,o seu ccid,as suas personalidades,probabilidade de ir preso e a sua class
        String texto = "";
        texto += "\nNome: "+ getNome() + "\nCCID: " + getCcid();
        texto += "\nLealdade: "+ getLealdade() + "\nMusculo: " + getMusculo() + "\nInteligencia: " + getInteligencia() + "\nEstratega: " + getEstratega() + "\nCarisma: " + getCarisma();
        texto += "\nProbabilidade de ir preso: " + getProb_preso();
        texto += "\nInformador: " + isInformador();
        texto += "\nClasse: Caporegime\n";
        return texto;
    }
    
}
