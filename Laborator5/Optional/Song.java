public class Song extends Item{

    Song(String name, String path) {
        super(name,path);
    }
    private String artistName;

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }
}
