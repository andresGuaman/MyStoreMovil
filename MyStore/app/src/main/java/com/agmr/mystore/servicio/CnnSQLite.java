package com.agmr.mystore.servicio;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.agmr.mystore.modelo.Favoritos;
import com.agmr.mystore.modelo.Notificaciones;
import com.agmr.mystore.modelo.Usuarios;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CnnSQLite extends SQLiteOpenHelper {

    private static final String DATABASE = "MyStore.db";
    Context context;

    public CnnSQLite(@Nullable Context context) {
        super(context, DATABASE, null, 1);
        this.context = context;

        assert context != null;
        File dbFile =context.getDatabasePath(DATABASE);

        if (!dbFile.exists()) {
            try{
                copyDB(dbFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void copyDB(File db) throws IOException {
        InputStream open =context.getAssets().open(DATABASE);
        OutputStream copy = new FileOutputStream(db);
        byte[] buffer = new byte[1024];
        int length;

        while ((length = open.read(buffer)) > 0) {
            copy.write(buffer, 0, length);
        }
        copy.flush();
        copy.close();
        open.close();
    }

    //Users' Methods

    public Cursor selectUsers() {
        Cursor cursor;
        String sql = "SELECT ROWID as _id, * FROM usuarios";
        cursor = this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public Cursor selectUserByStatus() {
        Cursor cursor;
        String sql = "SELECT ROWID as _id, * FROM usuarios WHERE usu_estado = 1";
        cursor = this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public Cursor selectUserById(int id) {
        Cursor cursor;
        String sql = "SELECT ROWID as _id, * FROM usuarios WHERE usu_id = id";
        cursor = this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public boolean insertUsuario(Usuarios u) {

        String sql = "INSERT INTO usuarios (usu_estado, usu_per_id, usu_rol) " +
                "VALUES('" + u.getUsu_estado() + "','" + u.getUsu_per_id() + "','" + u.getUsu_rol() + "')";
        try {
            this.getWritableDatabase().execSQL(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String sql = "DELETE FROM usuarios WHERE usu_id = id";
        try {
            this.getWritableDatabase().execSQL(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUserStatus(Usuarios u) {
        String sql = "UPDATE usuarios SET usu_estado = '" + u.getUsu_estado() + "' WHERE codigo = '" + u.getUsu_id() + "'";
        try {
            this.getWritableDatabase().execSQL(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Favourites' Methods

    public Cursor selectFavourites() {
        Cursor cursor;
        String sql = "SELECT ROWID as _id, * FROM favoritos";
        cursor = this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public Cursor selectFavouriteById(int id) {
        Cursor cursor;
        String sql = "SELECT ROWID as _id, * FROM favoritos WHERE fav_id = id";
        cursor = this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public boolean insertFavourite(Favoritos f) {

        String sql = "INSERT INTO favoritos (fav_pro_id, fav_estado, usu_id) " +
                "VALUES('" + f.getFav_pro_id() + "','" + f.getFav_estado() + "','" + f.getUsu_id() + "')";
        try {
            this.getWritableDatabase().execSQL(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFavourite(int id) {
        String sql = "DELETE FROM favoritos WHERE fav_id = id";
        try {
            this.getWritableDatabase().execSQL(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateFavouriteStatus(Favoritos f) {
        String sql = "UPDATE favoritos SET fav_estado = '" + f.getFav_estado() + "' WHERE codigo = '" + f.getFav_id() + "'";
        try {
            this.getWritableDatabase().execSQL(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Notifications' Methods

    public Cursor selectNotifications() {
        Cursor cursor;
        String sql = "SELECT ROWID as _id, * FROM notificaciones";
        cursor = this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public Cursor selectNotificationById(int id) {
        Cursor cursor;
        String sql = "SELECT ROWID as _id, * FROM notificaciones WHERE not_id = id";
        cursor = this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public boolean insertNotification(Favoritos f) {

        String sql = "INSERT INTO notificaciones (not_mensaje, not_estado, not_pro_id, usu_id) " +
                "VALUES('" + f.getFav_pro_id() + "','" + f.getFav_estado() + "','" + f.getUsu_id() + "')";
        try {
            this.getWritableDatabase().execSQL(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNotification(int id) {
        String sql = "DELETE FROM notificaciones WHERE not_id = id";
        try {
            this.getWritableDatabase().execSQL(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNotificationsStatus(Notificaciones n) {
        String sql = "UPDATE notificaciones SET not_estado = '" + n.getNot_estado() + "' WHERE codigo = '" + n.getNot_id() + "'";
        try {
            this.getWritableDatabase().execSQL(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {  }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  }
}
