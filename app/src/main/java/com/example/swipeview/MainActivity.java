package com.example.swipeview;

import android.animation.ArgbEvaluator;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ViewPager mViewPager;
    private SwipeViewAdapter mAdapter;
    private Integer[] color = null;
    private ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();
    private List<Model> mList;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<>();
        mList.add(new Model(R.drawable.pic1 , "Velvet Blazer" , "Price : 2,500"));
        mList.add(new Model(R.drawable.pic2 , "Velvet Blazer" , "Price : 3000"));
        mList.add(new Model(R.drawable.pic3 , "Velvet Blazer" , "Price : 1,800"));
        mList.add(new Model(R.drawable.pic4 , "Green Sherwani" , "Price : 3,500"));
        mList.add(new Model(R.drawable.images , "Pants" , "Price : 1,200"));
        mList.add(new Model(R.drawable.greensherwani , "Green Sherwani" , "Price : 4000"));
        mList.add(new Model(R.drawable.fullsleevetshirts , "Full Sleeve T-Shirt" , "Price : 1000"));
        mList.add(new Model(R.drawable.fullsleevetshirt , "Full Sleeve T-Shirt" , "Price : 1000"));
        mList.add(new Model(R.drawable.formalpants , "Formail Pants" , "Price : 1,200"));
        mList.add(new Model(R.drawable.pic1 , "Velvet Blazer" , "Price : 2,500"));
        mList.add(new Model(R.drawable.pic2 , "Velvet Blazer" , "Price : 3000"));
        mList.add(new Model(R.drawable.pic3 , "Velvet Blazer" , "Price : 1,800"));
        mList.add(new Model(R.drawable.pic4 , "Green Sherwani" , "Price : 3,500"));
        mList.add(new Model(R.drawable.images , "Pants" , "Price : 1,200"));
        mList.add(new Model(R.drawable.greensherwani , "Green Sherwani" , "Price : 4000"));
        mList.add(new Model(R.drawable.fullsleevetshirts , "Full Sleeve T-Shirt" , "Price : 1000"));
        mList.add(new Model(R.drawable.fullsleevetshirt , "Full Sleeve T-Shirt" , "Price : 1000"));
        mList.add(new Model(R.drawable.formalpants , "Formail Pants" , "Price : 1,200"));
        mList.add(new Model(R.drawable.fullsleevetshirts , "Full Sleeve T-Shirt" , "Price : 1000"));
        mList.add(new Model(R.drawable.fullsleevetshirt , "Full Sleeve T-Shirt" , "Price : 1000"));
        mList.add(new Model(R.drawable.formalpants , "Formail Pants" , "Price : 1,200"));
        mList.add(new Model(R.drawable.fullsleevetshirts , "Full Sleeve T-Shirt" , "Price : 1000"));
        mList.add(new Model(R.drawable.fullsleevetshirt , "Full Sleeve T-Shirt" , "Price : 1000"));
        mList.add(new Model(R.drawable.formalpants , "Formail Pants" , "Price : 1,200"));




       mAdapter = new SwipeViewAdapter(mList , this);
       mViewPager = findViewById(R.id.viewPager);
       mViewPager.setAdapter(mAdapter);
       mViewPager.setPadding(130,0,130,0);

       Integer[] colors = {getResources().getColor(R.color.color1) ,
                           getResources().getColor(R.color.color2) ,
                           getResources().getColor(R.color.color3) ,
                           getResources().getColor(R.color.color4) ,
                           getResources().getColor(R.color.color5) ,
                           getResources().getColor(R.color.color6) ,
                           getResources().getColor(R.color.color7) ,
                           getResources().getColor(R.color.color8) ,
                           getResources().getColor(R.color.color9) ,
                           getResources().getColor(R.color.color10) ,
                           getResources().getColor(R.color.color11) ,
                           getResources().getColor(R.color.color12)};

       color = colors;

       //This method is for changing background color
       mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
       {
           @Override
           public void onPageScrolled(int position, float positionOffSet, int positionOffSetPixels)
           {
                if (position < (mAdapter.getCount() -1 ) && position < (color.length -1))
                {
                    mViewPager.setBackgroundColor((Integer) mArgbEvaluator.evaluate(positionOffSet , color[position] ,color[position + 1]));
                }
                else
                {
                    mViewPager.setBackgroundColor(color[color.length - 1]);
                }
           }

           @Override
           public void onPageSelected(int i)
           {

           }

           @Override
           public void onPageScrollStateChanged(int i)
           {

           }
       });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_items , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.findFriends)
        {

        }
        if (item.getItemId() == R.id.settings)
        {

        }
        if (item.getItemId() == R.id.logOut)
        {

        }
        return true;
    }
}
