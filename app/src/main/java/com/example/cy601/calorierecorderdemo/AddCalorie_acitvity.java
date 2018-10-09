package com.example.cy601.calorierecorderdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cy601.greendao.ItemDao;

import java.util.Date;

public class AddCalorie_acitvity extends Activity {

    private CalendarView calendarView;
    private Button updateBtn;
    private EditText calorieData;
    private Date date;
    private ItemDao itemDao = GreenDaoHelper.getDaoSession().getItemDao();
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcalorie_activity);
        init();


    }

    private void init() {

        updateBtn = (Button) findViewById(R.id.updateBtn);
        calorieData = (EditText) findViewById(R.id.calorieData);
        calendarView = (CalendarView) findViewById(R.id.calendar);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //存储到数据库
                toInsert();


                //test
                //  String input=calorieData.getText().toString();
                //calorieData.setText(date);

            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //date = year + "-" + (month + 1) + "-" + dayOfMonth;
                //Toast.makeText(this,time,Toast.LENGTH_LONG).show();
                date=new Date(year,month,dayOfMonth);
                Toast.makeText(AddCalorie_acitvity.this,year+"-"+month+"-"+dayOfMonth, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //添加到数据库中
    public void toInsert() {

        /*
        //获取数据库操作对象
        SQLiteDB sqLiteDB = new SQLiteDB(this);
        SQLiteDatabase db = sqLiteDB.getReadableDatabase();
        ContentValues values = new ContentValues();
        //获取输入数据
        String dateDT = date;
        String calorieDT = calorieData.getText().toString();
        values.put("date",dateDT);
        values.put("calorie",calorieDT);
        //values.put("calorie",calorieDT);
        //将数据插入到数据库中
        Log.d("test", "insert  classes:");
        db.insert("calorieTable",null,values);
        Log.d("test", "insert  succeed:");
        db.setTransactionSuccessful();  //将修改数据的操作当作事务处理
     //   values.clear();//清除缓冲区数据
       //     db.close();
            Toast.makeText(getApplicationContext(), "adding sucessfully!", Toast.LENGTH_SHORT).show();
            calorieData.setText("");
           }
           */
        int Calorie=Integer.valueOf(calorieData.getText().toString());
        itemDao.insert(new Item(null,null,Calorie));
        itemDao.loadAll();

    }


}