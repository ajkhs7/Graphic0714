/*제대로 만들려면 프레임웤으로 가야한다~여기서는 그냥~*/
package game.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import graphic.graphic0714.R;

/**
 Created by JookHyun on 2015-07-14.
 */
public class GameView extends View{
    Bitmap ship;
    private int posX;
    private int posY;
    Paint paint;

    /*조이스틱, 총알버튼의 크기*/
    RectF[] control = new RectF[5];
    int controlWidth=100;
    int controlHeight=100;
    int x=100;
    int y=100;

    public GameView(Context context, AttributeSet attrs){
        super(context, attrs);

        Matrix matrix = new Matrix();
        matrix.setScale(100, 100);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ship);
        //bitmap.setWidth(100); 내폰 버전이 낮아서 안먹는듯~

        ship=Bitmap.createScaledBitmap(bitmap, 100, 100, false); //비율유지하고 크기 조절
        paint = new Paint();
        paint.setColor(Color.BLUE);

         control[0] = new RectF(x, 2*y, x+controlWidth, y+controlHeight); //왼쪽
         control[1] = new RectF(2*x+10, y, 2*x+10+controlWidth, y+controlHeight); //위
         control[2] = new RectF(3*x+20, y, 3*x+20+controlWidth, y+controlHeight); //오른쪽
         control[3] = new RectF(2*x+10, 2*y+10,2*x+10+controlWidth, 2*y+10+controlHeight); //아래
         control[4] = new RectF(x, y, x+controlWidth, y+controlHeight); //총알
    }

    /*조이스틱 그리기*/
    public void paintJoyStick(Canvas canvas){

        //위부터 총알까지 반복문으로 생성
/*        for(int i=0; i<control.length; i++){
            canvas.drawRect(control[i], paint); //사각형 크기만 지정가능
        }*/

        canvas.drawRect(control[0], paint);
        canvas.drawRect(control[1], paint);
        canvas.drawRect(control[2], paint);
        canvas.drawRect(control[3], paint);
        canvas.drawRect(control[4], paint);

         /*위*/
        //canvas.drawRect(new Rect(100, 200, 100 + 100, 200 + 100), paint); //사각형 크기만 지정가능

        /*아래*/

        /*왼쪽*/

        /*오른쪽*/

        /*총알*/

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawBitmap(ship, posX, posY, null);

        paintJoyStick(canvas);
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public int getPosY(){
        return posY;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }
}
