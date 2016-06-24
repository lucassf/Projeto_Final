package Implement;

import java.sql.Date;
import java.time.LocalDate;

public class ImpCategories {
    
    private Connection.DatabaseConnection database;
    private int id;
    
    public void SetDatabase(Connection.DatabaseConnection database) {
        this.database = database;
    }
    
    public boolean Insert(String names[]){
        int size = names.length;
        boolean t=true;
        LocalDate now = LocalDate.now();
        Date date = Date.valueOf(now);
        if (size>0) {
            String sql = "select max(idCategorias) as maxid from test.categorias;";
            if (database.ExecuteQuery(sql, new String[]{})) {
                database.NextRegister();
                id = database.GetInt("maxid") + 1;
                String[][] set = new String[3 * size][2];
                sql = "insert into test.categorias (idCategorias,Descricao,"
                + "DataDeCadastro) values ";
                for (int i = 0; i<size; i++) {
                    set[3 * i][0] = "int";
                    set[3 * i][1] = String.valueOf(getId() + i);
                    set[3 * i + 1][0] = "String";
                    set[3 * i + 1][1] = names[i];
                    set[3 * i + 2][0] = "Date";
                    set[3 * i + 2][1] = date.toString();
                    if (i > 0) {
                        sql += ",(?,?,?)";
                    } else {
                        sql += "(?,?,?)";
                    }
                }
                sql += ";";
                if (!database.UpdateQuery(sql, set)) {
                    t = false;
                }
            }else{
                t=false;
            }
        }
        return t;
    }

    public int getId() {
        return id;
    }
}
