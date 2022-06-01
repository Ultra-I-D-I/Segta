/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segta.formularios;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import segta.clases.Lote;
import segta.clases.Sector;
import segta.clases.Tambor;
import segta.controladores.ClienteJpaController;
import segta.controladores.LoteJpaController;
import segta.controladores.TamborJpaController;
import static segta.formularios.inicio.cambioSector;

/**
 *
 * @author MODERNIZACION3
 */
public class jDialogSelecionarTambor extends javax.swing.JDialog {

    /**
     * Creates new form JDialogLotes
     */
    /**
     * Centra Componente en la pantalla
     */
    public static void centerComponent(Component c) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = c.getSize();
        
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        c.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }

//    CREO LA CONEXION Y LOS CONTROLADORES
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SegTAPU");
    EntityManager em = emf.createEntityManager();
    TamborJpaController controladorT = new TamborJpaController(emf);
    ClienteJpaController controladorC = new ClienteJpaController(emf);
    LoteJpaController controladorL = new LoteJpaController(emf);
    Lote lote;
    Lote loteN;
    
    public jDialogSelecionarTambor(javax.swing.JDialog parent, boolean modal, Lote lo) {
        super(parent, modal);
        lote = lo;
        initComponents();
        centerComponent(this);

//CENTRA LOS DATOS DE LA TABLA
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jTableLote.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jTableLote.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jTableLote.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jTableLote.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jTableClasificado.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jTableClasificado.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jTableClasificado.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jTableClasificado.getColumnModel().getColumn(3).setCellRenderer(tcr);

//COMPLETA EL PANEL CON LOS DATOS DEL LOTE
//        Cliente clienteLote = controladorC.findCliente(lote);
        jTFNumeroLote.setText(lote.getLote());
        jTFNetoLote.setText(NetoLote());
////        jTFColor.setText(lote.getIdLoteContrato().getColor());
//        this.jCheckBox.setSelected(lote.getIdLoteContrato().getIdContrato().getTamborNuevo());
//        this.jCheckBoxHomo.setSelected(lote.getIdLoteContrato().getIdContrato().getHomogeneizada());

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
        tamborQueryClasificado = java.beans.Beans.isDesignTime() ? null : SegTAPUEntityManager.createQuery("SELECT t FROM Tambor t WHERE t.estado = 'clasificado'");
        tamborListClasificado = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() :org.jdesktop.observablecollections.ObservableCollections.observableList(tamborQueryClasificado.getResultList());
        tamborQueryLote = java.beans.Beans.isDesignTime() ? null : SegTAPUEntityManager.createQuery("SELECT t FROM Tambor t WHERE t.idLote = :pLote").setParameter("pLote", lote);
        tamborListLote = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() :org.jdesktop.observablecollections.ObservableCollections.observableList(tamborQueryLote.getResultList());
        sectorQuery = java.beans.Beans.isDesignTime() ? null : SegTAPUEntityManager.createQuery("SELECT s FROM Sector s ORDER BY s.nombre");
        sectorList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : sectorQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFNumeroLote = new javax.swing.JTextField();
        jTFColor = new javax.swing.JTextField();
        jCheckBox = new javax.swing.JCheckBox();
        jCheckBoxHomo = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jTFNetoLote = new javax.swing.JTextField();
        jBVolver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableClasificado = new javax.swing.JTable();
        jComboBoxSec = new javax.swing.JComboBox<>();
        jTamborBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableLote = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jButtonQuitar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        Sector s = new Sector();
        s.setNombre("Todos");
        sectorList.add(0,s);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AGREGAR TAMBORES AL LOTE");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("COLOR");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("NUMERO DE LOTE");

        jTFNumeroLote.setEditable(false);
        jTFNumeroLote.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTFColor.setEditable(false);
        jTFColor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jCheckBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox.setText("TAMBOR NUEVO");
        jCheckBox.setEnabled(false);

        jCheckBoxHomo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBoxHomo.setText("HOMOGENEIZADA");
        jCheckBoxHomo.setEnabled(false);

        jLabel6.setText("NETO DEL LOTE");

        jTFNetoLote.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFColor, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxHomo)
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNetoLote, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFColor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox)
                    .addComponent(jCheckBoxHomo)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNetoLote, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jBVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/volver icono.png"))); // NOI18N
        jBVolver.setText("VOLVER");
        jBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tambores Clasificados"));

        jTableClasificado.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tamborListClasificado, jTableClasificado);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numero}"));
        columnBinding.setColumnName("Numero");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${neto}"));
        columnBinding.setColumnName("Neto");
        columnBinding.setColumnClass(Float.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idColor.color}"));
        columnBinding.setColumnName("Color");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idSector.nombre}"));
        columnBinding.setColumnName("Grupo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estadoTambor}"));
        columnBinding.setColumnName("Tambor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${humedad}"));
        columnBinding.setColumnName("Humedad");
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProveedor.razonSocial}"));
        columnBinding.setColumnName("Apicultor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(jTableClasificado);

        jComboBoxSec.addItem("Sin asignar");
        jComboBoxSec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sectorList, jComboBoxSec);
        bindingGroup.addBinding(jComboBoxBinding);

        jTamborBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/buscar icono.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nro. Tambor");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Grupo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTamborBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSec, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(676, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTamborBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tambores del Lote"));

        jTableLote.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tamborListLote, jTableLote);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numero}"));
        columnBinding.setColumnName("Numero");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${neto}"));
        columnBinding.setColumnName("Neto");
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idColor.color}"));
        columnBinding.setColumnName("Color");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estadoTambor}"));
        columnBinding.setColumnName("Tambor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${humedad}"));
        columnBinding.setColumnName("Humedad");
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProveedor.razonSocial}"));
        columnBinding.setColumnName("Apicultor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(jTableLote);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/clasificar icono.png"))); // NOI18N
        jButtonAgregar.setText("AGREGAR");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonQuitar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/desclasificar icono.png"))); // NOI18N
        jButtonQuitar.setText("QUITAR");
        jButtonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonQuitar)
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonQuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 1230, 660));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segta/imagenes/fondo dialog.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverActionPerformed
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jBVolverActionPerformed
    public String NetoLote() {
        float netoLotef = 0;        
        loteN = controladorL.findLote(lote.getIdLote());;
        for (Tambor t : this.loteN.getTamborCollection()) {
            netoLotef = netoLotef + t.getNeto();
        }
        String netoLote = Float.toString(netoLotef);
        return netoLote;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Query ql;
        int numero = 0;
        boolean haynumero = false;
        String queryTxt = "SELECT t FROM Tambor t WHERE t.estado = 'clasificado'";
        Sector secSel = sectorList.get(jComboBoxSec.getSelectedIndex());
        
        if (!jTamborBuscar.getText().isEmpty()) {
            try {
                numero = Integer.parseInt(jTamborBuscar.getText());
                haynumero = true;
                
            } catch (Exception e) {
                haynumero = false;
            }
        }
        
        if (haynumero) {
            queryTxt = queryTxt + " AND t.numero like " + numero + "";
        }
        
        if (!secSel.getNombre().equals("Todos")) {
            queryTxt = queryTxt + " AND t.idSector=:pSector ";
        }
        
        queryTxt = queryTxt + " ORDER BY t.numero";
        
        ql = em.createQuery(queryTxt);
        
        if (!secSel.getNombre().equals("Todos")) {
            ql.setParameter("pSector", secSel);
        }
        
        tamborQueryClasificado = java.beans.Beans.isDesignTime() ? null : ql;
        tamborListClasificado.clear();
        tamborListClasificado.addAll(tamborQueryClasificado.getResultList());
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        
        if (this.jTableClasificado.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tambor");
            jTableClasificado.requestFocus();
            
        } else {
            
            for (int i = 0; i < jTableClasificado.getRowCount(); i++) {
                
                if (jTableClasificado.isRowSelected(i)) {
                    
                    Tambor tamborSel = (Tambor) tamborListClasificado.get(i);
                    
                    tamborSel.setEstado("loteado");
                    tamborSel.setIdLote(lote);
                    
                    try {
                        controladorT.edit(tamborSel);
                    } catch (Exception ex) {
                        Logger.getLogger(jDialogSelecionarTambor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            NetoLote();
            jTFNetoLote.setText(NetoLote());
            tamborListClasificado.clear();
            tamborListClasificado.addAll(tamborQueryClasificado.getResultList());
            tamborListLote.clear();
            tamborListLote.addAll(tamborQueryLote.getResultList());
            //tamborListLote.add(tamborSel);
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarActionPerformed
        
        if (this.jTableLote.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tambor");
            jTableLote.requestFocus();
            
        } else {
            
            for (int i = 0; i < jTableLote.getRowCount(); i++) {
                
                if (jTableLote.isRowSelected(i)) {
                    
                    Tambor tamborSel = (Tambor) tamborListLote.get(i);
                    
                    tamborSel.setEstado("clasificado");
                    tamborSel.setIdLote(null);
                    
                    try {
                        controladorT.edit(tamborSel);
                    } catch (Exception ex) {
                        Logger.getLogger(jDialogSelecionarTambor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            jTFNetoLote.setText(NetoLote().toString());
            tamborListClasificado.clear();
            tamborListClasificado.addAll(tamborQueryClasificado.getResultList());
            tamborListLote.clear();
            tamborListLote.addAll(tamborQueryLote.getResultList());
            //tamborListLote.add(tamborSel);

    }//GEN-LAST:event_jButtonQuitarActionPerformed
    }
    /**
     * @param args the command line arguments
     */
    //    public static void main(String args[]) {
    //        /* Set the Nimbus look and feel */
    //        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //         */
    //        try {
    //            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //                if ("Nimbus".equals(info.getName())) {
    //                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                    break;
    //                }
    //            }
    //        } catch (ClassNotFoundException ex) {
    //            java.util.logging.Logger.getLogger(jDialogSelecionarTambor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (InstantiationException ex) {
    //            java.util.logging.Logger.getLogger(jDialogSelecionarTambor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (IllegalAccessException ex) {
    //            java.util.logging.Logger.getLogger(jDialogSelecionarTambor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //            java.util.logging.Logger.getLogger(jDialogSelecionarTambor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        }
    //        //</editor-fold>
    //        //</editor-fold>
    //        //</editor-fold>
    //        //</editor-fold>
    //
    //        /* Create and display the dialog */
    //        java.awt.EventQueue.invokeLater(new Runnable() {
    //            public void run() {
    //                jDialogSelecionarTambor dialog = new jDialogSelecionarTambor(new javax.swing.JDialog(),Lote lo, true);
    //                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    //                    @Override
    //                    public void windowClosing(java.awt.event.WindowEvent e) {
    //                        System.exit(0);
    //                    }
    //                });
    //                dialog.setVisible(true);
    //            }
    //        });
    //    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager SegTAPUEntityManager;
    private javax.swing.JButton jBVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonQuitar;
    private javax.swing.JCheckBox jCheckBox;
    private javax.swing.JCheckBox jCheckBoxHomo;
    private javax.swing.JComboBox<String> jComboBoxSec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTFColor;
    private javax.swing.JTextField jTFNetoLote;
    private javax.swing.JTextField jTFNumeroLote;
    private javax.swing.JTable jTableClasificado;
    private javax.swing.JTable jTableLote;
    private javax.swing.JTextField jTamborBuscar;
    private java.util.List<segta.clases.Sector> sectorList;
    private javax.persistence.Query sectorQuery;
    private java.util.List<segta.clases.Tambor> tamborListClasificado;
    private java.util.List<segta.clases.Tambor> tamborListLote;
    private javax.persistence.Query tamborQueryClasificado;
    private javax.persistence.Query tamborQueryLote;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
