import java.util.Collections;

class AdvancedPlaylist extends Playlist {

    public AdvancedPlaylist() {
        super(); 
    }


    @Override
    public void mainSemua() {
        System.out.println("Memainkan playlist yag telah di acak, playing: ");
        Collections.shuffle(songs); 
        for (Lagu song : songs) {
            song.mainkan();
        }
    }


    public void acakDanMain() {
        System.out.println("Memainkan lagu secara random:");
        Collections.shuffle(songs);
        super.mainSemua(); 
    }
}
