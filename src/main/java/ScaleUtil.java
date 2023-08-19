import com.intellij.util.ui.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScaleUtil {

    public static ImageIcon scaleIconToHeight(Sprite imageIcon, int heightToUse) {

        ImageIcon originalicon = imageIcon.getIcon();

        double ratio = (double) originalicon.getIconHeight() / originalicon.getIconWidth();

        int newWidth = (int) (heightToUse / ratio);

        Image originalimage = originalicon.getImage();
        BufferedImage scaledImage = ImageUtil.createImage(newWidth, heightToUse, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(originalimage, 0, 0, newWidth, heightToUse, null);
        g.dispose();

        return new ImageIcon(scaledImage);
    }
}
