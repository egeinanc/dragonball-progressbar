import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@State(
        name = "DbProgressState",
        storages = {@Storage("DbProgress.xml")}
)
@Getter
@Setter
public class DbProgressbarState implements PersistentStateComponent<DbProgressbarState> {

    private Map<Sprite, Boolean> spriteState = new HashMap<>();

    public static DbProgressbarState getInstance() {
        return ApplicationManager.getApplication().getService(DbProgressbarState.class);
    }

    @Override
    public @Nullable DbProgressbarState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull DbProgressbarState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
