package Bai1;


import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			DanhSachPhong dsPhongHoc = new DanhSachPhong();
			menuPhongHoc(dsPhongHoc);
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Lỗi - Eror".toUpperCase());
		}

	}
	private static void tieuDe() {
		System.out.println(String.format("%15s | %-20s | %15s | %15s | %15s | %15s | %-25s | %15s | %-15s | %-20s", "Mã Phòng","Dãy Nhà","Diện Tích","Số Bóng �?èn","Máy Chiếu","Số Máy Tính","Thông Tin Chuyên Ngành","Sức Chứa","Bồn Rửa","Loại Phòng"));
	}
	private static void tieuDeMenu() {
		System.out.println("1. Thêm một Phòng Học.");
		System.out.println("2. Tìm kiếm một Phòng Học.");
		System.out.println("3. In ra toàn bộ danh sách Phòng Học.");
		System.out.println("4. In danh sách Phòng Học đạt chuẩn.");
		System.out.println("5. Sắp xếp danh sách tăng dần theo cột dãy nhà.");
		System.out.println("6. Sắp xếp danh sách giảm dần theo cột diện tích.");
		System.out.println("7. Sắp xếp danh sách tăng dần theo cột bóng đèn.");
		System.out.println("8. Cập nhật số máy tính cho một phòng máy tính.");
		System.out.println("9. Xóa một phòng Học.");
		System.out.println("10.In ra tổng số phòng Học.");
		System.out.println("11.In danh sách các phòng máy có 60 máy.");
		System.out.println("0.Thoát.");
	}
	private static void menuPhongHoc(DanhSachPhong dsPhongHoc) {
		
		int chon ;
		do {
			tieuDeMenu();
			System.out.println("Bạn chọn : ");
			try {
				chon = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Bạn vừa nhập không phải số!");
				throw null;
			}

			if(chon < 0|| chon > 11) {
				System.out.println("Chọn sai! Chọn từ số(0 đến 12)!\nChọn lại: ");
			}else {
				switch (chon) {
				case 0:
					break;
				case 1:
					menuChonNhapMem(dsPhongHoc);
					break;
				case 2:
					timPhongHoc(dsPhongHoc);
					break;
				case 3:
					dsPhongHoc.sapXepTheoID();
					xuatDanhSachPhong(dsPhongHoc);
					break;
				case 4:
					xuatDanhSachPhongDatChuan(dsPhongHoc);
					break;
				case 5:
					dsPhongHoc.sapXepTangDanTheoDayNha();
					System.out.println("danh sách sắp xếp tăng dần theo dãy nhà".toUpperCase());
					xuatDanhSachPhong(dsPhongHoc);
					break;
				case 6:
					dsPhongHoc.sapXepGiamDanTheoDienTich();
					System.out.println("danh sách sắp xếp giảm dần theo diện tích".toUpperCase());
					xuatDanhSachPhong(dsPhongHoc);
					break;
				case 7:
					dsPhongHoc.sapXepTangDanTheoSoBongDen();
					System.out.println("danh sách sắp tăng dần theo số bóng đèn".toUpperCase());
					xuatDanhSachPhong(dsPhongHoc);
					break;
				case 8:
					capNhatMayTinh(dsPhongHoc);
					break;
				case 9:
					xoaMotPhongHoc(dsPhongHoc);
					break;
				case 10:
					inTongSoPhongHoc(dsPhongHoc);
					break;
				case 11:
					inDanhSachPhongMay60(dsPhongHoc);
					break;
					
				default:
					
					break;
				}
			}

		}while(chon != 12);
	}

	private static void nhapCungPhongHoc(DanhSachPhong dsPhongHoc) {
		PhongHoc phong1 = new PhongLyThuyet("ph1", "A", 200, 20, true);//phòng chuẩn
		PhongHoc phong2 = new PhongLyThuyet("ph2", "B", 150, 20, false);

		PhongHoc phong3 = new PhongHocMayTinh("ph3", "C", 500, 55, 334);//phòng chuẩn
		PhongHoc phong4 = new PhongHocMayTinh("ph4", "D", 500, 40, 200);

		PhongHoc phong5 = new PhongThiNghiem("ph5", "E", 400, 44, "Hóa h�?c", 80, true);//phòng chuẩn
		PhongHoc phong6 = new PhongThiNghiem("ph6", "F", 400, 44, "Thực Phẩm", 30, false);
		if(dsPhongHoc.themMotPhongHoc(phong1)) {
			System.out.println("Thêm thành công: "+phong1.getMaPhong());
		}else {
			System.out.println("Thêm thất bại: "+phong1.getMaPhong()+" -Đã tồn tại!!" );
		}

		if(dsPhongHoc.themMotPhongHoc(phong2)) {
			System.out.println("Thêm thành công: "+phong2.getMaPhong());
		}else {
			System.out.println("Thêm thất bại: "+phong2.getMaPhong()+" -Đã tồn tại!!" );
		}
		if(dsPhongHoc.themMotPhongHoc(phong3)) {
			System.out.println("Thêm thành công: "+phong3.getMaPhong());
		}else {
			System.out.println("Thêm thất bại: "+phong3.getMaPhong()+" -Đã tồn tại!!" );
		}
		if(dsPhongHoc.themMotPhongHoc(phong4)) {
			System.out.println("Thêm thành công: "+phong4.getMaPhong());
		}else {
			System.out.println("Thêm thất bại: "+phong4.getMaPhong()+" -Đã tồn tại!!" );
		}
		if(dsPhongHoc.themMotPhongHoc(phong5)) {
			System.out.println("Thêm thành công: "+phong5.getMaPhong());
		}else {
			System.out.println("Thêm thất bại: "+phong5.getMaPhong()+" -Đã tồn tại!!" );
		}
		if(dsPhongHoc.themMotPhongHoc(phong6)) {
			System.out.println("Thêm thành công: "+phong6.getMaPhong());
		}else {
			System.out.println("Thêm thất bại: "+phong6.getMaPhong()+" -Đã tồn tại!!" );
		}
		System.out.println("\n");
	}

	private static void menuChonNhapMem(DanhSachPhong dsPhongHoc) {
		
		int chon = 0;
		do {

			System.out.println("Bạn Chọn ?".toUpperCase());

			System.out.println("1. Nhập Phòng Lý Thuyết.");
			System.out.println("2. Nhập Phòng Máy Tính.");
			System.out.println("3. Nhập Phòng Thí Nghiệm.");
			System.out.println("Bạn chọn nhập?: ");
			chon = sc.nextInt();
			if(chon < 0 || chon > 3) {
				System.out.println("Chọn sai! chọn lại!");
				System.out.println("1. Nhập Phòng Lý Thuyết.");
				System.out.println("2. Nhập Phòng Máy Tính.");
				System.out.println("3. Nhập Phòng Thí Nghiệm.");
				System.out.println("Bạn chọn nhập?: ");
			}else {
				switch (chon) {
				case 1:
					int phongLyThuyet = 1;
					nhapMemPhongHoc(dsPhongHoc, phongLyThuyet);
					chon = 412;
					break;
				case 2:
					int phongMayTinh = 2;
					nhapMemPhongHoc(dsPhongHoc, phongMayTinh);
					chon = 412;
					break;
				case 3:
					int phongThiNghiem = 3;
					nhapMemPhongHoc(dsPhongHoc, phongThiNghiem);
					chon = 412;
					break;
				default:
					break;
				}
			}
		}while(chon != 412);
	}

	private static void nhapMemPhongHoc(DanhSachPhong dsPhongHoc,int loaiPhong) {
		int phongLyThuyet = 1, phongMayTinh = 2,phongThiNghiem = 3;
		sc.nextLine();
		System.out.println("Nhập mã phòng học: ");
		String checkMa = null;
		String maPhongHoc = nhapChuoi(checkMa, "mã phòng học");

		System.out.println("Nhập dãy nhà: ");
		String checkDayNha = null;
		String dayNha = nhapChuoi(checkDayNha, "dãy nhà");

		System.out.println("Nhập diện tích: ");
		long checkDientich = 0;
		double dienTich = (double) nhapSo(checkDientich, "diện tích");

		System.out.println("Nhập số bóng đèn: ");
		long checkSoBongDen = 0;
		int bongDen = (int) nhapSo(checkSoBongDen, "số bóng đèn");

		if(loaiPhong == phongLyThuyet) {
			System.out.println("Có máy chiếu(1: Có, 2: Không): ");
			int kiemTraMayChieu = 0;
			do {
				try {
					kiemTraMayChieu = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Bạn vừa nhập kiểm tra có máy chiếu không phải số!");
					throw null;
				}

				if(kiemTraMayChieu > 2 || kiemTraMayChieu < 1) {
					System.out.println("Nhập sai!");
					System.out.println("Có máy chiếu(1: Có, 2: Không): ");
				}else {
					boolean coMayChieu = (kiemTraMayChieu == 1)?true:false;
					PhongLyThuyet phongMoi = new PhongLyThuyet(maPhongHoc, dayNha, dienTich, bongDen, coMayChieu);
					dsPhongHoc.themMotPhongHoc(phongMoi);
				}
			}while(kiemTraMayChieu > 2 || kiemTraMayChieu < 1);

		}else if (loaiPhong == phongMayTinh) {
			System.out.println("Nhập vào số lượng máy tính: ");
			long checkSoLuong = 0;
			int soLuongMayTinh = (int) nhapSo(checkSoLuong, "Số lượng máy tính");
			PhongHocMayTinh phongMoi = new PhongHocMayTinh(maPhongHoc, dayNha, dienTich, bongDen, soLuongMayTinh);
			dsPhongHoc.themMotPhongHoc(phongMoi);
		}else if (loaiPhong == phongThiNghiem) {
			sc.nextLine();
			System.out.println("Nhập thông tin Chuyên Ngành: ");
			String checkThongTinChuyenNganh = null;
			String thongTinChuyenNganh = nhapChuoi(checkThongTinChuyenNganh, "thông tin chuyên ngành");

			System.out.println("Nhập sức chứa: ");
			long checkSucChua = 0;
			int sucChua = (int) nhapSo(checkSucChua, "Sức chứa");

			System.out.println("Có bồn rửa(1: Có, 2: Không): ");
			int kiemTraBonRua = 0;
			do {
				try {
					kiemTraBonRua = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Bạn vừa nhập kiểm tra có bồn rửa không phải số!");
					throw null;
				}

				if(kiemTraBonRua > 2 || kiemTraBonRua < 1) {
					System.out.println("Nhập sai!");
					System.out.println("Có bồn rửa(1: Có, 2: Không): ");
				}else {
					boolean coBonRua = (kiemTraBonRua == 1)?true:false;
					PhongThiNghiem phongMoi = new PhongThiNghiem(maPhongHoc, dayNha, dienTich, bongDen, thongTinChuyenNganh, sucChua, coBonRua);
					dsPhongHoc.themMotPhongHoc(phongMoi);
				}
			}while(kiemTraBonRua > 2 || kiemTraBonRua < 1);

		}

	}


	private static void timPhongHoc(DanhSachPhong dsPhongHoc) {
		sc.nextLine();
		System.out.println("Nhập mã phòng cần tìm: ");
		String maCheck = null;
		String maCheckCanTim = nhapChuoi(maCheck, "Mã cần tìm");
		PhongHoc objTim = dsPhongHoc.timPhongHoc(maCheckCanTim);
		if(objTim !=null) {
			System.out.println("Tìm thấy phòng: "+maCheckCanTim);
			tieuDe();
			System.out.println(objTim);
		}else {
			System.out.println("Không tìm thấy phòng: "+maCheckCanTim);
		}

		System.out.println("\n");
	}


	private static void xuatDanhSachPhong(DanhSachPhong dsPhongHoc) {
		if(!dsPhongHoc.layHetDanhSach().isEmpty()) {
			System.out.println("danh sách phòng học".toUpperCase());
			tieuDe();
			for(PhongHoc phong: dsPhongHoc.layHetDanhSach()) {
				System.out.println(phong);
			}
		}else {
			System.out.println("Danh sách rỗng");
		}

		System.out.println("\n");
	}


	private static void xuatDanhSachPhongDatChuan(DanhSachPhong dsPhongHoc) {
		System.out.println("danh sách phòng học chuẩn".toUpperCase());
		tieuDe();
		for(PhongHoc phong: dsPhongHoc.danhSachPhongDatChuan()) {
			System.out.println(phong);
		}
		System.out.println("\n");
	}

	private static void capNhatMayTinh(DanhSachPhong dsPhongHoc) {
		sc.nextLine();
		System.out.println("Nhập mã phòng máy tính cần cập nhật");
		String checkMaPhongHoc = null;
		String maPhongHoc = nhapChuoi(checkMaPhongHoc, "mã phòng học");
		PhongHoc phongTim = dsPhongHoc.timPhongHoc(maPhongHoc);
		if(phongTim != null) {
			System.out.println("Cập nhật lại số lượng máy tính: ");
			long checkSoLuongMay = 0;
			int soLuongMayTinh = (int) nhapSo(checkSoLuongMay, "số lượng máy tính");
			if(dsPhongHoc.capNhatSoMayTinh(maPhongHoc, soLuongMayTinh)) {
				System.out.println("Cập nhật thành công!");
			}else {
				System.out.println("Mã phòng: "+maPhongHoc+" - Không phải là phòng máy tính");
			}
		}else {
			System.out.println("Mã phòng: "+maPhongHoc+" - Không tồn tại");
		}
		System.out.println("\n");
	}


	private static void xoaMotPhongHoc(DanhSachPhong dsPhongHoc) {
		sc.nextLine();
		System.out.println("Nhập mã cần xóa");
		String checkMaPhongHoc = null;
		String maPhongHoc = nhapChuoi(checkMaPhongHoc, "mã phòng học");
		PhongHoc phongTim = dsPhongHoc.timPhongHoc(maPhongHoc);
		if(phongTim != null) {
			if(dsPhongHoc.xoaPhongHoc(maPhongHoc)) {
				System.out.println("Xóa thành công "+maPhongHoc);
			}else {
				System.out.println("Xóa không thành công "+maPhongHoc);
			}

		}else {
			System.out.println("Mã phòng: "+maPhongHoc+" - Không tồn tại");
		}
		System.out.println("\n");

	}


	private static void inTongSoPhongHoc(DanhSachPhong dsPhongHoc) {
		System.out.println("Tổng số phòng học là: "+ dsPhongHoc.tongSoPhongHoc());
		System.out.println("\n");
	}


	private static void inDanhSachPhongMay60(DanhSachPhong dsPhongHoc) {

		if(!dsPhongHoc.danhSachPhongMayCo60May().isEmpty()) {
			System.out.println("danh sách phòng máy tình có 60 máy".toUpperCase());
			tieuDe();
			for(PhongHoc phong : dsPhongHoc.danhSachPhongMayCo60May()) {
				System.out.println(phong);
			}
		}else {
			System.out.println("Danh sách rỗng");
		}

		System.out.println("\n");
	}

	
	public static long nhapSo(long number, String text) {
		String title = text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
		do {
			try {
				number = sc.nextLong();
			} catch (Exception e) {
				System.out.println(title+ "bạn vừa nhập không phải số");
				throw null;
			}
			if(number < 0) {
				System.out.println(title+" - Không được bé hơn 0!\nNhập lại:");
			}
		}while(number < 0);
		return number;
	}

	public static String nhapChuoi(String str, String text) {
		String title = text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
		do {
			try {
				str = sc.nextLine();
			} catch (Exception e) {
				System.out.println("Something wrong!!");
				throw null;
			}
			if(str == null || str.isEmpty()) {
				System.out.println(title+" - Không được để trống!\nNhập lại:");
			}
		}while(str == null || str.isEmpty());
		return str;
	}
	
}

