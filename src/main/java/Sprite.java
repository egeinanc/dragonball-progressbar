import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;

@Getter
@AllArgsConstructor
public enum Sprite {
    GOKU_JINDUJUN(2, new ImageIcon(DbzProgressBarUi.getResource("jindujun.png")), true, true, 30),
    GOKU_FLYING(3, new ImageIcon(DbzProgressBarUi.getResource("flying_goku.png")), true, false, null),
;
    private final int id;
    private final ImageIcon icon;
    private final boolean isDeterminate;
    private final Boolean defaultSelected;
    private final Integer offset;

}
