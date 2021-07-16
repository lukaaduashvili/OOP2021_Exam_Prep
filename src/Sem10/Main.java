package Sem10;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Main extends JFrame {
   // public StudentStore store;
    public StudentModel model;
    public Main(StudentStore store) {
        //this.store  = store;
        model =  new StudentModel(store);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel actionP = new JPanel(new GridLayout(2, 1));

        actionP.add(createAddPanel());
        actionP.add(searchPanel());
        mainPanel.add(actionP, BorderLayout.NORTH);

        JTable table = new JTable();
        table.getTableHeader().setBackground(Color.white);
        table.setModel(model);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(table, BorderLayout.CENTER);

        mainPanel.add(tablePanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        setSize(500, 1500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JPanel searchPanel() {
        JPanel searchPanel = new JPanel(new GridLayout(1, 4));
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField enrollmentName = new JTextField();
        JButton search = new JButton("Search");
        searchPanel.add(firstName);
        searchPanel.add(lastName);
        searchPanel.add(enrollmentName);
        searchPanel.add(search);

        search.addActionListener(e -> {
            AndFilter f = new AndFilter();
            if(firstName.getText().length() > 0) {
                f.addFilter(new FirstNameFilter(firstName.getText()));
            }
            if(lastName.getText().length() > 0) {
                f.addFilter(new LastNameFilter(lastName.getText()));
            }
            if(enrollmentName.getText().length() > 0) {
                f.addFilter(new EnrollementFilter(Integer.valueOf(enrollmentName.getText())));
            }
            model.applyFilter(f);

        });

        return searchPanel;
    }


    public JPanel createAddPanel() {
        JPanel createPanel = new JPanel(new GridLayout(1, 4));
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField enrollmentName = new JTextField();
        JButton add = new JButton("Add");
        createPanel.add(firstName);
        createPanel.add(lastName);
        createPanel.add(enrollmentName);
        createPanel.add(add);

        add.addActionListener(e -> {
            Student st = new Student(
                    firstName.getText(),
                    lastName.getText(),
                    Integer.valueOf(enrollmentName.getText())
            );
            model.add(st);
        });

        return createPanel;
    }


    public static void main(String[] args) {
        StudentStore StS = new ArrayListStudentStore();
        StS.add(new Student("foo", "bar", 2002));
        StS.add(new Student("Moo", "Car", 2000));
        Main m = new Main(StS);
    }
}
