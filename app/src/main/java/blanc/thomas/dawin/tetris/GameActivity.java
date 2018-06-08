package blanc.thomas.dawin.tetris;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import java.util.Timer;
import blanc.thomas.dawin.tetris.Model.GameEngine;

public class GameActivity extends AppCompatActivity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initGame();
    }

	private void initGame() {
	    final Handler handler = new Handler();
		GameEngine gameEngine = new GameEngine(GameActivity.this, handler);
		GridView gameGridView = findViewById(R.id.GameGrid);
		gameGridView.setAdapter(gameEngine.adapter());
		handler.post(gameEngine);
	}

	@Override
	protected void onStart() {
		super.onStart();
		setImmersiveMode();
	}

	private void setImmersiveMode() {
		int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
		getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
	}
}
