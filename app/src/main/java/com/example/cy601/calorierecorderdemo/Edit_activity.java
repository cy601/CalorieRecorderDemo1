package com.example.cy601.calorierecorderdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Edit_activity extends Activity {
    private Button plusBtn;
    private ListView listView;
    private ArrayList<String> calorieView = new ArrayList<String>();
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);
init();
    }


    public void init(){
     plusBtn=(Button)findViewById(R.id.plusBtn);
     listView=(ListView)findViewById(R.id.listView);
     listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,calorieView));

        //Long click to delete some item
        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

    //定义AlertDialog.Builder对象，当长按列表项的时候弹出确认删除对话框
                AlertDialog.Builder builder=new AlertDialog.Builder(Edit_activity.this);
                builder.setMessage("Are you sure to delete this record?");
                builder.setTitle("DeleteItem Dialog");
                //添加AlertDialog.Builder对象的setPositiveButton()方法
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                       // listView.()
                        //获取日期 用于删除item
                      //  toDelete();
                        Toast.makeText(getBaseContext(), "Delete sucessfully", Toast.LENGTH_SHORT).show();
                    }
                });
                //添加AlertDialog.Builder对象的setNegativeButton()方法
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create().show();

                return false;
            }
        });



        //add listener for plusBtn,when click,open a new activity
     plusBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             plusBtn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(Edit_activity.this, AddCalorie_acitvity.class);
                     startActivity(intent);
                 }
             });
         }
     });
    }



/*
    //delete some data by calorie date
    public void toDelete(int calorie){
        //to get the object from database
        SQLiteDB DB=new SQLiteDB(getApplicationContext());
        SQLiteDatabase db=DB.getWritableDatabase();
        String st=Integer.toString(calorie);
        db.delete("calorie","calorie=?",new String[]{st.valueOf(7)});
        //To make this behavior be a transaction event
        db.setTransactionSuccessful();

    }
*/

}
