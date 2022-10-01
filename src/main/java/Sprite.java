import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;

@Getter
@AllArgsConstructor
public enum Sprite {
    GOKU_RUNNING(1, new ImageIcon(DbzProgressBarUi.getResource("goku_run.gif")), true, false),
    GOKU_JINDUJUN(2, new ImageIcon(DbzProgressBarUi.getResource("jindujun.png")), true, true),
    GOKU_KAMEHAMEHA_SMALL(3, new ImageIcon(DbzProgressBarUi.getResource("kamehameha.gif")), false, true),
    GOKU_KAMEHAMEHA(4, new ImageIcon(DbzProgressBarUi.getResource("goku_kamehameha.gif")), false, false),
    GOKU_KI_1(5, new ImageIcon(DbzProgressBarUi.getResource("goku_ki.gif")), false, false),
    GOKU_KI_2(6, new ImageIcon(DbzProgressBarUi.getResource("load_kamehameha.gif")), false, false),
    VEGETA_FINAL_FLASH(7, new ImageIcon(DbzProgressBarUi.getResource("vegeta_final_flash.gif")), false, false),
    ;

    private final int id;
    private final ImageIcon icon;
    private final boolean isDeterminate;
    private final Boolean defaultSelected;

}
