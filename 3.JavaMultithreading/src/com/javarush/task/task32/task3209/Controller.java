package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {

    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        View view = new View(); // создаем представление
        Controller controller = new Controller(view); // создаем контроллер
        view.init(); // вот она нечто инициализация пустым методом ) пока что
        controller.init(); // а вот она еще одна нечто инициализация
        view.setController(controller); // устанавливаем контроллер представлению
        controller.exit(); // и выходим
    }
}
