import com.intellij.ui.components.JBRadioButton;
import java.awt.Component;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.*;
import lombok.Getter;

@Getter
public class DbProgressConfigurationComponent {

    private final Map<Sprite, Boolean> spriteState = new HashMap<>();
    private final JSlider slider = new JSlider();
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
        DbProgressbarState state = DbProgressbarState.getInstance();
        mainPanel = new JPanel();

        mainPanel.setLayout(null);


        createSlider(state.getProgressbarHeight());
        createSpriteList();
    }

    private void createSpriteList() {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));

        listPanel.setBounds(0, 60, 500, 1000);

        listPanel.add(new JLabel("Determinate Sprites:"));

        ButtonGroup determinateGroup = new ButtonGroup();
        ButtonGroup inDeterminateGroup = new ButtonGroup();

        List<Sprite> determinateSprites = Arrays.stream(Sprite.values()).filter(Sprite::isDeterminate).collect(Collectors.toList());

        createJRadioButtons(determinateGroup, determinateSprites, listPanel);

        listPanel.add(new JLabel("Indeterminate Sprites:"));

        List<Sprite> inDeterminateSprites = Arrays.stream(Sprite.values()).filter(sprite -> !sprite.isDeterminate()).collect(Collectors.toList());
        createJRadioButtons(inDeterminateGroup, inDeterminateSprites, listPanel);

        mainPanel.add(listPanel);

    }

    private void createSlider(int value) {
        JPanel heightPanel = new JPanel();

        heightPanel.setBounds(0,0, 300, 50);

        heightPanel.add(new JLabel("Height:"));

        slider.setMinimum(20);
        slider.setMaximum(50);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.createStandardLabels(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setValue(value);

        heightPanel.add(slider);

        mainPanel.add(heightPanel);
    }


    private void createJRadioButtons(ButtonGroup buttonGroup, List<Sprite> spriteList, JPanel panel) {
        DbProgressbarState state = DbProgressbarState.getInstance();

        spriteList.forEach(sprite -> {
            JPanel iconPanel = new JPanel();

            iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.LINE_AXIS));

            JBRadioButton radioButton = new JBRadioButton();
            radioButton.setSelected(state.getSpriteState().get(sprite));
            spriteState.put(sprite, state.getSpriteState().get(sprite));
            radioButton.addActionListener(l -> {

                spriteList.forEach(s -> spriteState.put(s, false));

                spriteState.put(sprite, true);

            });

            JLabel icon = new JLabel(ScaleUtil.scaleIconToHeight(sprite, 50));

            buttonGroup.add(radioButton);
            iconPanel.add(radioButton);
            iconPanel.add(icon);

            iconPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(iconPanel);
        });
    }
}
