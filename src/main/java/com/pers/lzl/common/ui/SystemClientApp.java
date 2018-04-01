package com.pers.lzl.common.ui;

import com.lzl.resources.Resources;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class SystemClientApp extends JFrame {
    private static final long serialVersionUID = 5123533115508442592L;
    private static Logger logger = Logger.getLogger(SystemClientApp.class);
    private JPanel jPanelUp;
    public  JPanel centerJPanel;
    public  JPanel jPanelMiddle;
    private CardLayout cardLayout;
    private JPanel catalogPanel = new CatalogPanel();  //中间面板
    private JPanel jPanelDown;
    private JMenuBar jMenuBar;                         //创建菜单栏
    private JComboBox jComboBox;                        //条件选择框
    private JButton confirmBtn;                        //确定
    private JButton cleanBtn;                            //清空
    private JButton copyBtn;                            //复制
    private static ImageIcon imageIcon;
    public static JLabel imageJLabel;
    public static JLabel txtJLabel;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                SystemClientApp inst = new SystemClientApp();
                inst.setIconImage(Resources.getPasswordIcon().getImage());
                inst.setLocationRelativeTo(null);//设置窗口位于正中央
                inst.setVisible(true);//设置可见

            }
        });
    }

    public SystemClientApp() {
        initGUI();
        listener();
    }

    /**
     * 设置按钮监听事件
     */
    private void listener() {
        ButtonListener btnListener = new ButtonListener();
        confirmBtn.addActionListener(btnListener);
        cleanBtn.addActionListener(btnListener);
    }
    /**
     * 初始化控件函数
     */
    public void initGUI() {
        try {
            centerJPanel =  (JPanel) getContentPane();
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("实用工具类 by zhiliang.liu");
            getContentPane().setLayout(null);
            setPreferredSize(new Dimension(1000,630));
            setResizable(false);//禁止窗口拉伸
            {
                jPanelUp = new JPanel();
                FlowLayout flowLayout = new FlowLayout();
                getContentPane().add(jPanelUp);
                jPanelUp.setBounds(0,0,984,49);
                jPanelUp.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
                jPanelUp.setBackground(new Color(255, 255, 128));
                jPanelUp.setLayout(flowLayout);
                jPanelUp.setSize(1000, 49);
                {
                    confirmBtn = new JButton();
                    jPanelUp.add(confirmBtn);
                    confirmBtn.setText("确定");
                    confirmBtn.setIcon(Resources.getPasswordIcon());
                    confirmBtn.setBackground(new Color(255,128,64));
                    confirmBtn.setFocusPainted(false);
                    confirmBtn.setSize(120, 36);
                }
                {
                    cleanBtn = new JButton();
                    jPanelUp.add(cleanBtn);
                    cleanBtn.setText("清除");
                    cleanBtn.setIcon(Resources.getPasswordIcon());
                    cleanBtn.setBackground(new Color(255, 255, 255));
                    cleanBtn.setFocusPainted(false);
                    cleanBtn.setSize(120, 36);
                }
                {
                    copyBtn = new JButton();
                    jPanelUp.add(copyBtn);
                    copyBtn.setText("复制");
                    copyBtn.setIcon(Resources.getPasswordIcon());
                    copyBtn.setBackground(new Color(255, 255, 255));
                    copyBtn.setFocusPainted(false);
                    copyBtn.setSize(120, 36);
                }
            }
            {
                jPanelMiddle = new JPanel();
                cardLayout = new CardLayout();
                jPanelMiddle.setLayout(cardLayout);
                jPanelMiddle.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
                jPanelMiddle.add("catalogPanel",catalogPanel);
                cardLayout.show(jPanelMiddle, "catalogPanel");
                getContentPane().add(jPanelMiddle);
                jPanelMiddle.setBounds(0, 41, 997, 507);
            }
            {
                jPanelDown = new JPanel();
                jPanelDown.setLayout(new FlowLayout(FlowLayout.LEFT));
                jPanelDown.setBounds(0,547,994,35);
                jPanelDown.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
                jPanelDown.setSize(994, 35);
                imageJLabel = new JLabel();
                txtJLabel = new JLabel("暌违已久,如果可以,我们重新认识一次吧！",SwingConstants.LEFT);
                txtJLabel.setSize(925, 29);
                imageIcon = new ImageIcon(Resources.getPasswordIcon().getImage());
                imageJLabel.setSize(72, 29);
                imageJLabel.setIcon(imageIcon);
                jPanelDown.add(imageJLabel);
                jPanelDown.add(txtJLabel);
                getContentPane().add(jPanelDown);
            }
            {
                jMenuBar = new JMenuBar();
                this.setJMenuBar(jMenuBar);
                JMenu fileMenu = new JMenu();
                fileMenu.setText("文件(F)");
                fileMenu.setMnemonic(KeyEvent.VK_F);
                MenuActionListener menuActionListener = new MenuActionListener();
                JMenuItem exitItem = new JMenuItem("退出(X)",KeyEvent.VK_X);
                exitItem.addActionListener(menuActionListener);
                exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
                fileMenu.addSeparator();
                fileMenu.add(exitItem);
                jMenuBar.add(fileMenu);

                JMenu setMenu = new JMenu();
                setMenu.setText("设置");
                JMenuItem picPathItem = new JMenuItem();
                picPathItem.setText("根目录设置");
                picPathItem.addActionListener(menuActionListener);
                setMenu.add(picPathItem);
                jMenuBar.add(setMenu);

                JMenu infoJMenu = new JMenu();
                infoJMenu.setText("信息");
                JMenuItem helpItem = new JMenuItem();
                helpItem.setText("帮助");
                helpItem.addActionListener(menuActionListener);
                infoJMenu.add(helpItem);
                infoJMenu.addSeparator();
                JMenuItem aboutItem = new JMenuItem();
                aboutItem.addActionListener(menuActionListener);
                aboutItem.setText("关于");
                infoJMenu.add(aboutItem);
                jMenuBar.add(infoJMenu);
            }
            pack();
            setSize(1000, 630);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if ("确定".equals(cmd)) {
                JOptionPane.showMessageDialog(null, "确定");
            } else if ("清除".equals(cmd)) {
                JOptionPane.showMessageDialog(null, "清除");
            } else if ("复制".equals(cmd)) {
                JOptionPane.showMessageDialog(null, "复制");
            }
        }

    }
    class MenuActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if ("退出(X)".equals(cmd)) {
                int n = JOptionPane.showConfirmDialog(null, "即将退出该系统?", "标题",JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    System.exit(NORMAL);
                }
            }
        }

    }
}
