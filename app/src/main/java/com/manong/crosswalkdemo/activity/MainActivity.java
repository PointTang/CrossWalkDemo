package com.manong.crosswalkdemo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.manong.crosswalkdemo.R;
import com.manong.crosswalkdemo.BaseActivity;

import org.xwalk.core.XWalkView;

//需要搭配Baseactivity，这里默认为Baseactivity,并且默认BaseActivity为包名的根目录
public class MainActivity extends BaseActivity {
    private XWalkView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_main);
        isSetNavigationIcon = false;
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_main));
    }

    //初始化UI控件
    private void initView() {
        webView = (XWalkView) findViewById(R.id.webView);
        webView.loadUrl("https://www.baidu.com");
    }

    //初始化数据
    private void initData() {

    }

}
