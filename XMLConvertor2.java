
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;


public class XMLConvertor2 {

	
	 public void getAllUserNames(File fileName) {
	        try {
	            //xml parser
	        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            // excel sheet creation
	         // create a new excel file
	            
	            FileOutputStream out = new FileOutputStream(fileName.getParent()+ "\\" + "VeracodeReport.xls");
	                 
	            HSSFWorkbook wb = new HSSFWorkbook();
	            HSSFSheet spreadSheet = wb.createSheet("Spreadsheet");
	            HSSFCellStyle cellStyle=wb.createCellStyle();
	          //  DataFormat format = wb.createDataFormat();
	         // declare a row object reference
	            HSSFRow row = null;
	            // declare a cell object reference
	            HSSFCell cell = null;
	        
	                    
	            if (fileName.exists()) {
	                Document doc = db.parse(fileName);
	                Element docEle = doc.getDocumentElement();
	                cellStyle.setWrapText(true);
	                               	 
	                NodeList defectList = docEle.getElementsByTagName("flaw");
	 
	                // Print total student elements in document
	                if (defectList != null && defectList.getLength() > 0) {
	                    for (int i = 0; i < 1; i++) {
	                    	
	                    	row = spreadSheet.createRow(i);
	                    	for (int j = 0; j < 1; j++) {
	                    		
	                    		cell= row.createCell(j);
	                            cell.setCellValue("Category Name");
	                            cell= row.createCell(j+1);
	                            cell.setCellValue("Severity");
	                            cell= row.createCell(j+2);
	                            cell.setCellValue("Module");
	                            cell= row.createCell(j+3);
	                            cell.setCellValue("File Name");
	                            cell= row.createCell(j+4);
	                            cell.setCellValue("Path");
	                            cell= row.createCell(j+5);
	                            cell.setCellValue("Line Number");
	                            cell= row.createCell(j+6);
	                            cell.setCellValue("Code Snippet");
	                            cell= row.createCell(j+7);
	                            cell.setCellValue("Description");
	                    	}
	                    }}
	                                       
	                if (defectList != null && defectList.getLength() > 0) {
	                    for (int i = 0; i < defectList.getLength(); i++) {
	 
	                        Node node = defectList.item(i);
	                        row = spreadSheet.createRow(i+1);
	                        
	                        System.out.println("++++++++++++++++++++++++++++++++++" + i);
	                        if (node.getNodeType() == Node.ELEMENT_NODE) {
	 
	                            
	                            for (int j = 0; j < 1; j++) {
	                            	
	                            	
	                            Element e = (Element) node;
	                            NodeList nodeList = e.getElementsByTagName("flaw");
	                           // Element gElement = (Element)nodeList.item(0);
	                            //Element textElement = (Element)gElement.getElementsByTagName("flaw").item(i).getAttributes();
	                        //  System.out.println("++++++++++++++++++++++++++++++++++" + e.getAttributes());
	                            // Element e1 = (Element)nodeList.item(0);
	                            cell= row.createCell(j);
	                            
	                           cell.setCellValue(e.getAttribute("categoryname"));
                               spreadSheet.autoSizeColumn(j);
	                            
	                            cell= row.createCell(j+1);
	                            cell.setCellValue(e.getAttribute("severity"));
	                            spreadSheet.autoSizeColumn(j+1);
	                            
	 
	                            cell= row.createCell(j+2);
	                            cell.setCellValue(e.getAttribute("module"));
	                            spreadSheet.autoSizeColumn(j+2);
	                           	
	                                                      
	                            cell= row.createCell(j+3);
	                            cell.setCellValue(e.getAttribute("sourcefile"));
	                            spreadSheet.autoSizeColumn(j+3);
	                            
	                            cell= row.createCell(j+4);
	                            cell.setCellValue(e.getAttribute("sourcefilepath"));
	                            spreadSheet.autoSizeColumn(j+4);
	                            
	                            cell= row.createCell(j+5);
	                            cell.setCellValue(e.getAttribute("line"));
	                            spreadSheet.autoSizeColumn(j+5);
	                            
	                            cell= row.createCell(j+6);
	                            cell.setCellValue(e.getAttribute("functionprototype"));
	                            spreadSheet.autoSizeColumn(j+6);
	                            
	                            cell= row.createCell(j+7);
	                            cell.setCellValue(e.getAttribute("description"));
	                            spreadSheet.autoSizeColumn(j+7);
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
