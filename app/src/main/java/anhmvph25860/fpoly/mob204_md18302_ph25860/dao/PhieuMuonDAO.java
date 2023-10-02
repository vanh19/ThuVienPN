package anhmvph25860.fpoly.mob204_md18302_ph25860.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import anhmvph25860.fpoly.mob204_md18302_ph25860.database.DbHelper;
import anhmvph25860.fpoly.mob204_md18302_ph25860.model.PhieuMuon;

public class PhieuMuonDAO {
    DbHelper dbHelper;
    public PhieuMuonDAO(Context context){
        dbHelper = new DbHelper(context);
    }
    public ArrayList<PhieuMuon> getDSPhieuMuon(){
        ArrayList<PhieuMuon> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT pm.mapm, pm.matv, tv.hoten, pm.matt, tt.hoten, pm.masach, sc.tensach, pm.ngay, pm.trasach, pm.tienthue FROM PHIEUMUON pm, THANHVIEN tv, THUTHU tt, SACH sc WHERE pm.matv = tv.matv and pm.matt = tt.matt AND pm.masach = sc.masach ORDER BY pm.mapm DESC", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new PhieuMuon(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5),cursor.getString(6), cursor.getString(7), cursor.getInt(8), cursor.getInt(9)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean thaydoiTrangThai(int mapm){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("trasach",1);
        long check = sqLiteDatabase.update("PHIEUMUON", contentValues, "mapm = ?", new String[]{String.valueOf(mapm)});
        if (check == -1){
            return false;
        }else {
            return true;
        }
    }
    public boolean themPhieuMuon(PhieuMuon phieuMuon){
        SQLiteDatabase sqLiteDatabase1 = dbHelper.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        //contentValues1.put("mapm", phieuMuon.getMapm());
        contentValues1.put("matv", phieuMuon.getMatv());
        contentValues1.put("matt", phieuMuon.getMatt());
        contentValues1.put("masach", phieuMuon.getMasach());
        contentValues1.put("ngay", phieuMuon.getNgay());
        contentValues1.put("trasach", phieuMuon.getTrasach());
        contentValues1.put("tienthue", phieuMuon.getTienthue());


        long check = sqLiteDatabase1.insert("PHIEUMUON", null, contentValues1);
        if (check == -1){
            return false;
        }
        return true;
    }
}


