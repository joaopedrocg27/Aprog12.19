import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class TP {
    static Scanner sc2 = new Scanner (System.in);
    public static void main (String[] args) throws FileNotFoundException{
            String [][] equipaGrupo = new String [32][8];
            int limite;
            limite=lerFicheiro(equipaGrupo);
            limite++;
            int []pontuacao=new int[limite];
            calcularPontuacao(equipaGrupo,limite,pontuacao);
            
            ordenar(equipaGrupo,limite,pontuacao);
            System.out.println("Mau mau");
            
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
        lerManualmente(equipaGrupo,cont);
        return cont;
        }
    public static void lerManualmente (String[][] equipaGrupo,int limite){
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
                equipaGrupo[i1][0]=resposta;
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
        for (int i=0;i<limite;i++){
            switch(equipaGrupo[i][0]){
                case "A":
                    
                    sortGru(equipaGrupo,i1,i,limite,pontuacao);
                    i1++;
                    if (i1==4){
                        i=i1-1;
                        int i2=0;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao);
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
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao);
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
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao);
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
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao);
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
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao);
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
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao);
                    }
                    break;
                case "G":
                    if (i1>=24){
                    sortGru(equipaGrupo,i1,i,limite,pontuacao);
                    i1++;
                    }
                    if (i1==28){
                        i=i1-1;
                        int i2=24;
                        sortBetGru(equipaGrupo,i2,i,limite,pontuacao);
                    }
                    break;
                case "H":
                    if (i1>=28){
                        sortGru(equipaGrupo,i1,i,limite,pontuacao);
                        i1++;
                    }
                    break;
                    
                    
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
   public static void sortBetGru(String[][]equipaGrupo,int i1,int i,int limite,int[] pontuacao){
       int i2=i1;
       for (i=i1;i<i1+3;i++){
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
       i2++;
       
       }
   
   
   }
    public static boolean check1 (int[] generico){
       boolean r;
       int i=0;
       r= generico[i]<generico[i+1];
        if (r){
            return r;
        }else{
            
        }
    return r;
    }
   
}