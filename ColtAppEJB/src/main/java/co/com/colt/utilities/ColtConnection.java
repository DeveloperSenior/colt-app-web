/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.colt.utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ColtConnection {
    
   private static final ResourceBundle NAMES = ResourceBundle.getBundle("co.com.colt.properties.ColtConnection");
   private static final String DB_DRIVER = "DB_DRIVER"; 
    
    static {
        try {
            Class.forName(NAMES.getString(DB_DRIVER)).newInstance();
        } catch (ClassNotFoundException e1) {
             e1.printStackTrace(System.err);
             JOptionPane.showMessageDialog(null,"ClassNotFoundException" + e1.getMessage());
        } catch (InstantiationException e2) {
            JOptionPane.showMessageDialog(null,"InstantiationException" + e2.getMessage());
        } catch (IllegalAccessException e3) {
           JOptionPane.showMessageDialog(null,"IllegalAccessException" + e3.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Exception" + e.getMessage());
        }
    }
    
     public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(getUrl(), NAMES.getString("colt.user"),NAMES.getString("colt.password"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error critico al obtener la conexion a la base de datos");
            throw new SQLException(ex);
        }
    }

    private String getUrl() {
        return "jdbc:mysql://" + NAMES.getString("colt.host") + ":" + NAMES.getString("colt.port") + "/" + NAMES.getString("colt.bd");
    }
    
    public Connection getConnection(String URL, String USER, String PASSWORD)
            throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeResources(Connection connection, CallableStatement ocs) {
        try {
            if (ocs != null) {
                ocs.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error critico cerrando recursos");
        } finally {
            closeResources(connection);
        }
    }

    public void closeResources(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error critico cerrando recursos");
        }
    }

    public void closeResources(Connection connection, PreparedStatement ps) {
        try {
            closeResources(ps);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error critico cerrando recursos");
        } finally {
            closeResources(connection);
        }
    }

    public void closeResources(Connection connection, PreparedStatement ps, ResultSet rs) {
        try {
            closeResources(rs);
            closeResources(ps);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error critico cerrando recursos");
        } finally {
            closeResources(connection);
        }
    }

    public void closeResources(Connection connection, Statement ps, ResultSet rs) {
        try {
            closeResources(rs);
            closeResources(ps);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error critico cerrando recursos");
        } finally {
            closeResources(connection);
        }
    }

    public void closeResources(ResultSet rs) {
        try {
            if ((rs != null)
                    && (!rs.isClosed())) {
                rs.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error critico cerrando recursos");
        }
    }

    public void closeResources(Statement ps) {
        try {
            if ((ps != null)
                    && (!ps.isClosed())) {
                ps.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error critico cerrando recursos");
        }
    }

    public void closeResources(PreparedStatement ps) {
        try {
            if ((ps != null)
                    && (!ps.isClosed())) {
                ps.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error critico cerrando recursos");
        }
    }
    
}
