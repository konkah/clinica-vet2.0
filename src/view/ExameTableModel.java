/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.Animal;
import model.Cliente;
import model.Consulta;
import model.Veterinario;
import model.ConsultaDAO;
import model.Exame;
import model.ExameDAO;
/**
 *
 * @author User PC
 */
public class ExameTableModel extends GenericTableModel {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karlos
 */

    public ExameTableModel(ArrayList dados) {
        super(dados, new String[]{"Nome do Exame"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                 return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public ExameTableModel getSelectedObject( int row )
{ 
   
        return (ExameTableModel) vDados.get(row);
}
    
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exame exame = (Exame) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return exame.getDescricao();               
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Exame exame = (Exame) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                exame.setDescricao((String)aValue);
                break;    
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
      ExameDAO.getInstance().update(exame);
    }      
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}


