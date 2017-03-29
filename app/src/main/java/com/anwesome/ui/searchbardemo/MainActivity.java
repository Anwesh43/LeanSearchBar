package com.anwesome.ui.searchbardemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.anwesome.ui.searchbar.DataSource;
import com.anwesome.ui.searchbar.OnMatchListener;
import com.anwesome.ui.searchbar.SearchBar;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = (TextView)findViewById(R.id.resultText);
        resultText.setY(200);
        SearchBar searchBar = new SearchBar(this);
        DataSource dataSource = new DataSource();
        String res = "";
        for(String message:AppConstants.messages) {
            res+=message+"\n";
            dataSource.addToData(message);
        }
        resultText.setText(res);
        searchBar.show(dataSource, new OnMatchListener() {
            @Override
            public void onMatchResults(List<String> results) {
                String res = "";
                for(String result:results) {
                    res += result+"\n";
                }
                resultText.setText(res);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
