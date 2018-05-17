package blanc.thomas.dawin.tetris;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String[] scores = new String[10];
        for(int i = 0; i < scores.length; i++) {
            scores[i] = i + 1 + ". AAA - 00000";
        }
        saveArray(scores, "scores");
        String[] list = loadArray("scores");
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.simplerow, list);
        ListView lv = findViewById(R.id.listViewScoreboard);
        lv.setAdapter(listAdapter);
    }

    public void onClickPlayButton(View v) {
        startActivity(new Intent(MenuActivity.this, GameActivity.class));
    }

    public boolean saveArray(String[] array, String arrayName) {
        SharedPreferences prefs = getSharedPreferences("sharedScores", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.length);
        for(int i=0;i<array.length;i++)
            editor.putString(arrayName + "_" + i, array[i]);
        return editor.commit();
    }

    public String[] loadArray(String arrayName) {
        SharedPreferences prefs = getSharedPreferences("sharedScores", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for(int i=0;i<size;i++)
            array[i] = prefs.getString(arrayName + "_" + i, null);
        return array;
    }

}
