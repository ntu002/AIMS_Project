package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDVDScreen extends AimsScreen{

    private JTextField tfLength;

    private JTextField tfDirector;

    public JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(6, 2, 3, 3));

        JLabel lblTitle = new JLabel("Title");
        JLabel lblCategory = new JLabel("Category");
        JLabel lblCost = new JLabel("Cost");
        JLabel lblLength = new JLabel("Length");
        JLabel lblDirector = new JLabel("Director");

        tfTitle = new JTextField(15);
        tfCategory = new JTextField(15);
        tfCost = new JTextField(15);
        tfLength = new JTextField(15);
        tfDirector = new JTextField(15);

        center.add(lblTitle); center.add(tfTitle);
        center.add(lblCategory); center.add(tfCategory);
        center.add(lblCost); center.add(tfCost);
        center.add(lblLength); center.add(tfLength);
        center.add(lblDirector); center.add(tfDirector);

        JButton createBtn = new JButton("Add DVD");
        createBtn.addActionListener(new ButtonListener());
        center.add(createBtn);

        JButton clearFieldBtn = new JButton("Clear fields");
        clearFieldBtn.addActionListener(new ButtonListener());
        center.add(clearFieldBtn);

        return center;
    }

    public class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Add DVD")){
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                int length = Integer.parseInt(tfLength.getText());
                String director = tfDirector.getText();

                store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
                this.clearFields();
            }
            else if (button.equals("Clear fields")){
                this.clearFields();
            }
        }

        public void clearFields(){
            tfTitle.setText("");
            tfCategory.setText("");
            tfDirector.setText("");
            tfCost.setText("");
            tfLength.setText("");
        }
    }

    public AddDVDScreen(Store store){
        super(store);
        setCurrentScreen(this);
        setAddDVDScreen(this);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(false);
        setTitle("Add DVD Screen");
        setSize(1024,768);
    }
}
