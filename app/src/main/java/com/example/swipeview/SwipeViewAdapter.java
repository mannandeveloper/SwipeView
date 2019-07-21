package com.example.swipeview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SwipeViewAdapter extends PagerAdapter
{
    private List<Model> modelList;
    private LayoutInflater mInflater;
    private Context mContext;

    public SwipeViewAdapter(List<Model> modelList,Context mContext)
    {
        this.modelList = modelList;
        this.mContext = mContext;
    }

    @Override
    public int getCount()
    {
        return modelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.card_view , container , false);
        ImageView image;
        TextView name,price;

        image = view.findViewById(R.id.imageView);
        name = view.findViewById(R.id.name);
        price = view.findViewById(R.id.price);

        image.setImageResource(modelList.get(position).getImage());
        name.setText(modelList.get(position).getName());
        price.setText(modelList.get(position).getPrice());

        container.addView(view , 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        ((ViewPager)container).removeView((View)object);
    }
}
