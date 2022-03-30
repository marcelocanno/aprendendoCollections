package mySqlConection;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MyRowSetListener implements AdjustmentListener, RowSetListener{

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		
		
	}
	public void rowChanged(RowSetEvent event) {
		System.out.println("Quando a linha for atualizada, deletada ou inserida");
		if(event.getSource() instanceof RowSet) {
			try {
				((RowSet) event.getSource()).execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void cursorMoved(RowSetEvent event) {
		System.out.println("Toda vez que o cursor se mover");
	}
	public void rowSetChanged(RowSetEvent event) {
		System.out.println("Comando excute foi executado");
	}
}
