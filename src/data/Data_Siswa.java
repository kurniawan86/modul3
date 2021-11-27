package data;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import entity.siswa;

import java.util.ArrayList;

public class Data_Siswa
{
    ArrayList <siswa> students;

    public Data_Siswa()
    {
        this.students = new ArrayList<>();
    }

    public void insert(int id, String nm, String password, String waktu)
    {
        siswa objek = new siswa(id,nm,password,waktu);
        this.students.add(objek);
    }

    public void view()
    {
        for (int i = 0; i < this.students.size(); i++)
        {
            System.out.println("===================");
            this.students.get(i).viewData();
            System.out.println("===================");
        }
    }
}
