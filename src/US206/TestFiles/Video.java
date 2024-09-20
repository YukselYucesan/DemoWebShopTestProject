package US206.TestFiles;
import java.io.IOException;

public class Video {
    public static void main(String[] args) {
        String videoPath = "\"C:\\Users\\ASUS\\IdeaProjects\\DemoWebShopTestProject\\src\\US206" +
                           "\\TestFiles\\DemoWebShop_TestProject.webm\"";

        try {
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", videoPath});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}