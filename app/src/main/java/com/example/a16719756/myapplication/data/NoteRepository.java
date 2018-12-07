package com.example.a16719756.myapplication.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */

public class NoteRepository {

    private NotebookDao notebookDao;
    private LiveData<List<Note>> notesList;

    public NoteRepository(Application application) {
        AppDb db = AppDb.getDatabase(application);
        notebookDao = db.notebookModel();
        notesList = notebookDao.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return notebookDao.getAllNotes();
    }

    public void insert(Note note) {
        new insertAsyncTask(notebookDao).execute(note);
    }

    private static class insertAsyncTask extends AsyncTask<Note, Void, Void> {

        private NotebookDao mAsyncTaskDao;
        insertAsyncTask(NotebookDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Note... params) {
            mAsyncTaskDao.insertNote(params[0]);
            return null;
        }
    }
}
