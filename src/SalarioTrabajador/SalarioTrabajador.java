package SalarioTrabajador;

import java.util.Scanner;

public class SalarioTrabajador {

    static double readNumber(Scanner input) {

        while(!input.hasNextDouble()){
            System.out.print("Please Enter a Valid Number: ");
            input.next();
        }
        return input.nextDouble();
    }
    static double calcularSalario(double horastrabajadas, double tarifa) {
        if (horastrabajadas>40){
            double extras = horastrabajadas-40;
            double tarifaExtra = extras*((0.5*tarifa)+tarifa);
            return (40*tarifa) + (tarifaExtra);

        }
        return horastrabajadas*tarifa;
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Horas Trabajadas: ");
        double horastrabajadas = readNumber(input);
        System.out.print("Tarifa: ");
        double tarifa = readNumber(input);
        input.close();

        double salario = calcularSalario(horastrabajadas,tarifa);
        System.out.println("Salario Trabajador: " + salario + "€");


    }
}
