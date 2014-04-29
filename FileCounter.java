
import java.io.*;



public class FileCounter {

	
	 public void getAllFileNames(String fileName) {
	        
		 try {
	        	
	     File f = new File(fileName);
	     int count = 0;
         for (File file : f.listFiles()) {
                 if (file.isFile()) {
                         count++;
                 }
                 System.out.println("Done!!" + count);  
         }

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	 
	 public static void main (String args[]){
		 FileCounter f= new FileCounter();
		 f.getAllFileNames("C:\\sample\\src\\com\\toyota\\tms\\dealercommon\\DealerAssociateFilterType.java");
		 
	 }

	}
