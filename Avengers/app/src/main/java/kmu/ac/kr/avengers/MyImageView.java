package kmu.ac.kr.avengers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MyImageView extends ImageView
{
    final int NONE = 0;
    final int DRAG = 1;
    final int ZOOM = 2;
    final float SIZE = 3;
    int bitWidth;
    int bitHegiht;

    private int mode;
    private Matrix matrix, savedMatrix;
    private PointF start, mid;
    float oldDist;

    private float scale;
    private float savedScale;
    private PointF movePoint;
    private PointF savedMovedPoint;
    private PointF eventPoint;

    // 드래그나 줌이 너무 작을 시 드래그나 줌을 하지않기 위해 마지막 값을 저장해둠
    private Matrix lastMatrix;
    private PointF lastPoint;
    private float lastScale;

    float viewWidth;
    float viewHeight;

    boolean actionFlag;
    ContentView Parent;

    private PointF viewPoint;   // 출발,도착,혼잡도 이미지뷰를 표시할 좌표
    private PointF ADPoint;     // 출발 또는 도착 이미지뷰를 표시할 좌표

    public MyImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        this.setImageBitmap(makeBitmap());
        this.setScaleType(ImageView.ScaleType.MATRIX);

        mode = NONE;
        matrix = new Matrix();
        savedMatrix = new Matrix();
        start = new PointF();
        mid = new PointF();
        oldDist = 1f;

        scale = 1f;
        movePoint = new PointF(0, 0);
        eventPoint = new PointF();
        savedScale = 1f;
        savedMovedPoint = new PointF();

        lastScale = 1f;
        lastMatrix = new Matrix();
        lastPoint = new PointF();

        actionFlag = false;

        viewPoint = new PointF(0, 0);
        ADPoint = new PointF(0, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(40);

        float x, y;
        x = (eventPoint.x - movePoint.x) / scale;
        y = (eventPoint.y - movePoint.y) / scale;

        // 3으로 나눠야 width 1600 이미지에 정확하게 좌표가 변환됨
        x /= SIZE;
        y /= SIZE;

        canvas.drawCircle(eventPoint.x, eventPoint.y, 20, paint);
        canvas.drawText("좌표 : (" + x + ", " + y + ")"
                , eventPoint.x, eventPoint.y + 40, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                savedMatrix.set(matrix);
                savedScale = scale;
                savedMovedPoint.set(movePoint.x, movePoint.y);
                start.set(event.getX(), event.getY());
                mode = DRAG;
                eventPoint.set(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                if(mode != ZOOM)
                {
                    oldDist = distance(event);
                    if(oldDist > 10f) {
                        savedMatrix.set(matrix);
                        savedScale = scale;
                        savedMovedPoint.set(movePoint.x, movePoint.y);
                        mode = ZOOM;
                        float x = event.getX(0) + event.getX(1);
                        float y = event.getY(0) + event.getY(1);
                        mid.set(x / 2, y / 2);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if(actionFlag == false)
                    stationClicked(start);
                else
                    actionFlag = false;
            case MotionEvent.ACTION_POINTER_UP:
                if (mode != NONE)
                {
                    mode = NONE;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG)
                    drag(event.getX(), event.getY());
                else if (mode == ZOOM)
                    zoom(event);
                break;
        }
        viewWidth = this.getWidth();
        viewHeight = this.getHeight();
        Parent = (ContentView)getParent();
        if(movePoint.x > 0) {
            matrix.postTranslate(-movePoint.x, 0);
            movePoint.set(0, movePoint.y);
        } else if((movePoint.x - viewWidth) / scale / SIZE <  -1600) {
            float dx = (movePoint.x - viewWidth) / scale / SIZE - (-1600);
            matrix.postTranslate(-dx * scale * SIZE, 0);
            movePoint.set(-1600 * SIZE * scale + viewWidth, movePoint.y);
            System.out.println("dx = " + dx + "move = " + (movePoint.x - viewWidth) / scale / SIZE);
        }
        if(movePoint.y > 0 ){
            matrix.postTranslate(0, -movePoint.y);
            movePoint.set(movePoint.x, 0);
        } else if((movePoint.y - viewHeight) / scale / SIZE < -1460) {
            float dy = (movePoint.y - viewHeight) / scale / SIZE - (-1460);
            matrix.postTranslate(0, -dy * scale * SIZE);
            movePoint.set(movePoint.x, -1460 * SIZE * scale + viewHeight);
            System.out.println("dy = " + dy + "move = " + (movePoint.y - viewHeight) / scale / SIZE);
        }
        PointF sendPoint1 = new PointF();
        PointF sendPoint2 = new PointF();
        sendPoint1.set(viewPoint.x *scale * SIZE + movePoint.x, viewPoint.y * scale * SIZE + movePoint.y);
        sendPoint2.set(ADPoint.x + movePoint.x, ADPoint.x + movePoint.y);
        Parent.send(sendPoint1, ADPoint);
        this.setImageMatrix(matrix);
        return true;
    }

    public float distance(MotionEvent event)
    {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);

        return (float) Math.sqrt(x * x + y * y);
    }

    private Bitmap makeBitmap()
    {
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.subway_revise);
        bitWidth = bitmap.getWidth();
        bitHegiht = bitmap.getHeight();

        return bitmap;
    }

    public void zoom(MotionEvent event)
    {
        float newDist = distance(event);

        if (newDist > 50f)
        {
            actionFlag = true;
            matrix.set(savedMatrix);
            scale = savedScale;
            movePoint.set(savedMovedPoint.x, savedMovedPoint.y);
            float newScale = newDist / oldDist;
            if(scale * newScale < 0.5 || scale * newScale > 2.0)
            {
                matrix.set(lastMatrix);
                scale = lastScale;
                movePoint.set(lastPoint);
                return;
            }
            matrix.postScale(newScale, newScale, mid.x, mid.y);
            movePoint.set((movePoint.x - mid.x) * newScale + mid.x
                    , (movePoint.y - mid.y) * newScale + mid.y);
            scale *= newScale;
            lastScale = scale;
            lastPoint.set(movePoint.x, movePoint.y);
            lastMatrix.set(matrix);
        }
    }

    public void drag(float ex, float ey) {
        matrix.set(savedMatrix);
        movePoint.set(savedMovedPoint.x, savedMovedPoint.y);
        float dx = 0;
        float dy = 0;
        dx = ex - start.x;
        dy = ey - start.y;
        if ((dx < 25 && dx > -25) && (dy < 25 && dy > -25))
            return;
        actionFlag = true;
        matrix.postTranslate(dx, dy);
        movePoint.set(movePoint.x + dx, movePoint.y + dy);
        lastScale = scale;
        lastPoint.set(movePoint.x, movePoint.y);
        lastMatrix.set(matrix);
    }

    public void stationClicked(PointF sPoint){
        float rx, ry;
        rx = (sPoint.x - movePoint.x) / scale / SIZE;
        ry = (sPoint.y - movePoint.y) / scale / SIZE;
        viewPoint.set(rx, ry);
        if(true) // rx, ry과 역 범위 안이라면
            Parent.setVisible(true);
        else
            Parent.setVisible(false);

        invalidate();
    }

    public void setADPoint(){
        ADPoint.set(viewPoint.x, viewPoint.y);
        viewPoint.set(0, 0);
    }
}