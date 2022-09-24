import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class DbProgressbarConfigurable implements Configurable {

    private DbProgressConfigurationComponent component;


    @Nls
    @Override
    public String getDisplayName() {
        return "Dragonball Progress Bar Settings";
    }

    @Override
    public @Nullable JComponent createComponent() {
        component = new DbProgressConfigurationComponent();
        return component.getMainPanel();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() {
        System.out.println("apply2");
        DbProgressbarState state = DbProgressbarState.getInstance();

        boolean selected = ((JRadioButton) ((JPanel) component.getMainPanel().getComponent(1)).getComponent(0)).isSelected();
        System.out.println(selected);

    }
}
