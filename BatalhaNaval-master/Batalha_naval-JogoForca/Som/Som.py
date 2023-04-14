from pytube import YouTube

# cria uma instância do objeto YouTube
yt = YouTube('https://www.youtube.com/watch?v=2ZKBeHLEGtQ')

# extrai o fluxo de áudio em 128kbps
audio_stream = yt.streams.filter(only_audio=True, abr="128kbps").first()

# faz o download do fluxo de áudio em um arquivo mp4
audio_file = audio_stream.download()

# renomeia o arquivo mp4 para mp3
import os
os.rename(audio_file, audio_file[:-4] + ".mp3")