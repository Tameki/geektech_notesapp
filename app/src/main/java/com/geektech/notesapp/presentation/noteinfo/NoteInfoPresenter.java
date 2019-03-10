package com.geektech.notesapp.presentation.noteinfo;

import com.geektech.notesapp.data.notes.INotesStorage;
import com.geektech.notesapp.model.NoteEntity;

public class NoteInfoPresenter implements NoteInfoContract.Presenter {

    private NoteInfoContract.View mView;
    private INotesStorage mNotesStorage;
    private int mNoteId = -1;

    public NoteInfoPresenter(
            NoteInfoContract.View view,
            INotesStorage notesStorage
    ) {
        mView = view;
        mNotesStorage = notesStorage;
    }

    private void loadNote() {
        if (mView != null) {
            NoteEntity noteEntity = mNotesStorage.getNote(mNoteId);
            if (noteEntity != null) {
                mView.showNote(noteEntity);
            } else {
                mView.showLoadingError();
            }
        }
    }

    @Override
    public void loadNote(int id) {
        mNoteId = id;
        loadNote();
    }

    @Override
    public void onEditClick() {
        if (mView != null) {
            mView.openEditNote(mNoteId);
        }
    }

    @Override
    public void onDeleteClick() {
        if (mView != null) {
            mNotesStorage.deleteNote(mNoteId);
            mView.finishView();
        }
    }

    @Override
    public void onResume() {
        loadNote();
    }

    @Override
    public void attachView(NoteInfoContract.View view) {
        mView = view;
        view.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView = null;
    }

}
