import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class MyZip {
    private static void zip(File zipFile,File sourceFile) throws Exception{
        ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipFile));
        process(out,sourceFile,"");
        out.close();
    }
    /**
     * 递归形式写入zip文件
     * @param zipOutputStream zip输出流
     * @param sourceFile 源文件
     * @param base 父级路径
     * @throws Exception
     */
    private static void process(ZipOutputStream zipOutputStream,File sourceFile,String base) throws Exception{
        if(sourceFile.isDirectory()){
            File[] fl=sourceFile.listFiles();
            zipOutputStream.putNextEntry(new ZipEntry(base+sourceFile.getName()+"/"));
            base=base+sourceFile.getName()+"/";
            for(int i=0;i<fl.length;++i){
                process(zipOutputStream,fl[i],base);
            }
        }else{
            zipOutputStream.putNextEntry(new ZipEntry(base+sourceFile.getName()));
            FileInputStream in=new FileInputStream(sourceFile);
            zipOutputStream.setComment("www.mldnjava.cn");
            int b;
            while((b=in.read())!=-1){
                zipOutputStream.write(b);
            }
            in.close();
        }
    }
    public static void main(String[] args) throws Exception {
        MyZip.zip(new File("e:" +File.separator + "HelloJava.zip"),new File( "e:" + File.separator + "HelloJava.java"));
    }
} 