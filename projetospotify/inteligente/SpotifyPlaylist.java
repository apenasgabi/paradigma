import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class SpotifyPlaylist extends SpotifyContent {
    private List<SpotifyContent> contentList;
    
    public SpotifyPlaylist(String title){
        super(title, 0);
        contentList = new LinkedList<SpotifyContent>();
    }

    public List<SpotifyContent> getContentList() {
        return this.contentList;
    }

    public void setContentList(List<SpotifyContent> contentList) {
        this.contentList = contentList;
    }

    public String getDurationFormated(){
        int hours;
        int minutes;
        int seconds = this.getDuration();

        hours = seconds / 3600;
        seconds %= 3600;
        minutes = seconds / 60;
        seconds %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void addContent(SpotifyContent content){
        contentList.add(content);
        this.setDuration(this.getDuration() + content.getDuration());
    }

    public void removeContent(SpotifyContent content){
        if(contentList.contains(content))
            contentList.remove(content);
            this.setDuration(this.getDuration() - content.getDuration());
    }

    public List<SpotifyContent> filterBy(boolean music, boolean podcast, boolean audiobook){

        List<SpotifyContent> filteredList = new ArrayList<SpotifyContent>();
        
        for (SpotifyContent content : this.contentList){

            if(content.getClass() == SpotifyMusic.class && music)
                filteredList.add(content);

            if(content.getClass() == SpotifyPodcast.class && podcast)
                filteredList.add(content);

            if(content.getClass() == SpotifyAudiobook.class && audiobook)
                filteredList.add(content);
        }

        return filteredList;
    }

    public String getDescription(){
        String titulo = this.getTitle();
        if(titulo == "library") titulo = "Biblioteca";
        return String.format("Título da Playlist: %s\nDuração: %s\nConteúdos: %d ", titulo, getDurationFormated(), contentList.size());
    }
}
