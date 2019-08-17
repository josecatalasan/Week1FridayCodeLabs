package com.example.shopping_list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static int REQUEST_CODE = 101;
    ListView lvGroceries;
    String[] listContent = {"", "", "", "", "", "", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
            listContent = savedInstanceState.getStringArray("listContent");

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview_item_template, listContent);
        lvGroceries = findViewById(R.id.lvGroceries);
        lvGroceries.setAdapter(adapter);
    }

    public void addItem(View view) {
        Intent addAnItem = new Intent(this, AddItemActivity.class);
        addAnItem.putExtra("listContent", listContent);
        startActivityForResult(addAnItem, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == AddItemActivity.RESULT_CODE_FAILURE) {
            Toast.makeText(this, "The list is full.", Toast.LENGTH_LONG).show();
        }

        listContent = data.getStringArrayExtra("listContent");
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview_item_template, listContent);
        lvGroceries.setAdapter(adapter);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putStringArray("listContent", listContent);
    }

}
