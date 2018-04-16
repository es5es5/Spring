package com.lhw.smb;

import java.util.List;

public interface Mapper {
	// return 타입
		// insert, update, delete : int
		// select : List<자바빈> or 자바빈
	// method명 : id와 맞추기
	// parameter
	public abstract List<Menu> searchMenu(Menu m);
	public abstract int regMenu(Menu m);
	public abstract List<Menu> showMenu();
	
}
