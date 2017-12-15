/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import app.config.db.DbManager;
import app.logic.bean.FacturaBean;
import app.logic.bean.ServicioBean;
import app.logic.interfaces.FacturaManager;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class FacturaDAO implements FacturaManager {

    private static final Logger logger = Logger.getLogger(FacturaDAO.class.getName());
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private Connection dbconn;

    public FacturaDAO() {
        this.dbconn = DbManager.getInstance().getDbconn();
    }

    public Collection<FacturaBean> getFacturas() {
        System.out.println("getfacturas");
        int count = 0;
        String query = "SELECT * FROM FACTURAS";
        ArrayList<FacturaBean> facturasList = new ArrayList<>();
        ArrayList<ServicioBean> serviciosList = new ArrayList<>();
        try {
            Statement stm = dbconn.createStatement();
            ResultSet res = stm.executeQuery(query);

            while (res.next()) {
                Array servArray = res.getArray("SERVS");
                Object[] servicios = (Object[]) servArray.getArray();

                for (int i = 0; i < servicios.length; i++) {
                    ServicioBean servicioBean = new ServicioBean();
                    Struct servicio = (Struct) servicios[i];
                    Object[] attrib = servicio.getAttributes();
                    servicioBean.setId(Integer.valueOf(attrib[0].toString()));
                    servicioBean.setName(attrib[1].toString());
                    servicioBean.setDescription(attrib[2].toString());
                    servicioBean.setPrice(Double.parseDouble(attrib[3].toString()));
                    serviciosList.add(servicioBean);
                }
                // Create factura with resultSet data
                FacturaBean factura = new FacturaBean();
                factura.setId(res.getInt("ID_FAC"));
                factura.setIdcliente(res.getInt("ID_CLI"));
                factura.setDate(res.getDate("DATE_FAC").toLocalDate().format(dateFormatter));
                factura.setTotal(res.getDouble("TOTAL"));
                factura.setServiciosList(serviciosList);
                facturasList.add(factura);
            }
            
            facturasList.stream().forEach(f -> System.out.println("Id: "+f.getId()+
                    "  Idcliente: "+f.getIdcliente()+
                    " Servicios: "+f.getServiciosList().size()+
                    "  Date: "+f.getDate()+"  Total: "+f.getTotal()));
            
            System.out.println(facturasList.toString());
            res.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return facturasList;
    }

    public boolean deleteFactura(FacturaBean factura) {
        boolean success = false;
        String query = "DELETE FROM FACTURAS WHERE ID_FAC=?";

//        try {
//            PreparedStatement stm = dbconn.prepareStatement(query);
//            stm.setInt(1, factura.getId());
//            int res = stm.executeUpdate();
//            stm.close();
//            
//            if(res>0){
//                success=true;
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return success;
    }

    public boolean updateFactura(FacturaBean factura) {
        boolean success = false;
        String query = "UPDATE FACTURAS SET NAME_SER=?, DESCRIPTION=?, PRICE=? WHERE ID_SER=?";

//        try {
//            PreparedStatement stm = dbconn.prepareStatement(query);
//            stm.setString(1, factura.getName());
//            stm.setString(2, factura.getDescription());
//            stm.setDouble(3, factura.getPrice());
//            stm.setInt(4, factura.getId());
//            
//            int res = stm.executeUpdate();
//            stm.close();
//            
//            if(res>0){
//                success=true;
//                logger.log(Level.INFO, "Modificada factura id: {0}", factura.getId());
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } 
        return success;
    }

    @Override
    public boolean insertFactura(FacturaBean factura) {
        boolean success = false;
        String query = "INSERT INTO FACTURAS (NAME_SER, DESCRIPTION, PRICE) VALUES (?,?,?)";

//        try {
//            PreparedStatement stm = dbconn.prepareStatement(query);
//            stm.setString(1, factura.getName());
//            stm.setString(2, factura.getDescription());
//            stm.setFloat(3, factura.getPrice().floatValue());
//            
//            int res = stm.executeUpdate();
//            stm.close();
//            if(res>0){
//                success=true;
//                logger.log(Level.INFO, "Insertado nueva factura id: {0}", factura.getId());
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, "SqlException", ex);
//        }
        return success;
    }
}
