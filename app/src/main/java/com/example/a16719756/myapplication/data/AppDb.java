package com.example.a16719756.myapplication.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;


@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDb extends RoomDatabase {

    private static AppDb INSTANCE;
    // DAO для работы с БД
    public abstract NotebookDao notebookModel();

    // Это singleton
    public static AppDb getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDb.class)
                            .allowMainThreadQueries()
                            .build();
        }
        // Заполнение БД тестовыми данными
        new PopulateDbAsync(INSTANCE).execute();
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final NotebookDao mDao;

        PopulateDbAsync(AppDb db) {
            mDao = db.notebookModel();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();

            Note note = new Note(1,"Morning","Good morning");
            mDao.insertNote(note);
            note = new Note(2,"Hello","Hello there");
            mDao.insertNote(note);
            note = new Note(3,"Bye","Goodbye, my love, Goodbye");
            mDao.insertNote(note);

            return null;
        }
    }

}
