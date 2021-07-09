package com.example.pay.history;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.pay.R;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Database(entities = (History.class), version = 1)
public abstract class HistoryDatabase extends RoomDatabase {

    public static HistoryDatabase instance;

    private static Context activity;

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
            fillWithStartingData(activity);
            return null;
        }
    }
    private static void fillWithStartingData(Context context){
        HistoryDao historyDao = getInstance(context).historyDao();
        JSONArray doas = loadJSONArray(context);
        try {
            for (int i=0;i<doas.length();i++){
                JSONObject doa = doas.getJSONObject(i);
                String namapembayaran = doa.getString("namapembayaran");
                String tanggal = doa.getString("tanggal");
                String metodepembayaran = doa.getString("metodepembayaran");
                String status = doa.getString("status");

                historyDao.insert(new History(namapembayaran, tanggal, metodepembayaran, status));

            }
        }catch (JSONException e){

        }
    }
    private static JSONArray loadJSONArray(Context context){
        StringBuilder builder = new StringBuilder();
        InputStream in = context.getResources().openRawResource(R.raw.iphone);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) !=null){
                builder.append(line);
            }
            JSONObject json = new JSONObject(builder.toString());
            return json.getJSONArray("data");
        } catch (IOException | JSONException exception){
            exception.printStackTrace();
        }
        return null;
    }
}

