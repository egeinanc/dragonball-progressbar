import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Arrays;

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
        DbProgressbarState state = DbProgressbarState.getInstance();

        if (!Integer.valueOf(component.getSlider().getValue()).equals(state.getProgressbarHeight())) {
            return true;
        }

        for (Sprite sprite : Sprite.values()) {
            Boolean componentValue = component.getSpriteState().get(sprite);
            Boolean stateValue = state.getSpriteState().get(sprite);

            if (componentValue != stateValue) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void apply() {
        DbProgressbarState state = DbProgressbarState.getInstance();
        Arrays.stream(Sprite.values()).forEach(sprite -> {
            Boolean componentValue = component.getSpriteState().get(sprite);
            state.getSpriteState().put(sprite, componentValue);
        });

        state.setProgressbarHeight(component.getSlider().getValue());

    }
}
