import java.util.Scanner;

public class Main {
  public static void main (String args[]) {
    Scanner keyboard = new Scanner(System.in);
    int modoDeJogo;
    ModoDeJogo jogoSelecionado = new ModoDeJogo();

    System.out.println("Este eh o classico jogo da velha, disputado por 2 jogadores, cujo objetivo deles eh formar uma linha ou coluna ou diagonal com o seu respectivo simbolo. O jogo eh jogado em turnos e cada posicao eh determinada pelo numero da linha e numero da coluna, de forma similar ao jogo de batalha naval (a numeracao das linhas e das colunas vao de 0 a 2)");
    
    System.out.println("\nSelecione o modo de jogo: ");
    System.out.print("Jogador contra Jogador (digite 1)\nJogador contra Computador (digite 2)\nComputador contra Computador (digite 3)\n");
    modoDeJogo = keyboard.nextInt();    

    switch (modoDeJogo) {
      case 1:
        jogoSelecionado.jogadorContraJogador();
        break;
      case 2:
        jogoSelecionado.jogadorContraComputador();
        break;
      case 3:
        jogoSelecionado.computadorContraComputador();
        break;
      default:
        System.out.println("Modo de jogo invalido!");
        break;
    }

    keyboard.close();
  }
    
}