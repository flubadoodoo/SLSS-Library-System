package guiElements;

import java.awt.Color;

import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTextField;

import font.MFont;

@SuppressWarnings("serial")
public class MyTextField extends JXTextField {
	
	public MyTextField(String prompt, int x, int y, JXPanel panel) {
		setPrompt(prompt);
		setFont(MFont.getTextFont());
		setBounds(x, y, MFont.getTextWidth(this), MFont.getTextHeight(this));
		panel.add(this);
	}
	
	public MyTextField(String prompt, int x, int y, int width, int height, JXPanel panel) {
		setPrompt(prompt);
		setFont(MFont.getTextFont());
		setBounds(x, y, width, height);
		panel.add(this);
	}
	
	public MyTextField(String promptText) {
		super(promptText);
	}
	
	public MyTextField(String promptText, Color promptForeground) {
		super(promptText, promptForeground);
	}
	
	public MyTextField(String promptText, Color promptForeground, Color promptBackground) {
		super(promptText, promptForeground, promptBackground);
		
	}
	
}
