import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PrivateData {
    //Хранилище необходимых данных
    static ArrayList<String>data = new ArrayList<String>();

    private static String LOGIN = "";
    private static String PASSWORD = "";
    private static String YOUR_GITHUB_NAME = "";


    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getYOU_GH_NAME() {
        return YOUR_GITHUB_NAME;
    }

}
