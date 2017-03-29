package com.anwesome.ui.searchbar;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.List;

/**
 * Created by anweshmishra on 29/03/17.
 */
public class SearchTextViewWatcher implements TextWatcher{
    private DataSource dataSource;
    private OnMatchListener onMatchListener;
    public SearchTextViewWatcher(DataSource dataSource,OnMatchListener onMatchListener) {
        this.dataSource = dataSource;
        this.onMatchListener = onMatchListener;
    }
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(dataSource!=null && onMatchListener!=null) {
            List<String> results = dataSource.matchForResults(charSequence.toString());
            onMatchListener.onMatchResults(results);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
