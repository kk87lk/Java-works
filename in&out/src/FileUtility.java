import java.io.File;
class FileUtility
{
    public static void main (String args[])
    {
        System.out.println("路径分隔符:"+File.pathSeparator);
        System.out.println("文件分隔符:"+File.separator);
        File userFile=new File("c:\\652\\a\\abc.txt");
        System.out.println("文件对象全称:"+userFile);
        System.out.println("判断文件是否存在:"+userFile.exists());
        System.out.println("文件名称:"+userFile.getName());
        System.out.println("文件所在路径:"+userFile.getPath());
        System.out.println("文件所在的绝对路径:"+userFile.getAbsolutePath());
        System.out.println("文件的父路径:"+userFile.getParent());
        System.out.println("判断文件对象是否是普通文件:"+userFile.isFile());
        System.out.println("判断文件对象是否是目录:"+userFile.isDirectory());
        System.out.println("文件的字节数:"+userFile.length());
        System.out.println("文件是否能读:"+userFile.canRead());
        System.out.println("文件是否可写:"+userFile.canWrite());
        System.out.println("文件最后修改时间:"+userFile.lastModified());
    }

}