package com.example.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {
    public final static int RESULT_CODE_SUCCESS = 201;
    public final static int RESULT_CODE_FAILURE = 202;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void addAndReturn(View view) {
        Intent returnIntent = new Intent(this, MainActivity.class);
        String[] contentArray = getIntent().getStringArrayExtra("listContent");
        int emptyIndex = 0;
        for (String item : contentArray) {
            if (item.equals(""))
                break;
            emptyIndex++;
        }
        //emptyIndex will be 11 if the array is not empty
        if (emptyIndex == 10) {
            returnIntent.putExtra("listContent", contentArray);
            setResult(RESULT_CODE_FAILURE, returnIntent);
            finish();
        } else {

            switch (view.getId()) {
                case R.id.banana:
                    contentArray[emptyIndex] = "Banana";
                    break;
                case R.id.bread:
                    contentArray[emptyIndex] = "Bread";
                    break;
                case R.id.milk:
                    contentArray[emptyIndex] = "Milk";
                    break;
                case R.id.eggs:
                    contentArray[emptyIndex] = "Eggs";
                    break;
                case R.id.cheese:
                    contentArray[emptyIndex] = "Cheese";
                    break;
            }

            returnIntent.putExtra("listContent", contentArray);
            setResult(RESULT_CODE_SUCCESS, returnIntent);
            finish();

        }
    }
}
