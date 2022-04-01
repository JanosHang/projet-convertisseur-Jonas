package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable{


    @FXML
    private ComboBox<String> cbo8;

    @FXML
    private ComboBox<String> cbo6;

    @FXML
    private ComboBox<String> cbo7;

    @FXML
    private ComboBox<String> cbo4;

    @FXML
    private ComboBox<String> cbo5;

    @FXML
    private ComboBox<String> cbo2;

    @FXML
    private ComboBox<String> cbo3;

    @FXML
    private ComboBox<String> cbo1;
    
    @FXML
    private TextField txt1;
    
    @FXML
    private TextField txt2;
    
    @FXML
    private TextField txt3;
    
    @FXML
    private TextField txt4;
    
    @FXML
    private TextField txt5;
    
    @FXML
    private TextField txt6;
    
    @FXML
    private TextField txt7;
   
    @FXML
    private TextField txt8;
    
    @FXML
    private TabPane monPane;

    @FXML
    private Button btnMasse;

    @FXML
    private Button btnEnergie;

    @FXML
    private Button btnLongueur;
    
    @FXML
    private Button btnVitesse;
    
    @FXML
    private ImageView image1;
    
    @FXML
    private ImageView image2;
    
    @FXML
    private ImageView image3;
    
    @FXML
    private ImageView image4;
    
    
    @FXML
    void changer(ActionEvent e)
    {
    	Button b=(Button)e.getSource();
    	String a=b.getText();
    	
    	switch (a) 
    {
    	case "Longueur":
    		monPane.getSelectionModel().select(1); //selectionne le case 1 si l'usager clique sur "Longueur"
    		break;
    	case "Masse":
    		monPane.getSelectionModel().select(2); //selectionne le case 2 si l'usager clique sur "Masse"
    		break;
    	case "Vitesse":
    		monPane.getSelectionModel().select(3); //selectionne le case 3 si l'usager clique sur "Vitesse"
    		break;
    	case "Energie":
    		monPane.getSelectionModel().select(4); //selectionne le case 4 si l'usager clique sur "Energie"
    		break;
    	
    	}
    }
    
    @FXML
    void quitter()
    {
    	Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("SORTIE");
    	alert.setContentText("Veux tu fermer cet application?"); //demande a l'usager si il veut fermer l'application
    	Optional<ButtonType> result=alert.showAndWait(); //attends pour sa reponse
    	if(result.get()==ButtonType.OK) //si l'usager clique sur ok
   		System.exit(0); //ferme l'application
    }  
   
    
    public void initialize(URL location, ResourceBundle resources)
    {
    	cbo1.setItems(listLongueur); 
    	cbo2.setItems(listLongueur);
    	
    	cbo3.setItems(listMasse);
    	cbo4.setItems(listMasse);
    	
    	cbo5.setItems(listVitesse);
    	cbo6.setItems(listVitesse);
    	
    	cbo7.setItems(listEnergie);
    	cbo8.setItems(listEnergie);

    	cbo1.getSelectionModel().selectFirst();
    	cbo2.getSelectionModel().selectFirst();
    	
    	cbo3.getSelectionModel().selectFirst();
    	cbo4.getSelectionModel().selectFirst();
    	
    	cbo5.getSelectionModel().selectFirst();
    	cbo6.getSelectionModel().selectFirst();
    	
    	cbo7.getSelectionModel().selectFirst();
    	cbo8.getSelectionModel().selectFirst();

}
    
    private ObservableList<String> listLongueur=FXCollections.observableArrayList("km", "m", "cm", "mile", "yard", "foot", "inch");
    private ObservableList<String> listMasse=FXCollections.observableArrayList("kg", "g", "stone", "pound");
    private ObservableList<String> listVitesse=FXCollections.observableArrayList("meters/s", "km/h", "feet/s", "miles/h");
    private ObservableList<String> listEnergie=FXCollections.observableArrayList("Kj", "J", "kWh", "Wh");
    
    private double longueur[] = {1.0, 1000.0, 100000.0, 0.621371, 1093.61, 3280.84 , 39370.1 };
    private double masse[] = {1.0, 1000.0, 0.157473, 2.20462};
    private double vitesse[] = {1.0, 3.6, 3.28084, 2.23694};
    private double energie[] = {1.0, 1000.0, 0.000277778 , 0.277778};
    
    @FXML
    private void verifNum(KeyEvent e)
    {
    	TextField txt=(TextField)e.getSource();
    	txt.textProperty().addListener((observable,oldValue,newValue)->
    	{
    		if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
    		{
    			txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
    }

    });
}
    
    private double setTaux(ComboBox a, double tbl[])
    {
    	int item=a.getSelectionModel().getSelectedIndex();
    	double val=tbl[item];
    	return val;
    }
    
    private void convert(ComboBox a, ComboBox b, TextField c, TextField d, double tbl[])
    {
    	double from=setTaux(a,tbl);
    	double depart=0;
    	
    	depart =c.getText().equals("")?0:Double.parseDouble(c.getText());
    	
    	double to=setTaux(b,tbl);
    	double dest=(to/from)*depart;
    	d.setText(String.valueOf(dest));
    	
    }
    
    //convertir les longueurs
    @FXML
    private void ConvertL1()
    {
    	convert(cbo1, cbo2,txt1, txt2, longueur);
    }
    
    @FXML
    private void ConvertL2()
    {
    	convert(cbo2, cbo1,txt2, txt1, longueur);
    }
    
    
    //convertir les masses
    @FXML
    private void ConvertM1()
    {
    	convert(cbo3, cbo4,txt3, txt4, masse);
    }
    
    @FXML
    private void ConvertM2()
    {
    	convert(cbo4, cbo3,txt4, txt3, masse);
    }
    
    //convertir les vitesses
    @FXML
    private void ConvertV1()
    {
    	convert(cbo5, cbo6,txt5, txt6, vitesse);
    }
    
    @FXML
    private void ConvertV2()
    {
    	convert(cbo6, cbo5,txt6, txt5, vitesse);
    }
    
    
    //convertir les energies
    @FXML
    private void ConvertE1()
    {
    	convert(cbo7, cbo8,txt7, txt8, energie);
    }
    
    @FXML
    private void ConvertE2()
    {
    	convert(cbo8, cbo7,txt8, txt7, energie);
    }
    	
    		
   
  
    }
    
    
    
    
    

