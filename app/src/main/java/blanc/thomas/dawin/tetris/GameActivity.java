package blanc.thomas.dawin.tetris;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import blanc.thomas.dawin.tetris.Model.GameEngine;

public class GameActivity extends AppCompatActivity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initGame();
    }

	@SuppressLint("ClickableViewAccessibility")
	private void initGame() {
		//Handler for thread
	    final Handler handler = new Handler();

	    //Game logic
		GameEngine gameEngine = new GameEngine(GameActivity.this, handler,
				(TextView)findViewById(R.id.ScoreTextView),
				(TextView)findViewById(R.id.LevelTextView),
				(TextView)findViewById(R.id.LinesTextView));

		//GameGridview
		GridView gameGridView = findViewById(R.id.GameGrid);
		gameGridView.setOnTouchListener(gameEngine);
		gameGridView.setAdapter(gameEngine.getGameAdapter());

		//NextGridView
		GridView nextGridView = findViewById(R.id.NextGridView);
		nextGridView.setAdapter(gameEngine.getNextAdapter());

		//Post loop
		handler.post(gameEngine);
	}

	void onRotate(View v) {
//		gameEngine.rotateCurrent();
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
