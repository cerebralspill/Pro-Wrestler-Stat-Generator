package com.prowrestler.stats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Logger {


    public static void saveWrestlerToFile(Wrestler completeWrestler) {
        LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        String dateString = date.toString().replace(':', 'm');
        dateString += 's';
        String fileName = completeWrestler.getName() + "_stats_" + dateString + ".txt";
        File file = new File("wrestler_logs/" + fileName);

        try (PrintWriter pw = new PrintWriter(file.getAbsoluteFile())) {
            pw.println("Wrestler: " + completeWrestler.getName());
            pw.println("---------------------------");
            pw.println("         Stats");
            pw.println("---------------------------");
            pw.println(completeWrestler.toString());

            System.out.println("File successfully saved to " + fileName + " and placed in the wrestler_logs folder");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
