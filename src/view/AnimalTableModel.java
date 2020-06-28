/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import model.AnimalDAO;
import model.Cliente;
import model.Animal;
import view.GenericTableModel;

/**
 *
 * @author Kevin
 */
public class AnimalTableModel extends GenericTableModel {

    public AnimalTableModel(ArrayList dados) {
        super(dados, new String[]{"Nome do animal","Ano de Nascimento", "Sexo", "Cliente","Tratamentos","id"});
    }
    
    
    
      public AnimalTableModel getSelectedObject( int row )
{ 
   
        return  (AnimalTableModel) vDados.get(row);
}
      
      
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                 return String.class;
            case 1:
                return Integer.class;
            case 2:
                 return String.class;
            case 3:
                return Cliente.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return animal.getNome();
            case 1:
                return animal.getAnoNasc();
            case 2:
                return animal.getSexo();
            case 3:
                return animal.getCliente();
            case 4:
                return animal.getTratamentos();    
            case 5:
                return animal.getId();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                animal.setNome((String)aValue);
                break;
            case 1:
                animal.setAnoNasc((Integer)aValue);
                break;
            case 2:
                animal.setSexo((String)aValue);
                break;
            case 3:
                animal.setCliente((Cliente)aValue);
                break;
            case 4:
               
            case 5:
                 animal.setListaDeTratamentos((String)aValue);

                
                break;
             
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        AnimalDAO.getInstance().update(animal);
    }      
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
