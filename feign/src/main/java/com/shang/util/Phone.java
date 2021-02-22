package com.shang.util;

public class Phone {
    public boolean phone(String number){
        if(number.length()!=11){
            return false;
        }
//        if(number.substring(0,1) != "1") {
//            return false;
//        }
        return true;
    }
}
