package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;

public class View extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void exit() {
        controller.exit();
    }

    public void init() {
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void initMenuBar(){

    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPaneHTML = new JScrollPane(htmlTextPane); // один скролл для первой переменной
        tabbedPane.addTab("HTML", jScrollPaneHTML); // можно и в одну строку записать
        JScrollPane jScrollPaneTekst = new JScrollPane(plainTextPane); // второй скролл для второй
        tabbedPane.addTab("Текст", jScrollPaneTekst);
        tabbedPane.setPreferredSize(new Dimension(600, 600)); // размер окна
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this); // слушаем этот класс
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER); // вывод по центру
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){

    }


}
