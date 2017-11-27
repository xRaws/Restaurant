package database.entidades;

import java.util.Date;

public class Pedido 
{
    public int id_pedido;
    
    public int id_cardapio;
    
    public int id_funcionario;
    
    public int status;
    
    public Date created_at;
    
    public Date updated_at;
    
    public Cardapio getCardapio()
    {
        return null;
    }
    
    public Funcionario getFuncionario()
    {
        return null;
    }
    
    public Status getStatus()
    {
        return null;
    }
}