package com.kitri.util;

import java.io.File;
import java.io.IOException;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
//		if (createNewFile(f)) {
//			return f;
//		}
		String name = f.getName();
		String ext = null;

		int dot = name.lastIndexOf(".");
		if (dot != -1) {
			ext = name.substring(dot); // includes "."
		} else {
			ext = "";
		}

		long current = System.nanoTime();
		String newName = current + ext;
		System.out.println(">>>>>>>>>>>>" + newName);
		f = new File(f.getParent(), newName);

		return f;
	}

	private boolean createNewFile(File f) {
//		try {
//			return f.createNewFile();
//		} catch (IOException ignored) {
			return false;
//		}
	}

}
