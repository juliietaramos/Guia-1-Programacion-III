import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
    // Listas de datos para usar en los ejercicios
    private static final List<Integer> numeros = List.of(8, 3, 5, 1, 9, 6, 12, 3, 7, 4, 2, 10, 15, 20);
    private static final List<String> nombres = List.of("Juan", "Ana", "Pedro", "Carla", "Miguel");
    private static final List<String> palabras = List.of("Java", "Stream", "Lambda", "Funcional", "API");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            System.out.println("\n===== MENÚ DE EJERCICIOS STREAMS Y LAMBDAS =====");
            System.out.println("1. Filtrar números pares");
            System.out.println("2. Transformar una lista de nombres a mayúsculas");
            System.out.println("3. Ordenar una lista de números");
            System.out.println("4. Contar elementos mayores a un valor dado");
            System.out.println("5. Obtener los primeros 5 elementos de una lista");
            System.out.println("6. Convertir una lista de palabras en su longitud");
            System.out.println("7. Concatenar nombres con una separación");
            System.out.println("8. Eliminar duplicados de una lista");
            System.out.println("9. Obtener los 3 números más grandes de una lista");
            System.out.println("10. Agrupar palabras por su longitud");
            System.out.println("11. Encontrar el producto de todos los números de una lista");
            System.out.println("12. Obtener el nombre más largo de una lista");
            System.out.println("13. Convertir una lista de enteros en una cadena separada por guiones");
            System.out.println("14. Agrupar una lista de números en pares e impares");
            System.out.println("15. Obtener la suma de los cuadrados de los números impares");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> filtrarNumerosPares().forEach(System.out::println);
                case 2 -> transformarNombresAMayusculas().forEach(System.out::println);
                case 3 -> ordenarListaNumeros().forEach(System.out::println);
                case 4 -> System.out.printf("Cantidad de números mayores que 5: %d", contarMayoresQue(5));
                case 5 -> System.out.println("" + obtenerPrimeros5Elementos());
                case 6 -> System.out.println(convertirPalabrasALongitud());
                case 7 -> System.out.println(concatenarNombres());
                case 8 -> System.out.println(eliminarDuplicados());
                case 9 -> obtenerTop3Numeros().forEach(System.out::println);
                //case 10 -> agruparPalabrasPorLongitud();
                //case 11 -> productoDeNumeros();
                //case 12 -> nombreMasLargo();
                //case 13 -> listaEnterosComoString();
                //case 14 -> agruparParesEImpares();
                //case 15 -> sumaDeCuadradosImpares();
                //case 0 -> System.out.println("Saliendo del programa...");
                //default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    //Resolucion de los ejercicios

    private static List<Integer> filtrarNumerosPares(){
        return numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();
    }

    private static List<String> transformarNombresAMayusculas(){
        return nombres.stream()
                .map(String::toUpperCase)
                .toList();
    }

    private static List<Integer> ordenarListaNumeros(){
        return numeros.stream()
                .sorted().toList();
    }

    private static Long contarMayoresQue(int num){
        return numeros.stream()
                .filter(n -> n>num)
                .count();
    }

    private static List<Integer> obtenerPrimeros5Elementos(){
        return numeros.stream()
                .limit(5)
                .toList();
    }

    private static List<Integer> convertirPalabrasALongitud(){
        return palabras.stream()
                .map(String::length)
                .toList();
    }

    private static String concatenarNombres(){
        return nombres.stream()
                .reduce((p1 , p2) -> p1 + ", " + p2)
                .orElse(" ");
    }

    private static List<Integer> eliminarDuplicados(){
        return numeros.stream()
                .distinct()
                .toList();
    }

    private static List<Integer> obtenerTop3Numeros(){
        return numeros.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
    }

}