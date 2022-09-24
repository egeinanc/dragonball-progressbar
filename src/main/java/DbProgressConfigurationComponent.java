import jdk.jfr.SettingDefinition;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
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

        determinateSprites.forEach(sprite -> {
            JRadioButton radioButton = new JRadioButton(sprite.toString());
            determinateGroup.add(radioButton);
            mainPanel.add(radioButton);
        });

        mainPanel.add(new JLabel("Indeterminate Sprites:"));

        List<Sprite> inDeterminateSprites = Arrays.stream(Sprite.values()).filter(sprite -> !sprite.isDeterminate()).collect(Collectors.toList());
        inDeterminateSprites.forEach(sprite -> {
            JRadioButton radioButton = new JRadioButton(sprite.toString());
            inDeterminateGroup.add(radioButton);
            mainPanel.add(radioButton);

        });


        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }


}
