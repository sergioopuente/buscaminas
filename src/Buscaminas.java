public class Buscaminas {
    public static void main(String[] args) {
        Console console = new Console();
        Jugador jugador = new Jugador(console);
        Juego juego = new Juego(jugador);
        juego.jugar();
    }
}
