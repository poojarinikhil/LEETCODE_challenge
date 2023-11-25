package Codevita;

import java.util.Scanner;

public class compound_balance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String compound = sc.next();
        int valency = sc.nextInt();
        int a = compound.charAt(0);
        int b = compound.charAt(1);
        while (a%10 !=a){
            int one=a%10;
            int ten =a/10;
//            int ten_digit = ten/10;
            a = one + ten ;
        }
        while (b%10 !=a){
            int one=b%10;
            int ten =b/10;
//            int ten_digit = ten/10;
            b = one + ten ;
        }
    }
    public static void combination(int a, int b, int valency){
        if(valency%2==1){
            odd(a, b,valency);
        }
        else{
            even(a,b,valency);
        }
    }
    public static void odd(int a, int b, int valency){
        int base_a = (valency-b)/a;
        int base_b = (valency-a)/b;
        for (int i = 0;i<base_a;i++){
            for (int j = 0; j <base_b ; j++) {

            }
        }
    }
    public static void even(int a, int b, int valency){

    }
}
