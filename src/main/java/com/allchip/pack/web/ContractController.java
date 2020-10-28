package com.allchip.pack.web;

import com.allchip.pack.bean.RequestBean;
import com.allchip.pack.mapper.ContractMapper;
import com.allchip.pack.mapper.GoodMapper;
import com.allchip.pack.pojo.Contract;
import com.allchip.pack.pojo.Good;
import com.allchip.pack.pojo.User;
import com.allchip.pack.utils.ExcelUtils;
import com.allchip.pack.utils.QRCodeUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ContractController {
    @Autowired
    ContractMapper contractMapper;

    @Autowired
    GoodMapper goodMapper;

    /**路由 */
    //显示所有订单
    @RequestMapping("/listContract")
    public String listContract(Model model) throws Exception{
        List<Contract> list = contractMapper.findAll();
        model.addAttribute("list" , list);
        return "listContract";
    }
    @RequestMapping("/addContractPage")
    public String addCategoryPage(Model model) throws Exception {
        return "addContract";
    }

    @RequestMapping("/editContractPage")
    public String editCategoryPage(int id , Model m) throws Exception {
        Contract c = contractMapper.getById(id);
        m.addAttribute("c", c);
        return "editContract";
    }

    @RequestMapping("/editGoodPage")
    public String editGoodPage(int id , Model m) throws Exception {
        Good g = goodMapper.getById(id );
        m.addAttribute("g", g);
        return "editGood";
    }

    @RequestMapping("/contractDetailPage")
    public String contractDetailPage(int id , Model m) throws Exception {
        Contract c = contractMapper.getById(id);
        List<Good> goodList = goodMapper.getByNumber(c.getNumber());
        c.setGoodList(goodList);
        m.addAttribute("c", c);
        return "contractDetail";
    }

    @RequestMapping("/msgPage")
    public String msgPage(String msg ,  Model m) throws Exception {
        m.addAttribute("content" , msg);
        return "msg";
    }



    /**提供给前端接口 */
    /**合同*/
    //编辑合同
    @RequestMapping("/editContract")
    public String editCategory(Contract c) throws Exception {
        contractMapper.update(c);
        return "redirect:listContract";
    }

    //新建订单
    @RequestMapping("/addCategory")
    public String listCategory(Contract c) throws Exception {
        contractMapper.save(c);
        return "redirect:listContract";
    }

    /**货物*/
    //清空货物
    @RequestMapping("/removeGoods")
    public String removeGoods(String number , Model model) throws Exception{
        goodMapper.delete(number);
        model.addAttribute("content" , "删除成功");
        model.addAttribute("last" , "/listContract");
        model.addAttribute("last_value" , "返回首页");
        return "msg";
    }

    //编辑货物
    @RequestMapping("/editGood")
    public String editGood(Good g) throws Exception {
        goodMapper.update(g);
        System.out.println("editGood :" + g.getNumber());
        Contract contract = contractMapper.getByNumber(g.getNumber());
        return "redirect:contractDetailPage?id="+contract.getId();
    }

    /**其他*/
    /**打印二维码*/
    @RequestMapping("printQRCode")
    public String printQRCode(String number ,  Model model) throws Exception{
        Contract contract = contractMapper.getByNumber(number);
        contract.setGoodList(goodMapper.getByNumber(contract.getNumber()));
        if(contract.getGoodList() != null && contract.getGoodList().size() > 0){
            for(Good good : contract.getGoodList()){
                QRCodeUtil.doPrint(good);
            }
            model.addAttribute("content" , "打印成功");
        }else{
            model.addAttribute("content" , "没有货物");

        }
        model.addAttribute("last" , "/contractDetailPage?id="+contract.getId());
        model.addAttribute("last_value" , "返回详情");
        return "msg";

    }


    //上传excel
    @RequestMapping("file/upload_excel")
    public String uploadExcel(@RequestParam("file") MultipartFile file , String id ,Model model) throws Exception {
        String name=file.getOriginalFilename();
        if(name.length()<6|| !name.substring(name.length()-5).equals(".xlsx")){
            model.addAttribute("content" , "格式错误，需要xlsx结尾的格式文件");
        }else{
            List<Good>list = ExcelUtils.getGoods(file.getInputStream());
            for(Good good : list){
                good.setNumber(id);
                System.out.println("zouzhihao good 打印: " + good);
                goodMapper.save(good);
            }
            model.addAttribute("content" , "上传成功");
            model.addAttribute("last" , "/listContract");
            model.addAttribute("last_value" , "返回首页");
        }
        return "msg";
    }

    /**提供给app的接口*/
    @RequestMapping("/getContractList")
    @ResponseBody
    public String getContractList() throws Exception {
        List<Contract> list = contractMapper.findAll();
        RequestBean<List<Contract>> bean = new RequestBean<List<Contract>>();
        bean.setStatus(RequestBean.STATUS_SUCCESS);
        bean.setData(list);
        return new Gson().toJson(bean);
    }

    @RequestMapping("/getContractDetail")
    @ResponseBody
    public String getContractDetail(@RequestBody Contract reqContract) throws Exception {
        Contract contract = contractMapper.getById(reqContract.getId());
        List<Good> goods = goodMapper.getByNumber(contract.getNumber());
        contract.setGoodList(goods);
        RequestBean<Contract> bean = new RequestBean<Contract>();
        bean.setStatus(RequestBean.STATUS_SUCCESS);
        bean.setData(contract);
        return new Gson().toJson(bean);
    }

    //更新货物的装包状态
    @RequestMapping("/updatePackageGood")
    @ResponseBody
    public String updatePackageGood(@RequestBody List<Good> reqGoods) throws Exception{
        for(Good good:reqGoods){
            goodMapper.updatePackage(good);
        }
        RequestBean<Contract> bean = new RequestBean<Contract>();
        bean.setStatus(RequestBean.STATUS_SUCCESS);
        bean.setMsg("更新成功");
        return new Gson().toJson(bean);
    }






}
