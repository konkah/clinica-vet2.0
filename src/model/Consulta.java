package model;

/**
 *
 * @author Plinio Vilela
 */
public class Consulta {
    private int id;
    private String data;
    private Cliente IdCliente;
    private Animal IdAnimal;
    private String historico;
    private Veterinario veterinario;
    private String listaDeExames;
    private Realizada realizada;

    public Consulta(int id, String data, String historico,Cliente IdCliente,Animal IdAnimal,  Veterinario veterinario, String exames, Realizada realizada) {
        this.id = id;
        this.data = data;
        this.historico = historico;
        this.IdCliente = IdCliente;
        this.IdAnimal = IdAnimal;
        this.veterinario = veterinario;
        this.listaDeExames = exames;
        this.realizada = realizada;
    }

    public int getId(){
        return id;
    }
    
    public int setId(){
        return id;
    }

  
    public String getListaDeExames() {
        return listaDeExames;
    }
    
    public void setListaDeExames(String listaDeExames){
        this.listaDeExames = listaDeExames;
    }
    
    public String getData() {
        return data;
        
    }
    
    public void setData(String data){
        this.data=data;
    }

    public String getHistorico() {
        return historico;
    }
    
    public void setHistorico(String historico){
        this.historico=historico;
    }

    public String getCRVM() {
      
        return veterinario.getCrvm();
        
    }
    
    public void setCRVM(Veterinario veterinario){
        this.veterinario=veterinario;
    }
    
    public Animal getIdAnimal(){
        return IdAnimal;
    }

    public Cliente getIdCliente(){
        return IdCliente;
    }
    
    public void setIdCliente(Cliente IdCliente) {
        this.IdCliente = IdCliente;
    }

    public void setIdAnimal(Animal IdAnimal) {
        this.IdAnimal = IdAnimal;
    }


    public Realizada getRealizada() {
        return realizada;
    }

    public void setRealizada(Realizada realizada) {
        this.realizada = realizada;
    }
    
    enum Realizada {
        Finalizada(0),
        NaoAtendida(1),
        Paga(2)
        ;

        static Realizada get(int codigo) {
            for(int v = 0; v < values().length; v++) {
                if (values()[v].codigo == codigo)
                    return values()[v];
            }
            
            return null;
        }
        
        private Integer codigo;
        
        Realizada(Integer codigo) {
            this.codigo = codigo;
        }

        int getCodigo() {
            return codigo;
        }
    }
   
}
