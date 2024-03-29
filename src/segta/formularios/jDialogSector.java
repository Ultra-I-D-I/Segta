/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segta.formularios;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import segta.clases.Sector;
import segta.controladores.SectorJpaController;



/**
 *
 * @author MODERNIZACION3
 */
public class jDialogSector extends javax.swing.JDialog {

    /**
     * Creates new form jDialogDescargas
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SegTAPU");
    EntityManager em = emf.createEntityManager();
    SectorJpaController controlador = new SectorJpaController(emf);
    String tipo; //identifica si hay que agregar o editar
    Sector sec; //objeto seleccionado de la tabla
    

    public jDialogSector(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desactivaCampos();

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

        SegTAPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SegTAPU").createEntityManager();
        sectorQuery = java.beans.Beans.isDesignTime() ? null : SegTAPUEntityManager.createQuery("SELECT s FROM Sector s ORDER BY s.nombre ASC");
        sectorList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(sectorQuery.getResultList());
        jPanel1 = new javax.swing.JPanel();
        jPanelDatos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jBAceptar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jPanelTabla = new javax.swing.JPanel();
        jBAgregar = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jDialogDescargasFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SECTORES");
        setMaximumSize(new java.awt.Dimension(550, 790));
        setMinimumSize(new java.awt.Dimension(550, 790));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL GRUPO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("GRUPO");

        jTextNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jBAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/aceptar.png"))); // NOI18N
        jBAceptar.setText("ACEPTAR");
        jBAceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/cancerlar.png"))); // NOI18N
        jBCancelar.setText("CANCELAR");
        jBCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextNombre))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GRUPOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jBAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/add icono.png"))); // NOI18N
        jBAgregar.setText("AGREGAR");
        jBAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/editar.png"))); // NOI18N
        jBEditar.setText("EDITAR");
        jBEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sectorList, jTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTablaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addGroup(jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 480, 630));

        jDialogDescargasFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/fondo dialog.png"))); // NOI18N
        jDialogDescargasFondo.setMaximumSize(new java.awt.Dimension(550, 790));
        jDialogDescargasFondo.setMinimumSize(new java.awt.Dimension(550, 790));
        jDialogDescargasFondo.setPreferredSize(new java.awt.Dimension(550, 790));
        getContentPane().add(jDialogDescargasFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -60, 550, 850));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        tipo="nuevo";
        desactivaTabla();
        limpiaCampos();
        activaCampos();
        this.jTextNombre.requestFocus();
      
     
    }//GEN-LAST:event_jBAgregarActionPerformed


    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        
        if (this.jTable.getSelectedRowCount()==1){
     
          seleccionaSector();
          desactivaTabla();
          activaCampos();
          tipo="edit";

        }else{
             JOptionPane.showMessageDialog(null,"Debe seleccionar un Grupo","Validación",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
        int flagValidacion=0;
        String nom=this.jTextNombre.getText();
 
        //Razon social no null
        if (nom.isEmpty()){
            flagValidacion=1;
            JOptionPane.showMessageDialog(null,"Ingrese un nombre","Validación",JOptionPane.WARNING_MESSAGE);
            this.jTextNombre.requestFocus();
        }

        
        
        if (flagValidacion==0){
            
            if (tipo.equals("nuevo")){
                Sector nuevoSec = new Sector();
                nuevoSec.setNombre(nom);
             

                try {
                
                    controlador.create(nuevoSec);
                    JOptionPane.showMessageDialog(null,"Grupo creado con éxito","Información",JOptionPane.INFORMATION_MESSAGE);
                    limpiaCampos();
                       
                } catch (Exception ex) {
                    Logger.getLogger(jDialogSector.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"Error al crear el Grupo","Información",JOptionPane.ERROR_MESSAGE);
                }
            
            }else{
                sec.setNombre(nom);
              
                try {
                
                    controlador.edit(sec);
                    JOptionPane.showMessageDialog(null,"Grupo editado con éxito","Información",JOptionPane.INFORMATION_MESSAGE);
                    limpiaCampos();
                       
                } catch (Exception ex) {
                    Logger.getLogger(jDialogSector.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"Error al editar el Grupo","Información",JOptionPane.ERROR_MESSAGE);
                }
                
            }
  
            
            limpiaCampos();
            desactivaCampos();
            activaTabla();
            actualizaTabla();
             
        }
        
    }//GEN-LAST:event_jBAceptarActionPerformed
    //boton cancelar
    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        limpiaCampos();
        desactivaCampos();
        activaTabla();
        
    }//GEN-LAST:event_jBCancelarActionPerformed
    //Convierte la fila seleccionada en objeto cliente
    @SuppressWarnings("empty-statement")
    private void seleccionaSector(){
        if (this.jTable.getSelectedRowCount()==1){
            sec = sectorList.get(jTable.getSelectedRow());
            this.jTextNombre.setText(sec.getNombre());
                      
        }
    }
    //Limpia los textFields
    private void limpiaCampos(){
         this.jTextNombre.setText("");
      
        
    }
    //desactiva los textfields y botones de aceptar y cancelar
    private void desactivaCampos() {
        for (Component component : jPanelDatos.getComponents()) {
            component.setEnabled(false); 
        }

    }
    //activa los textfields y botones de aceptar y cancelar
    private void activaCampos() {
        for (Component component : jPanelDatos.getComponents()) {
            component.setEnabled(true); 
        }

    }
    
    
      //desactiva botones de agregar y editar y tabla 
     private void desactivaTabla() {
        for (Component component : jPanelTabla.getComponents()) {
            component.setEnabled(false); 
        }
        this.jTable.setEnabled(false);

    }
     //activa botones de agregar y editar y tabla 
    private void activaTabla() {
        for (Component component : jPanelTabla.getComponents()) {
            component.setEnabled(true); 
        }
        this.jTable.setEnabled(true);

    }
    private void actualizaTabla(){
        sectorList.clear();
        sectorList.addAll(sectorQuery.getResultList());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager SegTAPUEntityManager;
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JLabel jDialogDescargasFondo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextNombre;
    private java.util.List<segta.clases.Sector> sectorList;
    private javax.persistence.Query sectorQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
