import javax.swing.*;
import java.awt.*;

class Cryptograph extends JFrame{
    private static JTextArea textArea1 = new JTextArea(300,200);
    private JScrollPane paneTextArea1 = new JScrollPane(textArea1);
    private static JTextArea textArea2 = new JTextArea(300,200);
    private JScrollPane paneTextArea2 = new JScrollPane(textArea2);
    private MyButtonBar myButtonBar = MyButtonBar.getInstance();
    private MyMenuBar myMenuBar = MyMenuBar.getInstance();
    private JPanel jCenterPanel = new JPanel();

    static void setTextArea2Text(String text) {
        textArea2.setText(text);
    }

    static JTextArea getTextArea() {
        return textArea1;
    }

    private void prepareFrame() {
        setTitle("ССШСКГБСССР v0.69");
        setSize(800,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jCenterPanel.setLayout(new BoxLayout(jCenterPanel, BoxLayout.Y_AXIS));

        textArea1.setLineWrap(true);
        textArea2.setEditable(false);
        textArea2.setLineWrap(true);
        paneTextArea1.setAutoscrolls(true);
        paneTextArea2.setAutoscrolls(true);
        jCenterPanel.add(paneTextArea1);
        jCenterPanel.add(paneTextArea2);

        getContentPane().add(jCenterPanel,BorderLayout.CENTER);
        getContentPane().add(myButtonBar,BorderLayout.SOUTH);
        getContentPane().add(myMenuBar, BorderLayout.NORTH);
    }

    void showFrame() {
        prepareFrame();
        setVisible(true);
    }
}
