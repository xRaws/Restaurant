package database.entidades;

import java.util.Date;

public class Produto 
{
    public int id_produto;
    
    public int tipo;
    
    public int quantidade;
    
    public String nome;
    
    public String descricao;
    
    public Date created_at;
    
    public Date updated_at;
    
    public TipoProduto getTipo()
    {
        return null;
    }
}