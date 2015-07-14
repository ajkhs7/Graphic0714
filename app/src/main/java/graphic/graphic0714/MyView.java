/*사용자가 화면을 터치하면, MyView상의 터치한 좌표값을 구해서, 그 포인트에 원을 그려보자!! */
package graphic.graphic0714;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 Created by JookHyun on 2015-07-14.
 */
public class MyView extends View{
    //int posX;
    //int posY;
    ArrayList<Point> list = new ArrayList<Point>();
    int width=100;
    int height=100;
    Paint paint; //실제적인 그림을 그리는 객체가 아니라 부가적인 객체이다 색상...같은

    public MyView(Context context, AttributeSet attrs){ //xml의 속성을 조절하려면 AttributeSet 이 포함된 생성자를 만들어야한다
        super(context, attrs);
        paint=new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        /*원을 그리자*/
        //canvas.drawOval(posX, posY, posX+width, posY+height, null);
        //canvas.drawRect(new RectF(posX, posY, posX+width, posY+height), paint);
        for(int i=0; i<list.size(); i++){
            Point point = list.get(i);
            canvas.drawOval(new RectF(point.x, point.y, point.x + width, point.y + height), paint);
        }
    }
}
