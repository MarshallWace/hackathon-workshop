package com.mwam.hackathon.sources;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Parse a CSV file and emit the rows as record.
 *
 * @param <T> Java class to parse rows to.
 */
public class CSVSource<T> extends Source<T> {
    final Class<T> rowClass;
    final String filename;

    public CSVSource(Class<T> rowClass, String filename) {
        super(new ArrayList<>());
        this.rowClass = rowClass;
        this.filename = filename;
    }

    private List<T> getRows() {
        try {
            return new CsvToBeanBuilder<T>(new FileReader(filename))
                .withType(rowClass)
                .build()
                .parse();
        } catch (FileNotFoundException e) {
            // not good practice but unchecked exceptions are noisy
            throw new RuntimeException(e);
        }
    }

    /**
     * Begin emitting values.
     */
    @Override
    public void start() {
        for (final var row : getRows()) {
            emit(row);
        }

        flush();
    }
}
