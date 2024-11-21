package View;

import java.time.LocalDateTime;
import java.util.Scanner;

import Model.Notebook;
import Presenter.NotebookPresenter;

public class Main {
     public static void main(String[] args) {
        Notebook notebook = new Notebook();
        ConsoleNotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(notebook, view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String choice = view.getUserChoice();

            switch (choice) {
                case "1":
                    presenter.addNote();
                    break;
                case "2":
                    System.out.println("Введите дату (yyyy-MM-dd):");
                    LocalDateTime date = LocalDateTime.parse(scanner.nextLine() + "T00:00:00");
                    presenter.showNotesForDate(date);
                    break;
                case "3":
                    System.out.println("Введите дату начала недели (yyyy-MM-dd):");
                    date = LocalDateTime.parse(scanner.nextLine() + "T00:00:00");
                    presenter.showNotesForWeek(date);
                    break;
                case "4":
                    presenter.saveNotes(view.getFilePath("сохранения"));
                    break;
                case "5":
                    presenter.loadNotes(view.getFilePath("загрузки"));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Некорректный выбор.");
                    break;
            }
        }
    }
}
