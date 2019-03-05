package com.geektech.notesapp.presentation.noteinfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.geektech.notesapp.App;
import com.geektech.notesapp.R;
import com.geektech.notesapp.model.NoteEntity;

public class NoteInfoActivity extends AppCompatActivity {

    private TextView mTitle, mDescription, mCreatedAt;

    //region Static

    private static final String EXTRA_ID = "id";

    public static void start(Context context, int id) {
        context.startActivity(intent(context, id));
    }

    public static Intent intent(Context context, int id) {
        Intent intent = new Intent(context, NoteInfoActivity.class);

        intent.putExtra(EXTRA_ID, id);

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
        mTitle = findViewById(R.id.note_info_title);
        mDescription = findViewById(R.id.note_info_description);
        mCreatedAt = findViewById(R.id.note_info_created_at);

        loadNote();
    }

    private void loadNote() {
        NoteEntity note = App.notesStorage
                .getNote(getIntent().getIntExtra(EXTRA_ID, -1));

        if (note != null) {
            mTitle.setText(note.getTitle());
            mDescription.setText(note.getDescription());
            mCreatedAt.setText(note.getCreatedAt().toString()); //TODO: Date format
        }
    }
}
