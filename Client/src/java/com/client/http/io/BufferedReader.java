package com.client.http.io;

import com.client.util.Lists;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BufferedReader {
    
    private final Reader reader;

    public BufferedReader(Reader reader) {
        this.reader = reader;
    }

    public List<String> readAllLines() {
        final java.io.BufferedReader reader = new java.io.BufferedReader(this.reader);

        try {
            List<String> lines = Lists.create();

            while(reader.ready()) {
                String line = reader.readLine();

                if (line == null) break;

                lines.add(line);
            }

            return lines;
        } catch (IOException e) {
            throw new FailedToReadException("failed to consume all lines of reader", e);
        }
    }
}
