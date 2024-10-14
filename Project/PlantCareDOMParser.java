import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PlantCareDOMParser {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a DOM Document object
            Document document = builder.parse("plants.xml");

            // Normalize the document (optional but recommended)
            document.getDocumentElement().normalize();

            // Get all the plant elements
            NodeList plantList = document.getElementsByTagName("plant");

            for (int i = 0; i < plantList.getLength(); i++) {
                Node plantNode = plantList.item(i);

                if (plantNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element plantElement = (Element) plantNode;

                    // Get and print plant name
                    String name = plantElement.getElementsByTagName("name").item(0).getTextContent();
                    System.out.println("Plant Name: " + name);

                    // Get and print category
                    String category = plantElement.getElementsByTagName("category").item(0).getTextContent();
                    System.out.println("Category: " + category);

                    Element wateringElement = (Element) plantElement.getElementsByTagName("watering").item(0);
                    String wateringFrequency = wateringElement.getAttribute("frequency");
                    String watering = wateringElement.getTextContent();
                    System.out.println("Watering: " + watering + " (Frequency: " + wateringFrequency + ")");

                    // Get and print sunlight information
                    String sunlight = plantElement.getElementsByTagName("sunlight").item(0).getTextContent();
                    System.out.println("Sunlight: " + sunlight);

                    String temperature = plantElement.getElementsByTagName("temperature").item(0).getTextContent();
                    System.out.println("Temperature: " + temperature);

                    // Get and print soil information
                    String soil = plantElement.getElementsByTagName("soil").item(0).getTextContent();
                    System.out.println("Soil: " + soil);

                    // Get and print fertilizer information
                    String fertilizer = plantElement.getElementsByTagName("fertilizer").item(0).getTextContent();
                    System.out.println("Fertilizer: " + fertilizer);

                    System.out.println("-------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
