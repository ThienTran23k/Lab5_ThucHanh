package Bai1;

public class PhongLyThuyet extends PhongHoc{
	private boolean isMayChieu;

	public boolean isMayChieu() {
		return isMayChieu;
	}

	public void setMayChieu(boolean isMayChieu) {
		this.isMayChieu = isMayChieu;
	}


	public PhongLyThuyet() {
		super();

	}


	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);

	}


	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean isMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.isMayChieu = isMayChieu;
	}
	public String getMayChieu() {
		String chuoi = (this.isMayChieu() == true) ? "Có":"Không";
		return chuoi;
	}
	@Override
	public boolean isDatChuan() {
		if(super.phongDuAnhSang() == true && this.isMayChieu == true) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return super.toString()+String.format(" | %15s | %15s | %-25s | %15s | %-15s | %-20s", this.getMayChieu(),"--","--","--","--","Phòng Lý Thuyết");
	}
	
}

