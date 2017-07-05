package com.manong.crosswalkdemo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.manong.crosswalkdemo.R;
import com.manong.crosswalkdemo.BaseActivity;
import com.manong.crosswalkdemo.view.MyWebView;

import org.xwalk.core.XWalkView;

import java.io.File;

//需要搭配Baseactivity，这里默认为Baseactivity,并且默认BaseActivity为包名的根目录
public class MainActivity extends BaseActivity {
    private MyWebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		deleteFilesByDirectory(this.getCacheDir());
        setContentView(R.layout.activity_main);
        //这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_main);
        isSetNavigationIcon = false;
		isShowToolbar = false;

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_main));
		if (webView != null){
			webView.resumeTimers();
			webView.onShow();
		}
    }

    //初始化UI控件
    private void initView() {
        webView = (MyWebView) findViewById(R.id.webView);
//        webView.loadUrl("http://192.168.1.228:3089/get?serialNumber=02040115350000007");
		webView.loadUrl("https://web.viu.com");
    }

    //初始化数据
    private void initData() {

    }

	@Override
	protected void onPause() {
		super.onPause();
		if (webView != null){
			webView.pauseTimers();
			webView.onHide();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (webView != null){
			webView.onDestroy();
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		deleteFilesByDirectory(this.getCacheDir());
		finish();
	}

	private static void deleteFilesByDirectory(File directory) {
		if (directory != null && directory.exists() && directory.isDirectory()) {
			for (File item : directory.listFiles()) {
				item.delete();
			}
		}
	}

}
