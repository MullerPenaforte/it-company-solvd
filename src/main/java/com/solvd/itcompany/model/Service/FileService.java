package com.solvd.itcompany.model.Service;

import com.solvd.itcompany.interfaces.FileFormatter;
import com.solvd.itcompany.model.Records.WordResult;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    private static final Logger LOGGER = LogManager.getLogger(FileService.class);

    public static void countSpecialWords(String inputPath, String outputPath, String[] specialWords, FileFormatter formatter) throws IOException {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        String content = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8).toLowerCase();

        List<WordResult> wordResults = Arrays.stream(specialWords)
                .map(word -> new WordResult(word, StringUtils.countMatches(content, word.toLowerCase())))
                .collect(Collectors.toList());

        String finalReport = wordResults.stream()
                .map(result -> formatter.format(result.word(), result.count()))
                .collect(Collectors.joining("\n", "--- Word Count Report ---\n", "\n"));

        FileUtils.writeStringToFile(outputFile, finalReport, StandardCharsets.UTF_8, true);

        LOGGER.info("Report generated successfully with {} entries.", wordResults.size());
    }
}