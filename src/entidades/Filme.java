package entidades;

public class Filme {
    private String titulo;
    private int genero;    
    private String ano;
    private String diretor;
    private String pais;
    private int idFilme;
    private String descGenero;

    public String getDescGenero() {
        return descGenero;
    }

    public void setDescGenero(String descGenero) {
        this.descGenero = descGenero;
    }
    
    
    public int getIdFilme(){
        return idFilme;
    }
    
    public void setIdFilme(int idFilme){
        this.idFilme = idFilme;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public int getGenero(){
        return genero;
    }
    
    public void setGenero(int genero){
        this.genero = genero;
    }
    
    public String getAno(){
        return ano;
    }
    
    public void setAno(String ano){
        this.ano = ano;
    }
    
    public String getDiretor(){
        return diretor;
    }
    
    public void setDiretor(String diretor){
        this.diretor = diretor;
    }
    
    public String getPais(){
        return pais;
    }
    
    public void setPais(String pais){
        this.pais = pais;
    }

    @Override
    public String toString() {
        return titulo;
    }
    
    
}