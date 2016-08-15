package zpy.sdhy.ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MainFrame extends Frame implements KeyListener {
	private JLabel lab_tank;
	// 1代表砖头 4 代表tree
	private int[][] maps = {

			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 8, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 8, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 8, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }

	};
	private int ty;
	private int tx;
	// 任务完成计数器
	int num = 0;
	// 任务完成总数
	int total = 3;
	JLabel[][] sheeps = new JLabel[13][17];

	public MainFrame() {
		// 添加牢笼
		// inPutlaolong();
		// 添加主人公
		tankInPut();
		// 添加障碍
		zhuanInPut();
		// 天添加 懒洋洋
		inPutYang();
		// 设置窗口背景
		backgroundInit();
		// 设置基本窗口属性
		setMainFrameUI();

		// 设置监听
		this.addKeyListener(this);
	}

	private void inPutlaolong() {
		// TODO Auto-generated method stub
		Icon i = new ImageIcon("laolong.png");
		// 使用JLabel制作
		JLabel lab_lao1 = new JLabel(i);
		// 设置图片要显示的位置
		lab_lao1.setBounds(20 + 50 * 15, 60 + 50 * 4, 50, 50);
		// 添加到窗口
		this.add(lab_lao1);
		maps[4][15] = 8;

		// 使用JLabel制作
		JLabel lab_lao2 = new JLabel(i);
		// 设置图片要显示的位置
		lab_lao2.setBounds(20 + 50 * 15, 60 + 50 * 5, 50, 50);
		// 添加到窗口
		this.add(lab_lao2);
		maps[5][15] = 8;

		// 使用JLabel制作
		JLabel lab_lao3 = new JLabel(i);
		// 设置图片要显示的位置
		lab_lao3.setBounds(20 + 50 * 15, 60 + 50 * 6, 50, 50);
		// 添加到窗口
		this.add(lab_lao3);
		maps[6][15] = 8;
	}

	private void inPutYang() {
		// TODO Auto-generated method stub
		// 创建一张图片
		Icon i = new ImageIcon("yang.png");
		// 使用JLabel制作
		JLabel lab_sheep1 = new JLabel(i);
		// 设置图片要显示的位置
		lab_sheep1.setBounds(20 + 50 * 6, 60 + 50 * 4, 50, 50);
		// 添加到窗口
		this.add(lab_sheep1);
		maps[4][6] = 4;
		sheeps[4][6] = lab_sheep1;

		JLabel lab_sheep2 = new JLabel(i);
		// 设置图片要显示的位置
		lab_sheep2.setBounds(20 + 50 * 6, 60 + 50 * 6, 50, 50);
		// 添加到窗口
		this.add(lab_sheep2);
		maps[6][6] = 4;
		sheeps[6][6] = lab_sheep2;
		JLabel lab_sheep3 = new JLabel(i);
		// 设置图片要显示的位置
		lab_sheep3.setBounds(20 + 50 * 6, 60 + 50 * 8, 50, 50);
		// 添加到窗口
		this.add(lab_sheep3);
		maps[8][6] = 4;
		sheeps[8][6] = lab_sheep3;
	}

	private void zhuanInPut() {
		// TODO Auto-generated method stub
		Icon ic = new ImageIcon("tree.png");
		Icon l = new ImageIcon("laolong.png");
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length; j++) {
				if (maps[i][j] == 8) {
					// 使用JLabel制作
					JLabel lab_lao1 = new JLabel(l);
					// 设置图片要显示的位置
					lab_lao1.setBounds(20 + 50 * j, 60 + 50 * i, 50, 50);
					// 添加到窗口
					this.add(lab_lao1);
					// maps[i][j]=8;
				}
				// 判断一下原始数据里面的值如果是1，做障碍
				if (maps[i][j] == 1) {
					// 障碍的初始化
					// 2.创建JLabel
					JLabel lab_tree = new JLabel(ic);
					// 3.设置大小位置
					lab_tree.setBounds(20 + 50 * j, 60 + 50 * i, 50, 50);
					// 4.添加到窗体中
					this.add(lab_tree);
				}

			}
		}
	}

	private void tankInPut() {
		tx = 1;
		ty = 1;
		// TODO Auto-generated method stub
		Icon i = new ImageIcon("down.png");
		lab_tank = new JLabel(i);
		// 20 60 为左上角的起始值坐标为修正数值
		lab_tank.setBounds(20 + tx * 50, 60 + ty * 50, 50, 50);
		this.add(lab_tank);
		// 把tank的数据添加到数组中
		// maps[(260-20)/80][(300-60)/80]=8;

	}

	private void backgroundInit() {
		// TODO Auto-generated method stub
		// 创建一张图片
		Icon i = new ImageIcon("bg.png");
		// 使用JLabel制作背景
		JLabel lab_back = new JLabel(i);
		// 设置图片要显示的位置
		lab_back.setBounds(20, 60, 1360, 820);
		// 添加到窗口
		this.add(lab_back);

	}

	private void setMainFrameUI() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		this.setTitle("推箱子V1.0");
		this.setVisible(true);
		 setResizable(false);
		this.setSize(1120, 730);
		this.setLocationRelativeTo(null);
		// this.setLocation(50, 50);
		this.addWindowListener(new Mywindow());
	}

	class Mywindow extends WindowAdapter {
		public void windowClosing(WindowEvent e) {

			System.exit(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		// 获取按下去的按键
		// 38 上
		// 40 下
		// 37 左
		// 39 右
		// System.out.println(e.getKeyCode());
		int key = e.getKeyCode();
		if (key == 39) {
			// 向右走
			// 方向上第一位的坐标是ty tx+1
			// 方向上第二位的坐标是 ty tx+2

			if (maps[ty][tx + 1] == 0 || maps[ty][tx + 1] == 8) {
				tx = tx + 1;
				int x = (int) lab_tank.getLocation().getX();
				int y = (int) lab_tank.getLocation().getY();
				lab_tank.setLocation(x + 50, y);
				Icon i = new ImageIcon("right.png");
				lab_tank.setIcon(i);
				return;
			}
			if (maps[ty][tx + 1] == 1) {
				return;
			}
			// 前方有箱子+障碍物的情况
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 1) {
				return;
			}
			// 前方有两个箱子的情况
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 4) {
				return;
			}
			// 前方有箱子 + 已经到达目的地的箱子的情况
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 12) {
				return;
			}
			// 前方有 到达目的地的箱子 + 障碍物的情况
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 1) {
				return;
			}
			// 前方有到达目的地的箱子 + 箱子
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 4) {
				return;
			}
			// 前方有到达目的地的箱子 + 到达目的地的箱子
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 12) {
				return;
			}
			// 推着箱子可以往前走
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 0) {
				maps[ty][tx + 1] = 0;
				maps[ty][tx + 2] = 4;
			}
			// 推着箱子遇到了 目标地点
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 8) {
				maps[ty][tx + 1] = 0;
				maps[ty][tx + 2] = 12;
				num++;
			}
			// 从目标里面把箱子推出来了
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 0) {
				maps[ty][tx + 1] = 8;
				maps[ty][tx + 2] = 4;
				num--;
			}
			// 所在目标地 互换了
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 8) {
				maps[ty][tx + 1] = 8;
				maps[ty][tx + 2] = 12;
			}
			sheeps[ty][tx + 1].setLocation(20 + tx * 50 + 100, 60 + ty * 50);
			sheeps[ty][tx + 2] = sheeps[ty][tx + 1];
			sheeps[ty][tx + 1] = null;
			tx = tx + 1;
			int x = (int) lab_tank.getLocation().getX();
			int y = (int) lab_tank.getLocation().getY();
			lab_tank.setLocation(x + 50, y);
			Icon i = new ImageIcon("right.png");
			lab_tank.setIcon(i);
			// 胜利的判定
			victory();
			return;
		}
		if (key == 40) {
			// 向下

			if (maps[ty + 1][tx] == 0 || maps[ty + 1][tx] == 8) {
				ty = ty + 1;
				int x = (int) lab_tank.getLocation().getX();
				int y = (int) lab_tank.getLocation().getY();
				lab_tank.setLocation(x, y + 50);
				Icon i = new ImageIcon("down.png");
				lab_tank.setIcon(i);
				return;
			}
			if (maps[ty + 1][tx] == 1) {
				return;
			}
			// 前方有箱子+障碍物的情况
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 1) {
				return;
			}
			// 前方有两个箱子的情况
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 4) {
				return;
			}
			// 前方有箱子 + 已经到达目的地的箱子的情况
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 12) {
				return;
			}
			// 前方有 到达目的地的箱子 + 障碍物的情况
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 1) {
				return;
			}
			// 前方有到达目的地的箱子 + 箱子
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 4) {
				return;
			}
			// 前方有到达目的地的箱子 + 到达目的地的箱子
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 12) {
				return;
			}
			// 推着箱子可以往前走
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 0) {
				maps[ty + 1][tx] = 0;
				maps[ty + 2][tx] = 4;
			}
			// 推着箱子遇到了 目标地点
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 8) {
				maps[ty + 1][tx] = 0;
				maps[ty + 2][tx] = 12;
				num++;
			}
			// 从目标里面把箱子推出来了
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 0) {
				maps[ty + 1][tx] = 8;
				maps[ty + 2][tx] = 4;
				num--;
			}
			// 所在目标地 互换了
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 8) {
				maps[ty + 1][tx] = 8;
				maps[ty + 2][tx] = 12;
			}
			sheeps[ty + 1][tx].setLocation(20 + tx * 50, 60 + ty * 50 + 100);
			sheeps[ty + 2][tx] = sheeps[ty + 1][tx];
			sheeps[ty + 1][tx] = null;
			ty = ty + 1;
			int x = (int) lab_tank.getLocation().getX();
			int y = (int) lab_tank.getLocation().getY();
			lab_tank.setLocation(x, y + 50);
			Icon i = new ImageIcon("down.png");
			lab_tank.setIcon(i);
			// 胜利的判定
			victory();
			return;

		}
		if (key == 38) {
			// 向up

			if (maps[ty - 1][tx] == 0 || maps[ty - 1][tx] == 8) {
				ty = ty - 1;
				int x = (int) lab_tank.getLocation().getX();
				int y = (int) lab_tank.getLocation().getY();
				lab_tank.setLocation(x, y - 50);
				Icon i = new ImageIcon("up.png");
				lab_tank.setIcon(i);
				return;
			}
			if (maps[ty - 1][tx] == 1) {
				return;
			}
			// 前方有箱子+障碍物的情况
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 1) {
				return;
			}
			// 前方有两个箱子的情况
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 4) {
				return;
			}
			// 前方有箱子 + 已经到达目的地的箱子的情况
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 12) {
				return;
			}
			// 前方有 到达目的地的箱子 + 障碍物的情况
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 1) {
				return;
			}
			// 前方有到达目的地的箱子 + 箱子
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 4) {
				return;
			}
			// 前方有到达目的地的箱子 + 到达目的地的箱子
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 12) {
				return;
			}
			// 推着箱子可以往前走
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 0) {
				maps[ty - 1][tx] = 0;
				maps[ty - 2][tx] = 4;
			}
			// 推着箱子遇到了 目标地点
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 8) {
				maps[ty - 1][tx] = 0;
				maps[ty - 2][tx] = 12;
				num++;
			}
			// 从目标里面把箱子推出来了
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 0) {
				maps[ty - 1][tx] = 8;
				maps[ty - 2][tx] = 4;
				num--;
			}
			// 所在目标地 互换了
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 8) {
				maps[ty - 1][tx] = 8;
				maps[ty - 2][tx] = 12;
			}
			sheeps[ty - 1][tx].setLocation(20 + tx * 50, 60 + ty * 50 - 100);
			sheeps[ty - 2][tx] = sheeps[ty - 1][tx];
			sheeps[ty - 1][tx] = null;
			ty = ty - 1;
			int x = (int) lab_tank.getLocation().getX();
			int y = (int) lab_tank.getLocation().getY();
			lab_tank.setLocation(x, y - 50);
			Icon i = new ImageIcon("up.png");
			lab_tank.setIcon(i);
			// 胜利的判定
			victory();
			return;

		}
		if (key == 37) {
			// 向zuo走
			// 方向上第一位的坐标是ty tx-1
			// 方向上第二位的坐标是 ty tx-2

			if (maps[ty][tx - 1] == 0 || maps[ty][tx - 1] == 8) {
				tx = tx - 1;
				int x = (int) lab_tank.getLocation().getX();
				int y = (int) lab_tank.getLocation().getY();
				lab_tank.setLocation(x - 50, y);
				Icon i = new ImageIcon("left.png");
				lab_tank.setIcon(i);
				return;
			}
			if (maps[ty][tx - 1] == 1) {
				return;
			}
			// 前方有箱子-障碍物的情况
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 1) {
				return;
			}
			// 前方有两个箱子的情况
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 4) {
				return;
			}
			// 前方有箱子 - 已经到达目的地的箱子的情况
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 12) {
				return;
			}
			// 前方有 到达目的地的箱子 - 障碍物的情况
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 1) {
				return;
			}
			// 前方有到达目的地的箱子 - 箱子
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 4) {
				return;
			}
			// 前方有到达目的地的箱子 - 到达目的地的箱子
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 12) {
				return;
			}
			// 推着箱子可以往前走
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 0) {
				maps[ty][tx - 1] = 0;
				maps[ty][tx - 2] = 4;
			}
			// 推着箱子遇到了 目标地点
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 8) {
				maps[ty][tx - 1] = 0;
				maps[ty][tx - 2] = 12;
				num++;
			}
			// 从目标里面把箱子推出来了
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 0) {
				maps[ty][tx - 1] = 8;
				maps[ty][tx - 2] = 4;
				num--;
			}
			// 所在目标地 互换了
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 8) {
				maps[ty][tx - 1] = 8;
				maps[ty][tx - 2] = 12;
			}
			sheeps[ty][tx - 1].setLocation(20 + tx * 50 - 100, 60 + ty * 50);
			sheeps[ty][tx - 2] = sheeps[ty][tx - 1];
			sheeps[ty][tx - 1] = null;
			tx = tx - 1;
			int x = (int) lab_tank.getLocation().getX();
			int y = (int) lab_tank.getLocation().getY();
			lab_tank.setLocation(x - 50, y);
			Icon i = new ImageIcon("left.png");
			lab_tank.setIcon(i);
			// 胜利的判定
			victory();
			return;
		}

	}

	private void victory() {
		// TODO Auto-generated method stub
		// System.out.println(num);
		if (num == total) {
			// 移除窗体键盘事件，避免用户多余操作
			this.removeKeyListener(this);
			System.out.println("win");
			JDialog victory = new JDialog(this, "恭喜你取得了胜利", true);
			victory.setSize(400, 300);
			victory.setLocationRelativeTo(null);
			victory.setLayout(null);

			JLabel info = new JLabel(new ImageIcon("win.jpg"));
			info.setBounds(2, 2, 380, 180);
			victory.add(info);
			JButton click = new JButton("下一关");
			click.setBounds(140, 200, 120, 30);

			victory.add(click);
			victory.setVisible(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
