package com.example.student.createExcel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import com.example.student.model.Student;

public class excelGenerator {
	public static ByteArrayInputStream studentToExcel(List<Student> students) throws IOException{
		String[] columns = {"Roll Number","Name","Description","Science Marks","Language Marks","Social Science Marks","Percentage","Grade"};
		try (
				Workbook workBook =new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				){
			Sheet sheet = workBook.createSheet("Students");
			
			Font headerFont = workBook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.DARK_RED.getIndex());
			
			CellStyle headerCellStyle = workBook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			//Row for header-->
			Row headerRow = sheet.createRow(0);
			
			
			
			//header-->
			for(int col=0; col<columns.length;col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);
				
			}
			
			int rowIdx = 1;
			for(Student stud: students) {
				Row row = sheet.createRow(rowIdx++);
				row.createCell(0).setCellValue(stud.getRollNo());
				row.createCell(1).setCellValue(stud.getName());
				row.createCell(2).setCellValue(stud.getDesc());
				row.createCell(3).setCellValue(stud.getScienceMks());
				row.createCell(4).setCellValue(stud.getLangMks());
				row.createCell(5).setCellValue(stud.getSstMks());
				row.createCell(6).setCellValue(stud.getPerc());
				row.createCell(7).setCellValue(stud.getGrade());
			}
			
			workBook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
		
	}
}
