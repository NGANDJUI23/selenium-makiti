package service;

import model.PartnerData;

import java.util.List;

public interface FileServiceFace {
    List<PartnerData> readPartnerFromJson(String filePath);
}
