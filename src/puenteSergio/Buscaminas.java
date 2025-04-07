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