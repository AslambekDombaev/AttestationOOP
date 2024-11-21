package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notebook {
    private final List<Note> notes = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotesForDate(LocalDateTime date) {
        return notes.stream()
                .filter(n -> n.getDate().toLocalDate().isEqual(date.toLocalDate()))
                .sorted((n1, n2) -> n1.getDate().compareTo(n2.getDate()))
                .collect(Collectors.toList());
    }

    public List<Note> getNotesForWeek(LocalDateTime startDate) {
        return notes.stream()
                .filter(n -> !n.getDate().isBefore(startDate) && n.getDate().isBefore(startDate.plusDays(7)))
                .sorted((n1, n2) -> n1.getDate().compareTo(n2.getDate()))
                .collect(Collectors.toList());
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Note note : notes) {
                writer.write(note.getDate().format(formatter) + "|" + note.getDescription());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    LocalDateTime date = LocalDateTime.parse(parts[0], formatter);
                    addNote(new Note(date, parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}