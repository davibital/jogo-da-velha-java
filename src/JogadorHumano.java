class JogadorHumano extends Jogador {

  public JogadorHumano (String nomeJogador, char simbolo) {
    super(nomeJogador, simbolo);
  }

  @Override
  void fazerJogada(Tabuleiro tabuleiro, int linha, int coluna) {
    tabuleiro.estadoTabuleiro[linha][coluna] = this.simbolo;
    
    tabuleiro.ultimoJogador = this.nomeJogador;
    tabuleiro.jogada++;
  }
}
