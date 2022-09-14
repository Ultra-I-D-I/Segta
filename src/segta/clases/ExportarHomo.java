/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segta.clases;

import static java.awt.Color.black;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import segta.controladores.LoteJpaController;
import segta.controladores.TamboreshomoJpaController;
import segta.clases.Tamboreshomo;

/**
 *
 * @author Quales Group
 */
public class ExportarHomo {

    public void ExportarExcel(List lote, List homo, List tamboresLote, List tamboresSobrantes, List tamboresHomo) throws IOException, ParseException {

        Homo ho = new Homo();
        Tamboreshomo tamborH;

        int TotalTambSob = 0;
        int TotalTambCam = 0;
        int TotalTambExp = 0;
        int TotalPurga = 0;
        float TotalNetoL = 0;
        float TotalNetoExp = 0;
        float TotalNetoSo = 0;
        float TotalNetoTotal = 0;
        float TotalDifNeto = 0;
        float TotalPorc = 0;
        DecimalFormat formatoDecimal = new DecimalFormat("#0.0");

        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            String ruta = chooser.getSelectedFile().toString().concat(".xls");

            try {
                File archivoXLS = new File(ruta);

                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
               
                HSSFCellStyle estilo = (HSSFCellStyle) libro.createCellStyle();
                
                HSSFCellStyle estiloBold = (HSSFCellStyle) libro.createCellStyle();
                HSSFFont fuente = (HSSFFont) libro.createFont();

                Sheet hoja = libro.createSheet("Homogenizado");
                hoja.autoSizeColumn(14);
                estilo.setAlignment(CellStyle.ALIGN_CENTER);
                estilo.setBorderLeft(CellStyle.FINE_DOTS);
                estilo.setBorderRight(CellStyle.FINE_DOTS);
                estilo.setBorderBottom(CellStyle.FINE_DOTS);
                estilo.setBorderTop(CellStyle.FINE_DOTS);
                estilo.setWrapText(false);
                
                estiloBold.setAlignment(CellStyle.ALIGN_CENTER);
                estiloBold.setBorderLeft(CellStyle.FINE_DOTS);
                estiloBold.setBorderRight(CellStyle.FINE_DOTS);
                estiloBold.setBorderBottom(CellStyle.FINE_DOTS);
                estiloBold.setBorderTop(CellStyle.FINE_DOTS);
                estiloBold.setWrapText(true);
                estiloBold.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
                fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                estiloBold.setFont(fuente);

                //CARGO LA HOJA
                hoja.setDisplayGridlines(false);
                Row fila = hoja.createRow(0);
                
                Cell celda = fila.createCell(0);                
                celda.setCellValue("Homogeneizado");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(1);
                celda.setCellValue("Fecha");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(2);
                celda.setCellValue("Lote");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(3);
                celda.setCellValue("Tambores a Camara");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(4);
                celda.setCellValue("Purga");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(5);
                celda.setCellValue("Neto Ingresado");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(6);
                celda.setCellValue("Tambores a Exportar");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(7);
                celda.setCellValue("Neto a Exportar");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(8);
                celda.setCellValue("Tambores Sobrantes");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(9);
                celda.setCellValue("Neto Sobrante");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(10);
                celda.setCellValue("Neto Total");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(11);
                celda.setCellValue("Diferencia de kg");
                celda.setCellStyle(estiloBold);
                celda = fila.createCell(12);
                celda.setCellValue("Porcentaje");
                celda.setCellStyle(estiloBold);

                int filaInicio = 1;

                for (int f = 0; f < homo.size(); f++) {
                    int sobrantes = 0;
                    int purga = 0;
                    float netoL = 0;
                    float netoSo = 0;
                    int tamboresCam = 0;
                    float difNeto = 0;
                    float porc = 0;
                    fila = hoja.createRow(filaInicio);
                    celda.setCellStyle(estilo);
                    filaInicio++;
                    ho = (Homo) homo.get(f);
                    celda = fila.createCell(0);  // IDHOMO
                    celda.setCellStyle(estilo);
                    celda.setCellValue(ho.getIdHomo());

                    celda = fila.createCell(1);  //FECHA
                    String fechaS = null;
                    java.util.Date fechad = ho.getFecha();
                    DateFormat d = new SimpleDateFormat("dd/MM/yy");
                    try {
                        fechaS = d.format(fechad);
                    } catch (Exception ex) {
                        Logger.getLogger(ExportarHomo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    celda.setCellValue(fechaS);
                    celda.setCellStyle(estilo);

                    celda = fila.createCell(2);  // LOTE
                    celda.setCellStyle(estilo);
                    celda.setCellValue(ho.getIdLote());

                    celda = fila.createCell(3);  // TAMBORES A CAMARA
                    celda.setCellStyle(estilo);
                    for (int i = 0; i < lote.size(); i++) {
                        Lote l = (Lote) lote.get(i);
                        if (l.getLote().equals(ho.getIdLote())) {
                            tamboresCam = l.getTamborCollection().size();

                        }
                    }
                    celda.setCellValue(tamboresCam);

                    celda = fila.createCell(4);   // SOBRANTES
                    celda.setCellStyle(estilo);
                    for (int i = 0; i < tamboresSobrantes.size(); i++) {
                        Tamboreshomo t = (Tamboreshomo) tamboresSobrantes.get(i);
                        if (t.getIdHomoNuevo().getIdLote().equals(ho.getIdLote())) {
                            purga = purga + 1;
                        }
                    }

                    celda.setCellValue(purga);

                    celda = fila.createCell(5);    // NETO LOTE INGRESADO
                    celda.setCellStyle(estilo);
                    for (int i = 0; i < lote.size(); i++) {
                        Lote l = (Lote) lote.get(i);
                        if (l.getLote().equals(ho.getIdLote())) {
                            netoL = l.getNetoLote();

                        }
                    }
                    celda.setCellValue(formatoDecimal.format(netoL));

                    celda = fila.createCell(6);    // TAMBORES A EXPORTAR
                    celda.setCellStyle(estilo);
                    celda.setCellValue(ho.getTambores());

                    celda = fila.createCell(7);    // NETO A EXPORTAR
                    celda.setCellStyle(estilo);
                    celda.setCellValue(formatoDecimal.format(ho.getNetoLoteHomo()));

                    celda = fila.createCell(8);    // TAMBORES SOBRANTES
                    celda.setCellStyle(estilo);
                    for (int i = 0; i < tamboresSobrantes.size(); i++) {
                        Tamboreshomo t = (Tamboreshomo) tamboresSobrantes.get(i);
                        if (t.getIdHomoNuevo().getIdLote().equals(ho.getIdLote())) {
                            sobrantes = sobrantes + 1;
                        }
                    }

                    celda.setCellValue(sobrantes);

                    celda = fila.createCell(9);    // NETO SOBRANTE
                    celda.setCellStyle(estilo);
                    for (int i = 0; i < tamboresSobrantes.size(); i++) {
                        Tamboreshomo t = (Tamboreshomo) tamboresSobrantes.get(i);
                        if (t.getIdHomoNuevo().getIdLote().equals(ho.getIdLote())) {
                            netoSo = netoSo + t.getNeto();
                        }
                    }
//                   
                    if (netoSo == 0) {
                        celda.setCellValue("");
                    } else {

                        celda.setCellValue(formatoDecimal.format(netoSo));
                    }

                    celda = fila.createCell(10);    // NETO TOTAL
                    celda.setCellStyle(estilo);
                    float netoTotal = netoSo - ho.getNetoLoteHomo();
                    celda.setCellValue(formatoDecimal.format(netoTotal));

                    celda = fila.createCell(11);    // DIFERENCIA DE KG
                    celda.setCellStyle(estilo);
                    if (netoL == 0) {
                        difNeto = - ho.getNetoLoteHomo();
                    } else {
                        difNeto = netoL - ho.getNetoLoteHomo();
                    }
                    celda.setCellValue(formatoDecimal.format(difNeto));

                    celda = fila.createCell(12);    // PORCENTAJE DE DIFERENCIA
                    celda.setCellStyle(estilo);
                    porc = netoTotal / netoL * 100 - 100;
                    celda.setCellValue(formatoDecimal.format(porc));

                    //COMPLETO LOS TOTALES GENERALES
                    TotalTambSob = TotalTambSob + sobrantes;
                    TotalTambCam = TotalTambCam + tamboresCam;
                    TotalPurga = TotalPurga + purga;
                    TotalNetoL = TotalNetoL + netoL;
                    TotalTambExp = TotalTambExp + ho.getTambores();
                    TotalNetoExp = TotalNetoExp + ho.getNetoLoteHomo();
                    TotalNetoSo = TotalNetoSo + netoSo;
                    TotalNetoTotal = TotalNetoTotal + netoTotal;

                }
                Row fila2 = hoja.createRow(homo.size() + 1);
                Cell celda2 = fila2.createCell(0);
                celda2.setCellValue("");
                celda2 = fila2.createCell(1);
                celda2.setCellValue("");

                celda2 = fila2.createCell(2);
                celda2.setCellValue("Totales");
                celda2.setCellStyle(estiloBold);
                

                celda2 = fila2.createCell(3); //TOTAL DE TAMBORES
                celda2.setCellValue(TotalTambCam);//TOTAL DE TAMBORES A CAMARA
                celda2.setCellStyle(estiloBold);
                celda2 = fila2.createCell(4);
                celda2.setCellValue(TotalPurga);//TOTAL DE TAMBORES PURGA
                celda2.setCellStyle(estiloBold);
                celda2 = fila2.createCell(5);
                celda2.setCellValue(formatoDecimal.format(TotalNetoL));//TOTAL NETO DEL LOTE INGRESADO
                celda2.setCellStyle(estiloBold);
                celda2 = fila2.createCell(6);
                celda2.setCellValue(TotalTambExp);//TOTAL DE TAMBORES A EXPORTAR
                celda2.setCellStyle(estiloBold);
                celda2 = fila2.createCell(7);
                celda2.setCellValue(formatoDecimal.format(TotalNetoExp));//TOTAL NETO A EXPORTAR
                celda2.setCellStyle(estiloBold);
                celda2 = fila2.createCell(8);
                celda2.setCellValue(tamboresSobrantes.size());//TOTAL DE TAMBORES SOBRANTES
                celda2.setCellStyle(estiloBold);
                celda2 = fila2.createCell(9);
                celda2.setCellValue(formatoDecimal.format(TotalNetoSo));//TOTAL NETO SOBRANTE
                celda2.setCellStyle(estiloBold);
                celda2 = fila2.createCell(10);
                celda2.setCellValue(formatoDecimal.format(TotalNetoTotal));//NETO A EXPORTAR + NETO SOBRANTE
                celda2.setCellStyle(estiloBold);
                celda2 = fila2.createCell(11);
                TotalDifNeto = TotalNetoExp - TotalNetoL;
                celda2.setCellValue(formatoDecimal.format(TotalDifNeto));//TOTAL DIFERENCIA ENTRE EL NETO TOTAL Y NETO A EXPORTAR
                celda2.setCellStyle(estiloBold);
                celda2 = fila2.createCell(12);
                TotalPorc = TotalNetoTotal / TotalNetoL * 100 - 100;
                celda2.setCellValue(formatoDecimal.format(TotalPorc));
                celda2.setCellStyle(estiloBold);

                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (Exception ex) {

                System.out.println("Error " + ex.getMessage());
            }
        }
    }
}
