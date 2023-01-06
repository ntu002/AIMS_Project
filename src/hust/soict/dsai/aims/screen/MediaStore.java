package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.layout.VBox;

public class MediaStore extends JPanel {

    private Media media;
    private Cart cart;
    public MediaStore(Media media, Cart cart){
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartBtn = new JButton("Add to cart");
        addToCartBtn.addActionListener(new ButtonListener());
        container.add(addToCartBtn);

        JButton playBtn = new JButton("Play");
        playBtn.addActionListener(new ButtonListener());
        if (media instanceof Playable){
            container.add(playBtn);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Play")){
                if (media instanceof Playable){
                    try{
                        ((Playable) media).play();
                    } catch (PlayerException exception){
                        exception.printStackTrace();
                    }
                }
            } else if(button.equals("Add to cart")){
                cart.addMedia(media);
            }
        }
    }
}
