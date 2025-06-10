public class Juego {
    private Tablero tablero;
    private Jugador jugador;

    public Juego(Jugador jugador) {
        this.jugador = jugador;
        this.tablero = new Tablero();
    }

    public void iniciar() {
        boolean victoria = false;
        boolean derrota = false;
        while (!victoria && !derrota) {
            tablero.mostrar();
            char accion = jugador.pedirAccion();
            Coordenada coord = jugador.pedirCoordenada();
            if (accion == 'D') {
                if (!tablero.despejar(coord)) {
                    derrota = true;
                }
            } else {
                tablero.marcar(coord);
            }
            victoria = tablero.todasDespejadas();
        }
        tablero.mostrar();
        if (victoria) {
            System.out.println("¡Victoria!");
        } else {
            System.out.println("¡Boom! Derrota");
            tablero.revelarMinas();
        }
    }
}
