package database.querybuild;

import java.util.List;
import database.entidades.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioBuild extends BaseBuild
{  
    private String table;
    
    private String primaryKey;
    
    private Funcionario funcionario;
    
    private List<Funcionario> funcionarios;
    
    public FuncionarioBuild()
    {
        super();
        this.setTable(this.table = "funcionario");
        this.setPrimaryKey(this.primaryKey = "id_funcionario");
        
        this.funcionarios = new ArrayList<>();
    }
    
    public Funcionario find(int id)
    {   
        query = "SELECT * FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    public Funcionario find(int id, String fields)
    {        
        query = "SELECT "+ fields +" FROM "+ table +" WHERE "+ primaryKey +" = ?";
        
        return this.buildFind(query, id);
    }
    
    private Funcionario buildFind(String query, int id)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            sttm.setInt(1,id);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.funcionario = new Funcionario();
                this.funcionario.id = res.getInt("id_funcionario");
                this.funcionario.nome = res.getString("nome_funcionario");
                this.funcionario.user       = res.getString("user");
                this.funcionario.senha       = res.getString("senha");
                this.funcionario.ativo       = res.getInt("ativo");
                this.funcionario.tipo       = res.getInt("tipo_funcionario");
                this.funcionario.created_at = res.getTimestamp("create_at");
                this.funcionario.updated_at = res.getTimestamp("update_at");
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.funcionario;
    }
    
    public List<Funcionario> all()
    {
        query = "SELECT * FROM "+ table;
        
        return this.buildAll(query);
    }
    
    public List<Funcionario> all(String fields)
    {
        query = "SELECT "+ fields +" FROM "+ table;
        
        return this.buildAll(query);
    }
    
    private List<Funcionario> buildAll(String query)
    {
        try{
            PreparedStatement sttm = this.con.prepareStatement(query);
            ResultSet res = sttm.executeQuery();
            
            while(res.next()) {
                this.funcionario = new Funcionario();
                this.funcionario.id = res.getInt("id_funcionario");
                this.funcionario.nome = res.getString("nome_funcionario");
                this.funcionario.user       = res.getString("user");
                this.funcionario.senha       = res.getString("senha");
                this.funcionario.ativo       = res.getInt("ativo");
                this.funcionario.tipo       = res.getInt("tipo_funcionario");
                this.funcionario.created_at = res.getTimestamp("create_at");
                this.funcionario.updated_at = res.getTimestamp("update_at");
                
                this.funcionarios.add(this.funcionario);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.funcionarios;
    }
    
    public List<Funcionario> get()
    {
        ResultSet res = this.getResult();
        
        try{
            while(res.next()) {
                this.funcionario = new Funcionario();
                this.funcionario.id = res.getInt("id_funcionario");
                this.funcionario.nome = res.getString("nome_funcionario");
                this.funcionario.user       = res.getString("user");
                this.funcionario.senha       = res.getString("senha");
                this.funcionario.ativo       = res.getInt("ativo");
                this.funcionario.tipo       = res.getInt("tipo_funcionario");
                this.funcionario.created_at = res.getTimestamp("create_at");
                this.funcionario.updated_at = res.getTimestamp("update_at");
                
                this.funcionarios.add(this.funcionario);
            }
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
        return this.funcionarios;
    }
}