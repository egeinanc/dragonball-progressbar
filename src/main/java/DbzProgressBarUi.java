import com.intellij.ui.JBColor;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

public class DbzProgressBarUi extends BasicProgressBarUI {
    public DbzProgressBarUi() {

    }

    private void paint(Graphics g, JComponent c, boolean determinate) {
        if (determinate) {
            super.paintDeterminate(g, c);

        } else {
            super.paintIndeterminate(g, c);
        }

        Icon icon = new ImageIcon(DbzProgressBarUi.class.getResource("goku2.png"));
        icon.paintIcon(progressBar, g, 0, 0);

        System.out.println(progressBar.getHeight());
        System.out.println(progressBar.getWidth());
        progressBar.setBorder(BorderFactory.createLineBorder(JBColor.YELLOW));
        progressBar.setForeground(JBColor.CYAN);

    }

    @Override
    protected void paintIndeterminate(Graphics g, JComponent c) {
        paint(g, c, false);
    }

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        paint(g, c, true);
    }

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(final JComponent c) {
        c.setBorder(JBUI.Borders.empty().asUIResource());
        return new DbzProgressBarUi();
    }

}
