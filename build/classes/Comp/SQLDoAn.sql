
use QLCH;


create table NhaCungCap
(
	MaNCC				NCHAR(5)					NOT NULL,
	TenNCC				NVARCHAR(40)				NOT NULL,
	DiaChiNCC			NVARCHAR(40),
	SDTNCC				NVARCHAR(10)
)
create table Quyen
(
        MaTK				NCHAR(5)					NOT NULL,
        PhanQuyen                       NVARCHAR(20)                                    NOT NULL
)
create table SanPham
(
	MaSP				NCHAR(5)					NOT NULL,
	TenSP				NVARCHAR(20)                                    NOT NULL,
	Hang				NVARCHAR(20)            			NOT NULL,
	DungLuong			NVARCHAR(20)            			NOT NULL,
	DonGia				INT						NOT NULL,
	SoLuong 			INT						NOT NULL,
        HinhAnh                         NCHAR(100)                                          
)
create table DoanhThu
(
	MaDoanhThu		NCHAR(5)						NOT NULL,
        TongDoanhThu                    int                   
)

create table TaiKhoan
(
	MaTK				NCHAR(5)					NOT NULL,
	TenDangNhap				NCHAR(5)					NOT NULL,
	MatKhau				NVARCHAR(20)				NOT NULL,
	TrangThai					INT							NOT NULL
)

create table NhanVien
(
	MaNV		NCHAR(5)					NOT NULL,
	TenNV			NVARCHAR(40)				NOT NULL,
    GioiTinh        NVARCHAR(10)                                    NOT NULL,
    DiaChiNV			NVARCHAR(100),
	SDTNV				NVARCHAR(20),
	MaTK				NCHAR(5)					NOT NULL
	
)

create table KhachHang
(
	MaKH			NCHAR(5)					NOT NULL,
	TenKH		NVARCHAR(40)				NOT NULL,
	DiaChi				NVARCHAR(100),
	SDT					NVARCHAR(10),
	MaTK				NCHAR(5)					NOT NULL
)

create table ChuongTrinhKhuyenMai
(
	MaCTKM                          NCHAR(5)					NOT NULL,
        TenCTKM                         NVARCHAR(100)                                   NOT NULL,
	MucGiamGia			int,
	LoaiSanPhamDuocApDung		NVARCHAR(100)                                 NOT NULL,
        ThoiGianBatDau			NVARCHAR(100)                                    NOT NULL,
	ThoiGianKetThuc			NVARCHAR(100)                         NOT NULL,
        ThoiGianTaoKM                   NVARCHAR(100)                          NOT NULL,
        MaSP				NCHAR(5)					NOT NULL,                                    
        
	
)

create table HoaDon
(
	MaHoaDon			NCHAR(5)					NOT NULL,
	MaKH				NCHAR(5)					NOT NULL,
	MaNV				NCHAR(5)					NOT NULL,
	NgayLap                         datetime,
        NgayXuat                        datetime,
	TongGiaGoc			int                                             NOT NULL,
        TongGiaSauGiam                  int,
        MaDoanhThu		NCHAR(5)						NOT NULL
        
)

create table CTHoaDon
(
	MaHoaDon			NCHAR(5)					NOT NULL,
	MaSP				NCHAR(5)					NOT NULL,
	TenSP				NVARCHAR(40)				NOT NULL,
	SoLuong				int,
	GiaTien				int
)

create table Kho
(
	MaKho			NCHAR(5)						NOT NULL,
	TenKho			NVARCHAR(40)					NOT NULL,
	DiaChiKho		NVARCHAR(10),
	SDTKho			NVARCHAR(10)
)
create table PhieuNhapKho
(
	MaPhieuNhap		NCHAR(5)						NOT NULL,
	MaKho			NCHAR(5)						NOT NULL,
	NgayNhap		datetime                                               NOT NULL,
	TongTien		int                                                     NOT NULL,
        Thue                    int
)

create table CTPhieuNhapKho
(
	MaPhieuNhap		NCHAR(5)						NOT NULL,
	MaNCC			NCHAR(5)						NOT NULL,	
        SoLuong                         int                                             NOT NULL,
        DonGia                          int                                             NOT NULL,
	Tamtinh			int
)

