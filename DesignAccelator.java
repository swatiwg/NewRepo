package Business_Methods;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Object_Repository.ICDD_CustomerRecord_Obj;
import Object_Repository.ICDD_WorkItem_Obj;
import jxl.write.Label;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import utillities.BaseTestSetup;
import utillities.Common_Utils;



public class DesignAccelator{
	
	public void designAccelator() throws RowsExceededException, WriteException, IOException{
		
	JavascriptExecutor js;
		
		int k = 0;
		
		FileOutputStream filePath = new FileOutputStream("C:\\ICCD_Framework\\BaseTestCase_Framework\\INDIA\\BasePack_Framework_HK\\src\\test\\resources\\Datatable\\accelator.xlsx");
		
		
		jxl.write.WritableWorkbook wwb=Workbook.createWorkbook(filePath);
		System.out.println("Workbook is been created");	
		for (int g = 1; g < 2; g++) {
			WritableSheet wws = wwb.createSheet("PSTC", g);
			System.out.println("Created" + g);
			Label Var = new Label ( 0, 1,  "Field_Text");
	        wws.addCell(Var);
			Label Var1 = new Label (1, 1,  "Field_Type");
	        wws.addCell(Var1);
	        Label Var2 = new Label (2, 1, "Attribute_ID");
	        wws.addCell(Var2);
	        Label Var3 = new Label (3, 1, "Attribute_Name");
	        wws.addCell(Var3);
	        Label Var4 = new Label (4, 1, "Attribute_InnerText");
	        wws.addCell(Var4);
	        Label Var5 = new Label (5, 1, "Attribute_Class");
	        wws.addCell(Var5);
	        Label Var6 = new Label (6, 1, "Attribute_Value");
	        wws.addCell(Var6);
	        Label Var7 = new Label (7, 1, "Attribute_Placeholder");
	        wws.addCell(Var7);
	        Label Var8 = new Label (8, 1, "Attribute_Title");
	        wws.addCell(Var8);
	        Label Var9 = new Label (9, 1, "Attribute_TextValue");
	        wws.addCell(Var9);
	     
        
   
        // Input Tag Elements
        
		java.util.List<org.openqa.selenium.WebElement> linkElements = BaseTestSetup.driver.findElements(By.tagName("input"));
		System.out.println(linkElements.size());
		for (int i = 0; i < linkElements.size(); i++) {
			System.out.println(linkElements.get(i).getAttribute("type"));
			if(!linkElements.get(i).getAttribute("type").equals("") & linkElements.get(i).getAttribute("type").equals("text")){
				String placeholder = linkElements.get(i).getAttribute("placeholder");
				String id = linkElements.get(i).getAttribute("id");
				String name = linkElements.get(i).getAttribute("name");
				String classname = linkElements.get(i).getAttribute("class");
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,i+2,name);
		        wws.addCell(Val);
				Label Val1 = new Label (1,i+2,"Input_EditBox");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, i+2, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, i+2, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, i+2, classname);
		        wws.addCell(Val4);
		        Label Val5 = new Label (7, i+2, placeholder);
		        wws.addCell(Val5);
		        k = i+2;
		        
			}else if(!linkElements.get(i).getAttribute("type").equals("") & linkElements.get(i).getAttribute("type").equals("password")){
				System.out.println("Entered fetching objects");
				String placeholder = linkElements.get(i).getAttribute("placeholder");
				String id = linkElements.get(i).getAttribute("id");
				String name = linkElements.get(i).getAttribute("name");
				String classname = linkElements.get(i).getAttribute("class");
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,k+1,classname);
		        wws.addCell(Val);
				Label Val1 = new Label (1,k+1,"Input_EditBox");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, k+1, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, k+1, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, k+1, classname);
		        wws.addCell(Val4);
		        Label Val5 = new Label (7, k+1, placeholder);
		        wws.addCell(Val5);
		        k = k+1;
			}else if(!linkElements.get(i).getAttribute("type").equals("") & linkElements.get(i).getAttribute("type").equals("radio")){
				String placeholder = linkElements.get(i).getAttribute("placeholder");
				String id = linkElements.get(i).getAttribute("id");
				String name = linkElements.get(i).getAttribute("name");
				String classname = linkElements.get(i).getAttribute("class");
				String filedvalue = linkElements.get(i).getText();
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,k+1,classname);
		        wws.addCell(Val);
				Label Val1 = new Label (1,k+1,"RadioButton");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, k+1, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, k+1, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, k+1, classname);
		        wws.addCell(Val4);
		        Label Val5 = new Label (7, k+1, placeholder);
		        wws.addCell(Val5);
				
			
		        k = k+1;
			}else if(!linkElements.get(i).getAttribute("type").equals("") & linkElements.get(i).getAttribute("type").equals("checkbox")){
				String placeholder = linkElements.get(i).getAttribute("placeholder");
				String id = linkElements.get(i).getAttribute("id");
				String name = linkElements.get(i).getAttribute("name");
				String classname = linkElements.get(i).getAttribute("class");
				String filedvalue = linkElements.get(i).getText();
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,k+1,filedvalue);
		        wws.addCell(Val);
				Label Val1 = new Label (1,k+1,"checkbox");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, k+1, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, k+1, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, k+1, classname);
		        wws.addCell(Val4);
		        Label Val5 = new Label (7, k+1, placeholder);
		        wws.addCell(Val5);
		        k = k+1;
			}else if(!linkElements.get(i).getAttribute("type").equals("") & linkElements.get(i).getAttribute("type").equals("submit")){
				String placeholder = linkElements.get(i).getAttribute("placeholder");
				String id = linkElements.get(i).getAttribute("id");
				String name = linkElements.get(i).getAttribute("name");
				String classname = linkElements.get(i).getAttribute("class");
				String filedvalue = linkElements.get(i).getText();
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,k+1,filedvalue);
		        wws.addCell(Val);
				Label Val1 = new Label (1,k+1,"Button");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, k+1, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, k+1, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, k+1, classname);
		        wws.addCell(Val4);
		        Label Val5 = new Label (7, k+1, placeholder);
		        wws.addCell(Val5);
		        k = k+1;
			}else if(!linkElements.get(i).getAttribute("type").equals("text") & linkElements.get(i).getAttribute("value").equals("select")){
				String placeholder = linkElements.get(i).getAttribute("placeholder");
				String id = linkElements.get(i).getAttribute("id");
				String name = linkElements.get(i).getAttribute("name");
				String classname = linkElements.get(i).getAttribute("class");
				String filedvalue = linkElements.get(i).getText();
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,k+1,filedvalue);
		        wws.addCell(Val);
				Label Val1 = new Label (1,k+1,"Select");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, k+1, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, k+1, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, k+1, classname);
		        wws.addCell(Val4);
		        Label Val5 = new Label (7, k+1, placeholder);
		        wws.addCell(Val5);
		        k = k+1;
			}
	}
		// WebElement
		java.util.List<org.openqa.selenium.WebElement> linkElements2 = BaseTestSetup.driver
				.findElements(By.tagName("a"));
		for (int i = 0; i < linkElements2.size(); i++) {
			if(!linkElements2.get(i).getText().equals("")){
				String text = linkElements2.get(i).getText();
				String filedvalue = linkElements2.get(i).getText();
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,k+1,filedvalue);
		        wws.addCell(Val);
				Label Val1 = new Label (1,k+1,"Link");
		        wws.addCell(Val1);
		        Label Val2 = new Label (9,k+1, text);
		        wws.addCell(Val2);
		        k = k+1;
			}
		}
		
		//ListBox
		java.util.List<org.openqa.selenium.WebElement> linkElements3 = BaseTestSetup.driver
				.findElements(By.tagName("select"));
		for (int i = 0; i < linkElements3.size(); i++) {
			if(!linkElements3.get(i).getAttribute("type").equals("")){
				String placeholder = linkElements3.get(i).getAttribute("placeholder");
				String id = linkElements3.get(i).getAttribute("id");
				String name = linkElements3.get(i).getAttribute("name");
				String classname = linkElements3.get(i).getAttribute("class");
				String filedvalue = linkElements3.get(i).getText();
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,k+1,filedvalue);
		        wws.addCell(Val);
				Label Val1 = new Label (1,k+1,"Dropdown");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, k+1, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, k+1, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, k+1, classname);
		        wws.addCell(Val4);
		        Label Val5 = new Label (7, k+1, placeholder);
		        wws.addCell(Val5);
		        k = k+1;
			}
		}
		
		java.util.List<org.openqa.selenium.WebElement> linkElements13 = BaseTestSetup.driver
				.findElements(By.tagName("option"));
		for (int i = 0; i < linkElements13.size(); i++) {
				String placeholder = linkElements13.get(i).getAttribute("placeholder");
				String id = linkElements13.get(i).getAttribute("id");
				String name = linkElements13.get(i).getAttribute("name");
				String classname = linkElements13.get(i).getAttribute("value");
				String title = linkElements13.get(i).getAttribute("title");
				String text = linkElements13.get(i).getText();
				String filedvalue = linkElements13.get(i).getText();
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,k+1,filedvalue);
		        wws.addCell(Val);
				Label Val1 = new Label (1,k+1,"value from dropdown");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, k+1, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, k+1, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, k+1, classname);
		        wws.addCell(Val4);
		        Label Val5 = new Label (7, k+1, placeholder);
		        wws.addCell(Val5);
		        Label Val6 = new Label (8, k+1, title);
		        wws.addCell(Val6);
		        Label Val7 = new Label (9, k+1, text);
		        wws.addCell(Val7);
		        k = k+1;
			}
		
		
		java.util.List<org.openqa.selenium.WebElement> linkElements9 = BaseTestSetup.driver
				.findElements(By.tagName("td"));
		for (int i = 0; i < linkElements9.size(); i++) {
			if(!linkElements9.get(i).getAttribute("innerHTML").equals("")){
				String id = linkElements9.get(i).getAttribute("id");
				String name = linkElements9.get(i).getAttribute("name");
				String classname = linkElements9.get(i).getAttribute("class");
				String text = linkElements9.get(i).getText();
				String filedvalue = linkElements9.get(i).getText();
				System.out.println("Entered fetching objects");
				if (!text.isEmpty())
				{
				Label Val = new Label (0,k+1,filedvalue);
		        wws.addCell(Val);
				Label Val1 = new Label (1, k+1,"Table");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, k+1, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, k+1, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, k+1, classname);
		        wws.addCell(Val4);
		        Label Val6 = new Label (9, k+1, text);
		        wws.addCell(Val6);
		        k = k+1;
				}	       
		   }
		}	
		//Button
		java.util.List<org.openqa.selenium.WebElement> linkElementsBut = BaseTestSetup.driver
				.findElements(By.tagName("button"));
		for (int i = 0; i < linkElementsBut.size(); i++) {
			if(!linkElementsBut.get(i).getAttribute("type").equals("") & linkElements.get(i).getAttribute("type").equals("submit")){
				String placeholder = linkElements.get(i).getAttribute("placeholder");
				String id = linkElements.get(i).getAttribute("id");
				String name = linkElements.get(i).getAttribute("name");
				String classname = linkElements.get(i).getAttribute("class");
				String filedvalue = linkElements.get(i).getText();
				System.out.println("Entered fetching objects");
				Label Val = new Label (0,k+1,"filedvalue");
		        wws.addCell(Val);
				Label Val1 = new Label (1,i+2,"Button");
		        wws.addCell(Val1);
		        Label Val2 = new Label (2, i+2, id);
		        wws.addCell(Val2);
		        Label Val3 = new Label (3, i+2, name);
		        wws.addCell(Val3);
		        Label Val4 = new Label (5, i+2, classname);
		        wws.addCell(Val4);
		        Label Val5 = new Label (7, i+2, placeholder);
		        wws.addCell(Val5);
	        
		        k = i+2;
			}		
		}
		
		 //Image
  		java.util.List<org.openqa.selenium.WebElement> linkElements4 = BaseTestSetup.driver
  				.findElements(By.tagName("img"));
  		for (int i = 0; i < linkElements4.size(); i++) {
  				String src = linkElements4.get(i).getAttribute("src");
  				String Sp[] = src.split("/");
  				int Ubound = Sp.length;
      				if(Sp[Ubound-1].equals("btn-next.png")){
      					String name = linkElements4.get(i).getAttribute("class");
          				Label Val1 = new Label (1,k+1,"Image_Button");
          		        wws.addCell(Val1);
      					String id = linkElements4.get(i).getAttribute("title");
      					Label Val2 = new Label (2,k+1, id);
          		        wws.addCell(Val2);
          		        k = k+1;
      				}else if(Sp[Ubound-1].equals("calendar.gif")){
	      				String id = linkElements4.get(i).getAttribute("title");
	      				String name = linkElements4.get(i).getAttribute("class");
	      				Label Val1 = new Label (1,k+1,"Image_Calender");
	      		        wws.addCell(Val1);
	      		        Label Val2 = new Label (2,k+1, id);
	      		        wws.addCell(Val2);
	      		        Label Val3 = new Label (3,k+1, name);
	      		        wws.addCell(Val3);
	      		        k = k+1;
      				}
  		}
  		String n = g + "";
  		if(n.equals("1")){
//  			driver.findElement(By.id("close")).click();
//		    driver.switchTo().window(default_window);
//		    driver.findElement(By.xpath("//*[@alt='Overdrafts']")).click();
//		    driver.findElement(By.id("apply2e71e0004be90ef99de2fff4826f4cd0")).click();
//		    driver.switchTo().frame("popupFrame");
 // 			driver.findElement(By.id("login_Layer")).click();
// 			Thread.sleep(2000);
//  			driver.findElement(By.xpath("//*[@class='row txtC']/a")).click();
 // 			Thread.sleep(2000);
  		}
  	}
		
	        wwb.write();  
	        wwb.close();
	      
		}


//Vbs();
	
	
	
	public static void Vbs() throws InterruptedException {
		try {
			// System.out.println("in vbs method");
			
			
			Runtime.getRuntime().exec("wscript D:\\PSTC\\PSTC_Selenium_Workspace\\PSTC_Contest\\PSTC_DataExtraction\\Transpose.vbs");
			Thread.sleep(10000);
			Runtime.getRuntime().exec("wscript D:\\PSTC\\PSTC_Selenium_Workspace\\PSTC_Contest\\PSTC_DataExtraction\\DataPool.vbs");
			
			//Runtime.getRuntime().exec("wscript D:\\Pradeep_Selenium\\TAB.vbs");
		} catch (IOException e)

		{
			System.out.println("Error" + e);
		}
	}
	
}
