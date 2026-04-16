package com.solvd.itcompany.model.Service;

import com.solvd.itcompany.interfaces.FileFormatter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {

    public static void countSpecialWords(String inputPath, String outputPath, String[] specialWords, FileFormatter formatter) throws IOException {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        String content = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8).toLowerCase();

        // TRANSFORMANDO EM STREAM (Substituindo a iteração manual)
        List<String> results = Arrays.stream(specialWords) // 1. Cria a Stream do Array
                .map(word -> {
                    int count = StringUtils.countMatches(content, word.toLowerCase());
                    return formatter.format(word, count); // 2. Usa a Functional Interface
                })
                .collect(Collectors.toList()); // 3. Coleta em uma nova Lista

        // Escrevendo no arquivo usando Stream também
        String finalReport = results.stream().collect(Collectors.joining("\n", "--- Report ---\n", "\n"));
        FileUtils.writeStringToFile(outputFile, finalReport, StandardCharsets.UTF_8, true);
    }
}