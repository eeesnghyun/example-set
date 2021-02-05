package com.study.apachepoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApachePOIController {

	private static final Logger logger = LoggerFactory.getLogger(ApachePOIController.class);

	private static final String PATH = "D:\\ws_example\\file\\apachepoi\\";
	
	
	@RequestMapping(value = "/apachepoi/ex01.do", method = RequestMethod.GET)
	public String ex01(Locale locale, Model model) {
		logger.info("### Request URL : /apachepoi/ex01.do");
		return "/apachepoi/ex01";
	}
	
	@RequestMapping(value = "/apachepoi/ex02.do", method = RequestMethod.GET)
	public String ex02(Locale locale, Model model) {
		logger.info("### Request URL : /apachepoi/ex02.do");
		return "/apachepoi/ex02";
	}
	
	@RequestMapping(value = "/apachepoi/ex03.do", method = RequestMethod.GET)
	public String ex03(Locale locale, Model model) {
		logger.info("### Request URL : /apachepoi/ex03.do");
		return "/apachepoi/ex03";
	}

	@RequestMapping(value = "/apachepoi/goToExcel.do", method = { RequestMethod.GET,RequestMethod.POST })
    public ModelAndView goToExcel(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {		          	  	
		String sample = PATH + "ex01.xlsx";
		
		try {			
			File file = new File(sample);

			Workbook workbook = WorkbookFactory.create(new FileInputStream(file));			
			Sheet    sheet 	  = workbook.getSheet("Sheet1");
			
			String name  = (String) paramMap.get("name");
			String email = (String) paramMap.get("email");			
			int persons  = Integer.parseInt(paramMap.get("persons").toString());
			int money    = Integer.parseInt(paramMap.get("money").toString());
				
			// -------- 엑셀 파일 수정
			Cell cell = null;
					
			cell = getCell(sheet, 1, CellReference.convertColStringToIndex("B"));
			cell.setCellValue(name);
			
			cell = getCell(sheet, 2, CellReference.convertColStringToIndex("B"));	// Cell 알파벳 -> 숫자			
			cell.setCellValue(email);
			
			cell = getCell(sheet, 1, CellReference.convertColStringToIndex("E"));
			cell.setCellValue(money);
			
			cell = getCell(sheet, 2, CellReference.convertColStringToIndex("E"));
			cell.setCellValue(persons);
			
			cell = getCell(sheet, 3, CellReference.convertColStringToIndex("E"));
			cell.setCellFormula("E2*E3");
		
			// ----------------------------------------------------
			
			// -------- 엑셀 파일 저장
			FileOutputStream fos = new FileOutputStream(new File(sample));
			
			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();	// 수식 재계산
			workbook.write(fos);		
			// ----------------------------------------------------
					
			if(fos != null) fos.close();
			
			if(workbook != null) workbook.close();											
		} catch (Exception e) {
			e.printStackTrace();						
		}
		File file = new File(sample);
		
		return new ModelAndView("download", "downloadFile", file); 
    }
	
	public Cell getCell(Sheet sheet, int rownum, int cellnum) {
    	Row row = sheet.getRow(rownum);
    	
    	if(row == null) row = sheet.createRow(rownum);    	
    	
    	Cell cell = row.getCell(cellnum);
    	
    	if(cell == null) cell = row.createCell(cellnum);    	

    	return cell;
   	}    	

	@RequestMapping(value = "/apachepoi/readExcel.do", method = { RequestMethod.GET,RequestMethod.POST })
	public ModelAndView readExcel(HttpServletRequest request) throws Exception {
		String sample = PATH + "ex02.xlsx";
		
		ModelAndView mav = new ModelAndView();		
		try {							
			File file = new File(sample);
			
			Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
			Sheet sheet = workbook.getSheetAt(0);
			Row rowHead = sheet.getRow(0);			
				
			int rowCnt  = sheet.getPhysicalNumberOfRows();			
			int cellCnt = rowHead.getPhysicalNumberOfCells();
			
			ArrayList<ArrayList<String>> parentList = new ArrayList<ArrayList<String>>();
			ArrayList<String> childList = null;
			
			for(int i = 1; i < rowCnt; i++) {
				Row row = sheet.getRow(i);
				
				childList = new ArrayList<String>();

				if(row != null) {
					for(int j = 0; j < cellCnt; j++) {
						Cell cell = row.getCell(j);
						
						String value = "";
						
						if(cell != null) {							
							switch(cell.getCellType()) {														
								case FORMULA:
									value = cell.getCellFormula();
	                            break;
								case NUMERIC:
									value = (int) cell.getNumericCellValue() + "";
	                            break;
								case STRING:
									value = cell.getStringCellValue();									
	                            break;
								case BLANK:
									value = cell.getBooleanCellValue() + "";
	                            break;
								case ERROR:
									value = cell.getErrorCellValue() + "";
	                            break;
								case BOOLEAN:
									break;
								case _NONE:
									break;
								default:
									break;                               
							}
							childList.add(j, value);							
						}							
						logger.info(i + "번 행 : " + j + "번 열 값은: " + value);
					}
					parentList.add(childList);	
				}
			}							
			
			mav.addObject("list", parentList);
			mav.setViewName("/apachepoi/ex02_1");			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return mav;
	}
}
