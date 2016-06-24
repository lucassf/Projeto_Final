package Implement;

import Data.Providers;

public class ImpProviders {

    Connection.DatabaseConnection database = new Connection.DatabaseConnection();
    private String joptionmessage;
    private String errormessage;
    private final String DEFAULTERROR = "Campo obrigatório";
    private final String CNPJERROR = "Cnpj inválido";
    private final String EMAILERROR = "Email inválido";
    private final String PHONEERROR = "Telefone inválido";

    public void setDatabase(Connection.DatabaseConnection database) {
        this.database = database;
    }
    
    public String getMessage(){
        return joptionmessage;
    }
    
    public String getErrorMessage(){
        return errormessage;
    }
    
    public boolean Verify(String txt,String field){
        boolean t= false;
        if (field.equalsIgnoreCase("cnpj")&&!VerifyCnpj(txt)){
            errormessage = CNPJERROR;
        } else if (field.equalsIgnoreCase("email")&&!VerifyEmail(txt)){
            errormessage = EMAILERROR;
        }else if (field.equalsIgnoreCase("phone")){
            errormessage = PHONEERROR;
        } else if (txt.isEmpty()){
            errormessage = DEFAULTERROR;
        }
        else{
            errormessage = " ";
            t = true;
        }
        return t;
    }

    public boolean VerifyCnpj(String cnpj) {
        if (cnpj.length() != 14) {
            return false;
        }
        boolean t = false;
        int k = 0;
        int q = 0;
        int first, second, now;
        for (int i = 0; i < 12; i++) {
            now = cnpj.charAt(i) - '0';
            k += (i < 4) ? now * (5 - i) : now * (13 - i);
            q += (i < 5) ? now * (6 - i) : now * (14 - i);
        }
        k = k % 11;
        first = k < 2 ? 0 : 11 - k;
        q = (q + first * 2) % 11;
        second = q < 2 ? 0 : 11 - q;
        if (first == cnpj.charAt(12) - '0' && second == cnpj.charAt(13) - '0') {
            t = true;
        }
        return t;
    }

    public boolean VerifyEmail(String email) {
        boolean t = true;
        for (int i=0;i<email.length();i++){
            
        }

        return t;
    }

    public boolean Verify(Providers p) {
        boolean t = false;
        if (!p.getName().isEmpty() && VerifyCnpj(p.getCnpj()) && !p.getState().isEmpty()
                && !p.getPhone1().isEmpty() && !p.getEmail().isEmpty()) {
            t = true;
        }
        return t;
    }

    public boolean Insert(Providers p) {
        boolean t = false;
        String sql = "select max(idFornecedores) as maxid from test.fornecedores;";
        if (database.ExecuteQuery(sql, new String[]{})) {
            database.NextRegister();
            int id = database.GetInt("maxid") + 1;
            sql = "insert into test.fornecedores (idFornecedores,Nome,Cnpj,"
                    + "Endereco,Estado,Cidade,Bairro,Telefone1,Telefone2,Email,"
                    + "DataDeCadastro) select ?,?,?,?,?,?,?,?,?,?,?;";
            String[][] send = {{"int", String.valueOf(id)},
            {"string", p.getName()},
            {"string", p.getCnpj()},
            {"string", p.getAddress()},
            {"string", p.getState()},
            {"string", p.getCity()},
            {"string", p.getNeighborhood()},
            {"string", p.getPhone1()},
            {"string", p.getPhone2()},
            {"string", p.getEmail()},
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
    
    public boolean Update(Providers p){
        boolean t = false;
        String sql = "update test.fornecedores set Nome=?,Cnpj=?,"
                + "Endereco=?,Estado=?,Cidade=?,Bairro=?,Telefone1=?,"
                + "Telefone2=?,Email=? where idFornecedores=?;";
        String[][] send = {{"string", p.getName()},
            {"string", p.getCnpj()},
            {"string", p.getAddress()},
            {"string", p.getState()},
            {"string", p.getCity()},
            {"string", p.getNeighborhood()},
            {"string", p.getPhone1()},
            {"string", p.getPhone2()},
            {"string", p.getEmail()},
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
