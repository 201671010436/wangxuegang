package a.b.c.d;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class WordCount {
    public static void main(String[] args) throws FileNotFoundException,IOException{

        try{
            //读取文件
            BufferedReader br = new BufferedReader(new FileReader(
                    "E:\\word.txt"));
            //将读取内容按Integer列
            TreeMap<String,Integer> treemap = new TreeMap<String,Integer>();
            //存储英语单词
            String readLine = null;
            //记录单词个数
            int count = 0;
            while((readLine = br.readLine())!=null){
                readLine = readLine.toLowerCase();
                //readLine  = readLine.toUpperCase();
                String[] str = readLine.split("[\\s]");
                for(int i = 0;i<str.length;i++){
                    count++;
                    String word = str[i].trim();
                    if(treemap.containsKey(word)){
                        treemap.put(word, treemap.get(word)+1);
                    }else{
                        treemap.put(word, 1);
                    }
                }
            }

            System.out.println("按字典的输出顺序为:");
            System.out.println("单词："+"\t"+"单词出现的频率：" );
            Iterator<Map.Entry<String,Integer>> it  = treemap.entrySet().iterator();
            //判断是否存在下一个单词
            while(it.hasNext()){
                Map.Entry<String, Integer> entry = it.next();//获取map中每一个键值
                //输出结果
                System.out.println(entry.getKey()+"        "+entry.getValue());
                br.close();//关闭流
            }
            System.out.println("单词总数为："+count+"个");

        }catch(FileNotFoundException e){//异常处理
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}