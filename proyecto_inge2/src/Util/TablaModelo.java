package Util;

import javax.swing.table.DefaultTableModel;

//modelo de tabla, las tablas que usen este modelo no seran editables
public class TablaModelo extends DefaultTableModel {
         public boolean isCellEditable (int filas,int Columnas){
			return false;	
	}
}
