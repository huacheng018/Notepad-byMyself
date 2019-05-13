import javax.swing.*;

public class jFrame extends jMenuBar{
    //顶级容器
    JFrame jFrame = new JFrame("Just for test.");
    //菜单栏
    JMenuBar jMenuBar = new JMenuBar();

    /**
     * 各种设置数据
     */
    public void setAll(){
        setjFrame();
        addAll();
        //添加文本框进入面板
        jFrame.add(jTextArea);
        //设置监听者
        addListener();
        //设置文本区可编辑可用
        jTextArea.setEditable(true);
        jTextArea.setEnabled(true);
    }

    public void setjFrame() {//设置尺寸大小等杂七杂八
        //设置尺寸
        jFrame.setSize(800, 600);
        //起始位置居中
        jFrame.setLocationRelativeTo(null);
        //窗口不能调节大小
        //jFrame.setResizable(false);
        //关闭窗口,退出程序
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //窗口可见
        jFrame.setVisible(true);

    }

    public void addAll(){
        //添加菜单栏进入面板
        jFrame.setJMenuBar(jMenuBar);
        //往菜单栏扔菜单
        jMenuBar.add(file);
        jMenuBar.add(edit);
        jMenuBar.add(format);
        //各菜单扔进菜单栏
        addFileItem();
        addeditItem();
        addFormatItem();
    }
}
