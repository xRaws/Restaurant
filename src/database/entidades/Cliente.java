package database.entidades;

import java.util.Date;
import database.querybuild.ClienteBuild;
import database.repositorio.ClienteRepositorio;

public class Cliente
{    
    public int id;
    
    public String nome, sobrenome;
    
    public Date created_at, updated_at;  
}