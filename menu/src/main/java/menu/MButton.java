package menu;

import javax.swing.*;
import java.awt.*;

class MButton extends JButton {

    MButton(String text){
    	this.setBounds(500, 500, 400, 200);
        this.setText(text);
        this.setPreferredSize(new Dimension(400, 150));
        this.setFont(new Font("Ravie", Font.PLAIN, 40));
        this.setBackground(Color.decode("#C4E538"));
        this.setForeground(Color.decode("#9c99a0"));
        this.setBorderPainted(false);
        this.setOpaque(true);
        this.setFocusPainted(false);
    }

}
