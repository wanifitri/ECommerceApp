package com.oum.e_commerceapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oum.e_commerceapp.adapter.CategoryAdapter;
import com.oum.e_commerceapp.adapter.ProductAdapter;
import com.oum.e_commerceapp.modal.ProductDomain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductActivity extends Activity {
    GridView gridView;
    TextView txtItemCount;
    int itemCount=0;

    ArrayList<ProductDomain>productDomainArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //kena declare position (amik position dari HomeActivity/get function utk dpatkan position)
        int position = getIntent().getIntExtra("position",0);

        gridView = findViewById(R.id.grid_product);

        productDomainArrayList = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        //View view = inflater.inflate(R.layout.description,null)
        builder.setView(inflater.inflate(R.layout.description, null));
        builder.create();

        Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
        ProductDomain productDomain;
        switch(position){
           case 0:
                String [] clothList = {"BLOUSE","BAJU KORUNG","CARDIGAN","DRESS","LONG-SKIRTS"};
                int [] clothImageList = {R.drawable.blouse,R.drawable.bajukurung,R.drawable.cardigan,R.drawable.dress,R.drawable.ls3};
                String [] clothPriceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};


                for(int i=0;i<clothList.length;i++){
                    productDomain = new ProductDomain(clothList[i],clothPriceList[i],clothImageList[i]);
                    productDomainArrayList.add(productDomain);

                }
                gridView.setAdapter(new ProductAdapter(getApplicationContext(),productDomainArrayList));

                break;
           case 1:
               String [] electronicsList = {"STEAM IRON","WASHING MACHINE","KEETLE","LAPTOPS","STEAMER"};
               int []  electronicsImageList = {R.drawable.steamer,R.drawable.mesinbasuh,R.drawable.kettle,R.drawable.laptops,R.drawable.steameri};
               String [] electronicsPriceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};

               for(int i=0;i<electronicsList.length;i++){
                   productDomain = new ProductDomain(electronicsList[i],electronicsPriceList[i],electronicsImageList[i]);
                   productDomainArrayList.add(productDomain);

               }
               gridView.setAdapter(new ProductAdapter(getApplicationContext(),productDomainArrayList));

                break;
           case 2:
                String [] softwareList = {"ANTI-VIRUS","BAJU KORUNG","CARDIGAN","DRESS","LONG-SKIRTS"};
                int [] softwareImageList = {R.drawable.antivirus,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j};
                String [] softwarePriceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};

               for(int i=0;i<softwareList.length;i++) {
                   productDomain = new ProductDomain(softwareList[i], softwarePriceList[i], softwareImageList[i]);
                   productDomainArrayList.add(productDomain);
               }

                gridView.setAdapter(new ProductAdapter(getApplicationContext(),productDomainArrayList));

              break;
           case 3:
                String [] cellPhoneList = {"PHONE 1","PHONE 2","PHONE 3","PHONE 4","PHONE 5","PHONE 6"};
                int [] cellPhoneImageList = {R.drawable.mobilephone1,R.drawable.mobilephone2,R.drawable.mobilephone3,R.drawable.mobilephone4,R.drawable.mobilephone5,R.drawable.mobilephone6};
                String [] cellPhonePriceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};

               for(int i=0;i<cellPhoneList.length;i++) {
                   productDomain = new ProductDomain(cellPhoneList[i], cellPhonePriceList[i], cellPhoneImageList[i]);
                   productDomainArrayList.add(productDomain);
               }

                gridView.setAdapter(new ProductAdapter(getApplicationContext(),productDomainArrayList));

               break;
           case 4:
                String [] automobileList = {"CAR 1","CAR 2","CAR 3","CAR 4","CAR 5","CAR 5","CAR 6"};
                int [] automobileImageList = {R.drawable.keta1,R.drawable.keta2,R.drawable.keta3,R.drawable.keta4,R.drawable.keta5,R.drawable.keta6,};
                String [] automobilePriceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};

               for(int i=0;i<automobileList.length;i++) {
                   productDomain = new ProductDomain(automobileList[i], automobilePriceList[i], automobileImageList[i]);
                   productDomainArrayList.add(productDomain);
               }

               gridView.setAdapter(new ProductAdapter(getApplicationContext(),productDomainArrayList));

                break;

             default:
                 String [] defaultList = {"BLOUSE","BAJU KORUNG","CARDIGAN","DRESS","LONG-SKIRTS"};
                 int [] defaultImageList = {R.drawable.samsung_galaxy,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j};

        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_LONG).show();
                productDetails(productDomainArrayList.get(i).getProductName(),productDomainArrayList.get(i).getProductPrice(),
                productDomainArrayList.get(i).getImageId(),i);

            }
        });

    }
    public void productDetails(String productName, String productPrice, int imgId , final int position){
        final AlertDialog alert;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater= (LayoutInflater) this
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //Inflate and set the layout for the dialog
        //pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.description, null);

        builder.setView(view);
        alert = builder.create();
        alert.show();

        //this for each product click to add to cart
        TextView txtProduct = view.findViewById(R.id.txt_product_name);
        TextView txtPrice = view.findViewById(R.id.txt_price);
        ImageView imageView = view.findViewById(R.id.img_product);
        Button btnCart = view.findViewById(R.id.txt_button);

        txtProduct.setText(productName);
        txtPrice.setText(productPrice);
        imageView.setImageResource(imgId);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cartArray.add(productDomainArrayList.get(position));
                //itemCount++;
                alert.dismiss();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);


        final View notifications = menu.findItem(R.id.cart_item).getActionView();

        txtItemCount = (TextView) notifications.findViewById(R.id.cart_badge);
        updateHotCount(itemCount++);
        txtItemCount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateHotCount(itemCount++);
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Handle item selection
        switch (item.getItemId()) {
            case R.id.cart_item:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void updateHotCount(final int new_number){
    itemCount = new_number;
    if(itemCount <0) return ;
    runOnUiThread(new Runnable() {

        @Override
        public void run() {
            if (itemCount == 0) {
                txtItemCount.setVisibility(View.GONE);
            }
            else{
                txtItemCount.setVisibility(View.VISIBLE);
                txtItemCount.setText(Integer.toString(itemCount));
                // supportInvalidateOptionsMenu();
            }
        }
    });
}




}
