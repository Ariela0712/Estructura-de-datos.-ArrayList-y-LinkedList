public class Cancion {
    private String titulo;
    private String artista;
    private int duracionS;

    public Cancion(String titulo, String artista, int duracionS) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionS = duracionS;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracionS() {
        return duracionS;
    }

    public String toString() {
        return "Cancion: "+titulo+ "_ "+artista+" (" + duracionS +")";
    }
}
