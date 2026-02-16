package service;

import model.PartnerData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FileServiceImplTest {
    FileServiceImpl fileService = new FileServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest(name = "Test avec le file path {0}")
    @ValueSource(strings = {"", "   ", "\t", "src/test/resources/partner_data.json"})
    void readPartnerFromJson(String filePath) {

        if (!filePath.equals("src/test/resources/partner_data.json")) {
            assertThrows(RuntimeException.class,
                    () -> fileService.readPartnerFromJson(filePath));
        }
        else{
            List<PartnerData> result = fileService.readPartnerFromJson(filePath);
//            assertNotEquals(0, result.size());
            assertThat(result.size()).isNotEqualTo(0);
        }
    }
}