import lombok.Getter;

import javax.swing.*;

@Getter
public enum Sprite {
    GOKU_RUNNING(new ImageIcon(DbzProgressBarUi.getResource("goku_run.gif"))),
    GOKU_KAMEHAMEHA(new ImageIcon(DbzProgressBarUi.getResource("kamehameha.gif"))),
    GOKU_KI_1(new ImageIcon(DbzProgressBarUi.getResource("goku_ki.gif"))),
    GOKU_KI_2(new ImageIcon(DbzProgressBarUi.getResource("load_kamehameha.gif"))),
    GOKU_JINDUJUN(new ImageIcon(DbzProgressBarUi.getResource("jindujun.png"))),
    VEGETA_FINAL_FLASH(new ImageIcon(DbzProgressBarUi.getResource("vegeta_final_flash.gif"))),
    ;

    private final ImageIcon icon;

    Sprite(ImageIcon icon) {
        this.icon = icon;
    }
}
