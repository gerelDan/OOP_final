package view;

import model.Note;
import model.NoteBookService;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements NoteBookView{
    private Scanner scanner = new Scanner(System.in);
    private final Presenter presenter;
    private boolean exit;
    private final Menu menu;

    public ConsoleUI() {
        this.presenter = new Presenter(new NoteBookService(), this);
        exit = true;
        this.menu = new Menu(this);
    }
    public Presenter getPresenter(){
        return  this.presenter;
    }

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            for (Note note : notes) {
                System.out.println(note);
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDate getDateInput() {
        System.out.println("Enter date (yyyy-MM-dd:");
        String input = scanner.nextLine();
        DateTimeFormatter formatter =
                DateTimeFormatter.ISO_LOCAL_DATE;
        return LocalDate.parse(input, formatter);
    }

    @Override
    public LocalTime getTimeInput() {
        System.out.println("Enter time (HH:mm):");
        String input = scanner.nextLine();
        DateTimeFormatter formatter =
                DateTimeFormatter.ISO_LOCAL_TIME;
        return LocalTime.parse(input, formatter);
    }

    @Override
    public String getThemeInput() {
        System.out.println("Enter note theme:");
        return scanner.nextLine();
    }

    @Override
    public String getFileNameInput() {
        System.out.println("Enter file name:");
        return scanner.nextLine();

    }

    public void addNote(){
        presenter.addNote();
    }

    public void showNotesForDay(){
        presenter.showNotesForDay();
    }

    public void showNotesForWeek(){
        presenter.showNotesForWeek();
    }

    public void saveNotes(){
        presenter.saveNotes();
    }

    public void loadNotes(){
        presenter.loadNotes();
    }

    public void exit(){
        System.out.println("До новых встреч!");
        System.exit(0);
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        return numCommand <= menu.getSize();
    }

    private boolean checkTextForInt(String text) {
        return text.matches("[0-9]+");
    }
    private void printMenu() {
        showMessage(menu.menu());
    }
    public void start() {
        while (exit) {
            showMessage("Добрый день! Выберите одно из действий:");
            printMenu();
            execute();
        }
    }

}
