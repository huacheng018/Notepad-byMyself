import javax.swing.*;
import java.awt.*;

public class jMenuBar extends JMenuItemActionListener{

    /**
     * 菜单1--文件
     */
    JMenu file = new JMenu("文件");
    //子选项1--新建
    JMenuItem newFile = new JMenuItem("新建");
    //子选项2--打开
    JMenuItem open = new JMenuItem("打开");
    //子选项3--保存
    JMenuItem save = new JMenuItem("保存");
    //子选项4--另存为
    JMenuItem saveAs = new JMenuItem("另存为");
    //子选项5--退出
    JMenuItem exit = new JMenuItem("退出");

    public void addFileItem(){//添加自选项的函数
        //子选项1New扔进菜单file
        file.add(newFile);
        //子选项2open扔进菜单file
        file.add(open);
        //子选项3save扔进菜单file
        file.add(save);
        //子选项4svaeAs扔进菜单file
        file.add(saveAs);
        //加入分割线
        file.addSeparator();
        //子选项5exit扔进菜单file
        file.add(exit);
    }

    /**
     * 菜单2--编辑
     */
    JMenu edit = new JMenu("编辑");
    //撤销
    //JMenuItem undo = new JMenuItem("撤销");

    //子选项1--复制
    JMenuItem copy = new JMenuItem("复制");
    //子选项2--黏贴
    JMenuItem paste = new JMenuItem("黏贴");
    //子选项3--删除
    JMenuItem delete = new JMenuItem("删除");
    //子选项4--剪切
    JMenuItem cut = new JMenuItem("剪切");
    //子选项5--查找
    JMenuItem search = new JMenuItem("查找");
    //子选项6--替换
    JMenuItem replace = new JMenuItem("替换");
    //子选项7--日期
    JMenuItem data = new JMenuItem("日期");

    public void addeditItem(){//添加自选项的函数
        //子选项0undo扔进菜单2edit
        //edit.add(undo);

        //子选项1copy扔进菜单2edit
        edit.add(copy);
        //子选项2paste扔进菜单2deit
        edit.add(paste);
        //子选项3copy扔进菜单2edit
        edit.add(delete);
        //子选项4cut扔进菜单2edit
        edit.add(cut);
        //子选项5search扔进菜单2edit
        edit.add(search);
        //子选项6replace扔进菜单2edit
        edit.add(replace);
        //子选项7data扔进菜单2edit
        edit.add(data);
    }

    /**
     * 菜单3--格式
     */
    JMenu format = new JMenu("格式");
    //子选项1--自动换行
    JCheckBoxMenuItem autoSetLineWrap = new JCheckBoxMenuItem("自动换行");
    public void addFormatItem(){//添加自选项的函数
        //子选项1扔进菜单1
        format.add(autoSetLineWrap);
    }

    public void addListener(){
        JMenu[] menu = new JMenu[3];
        menu[0] = this.file;
        menu[1] = this.edit;
        for (int j=0;j<2;j++){
            for (Component component:menu[j].getMenuComponents()) {
                if (component instanceof JMenuItem){
                    ((JMenuItem) component).addActionListener(this);
                }
            }
        }
        //JCheckBoxMenuItem类型不同，单独加一下，不然不能用
        autoSetLineWrap.addActionListener(this);
    }
}
