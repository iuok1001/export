package com.pers.lzl.export;

import com.pers.lzl.common.utils.excel.Encodes;
import com.pers.lzl.modules.dpt.entity.ShoeTreeData;
import com.pers.lzl.modules.dpt.entity.ShoeTreeDataVo;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ShoeTreeDataExportTest {

    public static void main(String[] args) {

        List<ShoeTreeDataVo> list = new ArrayList();

        ShoeTreeDataVo shoeTreeDataVo = new ShoeTreeDataVo();
        shoeTreeDataVo.setId("S1001");
        shoeTreeDataVo.setName("张三001");
        shoeTreeDataVo.setType("类型1");
        //<editor-fold desc="设置内部类">
        ShoeTreeData shoeTreeData = new ShoeTreeData();
        shoeTreeData.setTypeName("35");
        shoeTreeData.setLenXdyc(1.01);
        shoeTreeData.setLenFyl(2.00);
        shoeTreeData.setLenJz(3.02);
        shoeTreeData.setLenMz(4.30);
        shoeTreeData.setLenXz(5.43);
        shoeTreeData.setLenFirst(6.00);
        shoeTreeData.setLenFifth(7.00);
        shoeTreeData.setLenYw(8.03);
        shoeTreeData.setLenZx(9.50);
        shoeTreeData.setLenHrc(10.00);
        shoeTreeData.setRoundTw(11.0660);
        shoeTreeData.setRoundFw(12.00);
        shoeTreeData.setWidBase(13.00);
        shoeTreeData.setWidMz(14.040);
        shoeTreeData.setWidXz(15.00);
        shoeTreeData.setWidFirst(16.005);
        shoeTreeData.setWidFifth(17.00);
        shoeTreeData.setWidYw(18.00);
        shoeTreeData.setWidZx(19.030);
        shoeTreeData.setSizeZqr(20.00);
        shoeTreeData.setSizeQr(21.00);
        shoeTreeData.setSizeHrg(22.00);
        shoeTreeData.setSizeTh(23.200);
        shoeTreeData.setSizeHgtd(24.00);
        shoeTreeData.setSizeHsg(25.00);
        shoeTreeData.setSizeQztd(26.00);
        shoeTreeData.setSizeDxod(27.040);
        shoeTreeData.setSizeZxtd(28.00);
        shoeTreeData.setSizeTkk(29.030);
        shoeTreeData.setSizeTkc(30.050);
        shoeTreeData.setSizeXxc(31.10);
        //</editor-fold>
        List<ShoeTreeData> shoeTreeDataList = new ArrayList<>();
        shoeTreeDataList.add(shoeTreeData);
        shoeTreeDataVo.setShoeTreeDataList(shoeTreeDataList);
        //endregion

        list.add(shoeTreeDataVo);
        list.add(shoeTreeDataVo);
        list.add(shoeTreeDataVo);

        /*JSONObject jsonObject = JSONObject.fromObject(shoeTreeDataVo);
        System.out.println(jsonObject.toString());*/

        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(500);
        for (int k = 0; k < list.size(); k++) {
            ShoeTreeDataVo shoeTreeDataVoItem = list.get(k);
            Sheet sheet1 = sxssfWorkbook.createSheet(shoeTreeDataVoItem.getId()+new Random().nextInt(100));
            Map<String, CellStyle> styles = createStyles(sxssfWorkbook);
            int rowNum = 0;
            //<editor-fold desc="创建鞋楦编号">
            Row headerRow_0 = sheet1.createRow(rowNum++);
            Cell cell_0_0 = headerRow_0.createCell(0);
            cell_0_0.setCellValue("鞋楦编号");
            cell_0_0.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="创建鞋楦名称">
            Row headerRow_1 = sheet1.createRow(rowNum++);
            Cell cell_1_0 = headerRow_1.createCell(0);
            cell_1_0.setCellValue("鞋楦名称");
            cell_1_0.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="创建鞋楦名称">
            Row headerRow_2 = sheet1.createRow(rowNum++);
            Cell cell_2_0 = headerRow_2.createCell(0);
            cell_2_0.setCellValue("鞋楦类型");
            cell_2_0.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="创建维度">
            Row headerRow_3 = sheet1.createRow(rowNum++);
            Cell cell_3_0 = headerRow_3.createCell(0);
            cell_3_0.setCellStyle(styles.get("data"));
            cell_3_0.setCellValue("维度");
            Cell cell_3_1 = headerRow_3.createCell(1);
            cell_3_1.setCellValue("名称");
            cell_3_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="创建长度_1">
            Row headerRow_4 = sheet1.createRow(rowNum++);
            Cell cell_4_0 = headerRow_4.createCell(0);
            cell_4_0.setCellValue("长度");
            cell_4_0.setCellStyle(styles.get("data"));
            Cell cell_4_1 = headerRow_4.createCell(1);
            cell_4_1.setCellValue("*楦底样长");
            Comment comment_4_1 = sheet1.createDrawingPatriarch().createCellComment(
                    new XSSFClientAnchor(0, 0, 0, 0, (short) 1, 4, (short) 0, 0));
            comment_4_1.setString(new XSSFRichTextString("必填字段"));
            cell_4_1.setCellComment(comment_4_1);
            cell_4_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="创建长度_2">
            Row headerRow_5 = sheet1.createRow(rowNum++);
            Cell cell_5_1 = headerRow_5.createCell(1);
            cell_5_1.setCellValue("*放余量");
            Comment comment_5_1 = sheet1.createDrawingPatriarch().createCellComment(
                    new XSSFClientAnchor(0, 0, 0, 0, (short) 1, 5, (short) 0, 0));
            comment_5_1.setString(new XSSFRichTextString("必填字段"));
            cell_5_1.setCellComment(comment_5_1);
            cell_5_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="创建长度_3">
            Row headerRow_6 = sheet1.createRow(rowNum++);
            Cell cell_6_1 = headerRow_6.createCell(1);
            cell_6_1.setCellValue("脚趾端点部位");
            cell_6_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="创建长度_4">
            Row headerRow_7 = sheet1.createRow(rowNum++);
            Cell cell_7_1 = headerRow_7.createCell(1);
            cell_7_1.setCellStyle(styles.get("data"));
            cell_7_1.setCellValue("拇指外突点部位");
            //</editor-fold>

            //<editor-fold desc="创建长度_5">
            Row headerRow_8 = sheet1.createRow(rowNum++);
            Cell cell_8_1 = headerRow_8.createCell(1);
            cell_8_1.setCellStyle(styles.get("data"));
            cell_8_1.setCellValue("小趾外突点部位");
            //</editor-fold>

            //<editor-fold desc="创建长度_6">
            Row headerRow_9 = sheet1.createRow(rowNum++);
            Cell cell_9_1 = headerRow_9.createCell(1);
            cell_9_1.setCellValue("第一庶趾部位");
            cell_9_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="创建长度_7">
            Row headerRow_10 = sheet1.createRow(rowNum++);
            Cell cell_10_1 = headerRow_10.createCell(1);
            cell_10_1.setCellStyle(styles.get("data"));
            cell_10_1.setCellValue("第五庶趾部位");
            //</editor-fold>

            //<editor-fold desc="创建长度_8">
            Row headerRow_11 = sheet1.createRow(rowNum++);
            Cell cell_11_1 = headerRow_11.createCell(1);
            cell_11_1.setCellStyle(styles.get("data"));
            cell_11_1.setCellValue("腰窝部位");
            //</editor-fold>

            // <editor-fold desc="创建长度_9">
            Row headerRow_12 = sheet1.createRow(rowNum++);
            Cell cell_12_1 = headerRow_12.createCell(1);
            cell_12_1.setCellStyle(styles.get("data"));
            cell_12_1.setCellValue("踵心部位");
            //</editor-fold>

            // <editor-fold desc="创建长度_9">
            Row headerRow_13 = sheet1.createRow(rowNum++);
            Cell cell_13_1 = headerRow_13.createCell(1);
            cell_13_1.setCellValue("*后容差");
            cell_13_1.setCellStyle(styles.get("data"));
            Comment comment_13_1 = sheet1.createDrawingPatriarch().createCellComment(
                    new XSSFClientAnchor(0, 0, 0, 0, (short) 1, 13, (short) 0, 0));
            comment_13_1.setString(new XSSFRichTextString("必填字段"));
            cell_13_1.setCellComment(comment_13_1);
            //</editor-fold>

            //<editor-fold desc="围度">
            //<editor-fold desc="创建围度">
            Row headerRow_14 = sheet1.createRow(rowNum++);
            Cell cell_14_0 = headerRow_14.createCell(0);
            cell_14_0.setCellStyle(styles.get("data"));
            cell_14_0.setCellValue("围度");
            //</editor-fold>

            // <editor-fold desc="创建围度_1">
            Cell cell_14_1 = headerRow_14.createCell(1);
            cell_14_1.setCellValue("*跖围");
            cell_14_1.setCellStyle(styles.get("data"));
            Comment comment_14_1 = sheet1.createDrawingPatriarch().createCellComment(
                    new XSSFClientAnchor(0, 0, 0, 0, (short) 1, 14, (short) 0, 0));
            comment_14_1.setString(new XSSFRichTextString("必填字段"));
            cell_14_1.setCellComment(comment_14_1);
            //</editor-fold>

            // <editor-fold desc="创建围度_2">
            Row headerRow_15 = sheet1.createRow(rowNum++);
            Cell cell_15_1 = headerRow_15.createCell(1);
            cell_15_1.setCellValue("*跗围");
            cell_15_1.setCellStyle(styles.get("data"));
            Comment comment_15_1 = sheet1.createDrawingPatriarch().createCellComment(
                    new XSSFClientAnchor(0, 0, 0, 0, (short) 1, 15, (short) 0, 0));
            comment_15_1.setString(new XSSFRichTextString("必填字段"));
            cell_15_1.setCellComment(comment_15_1);
            //</editor-fold>
            //</editor-fold>

            //<editor-fold desc="宽度">
            //<editor-fold desc="创建宽度">
            Row headerRow_16 = sheet1.createRow(rowNum++);
            Cell cell_16_0 = headerRow_16.createCell(0);
            cell_16_0.setCellStyle(styles.get("data"));
            cell_16_0.setCellValue("宽度");
            //</editor-fold>

            // <editor-fold desc="创建宽度_1">
            Cell cell_16_1 = headerRow_16.createCell(1);
            cell_16_1.setCellValue("*基本宽度");
            cell_16_1.setCellStyle(styles.get("data"));
            Comment comment_16_1 = sheet1.createDrawingPatriarch().createCellComment(
                    new XSSFClientAnchor(0, 0, 0, 0, (short) 1, 16, (short) 0, 0));
            comment_16_1.setString(new XSSFRichTextString("必填字段"));
            cell_16_1.setCellComment(comment_16_1);
            //</editor-fold>

            // <editor-fold desc="创建宽度_2">
            Row headerRow_17 = sheet1.createRow(rowNum++);
            Cell cell_17_1 = headerRow_17.createCell(1);
            cell_17_1.setCellValue("拇指里宽");
            cell_17_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建宽度_3">
            Row headerRow_18 = sheet1.createRow(rowNum++);
            Cell cell_18_1 = headerRow_18.createCell(1);
            cell_18_1.setCellValue("小趾外宽");
            cell_18_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建宽度_4">
            Row headerRow_19 = sheet1.createRow(rowNum++);
            Cell cell_19_1 = headerRow_19.createCell(1);
            cell_19_1.setCellValue("第一嗻趾里宽");
            cell_19_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建宽度_5">
            Row headerRow_20 = sheet1.createRow(rowNum++);
            Cell cell_20_1 = headerRow_20.createCell(1);
            cell_20_1.setCellValue("第五嗻趾外宽");
            cell_20_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建宽度_6">
            Row headerRow_21 = sheet1.createRow(rowNum++);
            Cell cell_21_1 = headerRow_21.createCell(1);
            cell_21_1.setCellValue("腰窝外宽");
            cell_21_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建宽度_7">
            Row headerRow_22 = sheet1.createRow(rowNum++);
            Cell cell_22_1 = headerRow_22.createCell(1);
            cell_22_1.setCellValue("*踵心全宽");
            cell_22_1.setCellStyle(styles.get("data"));
            Comment comment_22_1 = sheet1.createDrawingPatriarch().createCellComment(
                    new XSSFClientAnchor(0, 0, 0, 0, (short) 1, 22, (short) 0, 0));
            comment_22_1.setString(new XSSFRichTextString("必填字段"));
            cell_22_1.setCellComment(comment_22_1);
            //</editor-fold>
            //</editor-fold>

            //<editor-fold desc="楦体尺寸">
            //<editor-fold desc="创建楦体尺寸">
            Row headerRow_23 = sheet1.createRow(rowNum++);
            Cell cell_23_0 = headerRow_23.createCell(0);
            cell_23_0.setCellStyle(styles.get("data"));
            cell_23_0.setCellValue("楦体尺寸");
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_1">
            Cell cell_23_1 = headerRow_23.createCell(1);
            cell_23_1.setCellValue("总前跷");
            cell_23_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_2">
            Row headerRow_24 = sheet1.createRow(rowNum++);
            Cell cell_24_1 = headerRow_24.createCell(1);
            cell_24_1.setCellValue("前跷");
            cell_24_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_3">
            Row headerRow_25 = sheet1.createRow(rowNum++);
            Cell cell_25_1 = headerRow_25.createCell(1);
            cell_25_1.setCellValue("后跷高");
            cell_25_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_4">
            Row headerRow_26 = sheet1.createRow(rowNum++);
            Cell cell_26_1 = headerRow_26.createCell(1);
            cell_26_1.setCellValue("头厚");
            cell_26_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_5">
            Row headerRow_27 = sheet1.createRow(rowNum++);
            Cell cell_27_1 = headerRow_27.createCell(1);
            cell_27_1.setCellValue("*后跟突点高");
            cell_27_1.setCellStyle(styles.get("data"));
            Comment comment_27_1 = sheet1.createDrawingPatriarch().createCellComment(
                    new XSSFClientAnchor(0, 0, 0, 0, (short) 1, 27, (short) 0, 0));
            comment_27_1.setString(new XSSFRichTextString("必填字段"));
            cell_27_1.setCellComment(comment_27_1);
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_6">
            Row headerRow_28 = sheet1.createRow(rowNum++);
            Cell cell_28_1 = headerRow_28.createCell(1);
            cell_28_1.setCellValue("后身高");
            cell_28_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_7">
            Row headerRow_29 = sheet1.createRow(rowNum++);
            Cell cell_29_1 = headerRow_29.createCell(1);
            cell_29_1.setCellValue("前掌凸度");
            cell_29_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_8">
            Row headerRow_30 = sheet1.createRow(rowNum++);
            Cell cell_30_1 = headerRow_30.createCell(1);
            cell_30_1.setCellValue("低心凹度");
            cell_30_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_9">
            Row headerRow_31 = sheet1.createRow(rowNum++);
            Cell cell_31_1 = headerRow_31.createCell(1);
            cell_31_1.setCellValue("踵心凸度");
            cell_31_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_10">
            Row headerRow_32 = sheet1.createRow(rowNum++);
            Cell cell_32_1 = headerRow_32.createCell(1);
            cell_32_1.setCellValue("统口宽");
            cell_32_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_11">
            Row headerRow_33 = sheet1.createRow(rowNum++);
            Cell cell_33_1 = headerRow_33.createCell(1);
            cell_33_1.setCellValue("统口长");
            cell_33_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            // <editor-fold desc="创建楦体尺寸_12">
            Row headerRow_34 = sheet1.createRow(rowNum++);
            Cell cell_34_1 = headerRow_34.createCell(1);
            cell_34_1.setCellValue("楦斜长");
            cell_34_1.setCellStyle(styles.get("data"));
            //</editor-fold>
            //</editor-fold>

            //<editor-fold desc="合并单元格">
            CellRangeAddress region_4_0 = new CellRangeAddress(4, 13, (short) 0, (short) 0);
            sheet1.addMergedRegion(region_4_0);
            CellRangeAddress region_14_0 = new CellRangeAddress(14, 15, (short) 0, (short) 0);
            sheet1.addMergedRegion(region_14_0);
            CellRangeAddress region_16_0 = new CellRangeAddress(16, 22, (short) 0, (short) 0);
            sheet1.addMergedRegion(region_16_0);
            CellRangeAddress region_23_0 = new CellRangeAddress(23, 34, (short) 0, (short) 0);
            sheet1.addMergedRegion(region_23_0);
            //</editor-fold>

            //<editor-fold desc="填充数据区">

            //<editor-fold desc="鞋楦编号">
            Row row_0 = sheet1.getRow(0);
            Cell cell_0_1 = row_0.createCell(1);
            cell_0_1.setCellValue(shoeTreeDataVoItem.getId());
            cell_0_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="鞋楦名称">
            Row row_1 = sheet1.getRow(1);
            Cell cell_1_1 = row_1.createCell(1);
            cell_1_1.setCellValue(shoeTreeDataVoItem.getName());
            cell_1_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="鞋楦类型">
            Row row_2 = sheet1.getRow(2);
            Cell cell_2_1 = row_2.createCell(1);
            cell_2_1.setCellValue(shoeTreeDataVoItem.getType());
            cell_2_1.setCellStyle(styles.get("data"));
            //</editor-fold>

            //<editor-fold desc="鞋楦类型">
            for (int i = 0; i < 32; i++) {
                Row row = sheet1.getRow(3 + i);
                for (int j = 0; j < shoeTreeDataVoItem.getShoeTreeDataList().size(); j++) {
                    Cell cell = row.createCell(j + 2);
                    switch (i) {
                        case 0: cell.setCellValue("尺码-" + shoeTreeDataVoItem.getShoeTreeDataList().get(j).getTypeName() + "(mm)");break;//尺码号
                        case 1: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenXdyc());break;//*楦底样长
                        case 2: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenFyl());break;//*放余量
                        case 3: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenJz());break;//脚趾端点部位
                        case 4: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenMz());break;//拇指外突点部位
                        case 5: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenXz());break;//小趾外突点部位
                        case 6: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenFirst());break;//第一庶趾部位
                        case 7: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenFifth());break;//第五庶趾部位
                        case 8: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenYw());break;//腰窝部位
                        case 9: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenZx());break;//踵心部位
                        case 10: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getLenHrc());break;//*后容差
                        case 11: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getRoundTw());break;//*跖围
                        case 12: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getRoundFw());break;//*跗围
                        case 13: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getWidBase());break;//*基本宽度
                        case 14: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getWidMz());break;//拇指里宽
                        case 15: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getWidXz());break;//小趾外宽
                        case 16: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getWidFirst());break;//第一嗻趾里宽
                        case 17: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getWidFifth());break;//第五嗻趾外宽
                        case 18: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getWidYw());break;//腰窝外宽
                        case 19: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getWidZx());break;//*踵心全宽
                        case 20: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeZqr());break;//总前跷
                        case 21: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeQr());break;//前跷
                        case 22: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeHrg());break;//后跷高
                        case 23: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeTh());break;//头厚
                        case 24: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeHgtd());break;//*后跟突点高
                        case 25: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeHsg());break;//后身高
                        case 26: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeQztd());break;//前掌凸度
                        case 27: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeDxod());break;//低心凹度
                        case 28: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeZxtd());break;//踵心凸度
                        case 29: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeTkk());break;//统口宽
                        case 30: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeTkc());break;//统口长
                        case 31: cell.setCellValue(shoeTreeDataVoItem.getShoeTreeDataList().get(j).getSizeXxc());break;//楦斜长
                    }
                    if (i != 0) {
                        cell.setCellStyle(styles.get("data_float"));
                    } else {
                        cell.setCellStyle(styles.get("data"));
                    }
                }
            }
            //</editor-fold>

            //</editor-fold>

            for (int m = 0; m < 50; m++) {
                sheet1.autoSizeColumn(m);
                sheet1.setDefaultRowHeightInPoints(16);
                int colWidth = sheet1.getColumnWidth(m) * 2;
                sheet1.setColumnWidth(m, colWidth < 3000 ? 3000 : colWidth);
            }

        }


        FileOutputStream os = null;
        try {
            os = new FileOutputStream("target/export" + new Random().nextInt(100) + ".xlsx");
            sxssfWorkbook.write(os);
            sxssfWorkbook.dispose();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*response.reset();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+ Encodes.urlEncode(fileName));
        write(response.getOutputStream());*/

    }

    /**
     * 设置单元格格式
     * @param wb
     * @return
     */
    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style = wb.createCellStyle();
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short) 10);
        style.setFont(dataFont);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        styles.put("data", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("data_float",style);
        return styles;
    }


}
