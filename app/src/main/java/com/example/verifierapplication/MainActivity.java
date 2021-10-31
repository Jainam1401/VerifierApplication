package com.example.verifierapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String name="";
    private String number="";
    private String otp="";
    public static final String MSG="com.verifierapplication.msg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getinput(View v)
    {

        TextView tx=findViewById(R.id.usernameinput);
        name=tx.getText().toString();
        TextView textView=findViewById(R.id.phoneinput);
        number=textView.getText().toString();
        Button b1=findViewById(R.id.getotp);

        if(name.isEmpty())
        {
            Toast.makeText(this, "Username cannot be Empty ", Toast.LENGTH_SHORT).show();
        }
        else if(number.isEmpty())
        {
            Toast.makeText(this, "Phone Number cannot be Empty ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(number.length()==10)
            {
                Toast.makeText(this, " OTP sent to registered Mobile number ", Toast.LENGTH_SHORT).show();
                tx.getBackground().setAlpha(100);
                tx.setKeyListener(null);
                textView.getBackground().setAlpha(100);
                textView.setKeyListener(null);
                b1.getBackground().setAlpha(100);
                b1.setClickable(false);
                TextView tx1=findViewById(R.id.textView);
                tx1.setVisibility(View.VISIBLE);
                TextView tx2=findViewById(R.id.editTextTextPersonName);
                tx2.setVisibility(View.VISIBLE);
                Button b=findViewById(R.id.button);
                b.setVisibility(View.VISIBLE);
            }
            else
            {
                Toast.makeText(this, "Enter valid Phone Number ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void verify(View v)
    {

        TextView tx2=findViewById(R.id.editTextTextPersonName);
        otp=tx2.getText().toString();
        if(otp.isEmpty())
        {
            Toast.makeText(this, "Please Enter OTP ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(otp.length()==6 && otp.equals("123456"))
            {
                Toast.makeText(this, "Valid OTP ", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,MainPage.class);
                String message=" Welcome "+name;
                intent.putExtra(MSG,message);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Please enter valid OTP ", Toast.LENGTH_SHORT).show();
            }
        }
    }

}