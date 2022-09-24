import lombok.Getter;

import javax.swing.*;

@Getter
public enum Sprite {
    GOKU_RUNNING(new ImageIcon(DbzProgressBarUi.getResource("goku_run.gif")), true),
    GOKU_JINDUJUN(new ImageIcon(DbzProgressBarUi.getResource("jindujun.png")), true),
    GOKU_KAMEHAMEHA_SMALL(new ImageIcon(DbzProgressBarUi.getResource("kamehameha.gif")), false),
    GOKU_KAMEHAMEHA(new ImageIcon(DbzProgressBarUi.getResource("goku_kamehameha.gif")), false),
    GOKU_KI_1(new ImageIcon(DbzProgressBarUi.getResource("goku_ki.gif")), false),
    GOKU_KI_2(new ImageIcon(DbzProgressBarUi.getResource("load_kamehameha.gif")), false),
    VEGETA_FINAL_FLASH(new ImageIcon(DbzProgressBarUi.getResource("vegeta_final_flash.gif")), false),
    ;

    private final ImageIcon icon;
    private final boolean isDeterminate;

    Sprite(ImageIcon icon, boolean isDeterminate) {
        this.icon = icon;
        this.isDeterminate = isDeterminate;
    }
}
