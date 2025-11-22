package com.project.oop.lms.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project.oop.lms.entity.ThuThu;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
@Getter
@Setter
public class DataStore {

    private static final String FILE_PATH = "library_db.json";

    // Đối tượng chứa toàn bộ dữ liệu
    private LibraryData data = new LibraryData();
    private final ObjectMapper mapper = new ObjectMapper();

    //constructor
    public DataStore() {
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    //load file csdl neu ton tai
    @PostConstruct
    public void loadData() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try {
                this.data = mapper.readValue(file, LibraryData.class);
                System.out.println(">>> [DataStore] Đã tải dữ liệu thành công.");
            } catch (IOException e) {
                System.err.println(">>> [DataStore] Lỗi đọc file: " + e.getMessage());
            }
        }
        //tao tai khoan mac dinh
        if(this.data.getDsTaiKhoan().isEmpty()){
            ThuThu admin = new ThuThu("001", "admin", "123",
                    "Nguyen Huy Cuong", "Hoat Dong", "Thu thu");
            this.data.getDsTaiKhoan().add(admin);

            saveData();
        }

    }

    //ghi csdl len file
    private static final Logger logger = LoggerFactory.getLogger(DataStore.class);
    public void saveData() {
        try {
            mapper.writeValue(new File(FILE_PATH), this.data);
        } catch (IOException e) {
            logger.error("Lỗi ghi file: ", e);
        }
    }


}
