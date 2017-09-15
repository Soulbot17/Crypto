import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

class MyButtonBar extends JPanel{
    private final String BUTT_ENCRYPT = " ENCRYPT ";
    private final String BUTT_DECRYPT = " DECRYPT ";
    private static MyButtonBar instance;

    private JButton buttonEncrypt = new JButton(BUTT_ENCRYPT);
    private JSeparator separator = new JSeparator(0);
    private JButton buttonDecrypt = new JButton(BUTT_DECRYPT);
    private LineBorder border = new LineBorder(Color.BLACK,1,false);
    private JLabel mainLabel = new JLabel("         Номер один по борьбе секретными службами по всему миру!");

    private MyButtonBar() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        buttonEncrypt.setBorder(border);
        buttonEncrypt.addActionListener(new EncryptListener());
        buttonDecrypt.setBorder(border);
        buttonDecrypt.addActionListener(new DecryptListener());
        add(buttonEncrypt);
        add(buttonDecrypt);
        add(mainLabel);
    }

    static MyButtonBar getInstance() {
        if (instance==null) {
            return new MyButtonBar();
        } else return instance;
    }

    class EncryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int index = random.nextInt(40)+1;
            mainLabel.setText("         Твой секретный код:  "+(index*66-5*13)+". Не забый его, он нужен для расшифровки!");
            if (Cryptograph.getTextArea().getText()==null) return;
            char[] cryptoSet = Cryptograph.getTextArea().getText().toCharArray();
            for (int i = 0; i<cryptoSet.length;i++) {
                cryptoSet[i] = (char)(cryptoSet[i]+index);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : cryptoSet) sb.append(c);
            Cryptograph.setTextArea2Text(sb.toString());
        }
    }

    class DecryptListener implements ActionListener{
        private int code;
        private JTextField textField = new JTextField(8);

        private void doShit() {
            try {
                code = (Integer.parseInt(textField.getText())+5*13)/66;
            } catch (NumberFormatException c) {
                textField.setText("");
            }

            if (Cryptograph.getTextArea().getText()==null) return;
            char[] cryptoSet = Cryptograph.getTextArea().getText().toCharArray();
            for (int i = 0; i<cryptoSet.length;i++) {
                cryptoSet[i] = (char)(cryptoSet[i]-code);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : cryptoSet) sb.append(c);
            Cryptograph.setTextArea2Text(sb.toString());
        }

        public void actionPerformed(ActionEvent e) {
            new JFrame("Введи свой код:") {{
                setSize(600,400);
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                setLocationRelativeTo(null);
                Font font = new Font("SansSerif",Font.BOLD,15);
                textField.setFont(font);
                JButton okButton = new JButton("OK");
                setLayout(new FlowLayout());
                add(textField);
                textField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                            doShit();
                            dispose();
                        }
                    }
                });
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        doShit();
                        dispose();
                    }
                });
                add(okButton);
                pack();
                setVisible(true);
            }};
        }
    }


}
