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
            //��ȡ�ļ�
            BufferedReader br = new BufferedReader(new FileReader(
                    "E:\\word.txt"));
            //����ȡ���ݰ�Integer��
            TreeMap<String,Integer> treemap = new TreeMap<String,Integer>();
            //�洢Ӣ�ﵥ��
            String readLine = null;
            //��¼���ʸ���
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

            System.out.println("���ֵ�����˳��Ϊ:");
            System.out.println("���ʣ�"+"\t"+"���ʳ��ֵ�Ƶ�ʣ�" );
            Iterator<Map.Entry<String,Integer>> it  = treemap.entrySet().iterator();
            //�ж��Ƿ������һ������
            while(it.hasNext()){
                Map.Entry<String, Integer> entry = it.next();//��ȡmap��ÿһ����ֵ
                //������
                System.out.println(entry.getKey()+"        "+entry.getValue());
                br.close();//�ر���
            }
            System.out.println("��������Ϊ��"+count+"��");

        }catch(FileNotFoundException e){//�쳣����
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}