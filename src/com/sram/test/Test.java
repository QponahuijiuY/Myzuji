package com.sram.test;

import com.sram.beans.ZuJi;
import com.sram.dao.impl.ZuJiDaoImpl;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		//集合    可变长度的数组      泛型
		List<ZuJi> zujis = new ZuJiDaoImpl().getZuJis();
		System.out.println(zujis);
	}
}
