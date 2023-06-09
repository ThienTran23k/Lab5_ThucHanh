package Bai2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class SaveLoad {
	public static void save(Object obj, String fileName) {
		try{
			FileOutputStream fos=new FileOutputStream(fileName);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object load(String fileName) {
		Object obj=null;
		try{
			FileInputStream fis=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			obj=ois.readObject();
			ois.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}

