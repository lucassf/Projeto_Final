package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class DatabaseConnection {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet result;
    private String Message = "";

    public boolean InitConnection() {
        boolean conected = false;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/mysql";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", "1(d0uBleKaGe)#19");
            conected = true;
        } catch (SQLException sql) {
            System.out.println("Erro no banco\n" + sql.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println("Erro no driver\n" + cnf.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conected;
    }

    public boolean NextRegister() {
        boolean ret = false;
        try {
            ret = result.next();
        } catch (Exception e) {
            Message = e.getMessage();
        }
        return ret;
    }

    public String GetString(String name) {
        String s = null;
        try {
            s = result.getString(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public int GetInt(String name) {
        int s = 0;
        try {
            s = result.getInt(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public double GetDouble(String name) {
        double s = 0;
        try {
            s = result.getDouble(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public Date GetDate(String name) {
        Date s = null;
        try {
            s = result.getDate(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public boolean ExecuteQuery(String SQL, String[] s) {
        boolean func = false;
        try {
            pstm = con.prepareStatement(SQL);
            if (s != null) {
                int size = s.length;
                for (int i = 0; i < size; i++) {
                    pstm.setString(i + 1, s[i]);
                }
            }
            result = pstm.executeQuery();
            func = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return func;
    }

    public boolean UpdateQuery(String SQL, String[][] s) {
        boolean func = false;
        try {
            pstm = con.prepareStatement(SQL);
            if (s != null) {
                int size = s.length;
                for (int i = 0; i < size; i++) {
                    if (s[i][0].equalsIgnoreCase("string")) {
                        pstm.setString(i + 1, s[i][1]);
                    } else if (s[i][0].equalsIgnoreCase("int")) {
                        pstm.setInt(i + 1, Integer.parseInt(s[i][1]));
                    } else if (s[i][0].equalsIgnoreCase("double")) {
                        pstm.setDouble(i + 1, Double.parseDouble(s[i][1]));
                    } else if (s[i][0].equalsIgnoreCase("date")) {
                        pstm.setDate(i + 1, Date.valueOf(s[i][1]));
                    }
                }
            }
            pstm.executeUpdate();
            func = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return func;
    }

    public void CloseConection() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar o banco\n" + e.getMessage());
        }
    }
}
