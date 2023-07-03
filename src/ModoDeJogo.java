import java.util.Scanner;

class ModoDeJogo {
  
  public void jogadorContraJogador (Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
    Scanner keyboard = new Scanner(System.in);
    int posicao;

    while (tabuleiro.jogoEmAndamento) {
      posicao = keyboard.nextInt();
      jogador1.fazerJogada(tabuleiro, posicao);
      tabuleiro.mostrarTabuleiro();
      tabuleiro.verificarTabuleiro();

      // Quebra do laço caso o primeiro jogador tenha vencido a partida na sua jogada.
      if (!tabuleiro.jogoEmAndamento)
        break;
      
      posicao = keyboard.nextInt();
      jogador2.fazerJogada(tabuleiro, posicao);
      tabuleiro.mostrarTabuleiro();
      tabuleiro.verificarTabuleiro();
    }

    keyboard.close();
  }

  public void jogadorContraComputador (Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
    Scanner keyboard = new Scanner(System.in);
    int posicao;

    while (tabuleiro.jogoEmAndamento) {
      posicao = keyboard.nextInt();
      jogador1.fazerJogada(tabuleiro, posicao);
      tabuleiro.mostrarTabuleiro();
      tabuleiro.verificarTabuleiro();

      // Quebra do laço caso o primeiro jogador tenha vencido a partida na sua jogada.
      if (!tabuleiro.jogoEmAndamento)
        break;
      
      jogador2.fazerJogada(tabuleiro);
      tabuleiro.mostrarTabuleiro();
      tabuleiro.verificarTabuleiro();
    }

    keyboard.close();
  }

  public void computadorContraComputador (Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
    while (tabuleiro.jogoEmAndamento) {
      jogador1.fazerJogada(tabuleiro);
      tabuleiro.mostrarTabuleiro();
      tabuleiro.verificarTabuleiro();

      // Quebra do laço caso o primeiro jogador tenha vencido a partida na sua jogada.
      if (!tabuleiro.jogoEmAndamento)
        break;
      
      jogador2.fazerJogada(tabuleiro);
      tabuleiro.mostrarTabuleiro();
      tabuleiro.verificarTabuleiro();
    }
  }

}
