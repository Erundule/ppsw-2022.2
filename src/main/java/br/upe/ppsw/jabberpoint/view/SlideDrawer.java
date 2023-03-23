package br.upe.ppsw.jabberpoint.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.controller.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;

public class SlideDrawer {

	public static void draw(Graphics g, Rectangle area, ImageObserver view, Slide slide) {
	    float scale = getScale(area);

	    int y = area.y;

	    SlideItem slideItem = slide.getTitle();
	    	    
	    Style style = Style.getStyle(slideItem.getLevel());
	    slideItem.draw(area.x, y, scale, g, style, view);

	    y += slideItem.getBoundingBox(g, view, scale, style).height;

	    for (int number = 0; number < slide.getSize(); number++) {
	      slideItem = (SlideItem) slide.getSlideItems().elementAt(number);

	      style = Style.getStyle(slideItem.getLevel());
	      slideItem.draw(area.x, y, scale, g, style, view);

	      y += slideItem.getBoundingBox(g, view, scale, style).height;
	    }
	  }

	  public static float getScale(Rectangle area) {
	    return Math.min(((float) area.width) / ((float) WIDTH),
	        ((float) area.height) / ((float) HEIGHT));
	  }

	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	  
	public static int getWidth() {
			return SlideDrawer.WIDTH;
		}

	  public static int getHeight() {
			return SlideDrawer.HEIGHT;
		}
}
