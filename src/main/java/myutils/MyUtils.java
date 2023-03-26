package myutils;

import java.util.Scanner;
import java.util.Date;

public class MyUtils {

    static Scanner sc = new Scanner(System.in);
    static private final int MIN = 1;
    static private final int MAX_MES = 12;
    static private final String[] UNIDAD_TIEMPO = {"dia", "mes", "año"};

    // con el constructor vacio crea la fecho cuando fue creada
    static private final Date MAX_DATE = new Date();

    // @param cadena Strint cadena que es vol invertir
    // @return cadena invertida (null per cadenes nulls).
    public static String inverteix(String cadena) {
        String resultat = "";

        for (int i = cadena.length(); i > 0; i--) {

            resultat += cadena.charAt(i - 1);
        }

        return resultat;

    }

    // @param day int dia del naixement -- array pos -> 0
    // @param month int  mes del naixement -- array pos -> 1
    // @param year int any del naixement -- array pos -> 2
    // @return edat de la persona, per edat>150 retorna -1, per dates impossibles retorna -2
    public static int edat(int[] valores) {

        // En la clase date Los meses van del 0-11 y a los años se le restan -1900
        int edad;

        // Fechas imp
        if (!dataValida(valores)) {

            return -2;

            // Edades ++ a 150, 1750 -> +1900 (date year -1900) +150 
        } else if (!numeroRango(valores[2], MAX_DATE.getYear() + 1900, MAX_DATE.getYear() + 1750)) {

            return -1;
        }

        // Creamos Date de la fecha de nacimiento
        Date fechaNacimiento = new Date(valores[2] - 1900, valores[1] - 1, valores[0]);

        // Obtenemos la edad año actual - año de Nacimiento
        edad = (MAX_DATE.getYear() - fechaNacimiento.getYear()) - 1;

        // Correccion por meses
        if (fechaNacimiento.getMonth() < MAX_DATE.getMonth()) {
            edad++;

            // Correccion por dias (si estamos en el mismo mes)
        } else if (fechaNacimiento.getMonth() == MAX_DATE.getMonth()) {
            if (fechaNacimiento.getDate() <= MAX_DATE.getDate()) {
                edad++;
            }
        }

        // devolvemos la edad definitiva 
        return edad;
    }

    // @param numero número del que es calcula el factorial
    // @return retorna el factorial d'un número. Si el nombre es negatiu retorna -1.
    // no te sentit un factorial amb decimals per tant double -> 
    public static int factorial(int numero) {

        // dado que el 1 y el 0 tienen el mismo valor, nos podemos saltar una itineracion 
        if (numero == 0 || numero == 1) {

            return 1;

            // valores pos
        } else if (numero > 1) {

            int resultat = numero * factorial(numero - 1);
            return resultat;

            // resto de enteros, valores -
        } else {

            return -1;
        }
    }

    // metodo para asegurarnos de que entran un numero
    private static int introNum(String unidadTiempo) {

        System.out.print("Introdueix el num del " + unidadTiempo + " \n>");

        do {
            if (sc.hasNextInt()) {

                int num = sc.nextInt();
                return num;
            } else {
                System.err.println("Error. Introdueix un numero entero ");
                System.out.print(">");
                sc.next();
            }

        } while (true);

    }

    // indica si el num se encuentra en el rango especifico
    private static boolean numeroRango(int num, int maxNum, int minNum) {

        return (num >= minNum && num <= maxNum);

    }

    // calcula el max de dias que hay en un mes
    private static int maxDiaMes(int mes, int año) {

        int maxDia;

        if (mes % 2 == 0) {
            if (mes <= 7) {

                if (mes == 2) {
                    if (esAnyTraspaso(año)) {

                        maxDia = 29;
                    } else {
                        maxDia = 28;
                    }

                } else {
                    maxDia = 30;
                }

            } else {

                maxDia = 31;
            }

        } else {
            if (mes <= 7) {

                maxDia = 31;

            } else {
                maxDia = 30;
            }

        }

        return maxDia;

    }

    // indica si el año es de traspaso
    private static boolean esAnyTraspaso(int año) {

        return año % 4 == 0 && año % 100 != 0 || año % 400 == 0;
    }

    // crea un array, en este caso con dia, mes, año 
    public static int[] pedirFecha() {

        int[] fecha = new int[UNIDAD_TIEMPO.length];

        for (int i = 0; i < fecha.length; i++) {

            fecha[i] = introNum(UNIDAD_TIEMPO[i]);

        }

        return fecha;
    }

    //valida si la fecha es correcta, y tb que ya haya pasado
    private static boolean dataValida(int[] fecha) {

        if (fecha[2] == MAX_DATE.getYear() + 1900) {
            if (fecha[1] == MAX_DATE.getMonth() + 1) {

                return numeroRango(fecha[0], MAX_DATE.getDate(), MIN);

            }

        }

        return numeroRango(fecha[0], maxDiaMes(fecha[1], fecha[2]), MIN)
                && numeroRango(fecha[1], MAX_MES, MIN);

    }

}

