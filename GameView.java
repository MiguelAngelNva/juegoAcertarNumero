import java.util.Scanner;

public class GameView {
    private Scanner scanner = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int readInt(String prompt) {
        showMessage(prompt);

        while (!scanner.hasNextInt()) {
            showMessage("Error. Ingrese solo números.");
            scanner.next();
            showMessage(prompt);
        }

        return scanner.nextInt();
    }

    public boolean askPlayAgain() {
        showMessage("¿Desea jugar de nuevo? (S/N)");
        String answer = scanner.next().trim().toUpperCase();
        return answer.equals("S") || answer.equals("SI");
    }

    public int readLevel() {
        showMessage("Selecciona un nivel de dificultad:");
        showMessage("1: Principiante (1 - 10)");
        showMessage("2: Intermedio  (1 - 100)");
        showMessage("3: Avanzado    (1 - 1000)");

        int level;

        while (true) {
            level = readInt("Opción 1-3: ");
            if (level >= 1 && level <= 3) {
                return level;
            }
            showMessage("Opción inválida. Intente de nuevo.");
        }
    }

    public String levelName(int level) {
        if (level == 1)
            return "Principiante";
        if (level == 2)
            return "Intermedio";
        return "Avanzado";
    }
}