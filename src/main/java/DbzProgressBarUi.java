import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.net.URL;

public class DbzProgressBarUi extends BasicProgressBarUI {

    private final Sprite determinateSprite;
    private final Sprite inDeterminateSprite;
    private final int height;

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
        var wrapper = new Object() {
            final Sprite determinateSprite = Sprite.GOKU_RUNNING;
            final Sprite indeterminateSprite = Sprite.GOKU_KAMEHAMEHA_SMALL;

        };

        return new DbzProgressBarUi(wrapper.determinateSprite, wrapper.indeterminateSprite);
    }

    @Override
    protected void paintIndeterminate(Graphics g, JComponent c) {
        super.paintIndeterminate(g, c);

        ImageIcon imageIcon = inDeterminateSprite.getIcon();
        int yAxis = height > imageIcon.getIconHeight() ? (height - imageIcon.getIconHeight()) / 2 : 0;

        imageIcon.paintIcon(progressBar, g, 0, Math.round(yAxis));

    }

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        super.paintDeterminate(g, c);

        ImageIcon imageIcon = determinateSprite.getIcon();

        int amountFull = getAmountFull(progressBar.getInsets(), progressBar.getWidth(), progressBar.getHeight());

        int yAxis = height > imageIcon.getIconHeight() ? (height - imageIcon.getIconHeight()) / 2 : 0;
        imageIcon.paintIcon(progressBar, g, amountFull - imageIcon.getIconWidth(), Math.round(yAxis));

    }

    @Override
    public Dimension getPreferredSize(final JComponent c) {
        return new Dimension(400, height);
    }

}
