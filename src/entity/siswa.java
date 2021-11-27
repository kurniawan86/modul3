package entity;

public class siswa
{
    private int id;
    private String nama;
    private String pass;
    private String date;

    public siswa(int id, String nm, String password, String waktu)
    {
        this.id = id;
        this.nama = nm;
        this.pass = password;
        this.date = waktu;
    }

    public void viewData()
    {
        System.out.println("nama : "+this.nama);
        System.out.println("id : "+this.id);
        System.out.println("waktu pendaftaran : "+this.date);
    }

    public int getID()
    {
        return this.id;
    }
}
