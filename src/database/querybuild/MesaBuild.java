package database.querybuild;

import java.util.List;
import database.entidades.Mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaBuild extends BaseBuild
{  
    private String table;
    
    private String primaryKey;
    
    private Mesa mesa;
    
    private List<Mesa> mesas;
    
    public MesaBuild()
    {
        super();
        this.setTable(this.table = "mesas");
        this.setPrimaryKey(this.primaryKey = "id_mesa");
        
        this.mesas = new ArrayList<>();
    }
    
    public Mesa find(int id)
    {   
        query = "SELECT * FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    public Mesa find(int id, String fields)
    {        
        query = "SELECT "+ fields +" FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    private Mesa buildFind(String query, int id)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            sttm.setInt(1,id);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.mesa = new Mesa();
                this.mesa.id = res.getInt("id_mesa");
                this.mesa.id_cliente = res.getInt("codigo_prato");
                this.mesa.lugares = res.getInt("codigo_prato");
                this.mesa.status = res.getInt("codigo_prato");
                this.mesa.created_at = res.getTimestamp("create_at");
                this.mesa.updated_at = res.getTimestamp("update_at");
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.mesa;
    }
    
    public List<Mesa> all()
    {
        query = "SELECT * FROM "+ table;
        
        return this.buildAll(query);
    }
    
    public List<Mesa> all(String fields)
    {
        query = "SELECT "+ fields +" FROM "+ table;
        
        return this.buildAll(query);
    }
    
    private List<Mesa> buildAll(String query)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.mesa = new Mesa();
                this.mesa.id = res.getInt("id_mesa");
                this.mesa.id_cliente = res.getInt("codigo_prato");
                this.mesa.lugares = res.getInt("codigo_prato");
                this.mesa.status = res.getInt("codigo_prato");
                this.mesa.created_at = res.getTimestamp("create_at");
                this.mesa.updated_at = res.getTimestamp("update_at");
                
                this.mesas.add(this.mesa);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.mesas;
    }
    
    public List<Mesa> get()
    {
        ResultSet res = this.getResult();
        
        try{
            while(res.next()) {
                this.mesa = new Mesa();
                this.mesa.id = res.getInt("id_mesa");
                this.mesa.id_cliente = res.getInt("codigo_prato");
                this.mesa.lugares = res.getInt("codigo_prato");
                this.mesa.status = res.getInt("codigo_prato");
                this.mesa.created_at = res.getTimestamp("create_at");
                this.mesa.updated_at = res.getTimestamp("update_at");
                
                this.mesas.add(this.mesa);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.mesas;
    }
}