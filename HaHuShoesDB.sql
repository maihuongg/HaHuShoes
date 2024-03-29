USE [master]
GO
/****** Object:  Database [HaHuShoes]    Script Date: 5/29/2023 11:19:25 PM ******/
CREATE DATABASE [HaHuShoes]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HaHuShoes', FILENAME = N'E:\SQL Sever 2019\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\HaHuShoes.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'HaHuShoes_log', FILENAME = N'E:\SQL Sever 2019\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\HaHuShoes_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [HaHuShoes] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HaHuShoes].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HaHuShoes] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HaHuShoes] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HaHuShoes] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HaHuShoes] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HaHuShoes] SET ARITHABORT OFF 
GO
ALTER DATABASE [HaHuShoes] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [HaHuShoes] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HaHuShoes] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HaHuShoes] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HaHuShoes] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HaHuShoes] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HaHuShoes] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HaHuShoes] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HaHuShoes] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HaHuShoes] SET  ENABLE_BROKER 
GO
ALTER DATABASE [HaHuShoes] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HaHuShoes] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HaHuShoes] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HaHuShoes] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HaHuShoes] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HaHuShoes] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HaHuShoes] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HaHuShoes] SET RECOVERY FULL 
GO
ALTER DATABASE [HaHuShoes] SET  MULTI_USER 
GO
ALTER DATABASE [HaHuShoes] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HaHuShoes] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HaHuShoes] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HaHuShoes] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [HaHuShoes] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [HaHuShoes] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'HaHuShoes', N'ON'
GO
ALTER DATABASE [HaHuShoes] SET QUERY_STORE = OFF
GO
USE [HaHuShoes]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 5/29/2023 11:19:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[categoryId] [int] IDENTITY(1,1) NOT NULL,
	[categoryName] [nvarchar](100) NULL,
	[categoryCode] [nvarchar](100) NULL,
	[images] [nvarchar](500) NULL,
	[status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 5/29/2023 11:19:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[review] [nvarchar](500) NULL,
	[name] [nvarchar](100) NULL,
	[email] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 5/29/2023 11:19:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[email] [nvarchar](100) NULL,
	[subject] [nvarchar](100) NULL,
	[message] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Information]    Script Date: 5/29/2023 11:19:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Information](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userId] [int] NULL,
	[receiveName] [nvarchar](100) NULL,
	[phone] [nvarchar](15) NULL,
	[adress] [nvarchar](500) NULL,
	[totalMoney] [float] NULL,
	[orderId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 5/29/2023 11:19:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[orderId] [int] IDENTITY(1,1) NOT NULL,
	[userId] [int] NULL,
	[buyDate] [datetime] NULL,
	[totalMoney] [float] NULL,
	[status] [int] NULL,
	[prostatus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[orderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 5/29/2023 11:19:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[odetailId] [int] IDENTITY(1,1) NOT NULL,
	[quantity] [int] NULL,
	[unitPrice] [float] NULL,
	[productId] [int] NULL,
	[orderId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[odetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 5/29/2023 11:19:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[productId] [int] IDENTITY(1,1) NOT NULL,
	[productName] [nvarchar](100) NULL,
	[productCode] [nvarchar](100) NULL,
	[categoryId] [int] NULL,
	[descriptions] [nvarchar](2000) NULL,
	[price] [float] NULL,
	[amount] [int] NULL,
	[stock] [int] NULL,
	[wishlist] [int] NULL,
	[status] [int] NULL,
	[images] [nvarchar](500) NULL,
	[createDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[productId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserRole]    Script Date: 5/29/2023 11:19:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRole](
	[roleId] [int] NOT NULL,
	[roleName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[roleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 5/29/2023 11:19:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[userId] [int] IDENTITY(1,1) NOT NULL,
	[userName] [nvarchar](100) NULL,
	[email] [nvarchar](100) NULL,
	[fullName] [nvarchar](100) NULL,
	[password] [nvarchar](100) NULL,
	[images] [nvarchar](500) NULL,
	[userCode] [nvarchar](15) NULL,
	[roleId] [int] NULL,
	[status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([categoryId], [categoryName], [categoryCode], [images], [status]) VALUES (1, N'Sandals ', N'1120221', N'https://bucket.nhanh.vn/store3/92233/ps/20220128/F6S0026_1__1_.jpg', 1)
INSERT [dbo].[Category] ([categoryId], [categoryName], [categoryCode], [images], [status]) VALUES (2, N'Sneakers', N'1120222', N'https://bucket.nhanh.vn/store3/92233/ps/20221026/CHN0202__8_.jpg', 1)
INSERT [dbo].[Category] ([categoryId], [categoryName], [categoryCode], [images], [status]) VALUES (3, N'Dép', N'1120023', N'https://bucket.nhanh.vn/store3/92233/ps/20220808/TRE2222_dai_dien_moi_thumb.jpg', 1)
INSERT [dbo].[Category] ([categoryId], [categoryName], [categoryCode], [images], [status]) VALUES (4, N'Vớ', N'1120224', N'https://bucket.nhanh.vn/store3/92233/ps/20220530/VOSCC01_1__1_.jpg', 1)
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Information] ON 

INSERT [dbo].[Information] ([id], [userId], [receiveName], [phone], [adress], [totalMoney], [orderId]) VALUES (1, 2, N'Nguyễn Thị Thu Hằng', N'0387229978', N'Ho Chi Minh', 848000, 1)
INSERT [dbo].[Information] ([id], [userId], [receiveName], [phone], [adress], [totalMoney], [orderId]) VALUES (2, 2, N'Đặng Mai Hương', N'0387229916', N'Ho Chi Minh', 1147000, 2)
INSERT [dbo].[Information] ([id], [userId], [receiveName], [phone], [adress], [totalMoney], [orderId]) VALUES (3, 2, N'Nguyễn Thị Thu Hằng', N'0387229915', N'Ho Chi Minh', 533000, 3)
SET IDENTITY_INSERT [dbo].[Information] OFF
GO
SET IDENTITY_INSERT [dbo].[Order] ON 

INSERT [dbo].[Order] ([orderId], [userId], [buyDate], [totalMoney], [status], [prostatus]) VALUES (1, 2, CAST(N'2023-05-29T00:00:00.000' AS DateTime), 838000, 1, 1)
INSERT [dbo].[Order] ([orderId], [userId], [buyDate], [totalMoney], [status], [prostatus]) VALUES (2, 2, CAST(N'2023-05-29T00:00:00.000' AS DateTime), 1137000, 0, 1)
INSERT [dbo].[Order] ([orderId], [userId], [buyDate], [totalMoney], [status], [prostatus]) VALUES (3, 2, CAST(N'2023-05-29T00:00:00.000' AS DateTime), 523000, 0, 0)
SET IDENTITY_INSERT [dbo].[Order] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderDetail] ON 

INSERT [dbo].[OrderDetail] ([odetailId], [quantity], [unitPrice], [productId], [orderId]) VALUES (1, 1, 399000, 1, 1)
INSERT [dbo].[OrderDetail] ([odetailId], [quantity], [unitPrice], [productId], [orderId]) VALUES (2, 1, 439000, 2, 1)
INSERT [dbo].[OrderDetail] ([odetailId], [quantity], [unitPrice], [productId], [orderId]) VALUES (3, 2, 399000, 1, 2)
INSERT [dbo].[OrderDetail] ([odetailId], [quantity], [unitPrice], [productId], [orderId]) VALUES (4, 1, 339000, 3, 2)
INSERT [dbo].[OrderDetail] ([odetailId], [quantity], [unitPrice], [productId], [orderId]) VALUES (5, 1, 289000, 17, 3)
INSERT [dbo].[OrderDetail] ([odetailId], [quantity], [unitPrice], [productId], [orderId]) VALUES (6, 3, 78000, 41, 3)
SET IDENTITY_INSERT [dbo].[OrderDetail] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (1, N'Sandals F6 sport đen full ', N'2022111', 1, N'Dòng sản phẩm: F6S sandals. Chất liệu đế: Phylon. Chiều cao: 3cm. Siêu nhẹ với trọng lượng chưa tới 450G/đôi. Đế phylon bền bỉ, nhẹ, đàn hồi tốt cùng thiết kế bề mặt cao su chống trơn trượt tạo sự thoải mái trong di chuyển và tăng tuổi thọ sử dụng. Quai dù bản mảnh mềm mại, thoáng hút mau khô, không gây hôi chân. Khoen: hợp kim atimal không gỉ sét. Dán xé: cao cấp, độ bám dính lên đến 20.000 lần. Độ bền: tối thiểu 6 tháng. Xuất xứ thương hiệu: Việt Nam.', 399000, 117, 20, 23, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220608/F6S301_thumb.jpg', CAST(N'2022-11-09' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (2, N'Sandals F7 Racing đế đen phối trắng quai đen', N'2022112', 1, N'Dòng sản phẩm: F7 sandals. Thương hiệu: SHONDO. Chiều cao: 5cm. Siêu nhẹ với trọng lượng chưa tới 450G/đôi. Đế phylon bền bỉ, nhẹ, đàn hồi tốt cùng thiết kế bề mặt cao su chống trơn trượt tạo sự thoải mái trong di chuyển và tăng tuổi thọ sử dụng. Quai dù bản mảnh mềm mại, thoáng hút mau khô, không gây hôi chân. Khoen: hợp kim atimal không gỉ sét. Dán xé: cao cấp, độ bám dính lên đến 20.000 lần. Độ bền: tối thiểu 6 tháng. Xuất xứ thương hiệu: Việt Nam.', 439000, 99, 10, 16, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221017/F7R1010__1_.jpg', CAST(N'2022-11-01' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (3, N'Sandals F6 sport xanh da trời full ', N'2022113', 1, N'Đế: Chất liệu Phylon siêu nhẹ chống trơn trượt, đệm gót nâng cao 3cm giúp cải thiện chiều cao. Đế trên êm ái, nhiều rãnh thoáng khí massage lòng bàn chân. Quai: công nghệ dệt kim ưu việt tăng độ êm ái, chắc chắn, thấm hút mồ hôi giúp thoáng mát. Logo: Cao su khuôn độc quyền hàng chính hang. Khoen: Hợp kim atimal không gỉ sét. Dán xé: Cao cấp, độ bám dính lên đến 20.000 lần. Kích thước: 36 -39 (Nữ), 39 -44 (Nam). Xuất xứ thương hiệu: Việt Nam.', 339000, 129, 15, 61, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20211109/giay_sandals_shondo_f6_sport_F6S304.jpg', CAST(N'2022-11-01' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (4, N'Sneaker CLASS 1 in SH hồng', N'2022114', 2, N'Giày sneaker Class 1 có thiết kế tối giản với đường may giấu chỉ, logo Sh in chuyển nổi bật, tạo nên nét khác biệt, bắt mắt cho sản phẩm. Dòng sản phẩm: Sneaker Class 1. Thương hiệu: SHONDO. Chiều cao: 5 cm. Trọng lượng siêu nhẹ: ~400g. Đế phylon nguyên khối cùng rãnh họa tiết tăng độ bám dính, hạn chế trơn trượt. Mặt giày được làm từ da Microfiber, dây đai Webbing dệt kim cao cấp, logo in chuyển màng công nghệ mới. Mặt trong được làm từ vải Mesh mềm mại, thoáng khí kết hợp cùng với đệm EVA ôm sát mang đến sự êm ái, thoải mái, đồng thời, bảo vệ bàn chân trong suốt quá trình di chuyển. Xuất xứ thương hiệu: Việt Nam.', 799000, 50, 5, 5, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220727/SND0070_1__1_.jpg', CAST(N'2022-11-05' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (5, N'Sneaker CLASS 1 in MONOGRAM đen', N'2022115', 2, N'Sneaker Class 1 Monogram Đen có 2 phiên bản viền chỉ trắng hoặc đen, sẽ được giao ngẫu nhiên khi đặt hàng. Dòng sản phẩm: Sneaker Class 1. Thương hiệu: SHONDO. Chiều cao: 5 cm. Trọng lượng siêu nhẹ: ~400g. Đế phylon bền bỉ, nhẹ, đàn hồi tốt cùng với thiết kế rãnh hoa văn mặt đế trơn trượt, chống mài mòn vượt trội, tạo sự thoải mái trong di chuyển và tăng tuổi thọ sử dụng. Mặt giày được làm từ da Microfiber, dây đai Webbing dệt kim cao cấp, logo in chuyển màng công nghệ mới. Mặt trong được làm từ vải Mesh mềm mại, thoáng khí kết hợp cùng với đệm EVA ôm sát mang đến sự êm ái, thoải mái. Đồng thời, bảo vệ bàn chân trong suốt quá trình di chuyển. Xuất xứ thương hiệu: Việt Nam', 649000, 50, 25, 15, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220707/SND0110__1__thumb.jpg', CAST(N'2022-11-09' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (6, N'Sneaker CLASS 1 in SH caro trắng', N'2022116', 2, N'Giày sneaker Class 1 có thiết kế tối giản với đường may giấu chỉ, logo Sh in chuyển nổi bật, tạo nên nét khác biệt, bắt mắt cho sản phẩm. Dòng sản phẩm: Sneaker Class 1. Thương hiệu: SHONDO. Chiều cao: 5 cm. Trọng lượng siêu nhẹ: ~400g. Đế phylon nguyên khối cùng rãnh họa tiết tăng độ bám dính, hạn chế trơn trượt. Mặt giày được làm từ da Microfiber, dây đai Webbing dệt kim cao cấp, logo in chuyển màng công nghệ mới. Mặt trong được làm từ vải Mesh mềm mại, thoáng khí kết hợp cùng với đệm EVA ôm sát mang đến sự êm ái, thoải mái, đồng thời, bảo vệ bàn chân trong suốt quá trình di chuyển. Xuất xứ thương hiệu: Việt Nam.', 699000, 70, 15, 55, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220817/SND0002__1_.jpg', CAST(N'2022-11-07' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (7, N'Chunky S1 in SH trắng kem đế cao su nâu', N'2022117', 2, N'Thuộc dòng sản phẩm sneaker mới nhất 2022 của Shondo, Chunky S1 được thiết kế theo phong cách hầm hố, đường nét phá cách cùng logo SH nổi bật, dễ dàng phối đồ và thể hiện đa phong cách. Dòng sản phẩm: Chunky S1. Thương hiệu: SHONDO. Đế trên chất liệu Phylon cao cấp, kết hợp đế dưới cao su có rãnh, hạn chế trơn trượt, chống mài mòn. Mặt giày được làm từ da Microfiber, logo in chuyển màng công nghệ mới. Mặt trong được làm từ vải Mesh mềm mại, thoáng khí kết hợp cùng với đệm EVA ôm sát mang đến sự êm ái, thoải mái, đồng thời, bảo vệ bàn chân trong suốt quá trình di chuyển. Đế cao khoảng 6 cm. Xuất xứ thương hiệu: Việt Nam.', 1099000, 20, 4, 11, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221026/CHN0101__8_.jpg', CAST(N'2022-11-04' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (8, N'Dép Trendy III in chữ SH full đen', N'2022118', 3, N'Đế phylon nguyên khối bền, êm, nhẹ. Mặt quai được làm từ da CN và lót thun 4 chiều tạo sự êm ái, hút ẩm khô nhanh . Màu sắc: Full đen. Xuất xứ thương hiệu: Việt Nam.', 299000, 60, 20, 25, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220808/TRE1111_dai_dien_moi_thumb.jpg', CAST(N'2022-11-01' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (9, N'Vớ cổ cao in chữ Shondo đen', N'2022119', 4, N'Vớ cổ cao in chữ Shondo đen', 49000, 150, 10, 40, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220530/VOSCC11__1_.jpg', CAST(N'2022-11-06' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (10, N'Vớ cổ cao in chữ Shondo xám', N'2022120', 4, N'Vớ cổ cao in chữ Shondo xám', 49000, 150, 20, 35, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220530/VOSCC22__1_.jpg', CAST(N'2022-11-06' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (11, N'Vớ cổ cao in chữ Shondo trắng', N'2022121', 4, N'Vớ cổ cao in chữ Shondo trắng', 49000, 150, 15, 50, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220530/VOSCC01_1__1_.jpg', CAST(N'2022-11-06' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (12, N'Vớ cổ trung BASIC', N'2022122', 4, N'Vớ cổ trung BASIC', 29000, 100, 30, 37, 1, N'https://bucket.nhanh.vn/store/24295/ps/20220807/TAT_CO_TRUNG_BASIC_tag.jpg', CAST(N'2022-11-08' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (13, N'Dép Trendy II in chữ SHONDO vàng đế xanh quai trắng', N'2022123', 3, N'Dép TRE0095 là dòng dép thời trang với điểm nhấn là logo Shondo in font chữ comic cùng tính năng dán xé, có thể điều chỉnh được kích thước quai phù hợp với từng bàn chân. Đế phylon bền, êm, nhẹ. Mặt quai được làm từ da CN và lót thun 4 chiều tạo sự êm ái, hút ẩm khô nhanh. Màu sắc: Vàng – xanh - trắng. Xuất xứ thương hiệu: Việt Nam.', 279000, 150, 44, 88, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220928/Tre3502__1_.jpg', CAST(N'2022-11-08' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (14, N'Dép Flippy in chữ SH caro đế đen xanh phối quai đen', N'2022124', 3, N'Đế EVA nhẹ, êm, hạn chế mài mòn, trơn trượt. Quai làm từ dây đai webbing chắc chắn, độ hút ẩm khô nhanh. Xuất xứ thương hiệu: Việt Nam.', 199000, 140, 17, 73, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220831/FLP1212_dai_dien.jpg', CAST(N'2022-11-03' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (15, N'Dép Flippy in nhiều chữ SHONDO xám đen', N'2022125', 3, N'Đế EVA nhẹ, êm, hạn chế mài mòn, trơn trượt. Quai làm từ dây đai webbing chắc chắn, độ hút ẩm khô nhanh. Xuất xứ thương hiệu: Việt Nam.', 219000, 130, 33, 79, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220808/FLP2210_dai_dien_moi.jpg', CAST(N'2022-11-07' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (16, N'Dép Flippy in chữ SHONDO hồng', N'2022126', 3, N'Đế EVA nhẹ, êm, hạn chế mài mòn, trơn trượt. Quai làm từ dây đai webbing chắc chắn, độ hút ẩm khô nhanh. Xuất xứ thương hiệu: Việt Nam.', 199000, 120, 28, 41, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220831/FLP3070_dai_dien.jpg', CAST(N'2022-11-07' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (17, N'Dép Trendy II dù sọc mũi tên xanh lá', N'2022127', 3, N'Đế: Chất liệu Phylon siêu nhẹ chống trơn trượt, đệm gót nâng cao giúp cải thiện chiều cao. Đế trên thiết kế các rãnh massage lòng bàn chân. Màu sắc: Xanh lá, đai trắng họa tiết mũi tên. Size: 36 – 44. Xuất xứ: Việt Nam.', 289000, 159, 16, 53, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220808/TRE4301_dai_dien_moi.jpg', CAST(N'2022-11-07' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (18, N'Sandals Floral trắng xanh dương', N'2022128', 1, N'Đế: Phylon nguyên khối kết hợp kỹ thuật sơn 2 lớp tạo sự khác biệt. Quai: Dây đai webbing kết hợp da microfiber êm ái, độ thấm hút nhanh. Khoen: Hợp kim antimol cao cấp, không gỉ sét. Dán xé: cao cấp, độ bám dính lên đến 20.000 lần. Xuất xứ thương hiệu: Việt Nam.', 379000, 175, 45, 92, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221110/FLR0034__1_.jpg', CAST(N'2022-11-09' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (19, N'Sandals F6 sport loang khói xanh hồng', N'2022129', 1, N'Dòng sản phẩm: F6S sandals. Chất liệu đế: Phylon. Chiều cao: 3cm. Siêu nhẹ với trọng lượng chưa tới 450G/đôi. Đế phylon bền bỉ, nhẹ, đàn hồi tốt cùng thiết kế bề mặt cao su chống trơn trượt tạo sự thoải mái trong di chuyển và tăng tuổi thọ sử dụng. Quai dù bản mảnh mềm mại, thoáng hút mau khô, không gây hôi chân. Khoen: hợp kim atimal không gỉ sét. Dán xé: cao cấp, độ bám dính lên đến 20.000 lần. Độ bền: tối thiểu 6 tháng. Xuất xứ thương hiệu: Việt Nam.', 399000, 155, 56, 87, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20210531/F6_sport_loang_khoi_xanh_hong_F6S1072.jpg', CAST(N'2022-11-09' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (20, N'Sneaker CLASS 1 in MONOGRAM nhiều màu', N'2022130', 2, N'Dòng sản phẩm: Sneaker Class 1. Thương hiệu: SHONDO. Chiều cao: 5 cm. Trọng lượng siêu nhẹ: ~400g. Đế phylon bền bỉ, nhẹ, đàn hồi tốt cùng với thiết kế rãnh hoa văn mặt đế chống trơn trượt, chống mài mòn vượt trội, tạo sự thoải mái trong di chuyển và tăng tuổi thọ sử dụng. Mặt giày được làm từ da Microfiber, dây đai Webbing dệt kim cao cấp, logo in chuyển màng công nghệ mới. Mặt trong được làm từ vải Mesh mềm mại, thoáng khí kết hợp cùng với đệm EVA ôm sát mang đến sự êm ái, thoải mái. Đồng thời, bảo vệ bàn chân trong suốt quá trình di chuyển. Xuất xứ thương hiệu: Việt Nam.', 649000, 95, 12, 99, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220506/SND0058__1_.jpg', CAST(N'2022-11-06' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (21, N'Sandals F7 Racing Thỏ bảy màu đen', N'2022131', 1, N'F7M1010 là sản phẩm kết hợp giữa SHONDO x Thỏ 7 Màu với họa tiết nhân vật Thỏ 7 màu cọc tính nhưng không kém phần ngộ nghĩnh, hài hước. Dòng sản phẩm: F7 sandals.Thương hiệu: SHONDO.Chiều cao: 5cm. Siêu nhẹ với trọng lượng chưa tới 450G/đôi', 549000, 100, 50, 25, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20211209/F7M1010__1_.jpg', CAST(N'2022-11-09' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (22, N'Sandals F7 Racing xanh mint', N'2022132', 1, N'F7 Racing Thế Hệ Mới. Phiên bản đầy năng động, sáng tạo và đổi mới trong phong cách phối màu mang đến sự hiện đại và trẻ trung cho giới trẻ. Công nghệ dệt quai ưu việt gia tăng độ êm ái, thấm hút mồ hôi cực tốt. Đế trên nhiều rãnh thoáng khí giúp massage lòng bàn chân, tăng khả năng điều hướng khi di chuyển. Đế F7 Racing chất liệu phylon siêu nhẹ kết hợp cùng cao su ở phần gót bám giữ chắc chắn. Đế cao lên đến 5cm với độ đàn hồi nhẹ, vừa cải thiện chiều cao, vừa đem đến trải nghiệm êm ái, thoải mái nhất', 459000, 130, 70, 45, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221205/F7R32359_thumb.jpg', CAST(N'2022-11-09' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (23, N'Dép Trendy đai vệt sơn đen', N'2022133', 3, N'Dép SHONDO Trendy là dòng sản phẩm phụ của SHONDO. Đế dép được trang bị lớp đế đệm cùng với công nghệ massage chân, vừa giúp cải thiện chiều cao, vừa tạo sự thoải mái cho lòng bàn chân và tiện nghi di chuyển. Dép Trendy giúp người mang thể hiện cá tính của bản thân và không kém phần năng động trong ngày dài', 269000, 100, 65, 20, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20211220/TRE1030__1_.jpg', CAST(N'2022-11-09' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (24, N'Dép Flippy in chữ SHONDO cam', N'2022134', 3, N'Dép SHONDO Trendy là dòng sản phẩm phụ của SHONDO. Đế dép được trang bị lớp đế đệm cùng với công nghệ massage chân, vừa giúp cải thiện chiều cao, vừa tạo sự thoải mái cho lòng bàn chân và tiện nghi di chuyển. Dép Trendy giúp người mang thể hiện cá tính của bản thân và không kém phần năng động trong ngày dài', 199000, 400, 240, 50, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220831/FLP8011_dai_dien.jpg', CAST(N'2022-11-09' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (25, N'Dép Flippy in nhiều chữ SHONDO cam', N'2022135', 3, N'Đế EVA nhẹ, êm, hạn chế mài mòn, trơn trượt. Quai làm từ dây đai webbing chắc chắn, độ hút ẩm khô nhanh.Xuất xứ thương hiệu: Việt Nam', 219000, 100, 20, 90, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220831/FLP8010_dai_dien.jpg', CAST(N'2022-11-09' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (26, N'Dép Flippy xanh dạ', N'2022136', 3, N'- Đế EVA nhẹ, êm, hạn chế mài mòn, trơn trượt. Quai làm từ dây đai webbing chắc chắn, độ hút ẩm khô nhanh.Xuất xứ thương hiệu: Việt Nam', 199000, 300, 180, 100, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221205/FLP4040_dai_dien_moi.jpg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (27, N'Dép Flippy đen trắng', N'2022137', 3, N'- Đế EVA nhẹ, êm, hạn chế mài mòn, trơn trượt. Quai làm từ dây đai webbing chắc chắn, độ hút ẩm khô nhanh. Xuất xứ thương hiệu: Việt Nam', 219000, 50, 50, 0, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221205/FLP1010_dai_dien_moi.jpg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (28, N'Chunky S1 trắng đế ombre trắng tím', N'2022138', 2, N'Thuộc dòng sản phẩm sneaker mới nhất 2022 của Shondo, Chunky S1 được thiết kế theo phong cách hầm hố, đường nét phá cách cùng logo SH nổi bật, dễ dàng phối đồ và thể hiện đa phong cách. Dòng sản phẩm: Chunky S1. Thương hiệu: SHONDO. Đế trên chất liệu Phylon cao cấp, kết hợp đế dưới cao su có rãnh, hạn chế trơn trượt, chống mài mòn. Mặt giày được làm từ da Microfiber, logo in chuyển màng công nghệ mới. Mặt trong được làm từ vải Mesh mềm mại, thoáng khí kết hợp cùng với đệm EVA ôm sát mang đến sự êm ái, thoải mái, đồng thời, bảo vệ bàn chân trong suốt quá trình di chuyển. Đế cao khoảng 6 cm. Xuất xứ thương hiệu: Việt Nam.', 999000, 70, 15, 15, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221026/CHN0505__2_.jpg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (29, N'Chunky S1 trắng đế ombre xám đen', N'2022139', 2, N'Thuộc dòng sản phẩm sneaker mới nhất 2022 của Shondo, Chunky S1 được thiết kế theo phong cách hầm hố, đường nét phá cách cùng logo SH nổi bật, dễ dàng phối đồ và thể hiện đa phong cách. Dòng sản phẩm: Chunky S1. Thương hiệu: SHONDO. Đế trên chất liệu Phylon cao cấp, kết hợp đế dưới cao su có rãnh, hạn chế trơn trượt, chống mài mòn. Mặt giày được làm từ da Microfiber, logo in chuyển màng công nghệ mới. Mặt trong được làm từ vải Mesh mềm mại, thoáng khí kết hợp cùng với đệm EVA ôm sát mang đến sự êm ái, thoải mái, đồng thời, bảo vệ bàn chân trong suốt quá trình di chuyển. Đế cao khoảng 6 cm. Xuất xứ thương hiệu: Việt Nam.', 999000, 60, 20, 10, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221026/CHN0404__2_.jpg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (30, N'Sneaker Class 1 Shondo Pride', N'2011140', 2, N'Giày sneaker Shondo Pride với thiết kế sắc màu cầu vồng được lồng ghép vào icon SH -  biểu tượng của Shondo, thể hiện sự ủng hộ của thương hiệu đến với cộng đồng LGBTQ đầy sắc màu và rực rỡ.', 849000, 120, 80, 40, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20220922/SND0303_dai_dien.jpg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (31, N'Chunky S1 đen đế ombre đen cam', N'2022141', 2, N'Thuộc dòng sản phẩm sneaker mới nhất 2022 của Shondo, Chunky S1 được thiết kế theo phong cách hầm hố, đường nét phá cách cùng logo SH nổi bật, dễ dàng phối đồ và thể hiện đa phong cách. Dòng sản phẩm: Chunky S1. Thương hiệu: SHONDO. Đế trên chất liệu Phylon cao cấp, kết hợp đế dưới cao su có rãnh, hạn chế trơn trượt, chống mài mòn. Mặt giày được làm từ da Microfiber, logo in chuyển màng công nghệ mới. Mặt trong được làm từ vải Mesh mềm mại, thoáng khí kết hợp cùng với đệm EVA ôm sát mang đến sự êm ái, thoải mái, đồng thời, bảo vệ bàn chân trong suốt quá trình di chuyển. Đế cao khoảng 6 cm. Xuất xứ thương hiệu: Việt Nam.', 999000, 200, 180, 20, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221026/CHN1010__2_.jpg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (32, N'Chunky S1 trắng đế ombre xám đen', N'2022142', 2, N'Thuộc dòng sản phẩm sneaker mới nhất 2022 của Shondo, Chunky S1 được thiết kế theo phong cách hầm hố, đường nét phá cách cùng logo SH nổi bật, dễ dàng phối đồ và thể hiện đa phong cách. Dòng sản phẩm: Chunky S1. Thương hiệu: SHONDO. Đế trên chất liệu Phylon cao cấp, kết hợp đế dưới cao su có rãnh, hạn chế trơn trượt, chống mài mòn. Mặt giày được làm từ da Microfiber, logo in chuyển màng công nghệ mới. Mặt trong được làm từ vải Mesh mềm mại, thoáng khí kết hợp cùng với đệm EVA ôm sát mang đến sự êm ái, thoải mái, đồng thời, bảo vệ bàn chân trong suốt quá trình di chuyển. Đế cao khoảng 6 cm. Xuất xứ thương hiệu: Việt Nam.', 999000, 180, 160, 20, 1, N'https://bucket.nhanh.vn/store3/92233/ps/20221026/CHN0404__2_.jpg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (33, N'Sneaker Royal', N'2022143', 2, N'Sneaker royal thiết kế kiểu dáng năng động. Phối màu sắc ở phần gót chân đầy nổi bật và thu hút. Phù hợp mang nhiều dịp: đi làm, đi học hay dạo phố', 849000, 140, 30, 70, 1, N'https://product.hstatic.net/1000003969/product/tim_tt03043_10_20220808110853_2adefd99af3a41939423aaa4c9f3b5cf_master.jpeg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (34, N'Sneakers Ocean Wave', N'2022144', 2, N'Sneakers phối những gam màu viền cá tính, mạnh mẽ. Phom dáng hiện đại, ấn tượng.Chất liệu cao cấp siêu nhẹ với những lỗ thoáng khí giúp chân thoải mái hơn.', 780000, 100, 69, 18, 1, N'https://product.hstatic.net/1000003969/product/xanh-tim_tt05007_1_36caf1953a0a4be4adb187c365aadb37_master.jpg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (35, N'Sneaker Queendom', N'2022145', 2, N'Sneaker queendom thiết kế kiểu dáng năng động. Đế cao 5cm giúp bạn ăn gian được chiều cao. Phù hợp mang nhiều dịp: đi làm, đi học hay dạo phố', 780000, 70, 60, 0, 1, N'https://product.hstatic.net/1000003969/product/xanh_tt05014_20_20220926110425_ef733cfde3c74738940a6b18dfa7ca92_master.jpeg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (36, N'Vớ trung trơn hoạ tiết thêu cô gái', N'2022146', 3, N'Thành phần chất liệu: 70% Cotton, 25% Nylon, 5% Elastane..Size vớ: áp dụng theo kích thước bàn chân, phù hợp với hầu hết người Châu Á (230mm-285mm). Đối tượng sử dụng:   Nam/nữ giới văn phòng,người tập thể thao,giới trẻ. ', 78000, 500, 480, 20, 1, N'https://product.hstatic.net/1000219425/product/votrunghoatietcogaitrovonamnu_76010710a83546bbbfa5e0e6c566e133_master.jpeg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (37, N'Vớ Trung Trơn Hoạ Tiết Ong Thêu', N'2022147', 3, N'Thành phần chất liệu: 70% Cotton, 25% Nylon, 5% Elastane..Size vớ: áp dụng theo kích thước bàn chân, phù hợp với hầu hết người Châu Á (230mm-285mm). Đối tượng sử dụng:   Nam/nữ giới văn phòng,người tập thể thao,giới trẻ. ', 78000, 150, 100, 35, 1, N'https://product.hstatic.net/1000219425/product/votrunghinhconongvonamnu1_f2d4cb1c676747c98ea6174498467796_master.jpeg', CAST(N'2022-11-20' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (38, N'Sneakers Ocean Wave', N'2022144', 2, N'Sneakers phối những gam màu viền cá tính, mạnh mẽ. Phom dáng hiện đại, ấn tượng.Chất liệu cao cấp siêu nhẹ với những lỗ thoáng khí giúp chân thoải mái hơn.', 780000, 100, 69, 18, 1, N'https://product.hstatic.net/1000003969/product/xanh-tim_tt05007_1_36caf1953a0a4be4adb187c365aadb37_master.jpg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (39, N'Sneaker Queendom', N'2022145', 2, N'Sneaker queendom thiết kế kiểu dáng năng động. Đế cao 5cm giúp bạn ăn gian được chiều cao. Phù hợp mang nhiều dịp: đi làm, đi học hay dạo phố', 780000, 70, 60, 0, 1, N'https://product.hstatic.net/1000003969/product/xanh_tt05014_20_20220926110425_ef733cfde3c74738940a6b18dfa7ca92_master.jpeg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (40, N'Vớ trung trơn hoạ tiết thêu cô gái', N'2022146', 3, N'Thành phần chất liệu: 70% Cotton, 25% Nylon, 5% Elastane..Size vớ: áp dụng theo kích thước bàn chân, phù hợp với hầu hết người Châu Á (230mm-285mm). Đối tượng sử dụng:   Nam/nữ giới văn phòng,người tập thể thao,giới trẻ. ', 78000, 500, 480, 20, 1, N'https://product.hstatic.net/1000219425/product/votrunghoatietcogaitrovonamnu_76010710a83546bbbfa5e0e6c566e133_master.jpeg', CAST(N'2022-11-10' AS Date))
INSERT [dbo].[Product] ([productId], [productName], [productCode], [categoryId], [descriptions], [price], [amount], [stock], [wishlist], [status], [images], [createDate]) VALUES (41, N'Vớ Trung Trơn Hoạ Tiết Ong Thêu', N'2022147', 3, N'Thành phần chất liệu: 70% Cotton, 25% Nylon, 5% Elastane..Size vớ: áp dụng theo kích thước bàn chân, phù hợp với hầu hết người Châu Á (230mm-285mm). Đối tượng sử dụng:   Nam/nữ giới văn phòng,người tập thể thao,giới trẻ. ', 78000, 147, 100, 38, 1, N'https://product.hstatic.net/1000219425/product/votrunghinhconongvonamnu1_f2d4cb1c676747c98ea6174498467796_master.jpeg', CAST(N'2022-11-20' AS Date))
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
INSERT [dbo].[UserRole] ([roleId], [roleName]) VALUES (1, N'admin')
INSERT [dbo].[UserRole] ([roleId], [roleName]) VALUES (3, N'user')
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([userId], [userName], [email], [fullName], [password], [images], [userCode], [roleId], [status]) VALUES (1, N'test', NULL, NULL, N'12345', NULL, NULL, 1, 1)
INSERT [dbo].[Users] ([userId], [userName], [email], [fullName], [password], [images], [userCode], [roleId], [status]) VALUES (2, N'user', NULL, NULL, N'54321', NULL, NULL, 3, 1)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Information]  WITH CHECK ADD FOREIGN KEY([orderId])
REFERENCES [dbo].[Order] ([orderId])
GO
ALTER TABLE [dbo].[Information]  WITH CHECK ADD FOREIGN KEY([userId])
REFERENCES [dbo].[Users] ([userId])
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD FOREIGN KEY([userId])
REFERENCES [dbo].[Users] ([userId])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([orderId])
REFERENCES [dbo].[Order] ([orderId])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([productId])
REFERENCES [dbo].[Product] ([productId])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([categoryId])
REFERENCES [dbo].[Category] ([categoryId])
GO
USE [master]
GO
ALTER DATABASE [HaHuShoes] SET  READ_WRITE 
GO
