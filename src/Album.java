import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;
    private String name;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //functionalities

    public boolean findSong(String name){
        for(Song song : songs){
            if(song.getTitle().equals(name))
                return true;
        }
        return false;
    }

    public String addSongToAlbum(String title, double duration){
        if(!findSong(title)){
            Song song = new Song(title,duration);
            this.songs.add(song);
            return "Song has been added to album.";
        }
        return "Song already exists.";
    }
    public String addToPlaylistFromAlbum(String title, LinkedList<Song> playList){
        for(Song song : songs){
            if(song.getTitle().equals(title)){
                playList.add(song);
                return "Song added to Album";
            }
        }
        return "Song doesn't exist in Album";
    }

    public String addToPlaylistFromAlbum(int songNo, LinkedList<Song> playList){
        int index = songNo-1;
        if(index>=0 && index < songs.size()){
            playList.add(songs.get(index));
            return  "Song added to Album successfully";
        }
        return "Invalid songNo";
    }

}
