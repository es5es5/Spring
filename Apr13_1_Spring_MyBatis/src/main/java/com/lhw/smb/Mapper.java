package com.lhw.smb;

import java.util.List;

public interface Mapper {
	// return Ÿ��
		// insert, update, delete : int
		// select : List<�ڹٺ�> or �ڹٺ�
	// method�� : id�� ���߱�
	// parameter
	public abstract List<Menu> searchMenu(Menu m);
	public abstract int regMenu(Menu m);
	public abstract List<Menu> showMenu();
	
}
