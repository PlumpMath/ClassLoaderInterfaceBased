package about.image;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ImageResizeProportionally {

	public static void main(String[] args) {

		String path_immagine = "C:\\mia_immagine.jpg";

		BufferedImage srcImage;
		try {
			srcImage = ImageIO.read(new File(path_immagine));

			BufferedImage scaledImage = getScaledImage(srcImage);

			showImage(scaledImage);
			
			saveImage(scaledImage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void saveImage(BufferedImage scaledImage) throws FileNotFoundException, IOException {
		FileOutputStream file = new FileOutputStream("C:\\Users\\f.rosa\\Documents\\mia_immmagine_ridimensionata.jpg");
         ImageIO.write(scaledImage, "jpg", file);
         file.close();
	}

	// Ridimensionamento 100x118
	private static BufferedImage getScaledImage(BufferedImage originalImage) {

		int MAX_IMG_WIDTH = 110;
		int MAX_IMG_HEIGHT = 118;

		int width = originalImage.getWidth();
		int height = originalImage.getHeight();

		Dimension originalDimension = new Dimension(originalImage.getWidth(),
				originalImage.getHeight());
		Dimension boundaryDimension = new Dimension(MAX_IMG_WIDTH,
				MAX_IMG_HEIGHT);
		Dimension scalingDimension = getScaledDimension(originalDimension,
				boundaryDimension);

		width = (int) scalingDimension.getWidth();
		height = (int) scalingDimension.getHeight();

		BufferedImage resizedImage = new BufferedImage(width, height,
				originalImage.getType());
		Graphics2D g = resizedImage.createGraphics();

		g.drawImage(originalImage, 0, 0, width, height, null);

		return resizedImage;

	}

	/**
	 * Visualizzazione dell'immagine ridimensionata in un JFrame
	 */
	private static void showImage(BufferedImage image) {

		JFrame editorFrame = new JFrame("Immagine ridimensionata");
		editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		ImageIcon imageIcon = new ImageIcon(image);

		JLabel jLabel = new JLabel();
		jLabel.setIcon(imageIcon);

		editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

		editorFrame.pack();
		editorFrame.setLocationRelativeTo(null);
		editorFrame.setVisible(true);

	}

	public static Dimension getScaledDimension(Dimension imgSize,
			Dimension boundary) {

		int original_width = imgSize.width;
		int original_height = imgSize.height;
		int bound_width = boundary.width;
		int bound_height = boundary.height;
		int new_width = original_width;
		int new_height = original_height;

		// first check if we need to scale width
		if (original_width > bound_width) {
			// scale width to fit
			new_width = bound_width;
			// scale height to maintain aspect ratio
			new_height = (new_width * original_height) / original_width;
		}

		// then check if we need to scale even with the new height
		if (new_height > bound_height) {
			// scale height to fit instead
			new_height = bound_height;
			// scale width to maintain aspect ratio
			new_width = (new_height * original_width) / original_height;
		}

		return new Dimension(new_width, new_height);
	}
}
