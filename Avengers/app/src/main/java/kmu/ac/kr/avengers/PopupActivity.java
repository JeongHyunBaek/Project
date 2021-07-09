package kmu.ac.kr.avengers;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class PopupActivity extends AppCompatActivity
{
    String query;
    JSONArray information = null;
    ArrayList<HashMap<String, String>> subwayList;
    ListView popupList;
    public static Boolean inArea;
    TextView tv_car_one, tv_car_two, tv_car_three, tv_car_four, tv_car_five, tv_car_six, tv_subway_id;
    ImageView iv_car_one, iv_car_two, iv_car_three, iv_car_four, iv_car_five, iv_car_six;
    RelativeLayout rl_munyang;
    LayoutInflater inflater;

    private static final String TAG_RESULT = "result";
    private static final String TAG_SUBWAY_NUM = "T_NO";
    private static final String TAG_CAR_NUM = "T_UN";
    private static final String TAG_CONGESTION = "T_CON";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        this.inArea = true;

        tv_car_one = (TextView)findViewById(R.id.tv_car_one);
        tv_car_two = (TextView)findViewById(R.id.tv_car_two);
        tv_car_three = (TextView)findViewById(R.id.tv_car_three);
        tv_car_four = (TextView)findViewById(R.id.tv_car_four);
        tv_car_five = (TextView)findViewById(R.id.tv_car_five);
        tv_car_six = (TextView)findViewById(R.id.tv_car_six);
        tv_subway_id = (TextView)findViewById(R.id.tv_subway_id);

        iv_car_one = (ImageView)findViewById(R.id.iv_car_one);
        iv_car_two = (ImageView)findViewById(R.id.iv_car_two);
        iv_car_three = (ImageView)findViewById(R.id.iv_car_three);
        iv_car_four = (ImageView)findViewById(R.id.iv_car_four);
        iv_car_five = (ImageView)findViewById(R.id.iv_car_five);
        iv_car_six = (ImageView)findViewById(R.id.iv_car_six);

//        inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        rl_munyang.addView(inflater.inflate(R.layout.munyang_popup, null));

//        popupList = (ListView)findViewById(R.id.list_popup);
//        subwayList = new ArrayList<HashMap<String, String>>();
        //UpdateInfo updateInfo = new UpdateInfo();
        //updateInfo.start();
        getData("http://27.124.210.37/subway_info.php");
    }

    @Override
    protected void onPause()
    {
        this.inArea = false;
        super.onPause();
    }

    protected void showList()
    {
        try
        {
            JSONObject jsonInfo= new JSONObject(query);
            information = jsonInfo.getJSONArray(TAG_RESULT);

            for(int i = 0; i<information.length(); i++)
            {
                JSONObject tmp = information.getJSONObject(i);
                int subwayNum = tmp.getInt(TAG_SUBWAY_NUM);
                int carNum = tmp.getInt(TAG_CAR_NUM);
                int congestion = tmp.getInt(TAG_CONGESTION);

                tv_subway_id.setText(subwayNum + " 열차");

                switch (carNum)
                {
                    case 1:
                        if (congestion >= 0 && congestion < 34)
                        {
                            tv_car_one.setText(String.valueOf(congestion));
                            iv_car_one.setImageResource(R.drawable.subway_light);
                        }
                        else if (congestion >= 34 && congestion < 67)
                        {
                            tv_car_one.setText(String.valueOf(congestion));
                            iv_car_one.setImageResource(R.drawable.subway_normal);
                        }
                        else
                        {
                            tv_car_one.setText(String.valueOf(congestion));
                            iv_car_one.setImageResource(R.drawable.subway_crowd);
                        }
                        break;
                    case 2:
                        if (congestion >= 0 && congestion < 34)
                        {
                            tv_car_two.setText(String.valueOf(congestion));
                            iv_car_two.setImageResource(R.drawable.subway_light);
                        }
                        else if (congestion >= 34 && congestion < 67)
                        {
                            tv_car_two.setText(String.valueOf(congestion));
                            iv_car_two.setImageResource(R.drawable.subway_normal);
                        }
                        else
                        {
                            tv_car_two.setText(String.valueOf(congestion));
                            iv_car_two.setImageResource(R.drawable.subway_crowd);
                        }
                        break;
                    case 3:
                        if (congestion >= 0 && congestion < 34)
                        {
                            tv_car_three.setText(String.valueOf(congestion));
                            iv_car_three.setImageResource(R.drawable.subway_light);
                        }
                        else if (congestion >= 34 && congestion < 67)
                        {
                            tv_car_three.setText(String.valueOf(congestion));
                            iv_car_three.setImageResource(R.drawable.subway_normal);
                        }
                        else
                        {
                            tv_car_three.setText(String.valueOf(congestion));
                            iv_car_three.setImageResource(R.drawable.subway_crowd);
                        }
                        break;
                    case 4:
                        if (congestion >= 0 && congestion < 34)
                        {
                            tv_car_four.setText(String.valueOf(congestion));
                            iv_car_four.setImageResource(R.drawable.subway_light);
                        }
                        else if (congestion >= 34 && congestion < 67)
                        {
                            tv_car_four.setText(String.valueOf(congestion));
                            iv_car_four.setImageResource(R.drawable.subway_normal);
                        }
                        else
                        {
                            tv_car_four.setText(String.valueOf(congestion));
                            iv_car_four.setImageResource(R.drawable.subway_crowd);
                        }
                        break;
                    case 5:
                        if (congestion >= 0 && congestion < 34)
                        {
                            tv_car_five.setText(String.valueOf(congestion));
                            iv_car_five.setImageResource(R.drawable.subway_light);
                        }
                        else if (congestion >= 34 && congestion < 67)
                        {
                            tv_car_five.setText(String.valueOf(congestion));
                            iv_car_five.setImageResource(R.drawable.subway_normal);
                        }
                        else
                        {
                            tv_car_five.setText(String.valueOf(congestion));
                            iv_car_five.setImageResource(R.drawable.subway_crowd);
                        }
                        break;
                    case 6:
                        if (congestion >= 0 && congestion < 34)
                        {
                            tv_car_six.setText(String.valueOf(congestion));
                            iv_car_six.setImageResource(R.drawable.subway_light);
                        }
                        else if (congestion >= 34 && congestion < 67)
                        {
                            tv_car_six.setText(String.valueOf(congestion));
                            iv_car_six.setImageResource(R.drawable.subway_normal);
                        }
                        else
                        {
                            tv_car_six.setText(String.valueOf(congestion));
                            iv_car_six.setImageResource(R.drawable.subway_crowd);
                        }
                        break;
                    default:
                        break;
                }

//                String subwayNum = tmp.getString(TAG_SUBWAY_NUM);
//                String carNum = tmp.getString(TAG_CAR_NUM);
//                String congestion = tmp.getString(TAG_CONGESTION);



//                HashMap<String, String> info = new HashMap<String, String>();
//                info.put(TAG_SUBWAY_NUM, subwayNum);
//                info.put(TAG_CAR_NUM, carNum);
//                info.put(TAG_CONGESTION, congestion);
//
//                subwayList.add(info);
            }

//            ListAdapter listAdapter = new SimpleAdapter(
//                    PopupActivity.this, subwayList, R.layout.popup_list_item,
//                    new String[]{TAG_SUBWAY_NUM, TAG_CAR_NUM, TAG_CONGESTION},
//                    new int[]{R.id.tv_subway_num, R.id.tv_car_num, R.id.tv_congestion}
//            );
//
//            popupList.setAdapter(listAdapter);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public void getData(String url)
    {
        class DataGet extends AsyncTask<String, Void, String>
        {
            @Override
            protected String doInBackground(String... strings)
            {
                String uri = strings[0];

                BufferedReader bufferedReader = null;
                try
                {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine()) != null)
                    {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                }
                catch (Exception e)
                {
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String s)
            {
                query = s;
                showList();
            }
        }

        DataGet dg = new DataGet();
        dg.execute(url);
    }

    public class UpdateInfo extends Thread
    {
        UpdateInfo()
        {
            inArea = true;
        }

        @Override
        public void run()
        {
            super.run();

            while (inArea)
            {
                try
                {
                    getData("http://27.124.210.37/subway_info.php");
                    sleep(7000);
                }
                catch (InterruptedException e)
                {
                    return;
                }
            }
        }
    }

//    protected void onPause()
//    {
//
//    }

    public void munyangListener(View target)
    {
        inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rl_munyang.addView(inflater.inflate(R.layout.munyang_popup,null));
    }

    public void youngnamListener(View target)
    {

    }
}
