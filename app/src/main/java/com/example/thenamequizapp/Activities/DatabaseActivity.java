package com.example.thenamequizapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thenamequizapp.Adapters.DatabaseAdapter;
import com.example.thenamequizapp.Classes.AppDatabase;
import com.example.thenamequizapp.R;

import java.util.List;

import com.example.thenamequizapp.Classes.Person;

public class DatabaseActivity extends AppCompatActivity {

    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        ListView listView = findViewById(R.id.dbList);
        homeButton = findViewById(R.id.homeButton);

        homeButton.setOnClickListener(v -> homeButtonDatabase());

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        List<Person> persons = appDatabase.personDao().getAll();

        DatabaseAdapter databaseAdapter = new DatabaseAdapter(this, R.layout.row_item, persons);

        listView.setAdapter(databaseAdapter);

    }

    public void addNewPerson(View view) {
        Intent i = new Intent(this, NewPersonActivity.class);
        startActivity(i);
        finish();
    }

    public void homeButtonDatabase() {
        finish();
    }

}