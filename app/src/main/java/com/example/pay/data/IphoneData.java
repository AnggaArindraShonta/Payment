package com.example.pay.data;

import com.example.pay.R;
import com.example.pay.model.Iphone;

import java.util.ArrayList;

public class IphoneData {
    private  static String [] name = {
            "Iphone 6",
            "Iphone 6S Plus",
            "Iphone 7",
            "Iphone 7 Plus",
            "Iphone 8",
            "Iphone 8 Plus",
            "Iphone X",
            "Iphone XS Max"
    };
    private static  String [] rating = {
            "2.1",
            "2.3",
            "3.2",
            "3.5",
            "4.0",
            "4.2",
            "4.3",
            "4.5",
    };
    private static String [] price = {
            "Rp. 1.200.000",
            "Rp. 1.500.000",
            "Rp. 2.200.000",
            "Rp. 3.800.000",
            "Rp. 3.000.000",
            "Rp. 4.500.000",
            "Rp. 6.200.000",
            "Rp. 7.500.000"
    };
    private static String [] type={
            "Internal Memory 64GB",
            "Internal Memory 64GB",
            "Internal Memory 256GB",
            "Internal Memory 256GB",
            "Internal Memory 64GB",
            "Internal Memory 64GB",
            "Internal Memory 128GB",
            "Internal Memory 128GB"
    };
    private  static  int [] image = {
            R.drawable.iphone6,
            R.drawable.iphone6splus,
            R.drawable.iphone7,
            R.drawable.iphone7plus,
            R.drawable.iphone8,
            R.drawable.iphone8plus,
            R.drawable.iphonex,
            R.drawable.iphonexsmax
    };
    public static ArrayList <Iphone> getListData(){
        ArrayList<Iphone> list = new ArrayList<>();
        for (int position = 0 ; position < name.length; position++){
            Iphone iphone = new Iphone();
            iphone.setRating(rating[position]);
            iphone.setIphone_name(name[position]);
            iphone.setPrice(price[position]);
            iphone.setType(type[position]);
            iphone.setImage(image[position]);
            list.add(iphone);
        }
        return list;
    }
}
