/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segta.formularios;

import segta.clases.Usuario;
import segta.controladores.UsuarioJpaController;
import segta.clases.Usuarioperfil;
import segta.controladores.UsuarioperfilJpaController;
import segta.exceptions.NonexistentEntityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import org.jdesktop.beansbinding.BindingGroup;

/**
 *
 * @author Ruso
 */
public class JDialogUsuario extends javax.swing.JDialog {

    /**
     * Creates new form usuarioJDialog
     */
    public JDialogUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        trazabilidadPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SegTAPU").createEntityManager();
        usuarioQuery = java.beans.Beans.isDesignTime() ? null : trazabilidadPUEntityManager.createQuery("SELECT u FROM Usuario u");
        usuarioList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : usuarioQuery.getResultList();
        usuarioQuery1 = java.beans.Beans.isDesignTime() ? null : trazabilidadPUEntityManager.createQuery("SELECT u FROM Usuario u");
        usuarioList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : usuarioQuery1.getResultList();
        usuarioperfilQuery = java.beans.Beans.isDesignTime() ? null : trazabilidadPUEntityManager.createQuery("SELECT u FROM Usuarioperfil u");
        usuarioperfilList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : usuarioperfilQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        usuarioTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        clavePasswordField = new javax.swing.JPasswordField();
        crearButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuarioTable = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        perfilTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        claveButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        agregarPerfilButton = new javax.swing.JButton();
        eliminarPerfilButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ABM de Usuarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Usuario"));

        usuarioTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nombre de usuario:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Clave:");

        crearButton.setText("Crear");
        crearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clavePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(crearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(clavePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(crearButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        usuarioTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        usuarioTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, usuarioList1, usuarioTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idUsuario}"));
        columnBinding.setColumnName("Id Usuario");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        usuarioTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usuarioTableFocusGained(evt);
            }
        });
        usuarioTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioTableMousePressed(evt);
            }
        });
        usuarioTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuarioTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(usuarioTable);
        usuarioTable.getColumnModel().getColumn(0).setMaxWidth(0);
        usuarioTable.getColumnModel().getColumn(0).setMinWidth(0);
        usuarioTable.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        usuarioTable.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        perfilTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Perfil"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        perfilTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perfilTableFocusLost(evt);
            }
        });
        perfilTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                perfilTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(perfilTable);

        claveButton.setText("Cambiar Clave");
        claveButton.setEnabled(false);
        claveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claveButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");
        eliminarButton.setEnabled(false);
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        agregarPerfilButton.setText("Agregar");
        agregarPerfilButton.setEnabled(false);
        agregarPerfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPerfilButtonActionPerformed(evt);
            }
        });

        eliminarPerfilButton.setText("Eliminar");
        eliminarPerfilButton.setEnabled(false);
        eliminarPerfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPerfilButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(claveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(agregarPerfilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarPerfilButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(agregarPerfilButton)
                        .addComponent(eliminarPerfilButton))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(claveButton)
                        .addComponent(eliminarButton)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void actualizarUsuarios() {  
        trazabilidadPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SegTAPU").createEntityManager();
        usuarioQuery = java.beans.Beans.isDesignTime() ? null : trazabilidadPUEntityManager.createQuery("SELECT u FROM Usuario u");
        usuarioList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : usuarioQuery.getResultList();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, usuarioList, usuarioTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idUsuario}"));
        columnBinding.setColumnName("Id Usuario");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(usuarioTable);
        usuarioTable.getColumnModel().getColumn(0).setMaxWidth(0);
        usuarioTable.getColumnModel().getColumn(0).setMinWidth(0);
        usuarioTable.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        usuarioTable.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        this.claveButton.setEnabled(false);
        this.eliminarButton.setEnabled(false);
        this.usuarioTextField.setText(null);
        this.clavePasswordField.setText(null);
        this.usuarioSel=null;
        actualizarPerfiles(usuarioSel);
}

