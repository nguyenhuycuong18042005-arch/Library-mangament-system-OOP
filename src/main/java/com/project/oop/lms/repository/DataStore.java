package com.project.oop.lms.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class DataStore {

    private static final String FILE_PATH = "library_db.json";

    // Đối tượng chứa toàn bộ dữ liệu
    private LibraryData data = new LibraryData();

    private final ObjectMapper mapper = new ObjectMapper();

    public DataStore() {
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

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
    }


    private static final Logger logger = LoggerFactory.getLogger(DataStore.class);
    public void saveData() {
        try {
            mapper.writeValue(new File(FILE_PATH), this.data);
        } catch (IOException e) {
            logger.error("Lỗi ghi file: ", e);
        }
    }

    // --- MANUAL GETTER (Quan trọng nhất) ---

    // Các Service sẽ gọi: dataStore.getData().getDsSach()...
    public LibraryData getData() {
        return data;
    }

    // Setter cho Data (Ít dùng nhưng nên có cho đủ bộ)
    public void setData(LibraryData data) {
        this.data = data;
    }
}
