package ViewCover;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTable extends DefaultTableCellRenderer {

	    public CustomTable() {

	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        int cellValue = Integer.parseInt(table.getValueAt(row, 5).toString());
	        Component cellComponent = super.getTableCellRendererComponent(
	                table, value, isSelected, hasFocus, row, column);
	        
	        // Thay đổi màu chữ của từng hàng
	        if (cellValue == 0) {
	            cellComponent.setForeground(Color.orange);
	        } else {
	            cellComponent.setForeground(Color.BLUE);
	        }
	        
	        return cellComponent;
	    }
	}
