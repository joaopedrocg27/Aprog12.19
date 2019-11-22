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
    public static int menu(String[][] equipaGrupo,int limite,int[] pontuacao,int M,boolean[] jaLido) throws FileNotFoundException{
        
        
        
        switch (M){
            case 1:
                limite=lerFicheiro(equipaGrupo)+1;
                if (!jaLido[0]){
                //limite++;
                }
                jaLido[0]=true;
               // printMenu();
                break;
            case 2:
                if(!jaLido[0]){System.out.println("ATENÇÃO! Ficheiro inda não lido (opção 1)");
                    System.out.println("");
                }else{
                limite=lerManualmente (equipaGrupo,limite);
                jaLido[0]=true;
                printMenu();
                }
                break;
            case 3 :
                if(!jaLido[0]){System.out.println("ATENÇÃO! Ficheiro inda não lido (opção 1)");
                    System.out.println("");
                }else{
                    
                calcularPontuacao(equipaGrupo,limite,pontuacao);    
                printMenu();
                break;
                }
            case 4 :
                if(!jaLido[0]){System.out.println("ATENÇÃO! Ficheiro inda não lido (opção 1)");
                    System.out.println("");
                }else{
                ordenar(equipaGrupo,limite,pontuacao);
                printMenu();
                }
            case 5 :
                imprimirGrupo(equipaGrupo,pontuacao,limite);
                printMenu();
                break;
            case 6 :
                maximoGolos(equipaGrupo,limite);
                printMenu();
                break;
            case 7 :
                sofridoGolos(equipaGrupo,limite);
                printMenu();
                break;
            case 8:
                ordenarDiferencaGolos(equipaGrupo,limite);
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
        return limite;
    }
    public static void main (String[] args) throws FileNotFoundException{
            String [][] equipaGrupo = new String [32][8];
            int limite=0;
            int i=0;
           // limite=lerFicheiro(equipaGrupo);
           //limite++;
            int []pontuacao1=new int[1];
            //calcularPontuacao(equipaGrupo,limite,pontuacao);
            
            //ordenar(equipaGrupo,limite,pontuacao);
            boolean[] vef= {false};
            printMenu();
            int M=sc2.nextInt();
            while (M!=15){
            
            if (M==2||M==1){
                limite=menu(equipaGrupo,limite,pontuacao1,M,vef);
                int []pontuacao=new int[limite];
                M=sc2.nextInt();
                while (M!=15&&M!=1&&M!=2){
                    limite=menu(equipaGrupo,limite,pontuacao,M,vef);
                    M=sc2.nextInt();
                }
            }
            
            }
            
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
        
        return cont;
        }
    public static int lerManualmente (String[][] equipaGrupo,int limite){
        System.out.println("Quer adicionar mais equipas?");
        System.out.println("Se sim,escrever 'Y'");
        sc2.nextLine();
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
        int destinoFinal=0;
        int contG=4;
        int para=0;
        for (int i=0;i<limite;i++){
            
             
            switch(equipaGrupo[i][0]){
                case "A":
                    
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    if (destinoFinal==4){
                        i=destinoFinal-1;
                        int classPrim=0;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "B":
                    if (destinoFinal>=4){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==8){
                        i=destinoFinal-1;
                        int classPrim=4;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;     
                case "C":
                    if (destinoFinal>=8){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==12){
                        i=destinoFinal-1;
                        int classPrim=8;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "D":
                    if (destinoFinal>=12){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==16){
                        i=destinoFinal-1;
                        int classPrim=12;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "E":
                    if (destinoFinal>=16){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==20){
                        i=destinoFinal-1;
                        int classPrim=16;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "F":
                    if (destinoFinal>=20){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==24){
                        i=destinoFinal-1;
                        int classPrim=20;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "G":
                    if (destinoFinal>=24&&para==1){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if  (destinoFinal>=24&&para==0){
                        contG++;
                    }
                    if (contG>5){
                    if (destinoFinal==24+contG-4&&para==1){
                        i=destinoFinal-1;
                        contG -=4;
                        int classPrim=20+contG;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    }
                    break;
                case "H":
                    if (destinoFinal==contG+24){
                        int classPrim=limite-(limite-contG-24);
                        i=limite-1;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    
                    
                    break;
            }
             if (para==0&&i==limite-1){
                       para=1;
                       if (contG==4){
                       contG -=4;
                       }
                       i=destinoFinal-1;
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
   public static void sortBetGru(String[][]equipaGrupo,int classPrim,int i,int limite,int[] pontuacao,int classUltimo){
       int i2=classPrim;
       boolean r=true;
       
       while (r){
       for (i=classPrim;i<classUltimo;i++){
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
           if (i>classPrim){
           r=check1(pontuacao,equipaGrupo,i);
           
          
               if (r){
                  i=i-2;
                  i2=i2-2;
               }
           }
       
           
       i2++;
       }
       if (i==classUltimo){
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
    public static void imprimirGrupo (String[][]equipaGrupo,int[]pontuacao,int limite){
        int i1=0;
        String impr="";
        for (int i=0;i<limite;i++){
            
            while (i1<7){
                if (i1==0){
                    impr="";
                    impr=impr+equipaGrupo[i][i1];
                }
                i1++;
              impr=impr+","+equipaGrupo[i][i1];
              
            }
            impr=impr+","+pontuacao[i];
            i1=0;
            System.out.println(impr);
        }
    }
    public static void maximoGolos (String[][]equipaGrupo,int limite){
        int max=0;
        for (int i=0;i<limite;i++){
            if (max<Integer.parseInt(equipaGrupo[i][6])){
                max=Integer.parseInt(equipaGrupo[i][6]);
            }
        }
        for (int i=0;i<limite;i++){
            if (max==Integer.parseInt(equipaGrupo[i][6])){
                System.out.println(equipaGrupo[i][1]);
            }
        }
    }
    public static void sofridoGolos (String[][]equipaGrupo,int limite){
        int goloSofr=sc2.nextInt();
        for (int i=0;i<limite;i++){
            if (goloSofr==Integer.parseInt(equipaGrupo[i][7])){
                System.out.println(equipaGrupo[i][1]);
            }
        }
    }
    public static void ordenarDiferencaGolos (String[][]equipaGrupo,int limite){
        int contEqui=0;
        for (int i=0;i<limite;i++){
            if (Integer.parseInt(equipaGrupo[i][6])<Integer.parseInt(equipaGrupo[i][7])){
                contEqui++;
            }
        }
        int i1=0;
        String[]ordenar=new String[contEqui];
        for (int i=0;i<limite;i++){
            if (Integer.parseInt(equipaGrupo[i][6])<Integer.parseInt(equipaGrupo[i][7])){
                ordenar[i1]=equipaGrupo[i][1];
                i1++;
            }
        }
        for (i1=0;i1<contEqui-1;i1++){
            if (ordenar[i1].compareTo(ordenar[i1+1])>0){
                String temp=ordenar[i1];
                ordenar[i1]=ordenar[i1+1];
                ordenar[i1+1]=temp;
                if (i1>0){
                boolean r=ordenar[i1].compareTo(ordenar[i1-1])<0;
                if (r){
                    i1=i1-2;
                }
            }
            }
        }
        for (i1=0;i1<contEqui;i1++){
            System.out.println(ordenar[i1]);
        }
    }
}