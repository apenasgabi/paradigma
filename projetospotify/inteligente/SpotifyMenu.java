import java.util.HashMap;
import java.util.Map;

public class SpotifyMenu {
    private Map<String, SpotifyPlaylist> playlists;

    public Map<String, SpotifyPlaylist> getPlaylists(){
		return playlists;
	}
    
    public SpotifyMenu(){
        playlists = new HashMap<String, SpotifyPlaylist>();
        addPlaylist("library");
    }

    public void addPlaylist(String playlistTitle){
        if(!playlistExists(playlistTitle))
            playlists.put(playlistTitle, new SpotifyPlaylist(playlistTitle));
    }

    public SpotifyPlaylist getPlaylist(String playlistTitle){
        return playlists.get(playlistTitle);
    }

    public void removePlaylist(String playlistTitle){
        playlists.remove(playlistTitle);
    }

    public boolean playlistExists(String playlistTitle){
        return playlists.containsKey(playlistTitle);
    }

    public void addContent(String playlistTitle, SpotifyContent content){
        getPlaylist(playlistTitle).addContent(content);
    }

    public void removeContent(String playlistTitle, SpotifyContent content){
        getPlaylist(playlistTitle).removeContent(content);
    }

    public String getContentDescription(SpotifyContent content){
        String contentClass = "";
        
        if(content.getClass() == SpotifyMusic.class) contentClass = "Música";
        if(content.getClass() == SpotifyPodcast.class) contentClass = "Podcast";
        if(content.getClass() == SpotifyAudiobook.class) contentClass = "Audiobook";

        return String.format("%s - %s", contentClass, content.toString());
        
    }
}
