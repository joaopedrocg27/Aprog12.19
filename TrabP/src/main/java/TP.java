import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class TP {
    static Scanner sc2 = new Scanner (System.in);
    public static void printMenu(){
        System.out.println("1-Ler a informação disponível no ficheiro de texto e armazená-la em memória");
        System.out.println("2-Inserir manualmente informação de uma seleção (Exemplo: B,Portugal,3,1,2,0,5,4)");
        System.out.println("3-Calcular e armazenar em memória a pontuação de todas as equipas.");
        System.out.println("4-Calcular e armazenar em memória a classificação de todas as equipas nos respetivos grupos.");
        System.out.println("5-Listar a classificação das equipas por grupo;");
        System.out.println("6-Listar as equipas cujos golos marcados é igual ao máximo de golos marcados");
        System.out.println("7-Listar as equipas com um determinado número de golos sofridos. Insira o número de golos");
        System.out.println("8-Listar as equipas que têm mais golos sofridos do que golos marcados, ordenadas alfabeticamente");
        System.out.println("9-Listar o primeiro classificado de cada grupo");
        System.out.println("10-Listar informação completa de uma equipa insira o número de golos");
        System.out.println("11-Criar um ficheiro de texto (Statistics.txt) com estatísticas dos jogos");
        System.out.println("12-Remover da memória as equipas que não vão disputar a fase seguinte");
        System.out.println("13-Criar um ficheiro de texto (FinalStage.csv) com as equipas que vão disputar a fase seguinte do campeonato");
        System.out.println("14-Criar um ficheiro de texto (FinalStageGames.txt) com os jogos da fase final. ");
        System.out.println("15-Sair");
    }
    public static void menu(String[][] equipaGrupo,int limite,int[] pontuacao) throws FileNotFoundException{
        int M=sc2.nextInt();
        boolean jaLido = false;
        while(!(M==15)){
        switch (M){
            case 1:
                limite=lerFicheiro(equipaGrupo)+1;
                jaLido=true;
               // printMenu();
                break;
            case 2:
                if(!jaLido){System.out.println("ATENÇÃO! Ficheiro inda não lido (opção 1)");
                    System.out.println("");
                }else{
                lerManualmente (equipaGrupo,limite);
                jaLido=true;
                printMenu();
                }
                break;
            case 3 :
                if(!jaLido){System.out.println("ATENÇÃO! Ficheiro inda não lido (opção 1)");
                    System.out.println("");
                }else{
                calcularPontuacao(equipaGrupo,limite,pontuacao);    
                printMenu();
                break;
                }
            case 4 :
                if(!jaLido){System.out.println("ATENÇÃO! Ficheiro inda não lido (opção 1)");
                    System.out.println("");
                }else{
                ordenar(equipaGrupo,limite,pontuacao);
                printMenu();
                }
            case 5 :
//              imprimirGrupo(equipaGrupo,pontuacao,limite);
                printMenu();
                break;
            case 6 :
                //missing
                printMenu();
                break;
            case 7 :
                //missing
                printMenu();
                break;
            case 8:
                //missing
                printMenu();
                break;
            case 9:
                //missing
                printMenu();
                break;
            case 10:
                //missing
                printMenu();
                break;
            case 11:
                //missing
                printMenu();
                break;
            case 12:
                //missing
                printMenu();
                break;
            case 13:
                //missing
                printMenu();
                break;
            case 14:
                //missing
                printMenu();
                break;  
            case 15:
                break;
            default:
                System.out.println("Erro: Opção inválida");
                break;
        }
    M=sc2.nextInt();
    }
    }
    public static void main (String[] args) throws FileNotFoundException{
            String [][] equipaGrupo = new String [32][8];
            int limite=0;
           // limite=lerFicheiro(equipaGrupo);
           //limite++;
            int []pontuacao=new int[limite];
            calcularPontuacao(equipaGrupo,limite,pontuacao);
            
            ordenar(equipaGrupo,limite,pontuacao);
            System.out.println("Mau mau");
            printMenu();
            menu(equipaGrupo,limite,pontuacao);
    }
    public static int lerFicheiro (String[][] equipaGrupo) throws FileNotFoundException {
        File file = new File("PracticalWork.csv");
        Scanner sc = new Scanner(file);
        sc.nextLine();
        int cont=0,i=0;
        while (sc.hasNextLine()){
            while (i<=cont){
               equipaGrupo[i] = sc.nextLine().split(",");
                i++;
            }
            cont++;
            
        }
        cont--;
        cont = lerManualmente(equipaGrupo,cont);
        return cont;
        }
    public static int lerManualmente (String[][] equipaGrupo,int limite){
        System.out.println("Quer adicionar mais equipas?");
        System.out.println("Se sim,escrever 'Y'");
        String resposta = sc2.nextLine();
        while (resposta.equals("Y")){
        for (int i=limite;i<=32;i++){
            boolean r;
            if (equipaGrupo[i][0]==(null)){
                System.out.println("Insira o nome da equipa");
                r=verificarRepetição(equipaGrupo,i,limite);
                if (r){
                    break;
                }
                System.out.println("Insira o grupo da equipa");
                equipaGrupo[i][0]=sc2.nextLine();
                System.out.println("Insira o número de jogos da equipa");
                equipaGrupo[i][2]=sc2.nextLine();
                System.out.println("Insira o número de vitórias da equipa");
                equipaGrupo[i][3]=sc2.nextLine();
                System.out.println("Insira o número de empates da equipa");
                equipaGrupo[i][4]=sc2.nextLine();
                System.out.println("Insira o número de derrotas da equipa");
                equipaGrupo[i][5]=sc2.nextLine();
                System.out.println("Insira o número de golos marcados da equipa");
                equipaGrupo[i][6]=sc2.nextLine();
                System.out.println("Insira o número de golos sofridos da equipa");
                equipaGrupo[i][7]=sc2.nextLine();
                limite++;
                break;
            }
        
        }
        System.out.println("Quer adicionar mais equipas?");
        System.out.println("Se sim,escrever 'Y'");
        resposta = sc2.nextLine();
        }
    printMenu();
    return limite;   
    }
    public static boolean verificarRepetição(String[][]equipaGrupo,int i1,int limite){
        String resposta=sc2.nextLine();
       boolean r=false;
        for (int i=0;i<limite;i++){
           r= resposta.equals(equipaGrupo[i][1]);
            if (resposta.equals(equipaGrupo[i][1])){
                System.out.println("A equipa já foi inserida");
                break;
                
            }else{
                equipaGrupo[i1][1]=resposta;
            }
        }

        return r;
    }
    public static void calcularPontuacao(String[][]equipaGrupo,int limite,int [] pontuacao){
        
        for (int i=0;i<limite;i++){
            pontuacao[i]=(Integer.parseInt(equipaGrupo[i][3]))*3+(Integer.parseInt(equipaGrupo[i][4]));
        }
    }
    public static void ordenar(String[][]equipaGrupo,int limite,int[] pontuacao){
        int i1=0;
        int contG=4;
        int para=0;
        for (int i=0;i<limite;i++){
            
             
            switch(equipaGrupo[i][0]){
                case "A":
                    
                    sortGru(equipaGrupo,i1,i,limite,pontuacao);
                    i1++;
                    if (i1==4){
                        i=i1-1;
                        int i2=0;
                        int cont=i;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao,cont);
                    }
                    break;
                case "B":
                    if (i1>=4){
                    sortGru(equipaGrupo,i1,i,limite,pontuacao);
                    i1++;
                    }
                    if (i1==8){
                        i=i1-1;
                        int i2=4;
                        int cont=i;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao,cont);
                    }
                    break;     
                case "C":
                    if (i1>=8){
                    sortGru(equipaGrupo,i1,i,limite,pontuacao);
                    i1++;
                    }
                    if (i1==12){
                        i=i1-1;
                        int i2=8;
                        int cont=i;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao,cont);
                    }
                    break;
                case "D":
                    if (i1>=12){
                    sortGru(equipaGrupo,i1,i,limite,pontuacao);
                    i1++;
                    }
                    if (i1==16){
                        i=i1-1;
                        int i2=12;
                        int cont=i;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao,cont);
                    }
                    break;
                case "E":
                    if (i1>=16){
                    sortGru(equipaGrupo,i1,i,limite,pontuacao);
                    i1++;
                    }
                    if (i1==20){
                        i=i1-1;
                        int i2=16;
                        int cont=i;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao,cont);
                    }
                    break;
                case "F":
                    if (i1>=20){
                    sortGru(equipaGrupo,i1,i,limite,pontuacao);
                    i1++;
                    }
                    if (i1==24){
                        i=i1-1;
                        int i2=20;
                        int cont=i;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao,cont);
                    }
                    break;
                case "G":
                    if (i1>=24&&para==1){
                    sortGru(equipaGrupo,i1,i,limite,pontuacao);
                    i1++;
                    }
                    if  (i1>=24&&para==0){
                        contG++;
                    }
                    if (contG>5){
                    if (i1==24+contG-4&&para==1){
                        i=i1-1;
                        contG -=4;
                        int i2=20+contG;
                        int cont=i;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao,cont);
                    }
                    }
                    break;
                case "H":
                    if (i1==contG+24){
                        int i2=limite-(limite-contG-24);
                        i=limite-1;
                        int cont=i;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao,cont);
                    }
                    
                    
                    break;
            }
             if (para==0&&i==limite-1){
                       para=1;
                       if (contG==4){
                       contG -=4;
                       }
                       i=i1-1;
                    }      
            }
            
        }
    public static void sortGru(String[][]equipaGrupo,int i1,int i,int limite,int[] pontuacao){
       
       for (int ia = 0; ia < 8; ia++) {
        String temp = equipaGrupo[i][ia];
        equipaGrupo [i][ia] = equipaGrupo[i1][ia];
        equipaGrupo [i1][ia] = temp;
        
       }
       int ponttemp = pontuacao[i];
        pontuacao[i]=pontuacao[i1];
        pontuacao[i1]=ponttemp;
       
   }
   public static void sortBetGru(String[][]equipaGrupo,int i1,int i,int limite,int[] pontuacao,int cont){
       int i2=i1;
       boolean r=true;
       
       while (r){
       for (i=i1;i<cont;i++){
           if (pontuacao[i]<pontuacao[i+1]){
               sortGru(equipaGrupo,i2+1,i,limite,pontuacao);
           }else{
               if (pontuacao[i]==pontuacao[i+1]){
                   if (Integer.parseInt(equipaGrupo[i][6])<Integer.parseInt(equipaGrupo[i+1][6])){
                       sortGru(equipaGrupo,i2+1,i,limite,pontuacao);
                   }else{
                       if (Integer.parseInt(equipaGrupo[i][6])==Integer.parseInt(equipaGrupo[i+1][6])){
                            if (Integer.parseInt(equipaGrupo[i][7])>Integer.parseInt(equipaGrupo[i+1][7])){
                                sortGru(equipaGrupo,i2+1,i,limite,pontuacao);
                            }else{
                                    if (Integer.parseInt(equipaGrupo[i][7])==Integer.parseInt(equipaGrupo[i+1][7])){
                                        if (equipaGrupo[i][1].compareTo(equipaGrupo[i+1][1])>0){
                                            sortGru(equipaGrupo,i2+1,i,limite,pontuacao);
                                        }

                        }
                        }
                       }
                   }
               }
               
           }
           if (i>i1){
           r=check1(pontuacao,equipaGrupo,i);
           
          
               if (r){
                  i=i-2;
                  i2=i2-2;
               }
           }
       
           
       i2++;
       }
       if (i==cont){
           r=false;
       }
       }
       
       }
   
   
   
    public static boolean check1 (int[] generico,String[][]equipaGrupo,int i){
       boolean r;
       i=i-1;
       r= generico[i]<generico[i+1];
        if (r){
            return r;
                
            }else{
            if (generico[i]==generico[i+1]){
                r = Integer.parseInt(equipaGrupo[i][6])<Integer.parseInt(equipaGrupo[i+1][6]);
                if (r){
                    return r;
                    
                }else{
                    if (Integer.parseInt(equipaGrupo[i][6])==Integer.parseInt(equipaGrupo[i+1][6])){
                        r = Integer.parseInt(equipaGrupo[i][7])>Integer.parseInt(equipaGrupo[i+1][7]);
                        if (r){
                            return r;
                        }else{
                            r = equipaGrupo[i][1].compareTo(equipaGrupo[i+1][1])>0;
                            if (r){
                                return r;
                            }
                        }
                    }
                }
            }   
        }
    return r;
    }
   
}