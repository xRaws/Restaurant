package database.querybuild;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.entidades.Produto;

public class ProdutoBuild extends BaseBuild
{  
    private String table;
    
    private String primaryKey;
    
    protected List<Produto> produtos;
    
    protected Produto produto;

    public ProdutoBuild() 
    {
        super();
        this.setTable(this.table = "produto");
        this.setPrimaryKey(this.primaryKey = "id_produto");
        
        this.produtos = new ArrayList<>();
    }
    
    public Produto find(int id)
    {   
        query = "SELECT * FROM "+ this.table +" WHERE "+ this.primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    public Produto find(int id, String fields)
    {        
        query = "SELECT "+ fields +" FROM "+ this.table +" WHERE "+ this.primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    private Produto buildFind(String query, int id)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            sttm.setInt(1,id);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.produto = new Produto();
                this.produto.id_produto = res.getInt("id_produto");
                this.produto.quantidade = res.getInt("quantidade");
                this.produto.tipo       = res.getInt("tipo");
                this.produto.nome       = res.getString("nome");
                this.produto.descricao  = res.getString("descricao");
                this.produto.created_at = res.getTimestamp("create_at");
                this.produto.updated_at = res.getTimestamp("update_at");
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.produto;
    }
    
    public List<Produto> all()
    {
        query = "SELECT * FROM "+ table;
        
        return this.buildAll(query);
    }
    
    public List<Produto> all(String fields)
    {
        query = "SELECT "+ fields +" FROM "+ this.table;
        
        return this.buildAll(query);
    }
    
    private List<Produto> buildAll(String query)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.produto = new Produto();
                this.produto.id_produto = res.getInt("id_produto");
                this.produto.quantidade = res.getInt("quantidade");
                this.produto.tipo       = res.getInt("tipo");
                this.produto.nome       = res.getString("nome");
                this.produto.descricao  = res.getString("descricao");
                this.produto.created_at = res.getTimestamp("create_at");
                this.produto.updated_at = res.getTimestamp("update_at");
                
                this.produtos.add(this.produto);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.produtos;
    }
    
    public List<Produto> get()
    {
        
        ResultSet res = this.getResult();
        
        try{
            while(res.next()) {
                this.produto = new Produto();
                this.produto.id_produto = res.getInt("id_produto");
                this.produto.quantidade = res.getInt("quantidade");
                this.produto.tipo       = res.getInt("tipo");
                this.produto.nome       = res.getString("nome");
                this.produto.descricao  = res.getString("descricao");
                this.produto.created_at = res.getTimestamp("create_at");
                this.produto.updated_at = res.getTimestamp("update_at");
                
                this.produtos.add(this.produto);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.produtos;
    }
}