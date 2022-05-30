import AI.ClassifyUtils;
import AI.GetPics;
import ai.onnxruntime.OrtException;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class test_model_util {

    //private final String folder_path = "/run/media/flyme/68BE59E7BE59ADF6/Users/flyme/Pictures/垃圾分类目录/垃圾目录/";
    private final String folder_path = "/home/flyme/datasets/test";
    private final String log_path = "/home/flyme/model_test.txt";
    private final String pic_path = "src/main/resources/img/2-2.jpeg";

    //批量预测
    @Test
    public void evaluate() throws IOException, OrtException {
        ArrayList<Double> big_acc = new ArrayList<>();
        ArrayList<Double> small_acc = new ArrayList<>();

        //label
        String[] label = new String[2];

        //将预测记录写入文件
        File write_file = new File(log_path);
        //文件不存在创建文件
        if (!write_file.exists()) {
            write_file.createNewFile();
        }
        //文件输出流写入文件数据
        FileOutputStream fileOutputStream = new FileOutputStream(write_file);

        //获取预测图片的文件Path
        //获取大分类目录s
        ArrayList<String> folders = (ArrayList<String>) GetPics.get_folder(folder_path);
        for (String path : folders) {
            //存放小分类目录的path
            File big_folder = new File(path);
            label[0] = big_folder.getName();
            File[] mini_folder = big_folder.listFiles();
            for (File file : mini_folder) {
                label[1] = file.getName();
                File[] files = file.listFiles();
                //标题：
                byte[] bytes = (label[0] + "-" + label[1] + "---预测结果:\n").getBytes("UTF-8");
                fileOutputStream.write(bytes);
                //大小分类统计数
                int big_count = 0;
                int small_count = 0;
                //遍历图片文件并进行预测
                byte[] bytes1 = ("\t错误预测记录：\n").getBytes("UTF-8");
                fileOutputStream.write(bytes1);
                for (File name : files) {
                    //获取图片的路径名
                    String file_name = name.toString();
                    //进行预测
                    try {
                        String[] predict = ClassifyUtils.predict(file_name);
                        if (!predict[1].equals(label[1])) {
                            small_count++;
                            if (!predict[0].equals(label[0]))
                                big_count++;
                            byte[] bytes2 = ("\t\t" + label[0] + "-" + label[1] + " " + predict[0] + "-" + predict[1] + "\n").getBytes("UTF-8");
                            fileOutputStream.write(bytes2);
                            byte[] path_byte = ("\t\t"+file_name+"\n").getBytes(StandardCharsets.UTF_8);
                            fileOutputStream.write(path_byte);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //预测准确率分析
                double acc_1 = (1 - (double) big_count / files.length);
                double acc_2 = (1 - (double) small_count / files.length);
                byte[] bytes3 = ("\t大分类错误:" + big_count).getBytes("UTF-8");
                byte[] bytes4 = ("\t小分类错误:" + small_count).getBytes("UTF-8");
                byte[] bytes5 = ("\t大分类准确率:" + acc_1).getBytes("UTF-8");
                byte[] bytes6 = ("\t小分类准确率:" + acc_2 + "\n").getBytes("UTF-8");
                fileOutputStream.write(bytes3);
                fileOutputStream.write(bytes4);
                fileOutputStream.write(bytes5);
                fileOutputStream.write(bytes6);

                big_acc.add(acc_1);
                small_acc.add(acc_2);
            }
        }

        //计算最终的准确率
        double big_acc_finnal = 0.0;
        for (Double acc_ : big_acc) {
            big_acc_finnal += acc_;
        }
        big_acc_finnal = big_acc_finnal / big_acc.size();
        System.out.println(big_acc_finnal);
        fileOutputStream.write(("\n全局大分类准确率：" + big_acc_finnal).getBytes(StandardCharsets.UTF_8));

        double small_acc_finnal = 0.0;
        for (Double acc_ : small_acc) {
            small_acc_finnal += acc_;
        }
        small_acc_finnal = small_acc_finnal / big_acc.size();
        System.out.println(small_acc_finnal);
        fileOutputStream.write(("\t全局小分类准确率：" + small_acc_finnal).getBytes(StandardCharsets.UTF_8));

        fileOutputStream.close();
        ClassifyUtils.close_all();

}

    //单张预测
    @Test
    public void test_predict() throws IOException, OrtException {
        String[] predict = ClassifyUtils.predict(pic_path);
        System.out.println(predict[0]+"-"+predict[1]);
    }
}
