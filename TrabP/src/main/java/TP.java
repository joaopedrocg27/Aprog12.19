import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class TP {
    static Scanner sc2 = new Scanner (System.in);
    public static void printMenu(){
        System.out.println("|=================================================MENU========================================================|");
        System.out.println("|Insira a opção a executar:                                                                                   |");
        System.out.println("|1-Ler a informação disponível no ficheiro de texto e armazená-la em memória                                  |");
        System.out.println("|2-Inserir manualmente informação de uma seleção (Exemplo: B,Portugal,3,1,2,0,5,4)                            |");
        System.out.println("|3-Calcular e armazenar em memória a pontuação de todas as equipas.                                           |");
        System.out.println("|4-Calcular e armazenar em memória a classificação de todas as equipas nos respetivos grupos.                 |");
        System.out.println("|5-Listar a classificação das equipas por grupo;                                                              |");
        System.out.println("|6-Listar as equipas cujos golos marcados é igual ao máximo de golos marcados                                 |");
        System.out.println("|7-Listar as equipas com um determinado número de golos sofridos. Insira o número de golos                    |");
        System.out.println("|8-Listar as equipas que têm mais golos sofridos do que golos marcados, ordenadas alfabeticamente             |");
        System.out.println("|9-Listar o primeiro classificado de cada grupo                                                               |");
        System.out.println("|10-Listar informação completa de uma equipa insira o número de golos                                         |");
        System.out.println("|11-Criar um ficheiro de texto (Statistics.txt) com estatísticas dos jogos                                    |");
        System.out.println("|12-Remover da memória as equipas que não vão disputar a fase seguinte                                        |");
        System.out.println("|13-Criar um ficheiro de texto (FinalStage.csv) com as equipas que vão disputar a fase seguinte do campeonato |");
        System.out.println("|14-Criar um ficheiro de texto (FinalStageGames.txt) com os jogos da fase final.                              |");
        System.out.println("|15-Sair                                                                                                      |");
        System.out.println("|=============================================================================================================|");

    }
    public static int menu(String[][] equipaGrupo,int limite,int[] pontuacao,int M,boolean[] jaLido,int []contGrupo) throws FileNotFoundException{
        
        
        
        switch (M){
            case 1:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                limite=lerFicheiro(equipaGrupo)+1;
                if (!jaLido[0]){
                //limite++;
                }
                jaLido[0]=true;
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                selecPorGrupo(equipaGrupo,limite,contGrupo);
                break;
            case 2:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                if(!jaLido[0]){System.out.println("ATENÇÃO! Ficheiro inda não lido (opção 1)");
                    System.out.println("");
                }else{
                limite=lerManualmente (equipaGrupo,limite,contGrupo);
                jaLido[0]=true;
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                }
                break;
            case 3 :
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                if(!jaLido[0]){System.out.println("ATENÇÃO! Ficheiro inda não lido (opção 1)");
                    System.out.println("");
                }else{
                    
                calcularPontuacao(equipaGrupo,limite,pontuacao);    
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
                }
            case 4 :
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                if(!jaLido[0]){System.out.println("ATENÇÃO! Ficheiro inda não lido (opção 1)");
                    System.out.println("");
                }else{
                ordenar(equipaGrupo,limite,pontuacao,contGrupo);
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                }
                break;
            case 5 :
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                imprimirGrupo(equipaGrupo,pontuacao,limite);
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 6 :
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                maximoGolos(equipaGrupo,limite);
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 7 :
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                sofridoGolos(equipaGrupo,limite);
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 8:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                ordenarDiferencaGolos(equipaGrupo,limite);
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 9:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                //missing
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 10:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                //missing
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 11:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                //missing
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 12:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                //missing
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 13:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                //missing
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 14:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                //missing
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;  
            case 15:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                System.out.println("A terminar...");
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
            int []contGrupo = new int[8];
            boolean[] vef= {false};
            printMenu();
            boolean r=true;
            int M=sc2.nextInt();
            while (M!=1&&M!=2&&M!=2&&M<15){
                System.out.println("As opções 1 ou 2 precisam de ser ativadas antes do programa executar");
                sc2.nextLine();
                System.out.println("Deseja selecionar outra opção");
                System.out.println("Selecione 'Y' para confirma");
                System.out.println("Se selecionar algo diferente de Y para sair.");
                String resposta=sc2.nextLine();
                r= resposta.equals("Y") || resposta.equals("y");
                if (r){
                    System.out.println("Digite 1 ou 2");
                    M=sc2.nextInt();
                }else{
                    break;
                }
                
            }
            while (M!=15&&r){
            
            if (M==2||M==1){
                limite=menu(equipaGrupo,limite,pontuacao1,M,vef,contGrupo);
                int []pontuacao=new int[limite];
                M=sc2.nextInt();
                while (M!=15&&M!=1&&M!=2){
                    limite=menu(equipaGrupo,limite,pontuacao,M,vef,contGrupo);
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
    public static int lerManualmente (String[][] equipaGrupo,int limite,int[]contGrupo){
        System.out.println("Quer adicionar mais equipas?");
        System.out.println("Se sim,escrever 'Y'");
        sc2.nextLine();
        String resposta = sc2.nextLine();
        while (resposta.equalsIgnoreCase("Y")&&limite<32){
        for (int i=limite;i<32;i++){
            boolean r;
            if (equipaGrupo[i][0]==(null)){
                System.out.println("Insira o nome da equipa");
                r=verificarRepetição(equipaGrupo,i,limite);
                if (r){
                    break;
                }
                System.out.println("Insira o grupo da equipa");
                r=verificarNumSelecGrup(equipaGrupo,limite,contGrupo,i);
                if (r){
                    break;
                }
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
        if (limite<32){
        System.out.println("Quer adicionar mais equipas?");
        System.out.println("Se sim,escrever 'Y'");
        resposta = sc2.nextLine();
        }
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
    public static void selecPorGrupo (String[][]equipaGrupo,int limite,int[]contGrupo){
        for (int i=0;i<limite;i++){
            switch (equipaGrupo[i][0]){
                case "A":
                    contGrupo[0]++;
                    break;
                case "B":
                    contGrupo[1]++;
                    break;
                case "C":
                    contGrupo[2]++;
                    break;
                case "D":
                    contGrupo[3]++;
                    break;
                case "E":
                    contGrupo[4]++;
                    break;
                case "F":
                    contGrupo[5]++;
                    break;
                case "G":
                    contGrupo[6]++;
                    break;
                case "H":
                    contGrupo[7]++;
                    break;
            }
        }
    }
    public static boolean verificarNumSelecGrup(String[][]equipaGrupo,int limite,int[] contGrupo,int i){
        boolean r=false;
        String grupo=sc2.nextLine();
        switch (grupo){
            case "A":
                if (contGrupo[0]==4){
                    r=true;
                    equipaGrupo[i][1]=null;
                    System.out.println("Este grupo já tem 4 seleções");
                    return r;
                }else{
                    equipaGrupo[i][0]=grupo;
                    contGrupo[0]++;
                }
                break;
             case "B":
                if (contGrupo[1]==4){
                    r=true;
                    equipaGrupo[i][1]=null;
                    System.out.println("Este grupo já tem 4 seleções");
                    return r;
                }else{
                    equipaGrupo[i][0]=grupo;
                    contGrupo[1]++;
                }
                break;
            case "C":
                if (contGrupo[2]==4){
                    r=true;
                    equipaGrupo[i][1]=null;
                    System.out.println("Este grupo já tem 4 seleções");
                    return r;
                }else{
                    equipaGrupo[i][0]=grupo;
                    contGrupo[2]++;
                }
                break;
            case "D":
                if (contGrupo[3]==4){
                    r=true;
                    equipaGrupo[i][1]=null;
                    System.out.println("Este grupo já tem 4 seleções");
                    return r;
                }else{
                    equipaGrupo[i][0]=grupo;
                    contGrupo[3]++;
                }
                break;
            case "E":
                if (contGrupo[4]==4){
                    r=true;
                    equipaGrupo[i][1]=null;
                    System.out.println("Este grupo já tem 4 seleções");
                    return r;
                }else{
                    equipaGrupo[i][0]=grupo;
                    contGrupo[4]++;
                }
                break;
            case "F":
                if (contGrupo[5]==4){
                    r=true;
                    equipaGrupo[i][1]=null;
                    System.out.println("Este grupo já tem 4 seleções");
                    return r;
                }else{
                    equipaGrupo[i][0]=grupo;
                    contGrupo[5]++;
                }
                break;
            case "G":
                if (contGrupo[6]==4){
                    r=true;
                    equipaGrupo[i][1]=null;
                    System.out.println("Este grupo já tem 4 seleções");
                    return r;
                }else{
                    equipaGrupo[i][0]=grupo;
                    contGrupo[6]++;
                }
                break;
            case "H":
                if (contGrupo[7]==4){
                    r=true;
                    equipaGrupo[i][1]=null;
                    System.out.println("Este grupo já tem 4 seleções");
                    return r;
                }else{
                    equipaGrupo[i][0]=grupo;
                    contGrupo[7]++;
                }
                break;
            default:
                System.out.println("Grupo Inválido");
        }
    return r;
    }
    public static void calcularPontuacao(String[][]equipaGrupo,int limite,int [] pontuacao){
        
        for (int i=0;i<limite;i++){
            pontuacao[i]=(Integer.parseInt(equipaGrupo[i][3]))*3+(Integer.parseInt(equipaGrupo[i][4]));
        }
    }
    public static void ordenar(String[][]equipaGrupo,int limite,int[] pontuacao,int[]contGrupo){
        int destinoFinal=0;
        //int contG=4;
        //int para=0;
        for (int i=0;i<limite;i++){
            switch(equipaGrupo[i][0]){
                case "A":
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    if (destinoFinal==contGrupo[0]){
                        i=destinoFinal-1;
                        int classPrim=0;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "B":
                    if (destinoFinal>=contGrupo[0]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;     
                case "C":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "D":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "E":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "F":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    break;
                case "G":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]+contGrupo[6]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    
                    break;
                case "H":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]+contGrupo[6]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacao);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]+contGrupo[6]+contGrupo[7]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]+contGrupo[6];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacao,classUltimo);
                    }
                    
                    break;
            }
             /*if (para==0&&i==limite-1){
                       para=1;
                       if (contG==4){
                       contG -=4;
                       }
                       i=destinoFinal-1;
                    }*/      
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
        int maiorString=0;
        for (int i=0;i<limite;i++){
            if (equipaGrupo[i][1].length()>maiorString){
                maiorString=equipaGrupo[i][1].length();
            }
        }
        String espaco="";
        for (int i=0;i<maiorString-"Seleção".length();i++){
            espaco=espaco+" ";
        }
        System.out.println("|Grupo|Seleção" + espaco + "|J" + "|V" +"|E" +"|D" +"|GM" + "|GL" +"|P|");
        for (int i=0;i<limite;i++){
            
            while (i1<7){
                espaco="";
                if (i1==0){
                    impr="";
                    impr="|"+impr+equipaGrupo[i][i1]+"    " +"|";
                }
                i1++;
                for (int i2=0;i2<maiorString-equipaGrupo[i][1].length();i2++){
                   espaco=espaco+" ";
                }
                if(i1!=1){
                    espaco="";
                }
                if (i1==6||i1==7){
                    espaco=" ";
                }
              impr=impr+equipaGrupo[i][i1]+espaco+"|";
              
            }
            impr=impr+pontuacao[i]+"|";
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
            if (goloSofr== Integer.parseInt(equipaGrupo[i][7])){
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
    public static void primeiroGrupo(String[][]equipaGrupo,int limite){
        
        
        
            
            
    }            
}
