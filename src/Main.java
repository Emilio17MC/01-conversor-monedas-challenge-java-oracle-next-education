import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultarAPI consultarAPI = new ConsultarAPI();

        Moneda moneda = null;

        while (true) {
            System.out.println("********************");

            System.out.println("Sea bienvenido(a) al conversor de moneda");
            System.out.println("1) Dólar => Peso Argentino");
            System.out.println("2) Peso Argentino => Dólar");
            System.out.println("3) Dólar => Real Brasileño");
            System.out.println("4) Real Brasileño => Dólar");
            System.out.println("5) Dólar => Peso Colombiano");
            System.out.println("6) Peso Colombiano => Dólar");
            System.out.println("7) Salir");

            try {
                System.out.println("Elija una opción válida: ");
                int opcion = lectura.nextInt();

                if (opcion == 7) {
                    break;
                }

                System.out.println("Ingresa el valor que deseas convertir");
                double cantidad = lectura.nextDouble();

                if (opcion >= 1 && opcion <= 6) {
                    String monedaOrigen = "";
                    String monedaDestino = "";

                    if (opcion == 1) {
                        monedaOrigen = "USD";
                        monedaDestino = "ARS";
                    } else if (opcion == 2) {
                        monedaOrigen = "ARS";
                        monedaDestino = "USD";
                    } else if (opcion == 3) {
                        monedaOrigen = "USD";
                        monedaDestino = "BRL";
                    } else if (opcion == 4) {
                        monedaOrigen = "BRL";
                        monedaDestino = "USD";
                    } else if (opcion == 5) {
                        monedaOrigen = "USD";
                        monedaDestino = "COP";
                    } else if (opcion == 6) {
                        monedaOrigen = "COP";
                        monedaDestino = "USD";
                    }

                    moneda = consultarAPI.generarConversion(monedaOrigen, monedaDestino, cantidad);

                    if (moneda != null) {
                        System.out.println("El resultado de convertir "
                                + cantidad + " " + monedaOrigen + " a "
                                + monedaDestino + " es: " + moneda.conversion_result());
                    } else {
                        System.out.println("Ocurrió un error al realizar la conversión");
                    }

                } else {
                    System.out.println("Opción no válida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número válido");
                lectura.nextLine();
            }
        }


    }
}