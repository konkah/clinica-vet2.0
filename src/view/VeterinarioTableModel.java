package view;

import java.util.ArrayList;
import model.Veterinario;
import model.VeterinarioDAO;


public class VeterinarioTableModel extends GenericTableModel {

    public VeterinarioTableModel(ArrayList dados){
        super(dados, new String[]{"Nome","Endereco", "Telefone","especialidade","crvm", "ID"});
    }
    
    
     @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            
            case 5:
                return Integer.class;
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return veterinario.getNome();
            case 1:
                return veterinario.getEndereco();
            case 2:
                return veterinario.getTelefone();
            case 3:
                return veterinario.getEspecialidade();
            case 4:
                return veterinario.getCrvm();
                
            case 5:
                return veterinario.getId();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
   
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                veterinario.setNome((String)aValue);
                break;
            case 1:
            	veterinario.setEndereco((String)aValue);
                break;
            case 2:
            	veterinario.setTelefone((String)aValue);
                break;
            case 3:
                veterinario.setEspecialidade((String)aValue);
            case 4:
                veterinario.setCrvm((String)aValue);
                break;
            
            case 5:
                break;
              
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        VeterinarioDAO.getInstance().update(veterinario);
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }      
    
}
