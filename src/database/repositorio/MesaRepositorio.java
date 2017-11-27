package database.repositorio;

import java.util.ArrayList;
import java.util.List;
import database.entidades.Mesa;
import database.querybuild.MesaBuild;

public class MesaRepositorio
{
    private final MesaBuild mesaBuild;
    
    private final List<Mesa> mesas = new ArrayList<>();
    
    public MesaRepositorio()
    {
        mesaBuild = new MesaBuild();
    }
    
    public Mesa getMesa(int id)
    {
        return mesaBuild.find(id);
    }
    
    public Mesa getMesa(int id, String fields)
    {
        return mesaBuild.find(id,fields);
    }
    
    public List<Mesa> getMesas(List<Integer> ids)
    {
        for(Integer c : ids){
             this.mesas.add(mesaBuild.find(c));
        }
        
        return this.mesas;
    }
    
    public List<Mesa> getMesas()
    {
        return this.mesaBuild.all();
    }
    
    public List<Mesa> getMesas(String fields)
    {
        return this.mesaBuild.all(fields);
    }
}
