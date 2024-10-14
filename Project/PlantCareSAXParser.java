import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class PlantCareSAXParser {

    public static void main(String[] args) {
        try {
            // Create a SAXParserFactory and SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Parse the XML file using a custom handler
            PlantHandler handler = new PlantHandler();
            saxParser.parse("plants.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Custom handler class that extends DefaultHandler
class PlantHandler extends DefaultHandler {

    private boolean bName = false;
    private boolean bCategory = false;
    private boolean bWatering = false;
    private boolean bSunlight = false;
    private boolean bTemperature = false;
    private boolean bSoil = false;
    private boolean bFertilizer = false;

    private String wateringFrequency = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // When an element starts
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("category")) {
            bCategory = true;
        } else if (qName.equalsIgnoreCase("watering")) {
            bWatering = true;
            // Capture the 'frequency' attribute
            wateringFrequency = attributes.getValue("frequency");
        } else if (qName.equalsIgnoreCase("sunlight")) {
            bSunlight = true;
        } else if (qName.equalsIgnoreCase("temperature")) {
            bTemperature = true;
        } else if (qName.equalsIgnoreCase("soil")) {
            bSoil = true;
        } else if (qName.equalsIgnoreCase("fertilizer")) {
            bFertilizer = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // When an element ends, reset the flags
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("category")) {
            bCategory = false;
        } else if (qName.equalsIgnoreCase("watering")) {
            bWatering = false;
            wateringFrequency = "";
        } else if (qName.equalsIgnoreCase("sunlight")) {
            bSunlight = false;
        } else if (qName.equalsIgnoreCase("temperature")) {
            bTemperature = false;
        } else if (qName.equalsIgnoreCase("soil")) {
            bSoil = false;
        } else if (qName.equalsIgnoreCase("fertilizer")) {
            bFertilizer = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Process the data inside the element
        if (bName) {
            System.out.println("Plant Name: " + new String(ch, start, length));
        } else if (bCategory) {
            System.out.println("Category: " + new String(ch, start, length));
        } else if (bWatering) {
            System.out.println("Watering: " + new String(ch, start, length) + " (Frequency: " + wateringFrequency + ")");
        } else if (bSunlight) {
            System.out.println("Sunlight: " + new String(ch, start, length));
        } else if (bTemperature) {
            System.out.println("Temperature: " + new String(ch, start, length));
        } else if (bSoil) {
            System.out.println("Soil: " + new String(ch, start, length));
        } else if (bFertilizer) {
            System.out.println("Fertilizer: " + new String(ch, start, length));
        }
    }
}

                
              
