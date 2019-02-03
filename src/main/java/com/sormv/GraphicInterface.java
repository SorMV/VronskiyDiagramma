package com.sormv;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines new graphic frame and stores instance of object
 * <code>PaintPanel</code> which allows to paint new <code>DotClass</code> dots
 * and other initial settings
 *
 * @see JFrame
 */
public class GraphicInterface extends JFrame {

    /**
     * This field is paint panel that allows to add new dots, repaint result and
     * has some logic for implementation of connection between <code>DotClass</code> and
     * <code>LineClass</code>
     */
    private PaintPanel draw;

    /**
     * Constructs and initializes a <code>GraphicInterface</code> with some initial settings
     * like size, visibility, close operation. On this step we added three initial instances of
     * <code>DotClass</code> to show result of programm work
     */
    public GraphicInterface() {
        setSize(new Dimension(1000, 1000));
        draw = new PaintPanel();
        draw.addDots(new DotClass(300, 300));
        draw.addDots(new DotClass(400, 400));
        draw.addDots(new DotClass(300, 150));
        setLayout(new BorderLayout());
        add(draw);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        //PaintPanel p = new PaintPanel();
        GraphicInterface gi = new GraphicInterface();
    }

}
