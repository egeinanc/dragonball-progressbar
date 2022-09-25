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

        // todo fix
        DbProgressbarState state = DbProgressbarState.getInstance();
        System.out.println((component.getSpriteState() != state.getSpriteState()));
        return component.getSpriteState() != state.getSpriteState();
    }

    @Override
    public void apply() {

        // todo fix
        System.out.println("apply");
        DbProgressbarState state = DbProgressbarState.getInstance();

        state.setSpriteState(component.getSpriteState());
    }
}
