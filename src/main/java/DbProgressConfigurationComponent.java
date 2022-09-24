import lombok.Getter;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DbProgressConfigurationComponent {

    private JPanel mainPanel;

    public DbProgressConfigurationComponent() {
        createUI();

    }

    private void createUI() {
        mainPanel = new JPanel();
        ButtonGroup determinateGroup = new ButtonGroup();
        ButtonGroup inDeterminateGroup = new ButtonGroup();

        mainPanel.add(new JLabel("Deerminate Sprites:"));

        List<Sprite> determinateSprites = Arrays.stream(Sprite.values()).filter(Sprite::isDeterminate).collect(Collectors.toList());
        createJRadioButtons(determinateGroup, determinateSprites);

        mainPanel.add(new JLabel("Indeterminate Sprites:"));

        List<Sprite> inDeterminateSprites = Arrays.stream(Sprite.values()).filter(sprite -> !sprite.isDeterminate()).collect(Collectors.toList());
        createJRadioButtons(inDeterminateGroup, inDeterminateSprites);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }

    private void createJRadioButtons(ButtonGroup buttonGroup, List<Sprite> spriteList) {
        spriteList.forEach(sprite -> {
            JPanel iconPanel = new JPanel();
            iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.LINE_AXIS));
            JRadioButton radioButton = new JRadioButton();
            JLabel icon = new JLabel(sprite.getIcon());
            buttonGroup.add(radioButton);
            iconPanel.add(radioButton);
            iconPanel.add(icon);

            mainPanel.add(iconPanel);
        });
    }


}
