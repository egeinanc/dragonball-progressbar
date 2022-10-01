import com.intellij.ui.JBColor;
import com.intellij.ui.scale.JBUIScale;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;

public class DbzProgressBarUi extends BasicProgressBarUI {

    private final Sprite determinateSprite;
    private final Sprite inDeterminateSprite;
    private final int height;

    @SuppressWarnings("all")
    private final Color invisibleColor = new Color(0, 0, 0, 0);


    public DbzProgressBarUi(Sprite determinateSprite, Sprite inDeterminateSprite) {
        this.determinateSprite = determinateSprite;
        this.inDeterminateSprite = inDeterminateSprite;
        this.height = Math.max(determinateSprite.getIcon().getIconHeight(), inDeterminateSprite.getIcon().getIconHeight());
    }

    public static URL getResource(String name) {
        return DbzProgressBarUi.class.getResource(name);
    }

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(final JComponent c) {

        DbProgressConfigurationComponent.syncState();

        boolean determinateIsSet = false;
        boolean inDeterminateIsSet = false;
        Sprite determinateSprite = Sprite.GOKU_JINDUJUN;
        Sprite indeterminateSprite = Sprite.GOKU_KAMEHAMEHA_SMALL;

        DbProgressbarState state = DbProgressbarState.getInstance();
        for (Sprite sprite : Sprite.values()) {

            if (determinateIsSet && inDeterminateIsSet) break;

            Boolean stateValue = state.getSpriteState().get(sprite);

            if (sprite.isDeterminate() && stateValue && !determinateIsSet) {
                determinateSprite = sprite;
                determinateIsSet = true;
            }

            if (!sprite.isDeterminate() && stateValue && !inDeterminateIsSet) {
                indeterminateSprite = sprite;
                inDeterminateIsSet = true;
            }
        }

        return new DbzProgressBarUi(determinateSprite, indeterminateSprite);
    }

    @Override
    protected void paintIndeterminate(Graphics g, JComponent c) {
        super.paintIndeterminate(g, c);
        progressBar.setForeground(new JBColor(invisibleColor, invisibleColor));
        paintBorder((Graphics2D) g);

        ImageIcon imageIcon = inDeterminateSprite.getIcon();
        int yAxis = height > imageIcon.getIconHeight() ? (height - imageIcon.getIconHeight()) / 2 : 0;

        imageIcon.paintIcon(progressBar, g, 0, Math.round(yAxis));

    }

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        super.paintDeterminate(g, c);

        progressBar.setForeground(new JBColor(invisibleColor, invisibleColor));
        paintBorder((Graphics2D) g);

        ImageIcon imageIcon = determinateSprite.getIcon();

        int amountFull = getAmountFull(progressBar.getInsets(), progressBar.getWidth(), progressBar.getHeight());

        int yAxis = height > imageIcon.getIconHeight() ? (height - imageIcon.getIconHeight()) / 2 : 0;
        imageIcon.paintIcon(progressBar, g, amountFull - imageIcon.getIconWidth(), Math.round(yAxis));

    }

    @Override
    public Dimension getPreferredSize(final JComponent c) {
        return new Dimension(400, height);
    }

    private void paintBorder(Graphics2D graphics2D) {
        final int width = progressBar.getWidth();
        int height = progressBar.getPreferredSize().height;

        final float arcLength = JBUIScale.scale(9f);
        final float offset = JBUIScale.scale(2f);


        RoundRectangle2D.Float rectangle = new RoundRectangle2D.Float(JBUIScale.scale(1f),
                JBUIScale.scale(1f),
                width - offset,
                height - offset,
                arcLength,
                arcLength);

        final Color color = graphics2D.getColor();
        final Stroke stroke = graphics2D.getStroke();

        graphics2D.setColor(JBColor.GRAY);
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.draw(rectangle);

        graphics2D.setColor(color);
        graphics2D.setStroke(stroke);

    }

}
