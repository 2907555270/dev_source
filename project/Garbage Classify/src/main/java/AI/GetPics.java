package AI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetPics {

    //获取目录下的所有文件路径
    public static ArrayList<String> get_file(String folder_path){
        ArrayList<String> pis_paths = new ArrayList<>();
        File folder = new File(folder_path);
        File[] files = folder.listFiles();
        for (File file : files ) {
            pis_paths.add(file.toString());
        }
        return pis_paths;
    }

    //获取当前目录下的所有目录
    public static List<String> get_folder(String path){
        List<String> list = new ArrayList<>();
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file:files ) {
            if(file.isDirectory())
                list.add(file.toString());
        }
        return list;
    }
}

