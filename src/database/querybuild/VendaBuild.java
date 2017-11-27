package database.querybuild;

import java.util.List;
import database.entidades.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendaBuild extends BaseBuild
{  
    private String table;
    
    private String primaryKey;
    
    private Venda venda;
    
    private List<Venda> vendas;
    
    public VendaBuild()
    {
        super();
        this.setTable(this.table = "venda");
        this.setPrimaryKey(this.primaryKey = "id_venda");
        
        this.vendas = new ArrayList<>();
    }
    
    public Venda find(int id)
    {   
        query = "SELECT * FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    public Venda find(int id, String fields)
    {        
        query = "SELECT "+ fields +" FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    private Venda buildFind(String query, int id)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            sttm.setInt(1,id);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.venda = new Venda();
                this.venda.id = res.getInt("id_venda");
                this.venda.id_pedido = res.getInt("id_pedido");
                this.venda.situacao = res.getInt("situacao");
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.venda;
    }
    
    public List<Venda> all()
    {
        query = "SELECT * FROM "+ table;
        
        return null;
    }
    
    public List<Venda> all(String fields)
    {
        query = "SELECT "+ fields +" FROM "+ table;
        
        return null;
    }
    
    
    private List<Venda> buildAll(String query)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.venda = new Venda();
                this.venda.id = res.getInt("id_venda");
                this.venda.id_pedido = res.getInt("id_pedido");
                this.venda.situacao = res.getInt("situacao");
                
                this.vendas.add(this.venda);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.vendas;
    }
    
    public List<Venda> get()
    {
        try{
            ResultSet res = this.getResult();
            
            while(res.next()) {
                this.venda = new Venda();
                this.venda.id = res.getInt("id_venda");
                this.venda.id_pedido = res.getInt("id_pedido");
                this.venda.situacao = res.getInt("situacao");
                
                this.vendas.add(this.venda);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.vendas;
    }
}