package interfaces;

import controladores.Gestor;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;

public class PrincipalController {
    public TextField txtPostulaciones;
    public TextField txtRegiones;
    public TextField txtConteos;
    public Button btnCargarPostulaciones;
    public Button btnCargarRegiones;
    public Button btnCargarConteos;
    public Button btnImportarDatos;
    public ComboBox cmbDistrito;
    public ComboBox cmbSeccion;
    public ComboBox cmbCircuito;
    public ComboBox cmbCandidato;
    public CheckBox chbIncluirTodos;
    public Button btnLimpiarFiltros;
    public Button btnContar;
    public Button btnSalir;
    private boolean datosCargados = false;
    private static Gestor gestor;

    public void btnCargarRegionesClick(ActionEvent actionEvent){
        cargarArchivo(txtRegiones);
    }

    public void btnCargarPostulacionesClick(ActionEvent actionEvent){
        cargarArchivo(txtPostulaciones);
    }

    public void btnCargarConteosClick(ActionEvent actionEvent){
        cargarArchivo(txtConteos);
    }

    private void cargarArchivo(TextField txtRuta){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos de texto", "*.dsv"));
        File seleccionado = fc.showOpenDialog(null);
        if (seleccionado != null) {
            txtRuta.setText(seleccionado.getAbsolutePath());
        }
    }

    public void btnImportarDatosClick(ActionEvent actionEvent)
    {
        if (txtPostulaciones.getText().equals("") || txtConteos.getText().equals("") || txtRegiones.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Falta cargar archivos de datos.");
            return;}
        else {
            try {
                gestor = new Gestor();
                datosCargados = true;
                btnCargarPostulaciones.setDisable(true);
                btnImportarDatos.setDisable(true);
                btnCargarRegiones.setDisable(true);
                btnCargarConteos.setDisable(true);
                cmbCandidato.setDisable(false);
                cmbCircuito.setDisable(false);
                cmbSeccion.setDisable(false);
                cmbDistrito.setDisable(false);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Se produjo un error. Por favor revise los archivos cargados.");
            }
        }
    }

    public void cmbCircuitoSelection(ActionEvent actionEvent) {

    }

    public void cmbSeccionSelection(ActionEvent actionEvent) {

    }

    public void cmbDistritoSelection(ActionEvent actionEvent) {

    }

    public void cmbCandidatoSelection(ActionEvent actionEvent) {

    }

    public void chbIncluirTodosChecked(ActionEvent actionEvent) {

    }

    public void btnLimpiarFiltrosClick(ActionEvent actionEvent) {

    }

    public void btnContarClick(ActionEvent actionEvent) {

    }

    public void btnSalirClick(ActionEvent actionEvent) {
        System.exit(0);
    }

}
