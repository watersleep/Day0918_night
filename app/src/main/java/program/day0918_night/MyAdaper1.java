package program.day0918_night;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class MyAdaper1 extends BaseAdapter {
    private ArrayList<Type> list;
    private LayoutInflater inflater;
    private Context context;

    public MyAdaper1(ArrayList<Type> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.type_item, parent, false);
            holder = new ViewHolder();

            holder.tv_description = (TextView) convertView.findViewById(R.id.tv_description);
            holder.tv_food = (TextView) convertView.findViewById(R.id.tv_food);
            holder.tv_keyword = (TextView) convertView.findViewById(R.id.tv_keywoord);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Type type = list.get(position);

        holder.tv_name.setText(type.getName());
        holder.tv_description.setText(type.getDescription());
        holder.tv_food.setText(type.getFood());
        holder.tv_keyword.setText("关键字： "+type.getKeyword());

        Picasso.with(context).load(type.getImag()).into(holder.iv);

        return convertView;
    }

    public class ViewHolder {
        TextView tv_description;
        TextView tv_food;
        TextView tv_name;
        TextView tv_keyword;
        ImageView iv;
    }
}
