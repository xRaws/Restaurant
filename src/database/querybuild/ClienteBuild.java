package database.querybuild;

import java.util.List;
import database.entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteBuild extends BaseBuild
{  
    private String table;
    
    private String primaryKey;
    
    private Cliente cliente;
    
    private List<Cliente> clientes;
    
    public ClienteBuild()
    {
        super();
        this.setTable(this.table = "cliente");
        this.setPrimaryKey(this.primaryKey = "id_cliente");
        
        this.clientes = new ArrayList<>();
    }
    
    public Cliente find(int id)
    {   
        query = "SELECT * FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    public Cliente find(int id, String fields)
    {        
        query = "SELECT "+ fields +" FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    private Cliente buildFind(String query, int id)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            sttm.setInt(1,id);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.cliente = new Cliente();
                this.cliente.id         = res.getInt("id_cliente");
                this.cliente.nome       = res.getString("nome");
                this.cliente.sobrenome  = res.getString("sobrenome");
                this.cliente.created_at = res.getTimestamp("create_at");
                this.cliente.updated_at = res.getTimestamp("update_at");
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.cliente;
    }
    
    public List<Cliente> all()
    {
        query = "SELECT * FROM "+ table;
        
        return this.buildAll(query);
    }
    
    public List<Cliente> all(String fields)
    {
        query = "SELECT "+ fields +" FROM "+ table;
        
        return this.buildAll(query);
    }
    
    private List<Cliente> buildAll(String query)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.cliente = new Cliente();
                this.cliente.id         = res.getInt("id_cliente");
                this.cliente.nome       = res.getString("nome");
                this.cliente.sobrenome  = res.getString("sobrenome");
                this.cliente.created_at = res.getTimestamp("create_at");
                this.cliente.updated_at = res.getTimestamp("update_at");
                
                this.clientes.add(this.cliente);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.clientes;
    }
    
    public List<Cliente> get()
    {
        ResultSet res = this.getResult();
        
        try{
            while(res.next()) {
                this.cliente = new Cliente();
                this.cliente.id         = res.getInt("id_cliente");
                this.cliente.nome       = res.getString("nome");
                this.cliente.sobrenome  = res.getString("sobrenome");
                this.cliente.created_at = res.getTimestamp("create_at");
                this.cliente.updated_at = res.getTimestamp("update_at");
                
                this.clientes.add(this.cliente);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.clientes;
    }
}