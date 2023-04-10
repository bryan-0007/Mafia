package com.mycompany.poo_projeto_v2;

import java.util.*;
import java.io.*;

public class Mafia {

    private static final Scanner scan = new Scanner(System.in, "cp1252");//criação de objeto da class scanner para obter o input do utilizador
    private static final Scanner scanner = new Scanner(System.in, "cp1252");//criação de objeto da class scanner para obter o input do utilizador
    private static final Random rand = new Random();//criação de objeto da class random para conseguirmos obter numeros random

    private static Familia temp_fam;//referencia da classe familia para conseguir distinguir entre familias
    private static Mafioso temp_boss;//referencia da classe Mafioso para conseguirmos distinguir entre boss
    private static Caporegime temp_capo;//referencia da classe Caporegime para selecionar um caporegime existente na arraylist caporegimes existente na class boss

    //Criação das 5 famílias
    private static final Familia f1 = new Familia("La Costa Nostra");
    private static final Familia f2 = new Familia("La Costa Parica");
    private static final Familia f3 = new Familia("La Costa Madeira");
    private static final Familia f4 = new Familia("La Costa Calhau");
    private static final Familia f5 = new Familia("Malvinas");

    //criação de 5 bosses um para cada familia
    private static final Mafioso b1 = new Boss("Riccardo", 23423445);
    private static final Mafioso b2 = new Boss("Johnny", 23893445);
    private static final Mafioso b3 = new Boss("Messi", 23427835);
    private static final Mafioso b4 = new Boss("Ronaldo", 23034745);
    private static final Mafioso b5 = new Boss("Adalberto", 28932445);

///////////////////////////////////////////////MENUS INICIAIS/////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    public static void main(String[] args){
        menuEscolheFamilia();//chamamento do MenuEscolheFamilia
    }

    public static void menuEscolheFamilia(){
        int opcao;
        try {
            do {
            //irá fazer enquanto o utlizador nao pressionar 6 para sair do menu
                System.out.println("    [1] La Costa Nostra");
                System.out.println("    [2] La Costa Parica");
                System.out.println("    [3] La Costa Madeira");
                System.out.println("    [4] La Costa Calhau");
                System.out.println("    [5] Malvinas");
                System.out.println("    [6] Sair ");
                System.out.println("\n    Escolha uma das seguintes familias:");
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        familyCreation(f1, b1);
                        menuInicial();//chamamento para o menuInicial
                        break;
                    case 2:
                        familyCreation(f2, b2);
                        menuInicial();//chamamento para o menuInicial
                        break;
                    case 3:
                        familyCreation(f3, b3);
                        menuInicial();//chamamento para o menuInicial
                        break;
                    case 4:
                        familyCreation(f4, b4);
                        menuInicial();//chamamento para o menuInicial
                        break;
                    case 5:
                        familyCreation(f5, b5);
                        menuInicial();//chamamento para o menuInicial
                        break;
                }
                if (opcao > 6) {
                    confirmNotInCase(); // usado para confirmar e prosseguir para a próxima etapa do programa através da key ENTER
                }
            } while (opcao != 6);

        } catch(NoSuchElementException e){
            noSuchElementException();
            menuEscolheFamilia();
        }
    }

    public static void menuInicial(){
        try {
            int opcao;
            do {//irá fazer enquanto o  utlizador nao pressionar 5 para sair do menu
                System.out.println("    Bem vindo ao menu da Mafia, escolha uma das seguintes opções");
                System.out.println("    [1] Menu Boss");
                System.out.println("    [2] Menu Underboss");
                System.out.println("    [3] Menu Consigliere");
                System.out.println("    [4] Menu Familia");
                System.out.println("    [5] Sair ");
                System.out.println("\n    Insira um opção válida:");
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        menuBoss();//chamamento do menuBoss
                        break;
                    case 2:
                        menuUnderBoss();//chamamento do menuUnderBoss
                        break;
                    case 3:
                        menuConsigliere();//chamamento do menuConsiglieri
                        break;
                    case 4:
                        menuFamilia();//chamamento do menuFamilia
                        break;
                }
                if (opcao > 5) {
                    confirmNotInCase(); // usado para confirmar e prosseguir para a próxima etapa do programa através da key ENTER
                }
            } while (opcao != 5);
        }
        catch(NoSuchElementException e){
            noSuchElementException();
            menuInicial();
        }
    }

    public static void menuBoss() {
        try {
            int opcao;
            do {//irá fazer enquanto o utlizador nao pressionar 6 para sair do menu
                System.out.println("    [1] Recruta Soldier");
                System.out.println("    [2] Recruta CapoRegime");
                System.out.println("    [3] Recruta UnderBoss");
                System.out.println("    [4] Gera Negocios para caporegime");
                System.out.println("    [5] Nomear Consiglieri");
                System.out.println("    [6] Sair");
                System.out.println("\n" + "    Introduza opção:");//mudar aqui quando puder !!!!!!!!!!!
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        recrutaSoldier(temp_fam, temp_boss);//chamar a função RecrutaSoldier
                        break;
                    case 2:
                        recrutaCapoRegime(temp_fam, temp_boss);//chamar a função RecrutaCaporegime
                        break;
                    case 3:
                        recrutaUnderBoss(temp_fam);//chamar a função RecrutaUndeBoss
                        break;
                    case 4:
                        geraNegocios(temp_fam, temp_boss);//chamar a função geraNegocios
                        break;
                    case 5:
                        nomeiaConsiglieri(temp_fam);//chamar a função nomeiaConsiglieri
                        break;
                }
                if (opcao > 6) {
                    confirmNotInCase(); // usado para confirmar e prosseguir para a próxima etapa do programa através da key ENTER
                }
            } while (opcao != 6);
        } catch(NoSuchElementException e){
            noSuchElementException();
            menuBoss();
        }
    }

    public static void menuUnderBoss() {
        try {
            int opcao;
            do {//irá fazer enquanto o utlizador nao pressionar 4 para sair do menu
                System.out.println("    [1] Libertar mafioso");
                System.out.println("    [2] Período contabilístico");
                System.out.println("    [3] Loyalty test");
                System.out.println("    [4] Sair");
                System.out.println("\n" + "    Introduza opção");
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        libertaMafioso(temp_fam, temp_fam.getEncarcerados());//chama a funçao libertaMafioso que tem como argumentos a familia e a arraylist de familia encarcerados
                        break;
                    case 2:
                        periodoContabilistico(temp_fam, temp_boss);//chama a função periodoContabilistico
                        break;
                    case 3:
                        temp_boss.probIrPreso(temp_fam.getMafiosos(), temp_fam);
                        temp_boss.serInformador(temp_fam.getMafiosos(), temp_fam);//chama a funçao ser informador na classe Mafioso
                        System.out.println("    ------OBITUARIO---------");
                        System.out.println(temp_fam.getObituario());//imprime a informaçao de todos os mortos
                        System.out.println("    ------ENCARCERADOS---------");
                        System.out.println(temp_fam.getEncarcerados());
                        break;
                }
                if (opcao > 4) {
                    confirmNotInCase(); // usado para confirmar e prosseguir para a próxima etapa do programa através da key ENTER
                }
            } while (opcao != 4);
        }
        catch(NoSuchElementException e){
            noSuchElementException();
            menuUnderBoss();
        }
    }

    public static void menuConsigliere() {
        try {
            int opcao;
            do {//irá fazer enquanto o utlizador nao pressionar 3 para sair do menu
                System.out.println("    [1] Expandir negocio");
                System.out.println("    [2] Mafia Sitdown");
                System.out.println("    [3] sair");
                System.out.println("\n    Introduza opção:");
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        expandirNegocio(temp_fam);//chama a funçao expandir negocio
                        System.out.println(temp_fam.getNegocios());//imprime a informação de todos os negocios
                        break;
                    case 2:
                        //Mafia Sitdown();
                        break;
                }
                if (opcao > 3) {
                    confirmNotInCase(); // usado para confirmar e prosseguir para a próxima etapa do programa através da key ENTER
                }
            } while (opcao != 3);
        } catch(NoSuchElementException e) {
            noSuchElementException();
            menuConsigliere();
        }
    }

    public static void menuFamilia(){
        try {
            int opcao;
            do {//irá fazer enquanto o utlizador nao pressionar 8 para sair do menu
                System.out.println("    [1] Retrato de Familia");
                System.out.println("    [2] Plano de negocios");
                System.out.println("    [3] Mapa de Custos");
                System.out.println("    [4] Espirito de equipa");
                System.out.println("    [5] Obituario");
                System.out.println("    [6] Encarcerados");
                System.out.println("    [7] All out war");
                System.out.println("    [8] Sair da Aplicação");
                System.out.println("\n    Introduza opção");
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        retratoFamilia(temp_fam);//chama a funçao retratofamilia
                        break;
                    case 2:
                        planoNegocios(temp_fam);//chama a funçao planoNegocios
                        break;
                    case 3:
                        mapaCustos(temp_fam);//chama a função mapaCustos
                        break;
                    case 4:
                        System.out.println("\n    Introduza o nome do Caporegime da qual quer inserir o Soldier: ");
                        String nome = scan.next();//faz scan do input do utilizador
                        for (int i = 0; i < ((Boss) temp_boss).getRegimes().size(); i++) {//chamento do arraylist regimes atraves de um downcast de boss para mafiosos onde ocorre num for loop onde vai procurar se o nome do caporegime vai ser igual ao do input do utilizador
                            if (((Boss) temp_boss).getRegimes().get(i).getNome().equalsIgnoreCase(nome)) {
                                temp_capo = ((Boss) temp_boss).getRegimes().get(i);
                                break;
                            }
                        }
                        espirito_de_equipa(temp_capo);//chamamento da função espirito
                        break;
                    case 5:
                        obituario(temp_fam);//chamamento da função obituario
                        break;
                    case 6:
                        encarcerados(temp_fam);//chamamento da função encarcerados
                        break;
                    case 7:
                        //All out war();
                        break;
                }
                if (opcao > 8) {
                    confirmNotInCase(); // usado para confirmar e prosseguir para a próxima etapa do programa através da key ENTER
                }
            } while (opcao != 8);
        }
        catch(NoSuchElementException e) {
            noSuchElementException();
            menuFamilia();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void recrutaSoldier(Familia familia, Mafioso boss) {
        System.out.println("\n    Introduza o nome do Caporegime da qual quer inserir o Soldier: ");
        String nome = scan.next();//da scan no input do utilizador
        for (int i = 0; i < ((Boss) temp_boss).getRegimes().size(); i++) {//chamento do arraylist regimes atraves de um downcast de boss para mafiosos onde ocorre num for loop onde vai procurar se o nome do caporegime vai ser igual ao do input do utilizador
            if (((Boss) temp_boss).getRegimes().get(i).getNome().equalsIgnoreCase(nome)) {
                temp_capo = ((Boss) temp_boss).getRegimes().get(i);
                break;
            }
        }
        System.out.println("    Insira o nome do Soldier: ");
        String nome2 = scan.next();//da scan do input do nome
        System.out.println("    Insira o ccid do Soldier: ");
        int numero = scan.nextInt();//da scan do input do soldier
        int length = String.valueOf(numero).length();
        Soldier s1 = new Soldier(nome2, numero);//criação do objeto soldier tendo como parametros o nome e o ccid que utilizador deu 
        temp_capo.addSoldiers(s1);//adicionamos o soldier á equipa do caporegime intronduzindo o na arrayList soldier situada na classe CapoRegime
        familia.addMafiosos(s1);//adicionar o soldier a arraylist mafiosos onde tem todos os membros da familia
        System.out.println("    Recrutamento com sucesso!");
        System.out.println("\n    Equipa da qual o Soldier pertence: \n    " + ((Boss) boss).equipaCaporegime(temp_capo));//mostra a equipa de onde o soldier pertence
        System.out.println(temp_capo.getSoldiers());//mostra a equipa do caporegime
    }

    public static void recrutaCapoRegime(Familia familia, Mafioso boss) {
        System.out.println("    Insira o nome do CapoRegime: ");
        String nome = scan.next();//da scan do input do nome
        System.out.println("    Insira o ccid do CapoRegime");
        int numero = scan.nextInt();//da scan do input do soldier
        Caporegime z1 = new Caporegime(nome, numero);//criação do objeto caporegime tendo como parametros o nome e o ccid que o utilizador deu
        ((Boss) boss).addRegimes(z1); // downcast de Mafioso para Boss, porque boss é do tipo estático e para aceder a um metodo de Boss(subclasse de mafioso) que não faz override com o metodo de Mafioso, somente usando downcast.
        familia.addMafiosos(z1);//adicionar o caporegime a arraylist mafiosos onde tem todos os membros da familia
        System.out.println("    Recrutamento com sucesso!");
        System.out.println(((Boss) boss).getRegimes());//mostra todos os caporegimes
    }

    public static void recrutaUnderBoss(Familia familia) {
        System.out.println("    Insira o nome do UnderBoss: ");
        String nome = scan.next();//da scan do input do nome
        System.out.println("    Insira o ccid do UnderBoss: ");
        int numero = scan.nextInt();//da scan do input do soldier
        Mafioso u1 = new UnderBoss(nome, numero);//criação do objeto UnderBoss tendo como parametros o nome e o ccid que utilizador deu 
        familia.addMafiosos(u1);//adicionar o UnderBoss a arraylist mafiosos onde tem todos os membros da familia
        System.out.println("    Recrutamento com sucesso!");
    }

    public static void obituario(Familia familia) {
        System.out.println("    Obituário: \n" + familia.getObituario());//vai buscar a arraylist obituario na classe familia e imprime todos os mortos da familia
    }

    public static void espirito_de_equipa(Mafioso capo) {
        System.out.println("    Espírito de equipa: \n" + capo + "\n" + ((Caporegime) capo).getSoldiers());//imprime a informação da equipa de um caporegime buscando a arraylist soldiers na classe caporegime
    }

    public static void encarcerados(Familia familia) {
        System.out.println("    Espírito de equipa: \n" + familia.getEncarcerados());//vai buscar a arraylist encarcerados na classe familia e imprime todos os presos da familia
    }

    private static int defineNumeroNegocios(Mafioso temp_boss) {// gera numero de negocios
        int carisma_boss = temp_boss.getCarisma();//vai buscar o carisma do boss
        int numero_de_negocios = rand.nextInt(4) + 1;//atribui um número aleatório a esta variável que vai ser o número de negócios
        if (carisma_boss > 65) {
            return numero_de_negocios += rand.nextInt(3);//se o carisma do boss for superior que 65 o numero de negocios irá aumentar do que seria susposto ser
        } else {
            return numero_de_negocios;//se for menor que 65 o numero de negocios irá manter se segundo a variavel defenida
        }
    }

    public static void libertaMafioso(Familia familia, ArrayList<Mafioso> encarcerados) {
        familia.setRiqueza_acumulada(familia.getRiqueza_acumulada() - (familia.getCustos_preso()));//atualizamos a riqueza da familia atraves do metodo setRiquezaacumulada retirado da classe Familia onde retiramos o valor da variavel custo_preso atraves da chamada do metodo getCustoPreso na classe familia
        System.out.println("    Libertado com sucesso o " + familia.getEncarcerados().get(0));//print do nome do preso libertado que neste caso vai ser o mafioso que estará na primeira posição da arraylist encarcerados que situa se na classe familia
        encarcerados.remove(0);//remoçao do presioneiro da arraylist encarcerados
    }

    public static void associates_sem_linhagem(Familia familia) {
        try {
            FileReader inStream = new FileReader("associates_sem_linhagem.txt");//abre stream de leitura
            BufferedReader bR = new BufferedReader(inStream);//reduçao do número de acessos ao ficheiro

            String linha = bR.readLine();//leitura de linhas de caractere
            String nomeAs;
            int numeroccid;

            while (linha != null) {//enquanto a linha for diferente de null irá correr buscando o nome e o ccid de cada associado

                linha = bR.readLine();
                nomeAs = String.valueOf(linha);//passagem de string para string

                linha = bR.readLine();
                numeroccid = Integer.parseInt(linha);//passagem de string para int

                Associate ass = new Associate(nomeAs, numeroccid);//criação de um associate sem linhagem com o nome e ccid dos ficheiros
                familia.addAssociadosSemLinhagem(ass);//adicionar a arraylist de associados sem linhagem
                familia.addAssociados(ass);//adicionar a arraylist de associados

                System.out.println("\n");
                linha = bR.readLine();
            }
            bR.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void associates_com_linhagem(Familia familia){
        try {
            FileReader inStream = new FileReader("associados_com_linhagem.txt");//abre stream de leitura
            BufferedReader bR = new BufferedReader(inStream);//reduçao do número de acessos ao ficheiro

            String linha = bR.readLine();//leitura de linhas de caratere
            String nomeAs;
            int numeroccid;

            while (linha != null) {//enquanto a linha for diferente de null irá correr buscando o nome e o ccid de cada associado

                linha = bR.readLine();
                nomeAs = String.valueOf(linha);//passagem de string para string

                linha = bR.readLine();
                numeroccid = Integer.parseInt(linha);//passagem de string para int

                Associate ass = new Associate(nomeAs, numeroccid);//criaçao de um associate com linhagem com o seu nome e ccid dos ficheiros
                familia.addMafiosos(ass);//adiocar a arraylist de mafiosos onde contem todos os mafiosos
                familia.addAssociados(ass);//adicionar a arraylist de associados

                System.out.println("\n");
                linha = bR.readLine();
            }
            bR.close();//para fechar a stream
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void geraNegocios(Familia familia, Mafioso maf) {
        System.out.println("    Insira os negócios");
        for (int i = 0; i < defineNumeroNegocios(temp_boss); i++) {//ira pedir ao utilizador para inserir um certo número de negócios consoante for o valor do defineNumeroNegocios
            System.out.println("    Insira o nome do negocio");
            String nome = scan.next();//da scan do nome dos negocios 
            Negocio n = new Negocio(nome);//criaçao de um objeto do tipo negocios tendo como parametro o nome que o utilizador inseriu
            familia.addNegocios(n);//adiciona o objeto negocio a arryalist negocios onde contem todos os negocios
            familia.getCaponegocios().put(n, (((Boss) maf).getRegimes()));//cada negócio irá ter um conjunto de caporegimes
            familia.getAssonegocios().put(n, familia.getAssociados());//cada negócio irá ter um conjunto de associates
        }
        System.out.println(familia.getCaponegocios());//imprime a informaçao do HasHMap onde contem um negócio com os seus caporegimes associados
        System.out.println(familia.getAssonegocios());//imprime a informaçao do HasHMap onde contem um negócio com os seus associates associados
    }

    public static void periodoContabilistico(Familia f, Mafioso b) { // "Recolhe" os pagamentos de cada negocio, os custos dos presos e da polícia  para a riqueza acumulada da familia 
        for (int i = 0; i < f.getNegocios().size(); i++) {  // percorre o loop da ArrayList<Negocio> negocios da classe Familia
            f.setRiqueza_acumulada(f.getRiqueza_acumulada() + f.getNegocios().get(i).getPagamentos()); // Aumenta a riqueza acumulada da familia de acordo com os pagamentos(rendimentos) do negocio
            int k = f.getNegocios().get(i).getPagamentos(); // guarda o valor dos pagamentos na variável k
            f.setRiqueza_acumulada(f.getRiqueza_acumulada() - (f.getCustoPoliciaTotal(f.getNegocios()) + f.getCustos_preso())); // Diminui a riqueza acumulada da familia de acordo com os custos da policia e dos presos
            int x = f.getCustoPoliciaTotal(f.getNegocios()) + f.getCustos_preso(); // guarda o valor dos custos da familia
            if (x > k) { // Se os custos forem maiores que os pagamentos, entao retiramos capital ao UnderBoss como castigo do Boss
                for (int j = 0; j < f.getMafiosos().size(); j++) { // percorrer um loop dentro da ArrayList<Mafiosos> mafiosos da classe familia
                    if (f.getMafiosos().get(j) instanceof UnderBoss) { // se o Mafioso for uma instância de UnderBoss
                        ((UnderBoss) f.getMafiosos().get(j)).setCapital(((UnderBoss) f.getMafiosos().get(j)).getCapital() - 50); // então diminui-se o capital do UnderBoss em 50
                    }
                }
            }
        }
        b.serInformador(f.getMafiosos(), f); // verificar se existe um informador entre os mafiosos caso exista então ele é adicionado à ArrayList<Mafioso> obituario
    }

    public static void nomeiaConsiglieri(Familia f) { // nomeia um consiglieri para a familia escolhida
        System.out.println("    ----------------COM LINHAGEM---------------");
        System.out.println(f.getMafiosos()); // Imprime os mafiosos dessa familia inclusive os associados com linhagem
        System.out.println("    -------------SEM LINHAGEM---------------");
        System.out.println(f.getAssociados_sem_linhagem()); // Imprime os associados sem linhagem
        System.out.println("\n    Selecione um destes nomes");
        String nome = scan.next(); // input de um dos nomes ja existentes como objetos  
        Consiglieri cons; // referência de um objeto Consiglieri

        for (int i = 0; i < f.getMafiosos().size(); i++) { // percorrer um loop dentro da ArrayList<Mafiosos> mafiosos da classe familia
            if (f.getMafiosos().get(i).getNome().equalsIgnoreCase(nome) && f.getMafiosos().get(i) instanceof Associate) { // verificar se o nome do objeto percorrido no loop é o mesmo que o nome inserido e veerificar se o objeto é uma instância da classe Associate
                cons = new Consiglieri(f.getMafiosos().get(i).getNome(), f.getMafiosos().get(i).getCcid()); // criar um objeto Consiglieri com o mesmo nome e ccid do objeto percorrido no loop
                f.setConsiglieri(cons); // definir o objeto cons como atributo da familia escolhida
                f.getMafiosos().remove(i); // remover o objeto que percorreu o loop da ArrayList<Mafiosos> mafiosos dessa mesma ArrayList
                f.getMafiosos().add(0, cons); // adicionar o objeto cons no inicio da ArrayList<Mafiosos> mafiosos de modo a evitar loops infinitos
            }
        }

        for (int i = 0; i < f.getAssociados_sem_linhagem().size(); i++) { // percorrer um loop dentro da ArrayList<Mafiosos> associados_sem_linhagem da classe familia
            if (f.getAssociados_sem_linhagem().get(i).getNome().equalsIgnoreCase(nome) && f.getAssociados_sem_linhagem().get(i) != null) { // verificar se o nome do objeto percorrido no loop é o mesmo que o nome inserido e veerificar se o objeto é uma instância da classe Associate
                cons = new Consiglieri(f.getAssociados_sem_linhagem().get(i).getNome(), f.getAssociados_sem_linhagem().get(i).getCcid()); // criar um objeto Consiglieri com o mesmo nome e ccid do objeto percorrido no loop
                f.setConsiglieri(cons);
                f.getAssociados_sem_linhagem().remove(i); // remover o objeto que percorreu o loop da ArrayList<Associate> associados_sem_linhagem dessa mesma ArrayList
                f.getMafiosos().add(0, cons); // definir o objeto "cons" como atributo da familia escolhida
                for (int j = 0; j < f.getMafiosos().size(); j++) { // Percorre um loop sobre a ArrayList<Mafioso> mafiosos 
                    f.getMafiosos().get(j).setLealdade(f.getMafiosos().get(j).getLealdade() - 10); // Diminuir ou redifinir a Lealdade de cada um dos mafiosos
                }
            }
        }
        System.out.println(f.getConsiglieri()); // Imprimir o Consiglieri da familia
    }

    public static void expandirNegocio(Familia f) { // Expande o negocio escolhido, ou seja, aumenta as receitas do negocio, neste caso, os pagamentos de cada negocio consoante o número de estratega do Consiglieri
        System.out.println("    Escolha um deste negocios para expandi-lo");
        String nome = scan.next(); // lê o input que escolhe o negócio a expandir
        for (int i = 0; i < f.getNegocios().size(); i++) { // loop na ArrayList<Negocio> da classe Familia
            if (f.getNegocios().get(i).getNome_negocio().equalsIgnoreCase(nome)) { // Verifica se o input inserido corresponde ao objeto que é percorrido na ArrayList<Negocio>
                if (f.getConsiglieri().getEstratega() == 0) { // quando o número de Estratega do Consiglieri é zero, então
                    f.getNegocios().get(i).setPagamentos(f.getNegocios().get(i).getPagamentos() + 100); // o pagamento desse negocio aumenta em 100
                }
                if (f.getConsiglieri().getEstratega() <= 40) { // quando o número de Estratega do Consiglieri é maior que zero e menor ou igual que 40, então
                    f.getNegocios().get(i).setPagamentos(f.getNegocios().get(i).getPagamentos() + 200); // o pagamento desse negocio aumenta em 200
                }
                if (f.getConsiglieri().getEstratega() > 40) { //quando o número de Estratega do Consiglieri é maior que 41, então
                    f.getNegocios().get(i).setPagamentos(f.getNegocios().get(i).getPagamentos() + 300); // o pagamento desse negocio aumenta em 300
                }
            }
        }
    }

    public static void retratoFamilia(Familia f) { // Imprime o nome da familia, todos os mafiosos da familia, todos os mortos da familia, todos os encarcerados da familia, os custos a pagar, as receitas e o nome dos negocios.
        System.out.println(f);
    }

    public static void mapaCustos(Familia f) { // Imprime os custos da familia
        System.out.println("\n    Custos de um preso: " + f.getCustos_preso() + "\n    Custos da policia: " + f.getCustoPoliciaTotal(f.getNegocios()));
    }

    public static void planoNegocios(Familia f) { // Imprime os rendimentos de cada negócio e os caporegimes e associates de cada negócio
        System.out.println(f.getNegocios() + "\n    Caporegimes do negocio: " + f.getCaponegocios() + "\n    Associates do negocio: " + f.getAssonegocios());
    }

    public static void confirmNotInCase(){ // Método que usado para confirmar e prosseguir para a etapa seguinte através da key ENTER
        System.out.println("\n\n    Opção inválida, escolha uma das opções, carregue em ENTER para proseguir\n\n");
        scanner.nextLine();
        scan.nextLine();
    }

    public static void noSuchElementException(){ // Método que usado para confirmar e prosseguir para a etapa seguinte através da key ENTER
        System.out.println("\n\n    Opção inválida, insira um número dentro das opções, carregue em ENTER para proseguir\n\n");
        scanner.nextLine();
        scan.nextLine();
    }

    public static void familyCreation(Familia temp_fam, Mafioso temp_boss){
        temp_fam.addMafiosos(temp_boss);//introduçao do boss na arraylist mafiosos onde contem todos os membros da familia
        associates_sem_linhagem(temp_fam);//criaçao de objetos associados sem linhagem e adicionamente na arraylist associados onde contem todos os associados e na arraylisr associados sem linhagem
        associates_com_linhagem(temp_fam);//criacao de objetos associados com linhagem e adicionados na arraylist mafiosos da classe familia e adicionados na arraylist associados onde contem todos os associados
        menuInicial();//chamamento para o menuInicial
    }
}
