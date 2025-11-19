Mô tả dự án: dự án có 4 packet quan trọng
  - entity: các class đại diện cho data của các thực thể cần quản lý
  - repository: các class đảm nhận việc ghi/đọc/lưu data lên file JSON
  - service: các interface và class đảm nhiệm chức năng nghiệp vụ của hệ thống
  - controller: các class liên kết - điều kiển các class backend với web frontend

Mỗi người sẽ phụ trách 1 chức năng trọn vẹn từ backend đến frontend
Để lấy dữ liệu trên csdl (file JSON), mọi người import class DataStore, lấy các list dữ liệu qua getter getData()
VÍ DỤ: List<Sach> list = dataStore.getData().getDsSach();
 
