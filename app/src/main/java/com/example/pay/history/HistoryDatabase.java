package com.example.pay.history;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

@Database(entities = (History.class), version = 1)
public abstract class HistoryDatabase extends RoomDatabase {

    public static HistoryDatabase instance;

    public abstract HistoryDao historyDao();

    public static synchronized HistoryDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    HistoryDatabase.class, "history_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{

        private HistoryDao historyDao;
        private PopulateDbAsyncTask(HistoryDatabase db){
            historyDao = db.historyDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            historyDao.insert(new History("PLN Bills", "5 July 2021", "BCA OneKlik", "Success"));
            return null;
        }

    }

}
