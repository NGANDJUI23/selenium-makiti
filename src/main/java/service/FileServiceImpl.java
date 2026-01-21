package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.PartnerData;


import java.io.File;
import java.io.IOException;

import java.util.List;

public class FileServiceImpl implements FileServiceFace {
    @Override
    public List<PartnerData> readPartnerFromJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Lire le JSON complet
            JsonNode rootNode = mapper.readTree(new File(filePath));

            // Récupérer le tableau "data" et le convertir en List<PartnerData>
            return mapper.convertValue(
                    rootNode.get("data"),
                    new TypeReference<List<PartnerData>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Erreur lecture JSON : " + filePath, e);
        }
    }
}
