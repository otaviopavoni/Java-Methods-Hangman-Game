import java.util.Objects;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int mistakes = 0;

        String secret_word = "word";
        char[] secret_word_array = secret_word.toCharArray();
        String[] array = new String[secret_word.length()];

        for (int i = 0; i < secret_word.length(); i++) {
            array[i] = "_";
        }

        while (true){

            boolean found = false;

            for (int i = 0; i < secret_word.length(); i++) {
                System.out.print(array[i] + " ");
            }

            System.out.println("Type a letter: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.isEmpty()) {
                continue;
            }

            char guess = input.charAt(0);

            for (int i = 0; i < secret_word_array.length; i++) {

                if (guess == secret_word_array[i]){
                    array[i] = String.valueOf(guess);
                    found = true;
                }
            }

            if (!found){
                mistakes++;
                showState(mistakes);
            }

            if (isOver(array)){
                System.out.println("Congratulations! You win!");
                break;
            }

            if (mistakes == 7){
                System.out.println("You lost the game!");
                break;
            }


        }

    }

    public static boolean isOver(String[] array){
        for (String s : array) {
            if (Objects.equals(s, "_")) {
                return false;
            }
        }
        return true;
    }

    public static void showState(int mistakes){
        switch (mistakes) {

            case 0:
                System.out.println("""
                
                
                
                
                """);
                break;

            case 1:
                System.out.println("""
                  +---+
                  |   |
                      |
                      |
                      |
                      |
                =========
                """);
                break;

            case 2:
                System.out.println("""
                  +---+
                  |   |
                  O   |
                      |
                      |
                      |
                =========
                """);
                break;

            case 3:
                System.out.println("""
                  +---+
                  |   |
                  O   |
                  |   |
                      |
                      |
                =========
                """);
                break;

            case 4:
                System.out.println("""
                  +---+
                  |   |
                  O   |
                 /|   |
                      |
                      |
                =========
                """);
                break;

            case 5:
                System.out.println("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                      |
                      |
                =========
                """);
                break;

            case 6:
                System.out.println("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                 /    |
                      |
                =========
                """);
                break;

            case 7:
                System.out.println("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                 / \\  |
                      |
                =========
                """);
                break;

            default:
                System.out.println("Erro inválido.");
        }
    }
}