-- Tạo cơ sở dữ liệu thoiquen
CREATE DATABASE thoiquen;
USE thoiquen;

-- Bảng User
CREATE TABLE User (
    id VARCHAR(50) PRIMARY KEY,         -- id là String
    email VARCHAR(100) NOT NULL UNIQUE,
    matkhau VARCHAR(255) NOT NULL,
    role BOOLEAN NOT NULL               -- TRUE: admin, FALSE: user
);

-- Bảng ThoiQuen (Thói Quen)
CREATE TABLE ThoiQuen (
    habit_id VARCHAR(50) PRIMARY KEY,   -- habit_id là String
    tenthoiquen VARCHAR(100) NOT NULL,
    ngayBatDau DATE NOT NULL,
    ngayKetThuc DATE NOT NULL
);

-- Bảng TheoDoiThoiQuen (Theo Dõi Thói Quen)
CREATE TABLE TheoDoiThoiQuen (
    id VARCHAR(50) PRIMARY KEY,         -- id là String
    habit_id VARCHAR(50),
    user_id VARCHAR(50),
    ngay DATE NOT NULL,
    trangThai BOOLEAN NOT NULL,
    FOREIGN KEY (habit_id) REFERENCES ThoiQuen(habit_id),
    FOREIGN KEY (user_id) REFERENCES User(id)
);

-- Bảng ThongKe
CREATE TABLE ThongKe (
    id VARCHAR(50) PRIMARY KEY,         -- id là String
    user_id VARCHAR(50),
    habit_id VARCHAR(50),
    songaythuchien INT NOT NULL,
    songaykhongthuchien INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (habit_id) REFERENCES ThoiQuen(habit_id)
);

-- Bảng NhacNho
CREATE TABLE NhacNho (
    reminder_id VARCHAR(50) PRIMARY KEY,   -- reminder_id là String
    habit_id VARCHAR(50),                  -- habit_id là String
    thoiGianNhacNho DATETIME NOT NULL,
    tinNhan VARCHAR(255) NOT NULL,
    loaiThongBao VARCHAR(50) NOT NULL,
    FOREIGN KEY (habit_id) REFERENCES ThoiQuen(habit_id)
);
-- Chèn dữ liệu vào bảng User
INSERT INTO User (id, email, matkhau, role)
VALUES ('u001', 'than@gmail.com', '123', FALSE),
       ('u002', 'hieu@gmail.com', '123', FALSE),
       ('u003', 'phuong@gmail.com', '456', FALSE),
       ('u004', 'duc@gmail.com', '123456', false);

-- Chèn dữ liệu vào bảng ThoiQuen
INSERT INTO ThoiQuen (habit_id, tenthoiquen, ngayBatDau, ngayKetThuc)
VALUES ('h001', 'Tập thể dục buổi sáng', '2024-01-01', '2024-12-31'),
       ('h002', 'Đọc sách mỗi ngày', '2024-01-01', '2024-12-31'),
       ('h003', 'Học tiếng Anh', '2024-01-01', '2024-06-30');

-- Chèn dữ liệu vào bảng TheoDoiThoiQuen
INSERT INTO TheoDoiThoiQuen (id, habit_id, user_id, ngay, trangThai)
VALUES ('tdt001', 'h001', 'u002', '2024-01-05', TRUE),
       ('tdt002', 'h002', 'u002', '2024-01-05', FALSE),
       ('tdt003', 'h003', 'u003', '2024-01-06', TRUE);

-- Chèn dữ liệu vào bảng ThongKe
INSERT INTO ThongKe (id, user_id, habit_id, songaythuchien, songaykhongthuchien)
VALUES ('tk001', 'u002', 'h001', 5, 2),
       ('tk002', 'u003', 'h003', 10, 0);

-- Chèn dữ liệu vào bảng NhacNho
INSERT INTO NhacNho (reminder_id, habit_id, thoiGianNhacNho, tinNhan, loaiThongBao)
VALUES ('nn001', 'h001', '2024-01-05 07:00:00', 'Đã đến giờ tập thể dục!', 'email'),
       ('nn002', 'h002', '2024-01-05 09:00:00', 'Đừng quên đọc sách nhé!', 'app'),
       ('nn003', 'h003', '2024-01-06 18:00:00', 'Học tiếng Anh nào!', 'sms');

