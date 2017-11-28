package com.gupao.web.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by
 * on 17/3/6.
 * Description:
 */
@Service
@Scope("prototype")
public class TestService {

    public void test(){
        System.out.println("hello");
    }
}
