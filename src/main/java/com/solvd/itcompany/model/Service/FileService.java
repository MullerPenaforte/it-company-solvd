package com.solvd.itcompany.model.Service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileService {

    public static void countSpecialWords(String inputPath, String outputPath, String[] specialWords) throws IOException {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);


        String content = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);

        StringBuilder result = new StringBuilder();
        result.append("--- New Scan ---\n");

        for (String word : specialWords) {

            int count = StringUtils.countMatches(content.toLowerCase(), word.toLowerCase());
            result.append("Word '").append(word).append("' found: ").append(count).append(" times.\n");
        }


        FileUtils.writeStringToFile(outputFile, result.toString() + "\n", StandardCharsets.UTF_8, true);
    }
}