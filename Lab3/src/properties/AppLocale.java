package properties;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class AppLocale {
    private static final String strMsg = "properties/Msg";
    private static Locale loc;
    private static ResourceBundle res;
    private static ResourceBundle appSettings;


    
    /** 
     * @return Locale
     */
    public static Locale get() {
        return AppLocale.loc;
    }

    
    /** 
     * @param loc
     */
    public static void set(Locale loc) {
        AppLocale.loc = loc;
        res = ResourceBundle.getBundle(AppLocale.strMsg, AppLocale.loc);
        appSettings = ResourceBundle.getBundle("properties/application");
    }

    
    /** 
     * @return ResourceBundle
     */
    public static ResourceBundle getBundle() {
        return AppLocale.res;
    }

    
    /** 
     * @param key
     * @return String
     */
    public static String getString(String key) {
        return getColor().get(AppLocale.appSettings.getString(COLOR)) + AppLocale.res.getString(key) + ANSI_RESET;
    }

    
    /** 
     * @return Map<String, String>
     */
    public static Map<String, String> getColor() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("BLACK", ANSI_BLACK);
        map.put("RED", ANSI_RED);
        map.put("GREEN", ANSI_GREEN);
        map.put("YELLOW", ANSI_YELLOW);
        map.put("BLUE", ANSI_BLUE);
        map.put("PURPLE", ANSI_PURPLE);
        map.put("CYAN", ANSI_CYAN);
        map.put("WHITE", ANSI_WHITE);

        return map;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Resource keys:

    public static final String TEXT = "TEXT";
    public static final String ALL_WORDS = "ALL_WORDS";
    public static final String ENTER_CHARACTER = "ENTER_CHARACTER";
    public static final String WORDS_SORTED = "WORDS_SORTED";
    public static final String TRANSFORM_MODE = "TRANSFORM_MODE";


    public static final String COLOR = "COLOR";
}
