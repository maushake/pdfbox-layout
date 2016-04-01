package rst.pdfbox.layout.elements;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import rst.pdfbox.layout.text.Position;

/**
 * A drawable element that occupies some vertical space without any graphical
 * representation.
 */
public class VerticalSpacer implements Drawable, Element, Dividable {

    private float height;

    /**
     * Creates a vertical space with the given height.
     * 
     * @param height
     */
    public VerticalSpacer(float height) {
	this.height = height;
    }

    @Override
    public float getWidth() throws IOException {
	return 0;
    }

    @Override
    public float getHeight() throws IOException {
	return height;
    }

    @Override
    public Position getAbsolutePosition() {
	return null;
    }

    @Override
    public void draw(PDPageContentStream contentStream, Position origin)
	    throws IOException {
	// nothing to draw
    }

    @Override
    public Divided divide(float remainingHeight, final float pageHeight)
	    throws IOException {
	return new Divided(new VerticalSpacer(remainingHeight),
		new VerticalSpacer(getHeight() - remainingHeight));
    }
}