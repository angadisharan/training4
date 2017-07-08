package com.mathrusoft.demodatabase;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharanangadi on 08/07/17.
 */

public class ActivityDemoDialogue extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_dialogue);

        findViewById(R.id.simple_dialogue).setOnClickListener(onClickListener);
        findViewById(R.id.custom_dialogue).setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.simple_dialogue:
                    showSimpleDialogue();
                    break;
                case R.id.custom_dialogue:
                    showCustomDialogue();
                    break;
            }
        }
    };

    private void showCustomDialogue() {

        final Dialog alertDialog = new Dialog(this);

        alertDialog.setContentView(R.layout.activity_login);

        EditText userName = (EditText) alertDialog.findViewById(R.id.user_name);
        Button submit = (Button) alertDialog.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();

    }

    private void showSimpleDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivityDemoDialogue.this, "OK clicked", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ActivityDemoDialogue.this, "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setMessage("Hello Dialogue content")
                .setTitle("Hello Title");

        builder.show();
    }
}
