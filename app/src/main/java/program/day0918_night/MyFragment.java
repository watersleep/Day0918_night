package program.day0918_night;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class MyFragment extends Fragment {
    private String id;
    private ArrayList<Type> list = new ArrayList<>();
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        id=getArguments().getString("id");
        lv = new ListView(getContext());
        new MyAsynTask().execute("http://www.tngou.net/api/cook/list?id=" + id);
        return lv;
    }

    public class MyAsynTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String json = GetJson.getJson(params[0]);
            return json;
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONArray tngou = new JSONObject(s).getJSONArray("tngou");
                for (int i = 0; i < tngou.length(); i++) {
                    JSONObject data = tngou.getJSONObject(i);
                    String description = data.getString("description");
                    String food = data.getString("food");
                    String keywords = data.getString("keywords");
                    String img = data.getString("img");
                    String name = data.getString("name");
                    img="http://tnfs.tngou.net/image"+img;
                    list.add(new Type(description,keywords,name,img,food));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MyAdaper1 adapter = new MyAdaper1(list, getContext());
            lv.setAdapter(adapter);
        }
    }
}
