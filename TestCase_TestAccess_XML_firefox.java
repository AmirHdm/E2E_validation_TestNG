/*
 Used for UI testing purpose & Access testing 
 Firefox v : 111.0 (64 bits)
 geckodriver : geckodriver-v0.32.2-win64
 Selenium : selenium-java-4.8.1

*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//Read data from external xml file
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class TC1 {


    public static String user_id;
    public static String user_name;
    public static String user_password;

	public static void main(String[] args) {
    	
    	try {
    	    File fXmlFile = new File("C:\\Users\\Amir\\Desktop\\webdriver\\Cred.xml");
    	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	    Document doc = dBuilder.parse(fXmlFile);
    	    doc.getDocumentElement().normalize();

    	    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
    	    NodeList nList = doc.getElementsByTagName("UserCred1");

    	    for (int temp = 0; temp < nList.getLength(); temp++) {
    	        Node nNode = nList.item(temp);
    	        System.out.println("\nCurrent Element :" + nNode.getNodeName());
    	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    	            Element eElement = (Element) nNode;
    	           user_id =eElement.getAttribute("id");
    	           user_name = eElement.getElementsByTagName("userid").item(0).getTextContent();
    	           user_password = eElement.getElementsByTagName("userpassword").item(0).getTextContent();
    	        }
    	    }
    	    } catch (Exception e) {
    	    e.printStackTrace();
    	    }
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","C:\\firefox\\geckodriver.exe");
    	 	
    	WebDriver driver = new FirefoxDriver();
    	      
        // launch Fire fox and direct it to the Base URL
    	
    	
    	driver.get("http://www.demo.guru99.com/V4/");
    	driver.findElement(By.name("uid")).sendKeys(user_name);
    	driver.findElement(By.name("password")).sendKeys(user_password);
    	driver.findElement(By.name("btnLogin")).click();
    	String ExpectedTitle = "Guru99 Bank Manager HomePage";
    	String ActualTitle = driver.getTitle();
    	    	
    	if (ActualTitle.contentEquals(ExpectedTitle))
    	{
    		System.out.println(ActualTitle);
        	System.out.println(ExpectedTitle);
    		System.out.println("Test OK");
    		
    	} else
    	{
    		System.out.println(ActualTitle);
        	System.out.println(ExpectedTitle);
    		System.out.println("Test KO");
    	}
    	
       
    	driver.close();
    }

}