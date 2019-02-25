package com.geektech.notesapp.presentation.addnote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.notesapp.R;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        init();
    }

    private void init() {
        //TODO: Init views
        //TODO: 1 title input, 1 description input, 1 submit button
    }

    private void addNote() {
        //TODO: Fetch inputs text and save new Note via App.notesStorage
    }
}
