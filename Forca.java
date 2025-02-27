
import java.util.Random;
import java.util.Scanner;

public class Forca {

    public static void main(String[] args) {
        String[] palavras = {"java", "programacao", "computador", "desenvolvimento", "algoritmo"};
        Random random = new Random();
        int indice = random.nextInt(palavras.length); // Escolhe uma palavra aleatória
        String palavraEscolhida = palavras[indice];
        char[] palavraAdivinhada = new char[palavraEscolhida.length()];
        for (int i = 0; i < palavraAdivinhada.length; i++) {
            palavraAdivinhada[i] = '_'; // Inicializa a palavra com _ (letras não adivinhadas)
        }

        int tentativas = 6; // Número máximo de tentativas
        boolean palavraCorreta = false;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bem-vindo ao Jogo da Forca!");
            System.out.println("A palavra tem " + palavraEscolhida.length() + " letras.");

            while (tentativas > 0 && !palavraCorreta) {
                System.out.println("\nPalavra: " + new String(palavraAdivinhada));
                System.out.println("Tentativas restantes: " + tentativas);
                System.out.print("Digite uma letra: ");
                char letra = scanner.next().charAt(0);

                boolean letraCorreta = false;

                // Verifica se a letra está na palavra
                for (int i = 0; i < palavraEscolhida.length(); i++) {
                    if (palavraEscolhida.charAt(i) == letra) {
                        tentativas = -1;
                        palavraAdivinhada[i] = letra; // Substitui o _ pela letra correta
                        letraCorreta = true;
                    }
                }

                if (!letraCorreta) {
                    tentativas--; // Diminui o número de tentativas se a letra não estiver na palavra
                    System.out.println("A letra não está na palavra.");
                }

                // Verifica se o jogador adivinhou a palavra
                palavraCorreta = true;
                for (int i = 0; i < palavraAdivinhada.length; i++) {
                    if (palavraAdivinhada[i] == '_') {
                        palavraCorreta = false;
                        break;
                    }
                }
            }

            if (palavraCorreta) {
                System.out.println("\nParabéns! Você adivinhou a palavra: " + palavraEscolhida);
            } else {
                System.out.println("\nVocê perdeu! A palavra era: " + palavraEscolhida);
            }
        }
    }
}
