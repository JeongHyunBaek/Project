package kmu.ac.kr.avengers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListViewAdapter extends BaseAdapter
{
    private ArrayList<CustomListItem> customListItems = new ArrayList<>();
    private ArrayList<CustomListItem> displayListItems = new ArrayList<>();

    @Override
    public int getCount()
    {
        return displayListItems.size();
    }

    @Override
    public CustomListItem getItem(int position)
    {
        return displayListItems.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Context context = parent.getContext();

        /* 'listview_custom_Layout'을 inflate하여 convertView 참조 획득 */
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list_layout, parent, false);
        }

        /* 'listview_custom'에 정의된 위젯에 대한 참조 획득 */
        ImageView iv_img = (ImageView)convertView.findViewById(R.id.iv_logo);
        TextView tv_name = (TextView)convertView.findViewById(R.id.tv_station);

        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        CustomListItem customListItem = getItem(position);

        /* 각 위젯에 세팅된 아이템을 뿌려준다 */
        iv_img.setImageDrawable(customListItem.getIcon());
        tv_name.setText(customListItem.getStation());

        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  */

        return convertView;
    }
    /* 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성 */
    public void addItem(Drawable img, String station)
    {
        CustomListItem customListItem = new CustomListItem();

        /* MyItem에 아이템을 setting한다. */
        customListItem.setIcon(img);
        customListItem.setStation(station);

        /* mItems에 MyItem을 추가한다. */
        customListItems.add(customListItem);
    }

    public void addList(Drawable img, String[] stations)
    {
        CustomListItem customListItem = new CustomListItem();

        for (int i = 0; i < stations.length; i++)
        {
            customListItem.setIcon(img);
            customListItem.setStation(stations[i]);
            customListItems.add(customListItem);
        }
    }

    public void filter(String search)
    {
        displayListItems.clear();

        if (search.length() == 0)
        {
//            displayListItems.addAll(customListItems);
        }
        else
        {
            for (CustomListItem items : customListItems)
            {
                if (items.getStation().contains(search))
                {
                    displayListItems.add(items);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void testFill()
    {
        displayListItems.clear();
        displayListItems.addAll(customListItems);
    }
}
