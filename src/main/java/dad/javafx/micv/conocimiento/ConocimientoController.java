package dad.javafx.micv.conocimiento;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.*;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class ConocimientoController implements Initializable {

	
	
	private ListProperty<ConocimientoModel> conocimiento = new SimpleListProperty<>();

	
	
	public ConocimientoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/conocimientoView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public Pane getView() {
		return root;
	}

	@FXML
	private Pane root;

	@FXML
	private TableColumn<ConocimientoModel, String> denominacionColum;

	@FXML
	private TableColumn<ConocimientoModel, Nivel> nivelColumn;

	@FXML
	private Button conocimientoButton;

	@FXML
	private Button idiomaButton;

	@FXML
	private Button deleteButton;

	@FXML
	void onAddConAction(ActionEvent event) {

	}

	@FXML
	void onAddIdiomAction(ActionEvent event) {

	}

	@FXML
	void onDeleteButton(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public final ListProperty<ConocimientoModel> conocimientoProperty() {
		return this.conocimiento;
	}
	

	public final ObservableList<ConocimientoModel> getConocimiento() {
		return this.conocimientoProperty().get();
	}
	

	public final void setConocimiento(final ObservableList<ConocimientoModel> conocimiento) {
		this.conocimientoProperty().set(conocimiento);
	}
	



	
	

}
