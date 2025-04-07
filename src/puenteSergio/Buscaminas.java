public class Buscaminas {
    private static final int TAMANO = 6;
    private static final int MINAS = 6;
    private static final char CUBIERTO = '_';
    private static final char MARCADO = 'M';
    private static final char MINA = '*';
    private static final char DESPEJADO = 'D';

    private char[][] tablero;
    private boolean[][] minas;
    private boolean[][] visible;
    private boolean[][] marcado;

    public Buscaminas() {
        tablero = new char[TAMANO][TAMANO];
        minas = new boolean[TAMANO][TAMANO];
        visible = new boolean[TAMANO][TAMANO];
        marcado = new boolean[TAMANO][TAMANO];
        inicializarJuego();
    }

    private void inicializarJuego() {
        
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = CUBIERTO;
                minas[i][j] = false;
                visible[i][j] = false;
                marcado[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Buscaminas juego = new Buscaminas();
    }
}
private void inicializarJuego() {
  
    Random rand = new Random();
    int minasColocadas = 0;
    while (minasColocadas < MINAS) {
        int fila = rand.nextInt(TAMANO);
        int columna = rand.nextInt(TAMANO);
        if (!minas[fila][columna]) {
            minas[fila][columna] = true;
            minasColocadas++;
        }
    }
}
private void mostrarTablero() {
    System.out.println("\nBUSCAMINAS");
    System.out.print("  ");
    for (int i = 1; i <= TAMANO; i++) {
        System.out.print(i + " ");
    }
    System.out.println();

    for (int i = 0; i < TAMANO; i++) {
        System.out.print((i + 1) + " ");
        for (int j = 0; j < TAMANO; j++) {
            System.out.print(tablero[i][j] + " ");
        }
        System.out.println();
    }
}

private void mostrarTableroCompleto() {
    System.out.println("\nTABLERO COMPLETO");
    System.out.print("  ");
    for (int i = 1; i <= TAMANO; i++) {
        System.out.print(i + " ");
    }
    System.out.println();

    for (int i = 0; i < TAMANO; i++) {
        System.out.print((i + 1) + " ");
        for (int j = 0; j < TAMANO; j++) {
            if (minas[i][j]) {
                System.out.print(MINA + " ");
            } else {
                System.out.print(tablero[i][j] + " ");
            }
        }
        System.out.println();
    }
}
private boolean juegoTerminado;
private boolean victoria;
private int casillasDespejadas;

public Buscaminas() {
    
    juegoTerminado = false;
    victoria = false;
    casillasDespejadas = 0;
}

private void despejar(int fila, int columna) {
    if (marcado[fila][columna] || visible[fila][columna]) {
        return;
    }

    if (minas[fila][columna]) {
        juegoTerminado = true;
        victoria = false;
        return;
    }

    visible[fila][columna] = true;
    tablero[fila][columna] = DESPEJADO;
    casillasDespejadas++;

    if (casillasDespejadas == (TAMANO * TAMANO - MINAS)) {
        juegoTerminado = true;
        victoria = true;
    }
}

private void marcar(int fila, int columna) {
    if (visible[fila][columna]) {
        return;
    }

    if (marcado[fila][columna]) {
        marcado[fila][columna] = false;
        tablero[fila][columna] = CUBIERTO;
    } else {
        marcado[fila][columna] = true;
        tablero[fila][columna] = MARCADO;
    }
}
public void jugar() {
    Scanner scanner = new Scanner(System.in);

    while (!juegoTerminado) {
        mostrarTablero();

        System.out.print("\n[D]espejar o [M]arcar mina? ");
        String accion = scanner.nextLine().toUpperCase();

        if (!accion.equals("D") && !accion.equals("M")) {
            System.out.println("Opción no válida. Use D o M.");
            continue;
        }

        System.out.println("\nElija coordenada:");
        System.out.print("> Fila: ");
        int fila = scanner.nextInt() - 1;
        System.out.print("> Columna: ");
        int columna = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (fila < 0 || fila >= TAMANO || columna < 0 || columna >= TAMANO) {
            System.out.println("Coordenadas fuera de rango. Intente de nuevo.");
            continue;
        }

        if (accion.equals("D")) {
            despejar(fila, columna);
            if (juegoTerminado && !victoria) {
                System.out.println("\nMina???\nHas practiso?!?");
                mostrarTableroCompleto();
            } else if (victoria) {
                System.out.println("\nEnhorísima: Un despejado todo el fashion!!!");
                mostrarTableroCompleto();
            } else {
                System.out.println("\nCoordenada despejada");
            }
        } else {
            marcar(fila, columna);
            System.out.println("\nCoordenada marcada");
        }
    }

    scanner.close();
}

public static void main(String[] args) {
    Buscaminas juego = new Buscaminas();
    juego.jugar();
}