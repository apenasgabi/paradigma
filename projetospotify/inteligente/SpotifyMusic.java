import java.util.InputMismatchException;
import java.util.List;

public class SpotifyMusic extends SpotifyContent {
    private List<String> songwriters;
    private List<String> interpreters;
    private String genre;

    public SpotifyMusic(String title, int duration, List<String> songwriters, List<String> interpreters, String genre) {
        super(title, duration);

        if (isNullOrWhitespace(title) || songwriters.isEmpty() || interpreters.isEmpty() || isNullOrWhitespace(genre)) {
            throw new InputMismatchException("Entrada inválida");
        }

        this.songwriters = songwriters;
        this.interpreters = interpreters;
        this.genre = genre;
    }

    private boolean isNullOrWhitespace(String s) {
        return s == null || s.trim().isEmpty();
    }

    public List<String> getSongwriters() {
        return this.songwriters;
    }

    public void setSongwriters(List<String> songwriters) {
        this.songwriters = songwriters;
    }

    public List<String> getInterpreters() {
        return this.interpreters;
    }

    public void setInterpreters(List<String> interpreters) {
        this.interpreters = interpreters;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        String songwritersString = String.join(";", songwriters);
        String interpretersString = String.join(";", interpreters);

        return String.format("Música | Título: %s | Duração: %d segundos | Interpretes: %s | Compositores: %s|", title, duration, interpretersString, songwritersString);
    }
}
