import com.intellij.ui.JBColor;
import com.intellij.ui.scale.JBUIScale;
import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class DbzProgressBarUi extends BasicProgressBarUI {
    private ImageIcon icon;

    public DbzProgressBarUi() {

    }

    private void paint(Graphics g, JComponent c, boolean determinate) {
        if (determinate) {
            super.paintDeterminate(g, c);
            Icon icon = new ImageIcon(getClass().getResource("beams.gif"));
            icon.paintIcon(progressBar, g, 0, 0);

        } else {
            super.paintIndeterminate(g, c);
            Icon icon = new ImageIcon(getClass().getResource("supersayjan.gif"));
            icon.paintIcon(progressBar, g, 0, 0);
        }


        progressBar.setForeground(JBColor.YELLOW);

        // border
        final int width = progressBar.getWidth();
        int height = progressBar.getPreferredSize().height;

        drawBorder((Graphics2D) g, width, height);
    }

    private void drawBorder(Graphics2D g, int width, int height) {
        RoundRectangle2D rectangle = getRoundRectangle(width, height);

        final Color color = g.getColor();
        final Stroke stroke = g.getStroke();

        g.setColor(progressBar.getForeground());
        g.setStroke(new BasicStroke(2));
        g.draw(rectangle);

        g.setColor(color);
        g.setStroke(stroke);
    }


    @NotNull
    private RoundRectangle2D getRoundRectangle(final int width, final int height) {
        final float arcLength = JBUIScale.scale(9f);
        final float offset = JBUIScale.scale(2f);

        return new RoundRectangle2D.Float(JBUIScale.scale(1f), JBUIScale.scale(1f), width - offset, height - offset, arcLength, arcLength);
    }

    @Override
    protected void paintIndeterminate(Graphics g, JComponent c) {
        paint(g, c, false);
    }

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        paint(g, c, true);
    }

    @Override
    public Dimension getPreferredSize(final JComponent c) {
        return new Dimension(super.getPreferredSize(c).width, 50);
    }

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(final JComponent c) {
        c.setBorder(JBUI.Borders.empty().asUIResource());
        return new DbzProgressBarUi();
    }

}
