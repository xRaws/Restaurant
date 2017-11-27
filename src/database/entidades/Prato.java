package database.entidades;

import java.util.Date;
import java.util.List;

public class Prato 
{
    public int id_prato;
    
    public String nome;
    
    public String descricao;
    
    public float valor;
    
    public Date created_at;
    
    public Date updated_at;
    
    public List<Produto> getProdutos()
    {
        return null;
    }
}
