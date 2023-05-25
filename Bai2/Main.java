package Bai2;

import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.text.NumberFormat;


public class Main {
	private static final String fileName = "listKHChoVe";
	static ListKH listKH = new ListKH();
	public static void main(String[] args) throws Exception {
		boolean flag = true;

		if(new File(fileName).exists()) 
			listKH.loadDsDoiVe(fileName);
		
		int chon = -1;
		do
		{
			chon = menu();
			switch (chon)
			{
			case 1:				
				try {
					System.out.println("Tổng số khách hàng chờ mua vé trước khi thêm: "+listKH.tongSoKHDoiVe());
					listKH.themKHVaoListDoi(nhapDuLieu());
					System.out.println("Thêm hoàn tất ");
					flag = false;
					System.out.println("Tổng số khách hàng chờ mua vé sau khi thêm: "+listKH.tongSoKHDoiVe());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Fail ! ");
				}
				break;
			case 2:
				banVe();
				flag = false;
				break;
			case 3:
				xuatDanhSach(listKH.getAllKHDoiVe());
				break;
			case 4:
				xoaKH();
				flag = false;
				break;
			case 5:
				thongKe();
				break;
			case 6:
				try {
					listKH.saveDsDoiVe(fileName);
					System.out.println("Success");
					flag = true;
				} catch (Exception e) {
					System.out.println("Fail");
				}
				break;
			case 7:
				xuatDSCacGaDoiVe();
				break;
			case 8:
				thongKeTungGa();
				break;
			}
		}while(chon != 0);
		
		if(!flag)
		{
			System.out.println("-------- Bạn chưa lưu danh sách khách hàng chờ --------");
			System.out.println("1. Lưu và thoát");
			System.out.println("2. Thoát ra");
			Scanner nhap = new Scanner(System.in);
			chon = nhap.nextInt();
			if(chon == 1)
			{
				listKH.saveDsDoiVe(fileName);
				System.out.println("Lưu thành công!");
				flag = true;
			}
		}
		System.out.println("TẠM BIỆT !");
	}
	
	public static int menu()
	{
		Scanner nhap = new Scanner(System.in);
		System.out.println("1. Thêm khách hàng mới vào hàng chờ mua vé");
		System.out.println("2. Bán 1 vé cho khách hàng đã đăng ký trước");
		System.out.println("3. Hiển thị danh sách khách hàng chờ mua vé");
		System.out.println("4. Hủy 1 khách hàng ra khỏi danh sách ( khách hàng không mua vé nữa )");
		System.out.println("5. Thống kê tình hình bán vé");
		System.out.println("6. Lưu danh sách vào file");
		System.out.println("7. Hiển thị danh sách các ga đang chờ mua vé");
		System.out.println("8. Hiển thị danh sách các ga đang chờ mua vé và số vé tương ứng cho ga");
		System.out.println("0. Thoát");


		System.out.println("Bạn chọn :");
		int chon = nhap.nextInt();
		return chon;
	}
	
	public static void xuatTieuDe()
	{
		inGachNgang();
		System.out.printf("|%-10s|%-30s|%-15s|%-15s|\n", "Số CMND", "Tên khách hàng", "Ga đến", "Giá tiền");
		inGachNgang();
	}
	
	public static void inGachNgang()
	{
		for(int i = 0; i < 75; i++)
			System.out.print("-");
		System.out.println("");
	}
	
//	public static void nhapCung() throws Exception
//	{
//		KhachHang kh = new KhachHang("111111111", "Nguyễn Chí Khang", "Ga-001", 100000);
//		listKH.themKHVaoListDoi(kh);
//		kh = new KhachHang("222222222", "Mai Xuân Nguyên", "Ga-005", 500000);
//		listKH.themKHVaoListDoi(kh);
//		kh = new KhachHang("333333333", "Lê Thị Thanh Ngân", "Ga-003", 300000);
//		listKH.themKHVaoListDoi(kh);
//		kh = new KhachHang("444444444", "Trần Mạnh Cường", "Ga-001", 100000);
//		listKH.themKHVaoListDoi(kh);
//		kh = new KhachHang("555555555", "Ngô Minh Hiếu", "Ga-002", 200000);
//		listKH.themKHVaoListDoi(kh);
//		kh = new KhachHang("666666666", "Phó Ái Vy", "Ga-001", 100000);
//		listKH.themKHVaoListDoi(kh);
//		kh = new KhachHang("777777777", "Trương Thị Mỹ Diệu", "Ga-003", 300000);
//		listKH.themKHVaoListDoi(kh);
//		kh = new KhachHang("888888888", "Lê Chí Hào", "Ga-005", 500000);
//		listKH.themKHVaoListDoi(kh);
//		kh = new KhachHang("999999999", "Ngô Văn Hòa Thuận", "Ga-004", 350000);
//		listKH.themKHVaoListDoi(kh);
//	}
	
