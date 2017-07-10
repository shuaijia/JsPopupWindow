package com.jia.jspopwindemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jia.jspopupwindow.JsPopupWindow;

public class MainActivity extends Activity {

    private TextView tv_target1;
    private TextView tv_target2;


    private RelativeLayout rl_pop_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl_pop_root = (RelativeLayout) findViewById(R.id.rl_pop_root);
        tv_target1 = (TextView) findViewById(R.id.tv_target1);
        tv_target2 = (TextView) findViewById(R.id.tv_target2);

        tv_target1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWinAtLocation();
            }
        });

        tv_target2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWinAsLocation();
            }
        });

    }

    private void showPopWinAtLocation() {
         JsPopupWindow popWindow = new JsPopupWindow.Builder()
                .setContentViewId(R.layout.dialog_popupwindow) // 设置布局
                .setContext(MainActivity.this) // 设置上下文
                .setOutSideCancle(true) // 点击外部消失
                .setHeight(LinearLayout.LayoutParams.WRAP_CONTENT) // 设置高度
                .setWidth(LinearLayout.LayoutParams.WRAP_CONTENT) // 设置宽度
                .setAnimation(R.style.anim_pop) // 设置动画
                .build() // 构建
                .showAtLocation(rl_pop_root, Gravity.TOP | Gravity.CENTER, 0, 0); // 必须在build之后，显示popupWindow

        // 获取子控件
        TextView tv_pop= (TextView) popWindow.getItemView(R.id.tv_pop);
        tv_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"PopupWindow的Item点击",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showPopWinAsLocation() {
        JsPopupWindow popWindow = new JsPopupWindow.Builder()
                .setContentViewId(R.layout.dialog_popupwindow)
                .setContext(MainActivity.this)
                .setOutSideCancle(true)
                .setHeight(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setWidth(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setAnimation(R.style.anim_pop)
                .build()
                .showAsLocation(tv_target2, Gravity.BOTTOM | Gravity.CENTER, 0, 0);
    }
}
