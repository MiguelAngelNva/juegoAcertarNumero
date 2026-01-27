public class GameController {
    public static void main(String[] args) {

        GameView view = new GameView();

        view.showMessage("NumLogic Explorer - Adivina el número");

        while (true) {

            int level = view.readLevel();
            int min;
            int max;

            /*
             * while (true) {
             * min = view.readInt("Ingrese el límite inferior (min):");
             * max = view.readInt("Ingrese el límite superior (max):");
             * 
             * if (min < max) {
             * break;
             * }
             * view.showMessage("El mínimo debe ser menor que el máximo. Intente de
             * nuevo.");
             * }
             */

            if (level == 1) {
                min = 1;
                max = 10;
            } else if (level == 2) {
                min = 1;
                max = 100;
            } else {
                min = 1;
                max = 1000;
            }

            view.showMessage("Nivel seleccionado: " + view.levelName(level));
            view.showMessage("Rango configurado: " + min + " a " + max);

            Game game = new Game(min, max);
            view.showMessage("Adivina el número...");

            // loop del juego
            while (true) {
                int userNumber = view.readInt("Ingrese su número:");

                if (userNumber < min || userNumber > max) {
                    view.showMessage("Debe estar dentro del rango " + min + " a " + max + ".");
                    continue;
                }

                String result = game.checkNumber(userNumber);
                view.showMessage(result);

                if (result.startsWith("Correcto!")) {
                    break;
                }
            }

            if (!view.askPlayAgain()) {
                view.showMessage("Gracias por jugar.");
                break;
            }
        }
    }
}
