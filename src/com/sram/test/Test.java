package com.sram.test;

import com.sram.beans.ZuJi;
import com.sram.dao.impl.ZuJiDaoImpl;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		//����    �ɱ䳤�ȵ�����      ����
		List<ZuJi> zujis = new ZuJiDaoImpl().getZuJis();
		System.out.println(zujis);
	}
}
