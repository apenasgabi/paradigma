import java.util.InputMismatchException;

public abstract class SpotifyContent {
    protected String title;
    protected int duration;

    public SpotifyContent(String title, int duration) {
        if (isNullOrWhitespace(title)) {
            throw new InputMismatchException("Entrada inválida");
        }
        this.title = title;
        this.duration = duration;
    }

    private boolean isNullOrWhitespace(String s) {
        return s == null || s.trim().isEmpty();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString() {
        return String.format("%s - %d", title, duration);
    }
}
