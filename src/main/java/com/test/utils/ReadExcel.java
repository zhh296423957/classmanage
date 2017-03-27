package com.test.utils;

import com.test.model.Academy;
import com.test.model.Student;
import com.test.service.AcademyService;
import com.test.service.GradeService;
import com.test.service.SchoolService;
import com.test.service.TbClassService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 张宏浩 on 2017/2/22.
 */
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ReadExcel {
    private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;
    private XSSFWorkbook xssfWorkbook;

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private AcademyService academyService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private TbClassService tbClassService;

    /**
     * 读取表格的所有数据
     * @Param InputStream 文件路径  number 传入对应的表格sheet码(页码从0开始)
     * @return List<Student> 每一行按照属性对应存储
     */

    public List<Student> lists(InputStream is, int number){
        List<Student> list = new ArrayList<Student>();
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        sheet = wb.getSheetAt(number);
        row = sheet.getRow(0);       	 	//标题栏
        int colNum  = row.getPhysicalNumberOfCells();   // 确认列数
        int rowNum = sheet.getLastRowNum();
        for(int i = 1 ; i<=rowNum;i++){
            Student student = new Student();
            row = sheet.getRow(i);
            student.setNumber(getCellFormatValue(row.getCell(0)).trim());
            student.setStudentName(getCellFormatValue(row.getCell(1)).trim());
            if("男".equals(getCellFormatValue(row.getCell(2)).trim())) {
                student.setSex((short) 0);
            }else if("女".equals(getCellFormatValue(row.getCell(2)).trim())){
                student.setSex((short) 1);
            }else {
                student.setSex((short)2);
            }
            student.setPhone(getCellFormatValue(row.getCell(3)).trim());
            student.setDepartment(getCellFormatValue(row.getCell(4)).trim());
            if("否".equals(getCellFormatValue(row.getCell(5)).trim())) {
                student.setIsCommitee((short)0);
            }else if("是".equals(getCellFormatValue(row.getCell(5)).trim())){
                student.setIsCommitee((short)1);
            }else{
                student.setSex((short)2);
            }
            student.setSchoolId(1);
            student.setGradeId(1);
            student.setAcademyId(1);
            student.setClassId(1);
            list.add(student);
        }
        return list;
    }

    /**
     * 存储所有的sheet表
     * @param is 文件路径
     * @return map sheet名称和表格内容
     *
     */
    public Map<String, List<Student>> mapOfxls(InputStream is){
        Map<String, List<Student>> mapentry = new HashMap<String, List<Student>>();
        List<Student> list = new ArrayList<Student>();
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        int sheetNum = wb.getNumberOfSheets();
        for(int i = 0;i<sheetNum;i++){
            String name = null;
            list = lists(is, i);
            sheet = wb.getSheetAt(i);
            name = sheet.getSheetName();
            mapentry.put(name, list);
        }
        for(Map.Entry<String, List<Student>> map:mapentry.entrySet())
        {
            System.out.println("K="+map.getKey()+".....value"+map.getValue());
        }
        return mapentry;
    }

    /**
     * 存储所有的sheet表
     * @param is 文件路径
     * @return map sheet名称和表格内容
     *
     */
    public Map<String, List<Student>> mapOfxlsx(InputStream is){
        Map<String, List<Student>> mapentry = new HashMap<String, List<Student>>();
        List<Student> list = new ArrayList<Student>();
        try {
            xssfWorkbook= new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        int sheetNum = xssfWorkbook.getNumberOfSheets();
        for(int i = 0;i<sheetNum;i++){
            XSSFSheet sheetOfXlsx = xssfWorkbook.getSheetAt(i);
            int rowNum = sheetOfXlsx.getLastRowNum();
                for(int j=1;j<=rowNum;j++) {
                    Student student = new Student();
                    XSSFRow row = sheetOfXlsx.getRow(j);

                    student.setNumber(row.getCell(0).toString());
                    student.setStudentName(row.getCell(1).toString());
                    if ("男".equals(row.getCell(2).toString())) {
                        student.setSex((short) 0);
                    } else if ("女".equals(row.getCell(2).toString())) {
                        student.setSex((short) 1);
                    } else {
                        student.setSex((short) 2);
                    }
                    student.setPhone(row.getCell(3).toString());
                    student.setDepartment(row.getCell(4).toString());
                    if ("否".equals(row.getCell(5).toString())) {
                        student.setIsCommitee((short) 0);
                    } else if ("是".equals(row.getCell(5).toString())) {
                        student.setIsCommitee((short) 1);
                    } else {
                        student.setIsCommitee((short) 2);
                    }
                    int schoolId = schoolService.judgeSchool(row.getCell(6).toString());
                    student.setSchoolId(schoolId);
                    int academyId = academyService.judgeAcademy(schoolId,row.getCell(7).toString());
                    student.setAcademyId(academyId);
                    int gradeId = gradeService.judgeGrade(academyId,row.getCell(8).toString());
                    student.setGradeId(gradeId);
                    int tbClass = tbClassService.judgeClass(gradeId,row.getCell(9).toString());
                    student.setClassId(tbClass);
                    list.add(student);
                }
            String name = null;
            name = sheetOfXlsx.getSheetName();
            mapentry.put(name, list);
        }
        for(Map.Entry<String, List<Student>> map:mapentry.entrySet())
        {
            System.out.println("K="+map.getKey()+".....value"+map.getValue());
        }
        return mapentry;
    }
    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    @SuppressWarnings("deprecation")
    private String getStringCellValue(HSSFCell cell){
        String strCell = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if(strCell.equals("") || strCell == null){
            return "";
        }
        if(cell == null){
            return "";
        }

        return strCell;
    }

    /**
     * 获取单元格数据内容为日期类型数据
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getDateCellValue(HSSFCell cell){
        String result = "";
        try{
            int cellType = cell.getCellType();
            if(cellType == HSSFCell.CELL_TYPE_NUMERIC){
                Date date = (Date) cell.getDateCellValue();
                result = (date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate();
            }else if (cellType == HSSFCell.CELL_TYPE_STRING) {
                String date = getStringCellValue(cell);
                result = date.replaceAll("[年月]", "-").replace("日", "-").trim();
            }else if (cellType == HSSFCell.CELL_TYPE_BLANK){
                result = "";
            }
        }catch (Exception e) {
            System.out.println("日期格式不正确！");
            e.printStackTrace();
            // TODO: handle exception
        }

        return result;
    }

    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell){
        String cellValue = "";
        if(cell != null){
            //判断当前Cell的Type
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA:{
                    //判断当前cell是否为Date
                    if(HSSFDateUtil.isCellDateFormatted(cell)){
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = (Date)cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                        cellValue = sdf.format(date);
                    }
                    //如果是纯数字
                    else {
                        //取得当前cell的数值
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case HSSFCell.CELL_TYPE_STRING:
                    //取得当前的cell字符串
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                //默认的cell值
                default:
                    cellValue = " ";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }


    public static void main(String[] args) throws IOException {
        ReadExcel readExcel = new ReadExcel();
        String path = "C:\\Users\\张宏浩\\Desktop\\student.xlsx";
        if(path.endsWith("xls")){
            try {
                InputStream inputStream = new FileInputStream(path);
                readExcel.mapOfxls(inputStream);
            } catch (FileNotFoundException e) {
                System.out.println("未找到文件路径");
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(path.endsWith("xlsx")){
                InputStream inputStream = new FileInputStream(path);
                readExcel.mapOfxlsx(inputStream);
        }

    }

}
