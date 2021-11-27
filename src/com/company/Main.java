package com.company;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import model.crud;

import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    crud manipulated;
    Scanner input;

    public Main() throws SQLException {
        manipulated = new crud();
        input = new Scanner(System.in);
    }

    private void menu_program() throws SQLException {
        System.out.println("=================================");
        System.out.println("selamat datang pada TUGAS MODUL 3");
        System.out.println("=================================");
        int pilih = 100;
        while (pilih != 0)
        {
            menu_pilihan();
            System.out.print("masukkan pilihan: ");
            pilih = this.input.nextInt();
            pilihan(pilih);
        }
    }
    private void pilihan(int pilih)
    {

        switch (pilih)
        {
            case 1:
                System.out.println("masuk menu view data");
                this.manipulated.viewData();
                break;
            case 2:
                System.out.println("masuk menu insert data");
                System.out.print("masukkan nama: ");
                String nama = this.input.next();
                System.out.print("masukkan pass: ");
                String pass = this.input.next();
                System.out.print("masukkan waktu (dd-mm-yyyy): ");
                String date = this.input.next();
                try
                {
                    this.manipulated.tambahData(nama, pass, date);
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("masuk menu pilihan 3");
                break;
            case 4:
                System.out.println("masuk menu pilihan 4");
                break;
            case 0:
                System.out.println("EXIT");
                break;
            default:
                System.out.println("pilihan anda tidak ada");
                break;
        }
    }
    private static void menu_pilihan()
    {
        System.out.println("===================");
        System.out.println("1. menu tampil data");
        System.out.println("2. menu insert data");
        System.out.println("3. menu update data");
        System.out.println("4. menu delete data");
        System.out.println("0. menu exit");
        System.out.println("===================");
    }
    public static void main(String[] args) throws SQLException
    {
        Main utama = new Main();
        utama.menu_program();
    }
}
