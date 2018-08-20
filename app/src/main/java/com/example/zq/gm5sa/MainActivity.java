package com.example.zq.gm5sa;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private String[] a={"省份生源图谱","优秀学子生源图谱","贫困学子生源图谱"};
    private String[] b={"省份男女比例","学院男女比例"};
    private String[] c={"各年级一卡通消费趋势","一卡通消费年级总计","一卡通消费性别总计","一卡通消费省份总计"};
    private String[] d={"就业地市图谱","岗位性质统计"};
    private String[] e={"各省份计划招生图谱","各地市计划招生图谱","留学生计划招生图谱"};
    private String[] f={"各学院学生数量和占比"};
    private String[] g={"学霸指数图谱","榜上有名"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        }
        initView();
        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.settings:
                Toast.makeText(this,"右滑有惊喜",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //这里这个一定要写，不然卡片标题显示不出来
            return mTitleList.get(position);//页卡标题
        }
    }
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        mInflater = LayoutInflater.from(this);
        View view1=mInflater.inflate(R.layout.list, null);
        ListView listview1 = view1.findViewById(R.id.listView_id);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,a);
        listview1.setAdapter(adapter1);
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this,web.class);
                        startActivity(intent);
                        break;
                    default:
                }
            }
        });
        View view2=mInflater.inflate(R.layout.list, null);
        ListView listview2 = view2.findViewById(R.id.listView_id);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,a);
        listview2.setAdapter(adapter2);
        View view3=mInflater.inflate(R.layout.list, null);
        ListView listview3 = view3.findViewById(R.id.listView_id);
        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,a);
        listview3.setAdapter(adapter3);
        View view4=mInflater.inflate(R.layout.list, null);
        ListView listview4 = view4.findViewById(R.id.listView_id);
        ArrayAdapter<String> adapter4=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,a);
        listview4.setAdapter(adapter4);
        View view5=mInflater.inflate(R.layout.list, null);
        ListView listview5 = view5.findViewById(R.id.listView_id);
        ArrayAdapter<String> adapter5=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,a);
        listview5.setAdapter(adapter5);
        View view6=mInflater.inflate(R.layout.list, null);
        ListView listview6 = view6.findViewById(R.id.listView_id);
        ArrayAdapter<String> adapter6=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,a);
        listview6.setAdapter(adapter6);
        View view7=mInflater.inflate(R.layout.list, null);
        ListView listview7 = view7.findViewById(R.id.listView_id);
        ArrayAdapter<String> adapter7=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,a);
        listview7.setAdapter(adapter7);
        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mViewList.add(view5);
        mViewList.add(view6);
        mViewList.add(view7);
        //添加页卡标题{"生源", "性别" ,"消费","就业","招生","学生数量","学霸指数"};
        mTitleList.add("生源");
        mTitleList.add("性别");
        mTitleList.add("消费");
        mTitleList.add("就业");
        mTitleList.add("招生");
        mTitleList.add("学生数量");
        mTitleList.add("学霸指数");
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(3)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(4)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(5)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(6)));
        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

    }

}
