class Lagu {
    private String Judul;
    private String artis;


    public Lagu(String Judul, String artis) {
        this.Judul = Judul;
        this.artis = artis;
    }


    public String getJudul() {
        return Judul;
    }

    public String getArtis() {
        return artis;
    }


    public void mainkan() {
        System.out.println("Memainkan lagu : " + Judul + " oleh " + artis);
    }
}
