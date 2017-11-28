package com.pers.lzl.export;

import com.pers.lzl.modules.dpt.entity.ShoeTreeData;
import com.pers.lzl.modules.dpt.entity.ShoeTreeDataVo;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultDefaultValueProcessor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoeTreeDataImportTest {

    public static void main(String[] args) {
        try {
            Workbook wb = new XSSFWorkbook(new FileInputStream(new File("target/测试导入.xlsx")));
            List<ShoeTreeDataVo> list = new ArrayList();
            //<editor-fold desc="每个页签塞数据">
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                Sheet sheet = wb.getSheetAt(i);
                ShoeTreeDataVo shoeTreeDataVo = new ShoeTreeDataVo();
                List<ShoeTreeData> shoeTreeDataList = new ArrayList<>();

                shoeTreeDataVo.setId(sheet.getRow(0).getCell(1).getStringCellValue());
                shoeTreeDataVo.setName(sheet.getRow(1).getCell(1).getStringCellValue());
                shoeTreeDataVo.setType(sheet.getRow(2).getCell(1).getStringCellValue());
                int colunmNum = 2;//获取标题长度
                while (true) {
                    if (sheet.getRow(3).getCell(colunmNum) != null) {
                        colunmNum++;
                    } else {
                        break;
                    }
                }
                for (int j = 2; j < colunmNum; j++) {
                    ShoeTreeData shoeTreeData = new ShoeTreeData();
                    shoeTreeData.setTypeName(sheet.getRow(3).getCell(j).getStringCellValue());//尺码-35（mm)
                    shoeTreeData.setLenXdyc(checkData(sheet, 4, j, true));
                    shoeTreeData.setLenFyl(checkData(sheet, 5, j, true));
                    shoeTreeData.setLenJz(checkData(sheet, 6, j));
                    shoeTreeData.setLenMz(checkData(sheet, 7, j));
                    shoeTreeData.setLenXz(checkData(sheet, 8, j));
                    shoeTreeData.setLenFirst(checkData(sheet, 9, j));
                    shoeTreeData.setLenFifth(checkData(sheet, 10, j));
                    shoeTreeData.setLenYw(checkData(sheet, 11, j));
                    shoeTreeData.setLenZx(checkData(sheet, 12, j));
                    shoeTreeData.setLenHrc(checkData(sheet, 13, j, true));
                    shoeTreeData.setRoundTw(checkData(sheet, 14, j, true));
                    shoeTreeData.setRoundFw(checkData(sheet, 15, j, true));
                    shoeTreeData.setWidBase(checkData(sheet, 16, j, true));
                    shoeTreeData.setWidMz(checkData(sheet, 17, j));
                    shoeTreeData.setWidXz(checkData(sheet, 18, j));
                    shoeTreeData.setWidFirst(checkData(sheet, 19, j));
                    shoeTreeData.setWidFifth(checkData(sheet, 20, j));
                    shoeTreeData.setWidYw(checkData(sheet, 21, j));
                    shoeTreeData.setWidZx(checkData(sheet, 22, j, true));
                    shoeTreeData.setSizeZqr(checkData(sheet, 23, j));
                    shoeTreeData.setSizeQr(checkData(sheet, 24, j));
                    shoeTreeData.setSizeHrg(checkData(sheet, 25, j));
                    shoeTreeData.setSizeTh(checkData(sheet, 26, j));
                    shoeTreeData.setSizeHgtd(checkData(sheet, 27, j, true));
                    shoeTreeData.setSizeHsg(checkData(sheet, 28, j));
                    shoeTreeData.setSizeQztd(checkData(sheet, 29, j));
                    shoeTreeData.setSizeDxod(checkData(sheet, 30, j));
                    shoeTreeData.setSizeZxtd(checkData(sheet, 31, j));
                    shoeTreeData.setSizeTkk(checkData(sheet, 32, j));
                    shoeTreeData.setSizeTkc(checkData(sheet, 33, j));
                    shoeTreeData.setSizeXxc(checkData(sheet, 34, j));
                    shoeTreeDataList.add(shoeTreeData);
                }
                shoeTreeDataVo.setShoeTreeDataList(shoeTreeDataList);
                list.add(shoeTreeDataVo);
            }
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerDefaultValueProcessor(Double.class, new DefaultDefaultValueProcessor() {
                public Object getDefaultValue(Class type) {
                    return null;
                }
            });
            JSONArray array = JSONArray.fromObject(list,jsonConfig);
            System.out.println(array.toString());
            //</editor-fold>
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    /**
     * 检查数据数字的类型
     * @param sheet    每个工作表
     * @param row      行
     * @param column   列
     * @param required 必填项
     * @return Double 值
     * @throws Exception 抛出的转换异常
     */
    public static Double checkData(Sheet sheet, Integer row, Integer column, Boolean required) throws Exception {
        if (sheet.getRow(row).getCell(column).getCellType() == Cell.CELL_TYPE_BLANK) {
            throw new Exception("导入错误,错误点：工作表[" + sheet.getSheetName() + "]，单元格[" + (char) (65 + column) + String.valueOf(row + 1) + "] 此项为必填项");
        }
        return checkData(sheet, row, column);
    }

    /**
     * 检查数据数字的类型
     * @param sheet    每个工作表
     * @param row      行
     * @param column   列
     * @return Double 值
     * @throws Exception 抛出的转换异常
     */
    public static Double checkData(Sheet sheet, Integer row, Integer column) throws Exception {
        if (sheet.getRow(row).getCell(column).getCellType() == Cell.CELL_TYPE_BLANK) {
            return null;
        } else if (sheet.getRow(row).getCell(column).getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return sheet.getRow(row).getCell(column).getNumericCellValue();
        } else if (sheet.getRow(row).getCell(column).getCellType() == Cell.CELL_TYPE_STRING) {
            throw new Exception("导入错误,错误点：工作表[" + sheet.getSheetName() + "]，单元格[" + (char) (65 + column) + String.valueOf(row + 1) + "] 正确格式为：0.00");
        } else {
            throw new Exception("导入错误,错误点：工作表[" + sheet.getSheetName() + "]，单元格[" + (char) (65 + column) + String.valueOf(row + 1) + "] 正确格式为：0.00");
        }
    }
}
