package com.example.a16719756.myapplication.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.example.a16719756.myapplication.data.Note;
import com.example.a16719756.myapplication.data.NoteRepository;

import java.util.List;

/*
    ViewModel предоставляет данные для UI.
 */

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;
    private LiveData<List<Note>> notesList;

    public NoteViewModel(Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        notesList = noteRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return noteRepository.getAllNotes();
    }

    public void insert(Note note) {
        noteRepository.insert(note);
    }


}
