package com.javas.file;

import java.io.*;

public class Copy {
	public static void main(String[] args) throws IOException {

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Pictures\\Camera Roll\\vi-vim-cheat-sheet-sch1.gif"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\idea\\javas\\vim.gif"));

		byte[] bys = new byte[1024];
		int len;
		while ((len = bis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}

		bis.close();
		bos.close();

	}
}
