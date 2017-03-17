package com.fengniao.materialtest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        setTitle("toolbar");
        //获取actionBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //显示导航图标
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置导航图标
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        }
        //设置默认选中项
//        navView.setCheckedItem(R.id.nav_call);
        //设置菜单选中事件监听器
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //开启侧拉菜单
            mDrawerLayout.openDrawer(GravityCompat.START);
            startActivity(new Intent(MainActivity.this,ViewActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
