package com.allchip.pack.web;

import com.allchip.pack.utils.QRCodeUtil;
import com.google.zxing.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 二维码调用前端控制器
 */
@RequestMapping("/Qrcode")
@RestController
public class QrcodeController {

    /**
     * 生成二维码
     */
    @GetMapping
    public void productcode() {
//        QRCodeUtil.zxingCodeCreate("this is test ", "./",100,"");
        QRCodeUtil.doPrint();
    }


    /**
     * 解析二维码
     */
    @GetMapping("/test")
    public void analysiscode() {
        Result result = QRCodeUtil.zxingCodeAnalyze("D:/voice/picture/2018/759.jpg");
        System.err.println("二维码解析内容："+result.toString());
    }

}