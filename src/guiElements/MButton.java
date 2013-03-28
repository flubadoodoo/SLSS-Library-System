package guiElements;

import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXPanel;

import font.MFont;

@SuppressWarnings("serial")
public class MButton extends JXButton {
	
	public MButton(String text, int x, int y, JXPanel panel) {
		setText(text);
		setFont(MFont.getButtonFont());
		setBounds(x, y, MFont.getButtonWidth(this), MFont.getButtonHeight(this));
		panel.add(this);
	}
	
	public MButton(String text) {
		super(text);
	}
	
	public MButton(Action a) {
		super(a);
	}
	
	public MButton(Icon icon) {
		super(icon);
	}
	
	public MButton(String text, Icon icon) {
		super(text, icon);
	}
	
	public MButton(String text, int x, int y, JXPanel panel, ActionListener actionListener) {
		setText(text);
		setFont(MFont.getButtonFont());
		setBounds(x, y, MFont.getButtonWidth(this), MFont.getButtonHeight(this));
		panel.add(this);
		addActionListener(actionListener);
	}
	
}
