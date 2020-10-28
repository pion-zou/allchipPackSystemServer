package com.allchip.pack.web;

import com.allchip.pack.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GoodController {
    @Autowired
    GoodMapper goodMapper;


}
