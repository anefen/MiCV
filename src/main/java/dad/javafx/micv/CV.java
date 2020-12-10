package dad.javafx.micv;
import dad.javafx.micv.conocimiento.ConocimientoModel;
import dad.javafx.micv.conocimiento.Idioma;
import dad.javafx.micv.contacto.*;
import dad.javafx.micv.experiencia.ExperienciaModel;
import dad.javafx.micv.formacion.FormacionModel;

import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import dad.javafx.micv.personal.PersonalModel;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {

	private ObjectProperty<PersonalModel> personal = new SimpleObjectProperty<PersonalModel>(new PersonalModel());
	private ObjectProperty<ContactoModel> contacto=new SimpleObjectProperty<ContactoModel>(new ContactoModel());
	private ListProperty<FormacionModel>formacion=new SimpleListProperty<FormacionModel>(FXCollections.observableArrayList());
	private ListProperty<ExperienciaModel> experiencia=new SimpleListProperty<ExperienciaModel>(FXCollections.observableArrayList());
	private ListProperty<ConocimientoModel> conocimiento=new SimpleListProperty<ConocimientoModel>(FXCollections.observableArrayList());

	
	public static void main(String[] args) {
		
		CV cv = new CV();
		cv.getPersonal().setNombre("Chuck");
		cv.getPersonal().setApellidos("Norris");
		cv.getPersonal().getNacionalidades().add(new Nacionalidad("estadounidense"));
		
		Gson gson = 
			FxGson.fullBuilder()
                .setPrettyPrinting()
                .create();
		
		String json = gson.toJson(cv); 

		System.out.println(json);
		
		cv = gson.fromJson(json, CV.class); 
		
	}
	
	public final ObjectProperty<PersonalModel> personalProperty() {
		return this.personal;
	}

	public final PersonalModel getPersonal() {
		return this.personalProperty().get();
	}

	public final void setPersonal(final PersonalModel personal) {
		this.personalProperty().set(personal);
	}


	public final ObjectProperty<ContactoModel> contactoProperty() {
		return this.contacto;
	}
	

	public final ContactoModel getContacto() {
		return this.contactoProperty().get();
	}
	

	public final void setContacto(final ContactoModel contacto) {
		this.contactoProperty().set(contacto);
	}
	

	public final ListProperty<FormacionModel> formacionProperty() {
		return this.formacion;
	}
	

	public final ObservableList<FormacionModel> getFormacion() {
		return this.formacionProperty().get();
	}
	

	public final void setFormacion(final ObservableList<FormacionModel> formacion) {
		this.formacionProperty().set(formacion);
	}
	

	public final ListProperty<ExperienciaModel> experienciaProperty() {
		return this.experiencia;
	}
	

	public final ObservableList<ExperienciaModel> getExperiencia() {
		return this.experienciaProperty().get();
	}
	

	public final void setExperiencia(final ObservableList<ExperienciaModel> experiencia) {
		this.experienciaProperty().set(experiencia);
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



