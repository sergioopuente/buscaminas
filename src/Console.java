import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);

    public char leerAccion() {
        System.out.println("[D]espejar o [M]arcar mina?");
        String line = scanner.nextLine().trim().toUpperCase();
        while (!line.equals("D") && !line.equals("M")) {
            System.out.println("Ingrese 'D' para despejar o 'M' para marcar");
            line = scanner.nextLine().trim().toUpperCase();
        }
        return line.charAt(0);
    }

    public Coordenada leerCoordenada() {
        System.out.println("Elija coordenada:");
        int fila = leerEntero("Fila: ");
        int columna = leerEntero("Columna: ");
        // ajustar a indice base 0
        return new Coordenada(fila - 1, columna - 1);
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print(mensaje);
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpiar salto
        if (valor < 1 || valor > 6) {
            System.out.println("Valor fuera de rango (1-6). Intente de nuevo.");
            return leerEntero(mensaje);
        }
        return valor;
    }
}
