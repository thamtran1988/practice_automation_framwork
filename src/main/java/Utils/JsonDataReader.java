package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.LoginData;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonDataReader {

    /**
     * Đọc toàn bộ file JSON dưới dạng Map<String, LoginData>
     * Key là tên Test Case (ví dụ: "SUCCESS_USER_SAUCEDEMO").
     */
    public static Map<String, LoginData> getLoginDataMap(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(filePath);

            // Dùng TypeReference để ánh xạ JSON Object thành Map
            return mapper.readValue(file, new TypeReference<Map<String, LoginData>>() {});

        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file JSON Map: " + e.getMessage());
            return null;
        }
    }
}
