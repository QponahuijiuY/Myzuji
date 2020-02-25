package com.sram.dao;

import java.util.List;

import com.sram.beans.ZuJi;

public interface ZuJiDao {
	public abstract List<ZuJi> getZuJis();
	
	public abstract void addZuJi(ZuJi zuJi);
	
	public abstract void deleteZuJi(int id);
	
	public abstract ZuJi getZuJi(int id);
	
	public abstract void updateZuJi(ZuJi zuJi);
}
