package konektor;
import java.sql.*;

public class koneksiDB
{
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3306/db_siswa";

    public Connection koneksi() throws SQLException
    {
        Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
        if (con!=null)
        {
            System.out.println("koneksi berhasil");
        }
        else
        {
            System.out.println("Koneksi tidak berhasil");
        }
        return con;
    }
}
