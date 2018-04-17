package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecoundScreen {

    private JPanel panel_secound;
    private JTextField text_name;
    private JTextField text_age;
    private JComboBox comboBox_mark;
    private JButton button_add;
    private JTable table;
    private JButton button_remove;
    private JLabel label_name;
    private JLabel label_age;
    private JLabel label_mark;


    public SecoundScreen() {

        String[] columns = {"Name", "Age", "Mark"};
        String[][] data = {{"Jon", "12", "3"}, {"LAra", "56", "3"}};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        Object[] row = new Object[3];
        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int counter=0;
                String passwd = text_name.getText();
                Pattern pattern = Pattern.compile("[A-Z]{1}|[a-z]{1}");
                Matcher matcher = pattern.matcher(passwd);

                while (matcher.find())
                    counter++;

                int counter2 = 0;
                String passwd2 = text_age.getText();
                Pattern pattern2 = Pattern.compile("\\d");
                Matcher matcher2 = pattern2.matcher(passwd2);

                while(matcher2.find())
                    counter2++;

               if(counter != 0 && counter == text_name.getText().length() && counter2 != 0 && counter2 == text_age.getText().length()) {
                    row[0] = text_name.getText();
                    row[1] = text_age.getText();
                    row[2] = comboBox_mark.getSelectedItem();

                    model.addRow(row);
               }
            }
        });
        button_remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = table.getSelectedRow();
                if(i >= 0)
                    model.removeRow(i);
            }
        });
    }

    private static void createGUI(){
        JFrame frame = new JFrame();
        frame.setContentPane(new SecoundScreen().panel_secound);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() { createGUI(); }}
        );
    }
}
