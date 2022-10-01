import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public class DbProgressConfigurationComponent {

    private final Map<Sprite, Boolean> spriteState = new HashMap<>();
    private JPanel mainPanel;

    public DbProgressConfigurationComponent() {
        defaultSpriteState();
        createUI();

    }

    private void defaultSpriteState() {
        DbProgressbarState state = DbProgressbarState.getInstance();
        Arrays.stream(Sprite.values()).forEach(sprite -> spriteState.put(sprite, sprite.getSelected()));
        if (state.getSpriteState().isEmpty()) {
            new ArrayList<>(state.getSpriteState().keySet()).forEach(sprite -> spriteState.put(sprite, sprite.getSelected()));
            state.setSpriteState(spriteState);
        }
    }

    private void createUI() {
        mainPanel = new JPanel();
        ButtonGroup determinateGroup = new ButtonGroup();
        ButtonGroup inDeterminateGroup = new ButtonGroup();

        mainPanel.add(new JLabel("Determinate Sprites:"));

        List<Sprite> determinateSprites = Arrays.stream(Sprite.values()).filter(Sprite::isDeterminate).collect(Collectors.toList());

        createJRadioButtons(determinateGroup, determinateSprites);

        mainPanel.add(new JLabel("Indeterminate Sprites:"));

        List<Sprite> inDeterminateSprites = Arrays.stream(Sprite.values()).filter(sprite -> !sprite.isDeterminate()).collect(Collectors.toList());
        createJRadioButtons(inDeterminateGroup, inDeterminateSprites);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }

    private void createJRadioButtons(ButtonGroup buttonGroup, List<Sprite> spriteList) {
        DbProgressbarState state = DbProgressbarState.getInstance();

        spriteList.forEach(sprite -> {
            JPanel iconPanel = new JPanel();

            iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.LINE_AXIS));

            JRadioButton radioButton = new JRadioButton();
            radioButton.setSelected(state.getSpriteState().get(sprite));
            radioButton.addActionListener(l -> {

                spriteList.forEach(s -> spriteState.put(s, false));

                spriteState.put(sprite, true);

            });

            JLabel icon = new JLabel(sprite.getIcon());

            buttonGroup.add(radioButton);
            iconPanel.add(radioButton);
            iconPanel.add(icon);

            iconPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            mainPanel.add(iconPanel);
        });
    }
}
