
import javax.swing.*;
import java.awt.Dimension;


public class IniciaJogo extends JFrame {
    public static void main(String[] args) {
        Jogo jogo = new Jogo("Jogo 1");
        Jogo jogo2 = new Jogo("Jogo 2");
        Dimension tamanho = jogo.getSize();
        int x = (int) tamanho.getWidth();
        int y = (int) tamanho.getHeight();
        Pontuacao pontuacao = new Pontuacao("Jogador 1", jogo);
        Pontuacao pontuacao2 = new Pontuacao("Jogador 2", jogo2);
        //pontuacao.run();

        pontuacao.setBounds(x/1000, 0, x, y / 5);
        pontuacao2.setBounds(x, 0, x, y / 5);
        jogo.setBounds(x, y / 5, x, y);
        jogo2.setBounds(0, y / 5, x, y);

    }

}
