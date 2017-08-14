/**
 * class to read files having products 
 */
package com.metacube.shoppingCart.Dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.metacube.shoppingCart.Model.Product;

public class FileHandling {
	/**
	 * 
	 * @param filepath
	 * @return a string having all values
	 */
	public static String read(String filepath) {
		StringBuffer buf = null;
		try {
			String str = "";
			buf = new StringBuffer();
			FileInputStream fstream = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			while ((str = br.readLine()) != null) {

				buf.append(str);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return buf.toString();
	}

	public static void readProducts(String filepath) {
		try {
			String str = "";
			FileInputStream fstream = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			while ((str = br.readLine()) != null) {
				String s[] = str.split(",");
				Product prod = new Product();
				prod.setCode(s[0]);
				prod.setName(s[1]);
				prod.setPrice(Double.parseDouble(s[2]));
				InMemoryProductDao.productMap.put(s[0], prod);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
