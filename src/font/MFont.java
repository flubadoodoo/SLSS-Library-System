package font;

import guiElements.MButton;
import guiElements.MyTextField;

import java.awt.Font;

import org.jdesktop.swingx.JXLabel;

public class MFont {
	
	private static final Font labelFont = new Font("Cantarell 11", Font.PLAIN, 16);
	private static final Font textFont = new Font("Cantarell 11", Font.PLAIN, 16);
	private static final Font buttonFont = new Font("Cantarell 11", Font.PLAIN, 16);
	
	private static final Font labelSFont = new Font("Cantarell 11", Font.BOLD, 20);
	
	public static int getLabelWidth(JXLabel label) {
		return label.getFontMetrics(label.getFont()).stringWidth(label.getText());
	}
	
	public static int getLabelHeight(JXLabel label) {
		return label.getFontMetrics(label.getFont()).getHeight();
	}
	
	public static int getTextWidth(MyTextField text) {
		return text.getFontMetrics(text.getFont()).stringWidth(text.getText());
	}
	
	public static int getTextHeight(MyTextField text) {
		return text.getFontMetrics(text.getFont()).getHeight();
	}
	
	public static int getButtonWidth(MButton button) {
		return button.getFontMetrics(button.getFont()).stringWidth(button.getText()) + 34;
	}
	
	public static int getButtonHeight(MButton button) {
		return button.getFontMetrics(button.getFont()).getHeight() + 17;
	}
	
	public static Font getLabelFont() {
		return labelFont;
	}
	
	public static Font getTextFont() {
		return textFont;
	}
	
	public static Font getButtonFont() {
		return buttonFont;
	}
	
	public static Font getLabelSFont() {
		return labelSFont;
	}
	
}
