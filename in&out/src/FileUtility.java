import java.io.File;
class FileUtility
{
    public static void main (String args[])
    {
        System.out.println("·���ָ���:"+File.pathSeparator);
        System.out.println("�ļ��ָ���:"+File.separator);
        File userFile=new File("c:\\652\\a\\abc.txt");
        System.out.println("�ļ�����ȫ��:"+userFile);
        System.out.println("�ж��ļ��Ƿ����:"+userFile.exists());
        System.out.println("�ļ�����:"+userFile.getName());
        System.out.println("�ļ�����·��:"+userFile.getPath());
        System.out.println("�ļ����ڵľ���·��:"+userFile.getAbsolutePath());
        System.out.println("�ļ��ĸ�·��:"+userFile.getParent());
        System.out.println("�ж��ļ������Ƿ�����ͨ�ļ�:"+userFile.isFile());
        System.out.println("�ж��ļ������Ƿ���Ŀ¼:"+userFile.isDirectory());
        System.out.println("�ļ����ֽ���:"+userFile.length());
        System.out.println("�ļ��Ƿ��ܶ�:"+userFile.canRead());
        System.out.println("�ļ��Ƿ��д:"+userFile.canWrite());
        System.out.println("�ļ�����޸�ʱ��:"+userFile.lastModified());
    }

}