package com.usc.cine.bedoyamarin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Helper de SQLite para crear y administrar la base de datos local.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "cine_usc.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_ENTRADAS = "entradas_cine";

    public static final String COL_ID = "id";
    public static final String COL_NOMBRE_PELICULA = "nombre_pelicula";
    public static final String COL_NOMBRE_CINE = "nombre_cine";
    public static final String COL_NUMERO_SALA = "numero_sala";
    public static final String COL_FECHA = "fecha";
    public static final String COL_HORA = "hora";
    public static final String COL_NUMERO_ENTRADAS = "numero_entradas";
    public static final String COL_COSTO_TOTAL = "costo_total";
    public static final String COL_ESTUDIANTE = "estudiante";

    public AdminSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_ENTRADAS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NOMBRE_PELICULA + " TEXT NOT NULL, " +
                COL_NOMBRE_CINE + " TEXT NOT NULL, " +
                COL_NUMERO_SALA + " TEXT NOT NULL, " +
                COL_FECHA + " TEXT NOT NULL, " +
                COL_HORA + " TEXT NOT NULL, " +
                COL_NUMERO_ENTRADAS + " INTEGER NOT NULL, " +
                COL_COSTO_TOTAL + " REAL NOT NULL, " +
                COL_ESTUDIANTE + " TEXT NOT NULL" +
                ");";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENTRADAS);
        onCreate(db);
    }

    public long insertarEntrada(EntradaCine entrada) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOMBRE_PELICULA, entrada.getNombrePelicula());
        values.put(COL_NOMBRE_CINE, entrada.getNombreCine());
        values.put(COL_NUMERO_SALA, entrada.getNumeroSala());
        values.put(COL_FECHA, entrada.getFecha());
        values.put(COL_HORA, entrada.getHora());
        values.put(COL_NUMERO_ENTRADAS, entrada.getNumeroEntradas());
        values.put(COL_COSTO_TOTAL, entrada.getCostoTotal());
        values.put(COL_ESTUDIANTE, entrada.getEstudiante());
        return db.insert(TABLE_ENTRADAS, null, values);
    }

    public EntradaCine obtenerEntradaPorId(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_ID + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};

        Cursor cursor = db.query(TABLE_ENTRADAS, null, selection, selectionArgs,
                null, null, null);

        EntradaCine entrada = null;
        if (cursor.moveToFirst()) {
            entrada = new EntradaCine(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_NOMBRE_PELICULA)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_NOMBRE_CINE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_NUMERO_SALA)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_FECHA)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_HORA)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(COL_NUMERO_ENTRADAS)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(COL_COSTO_TOTAL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_ESTUDIANTE))
            );
        }
        cursor.close();
        return entrada;
    }

    public int actualizarEntrada(int id, EntradaCine entrada) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOMBRE_PELICULA, entrada.getNombrePelicula());
        values.put(COL_NOMBRE_CINE, entrada.getNombreCine());
        values.put(COL_NUMERO_SALA, entrada.getNumeroSala());
        values.put(COL_FECHA, entrada.getFecha());
        values.put(COL_HORA, entrada.getHora());
        values.put(COL_NUMERO_ENTRADAS, entrada.getNumeroEntradas());
        values.put(COL_COSTO_TOTAL, entrada.getCostoTotal());
        values.put(COL_ESTUDIANTE, entrada.getEstudiante());
        return db.update(TABLE_ENTRADAS, values, COL_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public int eliminarEntrada(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_ENTRADAS, COL_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
}
