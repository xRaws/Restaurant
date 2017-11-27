package database.repositorio;

import java.util.ArrayList;
import java.util.List;
import database.entidades.Cliente;
import database.querybuild.ClienteBuild;

public class ClienteRepositorio
{
    private final ClienteBuild clienteBuild;
    
    private final List<Cliente> clientes = new ArrayList<>();
    
    public ClienteRepositorio()
    {
        clienteBuild = new ClienteBuild();
    }
    
    public Cliente getCliente(int id)
    {
        return clienteBuild.find(id);
    }
    
    public Cliente getCliente(int id, String fields)
    {
        return clienteBuild.find(id,fields);
    }
    
    public List<Cliente> getClientes(List<Integer> ids)
    {
        for(Integer c : ids){
             this.clientes.add(clienteBuild.find(c));
        }
        
        return this.clientes;
    }
    
    public List<Cliente> getClientes()
    {
        return this.clienteBuild.all();
    }
    
    public List<Cliente> getClientes(String fields)
    {
        return this.clienteBuild.all(fields);
    }
}
