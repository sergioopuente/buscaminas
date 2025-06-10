import java.util.Random;

public class Tablero {
    private static final int TAMANIO = 6;
    private static final int NUM_MINAS = 6;

    private boolean[][] minas = new boolean[TAMANIO][TAMANIO];
    private EstadoCasilla[][] estados = new EstadoCasilla[TAMANIO][TAMANIO];

    private enum EstadoCasilla { CUBIERTA, MARCADA, DESPEJADA }

    public Tablero() {
        inicializar();
    }

    private void inicializar() {
        Random random = new Random();
        int colocadas = 0;
        while (colocadas < NUM_MINAS) {
            int f = random.nextInt(TAMANIO);
            int c = random.nextInt(TAMANIO);
            if (!minas[f][c]) {
                minas[f][c] = true;
                colocadas++;
            }
        }
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                estados[i][j] = EstadoCasilla.CUBIERTA;
            }
        }
    }

    public boolean despejar(Coordenada coord) {
        int f = coord.getFila();
        int c = coord.getColumna();
        if (estados[f][c] == EstadoCasilla.MARCADA || estados[f][c] == EstadoCasilla.DESPEJADA) {
            return true; // no efecto
        }
        if (minas[f][c]) {
            estados[f][c] = EstadoCasilla.DESPEJADA;
            return false; // mina: derrota
        }
        estados[f][c] = EstadoCasilla.DESPEJADA;
        return true;
    }

    public void marcar(Coordenada coord) {
        int f = coord.getFila();
        int c = coord.getColumna();
        if (estados[f][c] == EstadoCasilla.DESPEJADA) {
            return; // no se puede marcar
        }
        if (estados[f][c] == EstadoCasilla.MARCADA) {
            estados[f][c] = EstadoCasilla.CUBIERTA; // desmarcar
        } else {
            estados[f][c] = EstadoCasilla.MARCADA;
        }
    }

    public boolean todasDespejadas() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                if (!minas[i][j] && estados[i][j] != EstadoCasilla.DESPEJADA) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrar() {
        System.out.println("BUSCAMINAS");
        System.out.print("  ");
        for (int i = 1; i <= TAMANIO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < TAMANIO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANIO; j++) {
                char vista = '_';
                switch (estados[i][j]) {
                    case DESPEJADA:
                        vista = 'D';
                        break;
                    case MARCADA:
                        vista = 'M';
                        break;
                    default:
                        vista = '_';
                }
                System.out.print(vista + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // For testing or to show mines at end
    public void revelarMinas() {
        System.out.println("Ubicacion de minas:");
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print((minas[i][j] ? '*' : '.') + " ");
            }
            System.out.println();
        }
    }
}
