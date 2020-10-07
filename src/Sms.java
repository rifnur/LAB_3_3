import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sms extends JFrame {

    String res="";
    public Sms (){
        setTitle("Поговорим");
        setBounds(300,300,500,300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

       /* ImageIcon image =
                new ImageIcon("images/logo.png");
        this.setIconImage(image.getImage());*/
       /* Image img = new ImageIcon(Sms.class.getResource("/images/logo.png")).getImage();
        this.setIconImage(img);
*/

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        //panel.setBackground(Color.lightGray);
        panel.setLayout(new BorderLayout(2,2));

        JTextArea otpravlen = new JTextArea();
        JScrollPane scroll = new JScrollPane(otpravlen);
        panel.add(scroll,BorderLayout.CENTER);
        otpravlen.setFont(new Font("Serif",Font.ITALIC,14));

        otpravlen.setEditable(false);


        JPanel panel1 = new JPanel();
        add(panel1, BorderLayout.SOUTH);
        // panel.setBackground(Color.PINK);
        panel1.setPreferredSize(new Dimension(10,40));
        panel1.setLayout(new BorderLayout(2,2));

        JTextField text = new JTextField();
        text.setFont(new Font("Serif",Font.PLAIN,14));
        panel1.add(text);
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.write(text.getText());
                otpravlen.append(text.getText()+"\n");
                text.setText("");
            }
        });

        JButton button = new JButton("Отправить");
        /*ImageIcon icon3 = new ImageIcon("/images/coins.png");
        button.setIcon(icon3);*/
        panel1.add(button, BorderLayout.EAST);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.write(text.getText());
                otpravlen.append(text.getText()+"\n");
                text.setText("");
            }
        });
        setVisible(true);
    }
}
