package com.example.android.inventoryapp.data;

import android.provider.BaseColumns;

public class InventoryContract  {
    private InventoryContract(){}

    public static final class ProductEntry implements BaseColumns{
        public final static String TABLE_NAME = "products";
        public static final String _ID = BaseColumns._ID;
        public final static String COLUMN_PRODUCT_NAME = "product_name";
        public final static String COLUMN_PRODUCT_COST = "product_cost";
        public final static String COLUMN_PRODUCT_QUANTITY ="quantity";
        public final static String COLUMN_SUPPLIER_NAME = "supplier_name";
        public final static String COLUMN_SUPPLIER_PHONE ="supplier_phone";
    }
}
