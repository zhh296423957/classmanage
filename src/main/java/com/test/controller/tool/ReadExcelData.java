package com.test.controller.tool;

import com.test.model.Academy;
import com.test.model.School;
import com.test.model.Student;
import com.test.service.*;
import com.test.utils.CreateMD5;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by 张宏浩 on 2017/3/27.
 */
@Service
public class ReadExcelData {

    private  XSSFWorkbook wb;
    private  XSSFSheet sheet;
    private  XSSFRow row;

    @Resource
    private StudentService studentService;
    @Resource
    private SchoolService schoolService;
    @Resource
    private AcademyService academyService;
    @Resource
    private GradeService gradeService;
    @Resource
    private TbClassService classService;




    public  String[] readExcelTitle(String file) throws Exception {

        try {
            wb = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        int rowNum=sheet.getLastRowNum();  //获取总行数
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();

        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = getCellFormatValue(row.getCell((short) i));
        }
        return title;
    }

    public  int   insertStudent(String file) throws IOException {
        Properties p = new Properties();
        InputStream in = ReadExcelData.class.getResourceAsStream("/password.properties");
        p.load(in);
        in.close();   //获取properties中的默认密码

        try {
            wb = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        int rowNum = sheet.getLastRowNum();  //获得总的行数，索引从0开始
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        for(int i=1;i<=rowNum;i++){
            row = sheet.getRow(i);
            //将每一行的数据存储到对应的学生属性中
            Student student = new Student();
            student.setNumber(getCellFormatValue(row.getCell(0)));
            student.setStudentName(getCellFormatValue(row.getCell(1)));
            if("男".equals(getCellFormatValue(row.getCell(2)))){
                student.setSex((short)0);
            }else {
                student.setSex((short)1);
            }
            student.setPwd(CreateMD5.getMd5(p.getProperty("password")));          //默认密码为123456
            student.setPhone(getCellFormatValue(row.getCell(3)));
            student.setDepartment(getCellFormatValue(row.getCell(4)));
            if("否".equals(getCellFormatValue(row.getCell(5)))){
                student.setIsCommitee((short)0);
            }else {
                student.setIsCommitee((short)1);
            }
            String schName = getCellFormatValue(row.getCell(6));  //获取学校名称
            int schId = schoolService.judgeSchool(schName);
            student.setSchoolId(schId);

            String acaName = getCellFormatValue(row.getCell(7)); //获得学院名称
            int acaId = academyService.judgeAcademy(schId,acaName);
            student.setAcademyId(acaId);

            String graName = getCellFormatValue(row.getCell(8)); //获得年级名称
            int graId = gradeService.judgeGrade(acaId,graName);
            student.setGradeId(graId);

            String claName = getCellFormatValue(row.getCell(9)); //获得班级名称
            int claId = classService.judgeClass(graId,claName);
            student.setClassId(claId);
            student.setGmtCreate(new Date());
            studentService.insert(student);
        }
        return rowNum; //返回总行数，也就是班级的总人数
    }

    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private  String getCellFormatValue(XSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case XSSFCell.CELL_TYPE_NUMERIC:
                case XSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);

                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case XSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }
}
