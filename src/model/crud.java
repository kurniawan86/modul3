package model;
import konektor.koneksiDB;

import java.sql.*;

public class crud
{
    Connection konek;
    Statement stat;

    public crud() throws SQLException
    {
        koneksiDB koneksi = new koneksiDB();
        this.konek = koneksi.koneksi();
        this.stat = this.konek.createStatement();
    }
    public void viewData()
    {
        try
        {
            String sql = "SELECT * FROM siswa";
            ResultSet rs = this.stat.executeQuery(sql);
            while(rs.next())
            {
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("nama: "+rs.getString("nama"));
                System.out.println("tanggal: "+rs.getString("waktu"));
                System.out.println("===================================");
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
    }
}
