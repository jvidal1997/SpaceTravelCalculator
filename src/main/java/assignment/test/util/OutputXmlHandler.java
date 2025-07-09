/**
 * This class is intended to manage the output of the {@link Main} program.
 * @author J. Vidal
 * 10.23.2024
 */
package assignment.test.util;

import assignment.AppRouter;
import assignment.test.TestApplicationProperties;
import edu.ccri.assignment.files.xml.AbstractXmlStaxWriteElementData;
import edu.ccri.assignment.files.xml.XmlStaxElementData;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class is intended to manage the output of the {@link AppRouter} program.
 */
public class OutputXmlHandler extends AbstractXmlStaxWriteElementData {
    /**
     * An array list to store the output data
     */
    private ArrayList<ArrayList<XmlStaxElementData>> dataList = new ArrayList<>();
    /**
     * The number of times the {@link #getChildNodeTag()} method has been called.
     */
    private int callCount = 0;
    /**
     * The number of times a trip node tag has been created.
     */
    private int iterationCount = 0;
    /**
     * Used to name the trip nodes with an ordered number. *
     */
    private int tripCount = 0;

    /**
     * Constructs a new {@link OutputXmlHandler} instance and initializes it.
     */
    public OutputXmlHandler() {
        super();
        initialize();
    }

    @Override
    protected String getChildNodeTag() {
        switch (callCount) {
            case 0, 1 -> {
                callCount++;
                return "contact";
            }
            case 2, 3 -> {
                callCount++;
                return "constant";
            }
            default -> {
                callCount++;
                if (iterationCount % 2 == 0) {
                    tripCount++;
                }
                iterationCount++;
                return "trip" + tripCount;
            }
        }
    }

    @Override
    protected ArrayList<ArrayList<XmlStaxElementData>> getDataList() {
        return this.dataList;
    }

    @Override
    protected void setDataList(ArrayList<ArrayList<XmlStaxElementData>> dataList) {
        this.dataList = dataList;
    }

    @Override
    protected String getFileNamePrefix() {
        String uniqueID = "." + UUID.randomUUID();
        TaskManager.setOutputXMLFileName(TestApplicationProperties.APP_RESOURCES_PATH + TestApplicationProperties.OUTPUT_FILE_NAME_PLANETARY_CONSTANTS_PREFIX + uniqueID);
        return TaskManager.getOutputXMLFileName();
    }

    @Override
    protected String getFileNameSuffix() {
        TaskManager.setOutputXMLFileName(TaskManager.outputXMLFileName + TestApplicationProperties.OUTPUT_FILE_NAME_PLANETARY_CONSTANTS_SUFFIX);
        return TestApplicationProperties.OUTPUT_FILE_NAME_PLANETARY_CONSTANTS_SUFFIX;
    }

    @Override
    protected String getXmlParentTag() {
        return "output";
    }

    @Override
    protected boolean useNameUnique() {
        return false;
    }
}
