package janelas;

import controle.Cadastro;
import controle.Conexao;
import entidades.Filme;
import entidades.Genero;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadastroFilme extends javax.swing.JFrame {

    Conexao conexao = new Conexao();
    PreparedStatement st = null;
    ResultSet rs = null;
    
    private LinkedList<Genero> listGenero = new LinkedList<>();

    public CadastroFilme() {
        initComponents(); 
        carregarComboGenero();
        readJtable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        comboGenero = new javax.swing.JComboBox();
        txtAno = new javax.swing.JTextField();
        txtDiretor = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jFilmes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Cadastro");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Filme");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel2.setText("Título:");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel3.setText("Gênero:");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel4.setText("Ano:");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel5.setText("Diretor:");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel6.setText("País:");

        txtTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N

        comboGenero.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        comboGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboGeneroItemStateChanged(evt);
            }
        });

        txtAno.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N

        txtDiretor.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N

        txtPais.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiretor))
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPais)
                    .addComponent(comboGenero, 0, 212, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btCadastrar.setBackground(new java.awt.Color(204, 204, 204));
        btCadastrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        btCadastrar.setText("CADASTRAR");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAlterar.setBackground(new java.awt.Color(204, 204, 204));
        btAlterar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        btAlterar.setText("ALTERAR");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setBackground(new java.awt.Color(204, 204, 204));
        btExcluir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        btExcluir.setText("EXCLUIR");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jFilmes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        jFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Gênero", "Ano", "Diretor", "País"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jFilmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFilmesMouseClicked(evt);
            }
        });
        jFilmes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFilmesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jFilmes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        Filme f = new Filme();
        Cadastro c = new Cadastro();
        
        Genero genero = (Genero)comboGenero.getSelectedItem();

        f.setTitulo(txtTitulo.getText());
        f.setGenero(genero.getIdGenero());
        f.setAno(txtAno.getText());
        f.setDiretor(txtDiretor.getText());
        f.setPais(txtPais.getText());

        c.salvarFilme(f);
        readJtable();

        txtTitulo.setText("");
        comboGenero.setSelectedItem("");
        txtAno.setText("");
        txtDiretor.setText("");
        txtPais.setText("");
        carregarComboGenero();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (jFilmes.getSelectedRow() != -1) {
            
            Filme f = new Filme();
            Cadastro c = new Cadastro();

            f.setIdFilme((int)jFilmes.getValueAt(jFilmes.getSelectedRow(), 0));

            c.deletarFilme(f);        
            readJtable();

            txtTitulo.setText("");
            comboGenero.setSelectedItem("");
            txtAno.setText("");
            txtDiretor.setText("");
            txtPais.setText("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um filme para excluir.");
        }        
    }//GEN-LAST:event_btExcluirActionPerformed

    private void jFilmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFilmesMouseClicked
        if (jFilmes.getSelectedRow() != -1) {

            txtTitulo.setText(jFilmes.getValueAt(jFilmes.getSelectedRow(), 1).toString());
            comboGenero.setSelectedItem(jFilmes.getValueAt(jFilmes.getSelectedRow(), 2).toString());
            txtAno.setText(jFilmes.getValueAt(jFilmes.getSelectedRow(), 3).toString());
            txtDiretor.setText(jFilmes.getValueAt(jFilmes.getSelectedRow(), 4).toString());
            txtPais.setText(jFilmes.getValueAt(jFilmes.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jFilmesMouseClicked

    private void jFilmesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFilmesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jFilmesKeyReleased

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (jFilmes.getSelectedRow() != -1) {
            
            Filme f = new Filme();
            Cadastro c = new Cadastro();
            Genero genero = (Genero) comboGenero.getSelectedItem();

            f.setTitulo(txtTitulo.getText());            
            f.setGenero(genero.getIdGenero());
            f.setAno(txtAno.getText());
            f.setDiretor(txtDiretor.getText());
            f.setPais(txtPais.getText());
            f.setIdFilme((int)jFilmes.getValueAt(jFilmes.getSelectedRow(), 0));

            c.atualizarFilme(f);
            readJtable();

            txtTitulo.setText("");
            comboGenero.setSelectedItem("");
            txtAno.setText("");
            txtDiretor.setText("");
            txtPais.setText("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um filme para atualizar.");
        }     
    }//GEN-LAST:event_btAlterarActionPerformed

    private void comboGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboGeneroItemStateChanged
        // TODO add your handling code here:
        
        //Colocar aqui para pegar a selecao do objeto
        
    }//GEN-LAST:event_comboGeneroItemStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFilme().setVisible(true);
            }
        });
    }

    private void carregarComboGenero() {
    
        List list = new LinkedList<>();
        Genero gen = null;
        
        String sql = "SELECT * FROM genero";

        try {
            st = conexao.getConexao().prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                gen = new Genero();
                gen.setIdGenero(rs.getInt("idGenero"));
                gen.setGenero(rs.getString("descricao"));
                list.add(gen);
            }
            listGenero.addAll(list);
            comboGenero.setModel(new DefaultComboBoxModel(listGenero.toArray()));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void readJtable() {
        DefaultTableModel modelo = (DefaultTableModel) jFilmes.getModel();
        modelo.setNumRows(0);
        Cadastro c = new Cadastro();

        for (Filme f : c.ConsultarFilmes()) {
            modelo.addRow(new Object[]{
                f.getIdFilme(),
                f.getTitulo(),
                f.getDescGenero(),
                f.getAno(),
                f.getDiretor(),
                f.getPais(),});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JComboBox comboGenero;
    private javax.swing.JTable jFilmes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtDiretor;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
