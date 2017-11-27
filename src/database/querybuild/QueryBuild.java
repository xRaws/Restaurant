package database.querybuild;

public class QueryBuild extends BaseBuild
{
    public QueryBuild()
    {
    
    }
    public QueryBuild(String table, String primaryKey)
    {
        super();
        this.setTable(table);
        this.setPrimaryKey(primaryKey);
    }
}
