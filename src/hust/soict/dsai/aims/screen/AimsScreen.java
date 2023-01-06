package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AimsScreen extends JFrame {
    protected static JFrame storeScreen;
    protected static JFrame cartScreen;
    protected static JFrame addBookScreen;
    protected static JFrame addCDScreen;
    protected static JFrame addDVDScreen;
    protected JFrame currentScreen;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    protected static Store store;
    protected static Cart cart;


    public AimsScreen() {

    }

    public void setStoreScreen(JFrame storeScreen) {
        this.storeScreen = storeScreen;
    }

    public void setCartScreen(JFrame cartScreen) {
        this.cartScreen = cartScreen;
    }

    public void setAddBookScreen(JFrame addBookScreen) {
        this.addBookScreen = addBookScreen;
    }

    public void setAddCDScreen(JFrame addCDScreen) {
        this.addCDScreen = addCDScreen;
    }

    public void setAddDVDScreen(JFrame addDVDScreen) {
        this.addDVDScreen = addDVDScreen;
    }

    public void setCurrentScreen(JFrame currentScreen) {
        this.currentScreen = currentScreen;
    }

    public AimsScreen(Store store){
        this.store = store;
    }

    public AimsScreen(Store store, Cart cart){
        this.store = store;
        this.cart = cart;
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem menuAddBook = new JMenuItem("Add Book");
        JMenuItem menuAddCD = new JMenuItem("Add CD");
        JMenuItem menuAddDVD = new JMenuItem("Add DVD");

        menuAddBook.addActionListener(new MenuListener());
        menuAddCD.addActionListener(new MenuListener());
        menuAddDVD.addActionListener(new MenuListener());

        smUpdateStore.add(menuAddBook);
        smUpdateStore.add(menuAddCD);
        smUpdateStore.add(menuAddDVD);

        menu.add(smUpdateStore);
        JMenuItem menuViewStore = new JMenuItem("View Store");
        JMenuItem menuViewCart = new JMenuItem("View Cart");
        menuViewStore.addActionListener(new MenuListener());
        menuViewCart.addActionListener(new MenuListener());

        menu.add(menuViewCart);
        menu.add(menuViewStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View Cart");
        cart.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cartScreen.setVisible(cartScreen.isVisible() ? false : true);
                    }
                }
        );

        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));

        header.add(title);
        header.add(Box.createHorizontalGlue());

        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    abstract JPanel createCenter();

    public class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String menu = e.getActionCommand();
            if (menu.equals("View Store") && !storeScreen.equals(currentScreen)){
                storeScreen.setVisible(true);
                currentScreen.setVisible(false);
            } else if (menu.equals("View Cart") && !cartScreen.equals(currentScreen)){
                cartScreen.setVisible(true);
                currentScreen.setVisible(false);
            } else if (menu.equals("Add Book") && !addBookScreen.equals(currentScreen)){
                addBookScreen.setVisible(true);
                currentScreen.setVisible(false);
            } else if (menu.equals("Add CD") && !addCDScreen.equals(currentScreen)){
                addCDScreen.setVisible(true);
                currentScreen.setVisible(false);
            } else if (menu.equals("Add DVD") && !addDVDScreen.equals(currentScreen)){
                addDVDScreen.setVisible(true);
                currentScreen.setVisible(false);
            }
        }
    }

}
