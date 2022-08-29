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
        return new Dimension(400, 75);
    }

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(final JComponent c) {
        return new DbzProgressBarUi();
    }

}
