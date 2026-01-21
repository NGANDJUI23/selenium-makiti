package service;

import model.PartnerData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void readPartnerFromJson() {
        FileServiceImpl fileService = new FileServiceImpl();
        List<PartnerData> result = fileService.readPartnerFromJson("src/test/resources/partner_data.json");
        assertNotEquals(0, result.size());
    }
}