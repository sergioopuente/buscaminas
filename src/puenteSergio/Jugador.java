package puenteSergio;

import java.util.Scanner;

public class Jugador {
    private boolean estaVivo = true;

    public void realizarTurno(Tablero tablero, Scanner entrada) {
        System.out.println("Introduce la fila y la columna (valores del 1 al 6):");
        int fila = entrada.nextInt() - 1;
        int columna = entrada.nextInt() - 1;

        if (!tablero.esCoordenadaValida(fila, columna)) {
            System.out.println("Coordenada no válida. Inténtalo otra vez.");
            return;
        }

        if (tablero.hayMinaEn(fila, columna)) {
            System.out.println("💥 ¡KABOOM! Pisaste una mina. Fin del juego.");
            tablero.revelarMina(fila, columna);
            estaVivo = false;
        } else {
            tablero.revelarCasilla(fila, columna);
            System.out.println("✅ Casilla limpia. Continúa...");
        }
    }

    public boolean estaConVida() {
        return estaVivo;
    }
}