create table SanPhamNCC
(
        MaNCC				NCHAR(5)					NOT NULL,
	MaSP				NCHAR(5)					NOT NULL

)



--Thiết lập ràng buộc--
--Khóa chính--
alter table HoaDon
	add constraint PK_HoaDon primary key (MaHoaDon)

alter table NhaCungCap
	add constraint PK_NhaCungCap primary key (MaNCC)

alter table SanPham
	add constraint PK_SanPham primary key (MaSP)

alter table NhanVien
	add constraint PK_NhanVien primary key (MaNV)

alter table KhachHang
	add constraint PK_KhachHang primary key (MaKH)

alter table Kho
	add constraint PK_Kho primary key (MaKho)

alter table PhieuNhapKho
	add constraint PK_PhieuNhapKho primary key(MaPhieuNhap)

alter table ChuongTrinhKhuyenMai
	add constraint PK_ChuongTrinhKhuyenMai primary key(MaCTKM)

alter table TaiKhoan
	add constraint PK_TaiKhoan primary key(MaTK)

alter table DoanhThu
	add constraint PK_DoanhThu primary key(MaDoanhThu)

--Khóa ngoại--
alter table HoaDon
	add constraint FK_MaKhachHang_HoaDon foreign key (MaKH) references KhachHang(MaKH)
alter table HoaDon
        add constraint FK_MaNhanVien_HoaDon foreign key (MaNV) references NhanVien(MaNV)
alter table HoaDon 
        add constraint FK_MaDoanhThu_HoaDon foreign key (MaDoanhThu) references DoanhThu(MaDoanhThu)

alter table SanPhamNCC
        add constraint FK_MaNCC_SanPhamNCC  foreign key (MaNCC)    references NhaCungCap(MaNCC)
alter table SanPhamNCC
        add constraint FK_MaSP_SanPhamNCC   foreign key (MaSP)     references SanPham(MaSP)

alter table CTHoaDon 
	add constraint FK_MaHoaDon_CTHoaDon foreign key (MaHoaDon) references HoaDon(MaHoaDon)
alter table CTHoaDon 
	add constraint FK_MaSP_CTHoaDon foreign key (MaSP) references SanPham(MaSP)

alter table KhachHang
	add constraint FK_MaTK_KhachHang foreign key (MaTK) references TaiKhoan(MaTK)

alter table NhanVien
	add constraint FK_MaTK_NhanVien foreign key (MaTK) references TaiKhoan(MaTK)

alter table Quyen   
        add constraint FK_MaTK_Quyen foreign key (MaTK) references TaiKhoan(MaTK)

alter table PhieuNhapKho
	add constraint FK_MaKho_PhieuNhapKho foreign key (MaKho) references Kho(MaKho)

alter table CTPhieuNhapKho
	add constraint FK_MaPhieuNhap_CTPhieuNhapKho foreign key (MaPhieuNhap) references PhieuNhapKho(MaPhieuNhap)
alter table CTPhieuNhapKho
	add constraint FK_MaNCC_CTPhieuNhapKho foreign key (MaNCC) references NhaCungCap(MaNCC)


alter table ChuongTrinhKhuyenMai
	add constraint FK_MaSP_ChuongTrinhKhuyenMai foreign key (MaSP) references SanPham(MaSP)

insert into Kho values('kho01', 'kho tang dia nguc', 'am phu', '00000000');

insert into NhaCungCap values('NCC1', 'apple','dfb', '010892398');
insert into NhaCungCap values('NCC2', 'oppo','qrqư', '01089s398');
insert into NhaCungCap values('NCC3', 'samsung','fwevsd', 'ưdgẻgẻghẻ');
insert into NhaCungCap values('NCC4', 'rog','sjdhf', '01089a398');
insert into NhaCungCap values('NCC5', 'microsoft','ừd', '01089èa398');


