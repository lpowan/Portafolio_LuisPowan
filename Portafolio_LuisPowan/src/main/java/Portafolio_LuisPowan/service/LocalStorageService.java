package Portafolio_LuisPowan.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Guarda las imagenes en una carpeta de la PC.
 * Las imagenes se publican en la URL /imagenes/** (ver ProjectConfig).
 *
 * @author ltgpo
 */
@Service
public class LocalStorageService {

    @Value("${app.uploads.dir}")
    private String uploadsDir;

    //Guarda la imagen en <uploadsDir>/<folder>/imgNNNNNNNNNNNNNN.ext y devuelve su URL.
    public String uploadImage(MultipartFile localFile, String folder, Integer id) throws IOException {
        String originalName = localFile.getOriginalFilename();
        String fileExtension = "";
        if (originalName != null && originalName.contains(".")) {
            fileExtension = originalName.substring(originalName.lastIndexOf(".")).toLowerCase();
        }

        // Se genera el nombre del archivo con un formato consistente.
        String fileName = "img" + getFormattedNumber(id) + fileExtension;

        Path carpeta = Paths.get(uploadsDir, folder).toAbsolutePath().normalize();
        Files.createDirectories(carpeta);
        try (InputStream in = localFile.getInputStream()) {
            Files.copy(in, carpeta.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        }

        // Se agrega la hora para que el navegador no muestre la imagen anterior en cache.
        return "/imagenes/" + folder + "/" + fileName + "?v=" + System.currentTimeMillis();
    }

    /**
     * Genera un string numérico con un formato de 14 dígitos, rellenado con
     * ceros a la izquierda.
     */
    private String getFormattedNumber(long id) {
        return String.format("%014d", id);
    }
}
