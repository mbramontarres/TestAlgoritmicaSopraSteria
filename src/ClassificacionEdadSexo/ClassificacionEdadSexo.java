package ClassificacionEdadSexo;

import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ClassificacionEdadSexo {


    static int readNumber() {
        Scanner input = new Scanner(System.in);
        if(input.hasNextInt()){
            int number = input.nextInt();
            if(number>0){
                return number;
            }
            else{
                System.out.print("Por favor entra una edad correcta:");
                return readNumber();
            }

        }
        else{
            System.out.print("Por favor entra una edad correcta:");
            return readNumber();
        }
    }
    static Vector<Persona> readPersonas(){
        Vector<Persona> Personas = new Vector<Persona>(50);
        Scanner input = new Scanner(System.in);
        for(int i = 0; i< Personas.capacity(); i++){
            System.out.println("Persona " + (i+1) + ": ");
            System.out.print("Sexo(M/F): ");
            String sexo = input.next();
            while(!sexo.equals("F") && !sexo.equals("M")){
                System.out.print("Por favor entre M por masculino o F por Femenino: ");
                sexo = input.next();
                System.out.print(sexo);
            }

            System.out.print("Edad: ");

            int edad = readNumber();


            Persona p = new Persona(sexo,edad);
            Personas.add(p);
        }

        input.close();

        return Personas;
    }


    public static void main(String[] args) {

        Vector<Persona> Personas = readPersonas();

        Stream<Persona> mayoresEdad = Personas.stream().filter(x -> x.getEdad()>=18);
        Stream<Persona> menoresEdad = Personas.stream().filter(x -> x.getEdad()<18);
        Stream<Persona> menoresEdadMujeres = Personas.stream().filter(x -> x.getEdad()<18 && Objects.equals(x.getSexo(), "F"));
        Stream<Persona> mayoresEdadHombres = Personas.stream().filter(x -> x.getEdad()>=18 && Objects.equals(x.getSexo(), "M"));
        long countMayoresEdad = mayoresEdad.count();
        long countMenoresEdad = menoresEdad.count();
        Stream<Persona> mujeres = Personas.stream().filter(x -> Objects.equals(x.getSexo(), "F"));

        System.out.println("a. Mayores de edad: " + countMayoresEdad);
        System.out.println("b. Menores de edad: " + countMenoresEdad);
        System.out.println("c. Personas masculinas mayores de edad: " + mayoresEdadHombres.count());
        System.out.println("d. Personas femeninas menores de edad: " +  menoresEdadMujeres.count());
        System.out.println("e. Porcentaje que representan las personas mayores de edad respecto al total de\n" +
                "personas: " + ((countMayoresEdad*100)/Personas.size()) + "%");
        System.out.println("f. Porcentaje que representan las mujeres respecto al total de personas: " + ((mujeres.count()*100)/Personas.size()) + "%");

    }

}
