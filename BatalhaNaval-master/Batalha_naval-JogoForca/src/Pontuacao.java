import javax.swing.JFrame;
import javax.swing.JLabel;
import java.time.Duration;
import java.time.Instant;
import java.awt.Color;



public class Pontuacao extends JFrame implements Runnable {
    private Instant inicio = Instant.now();
    private JLabel labelTempo; // Variável para armazenar o JLabel do tempo
    private JLabel labelPontuacao; // Variável para armazenar o JLabel do tempo
    private Jogo referencia_Jogo; // Variável para armazenar a referência do jogo

    public Pontuacao(String nomeJogo, Jogo referencia_Jogo) {
        super("Pontuacao do " + nomeJogo);
        this.referencia_Jogo = referencia_Jogo;
        setBackground(Color.black);
        setSize(400, 100); // Ajusta o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Configura o layout como null para definir manualmente os bounds

        labelPontuacao = new JLabel("Pontuacao" + referencia_Jogo.getNumero_acertos());
        labelPontuacao.setBounds(10, 10, 180, 40); // Ajusta a posição e o tamanho da primeira JLabel
        add(labelPontuacao);

        labelTempo = new JLabel("Tempo decorrido: 0 segundos");
        labelTempo.setBounds(200, 10, 180, 40); // Ajusta a posição e o tamanho da segunda JLabel
        add(labelTempo);

        setVisible(true);

        Thread threadAtualizacao = new Thread(this); // Cria uma nova thread para a atualização do tempo
        threadAtualizacao.start(); // Inicia a thread
    }
    

    @Override
    public void run()  {
        while (true) {
            Duration duracao = Duration.between(inicio, Instant.now());
            long segundos = duracao.getSeconds(); // Obtém o tempo decorrido em segundos
            if(referencia_Jogo != null){
                int valorpontos = referencia_Jogo.getNumero_acertos();
                labelPontuacao.setText("Pontuacao: " + valorpontos);
            }         
            
            labelTempo.setText("Tempo decorrido: " + segundos + " segundos"); // Atualiza o texto do JLabel com o tempo
                                                                              // atual
            try {
                Thread.sleep(1000); // Aguarda 1 segundo (1000 milissegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}