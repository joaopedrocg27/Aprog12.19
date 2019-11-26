import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        System.out.println("|8-Listar as equipas que têm /home/guilherme/Aprog12.19mais golos sofridos do que golos marcados, ordenadas alfabeticamente             |");
        System.out.println("|9-Listar o primeiro classificado de cada grupo                                                               |");
        System.out.println("|10-Listar informação completa de uma equipa                                       |");
        System.out.println("|11-Criar um ficheiro de texto (Statistics.txt) com estatísticas dos jogos                                    |");
        System.out.println("|12-Remover da memória as equipas que não vão disputar a fase seguinte                                        |");
        System.out.println("|13-Criar um ficheiro de texto (FinalStage.csv) com as equipas que vão disputar a fase seguinte do campeonato |");
        System.out.println("|14-Criar um ficheiro de texto (FinalStageGames.txt) com os jogos da fase final.                              |");
        System.out.println("|15-Sair                                                                                                      |");
        System.out.println("|=============================================================================================================|");

    }
    public static int menu(String[][] equipaGrupo,int limite,int[][] pontuacaoDg,int M,boolean[] jaLido,int []contGrupo) throws FileNotFoundException{        
        switch (M){
            case 1:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                limite=lerFicheiro(equipaGrupo);
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
                    
                calcularPontuacao(equipaGrupo,limite,pontuacaoDg);    
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
                ordenar(equipaGrupo,limite,pontuacaoDg,contGrupo);
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                }
                break;
            case 5 :
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                imprimirGrupo(equipaGrupo,pontuacaoDg,limite);
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
                System.out.println("Indicar o numero de golos sofridos");
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
                primeiroGrupo(equipaGrupo,limite,pontuacaoDg,contGrupo);
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 10:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                listarInformacaoSelecao(equipaGrupo,limite,pontuacaoDg,contGrupo);
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 11:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                estatistica (equipaGrupo,limite);
                System.out.println("Done");
                System.out.println(" ");
                printMenu();
                break;
            case 12:
                System.out.println("============================================== Opçao "+M+" ======================================================");
                System.out.println(" ");
                limite = limparMemoria (equipaGrupo,limite,contGrupo,pontuacaoDg);
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
            /*É neste array que fica gravado a informaçao*/
            int limite=0;
            //Conta o numero de linhas
            int [][]pontuacao1=new int[1][1];
            //array provisorio para depois ser substituido por pontuacao
            int []contGrupo = new int[8];
            //Conta a quantidade de seleções por grupo
            boolean[] vef= {false};
            //Permite saber se uma opção já foi selecionada
            printMenu();
            boolean r=true;
            //Se for verdade permite que o menu funcione
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
                int [][]pontuacaoDg=new int[limite][2];
                M=sc2.nextInt();
                while (M!=15&&M!=1&&M!=2){
                    limite=menu(equipaGrupo,limite,pontuacaoDg,M,vef,contGrupo);
                    M=sc2.nextInt();
                }
            }
            
            }
            
    }
    public static int lerFicheiro (String[][] equipaGrupo) throws FileNotFoundException {
        File file = new File("PracticalWork.csv");
        Scanner sc = new Scanner(file);
        sc.nextLine();
        //Não lê a primeira linha pois é irrelevante
        int cont=0,i=0;
        //cont é um contador de linhas do ficheiro
        //i indica a linha do ficheiro
        while (sc.hasNextLine()){ 
            equipaGrupo[i] = sc.nextLine().split(",");
            i++;
            cont++;
        }
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
    public static void calcularPontuacao(String[][]equipaGrupo,int limite,int [][] pontuacaoDg){
        
        for (int i=0;i<limite;i++){
            pontuacaoDg[i][0]=(Integer.parseInt(equipaGrupo[i][3]))*3+(Integer.parseInt(equipaGrupo[i][4]));
            pontuacaoDg[i][1]=Integer.parseInt(equipaGrupo[i][6])-Integer.parseInt(equipaGrupo[i][7]);
        }
    }
    public static void ordenar(String[][]equipaGrupo,int limite,int[][] pontuacaoDg,int[]contGrupo){
        int destinoFinal=0;
        //int contG=4;
        //int para=0;
        for (int i=0;i<32;i++){
            if (equipaGrupo[i][0] !=null){
            switch(equipaGrupo[i][0]){
                case "A":
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacaoDg);
                    destinoFinal++;
                    if (destinoFinal==contGrupo[0]){
                        i=destinoFinal-1;
                        int classPrim=0;
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacaoDg,classUltimo);
                    }
                    break;
                case "B":
                    if (destinoFinal>=contGrupo[0]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacaoDg);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacaoDg,classUltimo);
                    }
                    break;     
                case "C":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacaoDg);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacaoDg,classUltimo);
                    }
                    break;
                case "D":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacaoDg);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacaoDg,classUltimo);
                    }
                    break;
                case "E":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacaoDg);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacaoDg,classUltimo);
                    }
                    break;
                case "F":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacaoDg);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacaoDg,classUltimo);
                    }
                    break;
                case "G":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacaoDg);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]+contGrupo[6]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacaoDg,classUltimo);
                    }
                    
                    break;
                case "H":
                    if (destinoFinal>=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]+contGrupo[6]){
                    sortGru(equipaGrupo,destinoFinal,i,limite,pontuacaoDg);
                    destinoFinal++;
                    }
                    if (destinoFinal==contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]+contGrupo[6]+contGrupo[7]){
                        i=destinoFinal-1;
                        int classPrim=contGrupo[0]+contGrupo[1]+contGrupo[2]+contGrupo[3]+contGrupo[4]+contGrupo[5]+contGrupo[6];
                        int classUltimo=i;
                        sortBetGru(equipaGrupo,classPrim,i,limite,pontuacaoDg,classUltimo);
                    }
                    
                    break;
            }
            }   
            }
            
        }
            
   
    

   public static void sortGru(String[][]equipaGrupo,int i1,int i,int limite,int[][] pontuacaoDg){
       
       for (int ia = 0; ia < 8; ia++) {
        String temp = equipaGrupo[i][ia];
        equipaGrupo [i][ia] = equipaGrupo[i1][ia];
        equipaGrupo [i1][ia] = temp;
        
       }
       int ponttemp = pontuacaoDg[i][0];
        pontuacaoDg[i][0]=pontuacaoDg[i1][0];
        pontuacaoDg[i1][0]=ponttemp;
        int dgTemp = pontuacaoDg[i][1];
        pontuacaoDg[i][1]=pontuacaoDg[i1][1];
        pontuacaoDg[i1][1]=ponttemp; 
       
   }
   public static void sortBetGru(String[][]equipaGrupo,int classPrim,int i,int limite,int[][] pontuacaoDg,int classUltimo){
       int i2=classPrim;
       boolean r=true;
       
       while (r){
       for (i=classPrim;i<classUltimo;i++){
           if (pontuacaoDg[i][0]<pontuacaoDg[i+1][0]){
               sortGru(equipaGrupo,i2+1,i,limite,pontuacaoDg);
           }else{
               if (pontuacaoDg[i]==pontuacaoDg[i+1]){
                   if (Integer.parseInt(equipaGrupo[i][6])<Integer.parseInt(equipaGrupo[i+1][6])){
                       sortGru(equipaGrupo,i2+1,i,limite,pontuacaoDg);
                   }else{
                       if (Integer.parseInt(equipaGrupo[i][6])==Integer.parseInt(equipaGrupo[i+1][6])){
                            if (Integer.parseInt(equipaGrupo[i][7])>Integer.parseInt(equipaGrupo[i+1][7])){
                                sortGru(equipaGrupo,i2+1,i,limite,pontuacaoDg);
                            }else{
                                    if (Integer.parseInt(equipaGrupo[i][7])==Integer.parseInt(equipaGrupo[i+1][7])){
                                        if (equipaGrupo[i][1].compareTo(equipaGrupo[i+1][1])>0){
                                            sortGru(equipaGrupo,i2+1,i,limite,pontuacaoDg);
                                        }

                        }
                        }
                       }
                   }
               }
               
           }
           if (i>classPrim){
           r=check1(pontuacaoDg,equipaGrupo,i);
           
          
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
   
   
   
    public static boolean check1 (int[][] pontuacaoDg,String[][]equipaGrupo,int i){
       boolean r;
       i=i-1;
       r= pontuacaoDg[i][0]<pontuacaoDg[i+1][0];
        if (r){
            return r;
                
            }else{
            if (pontuacaoDg[i][0]==pontuacaoDg[i+1][0]){
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
    public static void imprimirGrupo (String[][]equipaGrupo,int[][]pontuacaoDg,int limite){
        int i1=0;
        String impr="";
        int soma=0;
        int pos;
        String espaco="";
        
        System.out.println("| Grp | Pos | Equipa          | Pts| J  | E  | D  | GM | GS | GD | GD |");
        System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
        for (int i=0;i<limite;i++){
           while (i1<=8){
            if (i1==0){
               pos = i+1-soma;
               impr="|"+equipaGrupo[i][0]+"    " + "|" +"    "+ pos+"|";
              }
            if (i1==1){
                for (int esp=0;esp<17-equipaGrupo[i][1].length();esp++){
                    espaco=espaco+ " ";
                }
                impr=impr+equipaGrupo[i][1]+espaco+"|";
            }
            if (i1==2){
                impr=impr+"   "+pontuacaoDg[i][0]+"|";
            }
            if (i1==8){
                impr=impr+"   "+pontuacaoDg[i][1]+"|";
            if (i1>2&&i1<8){
                impr=impr+"   "+equipaGrupo[i][i1]+"|";
            }
            i1++;
           } 
           
           }
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
    public static void primeiroGrupo(String[][]equipaGrupo,int limite,int[][] pontuacaoDg,int[]contGrupo){
        calcularPontuacao(equipaGrupo,limite,pontuacaoDg);
        ordenar(equipaGrupo,limite,pontuacaoDg,contGrupo);
        int aux=0;
        for(int i=0;i<=7;i++){
            if(contGrupo[i]==0){
                System.out.println("Grupo vazio!");
            }else{
            System.out.println(equipaGrupo[aux][1]);
            }
            aux = aux+contGrupo[i];
            
            
    } 
    }
    public static void listarInformacaoSelecao(String[][]equipaGrupo,int limite,int [][]pontuacaoDg,int[] contGrupo){
        sc2.nextLine();
        System.out.println("Introduza a seleção para a qual quer mais informação");
        String selecao=sc2.nextLine();
        int contador=0;
        int soma=0; 
        for (int i=0;i<limite;i++){
            if (selecao.equals(equipaGrupo[i][1])){
                String espaco="";
                String informacao="";
                int pos=i+1;
                if ("selecao".length()>equipaGrupo[i][1].length()){
                    for (int cont=0;cont<"selecao".length()-equipaGrupo[i][1].length();cont++){
                        espaco=espaco+" ";
                    }
                    while (pos>4){
                        int i5=0;
                        
                        soma=contGrupo[i5]+soma;
                        pos =i+1-soma;
                    }
                    for (int i1=0;i1<8;i1++){
                        if (i1==0){
                            informacao="|" + equipaGrupo[i][i1] + "    " + "|" +pos + "º ";
                        }else{
                            if (i1==6||i1==7){
                                informacao=informacao + "|"+equipaGrupo[i][i1] +" ";
                            }else{
                                if (i1==1){
                                    informacao=informacao + "|"+equipaGrupo[i][i1] +espaco;
                                }else{
                                informacao=informacao +"|" + equipaGrupo[i][i1];
                                }
                            }
                        }
                    }
                    informacao=informacao+ "|" + pontuacaoDg[i][0] +"|";
                    System.out.println("|Grupo|Pos|Seleção|J|V|E|D|GM|GF|P|");
                    System.out.println(informacao);
                }else{
                    while (pos>4){
                        int i5=0; 
                        soma=contGrupo[i5]+soma;
                        pos =i+1-soma;
                    }
                    informacao="|" + equipaGrupo[i][0] + "    "+ "|" +pos + "º " + "|";
                    for (int cont=0;cont<equipaGrupo[i][1].length()-"selecao".length();cont++){
                        espaco=espaco+" ";
                    }
                    for (int i1=1;i1<8;i1++){
                     if (i1!=1){
                         espaco="";
                     }   
                     if (i1==6||i1==7){
                         espaco=" ";
                     }
                     informacao=informacao + equipaGrupo[i][i1] + espaco + "|";
                    }
                    
                    informacao=informacao+ "|" + pontuacaoDg[i][0] +"|";
                    System.out.println("|Grupo|Pos|Selecao"+espaco+"|J|V|E|D|GM|GF|P|");
                    System.out.println(informacao);
                }
            
            }else{
                contador++;
            }
        }
        if (contador==limite){
            System.out.println("A seleção não é válida");
        }
    }
    public static void estatistica (String[][]equipaGrupo,int limite) throws FileNotFoundException{
        int jogos=0,vitorias=0,empates=0,derrota=0,golosM=0,golosS=0;
        double mediaGoloM,mediaGoloS;
        for (int i=0;i<limite;i++){
            jogos = Integer.parseInt(equipaGrupo[i][2]) + jogos;
            vitorias= Integer.parseInt(equipaGrupo[i][3]) + vitorias;
            empates = Integer.parseInt(equipaGrupo[i][4]) + empates;
            derrota= Integer.parseInt(equipaGrupo[i][5]) + derrota;
            golosM= Integer.parseInt(equipaGrupo[i][6]) + golosM;
            golosS= Integer.parseInt(equipaGrupo[i][7]) + golosS;
        }
        mediaGoloM = ((double)golosM)/jogos;
        mediaGoloS = ((double)golosS)/jogos;
        printToFile(equipaGrupo,limite,mediaGoloS,mediaGoloM,jogos,vitorias,derrota,golosM,golosS,empates);
        
    }
    public static int limparMemoria (String[][]equipaGrupo,int limite,int[] contGrupo,int[][] pontuacaoDg){
       boolean r=false;
        for (int i = 0; i < contGrupo.length; i++) {
            if (contGrupo[i]<2){
                switch (i){
                    case 0:
                        System.out.println("O grupo A não cumpre o numero mínimo de elementos");
                        r=true;
                        break;
                    case 1:
                        System.out.println("O grupo B não cumpre o numero mínimo de elementos");
                        r=true;
                        break;
                    case 2:
                        System.out.println("O grupo C não cumpre o numero mínimo de elementos");
                        r=true;
                        break;
                    case 3:
                        System.out.println("O grupo D não cumpre o numero mínimo de elementos");
                        r=true;
                        break;
                    case 4:
                        System.out.println("O grupo E não cumpre o numero mínimo de elementos");
                        r=true;
                        break;
                    case 5:
                        System.out.println("O grupo F não cumpre o numero mínimo de elementos");
                        r=true;
                        break;
                    case 6:
                        System.out.println("O grupo G não cumpre o numero mínimo de elementos");
                        r=true;
                        break;
                    case 7:
                        System.out.println("O grupo H não cumpre o numero mínimo de elementos");
                        r=true;
                        break;


                }
            }    
            }
        int soma=0;
        int i1;
       for (int i = 0; i < 8; i++) {
           if (r){
               break;
           }
           i1=0;
           soma=contGrupo[i]+soma;
           while (i1<8){
           if (contGrupo[i]==4){
               equipaGrupo[soma-2][i1]=null;
               equipaGrupo[soma-1][i1]=null;
           }else{
               if (contGrupo[i]==3){
                   equipaGrupo[soma-1][i1]=null;  
               }
                 
           }
           i1++;
           }

        }
      soma=0;
        for (int i = 0; i < contGrupo.length; i++) {
            contGrupo[i]=2;
            soma=soma + contGrupo[i];
            
        }
       ordenar(equipaGrupo,limite,pontuacaoDg,contGrupo);
       if (!r){
               limite=soma;
       } 
        return limite;
    }
    public static void printToFile(String[][]equipaGrupo,int limite,double mediaGolosS,double mediaGolosM,int jogos,int vitorias,int derrota,int golosM,int golosS,int empates) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(new File("statistics.txt"));
        out.println("Total de jogos="+jogos);
        out.println("Total de vitórias="+vitorias);
        out.println("Total de empates="+empates);
        out.println("Total de derrotas="+derrota);
        out.println("Total de golos marcados="+golosM);
        out.println("Total de golos sofridos="+golosS);
        out.printf("%s%.1f%n","Média de golos marcados por jogo=",mediaGolosM);
        out.printf("%s%.1f%n","Média de golos sofridos por jogo=",mediaGolosS);
        out.close();
    } 
}
