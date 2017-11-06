import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.InputStream;

public class PictureSorter{
   public static void sort() {
         //Folder of unsorted pictures
         File dir = new File("ENTERPATH");
         ArrayList <String> picList = new ArrayList<String>(); 
         if (dir.isDirectory()) { 
         String[] files = dir.list(); 
          for (String file : files) {
             picList.add(file); 
          }
         }
         for(int i = 0; i < picList.size()-1; i++){
            //Folder of unsorted pictures
            Path picPath = Paths.get("ENTERPATH" + picList.get(i));
            try{
               BasicFileAttributes attr = Files.readAttributes(picPath, BasicFileAttributes.class);
               String time = attr.creationTime().toString();
               int loc = time.indexOf('T');
               String cutTime = time.substring(0,loc);
               new File(cutTime).mkdir();
               //Folder of unsorted pictures
               Path FROM = Paths.get("ENTERPATH" + picList.get(i));
               //Folder where the sorted pictures will go to
               Path TO = Paths.get("ENTERPATH" + cutTime + "\\" + picList.get(i)); 
               Files.copy(FROM, TO);             
            }
            catch(IOException e){
               e.printStackTrace();
            }
         }  
   }
   public static void main(String[] args)  {
      sort();
   }
}          
