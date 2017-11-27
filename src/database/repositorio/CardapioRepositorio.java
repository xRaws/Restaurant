package database.repositorio;

import java.util.ArrayList;
import java.util.List;
import database.entidades.Cardapio;
import database.querybuild.CardapioBuild;

public class CardapioRepositorio
{
    private final CardapioBuild cardapioBuild;
    
    private final List<Cardapio> cardapios = new ArrayList<>();
    
    public CardapioRepositorio()
    {
        cardapioBuild = new CardapioBuild();
    }
    
    public Cardapio getCardapio(int id)
    {
        return cardapioBuild.find(id);
    }
    
    public Cardapio getCardapio(int id, String fields)
    {
        return cardapioBuild.find(id,fields);
    }
    
    public List<Cardapio> getCardapios(List<Integer> ids)
    {
        for(Integer c : ids){
             this.cardapios.add(cardapioBuild.find(c));
        }
        
        return this.cardapios;
    }
    
    public List<Cardapio> getCardapios()
    {
        return this.cardapioBuild.all();
    }
    
    public List<Cardapio> getCardapios(String fields)
    {
        return this.cardapioBuild.all(fields);
    }
}