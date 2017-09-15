import javax.swing.*;

class MyMenuBar extends JMenuBar {
    private JMenu about = new JMenu("ИНТЕРЕСНАЯ ВКЛАДОЧКА");
    private JMenuItem fact1 = new JMenuItem("I AM THE");
    private JMenuItem fact2 = new JMenuItem("KING OF THE JAVA!");
    private static MyMenuBar instance;

    private MyMenuBar() {
        about.add(fact1);
        about.add(fact2);
        add(about);
    }

    static MyMenuBar getInstance() {
        if (instance ==null) {
            return new MyMenuBar();
        } else return instance;
    }

}
