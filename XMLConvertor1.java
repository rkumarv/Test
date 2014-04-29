
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormat;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;


public class XMLConvertor1 {

	
	 public void getAllUserNames(File fileName) {
	        try {
	            //xml parser
	        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            // excel sheet creation
	         // create a new excel file
	            
	            FileOutputStream out = new FileOutputStream(fileName.getParent()+ "\\" + "FortifyReport.xls");
	                 
	            HSSFWorkbook wb = new HSSFWorkbook();
	            HSSFSheet spreadSheet = wb.createSheet("spreadsheet");
	            HSSFCellStyle cellStyle=wb.createCellStyle();
	            DataFormat format = wb.createDataFormat();
	         // declare a row object reference
	            HSSFRow row = null;
	            // declare a cell object reference
	            HSSFCell cell = null;
	        
	            
	            if (fileName.exists()) {
	                Document doc = db.parse(fileName);
	                Element docEle = doc.getDocumentElement();
	                cellStyle.setWrapText(true);
	                              	 
	                NodeList defectList = docEle.getElementsByTagName("Issue");
	 
	                // Print total student elements in document
	                if (defectList != null && defectList.getLength() > 0) {
	                    for (int i = 0; i < 1; i++) {
	                    	
	                    	row = spreadSheet.createRow(i);
	                    	for (int j = 0; j < 1; j++) {
	                    		
	                    		cell= row.createCell(j);
	                            cell.setCellValue("Category");
	                            cell= row.createCell(j+1);
	                            cell.setCellValue("Priority");
	                            cell= row.createCell(j+2);
	                            cell.setCellValue("File Name");
	                            cell= row.createCell(j+3);
	                            cell.setCellValue("File Path");
	                            cell= row.createCell(j+4);
	                            cell.setCellValue("Line Number");
	                            cell= row.createCell(j+5);
	                            cell.setCellValue("Code Snippet");
	                            System.out.println("Are you Kidding!!!!" + defectList.getLength() +"# of issues" );
	                    	}
	                    }}
	                                         
	                if (defectList != null && defectList.getLength() > 0) {
	                    for (int i = 0; i < defectList.getLength(); i++) {
	                    	System.out.println("*****" + i);
	                        Node node = defectList.item(i);
	                        row = spreadSheet.createRow(i+1);
	                        
	                       
	                        if (node.getNodeType() == Node.ELEMENT_NODE) {
	 
	                            
	                            for (int j = 0; j < 1; j++) {
	                            	
	                            	
	                            Element e = (Element) node;
	                            NodeList nodeList = e.getElementsByTagName("Category");
	                            cell= row.createCell(j);
	                            
	                            cell.setCellValue(nodeList.item(0).getChildNodes().item(0)
                                .getNodeValue());
	                            spreadSheet.autoSizeColumn(j);
	                            
	 
	                            nodeList = e.getElementsByTagName("Friority");
	                            cell= row.createCell(j+1);
	                            
	                            cell.setCellValue(nodeList.item(0).getChildNodes().item(0)
	                                    .getNodeValue());
	                            spreadSheet.autoSizeColumn(j+1);
	                            
	 
	                            nodeList = e.getElementsByTagName("FileName");
	                            cell= row.createCell(j+2);
	                            cell.setCellValue(nodeList.item(0).getChildNodes().item(0)
	                                    .getNodeValue());
	                            spreadSheet.autoSizeColumn(j+2);
	                            
	                            
	                            nodeList = e.getElementsByTagName("FilePath");
	                            cell= row.createCell(j+3);
	                            cell.setCellValue(nodeList.item(0).getChildNodes().item(0)
	                                    .getNodeValue());
	                            spreadSheet.autoSizeColumn(j+3);
	                            
	                            
	                            nodeList = e.getElementsByTagName("LineStart");
	                            cell= row.createCell(j+4);
	                            cellStyle.setDataFormat(format.getFormat("0.0"));
	                            cell.setCellValue(nodeList.item(0).getChildNodes().item(0)
	                                    .getNodeValue());
	                            spreadSheet.autoSizeColumn(j+4);
	                           
	                            
	                            
	                          nodeList = e.getElementsByTagName("Snippet");
	                            cell= row.createCell(j+5);
	                           /* cell.setCellValue(nodeList.item(0).getChildNodes().item(0)
	                                    .getNodeValue());*/
	                            cell.setCellValue("");
	                            spreadSheet.autoSizeColumn(j+5);
	                            
	                            
	                           	                                                      
	                            }
	                        }
	                }
	                } else {
	                    System.exit(1);
	                }
	                wb.write(out);
	                out.flush();
	                out.close();
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	}
