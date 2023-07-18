import java.util.Random;

class JogadorArtificial extends Jogador {

  public JogadorArtificial (String nomeJogador, char simbolo) {
    super(nomeJogador, simbolo);
  }

  private int gerarNumeroAleatorio() {
    Random random = new Random();

    // Gera número aleatório no intervalo entre 1 e 9
    int numeroAleatorio = random.nextInt(9) + 1;

    return numeroAleatorio;
  }
  
  @Override
  void fazerJogada(Tabuleiro tabuleiro) {
    int linha, coluna;
    
    // Laço de repetição para que outra posição do tabuleiro caso a posição escolhida anteriormente esteja indisponível
    do {
      int posicao = gerarNumeroAleatorio();

      // Transformação da posição em número para a posição na matriz do tabuleiro
      switch (posicao) {
        case 1:
          linha = 0;
          coluna = 0;
          break;
        case 2:
          linha = 0;
          coluna = 1;
          break;
        case 3:
          linha = 0;
          coluna = 2;
          break;
        case 4:
          linha = 1;
          coluna = 0;
          break;
        case 5:
          linha = 1;
          coluna = 1;
          break;
        case 6:
          linha = 1;
          coluna = 2;
          break;
        case 7:
          linha = 2;
          coluna = 0;
          break;
        case 8:
          linha = 2;
          coluna = 1;
          break;
        case 9:
          linha = 2;
          coluna = 2;
          break;
        default:
          System.out.println("Posicao invalida!");
          return;
      }
    }

    // Verificação da disponibilidade da posição no tabuleiro
    while (tabuleiro.verificarPosicao(linha, coluna) == false);

    // Aqui que é efetivada a jogada na posição escolhida
    tabuleiro.estadoTabuleiro[linha][coluna] = this.simbolo;
    
    tabuleiro.ultimoJogador = this.nomeJogador;
    tabuleiro.jogada++;
  }
}
