import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ProductParser {

  public static void main(String[] args) {

    try {
        File xmlFile = new File("C:\\Users\\Asus TUF -PC\\OneDrive\\Desktop\\IT106\\RMI_ecommerce\\server\\products.xml.txt");
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(xmlFile);
      doc.getDocumentElement().normalize();

      System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

      NodeList productList = doc.getElementsByTagName("product");

      for (int i = 0; i < productList.getLength(); i++) {
        Node node = productList.item(i);

        if (node.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) node;

          String productCode = getElementValue(element, "productCode");
          String name = getElementValue(element, "name");
          String description = getElementValue(element, "description");
          double storePrice = Double.parseDouble(getElementValue(element, "storePrice"));
          double retailPrice = Double.parseDouble(getElementValue(element, "retailPrice"));
          double quantity = Double.parseDouble(getElementValue(element, "quantity"));

          Product product = new Product(productCode, name, description, storePrice, retailPrice, quantity);
          product.ViewProducts();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static String getElementValue(Element element, String childName) {
    NodeList nodeList = element.getElementsByTagName(childName);
    if (nodeList.getLength() > 0) {
      Element childElement = (Element) nodeList.item(0);
      Node textNode = childElement.getChildNodes().item(0);
      if (textNode != null) {
        return textNode.getNodeValue();
      }
    }
    return "";
  }
}
