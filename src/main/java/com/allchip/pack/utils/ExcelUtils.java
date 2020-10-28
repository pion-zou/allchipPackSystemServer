package com.allchip.pack.utils;

import com.allchip.pack.pojo.Good;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    public static List<Object> excelToShopIdList(InputStream inputStream) {
        List<Object> list = new ArrayList<>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
//工作表对象
            Sheet sheet = workbook.getSheetAt(0);
//总行数
            int rowLength = sheet.getLastRowNum() - 1;
            System.out.println("总行数有多少行" + rowLength);
//工作表的列
            Row row = sheet.getRow(0);

//总列数
            int colLength = row.getLastCellNum();
            System.out.println("总列数有多少列" + colLength);
//得到指定的单元格
            Cell cell = row.getCell(0);
            for (int i = 4; i < rowLength - 7; i++) {
                row = sheet.getRow(i);
                for (int j = 1; j < colLength + 1; j++) {
                    cell = row.getCell(j);
// System.out.println(cell);
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String data = cell.getStringCellValue();
                        data = data.trim();
                        System.out.print(data);
//判断data是否是数字
                    }
                }
                System.out.println("+");
            }
        } catch (Exception e) {
            LOGGER.error("parse excel file error :", e);
        }
        return list;
    }

    public static List<Good> getGoods(InputStream inputStream){
        List<Good> goods = new ArrayList<>();
        Workbook workbook = null;
        try{
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            Sheet sheet = workbook.getSheetAt(0);
            int rowLength = sheet.getLastRowNum() - 1;
            for(int rowNum = 0 ; rowNum < rowLength ; rowNum ++){
                Row row = sheet.getRow(rowNum);
                Cell firstCell = row.getCell(0);
                if(firstCell != null){
                    firstCell.setCellType(CellType.STRING);
                    String content = firstCell.getStringCellValue();
                    //找到了商品表的开始
                    if(" Item NO.".equals(content)){
                        //下一行开始解析数据
                        rowNum++;
                        String firstContent = "";
                        while ((firstContent =  sheet.getRow(rowNum).getCell(0).getStringCellValue()) != null && !firstContent.isEmpty()){
                            Row thisRow = sheet.getRow(rowNum);
                            Good good = new Good();
                            good.setItem_index(thisRow.getCell(0).getStringCellValue());
                            //设置型号
                            good.setType(thisRow.getCell(1).getStringCellValue());
                            //设置dc
                            good.setYear(thisRow.getCell(2).getStringCellValue());
                            //设置制造商
                            good.setManufacturer(thisRow.getCell(3).getStringCellValue());
                            //设置数量
                            good.setCount((int)(thisRow.getCell(4).getNumericCellValue()));
                            //设置package
                            good.setPackage(thisRow.getCell(5).getStringCellValue());
                            //设置单价
                            good.setUnit_price((float)(thisRow.getCell(6).getNumericCellValue()));
                            //设置总价
                            good.setTotal_price((float)(thisRow.getCell(7).getNumericCellValue()));
                            goods.add(good);
                            rowNum++;
                        }
                        break;
                    }
                }
            }


        }catch (Exception e){
            LOGGER.error("parse excel file error :", e);
        }
        return goods;
    }


}