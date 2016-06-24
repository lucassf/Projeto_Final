package Implement;

import Data.Products;

public class ImpProducts {

    private Connection.DatabaseConnection database;
    private String joptionmessage;
    private String errormessage;
    private final String DEFAULTERROR = "Campo obrigatório";
    private final String CATEGORYERROR = "Selecione uma categoria";

    public void SetDatabase(Connection.DatabaseConnection database) {
        this.database = database;
    }

    public boolean Verify(Products p) {
        boolean t = true;
        if (p.getName().isEmpty() || p.getCategoryid().isEmpty()
                || p.getManufacturer().isEmpty() || p.getSender().isEmpty()
                || p.getBuyprice().isEmpty() || p.getPrice().isEmpty()
                || p.getDif().isEmpty()) {
            t = false;
        }
        return t;
    }
    
    public boolean Verify(String txt,String field){
        boolean t = false;
        if (!txt.isEmpty()){
            errormessage = " ";
            t=true;
        } else if (field.equalsIgnoreCase("categoria")){
            errormessage = CATEGORYERROR;
        } else{
            errormessage = DEFAULTERROR;
        }
        return t;
    }

    public String GetJOptionMessage() {
        return joptionmessage;
    }
    
    public String getErrorMessage(){
        return errormessage;
    }

    public boolean Insert(Products p) {
        boolean t = false;
        String sql = "select max(idProdutos) as maxid from test.produtos;";
        if (database.ExecuteQuery(sql, new String[]{})) {
            database.NextRegister();
            int id = database.GetInt("maxid") + 1;
            sql = "insert into test.produtos (idProdutos,Descricao,idCategoria,"
                    + "Margem,PrecoCusto,PrecoVenda,Fabricante,Fornecedor,"
                    + "DataDeCadastro) select ?,?,?,?,?,?,?,?,?;";
            String[][] send = {{"int", String.valueOf(id)},
            {"string", p.getName()},
            {"int", p.getCategoryid()},
            {"double", p.getDif()},
            {"double", p.getBuyprice()},
            {"double", p.getPrice()}, {"string", p.getManufacturer()},
            {"string", p.getSender()},
            {"date", p.getDate()}};
            if (database.UpdateQuery(sql, send)) {
                joptionmessage = "Inserção realizada com sucessso";
                t = true;
            } else {
                joptionmessage = "Erro no banco de dados";
            }
        } else {
            joptionmessage = "Erro no banco de dados";
        }
        return t;
    }

    public boolean Update(Products p) {
        boolean t = false;
        String sql = "update test.produtos set Descricao=?,idCategoria=?,"
                + "Margem=?,PrecoCusto=?,PrecoVenda=?,Fabricante=?,"
                + "Fornecedor=?,DataDeCadastro=? where idProdutos=?;";
        String[][] send = {{"string", p.getName()},
        {"int", p.getCategoryid()},
        {"double", p.getDif()},
        {"double", p.getBuyprice()},
        {"double", p.getPrice()},
        {"string", p.getManufacturer()},
        {"string", p.getSender()},
        {"date", p.getDate()},
        {"int", p.getId()}};
        if (database.UpdateQuery(sql, send)) {
            joptionmessage = "Atualização realizada com sucessso";
            t = true;
        } else {
            joptionmessage = "Erro no banco de dados";
        }
        return t;
    }
}
