package com.geektech.notesapp.presentation.noteinfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.notesapp.R;

public class NoteInfoActivity extends AppCompatActivity {

    //region Static

    public static void start(Context context, int id) {
        context.startActivity(intent(context, id));
    }

    public static Intent intent(Context context, int id) {
        Intent intent = new Intent(context, NoteInfoActivity.class);

        //TODO: Put id into intent extras

        return intent;
    }

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note_info);

        init();
    }

    private void init() {
        //TODO: Init all views
        //TODO: Get passed id from intent and load NoteEntity data into views
    }
}
