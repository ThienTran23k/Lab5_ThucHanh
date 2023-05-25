package Bai2;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ListKH implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Queue<KhachHang> listDoiVe, listCoVe;
	
	public ListKH()
	{
		listDoiVe = new LinkedList<KhachHang>();
		listCoVe = new LinkedList<KhachHang>();
	}
	
	public Queue<KhachHang> getAllKHDoiVe()
	{
		return listDoiVe;
	}
	
	public Queue<KhachHang> getAllKHCoVe()
	{
		return listCoVe;
	}
	
	public boolean themKHVaoListDoi(KhachHang kh) throws Exception
	{
		if(listDoiVe.contains(kh))
			throw new Exception("Trùng số CMND!");
		listDoiVe.add(kh);
		return true;
	}
	
	public boolean xoaKH(KhachHang kh)
	{
		listDoiVe.remove(kh);
		return true;
	}
	
	public KhachHang timKH(String cMND)
	{
		for (KhachHang kh : listDoiVe)
		{
			if(kh.getcMND().equalsIgnoreCase(cMND))
				return kh;
		}
		return null;
	}
	
	public boolean banVe() {
		if(listDoiVe.size() > 0)
		{
			KhachHang kh = listDoiVe.poll();
			listCoVe.add(kh);
			return true;
		}
		return false;
	}
	
	public int tongSoKHDoiVe()
	{
		return listDoiVe.size();
	}
	
	public int tongSoKHCoVe()
	{
		return listCoVe.size();
	}
	
	public double tongTien()
	{
		double sum = 0;
		for (KhachHang kh : listCoVe) 
		{
			sum += kh.getGiaTien();
		}
		return sum;
	}
	
	public Set<String> danhSachGaDoiVe() 
	{
		Set<String> listGa = new TreeSet<String>();
		for(KhachHang kh: listDoiVe)
			listGa.add(kh.getGaDen());
		return listGa;
	}
	
	public int tongSoKHChoTungGa(String ga)
	{
		int dem = 0;
		for (KhachHang kh : listDoiVe) {
			if(kh.getGaDen().equalsIgnoreCase(ga))
				dem++;
		}
		return dem;
	}
	
	public Map<String, Integer> thongKeSoVeTungGa() 
	{
		Map<String, Integer> bangThongKe = new TreeMap<String, Integer>();
		for(KhachHang kh : listCoVe)
		{
			String ga = kh.getGaDen();
			if(bangThongKe.containsKey(ga)) 
				bangThongKe.put(ga, bangThongKe.get(ga) + 1); 
			else
				bangThongKe.put(ga, 1); 
		}
		return bangThongKe;
	}
	

	public void saveDsDoiVe(String fileName) 
	{
		SaveLoad.save(listDoiVe, fileName);
	}
	

	public void loadDsDoiVe(String fileName)
	{
		listDoiVe = (Queue<KhachHang>)SaveLoad.load(fileName);
	}
}

