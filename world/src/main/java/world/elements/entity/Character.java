package world.elements.entity;

import world.Position;
import world.behavior.ArrowKeyControl;
import world.elements.SpriteManager;
import world.reaction.InertiaRemove;
import world.reaction.Remove;
import world.reaction.Sides;

import java.awt.*;

/**
 *Character Entity
 * the character will be control by player
 * @see Entity
 * */
public class Character extends Entity{

    public Character(Position position, Dimension dimension) {
        super(position, dimension, new SpriteManager(
                new String[]{"player1.png" , "player2.png" , "player3.png" , "player4.png"},
                new String[]{"up1.png","up2.png","up3.png","up4.png",},
                new String[]{"down_1.png", "down_2.png", "down_3.png", "down_4.png"},
                new String[]{"player_left1.png", "player_left2.png","player_left3.png"},
                new String[]{"right1.png", "right2.png","right3.png"}
        ),10);

        this.reactions.add(new Remove(this, Monster.class, new Sides[]{Sides.LEFT, Sides.RIGHT, Sides.TOP, Sides.BOTTOM}));
        this.reactions.add(new InertiaRemove(this, Rock.class, new Sides[]{Sides.TOP}));
    }


    @Override
    public void run() {
        super.run();



    }

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new ArrowKeyControl(this, this.engine));
    }

    @Override
    public void destroy() {
        this.engine.removeCharacter(this);
        this.engine.lose();
    }

    @Override
    public boolean hasFinish() {
        return this.engine.levelCompleted();
    }
}