private void actualizarPerfiles(Usuario user){
           
     BindingGroup perfilbindingGroup = new org.jdesktop.beansbinding.BindingGroup();
     trazabilidadPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SegTAPU").createEntityManager();
     Query perfilQuery = java.beans.Beans.isDesignTime() ? null : trazabilidadPUEntityManager.createQuery("SELECT p FROM Usuarioperfil p Where p.idUsuario=:usuario");
     perfilQuery.setParameter("usuario", user);
     List perfilList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : perfilQuery.getResultList();
     org.jdesktop.swingbinding.JTableBinding perfilTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, perfilList, perfilTable);
     org.jdesktop.swingbinding.JTableBinding.ColumnBinding perfilColumnBinding = perfilTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idUsuarioPerfil}"));
     perfilColumnBinding.setColumnName("idUsuarioPerfil");
     perfilColumnBinding.setColumnClass(Integer.class);
     perfilColumnBinding = perfilTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${perfil}"));
     perfilColumnBinding.setColumnName("Perfil");
     perfilColumnBinding.setColumnClass(String.class);
     perfilbindingGroup.addBinding(perfilTableBinding);
     perfilTableBinding.bind();
     //perfilbindingGroup.bind();
     jScrollPane2.setViewportView(perfilTable);
     perfilTable.getColumnModel().getColumn(0).setMaxWidth(0);
     perfilTable.getColumnModel().getColumn(0).setMinWidth(0);
     perfilTable.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
     perfilTable.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
     this.agregarPerfilButton.setEnabled(false);
     this.eliminarPerfilButton.setEnabled(false);
     perfilSel=null;
    
}
    private void crearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearButtonActionPerformed
        // TODO add your handling code here:
        String nombre=this.usuarioTextField.getText();
        String clave=this.clavePasswordField.getText();
        
        if (nombre.isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese nombre de usuario","Validación",JOptionPane.WARNING_MESSAGE);
            this.usuarioTextField.requestFocus();
        }else if(clave.isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese una contraseña","Validación",JOptionPane.WARNING_MESSAGE);
            this.clavePasswordField.requestFocus();
        }else{
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("SegTAPU");
            UsuarioJpaController controlador= new UsuarioJpaController(emf);
            try {
                if (controlador.usuarioExiste(nombre)){
                    JOptionPane.showMessageDialog(null,"El nombre de usuario ya existe","Validación",JOptionPane.WARNING_MESSAGE);
                    this.usuarioTextField.requestFocus();
                }else{
                    String claveMD5=controlador.claveMD5(clave);
                    Usuario u = new Usuario();
                    u.setNombre(nombre);
                    u.setClave(claveMD5);
                    try {
                       controlador.create(u);
                       JOptionPane.showMessageDialog(null,"Usuario creado con éxito","Información",JOptionPane.INFORMATION_MESSAGE);
                       actualizarUsuarios();
                    } catch (Exception ex) {
                       Logger.getLogger(JDialogUsuario.class.getName()).log(Level.SEVERE, null, ex);
                       JOptionPane.showMessageDialog(null,"Error al crear el usuario","Información",JOptionPane.ERROR_MESSAGE);
                    }
                   
                    
                }
                             
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(JDialogUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(JDialogUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
      
          
        }
                
      
    }//GEN-LAST:event_crearButtonActionPerformed

   
    private int cambiaClave() throws NoSuchAlgorithmException {

        int resultado=0;
        JPasswordField claveAnterior = new JPasswordField();
        JPasswordField claveNueva = new JPasswordField();
        final JPasswordField claveNueva2 = new JPasswordField();

        Object[] inputFields = {"Clave actual", claveAnterior,
                                "Nueva clave", claveNueva,
                                "Repita nueva clave", claveNueva2};

        int option = JOptionPane.showConfirmDialog(this, inputFields, "Cambio de clave", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String anterior = claveAnterior.getText();
            String nueva = claveNueva.getText();
            String nueva2 = claveNueva2.getText();
            
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("SegTAPU");
            UsuarioJpaController controlador= new UsuarioJpaController(emf);
            
            String anteriorMd5 = controlador.claveMD5(anterior);
            String nuevaMd5 = controlador.claveMD5(nueva);
            
                      
            
            if (!anteriorMd5.equals(usuarioSel.getClave())){
                resultado= 1;
            }else if (!nueva.equals(nueva2)){
                resultado= 2;
            }else{
                usuarioSel.setClave(nuevaMd5);
                try {
                    controlador.edit(usuarioSel);
                    resultado=3;

                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(JDialogUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    resultado=4;
                } catch (Exception ex) {
                    Logger.getLogger(JDialogUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    resultado=4;
                }
                
            }
            
            
        }
        return resultado;
    }
   private void clave() throws NoSuchAlgorithmException{
        int resultado=cambiaClave();
        switch (resultado) {
            case 1:
                JOptionPane.showMessageDialog(null,"La clave actual es incorrecta","Información",JOptionPane.ERROR_MESSAGE);
                clave();
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"Las nuevas claves no coinciden","Información",JOptionPane.ERROR_MESSAGE);
                clave();
                break;
            case 3:
                JOptionPane.showMessageDialog(null,"Clave cambiada con éxito","Información",JOptionPane.INFORMATION_MESSAGE);
                break;
            case 4:
                JOptionPane.showMessageDialog(null,"Error al cambiar la clave","Información",JOptionPane.ERROR_MESSAGE);
                break;
            default:
                break;
        }
       
   }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eliminarPerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPerfilButtonActionPerformed

        int opcion = JOptionPane.showConfirmDialog(rootPane, "Desea borrar el perfil "+perfilSel.getPerfil()+" para el usuario "+ usuarioSel.getNombre()+"?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (opcion==0){
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("SegTAPU");
            UsuarioperfilJpaController controladorperfil= new UsuarioperfilJpaController(emf);
            try {
                controladorperfil.destroy(perfilSel.getIdUsuarioPerfil());
                this.actualizarPerfiles(usuarioSel);
            } catch (Exception ex) {
                Logger.getLogger(JDialogUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Error al eliminar el perfil","Información",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_eliminarPerfilButtonActionPerformed

    private void agregarPerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPerfilButtonActionPerformed
        try {
            perfil();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(JDialogUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_agregarPerfilButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null,"Desea borrar el usuario "+ usuarioSel.getNombre()+"?","Eliminar",JOptionPane.WARNING_MESSAGE);
        int opcion = JOptionPane.showConfirmDialog(rootPane, "Desea borrar el usuario "+ usuarioSel.getNombre()+"?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (opcion==0){
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("SegTAPU");
            UsuarioJpaController controlador= new UsuarioJpaController(emf);
            UsuarioperfilJpaController controladorperfil= new UsuarioperfilJpaController(emf);
            try {
                Collection<Usuarioperfil> usuarioperfilCollection = usuarioSel.getUsuarioperfilCollection();
                Iterator<Usuarioperfil> iterator = usuarioperfilCollection.iterator();
                while(iterator.hasNext()) {
                    controladorperfil.destroy(iterator.next().getIdUsuarioPerfil());
                }
                controlador.destroy(usuarioSel.getIdUsuario());
                this.actualizarUsuarios();
            } catch (Exception ex) {
                Logger.getLogger(JDialogUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Error al eliminar el usuario","Información",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void claveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claveButtonActionPerformed
        try {
            clave();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(JDialogUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_claveButtonActionPerformed

    private void perfilTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfilTableMousePressed
        // TODO add your handling code here:
        int id = (int) perfilTable.getValueAt(perfilTable.getSelectedRow(), 0);
        if (id>0){
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("SegTAPU");
            UsuarioperfilJpaController controlador= new UsuarioperfilJpaController(emf);
            perfilSel = controlador.findUsuarioperfil(id);
            this.eliminarPerfilButton.setEnabled(true);

        }
    }//GEN-LAST:event_perfilTableMousePressed

    private void perfilTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_perfilTableFocusLost

    }//GEN-LAST:event_perfilTableFocusLost

    private void usuarioTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioTableKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_usuarioTableKeyPressed

    private void usuarioTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioTableMousePressed

        int id = (int) usuarioTable.getValueAt(usuarioTable.getSelectedRow(), 0);
        if (id>0){
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("SegTAPU");
            UsuarioJpaController controlador= new UsuarioJpaController(emf);
            usuarioSel = controlador.findUsuario(id);
            actualizarPerfiles(usuarioSel);
            this.eliminarButton.setEnabled(true);
            this.claveButton.setEnabled(true);
            this.agregarPerfilButton.setEnabled(true);
        }

    }//GEN-LAST:event_usuarioTableMousePressed

    private void usuarioTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioTableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_usuarioTableMouseClicked

    private void usuarioTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuarioTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTableFocusGained

    private int nuevoPerfil() throws NoSuchAlgorithmException{
         // TODO add your handling code here:
        int resultado=0;
        String[] perfiles = { "Administrador", "Descargas","Devoluciones", "Laboratorio", "Contratos","Listados","Tambores","Lotes","Configuración","Apicultores","Clientes" };
        String nuevoPerfil = null;
        nuevoPerfil=  (String) JOptionPane.showInputDialog(null,"Seleccione perfil para el usuario "+usuarioSel.getNombre(),"Perfiles",JOptionPane.QUESTION_MESSAGE,null,perfiles,perfiles[0]);
               
        if (nuevoPerfil!=null){
           EntityManagerFactory emf=Persistence.createEntityManagerFactory("SegTAPU");
           UsuarioJpaController controlador= new UsuarioJpaController(emf);
          
           if (controlador.tienePerfil(usuarioSel, nuevoPerfil)){
                resultado=1;
           }else{
                try{
                    UsuarioperfilJpaController controladorperfil= new UsuarioperfilJpaController(emf);
                    Usuarioperfil perfil = new Usuarioperfil();
                    perfil.setIdUsuario(usuarioSel);
                    perfil.setPerfil(nuevoPerfil);
                    controladorperfil.create(perfil);
                    actualizarPerfiles(usuarioSel);
                    this.agregarPerfilButton.setEnabled(true);
                    resultado=2;
                }catch (Exception e) {
                    resultado=3;     
                }
           }
        }
        return resultado;
    }
    
    private void perfil() throws NoSuchAlgorithmException{
        int resultado= nuevoPerfil();
       switch (resultado) {
            case 1:
                JOptionPane.showMessageDialog(null,"El perfil ya está asociado al usuario","Información",JOptionPane.ERROR_MESSAGE);
                perfil();
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"Perfil agregado con éxito","Información",JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null,"Error al agregar el perfil","Información",JOptionPane.ERROR_MESSAGE);
                break;
            default:
                break;
        }
    }
    
    private Usuario usuarioSel;
    private Usuarioperfil perfilSel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarPerfilButton;
    private javax.swing.JButton claveButton;
    private javax.swing.JPasswordField clavePasswordField;
    private javax.swing.JButton crearButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JButton eliminarPerfilButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable perfilTable;
    private javax.persistence.EntityManager trazabilidadPUEntityManager;
    private java.util.List<segta.clases.Usuario> usuarioList;
    private java.util.List<segta.clases.Usuario> usuarioList1;
    private javax.persistence.Query usuarioQuery;
    private javax.persistence.Query usuarioQuery1;
    private javax.swing.JTable usuarioTable;
    private javax.swing.JTextField usuarioTextField;
    private java.util.List<segta.clases.Usuarioperfil> usuarioperfilList;
    private javax.persistence.Query usuarioperfilQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
