package com.oum.e_commerceapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oum.e_commerceapp.R;
import com.oum.e_commerceapp.modal.ProductDomain;

import java.util.ArrayList;

/**
 * Created by seqato on 15/03/18.
 */

public class ProductAdapter extends BaseAdapter {
    ArrayList<ProductDomain> productDomainArrayList;
    LayoutInflater layoutInflater;
    Context context;


    public ProductAdapter(Context context, ArrayList<ProductDomain> productDomainArrayList) {
        this.context = context;
        this.productDomainArrayList = productDomainArrayList;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return productDomainArrayList.size();
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.product_list, null);
        }

        TextView title = (TextView) convertView.findViewById(R.id.category_name);
        TextView pricetxt = (TextView) convertView.findViewById(R.id.price);
        ImageView img=(ImageView)convertView.findViewById(R.id.flag);


        // setting the image resource and title
        title.setText(productDomainArrayList.get(position).getProductName());
        pricetxt.setText(productDomainArrayList.get(position).getProductPrice());
        img.setImageResource(productDomainArrayList.get(position).getImageId());

        return convertView;


    }
}


