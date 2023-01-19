package ParImpar;

import java.util.Scanner;

public class ParImpar {


    static int readNumber() {
        System.out.print("Enter Number: ");
        Scanner input = new Scanner(System.in);
        if(input.hasNextInt()){
            int number = input.nextInt();
            input.close();
            return number;
        }
        else{
            System.out.print("Please Enter a Valid Number!");
            return readNumber();
        }
    }

    static boolean isEven(int n){
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        int n = readNumber();
        while(n>0){
            System.out.print(n + " ");
            n = n-2;
        }
        if(isEven(n)){
            System.out.print(0 + " ");
        }
    }
}
