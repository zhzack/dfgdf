package java交通灯;
import java.awt.event.*;
import javax.swing.*;
public class Menu {
//	public static void main(String[] args) {
//		MenuComboBoxFrame mc = new MenuComboBoxFrame();
//		mc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mc.setVisible(true);
//		mc.setTitle("MenuComboBoxFrame");
//	}

}

class MenuComboBoxFrame extends JFrame {
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;//弹出式菜单
/**内部类*/
	class TestAction extends AbstractAction {
		public TestAction(String name) {
			super(name);
		}

		public void actionPerformed(ActionEvent event) {
			System.out.println(getValue(Action.NAME) + " selected.");
		}
	}//内部类
	public MenuComboBoxFrame() {
		setSize(400, 300);//设置窗体大小
		JMenu fileMenu = new JMenu("File");//设置文件菜单
		fileMenu.add(new TestAction("New"));
//demonstrate(示范) accelerators
		JMenuItem openItem = fileMenu.add(new TestAction("Open"));
//调用将加速器ctrl+O关联到OpenItem菜单项,o一定要大写
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrlO"));
//添加分割符
		fileMenu.addSeparator();
		saveAction = new TestAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrlS"));
		saveAsAction = new TestAction("Save As");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();
// new AbstractAction("Exit")用指定描述字符串和默认图标定义一个 Action对象。

		fileMenu.add(new AbstractAction("Exit") {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
//demonstrate check box and radio button menus
		readonlyItem = new JCheckBoxMenuItem("Read_Only");
		readonlyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boolean saveOk = !readonlyItem.isSelected();
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);
			}
		});
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overItem = new JRadioButtonMenuItem("OverType");
		group.add(insertItem);
		group.add(overItem);
//demonstrate icons(显示图标)
		Action cutAction = new TestAction("Cut");
		Action copyAction = new TestAction("Copy");
		Action pasteAction = new TestAction("Paste");
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
//demonstrate nested menus(显示嵌套菜单)
		JMenu optionMenu = new JMenu("Options");
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overItem);
		editMenu.addSeparator();
		editMenu.add(optionMenu);
//demonstrate mnemonics(演示法)
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		JMenuItem indexItem = new JMenuItem("Index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
//you can also add the mnemonic key to an action
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);
//创建一个菜单栏
		JMenuBar menuBar = new JMenuBar();
//将菜单栏添加到框架中
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

//demonstrate pop-ups
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);
		add(panel);
//the following line is a workaround for bug
//4966109（下面是一个错误4966109解决方法）
		panel.addMouseListener(new MouseAdapter() {
		});
	}
}
