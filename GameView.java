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
}