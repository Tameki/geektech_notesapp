package com.geektech.notesapp.presentation.noteinfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.geektech.notesapp.App;
import com.geektech.notesapp.R;
import com.geektech.notesapp.data.notes.local.model.RNote;
import com.geektech.notesapp.model.NoteEntity;
import com.geektech.notesapp.presentation.addnote.AddNoteActivity;
import com.geektech.util.DateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class NoteInfoActivity extends AppCompatActivity
    implements View.OnClickListener, NoteInfoContract.View {

    private NoteInfoContract.Presenter mPresenter;

    private TextView mTitle, mDescription, mCreatedAt;
    private View mEditBtn, mDeleteBtn;

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

        mPresenter = new NoteInfoPresenter(
                this,
                App.notesStorage
        );

        init();

        mPresenter.loadNote(getIntent().getIntExtra(EXTRA_ID, -1));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    private void init() {
        mTitle = findViewById(R.id.note_info_title);
        mDescription = findViewById(R.id.note_info_description);
        mCreatedAt = findViewById(R.id.note_info_created_at);
        mEditBtn = findViewById(R.id.note_info_edit);
        mDeleteBtn = findViewById(R.id.note_info_delete);

        mEditBtn.setOnClickListener(this);
        mDeleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.note_info_edit:
                mPresenter.onEditClick();
                break;
            case R.id.note_info_delete:
                mPresenter.onDeleteClick();
                break;
        }
    }

    ///region Contract

    @Override
    public void showNote(NoteEntity note) {
        mTitle.setText(note.getTitle());
        mDescription.setText(note.getDescription());

        mCreatedAt.setText(DateUtil.formatDefaultDate(note.getCreatedAt()));
    }

    @Override
    public void openEditNote(int id) {
        AddNoteActivity.start(this, id);
    }

    @Override
    public void attachPresenter(NoteInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void showLoadingError() {
        //TODO: Show error toast
    }

    //endregion
}
