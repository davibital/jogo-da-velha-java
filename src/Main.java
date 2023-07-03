import java.util.Scanner;

public class Main {
  public static void main (String args[]) {
    Scanner keyboard = new Scanner(System.in);
    String nomeJogador1, nomeJogador2;
    int modoDeJogo;

    System.out.println("Digite o nome do primeiro jogador (este jogara com o simbolo X): ");
    nomeJogador1 = keyboard.nextLine();

    System.out.println("Digite o nome do segundo jogador (este jogara com o simbolo O): ");
    nomeJogador2 = keyboard.nextLine();
    
    System.out.println("\nSelecione o modo de jogo: ");
    System.out.print("Jogador contra Jogador (digite 1)\nJogador contra Computador (digite 2)\nComputador contra Computador (digite 3)\n");
    modoDeJogo = keyboard.nextInt();

    Jogador jogador1 = new Jogador(nomeJogador1, 'X');
    Jogador jogador2 = new Jogador(nomeJogador2, 'O');
    Tabuleiro tabuleiro = new Tabuleiro();
    ModoDeJogo jogoSelecionado = new ModoDeJogo();
    tabuleiro.mostrarTabuleiro();

    switch (modoDeJogo) {
      case 1:
        jogoSelecionado.jogadorContraJogador(jogador1, jogador2, tabuleiro);
        break;
      case 2:
        jogoSelecionado.jogadorContraComputador(jogador1, jogador2, tabuleiro);
        break;
      case 3:
        jogoSelecionado.computadorContraComputador(jogador1, jogador2, tabuleiro);
        break;
      default:
        System.out.println("Modo de jogo invalido!");
        break;
    }

    
  }
    
}