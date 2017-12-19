package com.example.mravi.infrmr.util;

//import java.text.SimpleDateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by mravi on 20-12-2017.
 */

public class Util {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String dateFormatted(String dateString){
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat dateFormat=new SimpleDateFormat("EEE,d MM yyyy");

        return dateFormat.format(date);

    }

}
