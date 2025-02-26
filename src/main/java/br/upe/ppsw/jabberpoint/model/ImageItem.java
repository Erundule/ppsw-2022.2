package br.upe.ppsw.jabberpoint.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.springframework.util.ResourceUtils;

import br.upe.ppsw.jabberpoint.view.Style;

public class ImageItem extends SlideItem {

  public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	
	private BufferedImage bufferedImage;
	private String imageName;
	protected static final String FILE = "Arquivo ";
	protected static final String NOTFOUND = " não encontrado";

  public ImageItem(int level, String name) {
    super(level);

    imageName = name;

    try {
      bufferedImage = ImageIO.read(ResourceUtils.getFile(imageName).getAbsoluteFile());
    } catch (IOException e) {
      System.err.println(FILE + imageName + NOTFOUND);
    }

  }

  public ImageItem() {
    this(0, null);
  }

  public String getName() {
    return imageName;
  }

  public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
    return new Rectangle((int) (myStyle.getIndent() * scale), 0,
        (int) (bufferedImage.getWidth(observer) * scale),
        ((int) (myStyle.getLeading() * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
  }

  public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
    int width = x + (int) (myStyle.getIndent() * scale);
    int height = y + (int) (myStyle.getLeading() * scale);

    g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
        (int) (bufferedImage.getHeight(observer) * scale), observer);
  }

  public String toString() {
    return "BitmapItem[" + getLevel() + "," + imageName + "]";
  }
}
