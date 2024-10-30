package entidades;

public class Comentario {
    private int filme; 
    private String comentario;
    private Double nota;
    private String usuario;
    private int idComentario;
    private String tituloFilme;

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }
    
    public int getIdComentario(){
        return idComentario;
    }
    
    public void setIdComentario(int idComentario){
        this.idComentario = idComentario;
    }
    
    public int getFilme(){
        return filme;
    }
    
    public void setFilme (int filme){
        this.filme = filme;
    }
    
    public String getComentario(){
        return comentario;
    }
    
    public void setComentario(String comentario){
        this.comentario = comentario;
    }
    
    public Double getNota(){
        return nota;
    }
    
    public void setNota(Double nota){
        this.nota = nota;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return comentario;
    }
    
    
}