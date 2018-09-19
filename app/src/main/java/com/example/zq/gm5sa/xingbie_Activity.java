package com.example.zq.gm5sa;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class xingbie_Activity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("性别统计");
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
//        ActionBar actionBar=getSupportActionBar();
//        if(actionBar!=null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
//        }
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.mipmap.ic_menu, R.mipmap.ic_menu) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        initView();
        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_xingbie);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_shengyuan:
                        Intent intent=new Intent(xingbie_Activity.this,shengyuan.class);
                        startActivity(intent);
                        xingbie_Activity.this.finish();
                        break;
                    case R.id.nav_xingbie:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_xuesheng:
                        Intent intent1=new Intent(xingbie_Activity.this,xuesheng_Activity.class);
                        startActivity(intent1);
                        xingbie_Activity.this.finish();
                        break;
                    case R.id.nav_xiaofei:
                        Intent intent2=new Intent(xingbie_Activity.this,xiaofei_Activity.class);
                        startActivity(intent2);
                        xingbie_Activity.this.finish();
                        break;
                    case R.id.nav_xueba:
                        Intent intent3=new Intent(xingbie_Activity.this,xueba_Activity.class);
                        startActivity(intent3);
                        xingbie_Activity.this.finish();
                        break;
                    case R.id.nav_zhaosheng:
                        Intent intent4=new Intent(xingbie_Activity.this,zhaosheng_Activity.class);
                        startActivity(intent4);
                        xingbie_Activity.this.finish();
                        break;
                    case R.id.nav_jiuye:
                        Intent intent5=new Intent(xingbie_Activity.this,jiuye_Activity.class);
                        startActivity(intent5);
                        xingbie_Activity.this.finish();
                        break;
                    case R.id.nav_guanyu:
                        Toast.makeText(xingbie_Activity.this,"Copyright© Give Me Five S \n We are all in this together",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
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
//            case R.id.settings:
//                Toast.makeText(this,"右滑有惊喜",Toast.LENGTH_SHORT).show();
//                break;
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
        View view1=mInflater.inflate(R.layout.web, null);
        WebView webView1 = view1.findViewById(R.id.web_view);
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.getSettings().setSupportZoom(true);
        webView1.getSettings().setBuiltInZoomControls(true);
        webView1.getSettings().setDisplayZoomControls(false);
        webView1.getSettings().setUseWideViewPort(true);
        webView1.getSettings().setLoadWithOverviewMode(true);
        webView1.loadUrl("http://gm5s.tech:88/towersexjiguan.html");
        View view2=mInflater.inflate(R.layout.web, null);
        WebView webView2 = view2.findViewById(R.id.web_view);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setSupportZoom(true);
        webView2.getSettings().setBuiltInZoomControls(true);
        webView2.getSettings().setDisplayZoomControls(false);
        webView2.getSettings().setUseWideViewPort(true);
        webView2.getSettings().setLoadWithOverviewMode(true);
        webView2.loadUrl("http://gm5s.tech:88/towersexxueyuan.html");
        View view3=mInflater.inflate(R.layout.web, null);
        WebView webView3 = view3.findViewById(R.id.web_view);
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.getSettings().setSupportZoom(true);
        webView3.getSettings().setBuiltInZoomControls(true);
        webView3.getSettings().setDisplayZoomControls(false);
        webView3.getSettings().setUseWideViewPort(true);
        webView3.getSettings().setLoadWithOverviewMode(true);
        webView3.loadUrl("http://gm5s.tech:88/piesexall.html");
        View view4=mInflater.inflate(R.layout.web, null);
        WebView webView4 = view4.findViewById(R.id.web_view);
        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.getSettings().setSupportZoom(true);
        webView4.getSettings().setBuiltInZoomControls(true);
        webView4.getSettings().setDisplayZoomControls(false);
        webView4.getSettings().setUseWideViewPort(true);
        webView4.getSettings().setLoadWithOverviewMode(true);
        webView4.loadUrl("http://gm5s.tech:88/towersexnianji.html");
        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mTitleList.add("各省份性别比例");
        mTitleList.add("各学院性别比例");
        mTitleList.add("全校性别比例");
        mTitleList.add("各年级性别比例");
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(3)));
        xingbie_Activity.MyPagerAdapter mAdapter = new xingbie_Activity.MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

    }

}
