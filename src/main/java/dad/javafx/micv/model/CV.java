package dad.javafx.micv.model;

import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import dad.javafx.micv.personal.PersonalModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class CV {

	private ObjectProperty<PersonalModel> personal = new SimpleObjectProperty<PersonalModel>(new PersonalModel());

	public final ObjectProperty<PersonalModel> personalProperty() {
		return this.personal;
	}

	public final PersonalModel getPersonal() {
		return this.personalProperty().get();
	}

	public final void setPersonal(final PersonalModel personal) {
		this.personalProperty().set(personal);
	}

	public static void main(String[] args) {
		
		CV cv = new CV();
		cv.getPersonal().setNombre("Chuck");
		cv.getPersonal().setApellidos("Norris");
		cv.getPersonal().getNacionalidades().add(new Nacionalidad("estadounidense"));
		
		Gson gson = 
			FxGson.fullBuilder()
                .setPrettyPrinting()
                .create();
		
		String json = gson.toJson(cv); // convertir modelo de datos a json (marshalling)

		System.out.println(json);
		
		cv = gson.fromJson(json, CV.class); // convertir json a modelo de datos (unmarshalling) 
		
	}
	
}



