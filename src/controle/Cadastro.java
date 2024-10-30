package controle;

import entidades.Comentario;
import entidades.Filme;
import entidades.Genero;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cadastro {
    
    private Conexao conexao = new Conexao();
    
    //Listar Filmes na tabela
    public List <Filme> ConsultarFilmes() {
        PreparedStatement st;
        ResultSet rs;
        List <Filme> filmes = new ArrayList<>();
        
        try {
            st = conexao.getConexao().prepareStatement("SELECT fm.idFilme, fm.titulo, gn.descricao, fm.ano, fm.diretor, fm.pais FROM filme fm, genero gn WHERE fm.genero = gn.idGenero;");
            rs = st.executeQuery();
            
            while (rs.next()) {
                Filme f = new Filme();
                
                f.setIdFilme(rs.getInt("idFilme"));
                f.setTitulo(rs.getString("titulo"));
                f.setDescGenero(rs.getString("descricao"));
                f.setDiretor(rs.getString("diretor"));
                f.setAno(rs.getString("ano"));
                f.setPais(rs.getString("pais"));
                filmes.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return filmes;
    }
    
    //Listar Gêneros na tabela
    public List <Genero> ConsultarGenero() {
        PreparedStatement st;
        ResultSet rs;
        List <Genero> generos = new ArrayList<>();
        
        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM genero");           
            rs = st.executeQuery();
            
            while (rs.next()) {
                Genero g = new Genero();
                
                g.setIdGenero(rs.getInt("idGenero"));
                g.setGenero(rs.getString("descricao"));
                generos.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return generos;
    }
    
    //Listar Comentários na tabela
    public List <Comentario> ConsultarComentario() {
        PreparedStatement st;
        ResultSet rs;
        List <Comentario> comentarios = new ArrayList<>();
        
        try {
            st = conexao.getConexao().prepareStatement("SELECT cm.idComentario, cm.comentario, cm.nota, cm.usuario, fm.titulo FROM comentario cm, filme fm WHERE cm.filme = fm.idFilme");            
            rs = st.executeQuery();
            
            while (rs.next()) {               
                Comentario co = new Comentario();
                
                co.setIdComentario(rs.getInt("idComentario"));
                co.setTituloFilme(rs.getString("titulo"));
                co.setComentario(rs.getString("comentario"));
                co.setNota(rs.getDouble("nota"));
                co.setUsuario(rs.getString("usuario"));               
                comentarios.add(co);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return comentarios;
    }

    //Salvar Filme no Banco de Dados
    public void salvarFilme(Filme f) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("INSERT INTO filme "
                    + "(titulo, genero, ano, diretor, pais) VALUES (?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);   
            st.setString(i++, f.getTitulo());
            st.setInt(i++, f.getGenero());
            st.setString(i++, f.getAno());
            st.setString(i++, f.getDiretor());
            st.setString(i++, f.getPais());

            st.execute();
            JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!");
            
            rs = st.getGeneratedKeys();

            if (rs.next()) {
                f.setIdFilme(rs.getInt(1));
            }                 
                    
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    //Atualizar Filme no Banco de Dados
    public void atualizarFilme(Filme f) {
        PreparedStatement st;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("UPDATE filme SET "
                    + "titulo = ?, genero = ?, ano = ?, diretor = ?, pais = ? WHERE idFilme = ?");
            st.setString(i++, f.getTitulo());
            st.setObject(i++, f.getGenero());
            st.setString(i++, f.getAno());            
            st.setString(i++, f.getDiretor());
            st.setString(i++, f.getPais()); 
            st.setInt(i++, f.getIdFilme());

            st.execute();              
            JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso!");
                        
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

    //Exclusão do Filme no Banco de Dados
    public void deletarFilme(Filme f) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("DELETE FROM filme WHERE idFilme = ?");
            st.setInt(i++, f.getIdFilme());
            
            st.execute();    
            JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");
                                             
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    //Salvar Gênero no Banco de Dados
    public void salvarGenero(Genero g) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("INSERT INTO genero "
                    + "(descricao) VALUES (?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, g.getGenero());

            st.execute();
            JOptionPane.showMessageDialog(null, "Gênero cadastrado com sucesso!");
            
            rs = st.getGeneratedKeys();

            if (rs.next()) {
                g.setIdGenero(rs.getInt(1));
            }                 
                    
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

    //Atualizar Genero no Banco de Dados
    public void atualizarGenero(Genero g) {
        PreparedStatement st;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("UPDATE genero SET descricao = ? WHERE idGenero = ?");
            st.setString(i++, g.getGenero());
            st.setInt(i++, g.getIdGenero());

            st.executeUpdate();              
            JOptionPane.showMessageDialog(null, "Gênero atualizado com sucesso!");
                        
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }    
    
    //Exclusão do Gênero no Banco de Dados
    public void deletarGenero(Genero g) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("DELETE FROM genero WHERE idGenero = ?");
            st.setInt(i++, g.getIdGenero());
            
            st.execute();    
            JOptionPane.showMessageDialog(null, "Gênero excluído com sucesso!");
                                             
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    //Salvar Comentário no Banco de Dados
    public void salvarComentario(Comentario co) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("INSERT INTO comentario "
                    + "(filme, comentario, nota, usuario) VALUES (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setObject(i++, co.getFilme());
            st.setString(i++, co.getComentario());
            st.setDouble(i++, co.getNota());            
            st.setString(i++, co.getUsuario());

            st.execute();
            JOptionPane.showMessageDialog(null, "Comentário salvo com sucesso!");        
            
            rs = st.getGeneratedKeys();

            if (rs.next()) {
                co.setIdComentario(rs.getInt(1));
            }                 
                    
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    //Atualizar Comentários no Banco de Dados
    public void atualizarComentario(Comentario co) {
        PreparedStatement st;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("UPDATE comentario SET "
                    + "filme = ?, comentario = ?, nota = ?, usuario = ? WHERE idComentario = ?");
            st.setInt(i++, co.getFilme());
            st.setString(i++, co.getComentario());
            st.setDouble(i++, co.getNota());
            st.setString(i++, co.getUsuario());
            st.setInt(i++, co.getIdComentario());

            st.execute();    
            JOptionPane.showMessageDialog(null, "Comentário atualizado com sucesso!");                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    //Exclusão do Comentário no Banco de Dados
    public void deletarComentario(Comentario co) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("DELETE FROM comentario WHERE idComentario = ?");
            st.setInt(i++, co.getIdComentario());
            
            st.execute();    
            JOptionPane.showMessageDialog(null, "Comentário excluído com sucesso!");
                                             
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);            
        }
    } 
}

