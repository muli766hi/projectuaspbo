package Project.View;

import java.io.*;
import java.util.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Database implements Serializable{
    public static Database instance;
    private Connection connection;
    public static synchronized Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
     }
    // Lokasi file SQLite Anda
    private static final String URL = "jdbc:sqlite:projectpbo.sqlite";

    // Fungsi untuk mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC"); // Memastikan driver JDBC SQLite di-load
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("SQLite JDBC driver tidak ditemukan", e);
        }
    }
    
    private Database(){
     }
     
     public List<String> getUsernameAkun() throws SQLException{
        List<String> usernameList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                usernameList.add(rs.getString("username"));
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }

        return usernameList;
     }
     
     public List<String> getNimAkun() throws SQLException{
        List<String> nimList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                nimList.add(rs.getString("nim"));
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }

        return nimList;
     }
     
    private int getIdAkun() throws SQLException {
        int id = 0;
        Connection conn = getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM users ORDER BY id DESC LIMIT 1");
                    // Create a SQL INSERT statement
                    ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    // Retrieve data from the last row
                    id = resultSet.getInt("id")+1;
                    
                } else {
                    id = 1;
                }
                statement.close();
                conn.close();
                return id;
        } catch(Exception e){
            
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return id;
    }
    
     public int insertAkun(Akun akun)throws SQLException{    
        Connection conn = getConnection();
        int rowsInserted = 0;
        try{
        // Create a SQL INSERT statement
        String sql = "INSERT INTO users (id, nama, NIM, status, username, password, type, konfirmasi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        // Prepare the statement
                PreparedStatement statement = conn.prepareStatement(sql);

                // Set the parameter values
                statement.setString(1,String.valueOf(getIdAkun()));
                statement.setString(2, akun.getNama());
                statement.setString(3, akun.getNim());
                statement.setString(4, akun.getStatus());
                statement.setString(5, akun.getUsername());
                statement.setString(6, akun.getPassword());
                statement.setString(7, akun.getJenis());
                statement.setString(8, akun.getKonfirmasi());

                // Execute the statement
                rowsInserted = statement.executeUpdate();
                
                // Close the resources
                statement.close();
                conn.close();
                return rowsInserted;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
        if(conn!=null){
            conn.close();
        }
        }
    return rowsInserted;
    }
    
    public String login(Akun akun) throws SQLException{    
        Connection conn = getConnection();
        String type = null;
        String konfirmasi = null;
        try {
            // TODO add your handling code here:
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, akun.getUsername());
            statement.setString(2, akun.getPassword());
            
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.isBeforeFirst()){
                while(resultSet.next()) {
                    type= resultSet.getString("type");
                    konfirmasi = resultSet.getString("konfirmasi");
                } 
            } else {
                type = "salah";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        if(konfirmasi == null){
            return type;
        }
        return type+", "+konfirmasi;
    }
    private int getNoBarang() throws SQLException{
        Connection conn = getConnection();
        int no = 0;
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM barang ORDER BY no DESC LIMIT 1");
                    // Create a SQL INSERT statement
                    ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    // Retrieve data from the last row
                    no = resultSet.getInt("no")+1;
                } else {
                    no = 1;
                }
                
                // Close the resources
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return no;
    }
    
    private String getIdBarang() throws SQLException{
        Connection conn = getConnection();
        String id=null;
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM barang ORDER BY no DESC LIMIT 1");
                    // Create a SQL INSERT statement
                    ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    // Retrieve data from the last row
                    int no = resultSet.getInt("no")+1;
                    if(no < 10){
                        id = "00"+ no;
                    } else if( no<100){
                        id = "0"+ no;
                    } else{
                        id = String.valueOf(no);
                    }
                } else {
                    int no = 1;
                    id = "00"+no;
                }
                
                // Close the resources
                statement.close();
                conn.close();
                return id;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return id;
    }
    public boolean insertBarang(Barang barang) throws SQLException{    
        Connection conn = getConnection();
        boolean benar =false;
            try{
                
                String sql = "INSERT INTO barang (no,id,nama,tempat,tanggal,jumlah,status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                 // Prepare the statement
                PreparedStatement statement = conn.prepareStatement(sql);

                // Set the parameter values
                statement.setInt(1, getNoBarang());
                statement.setString(2, barang.getID()+getIdBarang());
                statement.setString(3, barang.getNama());
                statement.setString(4, barang.getTempat());
                statement.setString(5, String.valueOf(barang.getTanggal()));
                statement.setInt(6, barang.getJumlah());
                statement.setString(7, barang.getStatus());

                // Execute the statement
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    benar = true;
                }
                
                // Close the resources
                statement.close();
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return benar;
    }
    public boolean editBarang(Barang barang) throws SQLException{    
        Connection conn = getConnection();
        boolean benar =false;
            try {
                String sql = "UPDATE barang SET nama = ?, tempat = ?, tanggal = ?, jumlah = ?, status = ? WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, barang.getNama());
                statement.setString(2, barang.getTempat());
                statement.setString(3, String.valueOf(barang.getTanggal()));
                statement.setInt(4, barang.getJumlah());
                statement.setString(5, barang.getStatus());
                statement.setInt(6, Integer.parseInt(barang.getID()));
                
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    benar = true;
                } else {
                    benar = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return benar;
    }
    public Barang cariBarang(String id) throws SQLException{   
        Connection conn = getConnection();
        Barang barang = new Barang();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            String sql = "SELECT * FROM barang WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();
            
            
            if (!resultSet.isBeforeFirst()) {
                barang.setTempat("Id tidak ditemukkan!");
            } else{
                while (resultSet.next()) {
                    // Retrieve data from the current row
                    barang.setNama(resultSet.getString("nama"));
                    barang.setTanggal(resultSet.getString("tanggal"));
                    barang.setJumlah(resultSet.getInt("jumlah"));
                    barang.setStatus(resultSet.getString("status"));
                }
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return barang;
    } 
    public boolean hapusBarang(Barang barang) throws SQLException{    
        Connection conn = getConnection();
        boolean benar =false;
            try {
                Statement statement = conn.createStatement();

                String sql = "DELETE FROM barang WHERE id = " +barang.getID();

                int rowsAffected = statement.executeUpdate(sql);

                if (rowsAffected > 0) {
                    benar = true;
                } else {
                    benar = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return benar;
    }
     public List<Barang> getListBarang() throws SQLException{
        List<Barang> barangList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM barang";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Barang barang = new Barang();
                barang.setID(rs.getString("id"));
                barang.setNama(rs.getString("nama"));
                barang.setTempat(rs.getString("tempat"));
                barang.setTanggal(rs.getString("tanggal"));
                barang.setJumlah(rs.getInt("jumlah"));
                barang.setStatus(rs.getString("status"));

                barangList.add(barang);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }

        return barangList;
     }
     
     public boolean konfirmasiAkun(Akun akun) throws SQLException{
        Connection conn = getConnection();
        boolean benar = false;
        try {
            String sql = "UPDATE users SET konfirmasi = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, akun.getKonfirmasi());
            statement.setString(2, akun.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                benar = true;
            } else {
                benar = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return benar;
     }
     
     public boolean hapusAkun(String id) throws SQLException{
        Connection conn = getConnection();
        boolean benar = false;
        try {
            Statement statement = conn.createStatement();

                String sql = "DELETE FROM users WHERE id = " +id;

                int rowsAffected = statement.executeUpdate(sql);

                if (rowsAffected > 0) {
                    benar = true;
                } else {
                    benar = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return benar;
     }
     
    public Akun cariAkun(String id) throws SQLException{   
        Connection conn = getConnection();
        Akun akun = new Akun();
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                akun.setUsername("Data tidak ditemukan!");
            } else {
                while (resultSet.next()) {
                    // Retrieve data from the current row
                    akun.setNama(resultSet.getString("nama"));
                    akun.setNim(resultSet.getString("NIM"));
                    akun.setStatus(resultSet.getString("status"));
                    akun.setJenis(resultSet.getString("type"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return akun;
    }
     
    
    public boolean editAkun(Akun akun) throws SQLException{    
        Connection conn = getConnection();
        boolean benar =false;
            try {
                String sql = "UPDATE users SET nama = ?, NIM = ?, status = ?, type = ? WHERE id = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, akun.getNama());
                statement.setString(2, akun.getNim());
                statement.setString(3, akun.getStatus());
                statement.setString(4, akun.getJenis());
                statement.setInt(5, Integer.parseInt(akun.getId()));
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    benar = true;
                } else {
                    benar = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return benar;
    }
     
     public List<Akun> getListAkun() throws SQLException{
        List<Akun> akunList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Akun akun = new Akun();
                akun.setId(rs.getString("id"));
                akun.setNama(rs.getString("nama"));
                akun.setJenis(rs.getString("type"));
                akun.setKonfirmasi(rs.getString("konfirmasi"));
                akun.setStatus(rs.getString("status"));
                akun.setNim(rs.getString("NIM"));

                akunList.add(akun);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }

        return akunList;
     }
}