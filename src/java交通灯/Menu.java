package java��ͨ��;
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
	private JPopupMenu popup;//����ʽ�˵�
/**�ڲ���*/
	class TestAction extends AbstractAction {
		public TestAction(String name) {
			super(name);
		}

		public void actionPerformed(ActionEvent event) {
			System.out.println(getValue(Action.NAME) + " selected.");
		}
	}//�ڲ���
	public MenuComboBoxFrame() {
		setSize(400, 300);//���ô����С
		JMenu fileMenu = new JMenu("File");//�����ļ��˵�
		fileMenu.add(new TestAction("New"));
//demonstrate(ʾ��) accelerators
		JMenuItem openItem = fileMenu.add(new TestAction("Open"));
//���ý�������ctrl+O������OpenItem�˵���,oһ��Ҫ��д
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrlO"));
//��ӷָ��
		fileMenu.addSeparator();
		saveAction = new TestAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrlS"));
		saveAsAction = new TestAction("Save As");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();
// new AbstractAction("Exit")��ָ�������ַ�����Ĭ��ͼ�궨��һ�� Action����

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
//demonstrate icons(��ʾͼ��)
		Action cutAction = new TestAction("Cut");
		Action copyAction = new TestAction("Copy");
		Action pasteAction = new TestAction("Paste");
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
//demonstrate nested menus(��ʾǶ�ײ˵�)
		JMenu optionMenu = new JMenu("Options");
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overItem);
		editMenu.addSeparator();
		editMenu.add(optionMenu);
//demonstrate mnemonics(��ʾ��)
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		JMenuItem indexItem = new JMenuItem("Index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
//you can also add the mnemonic key to an action
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);
//����һ���˵���
		JMenuBar menuBar = new JMenuBar();
//���˵�����ӵ������
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
//4966109��������һ������4966109���������
		panel.addMouseListener(new MouseAdapter() {
		});
	}
}
