import javax.sound.sampled.*;

public class Audio {
    // Carrega o arquivo de som

    public void carregarSom(String arquivoSom) throws Exception {
        //arquivoSom = "caminho/do/arquivo/som.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                Audio.class.getResourceAsStream(arquivoSom));

        // Obtém o formato de áudio do arquivo de som
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
    // Cria uma linha de saída de áudio

    // Lê os dados do arquivo de som e escreve na linha de saída de áudio

    // Encerra a reprodução do som

}
