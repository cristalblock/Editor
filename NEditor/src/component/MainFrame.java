package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.datatransfer.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.border.Border;
import javax.swing.undo.UndoManager;

import java.awt.event.KeyAdapter;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	JFrame frmNeditor;
	private JTextArea jta;
	private JPanel panel;
	private NumberPanel np;
	private MyMenuItem menuItem_2, menuItem_3, mntmNewMenuItem, menuItem_5,
			menuItem_6, radioButtonMenuItem, menuItem_7, menuItem_8,
			menuItem_9, cut_, copy_, paste_, delete_, select_all_;
	private JMenu mnNewMenu;
	JLabel lblNewLabel_2, lblNewLabel_3, lblNewLabel_4;
	boolean edited = false;
	private UndoManager um;
	static int lines = 1;
	String filepath;
	static MainFrame window;
	MyPopupMenu pop = new MyPopupMenu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainFrame();
					window.frmNeditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		cut_ = new MyMenuItem("剪切     ");
		cut_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));
		cut_.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					cut();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		copy_ = new MyMenuItem("复制     ");
		copy_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));
		copy_.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					copy();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		paste_ = new MyMenuItem("粘贴     ");
		paste_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));
		paste_.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1)
					paste();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		delete_ = new MyMenuItem("删除     ");
		delete_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		delete_.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1)
					delete();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		select_all_ = new MyMenuItem("全选     ");
		select_all_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		select_all_.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1)
					select_all();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		cut_.setEnabled(false);
		copy_.setEnabled(false);
		paste_.setEnabled(false);
		delete_.setEnabled(false);
		select_all_.setEnabled(true);
		pop.add(cut_);
		pop.add(copy_);
		pop.add(paste_);
		pop.add(delete_);
		pop.add(select_all_);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNeditor = new JFrame();
		frmNeditor.setTitle("NEditor");
		frmNeditor.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		frmNeditor.setBounds(100, 100, 635, 500);
		frmNeditor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmNeditor.getContentPane().setLayout(null);
		frmNeditor.setResizable(false);
		frmNeditor.setLocationRelativeTo(null);
		frmNeditor.setIconImage(new ImageIcon(MainFrame.class
				.getResource("/img/notepad.png")).getImage());
		frmNeditor.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				if (!edited)
					System.exit(0);
				else {
					new MyDialog3(frmNeditor, "Save");
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

		});

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 629, 29);
		frmNeditor.getContentPane().add(menuBar);

		mnNewMenu = new MyMenu("\u6587\u4EF6(F)");
		mnNewMenu.setMnemonic('F');
		menuBar.add(mnNewMenu);

		JMenuItem menuItem = new MyMenuItem("\u65B0\u5EFA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		});
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnNewMenu.add(menuItem);

		JMenuItem menuItem_1 = new MyMenuItem("\u6253\u5F00");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		menuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		mnNewMenu.add(menuItem_1);

		menuItem_2 = new MyMenuItem("\u4FDD\u5B58");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		menuItem_2.setEnabled(false);
		menuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mnNewMenu.add(menuItem_2);

		menuItem_3 = new MyMenuItem("\u53E6\u5B58\u4E3A");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToAnotherPath();
			}
		});
		menuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnNewMenu.add(menuItem_3);

		JMenuItem menuItem_4 = new MyMenuItem("\u9000\u51FA");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!edited)
					System.exit(0);
				else {
					new MyDialog3(frmNeditor, "Save");
				}
			}
		});
		mnNewMenu.add(menuItem_4);

		JMenu mnNewMenu_1 = new MyMenu("\u7F16\u8F91(E)");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (jta.getSelectedText() != null
						&& !jta.getSelectedText().equals("")) {
					menuItem_6.setEnabled(true);
					menuItem_8.setEnabled(true);
					radioButtonMenuItem.setEnabled(true);
				} else {
					menuItem_6.setEnabled(false);
					menuItem_8.setEnabled(false);
					radioButtonMenuItem.setEnabled(false);
				}
				Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
				Transferable t = cb.getContents(null);
				if (t != null) {
					if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
						menuItem_7.setEnabled(true);
					} else {
						menuItem_7.setEnabled(false);
					}
				} else {
					menuItem_7.setEnabled(false);
				}
			}
		});
		mnNewMenu_1.setMnemonic('E');
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem = new MyMenuItem("\u64A4\u9500");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (um.canUndo()) {
					um.undo();
				}

				if (um.canUndo()) {
					mntmNewMenuItem.setEnabled(true);
					lblNewLabel_3.setEnabled(true);
				} else {
					mntmNewMenuItem.setEnabled(false);
					lblNewLabel_3.setEnabled(false);
				}
				if (um.canRedo()) {
					menuItem_5.setEnabled(true);
					lblNewLabel_4.setEnabled(true);
				} else {
					menuItem_5.setEnabled(false);
					lblNewLabel_4.setEnabled(false);
				}
			}
		});
		mntmNewMenuItem.setEnabled(false);
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem);

		menuItem_5 = new MyMenuItem("\u6062\u590D");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (um.canRedo()) {
					um.redo();
				}

				if (um.canUndo()) {
					mntmNewMenuItem.setEnabled(true);
					lblNewLabel_3.setEnabled(true);
				} else {
					mntmNewMenuItem.setEnabled(false);
					lblNewLabel_3.setEnabled(false);
				}
				if (um.canRedo()) {
					menuItem_5.setEnabled(true);
					lblNewLabel_4.setEnabled(true);
				} else {
					menuItem_5.setEnabled(false);
					lblNewLabel_4.setEnabled(false);
				}
			}
		});
		menuItem_5.setEnabled(false);
		menuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
				InputEvent.CTRL_MASK));
		mnNewMenu_1.add(menuItem_5);

		menuItem_6 = new MyMenuItem("\u526A\u5207");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cut();
			}
		});
		menuItem_6.setEnabled(false);
		menuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));
		mnNewMenu_1.add(menuItem_6);

		radioButtonMenuItem = new MyMenuItem("\u590D\u5236");
		radioButtonMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy();
			}
		});
		radioButtonMenuItem.setEnabled(false);
		radioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(radioButtonMenuItem);

		menuItem_7 = new MyMenuItem("\u7C98\u8D34");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paste();
			}
		});
		menuItem_7.setEnabled(false);
		menuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));
		mnNewMenu_1.add(menuItem_7);

		menuItem_8 = new MyMenuItem("\u5220\u9664");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		menuItem_8.setEnabled(false);
		menuItem_8
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		mnNewMenu_1.add(menuItem_8);

		menuItem_9 = new MyMenuItem("\u5168\u9009");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_all();
			}
		});
		menuItem_9.setEnabled(true);
		menuItem_9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		mnNewMenu_1.add(menuItem_9);

		JMenu mns = new MyMenu("\u641C\u7D22(S)");
		mns.setText("\u5173\u4E8E(H)");
		mns.setMnemonic('H');
		menuBar.add(mns);

		JMenuItem mntmneditor = new MyMenuItem("\u5173\u4E8ENEditor");
		mntmneditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AuthorDialog(frmNeditor, "开发人员");
			}
		});
		mntmneditor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mns.add(mntmneditor);

		JMenu mnt = new MyMenu("\u8BBE\u7F6E(T)");
		mnt.setMnemonic('T');
		menuBar.add(mnt);

		JMenuItem menuItem_10 = new MyMenuItem("\u4E2A\u6027\u8BBE\u7F6E");
		mnt.add(menuItem_10);

		jta = new JTextArea();
		um = new UndoManager();
		jta.getDocument().addUndoableEditListener(um);
		jta.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (!e.isActionKey()) {
					int noprint[] = { KeyEvent.VK_HOME, KeyEvent.VK_END,
							KeyEvent.VK_PAGE_UP, KeyEvent.VK_PAGE_DOWN,
							KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,
							KeyEvent.VK_RIGHT, KeyEvent.VK_ESCAPE,
							KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT,
							KeyEvent.VK_CAPS_LOCK, KeyEvent.VK_NUM_LOCK,
							KeyEvent.VK_UNDEFINED, KeyEvent.VK_F1,
							KeyEvent.VK_F2, KeyEvent.VK_F3, KeyEvent.VK_F4,
							KeyEvent.VK_F5, KeyEvent.VK_F6, KeyEvent.VK_F7,
							KeyEvent.VK_F8, KeyEvent.VK_F9, KeyEvent.VK_F10,
							KeyEvent.VK_F11, KeyEvent.VK_F12,
							KeyEvent.VK_PAUSE, KeyEvent.VK_INSERT,
							KeyEvent.VK_DELETE, KeyEvent.VK_ALT };
					int code = e.getKeyCode();
					boolean result = false;
					for (int i = 0; i <= noprint.length - 1; i++) {
						if (code == noprint[i]) {
							result = true;
							break;
						}
					}
					if (!result) {
						edited = true;
						menuItem_2.setEnabled(true);
						lblNewLabel_2.setEnabled(true);

						if (KeyEvent.getKeyText(e.getKeyCode()).equals("Enter")) {
							lines = jta.getLineCount() + 1;
						} else if (KeyEvent.getKeyText(e.getKeyCode()).equals(
								"Backspace")) {
							lines = (jta.getLineCount() - 1 >= 1) ? jta
									.getLineCount() - 1 : 1;
						}

						if (lines > 24) {
							np.hoff = -(lines - 24) * 17;
							np.setLocation(1, np.hoff);
						} else {
							np.hoff = 1;
							np.setLocation(1, 1);
						}
						panel.repaint();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (um.canUndo()) {
					mntmNewMenuItem.setEnabled(true);
					lblNewLabel_3.setEnabled(true);
				} else {
					mntmNewMenuItem.setEnabled(false);
					lblNewLabel_3.setEnabled(false);
				}
				if (um.canRedo()) {
					menuItem_5.setEnabled(true);
					lblNewLabel_4.setEnabled(true);
				} else {
					menuItem_5.setEnabled(false);
					lblNewLabel_4.setEnabled(false);
				}
			}
		});
		jta.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.isPopupTrigger()) {
					if (jta.getSelectedText() != null
							&& !jta.getSelectedText().equals("")) {
						cut_.setEnabled(true);
						delete_.setEnabled(true);
						copy_.setEnabled(true);
					} else {
						cut_.setEnabled(false);
						delete_.setEnabled(false);
						copy_.setEnabled(false);
					}
					Clipboard cb = Toolkit.getDefaultToolkit()
							.getSystemClipboard();
					Transferable t = cb.getContents(null);
					if (t != null) {
						if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
							paste_.setEnabled(true);
						} else {
							paste_.setEnabled(false);
						}
					} else {
						paste_.setEnabled(false);
					}
					pop.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		jta.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		jta.setLineWrap(false);

		JScrollPane scrollPane = new JScrollPane(jta);
		scrollPane.setBounds(20, 59, 609, 413);
		scrollPane.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				int count = e.getWheelRotation();
				if (count > 0) {
					if (lines > 24 && 412 - np.getY() + 17 <= np.getHeight()) {
						np.setLocation(1, np.getY() - 17);
					}
				} else {
					if (lines > 24 && np.getY() + 17 <= 0) {
						np.setLocation(1, np.getY() + 17);
					}
				}
			}
		});
		frmNeditor.getContentPane().add(scrollPane);

		JScrollBar jsb = scrollPane.getVerticalScrollBar();
		jsb.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				if (lines > 24) {
					np.setLocation(1, -e.getValue());
					panel.repaint();
				}
			}
		});

		panel = new JPanel();
		panel.setBounds(0, 59, 20, 412);
		panel.setBackground(Color.lightGray);
		panel.setBorder(new Border() {

			@Override
			public void paintBorder(Component c, Graphics g, int x, int y,
					int width, int height) {
				// TODO Auto-generated method stub
				g.setColor(Color.gray);
				g.drawRect(0, 0, width, height - 1);
			}

			@Override
			public Insets getBorderInsets(Component c) {
				// TODO Auto-generated method stub
				return new Insets(1, 1, 1, 1);
			}

			@Override
			public boolean isBorderOpaque() {
				// TODO Auto-generated method stub
				return true;
			}
		});
		frmNeditor.getContentPane().add(panel);
		panel.setLayout(null);

		np = new NumberPanel();
		np.setLocation(1, 1);
		panel.add(np);

		final JLabel lblNewLabel = new MyLabel();
		lblNewLabel.setToolTipText("新建");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBorder(new Border() {

					@Override
					public void paintBorder(Component c, Graphics g, int x,
							int y, int width, int height) {
						// TODO Auto-generated method stub
						g.setColor(Color.gray);
						g.drawRoundRect(0, 0, width - 1, height - 1, 3, 3);
					}

					@Override
					public Insets getBorderInsets(Component c) {
						// TODO Auto-generated method stub
						return new Insets(1, 1, 1, 1);
					}

					@Override
					public boolean isBorderOpaque() {
						// TODO Auto-generated method stub
						return true;
					}

				});
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBorder(null);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1)
					newFile();
			}
		});
		lblNewLabel.setBounds(10, 32, 25, 25);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/new.png")));
		frmNeditor.getContentPane().add(lblNewLabel);

		final JLabel lblNewLabel_1 = new MyLabel();
		lblNewLabel_1.setToolTipText("打开");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setBorder(new Border() {

					@Override
					public void paintBorder(Component c, Graphics g, int x,
							int y, int width, int height) {
						// TODO Auto-generated method stub
						g.setColor(Color.gray);
						g.drawRoundRect(0, 0, width - 1, height - 1, 3, 3);
					}

					@Override
					public Insets getBorderInsets(Component c) {
						// TODO Auto-generated method stub
						return new Insets(1, 1, 1, 1);
					}

					@Override
					public boolean isBorderOpaque() {
						// TODO Auto-generated method stub
						return true;
					}

				});
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBorder(null);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1)
					open();
			}
		});
		lblNewLabel_1.setBounds(40, 32, 25, 25);
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/open.png")));
		frmNeditor.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new MyLabel();
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setToolTipText("保存");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setBorder(new Border() {

					@Override
					public void paintBorder(Component c, Graphics g, int x,
							int y, int width, int height) {
						// TODO Auto-generated method stub
						g.setColor(Color.gray);
						g.drawRoundRect(0, 0, width - 1, height - 1, 3, 3);
					}

					@Override
					public Insets getBorderInsets(Component c) {
						// TODO Auto-generated method stub
						return new Insets(1, 1, 1, 1);
					}

					@Override
					public boolean isBorderOpaque() {
						// TODO Auto-generated method stub
						return true;
					}

				});
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setBorder(null);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1)
					if (lblNewLabel_2.isEnabled())
						save();
			}
		});
		lblNewLabel_2.setBounds(70, 32, 25, 25);
		lblNewLabel_2.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/save.png")));
		frmNeditor.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new MyLabel();
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setToolTipText("撤销");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setBorder(new Border() {

					@Override
					public void paintBorder(Component c, Graphics g, int x,
							int y, int width, int height) {
						// TODO Auto-generated method stub
						g.setColor(Color.gray);
						g.drawRoundRect(0, 0, width - 1, height - 1, 3, 3);
					}

					@Override
					public Insets getBorderInsets(Component c) {
						// TODO Auto-generated method stub
						return new Insets(1, 1, 1, 1);
					}

					@Override
					public boolean isBorderOpaque() {
						// TODO Auto-generated method stub
						return true;
					}

				});
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setBorder(null);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (lblNewLabel_3.isEnabled()) {
						if (um.canUndo()) {
							um.undo();
						}

						if (um.canUndo()) {
							mntmNewMenuItem.setEnabled(true);
							lblNewLabel_3.setEnabled(true);
						} else {
							mntmNewMenuItem.setEnabled(false);
							lblNewLabel_3.setEnabled(false);
						}
						if (um.canRedo()) {
							menuItem_5.setEnabled(true);
							lblNewLabel_4.setEnabled(true);
						} else {
							menuItem_5.setEnabled(false);
							lblNewLabel_4.setEnabled(false);
						}
					}
				}
			}
		});
		lblNewLabel_3.setBounds(100, 32, 25, 25);
		lblNewLabel_3.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/undo.png")));
		frmNeditor.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new MyLabel();
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setToolTipText("恢复");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setBorder(new Border() {

					@Override
					public void paintBorder(Component c, Graphics g, int x,
							int y, int width, int height) {
						// TODO Auto-generated method stub
						g.setColor(Color.gray);
						g.drawRoundRect(0, 0, width - 1, height - 1, 3, 3);
					}

					@Override
					public Insets getBorderInsets(Component c) {
						// TODO Auto-generated method stub
						return new Insets(1, 1, 1, 1);
					}

					@Override
					public boolean isBorderOpaque() {
						// TODO Auto-generated method stub
						return true;
					}

				});
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setBorder(null);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (lblNewLabel_4.isEnabled()) {
						if (um.canRedo()) {
							um.redo();
						}

						if (um.canUndo()) {
							mntmNewMenuItem.setEnabled(true);
							lblNewLabel_3.setEnabled(true);
						} else {
							mntmNewMenuItem.setEnabled(false);
							lblNewLabel_3.setEnabled(false);
						}
						if (um.canRedo()) {
							menuItem_5.setEnabled(true);
							lblNewLabel_4.setEnabled(true);
						} else {
							menuItem_5.setEnabled(false);
							lblNewLabel_4.setEnabled(false);
						}
					}
				}
			}
		});
		lblNewLabel_4.setBounds(130, 32, 25, 25);
		lblNewLabel_4.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/redo.png")));
		frmNeditor.getContentPane().add(lblNewLabel_4);

		final JLabel lblNewLabel_5 = new MyLabel();
		lblNewLabel_5.setToolTipText("设置");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5.setBorder(new Border() {

					@Override
					public void paintBorder(Component c, Graphics g, int x,
							int y, int width, int height) {
						// TODO Auto-generated method stub
						g.setColor(Color.gray);
						g.drawRoundRect(0, 0, width - 1, height - 1, 3, 3);
					}

					@Override
					public Insets getBorderInsets(Component c) {
						// TODO Auto-generated method stub
						return new Insets(1, 1, 1, 1);
					}

					@Override
					public boolean isBorderOpaque() {
						// TODO Auto-generated method stub
						return true;
					}

				});
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5.setBorder(null);
			}
		});
		lblNewLabel_5.setBounds(160, 32, 25, 25);
		lblNewLabel_5.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/settings.png")));
		frmNeditor.getContentPane().add(lblNewLabel_5);
	}

	public void newFile() {
		if (edited) {
			new MyDialog(frmNeditor, "Save");
		} else {
			lines = 1;
			np.hoff = 1;
			jta.setText("");
			menuItem_2.setEnabled(false);
			lblNewLabel_2.setEnabled(false);
			lblNewLabel_3.setEnabled(false);
			lblNewLabel_4.setEnabled(false);
			mntmNewMenuItem.setEnabled(false);
			menuItem_5.setEnabled(false);
			np.setLocation(1, 1);
			filepath = null;
			panel.repaint();
		}
	}

	public void open() {
		if (!edited) {
			FileDialog dia1 = new FileDialog(frmNeditor, "打开"); // 重要
			dia1.setVisible(true);
			String path = dia1.getDirectory() + dia1.getFile(); // 重要
			if (!path.equals("nullnull")) {
				filepath = path;
				String context = "";
				try {
					FileReader fr = new FileReader(path);
					BufferedReader br = new BufferedReader(fr);
					String message = null;
					try {
						while ((message = br.readLine()) != null) {
							context = context + message + "\n";
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jta.setText(context);
				lines = jta.getLineCount();
				menuItem_2.setEnabled(false);
				lblNewLabel_2.setEnabled(false);
				panel.repaint();
			}
		} else {
			new MyDialog2(frmNeditor, "Save");
		}
	}

	public void save() {
		if (filepath == null) {
			saveToAnotherPath();
		} else {
			String context = jta.getText();
			try {
				FileWriter fw = new FileWriter(filepath);
				fw.write(context);
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menuItem_2.setEnabled(false);
			lblNewLabel_2.setEnabled(false);
			edited = false;
		}
	}

	public void saveToAnotherPath() {
		FileDialog dia2 = new FileDialog(frmNeditor, "保存", FileDialog.SAVE);
		dia2.setVisible(true);
		String path = dia2.getDirectory() + dia2.getFile();
		if (!path.equals("nullnull")) {
			filepath = path;
			File file = new File(path);
			if (!file.exists()) {
				try {
					file.createNewFile();
					FileWriter fw = new FileWriter(path);
					fw.write(jta.getText());
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			menuItem_2.setEnabled(false);
			lblNewLabel_2.setEnabled(false);
			edited = false;
		}
	}

	public void cut() {
		jta.cut();
		edited = true;
		lblNewLabel_2.setEnabled(true);
		menuItem_2.setEnabled(true);
	}

	public void copy() {
		jta.copy();
	}

	public void paste() {
		jta.paste();
		edited = true;
		lblNewLabel_2.setEnabled(true);
		menuItem_2.setEnabled(true);
		lines = jta.getLineCount();
		panel.repaint();
	}

	public void delete() {
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable t = cb.getContents(null);
		jta.cut();
		cb.setContents(t, null);
		edited = true;
		lblNewLabel_2.setEnabled(true);
		menuItem_2.setEnabled(true);
		lines = jta.getLineCount();
		panel.repaint();
	}

	public void select_all() {
		jta.selectAll();
	}
}
