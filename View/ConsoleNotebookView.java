package View;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import Model.Note;

public class ConsoleNotebookView {
    private final Scanner scanner = new Scanner(System.in);

    public void displayNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("Нет записей.");
            return;
        }
        notes.forEach(System.out::println);
    }

    public Note getNoteInput() {
        System.out.println("Введите дату (yyyy-MM-dd HH:mm):");
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
        System.out.println("Введите описание:");
        String description = scanner.nextLine();
        return new Note(date, description);
    }

    public String getFilePath(String action) {
        System.out.println("Введите путь для " + action + " файла:");
        return scanner.nextLine();
    }

    public String getUserChoice() {
        System.out.println("1. Добавить запись\n2. Показать записи на день\n3. Показать записи на неделю\n4. Сохранить записи в файл\n5. Загрузить записи из файла\n0. Выход");
        return scanner.nextLine();
    }
}
