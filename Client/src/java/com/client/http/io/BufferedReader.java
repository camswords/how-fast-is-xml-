package com.client.http.io;

import com.client.condition.ReaderIsReady;
import com.client.time.UnitOfTime;
import com.client.util.Lists;
import com.client.time.Timer;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BufferedReader {
    
    private final Reader reader;

    public BufferedReader(Reader reader) {
        this.reader = reader;
    }

    public List<String> readUntil(String terminationLine) {
        final java.io.BufferedReader reader = new java.io.BufferedReader(this.reader);

        try {
            List<String> lines = Lists.create();

            new Timer(60, UnitOfTime.SECONDS).waitFor(new ReaderIsReady(reader));

            while(reader.ready()) {
                String line = reader.readLine();

                if (terminationLine.equals(line)) {
                    break;
                }

                lines.add(line);
            }

            return lines;
        } catch (IOException e) {
            throw new FailedToReadException("failed to consume all lines of reader", e);
        }
    }
}
