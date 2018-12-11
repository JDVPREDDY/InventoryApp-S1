package com.example.android.inventoryapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.inventoryapp.data.InventoryContract;
import com.example.android.inventoryapp.data.InventoryDbHelper;

public class EditorActivity extends AppCompatActivity {
    private EditText mPNameEditText;

    private EditText mCostEditText;

    private EditText mQuantityEditText;

    private EditText mSNameEditText;

    private EditText mPhoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        mPNameEditText = (EditText) findViewById(R.id.edit_product_name);
        mCostEditText = (EditText) findViewById(R.id.edit_product_cost);
        mQuantityEditText = (EditText) findViewById(R.id.edit_inventory_quantity);
        mSNameEditText = (EditText) findViewById(R.id.edit_supplier_name);
        mPhoneEditText =(EditText) findViewById(R.id.edit_supplier_phone);
    }

    private void insertProduct() {
        String pnameString = mPNameEditText.getText().toString().trim();
        String costString = mCostEditText.getText().toString().trim();
        String snameString = mSNameEditText.getText().toString().trim();
        String phoneString = mPhoneEditText.getText().toString().trim();
        String quantityString = mQuantityEditText.getText().toString().trim();
        int quantity = Integer.parseInt(quantityString);
        long phone = Long.parseLong(phoneString);
        int cost = Integer.parseInt(costString);
// Create database helper
        InventoryDbHelper mDbHelper = new InventoryDbHelper(this);
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(InventoryContract.ProductEntry.COLUMN_PRODUCT_NAME, pnameString);
        values.put(InventoryContract.ProductEntry.COLUMN_PRODUCT_COST, cost);
        values.put(InventoryContract.ProductEntry.COLUMN_PRODUCT_QUANTITY, quantity);
        values.put(InventoryContract.ProductEntry.COLUMN_SUPPLIER_NAME, snameString);
        values.put(InventoryContract.ProductEntry.COLUMN_SUPPLIER_PHONE, phone);
        // Insert a new row for product in the database, returning the ID of that new row.
        long newRowId = db.insert(InventoryContract.ProductEntry.TABLE_NAME, null, values);
        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving product", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "product saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                insertProduct();
                finish();
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
