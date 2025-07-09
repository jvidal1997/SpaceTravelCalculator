/**
 * This class is intended to handle writing output data to an Excel file.
 * @author J. Vidal
 * 10.13.2024
 */
package assignment.test.util;

import assignment.test.TestApplicationProperties;
import edu.ccri.assignment.files.poi.AbstractPoiWriteElementDataList;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class contains static methods that handle writing output data to an Excel file.
 */
public class OutputExcelHandler extends AbstractPoiWriteElementDataList {
    /**
     * A logger for testing static methods
     */
    private static final Logger logger = LogManager.getLogger( );
    /**
     * A boolean to indicate if the output directory has been initialized
     */
    private boolean initialized = false;
    /**
     * An array list to store the output data
     */
    private ArrayList<ArrayList<Object>> dataList = new ArrayList<>();

    /**
     * This is an empty constructor for the OutputExcelHandler class.
     */
    public OutputExcelHandler() {}

    /**
     * This method is used to get the output data list
     * @return the output data list
     */
    @Override
    protected ArrayList<ArrayList<Object>> getDataList() {
        return dataList;
    }

    /**
     * This method is used to get a unique output filename prefix
     * @return a unique filename prefix
     */
    @Override
    protected String getFileNamePrefix() {
        try {
            int i = getUniqueID();
            TaskManager.outputExcelFileName = TestApplicationProperties.APP_RESOURCES_PATH != null ? TestApplicationProperties.APP_RESOURCES_PATH + TestApplicationProperties.OUTPUT_FILE_NAME_PREFIX + i : "Unknown";
            return TaskManager.outputExcelFileName;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(ExceptionUtils.getStackTrace(e));
            return "";
        }
    }

    /**
     * This method is used to get the output filename suffix
     * @return the filename suffix
     */
    @Override
    protected String getFileNameSuffix() {
        return TestApplicationProperties.OUTPUT_FILE_NAME_SUFFIX != null ? TestApplicationProperties.OUTPUT_FILE_NAME_SUFFIX : ".xlsx";
    }

    /**
     * This method is used to set the output data list for the current work sheet
     * @param dataList the output data list
     */
    @Override
    protected void setDataList(ArrayList<ArrayList<Object>> dataList) {
        // If the output directory has not been initialized, initialize it and set initialized boolean to true
        if (!initialized) {
            initialize();
            initialized = true;
        }
        // Set the output data list for the current work sheet
        this.dataList = dataList;
    }

    /**
     * Checks if the output directory is full using the {@link #checkDirectory()} method. If the directory is full, a <i>FileNotFoundException</i> is thrown.
     * If the directory is not full, a unique filename ID is generated and returned using the {@link #getFile()} method.
     *
     * @return a unique filename ID that does not already exist in the output directory
     * @throws FileNotFoundException if the directory is full
     */
    private static int getUniqueID() throws FileNotFoundException {
        Boolean isFull = checkDirectory();
        if (isFull) {
            throw new FileNotFoundException("Directory is full. Please empty directory and try again.");
        }
        else{
            return getFile();
        }
    }

    /**
     * Generates a unique filename ID using {@link Random} and ensures it does not already exist in the output directory.
     *
     * @return a unique filename ID that does not already exist in the output directory
     */
    private static int getFile() {
        Random randomNumber = new Random();
        int i;
        File f;
        do {
            i = randomNumber.nextInt(21) + 1;
            f = new File(TestApplicationProperties.APP_RESOURCES_PATH + TestApplicationProperties.OUTPUT_FILE_NAME_PREFIX + i + TestApplicationProperties.OUTPUT_FILE_NAME_SUFFIX);
        } while (f.exists());
        return i;
    }

    /**
     * Checks if the directory is full.<br><br> A directory is considered full if all 21 possible
     * filenames
     * exist in the directory (ProcessedData1, ProcessedData2, ..., ProcessedData21).
     *
     * @return true if the directory is full, false otherwise
     */
    public static Boolean checkDirectory() {
        logger.info("Checking available capacity..");
        for (int i = 1; i <= 21; i++) {
            File f = new File(TestApplicationProperties.APP_RESOURCES_PATH + TestApplicationProperties.OUTPUT_FILE_NAME_PREFIX + i + TestApplicationProperties.OUTPUT_FILE_NAME_SUFFIX);
            if (!f.exists()) {
                logger.info("Available capacity test passed.");
                return false;
            }
        }
        logger.error("Available capacity test failed.");
        return true;
    }
}
