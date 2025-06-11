public class Jugador {
    private Console console;

    public Jugador(Console console) {
        this.console = console;
    }

    public Accion pedirAccion() {
        return console.leerAccion();
    }

    public Coordenada pedirCoordenada() {
        return console.leerCoordenada();
    }
}
