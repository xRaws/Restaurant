package database.querybuild;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.entidades.Cardapio;

public class CardapioBuild extends BaseBuild
{  
    private String table;
    
    private String primaryKey;
    
    private Cardapio cardapio;
    
    private List<Cardapio> cardapios;
    
    public CardapioBuild()
    {
        super();
        this.setTable(this.table = "cardapio");
        this.setPrimaryKey(this.primaryKey = "id_cardapio");
        
        this.cardapios = new ArrayList<>();
    }
    
    public Cardapio find(int id)
    {   
        query = "SELECT * FROM "+ this.table +" WHERE "+ this.primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    public Cardapio find(int id, String fields)
    {        
        query = "SELECT "+ fields +" FROM "+ this.table +" WHERE "+ this.primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    private Cardapio buildFind(String query, int id)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            sttm.setInt(1,id);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.cardapio = new Cardapio();
                this.cardapio.id_cardapio = res.getInt("id_cardapio");
                this.cardapio.codigo_prato = res.getInt("codigo_prato");
                this.cardapio.valor       = res.getFloat("valor");
                this.cardapio.versao       = res.getString("versao");
                this.cardapio.created_at = res.getTimestamp("create_at");
                this.cardapio.updated_at = res.getTimestamp("update_at");
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.cardapio;
    }
    
    public List<Cardapio> all()
    {
        query = "SELECT * FROM "+ this.table;
        
        return this.buildAll(query);
    }
    
    public List<Cardapio> all(String fields)
    {
        query = "SELECT "+ fields +" FROM "+ this.table;
        
        return this.buildAll(query);
    }
    
    private List<Cardapio> buildAll(String query)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.cardapio = new Cardapio();
                this.cardapio.id_cardapio = res.getInt("id_cardapio");
                this.cardapio.codigo_prato = res.getInt("codigo_prato");
                this.cardapio.valor       = res.getFloat("valor");
                this.cardapio.versao       = res.getString("versao");
                this.cardapio.created_at = res.getTimestamp("create_at");
                this.cardapio.updated_at = res.getTimestamp("update_at");
                
                this.cardapios.add(this.cardapio);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.cardapios;
    }
    
    public List<Cardapio> get()
    {
        ResultSet res = this.getResult();
        
        try{
            while(res.next()) {
                this.cardapio = new Cardapio();
                this.cardapio.id_cardapio   = res.getInt("id_cardapio");
                this.cardapio.codigo_prato  = res.getInt("codigo_prato");
                this.cardapio.valor         = res.getFloat("valor");
                this.cardapio.versao        = res.getString("versao");
                this.cardapio.created_at    = res.getTimestamp("create_at");
                this.cardapio.updated_at    = res.getTimestamp("update_at");
                
                this.cardapios.add(this.cardapio);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.cardapios;
    }
}