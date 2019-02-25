package com.geektech.notesapp.data.notes;

import com.geektech.notesapp.model.NoteEntity;

import java.util.Collection;
import java.util.HashMap;

public class NotesRepository implements NotesStorage {

    private HashMap<Integer, NoteEntity> mCache = new HashMap<>();

    public NotesRepository() {
        mCache.put(1, new NoteEntity());
        mCache.put(2, new NoteEntity());
        mCache.put(3, new NoteEntity());
        mCache.put(4, new NoteEntity());
        mCache.put(5, new NoteEntity());
    }

    @Override
    public void addNote(NoteEntity noteEntity) {
        //TODO: Add note to cache
    }

    @Override
    public NoteEntity getNote(int id) {
        return mCache.get(id);
    }

    @Override
    public Collection<NoteEntity> getAllNotes() {
        return mCache.values();
    }

    @Override
    public void deleteNote(int id) {

    }
}
