package com.liuwan.customview;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.liuwan.customview.bean.PieChartData;
import com.liuwan.customview.widget.PieChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuwan on 2016/9/23.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private LinearLayout back;
    private PieChartView pieChartView;
    private List<PieChartData> pieChartDatas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        back = (LinearLayout) findViewById(R.id.back);
        back.setOnClickListener(this);

        /**
         * 初始化饼图
         */
        pieChartView = (PieChartView) findViewById(R.id.customPieChart);
        // 从12点钟方向开始
        pieChartView.setStartAngle(270);
        // 分割线与背景色相同
        pieChartView.setLineColor(ContextCompat.getColor(this, R.color.color2));
        // 字体白色
        pieChartView.setTextColor(ContextCompat.getColor(this, R.color.color1));
        // 扇形半径和遮盖圆半径
        pieChartView.setRadius(250, 25);

        /**
         * 添加数据
         */
        pieChartDatas = new ArrayList<>();
        PieChartData pcd1 = new PieChartData();
        pcd1.percent = 55;
        pcd1.content = "工作票";
        pcd1.color = ContextCompat.getColor(this, R.color.color11);
        pieChartDatas.add(pcd1);
        PieChartData pcd2 = new PieChartData();
        pcd2.percent = 32;
        pcd2.content = "操作票";
        pcd2.color = ContextCompat.getColor(this, R.color.color13);
        pieChartDatas.add(pcd2);
        PieChartData pcd3 = new PieChartData();
        pcd3.percent = 13;
        pcd3.content = "缺陷";
        pcd3.color = ContextCompat.getColor(this, R.color.color5);
        pieChartDatas.add(pcd3);
        pieChartView.setPieChartData(pieChartDatas);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                MainActivity.this.finish();
                break;
        }
    }

}