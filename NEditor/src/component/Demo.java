package component;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Demo extends Frame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Demo frm = new Demo();
	// 创建一个菜单栏
	static MenuBar menubar = new MenuBar();
	// 创建一个下拉式菜单组件——"文件"
	static Menu menu1 = new Menu("文件");
	// 创建一个下拉式菜单组件——"关于"
	static Menu menu2 = new Menu("关于");
	// 创建一个菜单的所有项——"打开"
	static MenuItem item1 = new MenuItem("打开");
	// 创建一个菜单的所有项——"保存"
	static MenuItem item2 = new MenuItem("保存");
	// 创建一个菜单的所有项——"关于我们"
	static MenuItem item3 = new MenuItem("关于我们");

	// FileDialog 类显示一个对话框窗口，用户可以从中选择文件。
	static FileDialog dia1 = new FileDialog(frm, "打开");
	// FileDialog.SAVE此常量值指示文件对话框窗口的作用是查找要写入的文件。
	static FileDialog dia2 = new FileDialog(frm, "保存", FileDialog.SAVE);
	// 创建一个文本区
	static TextArea txa = new TextArea();
	// 创建一个窗口事件对象
	static WinLis wlis = new WinLis();

	public static void main(String agrs[]) {
		// 设置Frame的title
		frm.setTitle("小记事本@索晋炜09级4班");

		/* 将下拉式菜单menu1、menu2添加到菜单栏中 */
		menubar.add(menu1);
		menubar.add(menu2);

		/* 将菜单item1、item2添加到下拉式菜单menu1中，将菜单item3添加到下拉式菜单menu2中 */
		menu1.add(item1);
		menu1.add(item2);
		menu2.add(item3);

		/* 为item1、item2、item3添加指定的动作侦听器，以从此菜单项接收动作事件 */
		item1.addActionListener(frm);
		item2.addActionListener(frm);
		item3.addActionListener(frm);

		// 将文本去txa添加到Frame中
		frm.add(txa);
		// 将此窗体的菜单栏设置为指定的menubar菜单栏。
		frm.setMenuBar(menubar);
		// 调整Frame组件的大小宽800高650
		frm.setSize(800, 650);
		// 显示组件
		frm.setVisible(true);
		/* 为组件添加窗口事件 */
		frm.addWindowListener(wlis);
		frm.addWindowListener(wlis);
	}

	/* 窗口事件的实现，在关闭窗口的同时关闭运行程序 */
	static class WinLis extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			frm.dispose();
		}

	}

	public void actionPerformed(ActionEvent e) {
		// 获取当前点击的菜单对象，getSource()返回最初发生 Event 的对象。
		MenuItem item = (MenuItem) e.getSource();
		if (item == item1) {
			dia1.setVisible(true);
			/* getDirectory()获取dia1对话框的目录，getFile()获取dia1对话框的选定文件 */
			String fname = dia1.getDirectory() + dia1.getFile();
			try {
				// 创建一个文件输入字节流
				FileInputStream fi = new FileInputStream(fname);
				/* fi.available()返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数 */
				byte ba[] = new byte[fi.available()];
				// 从此输入流中将最多ba.length个字节的数据读入到一个byte数组中
				fi.read(ba);
				// 将值赋到文本区中(new String(ba)将字符转换成字符串).
				txa.setText(new String(ba));
				// 关闭输入流
				fi.close();
			} catch (IOException ioe) {
			}
			;
		}
		if (item == item2) {
			dia2.setVisible(true);
			// getDirectory()获取dia2对话框的目录
			String fname2 = dia2.getDirectory();
			// dia2.getFile()获得dia2对话框中的选定文件，并为其拼接上后缀.txt
			File file = new File(dia2.getFile() + ".txt");
			// 获得文本区中的内容
			String s = txa.getText();

			try {
				// 创建一个文本写入字符输出流，FIleWriter用来写入字符文件的便捷类
				BufferedWriter out = new BufferedWriter(new FileWriter(fname2
						+ file));
				// 写入
				out.write(s);
				// 关闭流
				out.close();

			} catch (Exception ioe) {
				ioe.printStackTrace();
			}

		}
	}

}

// 关于选项帮你添上了（事件监听也加上了），具体要实现什么功能，自己看着加吧！
