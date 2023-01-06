package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;


public class AddCDScreen extends AimsScreen{

    private JTextField tfDirector;
    private JTextField tfArtist;

    private JTextField tfTracks;

    @Override
    public JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(7, 2, 3, 3));
        JLabel lblTitle = new JLabel("Title");
        JLabel lblCategory = new JLabel("Category");
        JLabel lblCost = new JLabel("Cost");
        JLabel lblDirector = new JLabel("Director");
        JLabel lblArtist = new JLabel("Artist");
        JLabel lblTracks = new JLabel("Tracks (write each in <trackTitle>:<trackLength>, divided by commas");

        tfTitle = new JTextField(15);
        tfCategory = new JTextField(15);
        tfCost = new JTextField(15);
        tfDirector = new JTextField(15);
        tfArtist = new JTextField(15);
        tfTracks = new JTextField(100);

        center.add(lblTitle); center.add(tfTitle);
        center.add(lblCategory); center.add(tfCategory);
        center.add(lblCost); center.add(tfCost);
        center.add(lblDirector); center.add(tfDirector);
        center.add(lblArtist); center.add(tfArtist);
        center.add(lblTracks); center.add(tfTracks);

        JButton createBtn = new JButton("Add CD");
        createBtn.addActionListener(new ButtonListener());
        center.add(createBtn);

        JButton clearFieldBtn = new JButton("Clear fields");
        clearFieldBtn.addActionListener(new ButtonListener());
        center.add(clearFieldBtn);

        return center;
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Add CD")){
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                String director = tfDirector.getText();
                String artist = tfArtist.getText();

                CompactDisc newlyCreatedCD = new CompactDisc(title, category, cost, director, artist);
                store.addMedia(newlyCreatedCD);

                String[] tracks = tfTracks.getText().split(",");
                for (String track : tracks){
                    String[] splitted = track.split(":");
                    String trackTitle = splitted[0];
                    int trackLength = Integer.parseInt(splitted[1]);
                    newlyCreatedCD.addTrack(new Track(trackTitle, trackLength));
                }

                clearFields();

            } else if (button.equals("Clear fields")){
                clearFields();
            }
        }

        public void clearFields(){
            tfTitle.setText("");
            tfCategory.setText("");
            tfCost.setText("");
            tfDirector.setText("");
            tfArtist.setText("");
            tfTracks.setText("");
        }
    }

    public AddCDScreen(Store store){
        super(store);
        setCurrentScreen(this);
        setAddCDScreen(this);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(false);
        setTitle("Add CD Screen");
        setSize(1024, 768);
    }
}
