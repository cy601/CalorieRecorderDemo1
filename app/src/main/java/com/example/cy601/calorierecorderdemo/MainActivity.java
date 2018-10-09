package com.example.cy601.calorierecorderdemo;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.cy601.greendao.ItemDao;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;

//https://blog.csdn.net/zhaozhuzi/article/details/70598382
public class MainActivity extends AppCompatActivity {
    private Button editBtn,queryBtn;
    private EditText beginData,endData;
    private GraphView graph;
    private ItemDao itemDao = GreenDaoHelper.getDaoSession().getItemDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //database

    }
    private void init(){
        itemDao.loadAll();
        editBtn=(Button)findViewById(R.id.editBtn);
        queryBtn=(Button)findViewById(R.id.queryBtn);
        beginData=(EditText)findViewById(R.id.beginData);
        endData=(EditText)findViewById(R.id.endData);
        graph = (GraphView) findViewById(R.id.graph);
        endData.setInputType(InputType.TYPE_NULL);  // let it no pop the keyboard
        beginData.setInputType(InputType.TYPE_NULL);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Edit_activity.class);
                startActivity(intent);
            }
        });
        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        //设置开始日期
        beginData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            beginData.setText(year+"-"+(month+1)+"-"+dayOfMonth);

                    }
                },2018,0,1).show();
               }
        });

        //设置结束日期
    endData.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    endData.setText(year+"-"+(month+1)+"-"+dayOfMonth);

            }
        },2018,4,1).show();
    }
});

    //绘制图表Graph
 LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

    }


    }



