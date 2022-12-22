import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;

@Getter
@AllArgsConstructor
public enum Sprite {
    GOKU_RUNNING(1, new ImageIcon(DbzProgressBarUi.getResource("goku_run.gif")), true, false, 30),
    GOKU_JINDUJUN(2, new ImageIcon(DbzProgressBarUi.getResource("jindujun.png")), true, true, 30),
    GOKU_KAMEHAMEHA_SMALL(3, new ImageIcon(DbzProgressBarUi.getResource("kamehameha.gif")), false, true, null),
    GOKU_KAMEHAMEHA(4, new ImageIcon(DbzProgressBarUi.getResource("goku_kamehameha.gif")), false, false, null),
    GOKU_KI_1(5, new ImageIcon(DbzProgressBarUi.getResource("goku_ki.gif")), false, false, 0),
    GOKU_KI_2(6, new ImageIcon(DbzProgressBarUi.getResource("load_kamehameha.gif")), false, false, 0),
    VEGETA_FINAL_FLASH(7, new ImageIcon(DbzProgressBarUi.getResource("vegeta_final_flash.gif")), false, false, 0),
    ;

    private final int id;
    private final ImageIcon icon;
    private final boolean isDeterminate;
    private final Boolean defaultSelected;
    private final Integer offset;

}
