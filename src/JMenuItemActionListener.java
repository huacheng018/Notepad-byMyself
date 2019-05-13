import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuItemActionListener extends FileService implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem currentItem = (JMenuItem) e.getSource();
        switch (currentItem.getText()){
            //菜单1功能
            case "新建":
                newFile();
                break;
            case "打开":
                open();
                break;
            case "保存":
                save();
                break;
            case "另存为":
                saveAs();
                break;
            case "退出":
                exit();
                break;
            //菜单2功能
            /*case "撤销":
                setUndoManager();
                break;*/
            case "复制":
                copy();
                break;
            case "黏贴":
                paste();
                break;
            case "删除":
                delete();
                break;
            case "剪切":
                cut();
                break;
            case "查找":
                search();
                break;
            case "替换":
                replace();
                break;
            case "日期":
                data();
                break;
            //菜单3功能
            case "自动换行":
                autoSetLineWrap();
                break;
            default:
        }
    }
}
