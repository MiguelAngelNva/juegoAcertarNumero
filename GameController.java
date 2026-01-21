public class GameController {
    public static void main(String[] args) {

        GameView view = new GameView();

        view.showMessage("NumLogic Explorer - Adivina el número");

        while (true) {

            int min;
            int max;

            // Pedir rango y validar min < max
            while (true) {
                min = view.readInt("Ingrese el límite inferior (min):");
                max = view.readInt("Ingrese el límite superior (max):");

                if (min < max) {
                    break;
                }
                view.showMessage("El mínimo debe ser menor que el máximo. Intente de nuevo.");
            }

            // Crear juego con rango válido
            Game game = new Game(min, max);

            view.showMessage("Rango configurado: " + min + " a " + max);
            view.showMessage("Adivina el número...");

            // Loop de juego
            while (true) {
                int userNumber = view.readInt("Ingrese su número:");

                String result = game.checkNumber(userNumber);
                view.showMessage(result);

                if (result.startsWith("Correcto!")) {
                    break;
                }
            }

            // Reinicio completo
            if (!view.askPlayAgain()) {
                view.showMessage("Gracias por jugar.");
                break;
            }
        }
    }
}
