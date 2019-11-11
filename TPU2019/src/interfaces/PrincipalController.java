package interfaces;

import controladores.Gestor;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

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
}
