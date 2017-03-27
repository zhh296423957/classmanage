package com.test.controller.tool;

/**
 * Created by 张宏浩 on 2017/3/24.
 */

import com.test.model.*;
import com.test.service.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
@Service
public class ExportExcelDataTool {


    private final HSSFWorkbook  workbook;

    private final HSSFSheet     sheet;

    private final HSSFCellStyle cellStyle;

    @Autowired(required = false)
    private StudentService studentService;
    @Autowired(required = false)
    private SchoolService schoolService;
    @Autowired(required = false)
    private AcademyService academyService;
    @Autowired(required = false)
    private GradeService gradeService;
    @Autowired(required = false)
    private TbClassService classService;



    public ExportExcelDataTool() {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet();
        sheet.autoSizeColumn(1, true);
        /*workbook.setSheetName(0, "身份证明细模版");*/

        Font font = workbook.createFont();
        font.setColor(HSSFColor.RED.index);
        cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
    }

    /**
     *
     * @param response
     */
    public void exportExcel(HttpServletResponse response,int classId) {
        createSheet(sheet,classId);
        exportExcel2Brower(workbook, response,classId);
    }

    /**
     * @param sheet
     */
    private void createSheet(HSSFSheet sheet,int classId) {
        int i =1;
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell1 = row.createCell(0, 1);
        cell1.setCellValue("学号");
        HSSFCell cell2 = row.createCell(1, 1);
        cell2.setCellValue("姓名");
        HSSFCell cell3 = row.createCell(2, 1);
        cell3.setCellValue("性别");
        HSSFCell cell4 = row.createCell(3, 1);
        cell4.setCellValue("手机");
        HSSFCell cell5 = row.createCell(4, 1);
        cell5.setCellValue("宿舍号");
        HSSFCell cell6 = row.createCell(5, 1);
        cell6.setCellValue("学校");
        HSSFCell cell7 = row.createCell(6, 1);
        cell7.setCellValue("学院");
        HSSFCell cell8 = row.createCell(7, 1);
        cell8.setCellValue("年级");
        HSSFCell cell9 = row.createCell(8, 1);
        cell9.setCellValue("班级");


        List<Student> lists = studentService.listForClassId(classId);
        if(lists.size() ==0){
            return;
        }
        for(Student list:lists) {

                row = sheet.createRow(i);

                HSSFCell cell11 = row.createCell(0, 1);
                cell11.setCellValue(list.getNumber());
                HSSFCell cell22 = row.createCell(1, 1);
                cell22.setCellValue(list.getStudentName());
                if (list.getSex() == 0) {
                    HSSFCell cell33 = row.createCell(2, 1);
                    cell33.setCellValue("男");
                } else {
                    HSSFCell cell33 = row.createCell(2, 1);
                    cell33.setCellValue("女");
                }
                HSSFCell cell44 = row.createCell(3, 1);
                cell44.setCellValue(list.getPhone());
                HSSFCell cell55 = row.createCell(4, 1);
                cell55.setCellValue(list.getDepartment());

                School school = schoolService.getById(list.getSchoolId());
                HSSFCell cell66 = row.createCell(5, 1);
                cell66.setCellValue(school.getSchName());

                Academy academy = academyService.getById(list.getAcademyId());
                HSSFCell cell77 = row.createCell(6, 1);
                cell77.setCellValue(academy.getAcaName());

                Grade grade = gradeService.getById(list.getGradeId());
                HSSFCell cell88 = row.createCell(7, 1);
                cell88.setCellValue(grade.getGraName());

                TbClass tbClass = classService.getById(list.getClassId());
                HSSFCell cell99 = row.createCell(8, 1);
                cell99.setCellValue(tbClass.getClaName());
                i++;
        }

    }


    private void exportExcel2Brower(HSSFWorkbook workbook, HttpServletResponse response,int classId) {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowDate = sdf.format(new Date());*/
        TbClass tbClass =classService.getById(classId);
        Grade grade = gradeService.getById(tbClass.getGradeId());
        String fileName = "attachment; filename=" +grade.getGraName()+ tbClass.getClaName() + "学生信息.xls";
        OutputStream out = null;
        try {
            response.setHeader("Content-disposition", new String(fileName.getBytes("gbk"),
                    "ISO-8859-1"));
            response.setContentType("application/msexcel;charset=GBK");
            out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            //
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    //
                }
            }
        }
    }
}