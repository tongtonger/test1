package com.example.test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                AlertDialog.Builder dialog1=new AlertDialog.Builder(MainActivity.this);
                dialog1.setTitle("提示窗口");
                dialog1.setMessage("这是一个对话框");
                dialog1.show();
                break;
            case R.id.button2:
                AlertDialog.Builder dialog2=new AlertDialog.Builder(MainActivity.this);
                dialog2.setTitle("登陆窗口");
                LayoutInflater inflater=getLayoutInflater();
                final View layout=inflater.inflate(R.layout.login_dialog,null);
                dialog2.setView(layout);
                final EditText UserId=(EditText) layout.findViewById(R.id.UserId);
                final EditText Password=(EditText) layout.findViewById(R.id.Password);

                dialog2.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (UserId.getText().toString().equals("abc")&&Password.getText().toString().equals("123"))
                            Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                        }
                });
                dialog2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog2.show();
                break;
        }
    }
}