	public static KhachHang nhapDuLieu() throws Exception
	{
		String cMND, tenKH, gaDen;
		double giaTien;
		
		KhachHang kh = new KhachHang();
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhập số CMND khách hàng:");
		cMND = nhap.nextLine();
		KhachHang khTim = listKH.timKH(cMND);
		if(khTim == null)
		{
			kh.setcMND(cMND);
			System.out.println("Nhập tên khách hàng:");
			tenKH = nhap.nextLine();
			kh.setTenKH(tenKH);
			System.out.println("Nhập tên ga đến:");
			gaDen = nhap.nextLine();
			kh.setGaDen(gaDen);
			System.out.println("Nhập giá tiền:");
			giaTien = nhap.nextDouble();
			kh.setGiaTien(giaTien);
		}
		else
		{
			capNhat(khTim);
			throw new Exception("Cập nhật thành công!");
		}
		return kh;
	}
	
	public static void capNhat(KhachHang kh) throws Exception
	{
		String gaDen;
		double giaTien;
		
		System.out.println("Cập nhật dữ liệu khách hàng có số CMND là "+kh.getcMND());
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhập tên ga đến:");
		gaDen = nhap.nextLine();
		kh.setGaDen(gaDen);
		System.out.println("Nhập giá tiền:");
		giaTien = nhap.nextDouble();
		kh.setGiaTien(giaTien);
	}
	
	public static void xoaKH()
	{
		String cMND;
		
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhập số CMND khách hàng cần xóa:");
		cMND = nhap.nextLine();
		KhachHang khTim = listKH.timKH(cMND);
		if(khTim != null)
		{
			listKH.xoaKH(khTim);
			System.out.println("Xóa thành công!");
			xuatDanhSach(listKH.getAllKHDoiVe());
		}
		else
			System.out.println("Số CMND không tồn tại!");
	}
	
	public static String dinhDangTienTe(double tien)
	{
		Locale localeVN = new Locale("vi", "VN");
	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		
		return currencyVN.format(tien);
	}
	
	public static void thongKe()
	{
		System.out.printf("Tổng số khách hàng chờ nhận vé: "+listKH.tongSoKHDoiVe()+"\n");
		System.out.printf("Tổng số khách hàng đã có vé: "+listKH.tongSoKHCoVe()+"\n");
		System.out.printf("Tổng số tiền thu về là: "+dinhDangTienTe(listKH.tongTien())+"\n");
	}
	
	public static void banVe()
	{
		System.out.println("Thống kê trước khi bán vé:");
		System.out.printf("Tổng số khách hàng chờ nhận vé: "+listKH.tongSoKHDoiVe()+"\n");
		System.out.printf("Tổng số khách hàng đã có vé: "+listKH.tongSoKHCoVe()+"\n");
		if(listKH.banVe())
		{
			System.out.println("\nBán vé thành công!\n");
			System.out.println("Thống kê sau khi bán vé:");
			System.out.printf("Tổng số khách hàng chờ nhận vé: "+listKH.tongSoKHDoiVe()+"\n");
			System.out.printf("Tổng số khách hàng đã có vé: "+listKH.tongSoKHCoVe()+"\n");
		}
		else
			System.out.println("Không có khách hàng chờ mua vé!");
	}
	
	public static void xuatDanhSach(Queue<KhachHang> ds)
	{
		if(listKH.tongSoKHDoiVe()>0)
		{
			System.out.println("Danh sách khách hàng đợi mua vé:");
			xuatTieuDe();
			for (KhachHang kh : ds) {
				System.out.println(kh);
				inGachNgang();
			}
		}
		else
			System.out.println("Không có khách hàng chờ mua vé!");
	}
	
	public static void thongKeTungGa()
	{
		Map<String, Integer> thongKe = listKH.thongKeSoVeTungGa();
		if(thongKe.size() > 0){
			System.out.println("Bảng thống kê số vé đã bán theo từng ga");
			System.out.printf("|%-15s|%15s|\n","Tên ga","Số vé đã bán");
			for(String tenGa : thongKe.keySet())
			{
				System.out.printf("|%-15s|%15s|\n",tenGa,thongKe.get(tenGa));
				System.out.println("---------------------------------");
			}
		}
		else
			System.out.println("0 vé !");
	}
	
	public static void xuatDSCacGaDoiVe()
	{
		if(listKH.tongSoKHDoiVe() != 0)
		{
			System.out.println("Danh sách các ga đợi mua vé:");
			System.out.printf("|%-15s|%15s|\n","Tên ga", "Số khách chờ");
			Set<String> list = listKH.danhSachGaDoiVe();
			for (String s : list) {
				System.out.printf("|%-15s|%15s|\n", s, listKH.tongSoKHChoTungGa(s));
				System.out.println("---------------------------------");
			}
		}
		else
			System.out.println("Không còn khách đợi mua vé!");
	}
}

