//Used for UI testing purpose
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
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
    	    NodeList nList = doc.getElementsByTagName("UserCred");

    	    for (int temp = 0; temp < nList.getLength(); temp++) {
    	        Node nNode = nList.item(temp);
    	        System.out.println("\nCurrent Element :" + nNode.getNodeName());
    	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    	            Element eElement = (Element) nNode;
    	            System.out.println("Id : "
    	                               + eElement.getAttribute("id"));
    	           user_id =eElement.getAttribute("id");
    	            System.out.println("user id : "
    	                               + eElement.getElementsByTagName("userid")
    	                                 .item(0).getTextContent());
    	            user_name = eElement.getElementsByTagName("userid")
                            .item(0).getTextContent();
    	            System.out.println("user password : "
    	                               + eElement.getElementsByTagName("userpassword")
    	                                 .item(0).getTextContent());
    	            user_password = eElement.getElementsByTagName("userpassword")
                            .item(0).getTextContent();
    	        }
    	    }
    	    } catch (Exception e) {
    	    e.printStackTrace();
    	    }
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","C:\\chrome2\\chromedriver.exe");
    	ChromeOptions co = new ChromeOptions();
    	co.addArguments("--remote-allow-origins=*");  	
    	WebDriver driver = new ChromeDriver(co);
    	      
        // launch Fire fox and direct it to the Base URL
    	
    	
    	driver.get("http://www.demo.guru99.com/V4/");
    	driver.findElement(By.name("uid")).sendKeys(user_name);
    	driver.findElement(By.name("password")).sendKeys(user_password);
    	driver.findElement(By.name("btnLogin")).click();
    	String ExpectedTitle = " Guru99 Bank Manager HomePage ";
    	String ActualTitle = driver.getTitle();
    	
    	System.out.println(ActualTitle);
    	if (ActualTitle.contentEquals(ExpectedTitle))
    	{
    		System.out.println("Test OK");
    	} else
    	{
    		System.out.println("Test KO");
    	}
    	
       
    	//driver.close();
    }

}