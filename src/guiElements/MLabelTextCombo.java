package guiElements;

import panel.abstractPanel.AbstractPanel;

public class MLabelTextCombo {
	
	MLabel label;
	MTextField textField;
	
	public MLabelTextCombo(String labelText, String prompt, int x, int y, AbstractPanel panel) {
		label = new MLabel(labelText + " :", x, y, panel, false);
		textField = new MTextField(prompt, x, y, panel);
		double height = Math.max(label.getBounds().getHeight(), textField.getBounds().getHeight());
		label.setLocation(x, (int) (y + height / 2 - label.getBounds().getHeight() / 2));
		textField.setLocation((int) (x + label.getBounds().getWidth() + 10), (int) (y + height / 2 - textField.getBounds().getHeight() / 2));
	}
	
	public MLabelTextCombo(String labelText, String prompt, int x, int y, int width, AbstractPanel panel) {
		label = new MLabel(labelText + " :", x, y, panel, false);
		textField = new MTextField(prompt, x, y, panel);
		double height = Math.max(label.getBounds().getHeight(), textField.getBounds().getHeight());
		label.setLocation(x, (int) (y + height / 2 - label.getBounds().getHeight() / 2));
		textField.setLocation((int) (x + label.getBounds().getWidth() + 10), (int) (y + height / 2 - textField.getBounds().getHeight() / 2));
		textField.setSize((int) (width - label.getBounds().getWidth() - 10), (int) textField.getBounds().getHeight());
	}
	
	public MLabel getLabel() {
		return label;
	}
	
	public void setLabel(MLabel label) {
		this.label = label;
	}
	
	public MTextField getTextField() {
		return textField;
	}
	
	public void setTextField(MTextField textField) {
		this.textField = textField;
	}
}
