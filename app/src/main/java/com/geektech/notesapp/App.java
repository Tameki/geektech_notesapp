package com.geektech.notesapp;

import android.app.Application;

import com.geektech.notesapp.data.notes.NotesRepository;
import com.geektech.notesapp.data.notes.INotesStorage;
import com.geektech.notesapp.data.notes.local.NotesRealmStorage;
import com.geektech.util.shared.SharedStorage;
import com.geektech.util.shared.SharedStorageImpl;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {

    private final String SHARED_FILE_NAME = "shared_prefs";

    public static SharedStorage sharedStorage;
    public static INotesStorage notesStorage;

    @Override
    public void onCreate() {
        super.onCreate();

        setupRealm();

        initStorages();
    }

    private void setupRealm() {
        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                        .schemaVersion(1)
                        .name("notes.realm")
                        .compactOnLaunch()
                        .deleteRealmIfMigrationNeeded()
                        .build();

        Realm.setDefaultConfiguration(configuration);
    }

    private void initStorages() {
        sharedStorage = new SharedStorageImpl(this, SHARED_FILE_NAME);

        notesStorage = new NotesRepository(new NotesRealmStorage());
    }

}
