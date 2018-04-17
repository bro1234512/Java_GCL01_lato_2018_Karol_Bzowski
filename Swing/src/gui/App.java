package gui;

        import javax.swing.*;
        import javax.swing.text.StyledEditorKit;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.FocusAdapter;
        import java.awt.event.FocusEvent;
        import java.lang.reflect.Array;
        import java.util.Arrays;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class App
{
    private JPanel panel_Main;
    private JLabel label_loginerror;
    private JButton button_login;
    private JLabel label_password;
    private JLabel label_username;
    private JTextField text_username;
    private JPasswordField passwordField_1;
    private JButton button_reset;
    private JLabel label_usererror;
    private JLabel label_passworderror;
    private Boolean username_flag = false;
    private Boolean passwd_flag = false;
    static JFrame frame = new JFrame();

    public App()
    {
        button_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text_username.setText("");
                passwordField_1.setText("");
                username_flag = false;
                passwd_flag = false;
                label_loginerror.setVisible(false);
                label_usererror.setVisible(false);
                label_passworderror.setVisible(false);
            }
        });


        text_username.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                byte text = (byte) text_username.getText().length();
                if(text >= 3 && text <= 20) {
                    label_usererror.setVisible(false);
                    username_flag = true;
                }
                else {
                    label_usererror.setVisible(true);
                    username_flag = false;
                }
            }
        });
        passwordField_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String passwd = new String (passwordField_1.getPassword());
                Pattern pattern1 = Pattern.compile("[A-Z]+");
                Pattern pattern2 = Pattern.compile("\\p{Punct}+");
                Matcher matcher1 = pattern1.matcher(passwd);
                Matcher matcher2 = pattern2.matcher(passwd);

                if(matcher1.find() && matcher2.find()) {
                    label_passworderror.setVisible(false);
                    passwd_flag = true;
                }
                else {
                    label_passworderror.setVisible(true);
                    passwd_flag = false;
                }
            }
        });
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(username_flag && passwd_flag)
                {
                    //JOptionPane.showMessageDialog(null,"Można się zalogować!");
                    frame.dispose();

                    SecoundScreen.main(null);
                }
                else
                    label_loginerror.setVisible(true);
            }
        });
    }

    private static void createGUI()
    {
        frame.setContentPane(new App().panel_Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createGUI();
            }
        }
        );
    }
}
