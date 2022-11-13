package com.example.projectapp.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.projectapp.Domain.GunDomain;
import com.example.projectapp.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context, TinyDB tinyDB) {
        this.context = context;
        this.tinyDB = tinyDB;
    }

    public void insertFood(GunDomain item){
        ArrayList<GunDomain> listGun = getListCart();
        boolean existAlready = false;
        int n= 0;
        for (int i = 0; i < listGun.size(); i++) {
            if (listGun.get(i).getTitle().equals(item.getTitle())){
                existAlready = true;
                n=i;
                break;
            }
        }
        if(existAlready){
            listGun.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            listGun.add(item);
        }

        tinyDB.putListObject("CardList", listGun);
        Toast.makeText(context, "Added to yor Cart", Toast.LENGTH_SHORT).show();
    }

    private ArrayList<GunDomain> getListCart(){
        return tinyDB.getListObject("CardList");


    }

    public void minusNumberFood(ArrayList<GunDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if(listFood.get(position).getNumberInCart()==1){
            listFood.remove(position);
        }else{
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() - 1);

            }
        tinyDB.putListObject("Cardlist", listFood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<GunDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("Carlist", listFood);
        changeNumberItemsListener.changed();
    }

    /*public Double getTotalFee(){
        ArrayList<FoodDomain> listfood2 = getListCart();
        double fee = 0;
        //for (int i = 0; i < listfood2.size(); i++) {
        //    fee=fee+(listfood2.get());
        //}
    }*/
}
