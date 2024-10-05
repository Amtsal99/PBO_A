public class Main {
    public static void main(String[] args) {

        Lagu song1 = new Lagu("Shape of You", "Ed Sheeran");
        Lagu song2 = new Lagu("Blinding Lights", "The Weeknd");
        Lagu song3 = new Lagu("Levitating", "Dua Lipa");

        Playlist basicPlaylist = new BasicPlaylist();  
        basicPlaylist.tambahLagu(song1);
        basicPlaylist.tambahLagu(song2);
        basicPlaylist.mainSemua();  
        
        System.out.println();

        Playlist advancedPlaylist = new AdvancedPlaylist();
        advancedPlaylist.tambahLagu(song1);
        advancedPlaylist.tambahLagu(song2);
        advancedPlaylist.tambahLagu(song3);
        advancedPlaylist.mainSemua();  
        
        System.out.println();

        AdvancedPlaylist playlistAcak = new AdvancedPlaylist();
        playlistAcak.tambahLagu(song1);
        playlistAcak.tambahLagu(song2);
        playlistAcak.tambahLagu(song3);
        playlistAcak.acakDanMain();
    }
}
