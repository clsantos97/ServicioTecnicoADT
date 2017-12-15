package app.logic.bean;

import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Carlos
 */
public class FacturaBean {
    private final SimpleIntegerProperty id;
    private final SimpleIntegerProperty idcliente;
    private ArrayList<ServicioBean> serviciosList;
    private final SimpleStringProperty date;
    private final SimpleDoubleProperty total;
    
    public FacturaBean(Integer id, Integer idcliente,ArrayList<ServicioBean> serviciosList, String date, Double total){
        this.id=new SimpleIntegerProperty(id);
        this.idcliente=new SimpleIntegerProperty(idcliente);
        this.serviciosList = serviciosList;
        this.date = new SimpleStringProperty(date);
        this.total = new SimpleDoubleProperty(total);
    }
    
    public FacturaBean(){
        this.id=new SimpleIntegerProperty(0);
        this.idcliente=new SimpleIntegerProperty(0);
        this.serviciosList = new ArrayList();
        this.date = new SimpleStringProperty("");
        this.total = new SimpleDoubleProperty(0);
    }

    public ArrayList<ServicioBean> getServiciosList() {
        return serviciosList;
    }

    public void setServiciosList(ArrayList<ServicioBean> serviciosList) {
        this.serviciosList = serviciosList;
    }
    
    public Integer getId(){
        return id.get();
    }
    
    public Integer getIdcliente(){
        return idcliente.get();
    }
    
    public String getDate(){
        return date.get();
    }
    
    public Double getTotal(){
        return total.get();
    }
    
    public void setId(Integer id){
        this.id.set(id);
    }
    
    public void setIdcliente(Integer idcliente){
        this.idcliente.set(idcliente);
    }
    
    public void setDate(String date){
        this.date.set(date);  
    }
    
    public void setTotal(Double total){
        this.total.set(total);
    } 
}
