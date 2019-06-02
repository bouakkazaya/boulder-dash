package menu;

import javax.swing.*;
import java.awt.*;

abstract class SubMenu extends JPanel {

    protected IMenuAction menu;

    protected GridLayout layout;

    SubMenu(int rows, IMenuAction menu){
        this.menu = menu;

        this.setOpaque(false);

        this.layout = new GridLayout();
       
        

        
        this.layout.setHgap(50);
        this.layout.setVgap(50);
        this.layout.setColumns(3);
        this.layout.setRows(-3);
        this.setLayout(this.layout);
    }
}

