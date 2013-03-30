package guiElements;

import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTextField;

import font.MFont;

@SuppressWarnings("serial")
public class MTextField extends JXTextField {
	
	public MTextField(String prompt, int x, int y, JXPanel panel) {
		setPrompt(prompt);
		setFont(MFont.getTextFont());
		setBounds(x, y, MFont.getTextWidth(this), MFont.getTextHeight(this));
		panel.add(this);
	}
	
	public MTextField(String prompt, int x, int y, int width, int height, JXPanel panel) {
		setPrompt(prompt);
		setFont(MFont.getTextFont());
		setBounds(x, y, width, height);
		panel.add(this);
	}
	
}
