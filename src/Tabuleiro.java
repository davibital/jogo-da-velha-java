class Tabuleiro {
  
  char estadoTabuleiro [][];
  int jogada;
  String ultimoJogador;
  boolean jogoEmAndamento;

  // Construtor da classe
  Tabuleiro () {
    estadoTabuleiro = new char[3][3];
    for (int i = 0; i < estadoTabuleiro.length; i++)
      for (int j = 0; j < estadoTabuleiro.length; j++)
        estadoTabuleiro[i][j] = ' ';

    jogada = 0;
    jogoEmAndamento = true;
  }

  // Função para mostrar o tabuleiro no terminal
  void mostrarTabuleiro() {
    System.out.println("\nJogada " + jogada);

    for (int i = 0, j = 0; i < estadoTabuleiro.length; i++) {
      System.out.println("-------------");
      System.out.println("| " + estadoTabuleiro[i][j] + " | " + estadoTabuleiro[i][j + 1] + " | " + estadoTabuleiro[i][j + 2] + " |");
    }
    System.out.println("-------------");
  }

  // Função para verificar se a posição está disponível no tabuleiro
  boolean verificarPosicao(int linha, int coluna) {
    if (estadoTabuleiro[linha][coluna] == ' ') 
      return true;
    
    return false;
  }

  // As verificações a seguir são para determinar o vencedor ou um empate e, consequentemente, o encerramento do jogo.
  String verificarLinhas() {
    for (int i = 0, j = 0; i < estadoTabuleiro.length; i++)
      if (estadoTabuleiro[i][j] == estadoTabuleiro[i][j + 1] && estadoTabuleiro[i][j + 1] == estadoTabuleiro[i][j + 2] && estadoTabuleiro[i][j] != ' ')
        return "completa";

    return "incompleta";
  }

  String verificarColunas() {
    for (int i = 0, j = 0; j < estadoTabuleiro.length; j++)
      if (estadoTabuleiro[i][j] == estadoTabuleiro[i + 1][j] && estadoTabuleiro[i + 1][j] == estadoTabuleiro[i + 2][j] && estadoTabuleiro[i][j] != ' ')
        return "completa";

    return "incompleta";
  }

  String verificarDiagonais() {
    if (estadoTabuleiro[0][0] == estadoTabuleiro[1][1] && estadoTabuleiro[1][1] == estadoTabuleiro[2][2] && estadoTabuleiro[0][0] != ' ')
      return "completa";
    else if (estadoTabuleiro[0][2] == estadoTabuleiro[1][1] && estadoTabuleiro[1][1] == estadoTabuleiro[2][0] && estadoTabuleiro[0][2] != ' ')
      return "completa";

    return "incompleta";
  }

  void verificarTabuleiro() {
    // O jogo se encerra com vitória apenas se o jogador completar uma linha ou uma coluna ou uma diagonal com os seus símbolos.
    if (verificarLinhas() == "completa" || verificarColunas() == "completa" || verificarDiagonais() == "completa") {
      System.out.println("A partida finalizou com vitoria de " + ultimoJogador + "!");
      jogoEmAndamento = false;
    }
    // Ou se o tabuleiro todo for preenchido sem que nenhuma linha ou coluna ou diagonal seja preenchida apenas com simbolos iguais.
    else if (jogada == 9) {
      System.out.println("A partida foi encerrada com um empate!");
      jogoEmAndamento = false;
    }
  }
}
