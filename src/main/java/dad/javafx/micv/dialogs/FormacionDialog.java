package dad.javafx.micv.dialogs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.formacion.FormacionModel;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class FormacionDialog implements Initializable {

	private FormacionModel formacion = new FormacionModel();
	
    @FXML
    private GridPane view;

    @FXML
    private TextField denText;

    @FXML
    private DatePicker desdePicker;

    @FXML
    private DatePicker hastaPicker;

    @FXML
    private TextField orgText;


    public FormacionDialog() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addTituloView.fxml"));
		loader.setController(this);
		loader.load();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
}
