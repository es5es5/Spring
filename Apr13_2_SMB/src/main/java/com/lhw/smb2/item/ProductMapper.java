package com.lhw.smb2.item;

import java.util.List;

public interface ProductMapper {
	public abstract int reg(Item i);
	public abstract List<Item> getAllItem();
	public abstract int delete(Item i);
}
