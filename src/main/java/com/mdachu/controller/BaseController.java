package com.mdachu.controller;

import java.util.UUID;

/**
 * Created by mm on 2017/4/28.
 */
public class BaseController {

    public static void main(String[] args){
        System.out.printf("this is a test println");
    }

    public String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }


}
