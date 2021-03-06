package com.example.zq.gm5sa;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
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
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class jiuye_Activity extends AppCompatActivity {
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
        toolbar.setTitle("就业信息");
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
        navView.setCheckedItem(R.id.nav_jiuye);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_shengyuan:
                        Intent intent=new Intent(jiuye_Activity.this,shengyuan.class);
                        startActivity(intent);
                        jiuye_Activity.this.finish();
                        break;
                    case R.id.nav_xingbie:
                        Intent intent5=new Intent(jiuye_Activity.this,xingbie_Activity.class);
                        startActivity(intent5);
                        jiuye_Activity.this.finish();
                        break;
                    case R.id.nav_xuesheng:
                        Intent intent1=new Intent(jiuye_Activity.this,xuesheng_Activity.class);
                        startActivity(intent1);
                        jiuye_Activity.this.finish();
                        break;
                    case R.id.nav_xiaofei:
                        Intent intent2=new Intent(jiuye_Activity.this,xiaofei_Activity.class);
                        startActivity(intent2);
                        jiuye_Activity.this.finish();
                        break;
                    case R.id.nav_xueba:
                        Intent intent3=new Intent(jiuye_Activity.this,xueba_Activity.class);
                        startActivity(intent3);
                        jiuye_Activity.this.finish();
                        break;
                    case R.id.nav_zhaosheng:
                        Intent intent4=new Intent(jiuye_Activity.this,zhaosheng_Activity.class);
                        startActivity(intent4);
                        jiuye_Activity.this.finish();
                        break;
                    case R.id.nav_jiuye:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_guanyu:
                        Toast.makeText(jiuye_Activity.this,"Copyright© Give Me Five S \n We are all in this together",Toast.LENGTH_SHORT).show();
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
        View view1=mInflater.inflate(R.layout.videoview, null);
        VideoView videoView=view1.findViewById(R.id.videoView);
        String uri1 = "android.resource://" + getPackageName() + "/" + R.raw.jiuyequxiang;
        Uri uri = Uri.parse( uri1);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        View view2=mInflater.inflate(R.layout.web, null);
        WebView webView2 = view2.findViewById(R.id.web_view);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setSupportZoom(true);
        webView2.getSettings().setBuiltInZoomControls(true);
        webView2.getSettings().setDisplayZoomControls(false);
        webView2.getSettings().setUseWideViewPort(true);
        webView2.getSettings().setLoadWithOverviewMode(true);
        webView2.loadUrl("http://gm5s.tech:88/mapjiuye.html");
        View view3=mInflater.inflate(R.layout.web, null);
        WebView webView3 = view3.findViewById(R.id.web_view);
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.getSettings().setSupportZoom(true);
        webView3.getSettings().setBuiltInZoomControls(true);
        webView3.getSettings().setDisplayZoomControls(false);
        webView3.getSettings().setUseWideViewPort(true);
        webView3.getSettings().setLoadWithOverviewMode(true);
        webView3.loadUrl("http://gm5s.tech:88/barjiuye.html");
        View view4=mInflater.inflate(R.layout.web, null);
        WebView webView4 = view4.findViewById(R.id.web_view);
        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.getSettings().setSupportZoom(true);
        webView4.getSettings().setBuiltInZoomControls(true);
        webView4.getSettings().setDisplayZoomControls(false);
        webView4.getSettings().setUseWideViewPort(true);
        webView4.getSettings().setLoadWithOverviewMode(true);
        webView4.loadUrl("http://gm5s.tech:88/barjiuyehangye.html");
        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mTitleList.add("就业去向可视化");
        mTitleList.add("就业去向图谱");
        mTitleList.add("就业去向数据视图");
        mTitleList.add("就业去向行业视图");
//        mTitleList.add("贫困学子生源图谱");
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(3)));
        jiuye_Activity.MyPagerAdapter mAdapter = new jiuye_Activity.MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

    }

}
