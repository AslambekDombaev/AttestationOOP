package Presenter;

import java.time.LocalDateTime;
import java.util.List;

import Model.Note;
import Model.Notebook;
import View.ConsoleNotebookView;

public class NotebookPresenter {
    private final Notebook notebook;
    private final ConsoleNotebookView view;

    public NotebookPresenter(Notebook notebook, ConsoleNotebookView view) {
        this.notebook = notebook;
        this.view = view;
    }

    public void addNote() {
        notebook.addNote(view.getNoteInput());
    }

    public void showNotesForDate(LocalDateTime date) {
        List<Note> notes = notebook.getNotesForDate(date);
        view.displayNotes(notes);
    }

    public void showNotesForWeek(LocalDateTime startDate) {
        List<Note> notes = notebook.getNotesForWeek(startDate);
        view.displayNotes(notes);
    }

    public void saveNotes(String filePath) {
        notebook.saveToFile(filePath);
    }

    public void loadNotes(String filePath) {
        notebook.loadFromFile(filePath);
    }
}
