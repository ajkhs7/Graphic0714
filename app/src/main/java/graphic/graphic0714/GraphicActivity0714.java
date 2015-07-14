package graphic.graphic0714;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.ArrayList;


public class GraphicActivity0714 extends Activity{
    String TAG;
    MyView myView;
    ArrayList<Point> list = new ArrayList<Point>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphic_activity0714);
        TAG=this.getClass().getName();
        myView=(MyView)findViewById(R.id.myView);
    }

    public void printOval(ArrayList list){
        /*정해진 좌표를 이용하여 MyView 다시 그리기!!*/
        //myView.posX=x; //원래는 setter로 넣지만 여기서는 일단 생략
        //myView.posY=y;

        myView.list=list;
        myView.invalidate();//싹지우고 다시그려라//새로고침효과
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){ //단말기연결해서 터치해보면 잘 나온다
        //Log.d(TAG, "터치했어?");

        //printOval((int)event.getX(), (int)event.getY());

        /*터치가 발생하면 좌표를 컬렉션 객체에 담자*/
        Point point = new Point((int)event.getX(), (int)event.getY());
        list.add(point);
        printOval(list);

        return false;
    }
}
