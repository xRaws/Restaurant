package database.entidades;

import java.util.Date;

public class Funcionario 
{
    public int id;
    
    public String nome;
    
    public String sobrenome;
    
    public String matricula;
    
    public String user;
    
    public String senha;
    
    public int tipo;
    
    public int ativo;
    
    public Date created_at;
    
    public Date updated_at;
    
    public TipoFuncionario getTipoFuncionario()
    {
        return null;
    }
}