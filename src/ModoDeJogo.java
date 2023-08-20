import java.util.Scanner;
import java.util.Random;

class ModoDeJogo {
  static String nomeJogador1;
  static String nomeJogador2;
  static Scanner keyboard = new Scanner(System.in);
  static Jogador jogadores[];
  static Tabuleiro tabuleiro;
  static int jogadorVez;
  
  public static void jogadorContraJogador () {
    Random random = new Random();
    tabuleiro = Tabuleiro.getInstance();
    int linha, coluna;
    jogadorVez = random.nextInt(2);
    
    System.out.println("Digite o nome do primeiro jogador (este jogara com o simbolo X): ");
    nomeJogador1 = keyboard.nextLine();
    
    System.out.println("Digite o nome do segundo jogador (este jogara com o simbolo O): ");
    nomeJogador2 = keyboard.nextLine();

    jogadores = new Jogador[] {new JogadorHumano(nomeJogador1, 'X'), new JogadorHumano(nomeJogador2, 'O')};
    
    while (tabuleiro.jogoEmAndamento) {
      tabuleiro.mostrarTabuleiro();

      System.out.println("\nVez do jogador " + jogadores[jogadorVez].nomeJogador + ":");
      System.out.print("\nLinha: ");
      linha = keyboard.nextInt();
      System.out.print("Coluna: ");
      coluna = keyboard.nextInt();

      if (!tabuleiro.verificarPosicao(linha, coluna) || linha > 2 || coluna > 2 || linha < 0 || coluna < 0) {
        System.out.println("Posicao invalida, faca uma nova jogada.");
        continue;
      }

      jogadores[jogadorVez].fazerJogada(tabuleiro, linha, coluna);
      
      tabuleiro.verificarTabuleiro();
      jogadorVez = (jogadorVez + 1) % 2;
    }

    keyboard.close();
  }

  public static void jogadorContraComputador () {
    Random random = new Random();
    tabuleiro = Tabuleiro.getInstance();
    int linha, coluna;
    jogadorVez = random.nextInt(2);
    
    System.out.println("Digite o nome do primeiro jogador (este jogara com o simbolo X): ");
    nomeJogador1 = keyboard.nextLine();
    
    System.out.println("Digite o nome do segundo jogador (este jogara com o simbolo O): ");
    nomeJogador2 = keyboard.nextLine();

    jogadores = new Jogador[] {new JogadorHumano(nomeJogador1, 'X'), new JogadorArtificial(nomeJogador2, 'O')};
    
    while (tabuleiro.jogoEmAndamento) {
      tabuleiro.mostrarTabuleiro();
      if (jogadorVez == 0) {
        System.out.println("\nVez do jogador " + jogadores[jogadorVez].nomeJogador + ":");
        System.out.print("\nLinha: ");
        linha = keyboard.nextInt();
        System.out.print("Coluna: ");
        coluna = keyboard.nextInt();
        if (!tabuleiro.verificarPosicao(linha, coluna) || linha > 2 || coluna > 2 || linha < 0 || coluna < 0) {
          System.out.println("Posicao invalida, faca uma nova jogada.");
          continue;
        }

        jogadores[jogadorVez].fazerJogada(tabuleiro, linha, coluna);

      } else {
        System.out.println("\nVez do jogador " + jogadores[jogadorVez].nomeJogador + ":");
        jogadores[jogadorVez].fazerJogada(tabuleiro);
      }

      tabuleiro.verificarTabuleiro();
      jogadorVez = (jogadorVez + 1) % 2;
    }

    keyboard.close();
  }

  public static void computadorContraComputador () {
    Random random = new Random();
    tabuleiro = Tabuleiro.getInstance();
    jogadorVez = random.nextInt(2);
    
    System.out.println("Digite o nome do primeiro jogador (este jogara com o simbolo X): ");
    nomeJogador1 = keyboard.nextLine();
    
    System.out.println("Digite o nome do segundo jogador (este jogara com o simbolo O): ");
    nomeJogador2 = keyboard.nextLine();

    jogadores = new Jogador[] {new JogadorArtificial(nomeJogador1, 'X'), new JogadorArtificial(nomeJogador2, 'O')};
    
    while (tabuleiro.jogoEmAndamento) {
      tabuleiro.mostrarTabuleiro();
      System.out.println("\nVez do jogador " + jogadores[jogadorVez].nomeJogador + ":");
      jogadores[jogadorVez].fazerJogada(tabuleiro);

      tabuleiro.verificarTabuleiro();
      jogadorVez = (jogadorVez + 1) % 2;
    }
  }

}
