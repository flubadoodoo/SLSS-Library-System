package guiElements;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXPanel;

import font.MFont;

@SuppressWarnings("serial")
public class MLabel extends JXLabel {
	
	public MLabel(String text, int x, int y, JXPanel panel, boolean special) {
		setText(text);
		setFont(special ? MFont.getLabelSFont() : MFont.getLabelFont());
		setBounds(x, y, MFont.getLabelWidth(this), MFont.getLabelHeight(this));
		panel.add(this);
	}
	
}
