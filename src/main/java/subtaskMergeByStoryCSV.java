import sun.misc.BASE64Encoder;

import java.io.*;

public class subtaskMergeByStoryCSV {


    public static final String Backend_CSV_FILE_PATH = "/Users/19070005/Documents/gitRepo/ir-api-test/src/main/java/C4I-Backend.csv";
    public static final String Frontend_CSV_FILE_PATH = "/Users/19070005/Documents/gitRepo/ir-api-test/src/main/java/C4I-Frontend.csv";
    public static final String Test_CSV_FILE_PATH = "/Users/19070005/Documents/gitRepo/ir-api-test/src/main/java/C4I-Test.csv";
    //    public static final String[] StoryList = {"DAT4-5371,DAT4-5352,DAT4-5431,DAT4-5435,DAT4-5381,DAT4-5444,DAT4-5368,DAT4-5369,DAT4-5373,DAT4-5374,DAT4-5375,DAT4-5376,DAT4-5311,DAT4-5349,DAT4-5348,DAT4-4974,DAT4-5315,DAT4-5351,DAT4-5391,DAT4-5395,DAT4-5426,DAT4-5427,DAT4-5364,DAT4-5439,DAT4-5365,DAT4-5363,DAT4-5279,DAT4-5359,DAT4-5361,DAT4-5428,DAT4-5434,DAT4-5436,DAT4-5437,DAT4-5438,DAT4-5440,DAT4-5443"};
    public static final String[] StoryList = {"DAT4-5371","DAT4-5352","DAT4-5431","DAT4-5435","DAT4-5381","DAT4-5444","DAT4-5368","DAT4-5369","DAT4-5373","DAT4-5374","DAT4-5375","DAT4-5376","DAT4-5311","DAT4-5349","DAT4-5348","DAT4-4974","DAT4-5315","DAT4-5351","DAT4-5391","DAT4-5395","DAT4-5426","DAT4-5427","DAT4-5364","DAT4-5439","DAT4-5365","DAT4-5363","DAT4-5279","DAT4-5359","DAT4-5361","DAT4-5428","DAT4-5434","DAT4-5436","DAT4-5437","DAT4-5438","DAT4-5440","DAT4-5443"};

    public static void main(String[] args) {
        String backendCsvFile = Backend_CSV_FILE_PATH;
        String frontendCsvFile = Frontend_CSV_FILE_PATH;
        String testCsvFile = Test_CSV_FILE_PATH;
        BufferedReader backendBR = null;
        BufferedReader frontendBR = null;
        BufferedReader testBR = null;
        String line = "";
        String cvsSplitBy = ",";

        for (int i = 0; i < StoryList.length; i++) {
            try {
                backendBR = new BufferedReader(new FileReader(backendCsvFile));
                backendBR.readLine();

                while ((line = backendBR.readLine()) != null) {
                    String[] backendSubtask = line.split(cvsSplitBy);
                    if (backendSubtask[0].equals(StoryList[i])) {
                        for (int j = 0; j < backendSubtask.length; j++) {
                            System.out.print(backendSubtask[j] + ",");
                        }
                        System.out.println("");
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (backendBR != null) {
                    try {
                        backendBR.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                frontendBR = new BufferedReader(new FileReader(frontendCsvFile));
                frontendBR.readLine();

                while ((line = frontendBR.readLine()) != null) {
                    String[] frontendSubtask = line.split(cvsSplitBy);

                    if (frontendSubtask[0].equals(StoryList[i])) {
                        for (int j = 0; j < frontendSubtask.length; j++) {
                            System.out.print(frontendSubtask[j] + ",");
                        }
                        System.out.println("");
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (frontendBR != null) {
                    try {
                        frontendBR.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                testBR = new BufferedReader(new FileReader(testCsvFile));
                testBR.readLine();

                while ((line = testBR.readLine()) != null) {
                    String[] testSubtask = line.split(cvsSplitBy);

                    if (testSubtask[0].equals(StoryList[i])) {
                        for (int j = 0; j < testSubtask.length; j++) {
                            System.out.print(testSubtask[j] + ",");
                        }
                        System.out.println("");
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (testBR != null) {
                    try {
                        testBR.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


