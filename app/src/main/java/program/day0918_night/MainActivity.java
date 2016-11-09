package program.day0918_night;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout table;
    private ViewPager vp;
    private ArrayList<Fragment> ilist = new ArrayList<>();
    private ArrayList<String> tlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        table = ((TabLayout) findViewById(R.id.table));
        vp = ((ViewPager) findViewById(R.id.vp));
        new MyAsynTask().execute("http://www.tngou.net/api/cook/classify");

    }

    public class MyAsynTask extends AsyncTask<String, Void, MyAdapter> {

        @Override
        protected MyAdapter doInBackground(String... params) {
            String json = GetJson.getJson(params[0]);
            try {
                JSONArray tngou = new JSONObject(json).getJSONArray("tngou");
                for (int i = 0; i < tngou.length(); i++) {
                    JSONObject data = tngou.getJSONObject(i);
                    String title = data.optString("title");
                    String id = data.optString("id");

                    MyFragment fragment = new MyFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", id);
                    fragment.setArguments(bundle);
                    ilist.add(fragment);
                    tlist.add(title);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), ilist, tlist);

            return adapter;
        }

        @Override
        protected void onPostExecute(MyAdapter adapter) {
            vp.setAdapter(adapter);
            table.setupWithViewPager(vp);

            table.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }
}
