import java.util.ArrayList;
import java.util.List;

class Playlist {
    protected List<Lagu> songs;


    public Playlist() {
        songs = new ArrayList<>();
    }


    public void tambahLagu(Lagu song) {
        songs.add(song);
        System.out.println(song.getJudul() + " ditambahkan ke playlist.");
    }

    public void hapusLagu(Lagu song) {
        songs.remove(song);
        System.out.println(song.getJudul() + " dihapus dari playlist.");
    }

    public void mainSemua() {
        System.out.println("Memainkan semua lagu di dalam Playlist:");
        for (Lagu song : songs) {
            song.mainkan();
        }
    }
}
