package com.cwxin.bottomsheetdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_bottom = (Button) findViewById(R.id.btn_bottom);
        btn_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomDialogFragment fragment = new BottomDialogFragment();
                fragment.show(getSupportFragmentManager(), "bottom");
            }
        });
    }
}
