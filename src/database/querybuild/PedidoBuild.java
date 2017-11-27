package database.querybuild;

import java.util.List;
import database.entidades.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoBuild extends BaseBuild
{  
    private String table;
    
    private String primaryKey;
    
    private Pedido pedido;
    
    private List<Pedido> pedidos;
    
    public PedidoBuild()
    {
        super();
        this.setTable(this.table = "pedido");
        this.setPrimaryKey(this.primaryKey = "id_pedido");
        
        this.pedidos = new ArrayList<>();
    }
    
    public Pedido find(int id)
    {   
        query = "SELECT * FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    public Pedido find(int id, String fields)
    {        
        query = "SELECT "+ fields +" FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    private Pedido buildFind(String query, int id)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            sttm.setInt(1,id);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.pedido = new Pedido();
                this.pedido.id_pedido = res.getInt("id_pedido");
                this.pedido.id_cardapio = res.getInt("id_pedido");
                this.pedido.id_funcionario = res.getInt("id_pedido");
                this.pedido.status = res.getInt("id_pedido");
                this.pedido.created_at = res.getTimestamp("create_at");
                this.pedido.updated_at = res.getTimestamp("update_at");
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.pedido;
    }
    
    public List<Pedido> all()
    {
        query = "SELECT * FROM "+ table;
        
        return this.buildAll(query);
    }
    
    public List<Pedido> all(String fields)
    {
        query = "SELECT "+ fields +" FROM "+ table;
        
        return this.buildAll(query);
    }
    
    private List<Pedido> buildAll(String query)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.pedido = new Pedido();
                this.pedido.id_pedido = res.getInt("id_pedido");
                this.pedido.id_cardapio = res.getInt("id_pedido");
                this.pedido.id_funcionario = res.getInt("id_pedido");
                this.pedido.status = res.getInt("id_pedido");
                this.pedido.created_at = res.getTimestamp("create_at");
                this.pedido.updated_at = res.getTimestamp("update_at");
                
                this.pedidos.add(this.pedido);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.pedidos;
    }
    
    public List<Pedido> get()
    {
        try{
            ResultSet res = this.getResult();
            
            while(res.next()) {
                this.pedido = new Pedido();
                this.pedido.id_pedido = res.getInt("id_pedido");
                this.pedido.id_cardapio = res.getInt("id_pedido");
                this.pedido.id_funcionario = res.getInt("id_pedido");
                this.pedido.status = res.getInt("id_pedido");
                this.pedido.created_at = res.getTimestamp("create_at");
                this.pedido.updated_at = res.getTimestamp("update_at");
                
                this.pedidos.add(this.pedido);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.pedidos;
    }
}