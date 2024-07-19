//package fplhn.udpm.tooldugio.infrastructure.config.dbgenerator;
//
//import fplhn.udpm.quanlygiangvien.entity.CoSo;
//import fplhn.udpm.quanlygiangvien.infrastructure.constant.XoaMem;
//import fplhn.udpm.quanlygiangvien.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//@Component
//public class DBGenConfig {
//
//    @Autowired
//    private BlockRepository blockRepository;
//
//    @Autowired
//    private BoMonRepository boMonRepository;
//
//    @Autowired
//    private BoMonTheoCoSoRepository boMonTheoCoSoRepository;
//
//    @Autowired
//    private ChucVuRepository chucVuRepository;
//
//    @Autowired
//    private ChuyenNganhRepository chuyenNganhRepository;
//
//    @Autowired
//    private ChuyenNganhTheoCoSoRepository chuyenNganhTheoCoSoRepository;
//
//    @Autowired
//    private CampusRepository coSoConRepository;
//
//    @Autowired
//    private CoSoRepository coSoRepository;
//
//    @Autowired
//    private QLGiaoVienDayMonRepository giaoVienDayMonRepository;
//
//    @Autowired
//    private HocKyRepository hocKyRepository;
//
//    @Autowired
//    private LopMonRepository lopMonRepository;
//
//    @Autowired
//    private MonHocRepository monHocRepository;
//
//    @Autowired
//    private NhanVienRepository nhanVienRepository;
//
//    @Autowired
//    private NhanVienChucVuRepository nhanVienChucVuRepository;
//
//    // more @Autowired
//
//    // cấu hình
//
//    /**
//     * thêm cơ sở con
//     */
//    private static class CoSoInfo {
//        String tenCoSoTo;
//        String[] tenCoSoCon;
//
//        CoSoInfo(String tenCoSoTo, String... tenCoSoCon) {
//            this.tenCoSoTo = tenCoSoTo;
//            this.tenCoSoCon = tenCoSoCon;
//        }
//    }
//
//    List<CoSoInfo> coSoInfos = Arrays.asList(
//            new CoSoInfo("Đà Nẵng", "Đà Nẵng"),
//            new CoSoInfo("Hà Nội", "Hà Nội 1", "Hà Nội 2", "Hà Nội 3", "Hà Nội 4"),
//            new CoSoInfo("Hồ Chí Minh", "Hồ Chí Minh 1", "Hồ Chí Minh 2", "Hồ Chí Minh 3"),
//            new CoSoInfo("Cần Thơ", "Cần Thơ"),
//            new CoSoInfo("Tây Nguyên", "Tây Nguyên")
//    );
//
//    private static class ChuyenNganhInfo {
//        String tenBoMon;
//        String[] tenChuyenNganh;
//
//        ChuyenNganhInfo(String tenBoMon, String... tenChuyenNganh) {
//            this.tenBoMon = tenBoMon;
//            this.tenChuyenNganh = tenChuyenNganh;
//        }
//    }
//
//    List<ChuyenNganhInfo> chuyenNganhInfos = Arrays.asList(
//            new ChuyenNganhInfo("Công nghệ thông tin", "Lập trình Web", "Phát triển phần mềm", "Lập trình Mobile", "Lập trình Game", "Xử lý dữ liệu", "Ứng dụng phần mềm"),
//            new ChuyenNganhInfo("Quản trị kinh doanh", "Marketing & Sales", "Quan hệ công chúng & Tổ chức sự kiện", "Digital Marketing", "Quản trị Khách sạn - Nhà hàng", "Quản trị Dịch vụ du lịch & Lữ hành.", "Logistics"),
//            new ChuyenNganhInfo("Công nghệ kỹ thuật điều khiển và Tự động hoá", "CN kỹ thuật điều khiển và tự động hóa", "Công nghệ kỹ thuật điện, điện tử", "Điện công nghiệp"),
//            new ChuyenNganhInfo("Ngành khác", "Công nghệ kỹ thuật cơ khí", "Thiết kế đồ hoạ", "Dược (dự kiến)", "Chip & Bán dẫn (dự kiến)"),
//            new ChuyenNganhInfo("Thẩm mỹ làm đẹp", "Chăm sóc da và spa", "Trang điểm nghệ thuật", "Phun thêu thẩm mỹ", "Công nghệ móng")
//    );
//
//
//    private static class MonHocInfo {
//        String tenMonHoc;
//        String maMonHoc;
//
//        MonHocInfo(String tenMonHoc, String maMonHoc) {
//            this.tenMonHoc = tenMonHoc;
//            this.maMonHoc = maMonHoc;
//        }
//    }
//
//    public static class MonHocInfos {
//        String tenBoMon;
//        List<MonHocInfo>[] monHocList;
//
//        MonHocInfos(String tenBoMon, List<MonHocInfo>... monHocLists) {
//            this.tenBoMon = tenBoMon;
//            this.monHocList = monHocLists;
//        }
//    }
//
//    List<MonHocInfo> danhSachMonHocCNTT = Arrays.asList
//            (
//                    new
//
//                            MonHocInfo("Tin học", "COM1071"),
//                    new
//
//                            MonHocInfo("Cơ sở dữ liệu", "COM2012"),
//                    new
//
//                            MonHocInfo("Lập trình C cho Arduino", "IOT101"),
//                    new
//
//                            MonHocInfo("Thiết bị điện tử IOT cơ bản", "IOT102"),
//                    new
//
//                            MonHocInfo("Lập trình IOT cơ bản", "IOT201"),
//                    new
//
//                            MonHocInfo("Lập trình IOT nâng cao", "IOT202"),
//                    new
//
//                            MonHocInfo("Lập trình Android cơ bản", "MOB1032"),
//                    new
//
//                            MonHocInfo("Lập trình Android nâng cao", "MOB201"),
//                    new
//
//                            MonHocInfo("Thiết kế giao diện trên Android", "MOB202"),
//                    new
//
//                            MonHocInfo("Dự án mẫu (LTMT)", "MOB2041"),
//                    new
//
//                            MonHocInfo("Lập trình game 2D", "MOB305"),
//                    new
//
//                            MonHocInfo("Lập trình Mobile đa nền tảng", "MOB306"),
//                    new
//
//                            MonHocInfo("Lập trình game 2D nâng cao", "MOB401"),
//                    new
//
//                            MonHocInfo("Lập trình server cho Android", "MOB402"),
//                    new
//
//                            MonHocInfo("Android Networking", "MOB403"),
//                    new
//
//                            MonHocInfo("Dự án 1 (TKTW)", "PRO1014"),
//                    new
//
//                            MonHocInfo("Dự án 1 (LTMT)", "PRO1121"),
//                    new
//
//                            MonHocInfo("Dự án Tốt nghiệp - LTMT (Mobile)", "PRO2052"),
//                    new
//
//                            MonHocInfo("Dự án Tốt nghiệp - TKTW (SPA)", "PRO220"),
//                    new
//
//                            MonHocInfo("Dự án Tốt nghiệp - LTMT (IoT)", "PRO222"),
//                    new
//
//                            MonHocInfo("Dự án tốt nghiệp - TKTW (PHP Framework)", "PRO224"),
//                    new
//
//                            MonHocInfo("Xây dựng trang web", "WEB1013"),
//                    new
//
//                            MonHocInfo("Quản trị website", "WEB1022"),
//                    new
//
//                            MonHocInfo("Lập trình cơ sở với JavaScript", "WEB1043"),
//                    new
//
//                            MonHocInfo("Lập trình PHP 1", "WEB2014"),
//                    new
//
//                            MonHocInfo("Kỹ thuật trình bày nội dung Web", "WEB2022"),
//                    new
//
//                            MonHocInfo("Xây dựng trang web 2", "WEB2033"),
//                    new
//
//                            MonHocInfo("Dự án mẫu (TKTW)", "WEB2041"),
//                    new
//
//                            MonHocInfo("Marketing trên Internet", "WEB2053"),
//                    new
//
//                            MonHocInfo("Lập trình Javascript nâng cao", "WEB2061"),
//                    new
//
//                            MonHocInfo("Front-End Frameworks", "WEB207"),
//                    new
//
//                            MonHocInfo("Lập trình Front-End Framework 1", "WEB208"),
//                    new
//
//                            MonHocInfo("Lập trình Front-End Framework 2", "WEB209"),
//                    new
//
//                            MonHocInfo("Lập trình PHP 2", "WEB3014"),
//                    new
//
//                            MonHocInfo("Thiết kế web với HTML5 & CSS3", "WEB3023"),
//                    new
//
//                            MonHocInfo("Lập trình PHP 3", "WEB4013"),
//                    new
//
//                            MonHocInfo("Lập trình ECMAScript", "WEB501"),
//                    new
//
//                            MonHocInfo("Lập trình TypeScript", "WEB502"),
//                    new
//
//                            MonHocInfo("NodeJS & Restful Web Service", "WEB503")
//            );
//
//    List<MonHocInfo> danhSachMonHocCoBan = Arrays.asList(
//            new MonHocInfo("Phát triển cá nhân 1", "PDP101"),
//            new MonHocInfo("Phát triển cá nhân 2", "PDP201"),
//            new MonHocInfo("Kỹ năng học tập", "SKI1014"),
//            new MonHocInfo("Kỹ năng làm việc", "SKI2015"),
//            new MonHocInfo("Chính trị", "VIE1016"),
//            new MonHocInfo("Pháp luật", "VIE1026"),
//            new MonHocInfo("Giáo dục thể chất", "VIE103")
//    );
//
//
//    List<MonHocInfo> danhSachMonHocDuLich = Arrays.asList(
//            new MonHocInfo("Kế toán khách sạn nhà hàng", "ACC105"),
//            new MonHocInfo("Thực hành phần mềm quản lý KS-NH", "COM1062"),
//            new MonHocInfo("Cơ sở văn hóa Việt Nam", "HIS1011"),
//            new MonHocInfo("Lịch sử văn minh Việt Nam và Thế giới", "HIS1021"),
//            new MonHocInfo("Nghiệp vụ lễ tân", "HOS1011"),
//            new MonHocInfo("Thực hành nghiệp vụ lễ tân", "HOS1021"),
//            new MonHocInfo("Nghiệp vụ nhà hàng", "HOS1031"),
//            new MonHocInfo("Thực hành nghiệp vụ nhà hàng", "HOS1041"),
//            new MonHocInfo("An toàn & an ninh trong nhà hàng khách sạn", "HOS105"),
//            new MonHocInfo("Nhập môn quản trị du lịch nhà hàng khách sạn", "HOS106"),
//            new MonHocInfo("Nghiệp vụ lưu trú", "HOS2011"),
//            new MonHocInfo("Thực hành nghiệp vụ lưu trú", "HOS2021"),
//            new MonHocInfo("Nghiệp vụ Bar", "HOS2031"),
//            new MonHocInfo("Thực hành nghiệp vụ Bar", "HOS2041"),
//            new MonHocInfo("Thiết kế thực đơn và phát triển sản phẩm ẩm thực", "HOS3011"),
//            new MonHocInfo("Quản trị kinh doanh nhà hàng", "HOS302"),
//            new MonHocInfo("Quản trị dạ tiệc và hội nghị", "HOS3031"),
//            new MonHocInfo("Thực hành nghiệp vụ lưu trú nâng cao", "HOS304"),
//            new MonHocInfo("Thực hành nghiệp vụ nhà hàng nâng cao", "HOS305"),
//            new MonHocInfo("Quản trị khách sạn", "HOS4011"),
//            new MonHocInfo("Quản trị các dịch vụ giải trí trong khách sạn", "HOS4021"),
//            new MonHocInfo("Quản trị chất lượng dịch vụ", "HOS4031"),
//            new MonHocInfo("Thực tập doanh nghiệp (HDDL)", "PRO1051"),
//            new MonHocInfo("Thực tập doanh nghiệp (QTNH)", "PRO1071"),
//            new MonHocInfo("Thực tập doanh nghiệp (QTKS)", "PRO1081"),
//            new MonHocInfo("Dự án tốt nghiệp (HDDL)", "PRO2071"),
//            new MonHocInfo("Dự án tốt nghiệp (QTKS)", "PRO2091"),
//            new MonHocInfo("Dự án tốt nghiệp (QTNH)", "PRO2101"),
//            new MonHocInfo("Tâm lý và kỹ năng giao tiếp, ứng xử với khách hàng", "PSY1011"),
//            new MonHocInfo("Tổng quan DLNHKS", "TOU1011"),
//            new MonHocInfo("Địa lý và tài nguyên du lịch Việt Nam", "TOU1021"),
//            new MonHocInfo("Tuyến điểm du lịch 1", "TOU1031"),
//            new MonHocInfo("Di tích lịch sử văn hóa Việt Nam", "TOU1061"),
//            new MonHocInfo("Kỹ năng hoạt náo trong du lịch", "TOU107"),
//            new MonHocInfo("Nghiệp vụ tổ chức sự kiện", "TOU2013"),
//            new MonHocInfo("Tuyến điểm du lịch 2", "TOU2021"),
//            new MonHocInfo("Nghiệp vụ hướng dẫn 1", "TOU2031"),
//            new MonHocInfo("Thực hành nghiệp vụ hướng dẫn 1", "TOU2041"),
//            new MonHocInfo("Nghiệp vụ hướng dẫn 2", "TOU3011"),
//            new MonHocInfo("Thực hành nghiệp vụ hướng dẫn 2", "TOU302"),
//            new MonHocInfo("Tổ chức, thực hiện các loại hình Du lịch đặc thù", "TOU4011"),
//            new MonHocInfo("Điều hành chương trình du lịch", "TOU4021")
//    );
//
//    List<MonHocInfo> danhSachMonHocTMĐT = Arrays.asList(
//            new MonHocInfo("Nhập môn digital Marketing", "DOM101"),
//            new MonHocInfo("Email Marketing", "DOM1021"),
//            new MonHocInfo("Marketing nội dung", "DOM1031"),
//            new MonHocInfo("Công cụ tiện ích", "DOM104"),
//            new MonHocInfo("Marketing mạng xã hội", "DOM105"),
//            new MonHocInfo("Seo & Marketing trên công cụ tìm kiếm", "DOM107"),
//            new MonHocInfo("Tổng quan thương mại điện tử", "DOM1081"),
//            new MonHocInfo("Marketing trên di động", "DOM201"),
//            new MonHocInfo("Hoạch định chiến lược Marketing số", "DOM202"),
//            new MonHocInfo("Kỹ thuật phân tích và tổng hợp", "DOM203"),
//            new MonHocInfo("Dự án 1 (TMĐT)", "PRO1131"),
//            new MonHocInfo("Dự án tốt nghiệp (TMĐT)", "PRO2121")
//    );
//
//    List<MonHocInfo> danhSachMonHocTiengAnh = Arrays.asList(
//            new MonHocInfo("Tiếng anh chuyên ngành 1 (NHKS)", "EHO102"),
//            new MonHocInfo("Tiếng anh chuyên ngành 2 (NHKS)", "EHO202"),
//            new MonHocInfo("Tiếng Anh 1.1", "ENT1126"),
//            new MonHocInfo("Tiếng Anh 1.2", "ENT1225"),
//            new MonHocInfo("Tiếng Anh 2.1", "ENT2125"),
//            new MonHocInfo("Tiếng Anh 2.2", "ENT2225"),
//            new MonHocInfo("Tiếng anh chuyên ngành 1 (DL)", "ETO101"),
//            new MonHocInfo("Tiếng anh chuyên ngành 2 (DL)", "ETO201")
//    );
//
//
//    List<MonHocInfo> danhSachMonHocTuDongHoa = Arrays.asList(
//            new MonHocInfo("Mạch điện và an toàn điện", "AUT102"),
//            new MonHocInfo("Điện tử cơ bản", "AUT103"),
//            new MonHocInfo("Thiết kế mạch điện - điện tử", "AUT104"),
//            new MonHocInfo("Kỹ thuật xung số", "AUT105"),
//            new MonHocInfo("Mạch điện tử và ứng dụng", "AUT106"),
//            new MonHocInfo("Lắp đặt hệ thống điện", "AUT107"),
//            new MonHocInfo("Lắp đặt tủ điện công nghiệp", "AUT108"),
//            new MonHocInfo("Lý thuyết điều khiển tự động", "AUT109"),
//            new MonHocInfo("Kỹ thuật cảm biến", "AUT110"),
//            new MonHocInfo("Kỹ thuật số", "AUT111"),
//            new MonHocInfo("PLC cơ bản", "AUT206"),
//            new MonHocInfo("PLC nâng cao", "AUT207"),
//            new MonHocInfo("Lập trình Arduino", "AUT208"),
//            new MonHocInfo("Mạng Truyền thông công nghiệp", "AUT209"),
//            new MonHocInfo("Thiết kế bằng phần mềm", "AUT210"),
//            new MonHocInfo("Điều khiển thủy lực & khí nén", "AUT211"),
//            new MonHocInfo("Lập trình nhúng", "AUT212"),
//            new MonHocInfo("Năng lượng tái tạo", "AUT213"),
//            new MonHocInfo("Tự động hóa quá trình công nghệ", "AUT214"),
//            new MonHocInfo("Phát triển ứng dụng IoTs", "AUT215"),
//            new MonHocInfo("Robot công nghiệp", "AUT216"),
//            new MonHocInfo("Robot di động", "AUT217"),
//            new MonHocInfo("Mạch điện", "INE101"),
//            new MonHocInfo("Vật liệu điện - An toàn điện", "INE102"),
//            new MonHocInfo("Thực hành điện cơ bản", "INE104"),
//            new MonHocInfo("Khí cụ điện", "INE106"),
//            new MonHocInfo("Trang bị điện", "INE109"),
//            new MonHocInfo("Kỹ thuật mạch điện tử", "INE110"),
//            new MonHocInfo("Kỹ thuật đo lường và cảm biến", "INE113"),
//            new MonHocInfo("Máy điện", "INE114"),
//            new MonHocInfo("Điện tử công suất", "INE115"),
//            new MonHocInfo("Truyền động điện", "INE202"),
//            new MonHocInfo("Điều khiển điện - khí nén", "INE203"),
//            new MonHocInfo("Cung cấp điện", "INE205"),
//            new MonHocInfo("Tính toán sửa chữa máy điện", "INE212"),
//            new MonHocInfo("Vi điều khiển", "INE214"),
//            new MonHocInfo("Lập trình cỡ nhỏ", "INE215"),
//            new MonHocInfo("Vẽ thiết kế mạch điện - điện tử", "INE216"),
//            new MonHocInfo("Hệ thống năng lượng tái tạo", "INE217"),
//            new MonHocInfo("Phát triển ứng dụng của IOT", "INE218"),
//            new MonHocInfo("Kỹ thuật lập trình PLC", "INE220"),
//            new MonHocInfo("Tự động hóa trong sản xuất", "INE221"),
//            new MonHocInfo("Vẽ thiết kế điện", "INE222"),
//            new MonHocInfo("Sửa chữa, bảo chì thiết bị điện, điện tử", "INE223"),
//            new MonHocInfo("Lắp đặt và điều khiển hệ thống điện công nghiệp", "INE224")
//    );
//
//    List<MonHocInfo> danhSachMonHocDoHoa = Arrays.asList(
//            new MonHocInfo("Thiết kế hình ảnh với Photoshop", "MUL1013"),
//            new MonHocInfo("Thiết kế minh họa với Illustrator", "MUL1024"),
//            new MonHocInfo("Luật xa gần và bố cục trong thiết kế đồ họa", "MUL1143"),
//            new MonHocInfo("Nhập môn đồ họa", "MUL116"),
//            new MonHocInfo("Kỹ thuật nhiếp ảnh", "MUL117"),
//            new MonHocInfo("Chế bản điện tử với InDesign", "MUL2111"),
//            new MonHocInfo("Thiết kế bao bì", "MUL2123"),
//            new MonHocInfo("Nghệ thuật chữ", "MUL2133"),
//            new MonHocInfo("Màu sắc", "MUL2143"),
//            new MonHocInfo("Kỹ thuật in", "MUL215"),
//            new MonHocInfo("Thiết kế đa truyền thông với Animate", "MUL216"),
//            new MonHocInfo("Ý tưởng sáng tạo", "MUL217"),
//            new MonHocInfo("Nguyên lý thiết kế nội thất", "MUL218"),
//            new MonHocInfo("Kịch bản phân cảnh và quay phim", "MUL219"),
//            new MonHocInfo("Xử lý phim với Adobe Premiere", "MUL220"),
//            new MonHocInfo("Thiết kế phối cảnh nội thất với 3D Max", "MUL2211"),
//            new MonHocInfo("Dựng hình với Maya 3D", "MUL222"),
//            new MonHocInfo("Chuyên đề 1: Thiết kế đồ họa động với 3D Studio Max", "MUL311"),
//            new MonHocInfo("Chuyên đề 1: Xử lý hậu kỳ với Adobe Premiere", "MUL3151"),
//            new MonHocInfo("Autocad 2D", "MUL317"),
//            new MonHocInfo("Chuyên đề 2: Cinema4D", "MUL318"),
//            new MonHocInfo("Thiết kế thương hiệu và marketing", "MUL3191"),
//            new MonHocInfo("Chuyên đề 2: Thiết kế tạo hình nhân vật Maya 3D", "MUL320"),
//            new MonHocInfo("Hiệu ứng kỹ xảo với Adobe After Effect", "MUL3211"),
//            new MonHocInfo("Dựng phối cảnh với SketchUp", "MUL322"),
//            new MonHocInfo("Dự án 1 (TKĐH)", "PRO1112"),
//            new MonHocInfo("Dự án Tốt nghiệp - TKĐH (Phim và Quảng cáo)", "PRO221"),
//            new MonHocInfo("Dự án tốt nghiệp - TKĐH (Nội và ngoại thất)", "PRO223")
//    );
//
//    List<MonHocInfo> danhSachMonHocUngDungPhanMem = Arrays.asList(
//            new MonHocInfo("Tin học cơ sở", "COM1014"),
//            new MonHocInfo("Nhập môn lập trình", "COM108"),
//            new MonHocInfo("Quản trị cơ sở dữ liệu với SQL Server", "COM2034"),
//            new MonHocInfo("Lập trình Java 1", "MOB1014"),
//            new MonHocInfo("Lập trình Java 2", "MOB1023"),
//            new MonHocInfo("Quản lý dự án với phần mềm (Agile)", "MOB104"),
//            new MonHocInfo("Lập trình C#1", "NET101"),
//            new MonHocInfo("Lập trình C#2", "NET102"),
//            new MonHocInfo("Lập trình C#3", "NET103"),
//            new MonHocInfo("Lập trình C#4", "NET104"),
//            new MonHocInfo("Lập trình C#5", "NET105"),
//            new MonHocInfo("Lập trình C#6", "NET106"),
//            new MonHocInfo("Dự án 1 (UDPM.Java)", "PRO1041"),
//            new MonHocInfo("Dự án 1 (UDPM.NET)", "PRO131"),
//            new MonHocInfo("Dự án Tốt nghiệp - UDPM (Spring Boot)", "PRO2112"),
//            new MonHocInfo("Dự án Tốt nghiệp - UDPM (NETCORE)", "PRO219"),
//            new MonHocInfo("Nhập môn kỹ thuật phần mềm", "SOF102"),
//            new MonHocInfo("Lập trình Java 3", "SOF203"),
//            new MonHocInfo("Dự án mẫu (UDPM.Java)", "SOF2041"),
//            new MonHocInfo("Dự án mẫu (UDPM.NET)", "SOF205"),
//            new MonHocInfo("Lập trình Java 4", "SOF3011"),
//            new MonHocInfo("Lập trình Java 5", "SOF3021"),
//            new MonHocInfo("Kiểm thử cơ bản", "SOF3031"),
//            new MonHocInfo("Kiểm thử nâng cao", "SOF304"),
//            new MonHocInfo("Lập trình Java 6", "SOF306"),
//            new MonHocInfo("Cấu trúc dữ liệu và giải thuật", "SOF307")
//    );
//
//    List<MonHocInfos> monHocInfos = Arrays.asList(
//            new MonHocInfos("Quản trị kinh doanh", danhSachMonHocDuLich, danhSachMonHocTMĐT),
//            new MonHocInfos("Công nghệ kỹ thuật điều khiển và Tự động hoá", danhSachMonHocTuDongHoa),
//            new MonHocInfos("Ngành khác", danhSachMonHocTiengAnh),
//            new MonHocInfos("Thẩm mỹ làm đẹp", danhSachMonHocCoBan),
//            new MonHocInfos("Công nghệ thông tin", danhSachMonHocDoHoa, danhSachMonHocCNTT, danhSachMonHocUngDungPhanMem)
//    );
//
//    String[] tenCoSoTo = {
//            "Đà Nẵng",
//            "Hà Nội",
//            "Hồ Chí Minh",
//            "Cần Thơ",
//            "Tây Nguyên",
//            "Hải Phòng",
//            "Đồng Nai",
//            "Bắc Giang",
//            "Thừa Thiên Huế",
//            "Thái Nguyên",
//            "Bình Định",
//            "Bình Dương",
//            "Hà Nam",
//            "Vĩnh Phúc",
//            "Thanh Hóa",
//            "Quảng Nam",
//            "Bình Phước",
//            "Bà Rịa Vũng Tàu",
//            "Nghệ An",
//            "Nam Định",
//            "Nha Trang"
//    };
//
//    String[] tenBoMonCNTT = {
//            "Công nghệ thông tin",
//            "Quản trị kinh doanh",
//            "Công nghệ kỹ thuật điều khiển và Tự động hoá",
//            "Ngành khác",
//            "Thẩm mỹ làm đẹp",
//    };
//
//    String[] tenHocKy = {
//            "SPRING",
//            "SUMMER",
//            "FALL"
//    };
//
//    String[] tenChucVu = {
//            "TRUONG_MON",
//            "CHU_NHIEM_BO_MON",
//            "TRUONG_BAN_DAO_TAO",
//            "BAN_DAO_TAO",
//            "GIANG_VIEN_DI_DU_GIO",
//            "GIANG_VIEN_DUOC_DU_GIO",
//            "TO_CHUC_VA_QUAN_LY_DAO_TAO"
//    };
//
//    String[] tenGmailFpt = {
//            "nghiaxlxx@fpt.edu.vn",
//            "nghiathph32178@fpt.edu.vn",
//            "hieunmph42056@fpt.edu.vn",
//            "luatlvph31971@fpt.edu.vn",
//            "cuongnbph35909@fpt.edu.vn",
//            "hangnt169@fpt.edu.vn",
//            "dungna29@fpt.edu.vn",
//            "tiennh21@fpt.edu.vn",
//            "nganct6@fpt.edu.vn",
//            "admin@fpt.edu.vn"
//    };
//
//    String[] tenGmailFe = {
//            "nghiaxlxx@fe.edu.vn",
//            "nghiathph32178@fe.edu.vn",
//            "hieunmph42056@fe.edu.vn",
//            "luatlvph31971@fe.edu.vn",
//            "cuongnbph35909@fe.edu.vn",
//            "hangnt169@fe.edu.vn",
//            "dungna29@fe.edu.vn",
//            "tiennh21@fe.edu.vn",
//            "nganct6@fe.edu.vn",
//            "admin@fe.edu.vn"
//    };
//
//    String[] maNhanVien = {
//            "nghiaxlxx",
//            "nghiathph32178",
//            "hieunmph42056",
//            "luatlvph31971",
//            "cuongnbph35909",
//            "hangnt169",
//            "dungna29",
//            "tiennh21",
//            "nganct6",
//            "admin"
//    };
//
//    String[] tenNhanVien = {
//            "Trịnh Hiếu Nghĩa XLXX",
//            "Trịnh Hiếu Nghĩa",
//            "Nguyễn Minh Hiếu",
//            "Lục Văn Luật",
//            "Nguyễn Bá Cường",
//            "Nguyễn Thúy Hằng",
//            "Nguyễn Anh Dũng",
//            "Nguyễn Hoàng Tiến",
//            "Chu Thị Ngân",
//            "ADMIN"
//    };
//
//    /**
//     * main chạy
//     *
//     * @throws Exception
//     */
////    @PostConstruct
//    private void GeneratorData() throws Exception {
//
//        dataCoSo();
//
//        dataCoSoCon();
//
//        dataBoMon();
//
//        dataBoMonTheoCoSo();
//
//        dataChuyenNganh();
//
//        dataChucVu();
//
//        dataHocKy();
//
//        dataBlock();
//
//        dataNhanVien();
//
//        dataBoMonCoSoChuNhiem();
//
//        dataChuyenNganhTheoCoSo();
//
//        dataMonHoc();
//
//        dataGiaoVienDayMon();
//
//        dataLopMon();
//
//        dataTaiKhoanFPT();
//
//        dataModule();
//
//        dataTaiNguyen();
//
//        dataQuyen();
//
//        dataQuyenTaiKhoan();
//
//        dataNhanVienChucVu();
//
//    }
//
//    /**
//     * Cơ sở to
//     *
//     * @throws Exception
//     */
//
//    private void dataCoSo() throws Exception {
//
//        // Thêm từng Bộ môn vào cơ sở dữ liệu
//        for (String ten : tenCoSoTo) {
//            CoSo coSo = new CoSo();
//            coSo.setTen(ten);
//            coSo.setXoaMem(XoaMem.CHUA_XOA);
//            coSoRepository.save(coSo);
//        }
//    }
//
//    /**
//     * Cơ sở con
//     *
//     * @throws Exception
//     */
//
//    private void dataCoSoCon() throws Exception {
//
//        for (CoSoInfo coSoInfo : coSoInfos) {
//            CoSo coSoTo = coSoConRepository.findByTen(coSoInfo.tenCoSoTo);
//
//            // Thêm cơ sở con
//            for (String tenCoSoCon : coSoInfo.tenCoSoCon) {
//                CoSoCon coSoCon = new CoSoCon();
//                coSoCon.setTen(tenCoSoCon);
//                coSoCon.setCoSo(coSoTo);
//                coSoCon.setXoaMem(XoaMem.CHUA_XOA);
//                coSoConRepository.save(coSoCon);
//            }
//        }
//
//    }
//
//    /**
//     * Bộ môn
//     *
//     * @throws Exception
//     */
//
//    private void dataBoMon() throws Exception {
//
//        // Thêm từng Bộ môn vào cơ sở dữ liệu
//        for (String ten : tenBoMonCNTT) {
//            BoMon boMon = new BoMon();
//            boMon.setTen(ten);
//            boMon.setXoaMem(XoaMem.CHUA_XOA);
//            boMonRepository.save(boMon);
//        }
//
//    }
//
//    /**
//     * Chuyên ngành
//     *
//     * @throws Exception
//     */
//
//    private void dataChuyenNganh() throws Exception {
//
//        for (ChuyenNganhInfo chuyenNganhInfo : chuyenNganhInfos) {
//            BoMon boMon = dbBoMonRepository.findByTen(chuyenNganhInfo.tenBoMon);
//
//            // Thêm chuyên ngành
//            for (String tenChuyenNganh : chuyenNganhInfo.tenChuyenNganh) {
//                ChuyenNganh chuyenNganh = new ChuyenNganh();
//                chuyenNganh.setTen(tenChuyenNganh);
//                chuyenNganh.setBoMon(boMon);
//                chuyenNganh.setXoaMem(XoaMem.CHUA_XOA);
//                chuyenNganhRepository.save(chuyenNganh);
//            }
//        }
//
//    }
//
//    /**
//     * Chức vụ
//     *
//     * @throws Exception
//     */
//
//    private void dataChucVu() throws Exception {
//
//        for (String ten : tenCoSoTo) {
//            CoSo coSo = dbCoSoRepository.findByTen(ten);
//
//            // Thêm chức vụ
//            ChucVu chucVu1 = new ChucVu();
//            chucVu1.setCoSo(coSo);
//            chucVu1.setTen("GIANG_VIEN");
//            chucVu1.setXoaMem(XoaMem.CHUA_XOA);
//            chucVuRepository.save(chucVu1);
//
//            ChucVu chucVu2 = new ChucVu();
//            chucVu2.setCoSo(coSo);
//            chucVu2.setTen("CHU_NHIEM_BO_MON");
//            chucVu2.setXoaMem(XoaMem.CHUA_XOA);
//            chucVuRepository.save(chucVu2);
//
//            ChucVu chucVu3 = new ChucVu();
//            chucVu3.setCoSo(coSo);
//            chucVu3.setTen("ADMIN");
//            chucVu3.setXoaMem(XoaMem.CHUA_XOA);
//            chucVuRepository.save(chucVu3);
//
//            ChucVu chucVu4 = new ChucVu();
//            chucVu4.setCoSo(coSo);
//            chucVu4.setTen("TRUONG_MON");
//            chucVu4.setXoaMem(XoaMem.CHUA_XOA);
//            chucVuRepository.save(chucVu4);
//
//        }
//    }
//
//    /**
//     * data Học Kỳ
//     *
//     * @throws Exception
//     */
//
//    /**
//     * Date Học kỳ
//     *
//     * @param year
//     * @param month
//     * @return
//     */
//
//    private Date getStartDateHocKy(int year, int month) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, 1, 0, 0, 0); // Đặt thời gian vào ngày đầu tiên của tháng
//        return calendar.getTime();
//    }
//
//    /**
//     * Học kỳ
//     *
//     * @throws Exception
//     */
//
//    private void dataHocKy() throws Exception {
//        for (Long iL = 1950L; iL <= 2025L; iL++) {
//            HocKy spring = new HocKy();
//            spring.setNam(iL);
//            spring.setTen(TenHocKy.SPRING);
//            spring.setXoaMem(XoaMem.CHUA_XOA);
//            spring.setThoiGianBatDau(DateTimeUtil.convertDateToTimeStampSecond(getStartDateHocKy(iL.intValue(), Calendar.JANUARY)));
//            hocKyRepository.save(spring);
//
//            HocKy summer = new HocKy();
//            summer.setNam(iL);
//            summer.setTen(TenHocKy.SUMMER);
//            summer.setXoaMem(XoaMem.CHUA_XOA);
//            summer.setThoiGianBatDau(DateTimeUtil.convertDateToTimeStampSecond(getStartDateHocKy(iL.intValue(), Calendar.APRIL)));
//            hocKyRepository.save(summer);
//
//            HocKy fall = new HocKy();
//            fall.setNam(iL);
//            fall.setTen(TenHocKy.FALL);
//            fall.setXoaMem(XoaMem.CHUA_XOA);
//            fall.setThoiGianBatDau(DateTimeUtil.convertDateToTimeStampSecond(getStartDateHocKy(iL.intValue(), Calendar.AUGUST)));
//            hocKyRepository.save(fall);
//        }
//    }
//
//    /**
//     * data Block
//     */
//
//    /**
//     * Date block
//     *
//     * @param year
//     * @param month
//     * @return
//     */
//
//    private Date getStartDateBlock1(int year, int month) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, 1, 0, 0, 0); // Đặt thời gian vào ngày đầu tiên của tháng
//        return calendar.getTime();
//    }
//
//    private Date getEndDateBlock1(int year, int month) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, 28, 0, 0, 0); // Đặt thời gian vào ngày đầu tiên của tháng
//        return calendar.getTime();
//    }
//
//    private Date getStartDateBlock2(int year, int month) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, 1, 0, 0, 0); // Đặt thời gian vào ngày đầu tiên của tháng
//        return calendar.getTime();
//    }
//
//    private Date getEndDateBlock2(int year, int month) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, 30, 0, 0, 0); // Đặt thời gian vào ngày đầu tiên của tháng
//        return calendar.getTime();
//    }
//
//    /**
//     * Block
//     *
//     * @throws Exception
//     */
//    private void dataBlock() throws Exception {
//
//        for (String ten : tenHocKy) {
//
//            Long i;
//
//            for (i = 2020L; i <= 2025L; i++) {
//                Optional<HocKy> hocKy = dbHocKyRepository.findByTenAndNam(ten, i);
//
//                if (ten.equals("SPRING")) {
//                    if (hocKy != null) {
//                        Block block1 = new Block();
//                        block1.setTen("BLOCK_1");
//                        block1.setHocKy(hocKy.get());
//                        block1.setThoiGianBatDau(hocKy.get().getThoiGianBatDau());
//                        block1.setXoaMem(XoaMem.CHUA_XOA);
//                        block1.setThoiGianKetThuc(DateTimeUtil.convertDateToTimeStampSecond(getEndDateBlock1(i.intValue(), Calendar.FEBRUARY)));
//                        blockRepository.save(block1);
//
//                        Block block2 = new Block();
//                        block2.setTen("BLOCK_2");
//                        block2.setHocKy(hocKy.get());
//                        block2.setXoaMem(XoaMem.CHUA_XOA);
//                        block2.setThoiGianBatDau(DateTimeUtil.convertDateToTimeStampSecond(getStartDateBlock2(i.intValue(), Calendar.MARCH)));
//                        block2.setThoiGianKetThuc(DateTimeUtil.convertDateToTimeStampSecond(getEndDateBlock2(i.intValue(), Calendar.APRIL)));
//                        blockRepository.save(block2);
//                    }
//                }
//
//                if (ten.equals("SUMMER")) {
//                    if (hocKy != null) {
//                        Block block1 = new Block();
//                        block1.setTen("BLOCK_1");
//                        block1.setHocKy(hocKy.get());
//                        block1.setXoaMem(XoaMem.CHUA_XOA);
//                        block1.setThoiGianBatDau(hocKy.get().getThoiGianBatDau());
//                        block1.setThoiGianKetThuc(DateTimeUtil.convertDateToTimeStampSecond(getEndDateBlock1(i.intValue(), Calendar.OCTOBER)));
//                        blockRepository.save(block1);
//
//                        Block block2 = new Block();
//                        block2.setTen("BLOCK_2");
//                        block2.setHocKy(hocKy.get());
//                        block2.setXoaMem(XoaMem.CHUA_XOA);
//                        block2.setThoiGianBatDau(DateTimeUtil.convertDateToTimeStampSecond(getStartDateBlock2(i.intValue(), Calendar.NOVEMBER)));
//                        block2.setThoiGianKetThuc(DateTimeUtil.convertDateToTimeStampSecond(getEndDateBlock2(i.intValue(), Calendar.DECEMBER)));
//                        blockRepository.save(block2);
//                    }
//                }
//
//                if (ten.equals("FALL")) {
//                    if (hocKy != null) {
//                        Block block1 = new Block();
//                        block1.setTen("BLOCK_1");
//                        block1.setHocKy(hocKy.get());
//                        block1.setXoaMem(XoaMem.CHUA_XOA);
//                        block1.setThoiGianBatDau(hocKy.get().getThoiGianBatDau());
//                        block1.setThoiGianKetThuc(DateTimeUtil.convertDateToTimeStampSecond(getEndDateBlock1(i.intValue(), Calendar.JUNE)));
//                        blockRepository.save(block1);
//
//                        Block block2 = new Block();
//                        block2.setTen("BLOCK_2");
//                        block2.setHocKy(hocKy.get());
//                        block2.setXoaMem(XoaMem.CHUA_XOA);
//                        block2.setThoiGianBatDau(DateTimeUtil.convertDateToTimeStampSecond(getStartDateBlock2(i.intValue(), Calendar.JULY)));
//                        block2.setThoiGianKetThuc(DateTimeUtil.convertDateToTimeStampSecond(getEndDateBlock2(i.intValue(), Calendar.AUGUST)));
//                        blockRepository.save(block2);
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * Bộ môn theo cơ sở
//     */
//
//    private void dataBoMonTheoCoSo() throws Exception {
//
//        // Tạo thông tin cho từng cơ sở
//        for (String coSoTo : tenCoSoTo) {
//            CoSo coSo = dbCoSoRepository.findByTen(coSoTo);
//
//            // Tạo thông tin cho từng bộ môn trong cơ sở
//            for (String tenBoMon : tenBoMonCNTT) {
//                BoMon boMon = dbBoMonRepository.findByTen(tenBoMon);
//
//                // Liên kết bộ môn với cơ sở thông qua bảng liên kết
//                BoMonTheoCoSo boMonTheoCoSo = new BoMonTheoCoSo();
//                boMonTheoCoSo.setXoaMem(XoaMem.CHUA_XOA);
//                boMonTheoCoSo.setCoSo(coSo);
//                boMonTheoCoSo.setBoMon(boMon);
//                boMonTheoCoSoRepository.save(boMonTheoCoSo);
//            }
//        }
//
//    }
//
//    /**
//     * Nhân viên
//     *
//     * @throws Exception
//     */
//
//    private void dataNhanVien() throws Exception {
//
//        for (Long i = 1L; i <= 10L; i++) {
//
//            NhanVien nhanVien = new NhanVien();
//            Optional<BoMonTheoCoSo> boMonTheoCoSo = dbBoMonTheoCoSoRepository.findById(i);
//            Optional<ChucVu> chucVu = dbChucVuRepository.findById(i);
//            Optional<HocKy> hocKy = dbHocKyRepository.findById(i);
//            if (boMonTheoCoSo.get() != null && chucVu.get() != null && hocKy.get() != null) {
//                nhanVien.setTen(tenNhanVien[i.intValue() - 1]);
//                nhanVien.setXoaMem(XoaMem.CHUA_XOA);
//                nhanVien.setHocKy(hocKy.get());
//                nhanVien.setBoMonTheoCoSo(boMonTheoCoSo.get());
//                nhanVien.setLoaiHopDong(LoaiHopDong.TOAN_THOI_GIAN);
//                nhanVien.setTaiKhoanFE(tenGmailFe[i.intValue() - 1]);
//                nhanVien.setMaNhanVien(maNhanVien[i.intValue() - 1]);
//                nhanVien.setTrangThai(TrangThaiNhanVien.HOAT_DONG);
//                nhanVienRepository.save(nhanVien);
//            }
//        }
//
//    }
//
//    /**
//     * Nhân viên - Chức vụ
//     *
//     * @throws Exception
//     */
//
//    private void dataNhanVienChucVu() throws Exception {
//
//        for (Long i = 1L; i <= 210L; i++) {
//            NhanVienChucVu chucVuNhanVien = new NhanVienChucVu();
//            Optional<NhanVien> nhanVien = nhanVienRepository.findById(i);
//            Optional<ChucVu> chucVu = dbChucVuRepository.findById(i);
//            if (nhanVien.isPresent() && chucVu.isPresent()) {
//                chucVuNhanVien.setChucVu(chucVu.get());
//                chucVuNhanVien.setNhanVien(nhanVien.get());
//                chucVuNhanVien.setXoaMem(XoaMem.CHUA_XOA);
//                chucVuNhanVienRepository.save(chucVuNhanVien);
//            }
//
//        }
//
//    }
//
//    /**
//     * thêm chủ nhiệm bộ môn
//     *
//     * @throws Exception
//     */
//
//    private void dataBoMonCoSoChuNhiem() throws Exception {
//
//        for (Long i = 1L; i <= 210L; i++) {
//            Optional<NhanVien> nhanVien = nhanVienRepository.findById(i);
//            Optional<BoMonTheoCoSo> boMonTheoCoSo = dbBoMonTheoCoSoRepository.findById(i);
//            if (nhanVien.isPresent() && boMonTheoCoSo.isPresent()) {
//                boMonTheoCoSo.get().setNhanVien(nhanVien.get());
//                boMonTheoCoSo.get().setXoaMem(XoaMem.CHUA_XOA);
//                boMonTheoCoSoRepository.save(boMonTheoCoSo.get());
//            }
//
//        }
//
//    }
//
//    /**
//     * Chuyên nghành theo cơ sở
//     *
//     * @throws Exception
//     */
//
//    private void dataChuyenNganhTheoCoSo() throws Exception {
//        for (Long i = 1L; i <= 100L; i++) {
//            ChuyenNganhTheoCoSo chuyenNganhTheoCoSo = new ChuyenNganhTheoCoSo();
//            Optional<BoMonTheoCoSo> boMonTheoCoSo = dbBoMonTheoCoSoRepository.findById(i);
//            Optional<NhanVien> nhanVien = nhanVienRepository.findById(i);
//            Optional<ChuyenNganh> chuyenNganh = chuyenNganhRepository.findById(i);
//            if (boMonTheoCoSo.isPresent() && nhanVien.isPresent() && chuyenNganh.isPresent()) {
//                chuyenNganhTheoCoSo.setChuyenNganh(chuyenNganh.get());
//                chuyenNganhTheoCoSo.setBoMonTheoCoSo(boMonTheoCoSo.get());
//                chuyenNganhTheoCoSo.setNhanVien(nhanVien.get());
//                chuyenNganhTheoCoSo.setXoaMem(XoaMem.CHUA_XOA);
//                chuyenNganhTheoCoSoRepository.save(chuyenNganhTheoCoSo);
//            }
//
//        }
//    }
//
//    /**
//     * Môn học
//     *
//     * @throws Exception
//     */
//
//    private void dataMonHoc() throws Exception {
//        for (MonHocInfos monHocInfos : monHocInfos) {
//            BoMon boMon = dbBoMonRepository.findByTen(monHocInfos.tenBoMon);
//
//            for (List<MonHocInfo> monHocInfoList : monHocInfos.monHocList) {
//
//                for (MonHocInfo monHocInfo : monHocInfoList) {
//                    MonHoc monHoc = new MonHoc();
//                    monHoc.setTen(monHocInfo.tenMonHoc);
//                    monHoc.setBoMon(boMon);
//                    monHoc.setMaMon(monHocInfo.maMonHoc);
//                    monHoc.setTrangThaiMonHoc(TrangThaiMonHoc.MO);
//                    monHoc.setHinhThuc(HinhThuc.ONLINE);
//                    monHoc.setXoaMem(XoaMem.CHUA_XOA);
//                    monHoc.setThoiGianTao(DateTimeUtil.convertDateToTimeStampSecond(new Date()));
//                    monHocRepository.save(monHoc);
//                }
//            }
//        }
//    }
//
//    /**
//     * Giáo viên dạy môn
//     *
//     * @throws Exception
//     */
//
//    private void dataGiaoVienDayMon() throws Exception {
//
//        Random random = new Random();
//        for (Long i = 1L; i <= 100L; i++) {
//            GiaoVienDayMon giaoVienDayMon = new GiaoVienDayMon();
//            Optional<HocKy> hocKy = dbHocKyRepository.findById(i);
//            Optional<NhanVien> nhanVien = nhanVienRepository.findById(i);
//            Optional<MonHoc> monHoc = monHocRepository.findById(random.nextLong(30));
//            if (hocKy.isPresent() && nhanVien.isPresent() && monHoc.isPresent()) {
//                giaoVienDayMon.setNhanVien(nhanVien.get());
//                giaoVienDayMon.setHocKy(hocKy.get());
//                giaoVienDayMon.setMonHoc(monHoc.get());
//                giaoVienDayMon.setXoaMem(XoaMem.CHUA_XOA);
//                giaoVienDayMonRepository.save(giaoVienDayMon);
//            }
//        }
//    }
//
//    /**
//     * Lớp môn
//     *
//     * @throws Exception
//     */
//
//    private void dataLopMon() throws Exception {
//        System.out.println("run");
//        Random random = new Random();
//        for (Long i = 1L; i <= 100L; i++) {
//            LopMon lopMon = new LopMon();
//            Optional<CoSoCon> coSoCon = coSoConRepository.findById(random.nextLong(10));
//            Optional<NhanVien> nhanVien = nhanVienRepository.findById(i);
//            Optional<MonHoc> monHoc = monHocRepository.findById(random.nextLong(30));
//            Optional<Block> block = blockRepository.findById(random.nextLong(36));
//
//            if (coSoCon.isPresent() && nhanVien.isPresent() && monHoc.isPresent() && block.isPresent()) {
//                lopMon.setNhanVien(nhanVien.get());
//                lopMon.setMonHoc(monHoc.get());
//                lopMon.setCoSoCon(coSoCon.get());
//                lopMon.setBlock(block.get());
//                lopMon.setXoaMem(XoaMem.CHUA_XOA);
//                int tang = random.nextInt(4) + 1;
//                String kyTu = getKyTuTang(tang);
//                int[] so = getSoTang(tang);
//                int lop = so[random.nextInt(so.length)];
//                String maLop = kyTu + lop;
//                lopMon.setMaLop(maLop);
//                Long ca = random.nextLong(10);
//                if (ca == 10) {
//                    lopMon.setCa(Ca.CA10);
//                }
//                if (ca == 9) {
//                    lopMon.setCa(Ca.CA9);
//                }
//                if (ca == 8) {
//                    lopMon.setCa(Ca.CA8);
//                }
//                if (ca == 7) {
//                    lopMon.setCa(Ca.CA7);
//                }
//                if (ca == 6) {
//                    lopMon.setCa(Ca.CA6);
//                }
//                if (ca == 5) {
//                    lopMon.setCa(Ca.CA5);
//                }
//                if (ca == 4) {
//                    lopMon.setCa(Ca.CA4);
//                }
//                if (ca == 3) {
//                    lopMon.setCa(Ca.CA3);
//                }
//                if (ca == 2) {
//                    lopMon.setCa(Ca.CA2);
//                }
//                if (ca == 1) {
//                    lopMon.setCa(Ca.CA1);
//                }
//                if (ca == 0) {
//                    lopMon.setCa(Ca.CA1);
//                }
//                lopMon.setNgay(DateTimeUtil.convertDateToTimeStampSecond(new Date()));
//                lopMonRepository.save(lopMon);
//            }
//        }
//    }
//
//    private String getKyTuTang(int tang) {
//        String[] kyTu = {"P", "F", "L", "U", "D"};
//        return kyTu[tang - 1];
//    }
//
//    private int[] getSoTang(int tang) {
//        switch (tang) {
//            case 1:
//                return new int[]{101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
//            case 2:
//                return new int[]{201, 202, 203, 204, 205, 206, 207, 208, 209, 210};
//            case 3:
//                return new int[]{301, 302, 303, 304, 305, 306, 307, 308, 309, 310};
//            case 4:
//                return new int[]{401, 402, 403, 404, 405, 406, 407, 408, 409, 410};
//            default:
//                return new int[]{};
//        }
//    }
//
//    // xong giai đoạn 1 : note phần
//
//    private void dataTaiKhoanFPT() throws Exception {
//
//        for (Long i = 1L; i <= 100L; i++) {
//            TaiKhoanFPT taiKhoanFPT = new TaiKhoanFPT();
//            Optional<NhanVien> nhanVien = nhanVienRepository.findById(i);
//
//            if (nhanVien.isPresent()) {
//                taiKhoanFPT.setTaiKhoanFPT(tenGmailFpt[i.intValue() - 1]);
//                taiKhoanFPT.setNhanVien(nhanVien.get());
//                taiKhoanFPT.setXoaMem(XoaMem.CHUA_XOA);
//                dbTaiKhoanFPTRepository.save(taiKhoanFPT);
//            }
//        }
//
//    }
//
//    private void dataModule() throws Exception {
//
//        for (Long i = 1L; i <= 100L; i++) {
//            Optional<NhanVien> nhanVien = nhanVienRepository.findById(i);
//            Modules modules = new Modules();
//            modules.setTen("Module" + i);
//            if (nhanVien.isPresent()) {
//                modules.setNhanVien(nhanVien.get());
//            }
//            modules.setXoaMem(XoaMem.CHUA_XOA);
//            modulesRepository.save(modules);
//        }
//
//    }
//
//    private void dataTaiNguyen() throws Exception {
//
//        for (Long i = 1L; i <= 100L; i++) {
//            Optional<Modules> moDun = modulesRepository.findById(i);
//            TaiNguyen taiNguyen = new TaiNguyen();
//            taiNguyen.setMoDun(moDun.get());
//
//            taiNguyen.setMaTaiNguyen("TN " + i);
//            taiNguyen.setTenTaiNguyen("Tai nguyên " + i);
//            taiNguyen.setNoiDung("Nội dung " + i);
//            taiNguyen.setLoaiTaiNguyen(i % 2 == 0 ? LoaiTaiNguyen.FILE : LoaiTaiNguyen.INFO);
//            if (moDun.isPresent()) {
//                taiNguyen.setMoDun(moDun.get());
//            }
//            taiNguyen.setXoaMem(XoaMem.CHUA_XOA);
//            dbTaiNguyenRepository.save(taiNguyen);
//        }
//
//    }
//
//    private void dataQuyen() throws Exception {
//        for (Long i = 1L; i <= 100L; i++) {
//            Quyen quyen = new Quyen();
//            quyen.setMaQuyen("MaQuyen " + i);
//            quyen.setTenQuyen("Quyen " + i);
//            quyen.setMoTa("Mô tả " + i);
//            quyen.setXoaMem(XoaMem.CHUA_XOA);
//            dbQuyenRepository.save(quyen);
//        }
//
//    }
//
//    private void dataQuyenTaiKhoan() throws Exception {
//
//        for (Long i = 1L; i <= 100L; i++) {
//            Optional<Quyen> quyen = dbQuyenRepository.findById(i);
//            Optional<TaiNguyen> taiNguyen = dbTaiNguyenRepository.findById(i);
//            Optional<TaiKhoanFPT> taiKhoanFPT = dbTaiKhoanFPTRepository.findById(i);
//
//            if (quyen.isPresent() && taiKhoanFPT.isPresent() && taiNguyen.isPresent()) {
//                QuyenTaiKhoan quyenTaiKhoan = new QuyenTaiKhoan();
//                quyenTaiKhoan.setQuyen(quyen.get());
//                quyenTaiKhoan.setTaiNguyen(taiNguyen.get());
//                quyenTaiKhoan.setTaiKhoanFPT(taiKhoanFPT.get());
//                quyenTaiKhoan.setTrangThai(true);
//                quyenTaiKhoan.setThoiGianBatDau(DateTimeUtil.convertDateToTimeStampSecond(new Date()));
//
//                Date endDate = DateTimeUtil.addMinutes(new Date(), 30);
//                quyenTaiKhoan.setThoiGianKetThuc(DateTimeUtil.convertDateToTimeStampSecond(endDate));
//                quyenTaiKhoan.setXoaMem(XoaMem.CHUA_XOA);
//                dbQuyenTaiKhoanRepository.save(quyenTaiKhoan);
//            }
//        }
//
//    }
//}