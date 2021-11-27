package model;
import data.Data_Siswa;
import konektor.koneksiDB;

import java.sql.*;

public class crud
{
    Connection konek;
    Statement stat;
    Data_Siswa data;

    public crud() throws SQLException
    {
        koneksiDB koneksi = new koneksiDB();
        this.konek = koneksi.koneksi();
        this.stat = this.konek.createStatement();
        this.data = new Data_Siswa();
        this.setData();
    }

    public void viewData()
    {
        this.data.view();
    }

    private void setData()
    {
        try
        {
            String sql = "SELECT * FROM siswa";
            ResultSet rs = this.stat.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String pass = rs.getString("password");
                String date = rs.getString("waktu");
                this.data.insert(id,nama,pass,date);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void tambahData(String nama, String pass, String waktu) throws SQLException {
        String sql = "INSERT INTO siswa(id,nama,password,waktu) VALUES(?,?,?,?)";
        PreparedStatement prepared =  this.konek.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        prepared.setInt(1,0);
        prepared.setString(2, nama);
        prepared.setString(3, pass);
        prepared.setString(4, waktu);
        prepared.executeUpdate();
        this.setData();
    }
}
