package game.shooting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import graphic.graphic0714.R;

/**
 Created by JookHyun on 2015-07-14.
 */
public class GameActivity0714 extends Activity{
    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game0714);

        gameView=(GameView)findViewById(R.id.gameView);
    }

    /*우주선을 날리라!!Bitmap의 x축을 변경한 후 invalidate()호출 */
    public void moveShip(){
        int x = gameView.getPosX();
        x+=10;
        gameView.setPosX(x);
        gameView.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        moveShip();

        return super.onTouchEvent(event);
    }
}
