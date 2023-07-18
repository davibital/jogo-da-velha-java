class Jogador {
  protected String nomeJogador;
  protected char simbolo;

  // Construtor da classe
  public Jogador (String nomeJogador, char simbolo) {
    this.nomeJogador = nomeJogador;
    this.simbolo = simbolo;
  }

  public Jogador () {
    this.nomeJogador = "";
    this.simbolo = ' ';
  }

  void fazerJogada (Tabuleiro tabuleiro, int linha, int coluna) { }

  void fazerJogada (Tabuleiro tabuleiro) { }
}
