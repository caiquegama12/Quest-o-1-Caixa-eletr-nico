package org.example;
import java.util.Scanner;

class SaldoInsuficiente extends Exception {
    public SaldoInsuficiente() {}
}
class semNotas extends Exception{
    public semNotas(){}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double saldo=100;
        System.out.println("Quanto deseja sacar?");
        int sacar=sc.nextInt();
        int verificarNota=sacar;
        int[] notas={100,50,20,10,5,2};
        double[] quantidadeNota={2,3,1,1,5,10};
        int a=0;
        try{
            if(saldo>=sacar) {
                try{
                    while(verificarNota>0 && a<notas.length) {
                        int b = verificarNota / notas[a];
                        if (b > 0 && b <= quantidadeNota[a]) {
                            verificarNota = verificarNota - (b * notas[a]);
                            quantidadeNota[a] = quantidadeNota[a] - b;
                        }
                        a=a+1;
                    }
                    if(verificarNota==0){
                        System.out.println("Sacando o dinheiro");
                        saldo=saldo-sacar;
                    } else{
                        throw new semNotas();
                    }
                } catch (semNotas e){
                    System.out.println("O caixa não tem as notas");
                }

            } else {
                throw new SaldoInsuficiente();
            }
        } catch(SaldoInsuficiente e) {
            System.out.println("Não tem todo esse dinheiro!");
        }
        sc.close();
    }
}