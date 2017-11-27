package database.querybuild;

import java.util.List;
import database.entidades.Prato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PratoBuild extends BaseBuild
{  
    private String table;
    
    private String primaryKey;
    
    private Prato prato;
    
    private List<Prato> pratos;
    
    public PratoBuild()
    {
        super();
        this.setTable(this.table = "prato");
        this.setPrimaryKey(this.primaryKey = "id_prato");
        
        this.pratos = new ArrayList<>();
    }
    
    public Prato find(String id)
    {   
        query = "SELECT * FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query,id);
    }
    
    public Prato find(String id, String fields)
    {        
        query = "SELECT "+ fields +" FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    private Prato buildFind(String query, String id)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            sttm.setString(1,id);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.prato = new Prato();
                this.prato.id_prato = res.getInt("id_prato");
                this.prato.nome = res.getString("nome");
                this.prato.descricao = res.getString("descricao");
                this.prato.valor = res.getFloat("valor");
                this.prato.created_at = res.getTimestamp("create_at");
                this.prato.updated_at = res.getTimestamp("update_at");
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.prato;
    }
    
    public List<Prato> all()
    {
        query = "SELECT * FROM "+ table;
        
        return this.buildAll(query);
    }
    
    public List<Prato> all(String fields)
    {
        query = "SELECT "+ fields +" FROM "+ table;
        
        return this.buildAll(query);
    }
    
    private List<Prato> buildAll(String query)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.prato = new Prato();
                this.prato.id_prato = res.getInt("id_prato");
                this.prato.nome = res.getString("nome");
                this.prato.descricao = res.getString("descricao");
                this.prato.valor = res.getFloat("valor");
                this.prato.created_at = res.getTimestamp("create_at");
                this.prato.updated_at = res.getTimestamp("update_at");
                
                this.pratos.add(this.prato);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.pratos;
    }
    
    public List<Prato> get()
    {
        try{
            ResultSet res = this.getResult();
            
            while(res.next()) {
                this.prato = new Prato();
                this.prato.id_prato = res.getInt("id_prato");
                this.prato.nome = res.getString("nome");
                this.prato.descricao = res.getString("descricao");
                this.prato.valor = res.getFloat("valor");
                this.prato.created_at = res.getTimestamp("create_at");
                this.prato.updated_at = res.getTimestamp("update_at");
                
                this.pratos.add(this.prato);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.pratos;
    }
}