import javax.swing.*;

class MyMenuBar extends JMenuBar {
    private JMenu about = new JMenu("ИНТЕРЕСНАЯ ВКЛАДОЧКА");
    private JMenuItem fact1 = new JMenuItem("А");
    private JMenuItem fact2 = new JMenuItem("В");
    private JMenuItem fact3 = new JMenuItem("НЕЙ");
    private JMenuItem fact4 = new JMenuItem("НИЧЕГО");
    private JMenuItem fact5 = new JMenuItem("ИНТЕРЕСНОГО");
    private static MyMenuBar instance;

    private MyMenuBar() {
        about.add(fact1);
        about.add(fact2);
        about.add(fact3);
        about.add(fact4);
        about.add(fact5);
        add(about);
    }

    static MyMenuBar getInstance() {
        if (instance ==null) {
            return new MyMenuBar();
        } else return instance;
    }

}
