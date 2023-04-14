package com.mblhcmute.insertdatatofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge, edtPhone, edtHeight;
    Button btnSave;
    DatabaseReference reff;
    Member member = new Member();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.EdtName);
        edtAge = findViewById(R.id.EdtAge);
        edtPhone = findViewById(R.id.EdtPhone);
        edtHeight = findViewById(R.id.EdtHeight);
        btnSave = findViewById(R.id.btnSave);
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(edtAge.getText().toString().trim());
                Long phone = Long.parseLong(edtPhone.getText().toString().trim());
                Float height = Float.parseFloat(edtHeight.getText().toString().trim());
                member.setAge(age);
                member.setPhone(phone);
                member.setHeight(height);
                member.setName(edtName.getText().toString().trim());
                reff.push().setValue(member);
                Toast.makeText(MainActivity.this, "data insserted sucessfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}