import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloodFill {

    public static void floodFill(BufferedImage image, int startX, int startY, Color targetColor, Color replacementColor) {
        if (targetColor.equals(replacementColor)) {
            return;
        }

        int width = image.getWidth();
        int height = image.getHeight();
        StaticStack stack = new StaticStack(width * height);

        stack.push(new Coordenada(startX, startY));

        while (!stack.isEmpty()) {
            Coordenada coord = stack.pop();
            int x = coord.getX();
            int y = coord.getY();

            if (x < 0 || x >= width || y < 0 || y >= height) {
                continue;
            }

            Color currentColor = new Color(image.getRGB(x, y));

            if (!currentColor.equals(targetColor)) {
                continue;
            }

            image.setRGB(x, y, replacementColor.getRGB());

            stack.push(new Coordenada(x + 1, y));
            stack.push(new Coordenada(x - 1, y));
            stack.push(new Coordenada(x, y + 1));
            stack.push(new Coordenada(x, y - 1));
        }
    }
}