package com.example.pay.history;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HistoryRepository {

    private HistoryDao historyDao;
    private LiveData<List<History>> allHistory;

    public HistoryRepository(Application application) {
        HistoryDatabase database = HistoryDatabase.getInstance(application);
        historyDao = database.historyDao();
        allHistory = historyDao.getAllHistory();
    }

    public void insert(History history){
        new InsertHistoryAsyncTask(historyDao).execute(history);
    }

    public void delete(History history){

    }

    public LiveData<List<History>> getAllHistory() {
        return allHistory;
    }

    private static class InsertHistoryAsyncTask extends AsyncTask<History, Void, Void> {

        private HistoryDao historyDao;

        private InsertHistoryAsyncTask(HistoryDao historyDao){
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(History... histories) {
            historyDao.insert(histories[0]);
            return null;
        }
    }

    private static class DeleteHistoryAsyncTask extends AsyncTask<History, Void, Void> {

        private HistoryDao historyDao;

        private DeleteHistoryAsyncTask(HistoryDao historyDao){
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(History... histories) {
            historyDao.delete(histories[0]);
            return null;
        }
    }
}
