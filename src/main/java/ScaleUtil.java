import com.intellij.ui.paint.PaintUtil;
import com.intellij.ui.scale.ScaleContext;
import com.intellij.util.ui.ImageUtil;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class ScaleUtil {

    public static ImageIcon scaleIconToHeight(Sprite imageIcon, int heightToUse) {

        ImageIcon originalicon = imageIcon.getIcon();

        double ratio = (double) originalicon.getIconHeight() / originalicon.getIconWidth();

        int newWidth = (int) (heightToUse / ratio);

        Image originalimage = originalicon.getImage();
        ScaleContext sc = ScaleContext.createIdentity();
        BufferedImage scaledImage = ImageUtil.createImage(sc, newWidth, heightToUse, BufferedImage.TYPE_INT_ARGB, PaintUtil.RoundingMode.CEIL);

        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(originalimage, 0, 0, newWidth, heightToUse, null);
        g.dispose();

        return new ImageIcon(scaledImage);
    }
}
