package kmu.ac.kr.avengers;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;

/**
 * Created by Gunny on 2018-04-18.
 */

public class ContentView extends AbsoluteLayout {

    private MyImageView pathView;
    private LinearLayout menuView;
    private boolean flag;
    LayoutInflater layoutInflater;
    private LayoutParams params;

    public ContentView(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setLayoutParams(new AbsoluteLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0, 0));
        flag = false;
        params = new LayoutParams(context, attrs);

        pathView = new MyImageView(context, attrs);
        pathView.setLayoutParams(new AbsoluteLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0, 0));

        menuView = new LinearLayout(context, attrs, R.layout.menu_popup);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        menuView = (LinearLayout) layoutInflater.inflate(R.layout.menu_popup, this, false);
        menuView.setLayoutParams((new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0, 0)));

        this.addView(pathView);
        this.addView(menuView);

        menuView.getChildAt(2).setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, ScheduleActivity.class);
                context.startActivity(intent);
            }
        });

        menuView.getChildAt(3).setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, PopupActivity.class);
                context.startActivity(intent);
            }
        });
    }

    public void send(PointF viewPoint, PointF adPoint){
        params.x = (int)viewPoint.x;
        params.y = (int)viewPoint.y;
        menuView.layout(0, 0, menuView.getWidth(), menuView.getHeight());
        this.updateViewLayout(menuView, params);
    }

    public void setVisible(boolean bool){
        if(bool)
            menuView.setVisibility(VISIBLE);
        else
            menuView.setVisibility(GONE);
    }
}