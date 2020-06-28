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
/**
 *
 * @author User PC
 */
public class ConsultaTableModel extends GenericTableModel {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karlos
 */

    public ConsultaTableModel(ArrayList dados) {
        super(dados, new String[]{"dataConsulta","Histórico", "Nome Cliente", "Nome Animal", "crvm", "listaExames","id"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                 return String.class;
            case 1:
                return String.class;
            case 2:
                 return Cliente.class;
            case 3:
                return Animal.class;
            case 4:
                return Veterinario.class;
            case 5:
                return String.class;
            case 6:
                return Integer.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public ConsultaTableModel getSelectedObject( int row )
{ 
   
        return (ConsultaTableModel) vDados.get(row);
}
    
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return consulta.getData();
            case 1:
                return consulta.getHistorico();
            case 2:
                return consulta.getIdCliente();
            case 3:
                return consulta.getIdAnimal();
            case 4:
                return consulta.getCRVM();
            case 5:
                return consulta.getListaDeExames();
                
            case 6:
                return consulta.getId();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                consulta.setData((String)aValue);
                break;
            case 1:
                consulta.setHistorico((String)aValue);
                break;
            case 2:
                consulta.setIdCliente((Cliente)aValue);
                break;
            case 3:
                 consulta.setIdAnimal((Animal)aValue);
                 break;
            case 4:
                 consulta.setCRVM((Veterinario)aValue);
               break;
            case 5:
                 consulta.setListaDeExames((String)aValue);
           break;
            case 6:
                break;
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
      ConsultaDAO.getInstance().update(consulta);
    }      
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}


