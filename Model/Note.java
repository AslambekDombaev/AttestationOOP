package Model;
import java.time.LocalDateTime;

public class Note {
    private final LocalDateTime date;
    private final String description;

    public Note(LocalDateTime date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", date, description);
    }
}