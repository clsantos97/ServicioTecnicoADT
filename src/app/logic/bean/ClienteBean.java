package app.logic.bean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Carlos
 */
public class ClienteBean {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name; 
    private final SimpleStringProperty lastname;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty email;
    private final SimpleStringProperty zipcode;
    private final SimpleStringProperty regdate;
    
    public ClienteBean(Integer id, String name, String lastname, String phone, String email, String zipcode, String regdate){
        this.id=new SimpleIntegerProperty(id);
        this.name=new SimpleStringProperty(name);
        this.lastname=new SimpleStringProperty(lastname);
        this.phone=new SimpleStringProperty(phone);
        this.email=new SimpleStringProperty(email);
        this.zipcode=new SimpleStringProperty(zipcode);
        this.regdate=new SimpleStringProperty(regdate);
    }
    
    public ClienteBean(Integer id, String name){
        this.id=new SimpleIntegerProperty(id);
        this.name=new SimpleStringProperty(name);
        this.lastname=new SimpleStringProperty("");
        this.phone=new SimpleStringProperty("");
        this.email=new SimpleStringProperty("");
        this.zipcode=new SimpleStringProperty("");
        this.regdate=new SimpleStringProperty("");
    }
    
    public ClienteBean(){
        this.id=new SimpleIntegerProperty(0);
        this.name=new SimpleStringProperty("");
        this.lastname=new SimpleStringProperty("");
        this.phone=new SimpleStringProperty("");
        this.email=new SimpleStringProperty("");
        this.zipcode=new SimpleStringProperty("");
        this.regdate=new SimpleStringProperty("");
    }

    public Integer getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getLastname() {
        return lastname.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getZipcode() {
        return zipcode.get();
    }
    
    public String getRegdate() {
        return regdate.get();
    }
    
    public void setId(Integer id){
        this.id.set(id);
    }
    
    public void setName(String name){
        this.name.set(name);
    }
    
    public void setLastname(String lastname){
        this.lastname.set(lastname);
    }
    
    public void setPhone(String phone){
        this.phone.set(phone);
    }
    
    public void setEmail(String email){
        this.email.set(email);
    }
    
    public void setZipcode(String zipcode){
        this.zipcode.set(zipcode);
    }
    
    public void setRegdate(String regdate){
        this.regdate.set(regdate);
    }
}
