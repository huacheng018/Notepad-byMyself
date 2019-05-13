import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;

public class FileService {

    UndoManager undoManager = new UndoManager();

    //文本框
    JTextArea jTextArea = new JTextArea("It is a text.");

    //定义一个文件选择框
    JFileChooser jFileChooser = null;
    //文件输入流
    FileReader fileReader = null;
    //文件输出流
    FileWriter fileWriter = null;
    //缓冲输入流
    BufferedReader bufferedReader = null;
    //缓冲输出流
    BufferedWriter bufferedWriter = null;

    //新建---（稍微暴力一下）
    void newFile() {
        jTextArea.setText("");
    }

    //打开
    void open(){
        //实例化对象
        jFileChooser = new JFileChooser();
        //设置弹出选择框标题
        jFileChooser.setDialogTitle("打开");
        //设置默认路径
        jFileChooser.showOpenDialog(null);
        //弹出窗口
        jFileChooser.setVisible(true);
        //检查文件选择框返回地址
        File check = jFileChooser.getSelectedFile();
        if(check==null){
            return;
        }
        //用address保存用户编辑文件的绝对路径
        String address = jFileChooser.getSelectedFile().getAbsolutePath();
        /*
        //Stringbuilder存储
        StringBuilder temp = new StringBuilder();
        try {
           //实例化文件输入流
           fileReader = new FileReader(address);
           //实例化缓冲字符输入流
           bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(address),"GBK"));
           String line= null;
           while ((line= bufferedReader.readLine()) != null) {
               temp.append(line);
               System.out.println(temp);
           }
           jf.jTextArea.setText(String.valueOf(temp.toString()));
           bufferedReader.close();
           fileReader.close();
       } catch (FileNotFoundException e1) {
           e1.printStackTrace();
       } catch (IOException e1) {
           e1.printStackTrace();
       }*/
        //字符串能存换行符，上边的StringBuilder亲测不能，所以就用这个先
        try {
            //实例化文件输入流
            fileReader = new FileReader(address);
            //实例化缓冲字符输入流
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(address),"UTF-8"));
            //设置字符串为空
            String str = "";
            //定义一个strall存储文件全部信息
            String strAll="";
            //缓冲区拿数据
            while((str = bufferedReader.readLine()) != null) {
                strAll += str + "\r\n";
            }
            System.out.println(strAll);
            jTextArea.setText(strAll);//一次性硬塞
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            //关闭流文件,不关会占用系统内存
            try {
                bufferedReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                fileReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    //保存
    void save(){
        //实例化对象
        jFileChooser = new JFileChooser();
        //设置弹出选择框标题
        jFileChooser.setDialogTitle("保存");
        //设置默认路径
        jFileChooser.showSaveDialog(null);
        //弹出窗口
        jFileChooser.setVisible(true);
        //检查文件选择框返回地址
        File check = jFileChooser.getSelectedFile();
        if(check==null){
            return;
        }
        //用address保存用户编辑文件的绝对路径
        String address = jFileChooser.getSelectedFile().getAbsolutePath();
        if(address==null){
            return;
        }
        System.out.println(address);
        try {
            //实例化文件输出流写出文件
            fileWriter = new FileWriter(address);
            //实例化缓冲字符输出流
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(address),"GBK"));
            //获取记事本字符串写出
            System.out.println(jTextArea.getText());
            fileWriter.write(jTextArea.getText());
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            //关闭流文件,不关会占用系统内存
            try {
                bufferedWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    //另存为
    void saveAs(){
        //实例化对象
        jFileChooser = new JFileChooser();
        //设置弹出选择框标题
        jFileChooser.setDialogTitle("保存");
        //设置默认路径
        jFileChooser.showSaveDialog(null);
        //弹出窗口
        jFileChooser.setVisible(true);
        //检查文件选择框返回地址
        File check = jFileChooser.getSelectedFile();
        if(check==null){
            return;
        }
        //用address保存用户编辑文件的绝对路径
        String address = jFileChooser.getSelectedFile().getAbsolutePath();
        System.out.println(address);
        if(address==null){
            return;
        }
        System.out.println(address);
        try {
            //实例化文件输出流写出文件
            fileWriter = new FileWriter(address);
            //实例化缓冲字符输出流
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(address),"GBK"));
            //获取记事本字符串写出
            System.out.println(jTextArea.getText());
            fileWriter.write(jTextArea.getText());
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            //关闭流文件,不关会占用系统内存
            try {
                bufferedWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    //退出
    void exit(){
        System.exit(0);
    }

    //撤销
    /*void setUndoManager(){
        if (undoManager.canUndo()){
            undoManager.undo();
        }
    }*/

    //复制
    void copy(){
        jTextArea.copy();
    }

    //黏贴
    void paste(){
        jTextArea.paste();
    }

    //删除
    void delete(){
        jTextArea.replaceRange("",jTextArea.getSelectionStart(),jTextArea.getSelectionEnd());
    }

    //剪切
    void cut(){
        jTextArea.cut();
    }

    /**
     * 查找
     */
    JFrame jInternalFrame;
    JPanel panel;
    //查找文本域
    JTextField jTextField = new JTextField(8);

    //标签--方向
    JLabel direction = new JLabel("方向");
    //单选按钮--向上
    JRadioButton toUp = new JRadioButton("向上");
    //单选按钮--向下
    JRadioButton toDown = new JRadioButton("向下");
    //设置按钮组
    ButtonGroup buttonGroup = new ButtonGroup();

    //区分大小写指针，1区分，0不区分
    int cs = 0;
    void search(){
        //内部框
        jInternalFrame = new JFrame();
        //创建面板
        panel = new JPanel(null);
        //标签--查找内容
        JLabel jLabel = new JLabel("查找内容：");

        //按钮1--查找下一个
        JButton searchNext = new JButton("查找下一个");
        //按钮2--取消
        JButton cancel = new JButton("取消");
        //复选框--区分大小写
        JCheckBox caseSensitive = new JCheckBox("区分大小写");

        //默认选中向下
        toDown.setSelected(true);

        //窗口基本设置
        jInternalFrame.setSize(500,300);
        jInternalFrame.setLocation(700,300);
        jInternalFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //设置标签参数
        jLabel.setSize(100,50);
        jLabel.setLocation(30,10);
        jLabel.setFont(new Font(null, Font.PLAIN, 15));
        jLabel.setVisible(true);
        panel.add(jLabel);
        //方向标签
        direction.setSize(70,50);
        direction.setLocation(330,170);
        direction.setVisible(true);
        panel.add(direction);

        //设置文本域参数
        jTextField.setSize(250,30);
        jTextField.setLocation(120,20);
        jTextField.setEnabled(true);
        jTextField.setEditable(true);
        panel.add(jTextField);

        //设置两个功能按钮参数
        searchNext.setSize(100,30);
        searchNext.setLocation(80,100);
        cancel.setSize(100,30);
        cancel.setLocation(300,100);
        panel.add(searchNext);
        panel.add(cancel);

        //复选框参数
        caseSensitive.setSize(100,50);
        caseSensitive.setLocation(20,200);
        caseSensitive.setVisible(true);
        panel.add(caseSensitive);
        caseSensitive.setSelected(true);

        //添加按钮进按钮组
        buttonGroup.add(toUp);
        buttonGroup.add(toDown);
        //设置按钮参数
        toUp.setSize(70,50);
        toDown.setSize(70,50);
        toUp.setLocation(320,200);
        toDown.setLocation(400,200);
        panel.add(toUp);
        panel.add(toDown);

        //添加面板
        panel.setVisible(true);
        jInternalFrame.setContentPane(panel);
        jInternalFrame.setVisible(true);

        //添加监听者
        //查找下一个
        searchNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //见最下边的函数
                searchNextOne();
            }
        });
        //取消
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                end = 0;
                jInternalFrame.dispose();
            }
        });
        //区分大小写
        caseSensitive.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cs = 1;
            }
        });
        //向上
        toUp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            }
        });
        //向下
        toDown.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            }
        });
    }

    //替换
    void replace(){
        //内部框
        jInternalFrame = new JFrame();
        //创建面板
        panel = new JPanel(null);

        //窗口基本设置
        jInternalFrame.setSize(500,300);
        jInternalFrame.setLocation(700,300);
        jInternalFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //文本域--2，替换为
        JTextField jTextField2 = new JTextField(8);
        //标签--查找内容
        JLabel jLabel = new JLabel("查找内容：");
        //标签--替换为
        JLabel jLabel2 = new JLabel("替换为：");
        //按钮1--查找下一个
        JButton searchNext = new JButton("查找下一个");
        //按钮2--替换
        JButton replace = new JButton("替换");
        //按钮3--全部替换
        JButton replaceAll = new JButton("全部替换");
        //按钮4--取消
        JButton cancel = new JButton("取消");
        //复选框--区分大小写
        JCheckBox caseSensitive = new JCheckBox("区分大小写");

        //设置标签参数
        jLabel.setSize(100,50);
        jLabel.setLocation(30,10);
        jLabel.setFont(new Font(null, Font.PLAIN, 15));
        jLabel.setVisible(true);
        panel.add(jLabel);
        //设置标签参数
        jLabel2.setSize(100,50);
        jLabel2.setLocation(30,60);
        jLabel2.setFont(new Font(null, Font.PLAIN, 15));
        jLabel2.setVisible(true);
        panel.add(jLabel2);

        //设置文本域1参数
        jTextField.setSize(200,30);
        jTextField.setLocation(120,20);
        jTextField.setEnabled(true);
        jTextField.setEditable(true);
        panel.add(jTextField);
        //设置文本域2参数
        jTextField2.setSize(200,30);
        jTextField2.setLocation(120,70);
        jTextField2.setEnabled(true);
        jTextField2.setEditable(true);
        panel.add(jTextField2);

        //设置按钮参数
        searchNext.setSize(100,30);
        searchNext.setLocation(350,20);
        replace.setSize(100,30);
        replace.setLocation(350,70);
        replaceAll.setSize(100,30);
        replaceAll.setLocation(350,120);
        cancel.setSize(100,30);
        cancel.setLocation(350,170);
        panel.add(searchNext);
        panel.add(replace);
        panel.add(replaceAll);
        panel.add(cancel);

        //复选框参数
        caseSensitive.setSize(100,50);
        caseSensitive.setLocation(20,200);
        caseSensitive.setVisible(true);
        panel.add(caseSensitive);
        caseSensitive.setSelected(true);

        //添加面板
        panel.setVisible(true);
        jInternalFrame.setContentPane(panel);
        jInternalFrame.setVisible(true);

        //添加监听者
        //查找下一个
        searchNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchNextOne();
            }
        });
        //替换
        replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField.getText()==null){
                    JOptionPane.showConfirmDialog(null,"无替换内容");
                }
                else if (jTextField.getText().equals(jTextArea.getSelectedText())){
                    jTextArea.replaceRange(jTextField2.getText(), jTextArea.getSelectionStart(), jTextArea.getSelectionEnd());
                }
            }
        });
        //全部替换
        replaceAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = jTextField.getText();
                end = 0;//尾光标归0
                int x = jTextArea.getText().indexOf(temp, end);
                if (x==-1){//再按一次 全部替换 的弹出提示
                    JOptionPane.showConfirmDialog(null,"无替换内容");
                    return;
                }
                while(true){//方向向下
                    //索引
                    x = jTextArea.getText().indexOf(temp, end);
                    if (x==-1){
                        jTextArea.replaceRange(jTextField2.getText(),jTextArea.getSelectionStart(),jTextArea.getSelectionEnd());
                        break;
                    }else{
                        jTextArea.replaceRange(jTextField2.getText(),jTextArea.getSelectionStart(),jTextArea.getSelectionEnd());
                        end = x+temp.length();
                        jTextArea.setSelectionStart(x);
                        jTextArea.setSelectionEnd(x+temp.length());
                    }
                }
            }
        });
        //取消
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                end = 0;
                jInternalFrame.dispose();
            }
        });
        //区分大小写
        caseSensitive.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cs = 1;
            }
        });
    }

    //时间日期
    void data(){
        Date a = new Date();
        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        System.out.println(mediumDateFormat.format(a));
        jTextArea.replaceRange(mediumDateFormat.format(a),jTextArea.getSelectionStart(),jTextArea.getSelectionEnd());
    }

    //自动换行
    void autoSetLineWrap(){
        jTextArea.setLineWrap(true);
    }

    //查找函数
    int end = 0;// 尾光标
    void searchNextOne(){
        String temp = jTextField.getText();
        if (toDown.isSelected()){//方向向下
            if (end!=0){//卡位关键
                end=jTextArea.getSelectionEnd();
            }
            int x = jTextArea.getText().indexOf(temp, end);//indexof查找
            System.out.println(x+" 向下");//debug用
            if (x==-1){//没有则弹框
                JOptionPane.showConfirmDialog(null,"没找到 "+temp);
            }else{
                end = x+temp.length();
                jTextArea.setSelectionStart(x);
                jTextArea.setSelectionEnd(end);
            }
        }else if (toUp.isSelected()){//方向向上
            end=jTextArea.getSelectionEnd();
            int x = jTextArea.getText().lastIndexOf(temp,end-temp.length()-1);//indexof倒序查找
            System.out.println(x+" 向上");//debug用
            if(x==-1){//没有则弹框
                JOptionPane.showConfirmDialog(null,"没找到 "+temp);
            }else{
                end = x+temp.length();
                jTextArea.setSelectionStart(x);
                jTextArea.setSelectionEnd(end);
            }
        }
    }
}
