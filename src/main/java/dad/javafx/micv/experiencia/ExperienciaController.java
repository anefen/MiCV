package dad.javafx.micv.experiencia;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dad.javafx.micv.formacion.FormacionModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ExperienciaController implements Initializable{

	private ListProperty<ExperienciaModel> experiencia = new SimpleListProperty<ExperienciaModel>(FXCollections.observableArrayList());

	

	public ExperienciaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/experienciaView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public Pane getView() {
		return root;
	}
	    @FXML
	    private Pane root;

	    @FXML
	    private TableView<ExperienciaModel> expView;

	    @FXML
	    private TableColumn<ExperienciaModel, LocalDate> desdeColum;

	    @FXML
	    private TableColumn<ExperienciaModel, LocalDate> hastaColumn;

	    @FXML
	    private TableColumn<ExperienciaModel, String> denomColum;

	    @FXML
	    private TableColumn<ExperienciaModel, String> empleadorColumn;

	    @FXML
	    private VBox expBox;

	    @FXML
	    private Button addExpButton;

	    @FXML
	    private Button deleteExpButton;

	    @FXML
	    void onAddAction(ActionEvent event) {

	    }

	    @FXML
	    void onDeleteAction(ActionEvent event) {

	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

	}


