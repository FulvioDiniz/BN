
import javax.swing.*;





public class IniciaJogo extends JFrame{    
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        Jogo jogo2 = new Jogo();

        // while(true){
        //     if(jogo.getAtualizou()){
        //         jogo2.setAtualiou(true);
        //         jogo.setAtualiou(false);
        //     }
        //     if(jogo2.getAtualizou()){
        //         jogo.setAtualiou(true);
        //         jogo2.setAtualiou(false);
        //     }
        //     System.out.println("Jogo 1: " + jogo.getNumero_tiros() + " " + jogo.getNumero_acertos() + " " + jogo.getNumero_erros());
        //     System.out.println("Jogo 2: " + jogo2.getNumero_tiros() + " " + jogo2.getNumero_acertos() + " " + jogo2.getNumero_erros());
        // } 
                
        
    }

    IniciaJogo() {
        add(new Jogo());
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Batalha Naval");
        //setVisible(true);

    }
}
