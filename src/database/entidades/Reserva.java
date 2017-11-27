package database.entidades;

import database.repositorio.ClienteRepositorio;
import database.repositorio.MesaRepositorio;

public class Reserva 
{
    public int id_mesa;
    
    public int id_cliente;
    
    public int ativa;
    
    public Cliente getCliente()
    {
        return new ClienteRepositorio().getCliente(id_cliente);
    }
    
    public Mesa getMesa()
    {
        return new MesaRepositorio().getMesa(id_mesa);
    }
}