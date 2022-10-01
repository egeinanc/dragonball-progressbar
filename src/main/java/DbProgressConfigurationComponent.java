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
        syncState();
        createUI();

    }

    public static void syncState() {
        DbProgressbarState state = DbProgressbarState.getInstance();
        for (Sprite sprite : Sprite.values()) {
            // insert into state a possible new value
            state.getSpriteState().computeIfAbsent(sprite, Sprite::getDefaultSelected);
        }

        // remove all keys of state which are not available
        for (Sprite sprite : new ArrayList<>(state.getSpriteState().keySet())) {
            List<Sprite> sprites = Arrays.asList(Sprite.values());
            if (!sprites.contains(sprite)) {
                state.getSpriteState().remove(sprite);
            }
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
            spriteState.put(sprite, state.getSpriteState().get(sprite));
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
