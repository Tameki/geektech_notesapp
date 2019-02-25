package com.geektech.notesapp.presentation.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.geektech.notesapp.R;
import com.geektech.notesapp.presentation.intro.IntroActivity;
import com.geektech.notesapp.presentation.main.recycler.NoteItemViewHolder;
import com.geektech.notesapp.presentation.main.recycler.NotesAdapter;

public class MainActivity extends AppCompatActivity
    implements NoteItemViewHolder.NoteClickListener {

    private NotesAdapter mAdapter;
    private RecyclerView mRecycler;

    //region Static

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    //endregion

    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }

    //endregion

    //region Init

    private void init() {
        //TODO: Initialize recycler, and Adapter
    }

    //endregion

    //region Click

    @Override
    public void onClick(int position) {
        //TODO: Get note from adapter via NotesAdapter.getItem(int position) and open NoteInfoActivity
    }

    //endregion

    private void loadNotes() {
        //TODO: Load notes from NotesRepository, get from App instance
    }
}
