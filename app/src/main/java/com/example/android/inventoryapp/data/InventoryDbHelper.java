package com.example.android.inventoryapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InventoryDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "inventory.db";
    private static final int DATABASE_VERSION = 1;

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PRODUCTS_TABLE =  "CREATE TABLE " + InventoryContract.ProductEntry.TABLE_NAME + " ("
                + InventoryContract.ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + InventoryContract.ProductEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + InventoryContract.ProductEntry.COLUMN_PRODUCT_COST + " INTEGER NOT NULL, "
                + InventoryContract.ProductEntry.COLUMN_PRODUCT_QUANTITY + " INTEGER NOT NULL, "
                + InventoryContract.ProductEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL, "
                + InventoryContract.ProductEntry.COLUMN_SUPPLIER_PHONE + " LONG NOT NULL);";

        db.execSQL(SQL_CREATE_PRODUCTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
