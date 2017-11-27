package database.querybuild;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.DataBaseConexao;
import java.sql.Statement;

public abstract class BaseBuild 
{
    private String table;
    
    private String primaryKey;
    
    protected String query;
    
    protected final Connection con;
    
    protected PreparedStatement sttm;
    
    private final List<String> where = new ArrayList<>();
    
    private final List<String> fields = new ArrayList<>();
    
    private int limit;
    
    private String orderBy = "";
    
    protected String sql;
    
    public BaseBuild()
    {
        con = DataBaseConexao.getConexao();
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    
    
    public void where(String field,String value)
    {
        this.where.add(field+" = "+value);
    }
    
    public void where(String field, String operator, String value)
    {
        this.where.add(field+" "+operator+" "+value);
    }
    
    public void select(String field)
    {
        this.fields.add(field);
    }
    
    public void orderBy(String field)
    {
        this.orderBy = " ORDER BY " + field + " ASC ";
    }
    
    public void orderBy(String field, String direction)
    {
        this.orderBy = " ORDER BY " + field + " " + direction.toUpperCase();
    }
    
    public void limit(int value)
    {
        this.limit = value;
    }
    
    public String toSql()
    {
        String sqlIn = "SELECT ";
        int i = 0;
        if (this.fields.size() > 0){
        for( String f : this.fields) {
            if (i < (this.fields.size() - 1) && this.fields.size() > 0) {
                sqlIn += f + " , ";
            } else {
                sqlIn += f;
            }
            i++;
        }
        } else { sqlIn += "*";}
        
        sqlIn += " FROM " + this.table;
        
        if (this.where.size() > 0) {
            sqlIn += " WHERE ";
        }
        
        i = 0;
        
        for( String w : this.where) {
            if (i < (this.where.size() - 1) && this.where.size() > 0) {
                sqlIn += w + " AND ";
            } else {
                sqlIn += w;
            }
            i++;
        }
        
        if ( this.orderBy.length() > 0 ) {
            sqlIn += this.orderBy;
        }
        
        if (this.limit > 0) {
            sqlIn += " LIMIT "+ this.limit;
        }
        
        return sqlIn;
    }
    
    public ResultSet getResult()
    {
        try{
            sttm = con.prepareStatement(this.toSql());
            return sttm.executeQuery();
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
    }
    
    public ResultSet getResult(String sql)
    {
        try{
            sttm = con.prepareStatement(sql);
            return sttm.executeQuery();
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
    }
    
    public boolean delete(String id)
    {
        try{
            String query = "DELETE FROM "+ this.table +" WHERE "+ this.primaryKey +" = " + id;
            
            PreparedStatement smtt = this.insert(query);
            return smtt.execute();
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean update(String sql)
    {
        try{
            PreparedStatement smtt = this.insert(sql);
            return smtt.execute();
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public PreparedStatement insert(String sql)
    {
        try{
            return con.prepareStatement(sql);
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
    }
}
