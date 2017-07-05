package com.manong.crosswalkdemo.view;

import android.content.Context;
import android.util.AttributeSet;

import com.manong.crosswalkdemo.R;

import org.xwalk.core.XWalkView;

/**
 * Created by Point on 2017/4/14.
 */

public class MyWebView extends XWalkView {
	public MyWebView(Context context) {
		super(context);
		init();
	}

	public MyWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init(){
//		setBackgroundColor(0);
//		setBackground(null);

//		setBackgroundResource(R.drawable.bg);

	}

}
