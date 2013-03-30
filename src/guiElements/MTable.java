package guiElements;

import javax.swing.ListSelectionModel;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

import panel.abstractPanel.AbstractPanel;

@SuppressWarnings("serial")
public class MTable extends JXTable {
	
	public MTable(int x, int y, int width, String[][] data, String[] columns, AbstractPanel panel) {
		super(data, columns);
		setBounds(x, y, width, getRowHeight() * getRowCount());
		setHighlighters(HighlighterFactory.createAlternateStriping());
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setEditable(false);
		panel.add(this);
	}
	
}
