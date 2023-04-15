
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.LinkedList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;


public class Jogo extends JFrame implements ActionListener {
    private int numero_barcos = 0;
    private int numero_tiros = 0;
    private int numero_acertos = 0;
    private int numero_erros = 0;
    private int contador = 0;
    private final int ALTURA = 800;
    private final int LARGURA = 800;
    private final int TAMANHO_MATRIZ = 10;
    private JButton tabuleiro[][] = new JButton[TAMANHO_MATRIZ][TAMANHO_MATRIZ];
    private Image agua;
    private Image barco;
    private Image explosao;
    private boolean atualizou = false;
    private LinkedList<Integer> coordenadaX = new LinkedList<Integer>();
    private LinkedList<Integer> coordenadaY = new LinkedList<Integer>();

    public Jogo(String name) {
        setFocusable(true);
        this.setTitle(name);
        this.setSize(ALTURA, LARGURA);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        String caminho = "C:/Users/Fulvio/Desktop/bat/BatalhaNaval-master/Batalha_naval-JogoForca/Imagens/agua.png";
        ImageIcon agua1Icon = new ImageIcon(caminho);
        String caminho2 = "C:/Users/Fulvio/Desktop/bat/BatalhaNaval-master/Batalha_naval-JogoForca/Imagens/barco.png";
        ImageIcon barco1Icon = new ImageIcon(caminho2);
        String caminho3 = "C:/Users/Fulvio/Desktop/bat/BatalhaNaval-master/Batalha_naval-JogoForca/Imagens/bombear.png";
        ImageIcon explosao1Icon = new ImageIcon(caminho3);
        agua = agua1Icon.getImage();
        barco = barco1Icon.getImage();
        explosao = explosao1Icon.getImage();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridLayout(TAMANHO_MATRIZ, TAMANHO_MATRIZ));
        for (int i = 0; i < TAMANHO_MATRIZ; i++) {
            for (int j = 0; j < TAMANHO_MATRIZ; j++) {
                tabuleiro[i][j] = new JButton();
                tabuleiro[i][j].setBackground(Color.BLUE);
                tabuleiro[i][j].setOpaque(true);
                tabuleiro[i][j].setSize(5, 5);
                tabuleiro[i][j].addActionListener(new BotaoClickListener());
                tabuleiro[i][j].setBorderPainted(false);
                tabuleiro[i][j].setBounds(0, 0, 5, 5);
                tabuleiro[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                tabuleiro[i][j].setIcon(new ImageIcon(agua));
                tabuleiro[i][j].setText("Agua");
                tabuleiro[i][j].setForeground(new Color(0, 0, 0, 0));
                add(tabuleiro[i][j]);
            }
        }
        setSize(ALTURA, LARGURA);
        adicionaBarcoNoTabuleiro();

    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public boolean getAtualizou() {
        return atualizou;
    }

    public void setAtualiou(boolean atualizou) {
        this.atualizou = atualizou;
    }

    public int getNumero_barcos() {
        return numero_barcos;
    }

    public void setNumero_barcos(int numero_barcos) {
        this.numero_barcos = numero_barcos;
    }

    public int getNumero_tiros() {
        return numero_tiros;
    }

    public void setNumero_tiros(int numero_tiros) {
        this.numero_tiros = numero_tiros;
    }

    public int getNumero_acertos() {
        return numero_acertos;
    }

    public void setNumero_acertos(int numero_acertos) {
        this.numero_acertos = numero_acertos;
    }

    public int getNumero_erros() {
        return numero_erros;
    }

    public void setNumero_erros(int numero_erros) {
        this.numero_erros = numero_erros;
    }

    public LinkedList<Integer> getCoordenadaX() {
        return coordenadaX;
    }

    public LinkedList<Integer> getCoordenadaY() {
        return coordenadaY;
    }

    public void placarJogo(Jogo jogo){
        System.out.println("Jogo 1: " + jogo.getNumero_tiros() + " " + jogo.getNumero_acertos() + " " + jogo.getNumero_erros());
    }
    

    public void carregarSom(String arquivoSom) throws Exception {
        // arquivoSom = "caminho/do/arquivo/som.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                Audio.class.getResourceAsStream(arquivoSom));

        AudioFormat formatoAudio = audioInputStream.getFormat();
        SourceDataLine linhaAudio = AudioSystem.getSourceDataLine(formatoAudio);
        linhaAudio.open(formatoAudio);
        linhaAudio.start();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = audioInputStream.read(buffer)) != -1) {
            linhaAudio.write(buffer, 0, bytesRead);
        }
    }

    public void adicionaBarcoNoTabuleiro() {
        Random random = new Random();
        while (numero_barcos < 20) {
            int x = random.nextInt(TAMANHO_MATRIZ);
            int y = random.nextInt(TAMANHO_MATRIZ);
            if (tabuleiro[x][y].getText() == "Agua") {
                coordenadaX.add(x);
                coordenadaY.add(y);
                tabuleiro[x][y].setText("Barco");
                tabuleiro[x][y].setOpaque(true);
                //tabuleiro[x][y].setBorder(BorderFactory.createLineBorder(Color.white));
                numero_barcos++;
            }

        }
    }

    public void verificaBarco() {
        for (int i = 0; i < coordenadaX.size(); i++) {
            for (int j = 0; j < coordenadaY.size(); j++) {
                //tabuleiro[coordenadaX.getFirst()][coordenadaY.getFirst()].setText("Barco");
                coordenadaX.removeFirst();
                coordenadaY.removeFirst();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    private class BotaoClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botao = (JButton) e.getSource();
            //verificaBarco();
            if (botao.getText().equals("Agua")) {
                botao.setIcon(new ImageIcon(explosao));               
                numero_tiros++;
                numero_erros++;
            } else if (botao.getText().equals("Barco")) {
                botao.setBackground(Color.red);
                botao.setIcon(new ImageIcon(barco));
                numero_tiros++;
                numero_acertos++;
            }
            if (numero_acertos == 20) {
                JOptionPane.showMessageDialog(null, "Voce ganhou!");
            }
        }
    }

}
