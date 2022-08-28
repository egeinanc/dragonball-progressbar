import com.intellij.ui.JBColor;
import com.intellij.ui.scale.JBUIScale;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

public class DbzProgressBarUi extends BasicProgressBarUI {

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
        super.paintIndeterminate(g, c);
        Icon sonGoku = new ImageIcon(getClass().getResource("goku_kamehameha.gif"));
        sonGoku.paintIcon(progressBar, g, 0, 0);

        Icon vegeta = new ImageIcon(getClass().getResource("vegeta_final_flash.gif"));
        vegeta.paintIcon(progressBar, g, progressBar.getWidth() - vegeta.getIconWidth(), 0);


        progressBar.setForeground(UIUtil.getBoundsColor());

    }

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        super.paintDeterminate(g, c);

        Icon clouds = new ImageIcon(getClass().getResource("clouds.png"));
        clouds.paintIcon(progressBar, g, 0, 0);

        Icon icon = new ImageIcon(getClass().getResource("jindujun.png"));
        int amountFull = getAmountFull(progressBar.getInsets(), progressBar.getWidth(), progressBar.getHeight());
        icon.paintIcon(progressBar, g, amountFull <= 10 ? 20 - icon.getIconWidth(): amountFull - icon.getIconWidth(), 0);

    }

    @Override
    public Dimension getPreferredSize(final JComponent c) {
        return new Dimension(super.getPreferredSize(c).width, 75);
    }

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(final JComponent c) {
        return new DbzProgressBarUi();
    }

}