insert into SanPham values('sp01', 'oppo dick3', 'oppo', '5000mah', 30000000, 200,'comp/empty.png');
insert into SanPham values('sp02', 'oppo puss', 'oppo', '10000mah', 50000000, 193,'comp/empty.png');
insert into SanPham values('sp03', 'Iphone 25', 'apple', '5000mah', 33000000, 500,'comp/empty.png');
insert into SanPham values('sp04', 'Iphone 25 pro', 'apple', '7000mah', 42000000, 220,'comp/empty.png');
insert into SanPham values('sp05', 'Iphone 25 Pro Max', 'apple', '7000mah', 55000000, 92,'comp/empty.png');
insert into SanPham values('sp06', 'Iphone 25 Plus', 'apple', '5000mah', 35000000, 232,'comp/empty.png');
insert into SanPham values('sp07', 'Iphone 25 mini', 'apple', '3000mah', 24000000, 170,'comp/empty.png');
insert into SanPham values('sp08', 'Iphone 25 Plus Ultra', 'apple', '7000mah', 39000000, 105,'comp/empty.png');
insert into SanPham values('sp09', 'oppo reno 31', 'oppo', '10000mah', 43000000, 167,'comp/empty.png');
insert into SanPham values('sp10', 'Samsung galaxy remake', 'samsung', '3000mah', 12000000, 327,'comp/empty.png');
insert into SanPham values('sp11', 'Samsung olet phone', 'samsung', '6000mah', 22000000, 230,'comp/empty.png');
insert into SanPham values('sp12', 'rog phone 12', 'rog', '20000mah', 84000000, 73,'comp/empty.png');
insert into SanPham values('sp13', 'Iphone kcid 1', 'apple', '6000mah', 27000000, 89,'comp/empty.png');
insert into SanPham values('sp14', 'window phone king return', 'microsoft', '4000mah', 19000000, 70,'comp/empty.png');
insert into SanPham values('sp15', 'rog phỏn', 'rog', '8000mah', 52000000, 241,'comp/empty.png');
insert into SanPham values('sp16', 'window tablet gen 1', 'microsoft', '6000mah', 24000000, 182,'comp/empty.png');


insert into SanPhamNCC values('NCC2', 'sp01');
insert into SanPhamNCC values('NCC2', 'sp02');
insert into SanPhamNCC values('NCC1', 'sp03');
insert into SanPhamNCC values('NCC1', 'sp04');
insert into SanPhamNCC values('NCC1', 'sp05');
insert into SanPhamNCC values('NCC1', 'sp06');
insert into SanPhamNCC values('NCC1', 'sp07');
insert into SanPhamNCC values('NCC1', 'sp08');
insert into SanPhamNCC values('NCC2', 'sp09');
insert into SanPhamNCC values('NCC3', 'sp10');
insert into SanPhamNCC values('NCC3', 'sp11');
insert into SanPhamNCC values('NCC4', 'sp12');
insert into SanPhamNCC values('NCC1', 'sp13');
insert into SanPhamNCC values('NCC5', 'sp14');
insert into SanPhamNCC values('NCC4', 'sp15');
insert into SanPhamNCC values('NCC5', 'sp16');



insert into PhieuNhapKho values('pn01', 'kho01', '02-03-2023', 30000, 15);
insert into PhieuNhapKho values('pn02', 'kho01', '12-05-2023', 40000, 10);
insert into PhieuNhapKho values('pn03', 'kho01', '03-11-2023', 50000, 15);
insert into PhieuNhapKho values('pn04', 'kho01', '09-22-2023', 60000, 10);
insert into PhieuNhapKho values('pn05', 'kho01', '07-15-2023', 70000, 15);

insert into CTPhieuNhapKho values('pn01', 'NCC2', 6, 23000, 138000);
insert into CTPhieuNhapKho values('pn01', 'NCC3', 3, 10000, 30000);
insert into CTPhieuNhapKho values('pn01', 'NCC5', 2, 100000, 200000);
insert into CTPhieuNhapKho values('pn02', 'NCC1', 4, 2000, 8000);
insert into CTPhieuNhapKho values('pn02', 'NCC4', 5, 1000000, 5000000);
