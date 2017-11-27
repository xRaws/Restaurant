package database.entidades;

import java.util.Date;

public class Cardapio 
{
    public int id_cardapio;
    
    public int codigo_prato;
    
    public String versao;
    
    public float valor;
    
    public Date created_at;
    
    public Date updated_at;
    
    public Prato getPrato()
    {
        return null;
    }
}