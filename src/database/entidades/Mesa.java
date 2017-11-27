package database.entidades;

import java.util.Date;
import database.repositorio.ClienteRepositorio;

public class Mesa
{
    public int id, lugares, status;
    
    public int id_cliente;
    
    public Date created_at, updated_at;
    
    public Cliente getCliente()
    {
        return new ClienteRepositorio().getCliente(id_cliente);
    }
}