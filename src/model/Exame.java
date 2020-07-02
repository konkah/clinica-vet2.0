package model;

/**
 *
 * @author Plinio Vilela
 */
public class Exame {
    private Integer id;
    private String descricao;
    private Consulta consulta;

    public Exame(Integer id, String descricao, Consulta consulta) {
        this.id = id;
        this.descricao = descricao;
        this.consulta = consulta;
    }

    public Integer getId() {
        return id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public Consulta getConsulta() {
        return consulta;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
}
