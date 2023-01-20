import com.prowrestler.stats.Wrestler;
import com.prowrestler.stats.StatGenerator;
import com.prowrestler.stats.Logger;
import com.prowrestler.ui.UserInput;
import com.prowrestler.ui.UserOutput;

import java.util.*;

public class WrestlerStatGeneratorCLI {

    public static void main(String[] args) {

        WrestlerStatGeneratorCLI application = new WrestlerStatGeneratorCLI();
        application.run();

    }

    public void run() {
        UserOutput.printWelcome();

        List<Integer> stats = StatGenerator.rollStats();
        UserOutput.printNumberResults(stats);

        //we have sorted list, now allow user to put stats into Character
        Wrestler wrestler = statAllocator(stats);
        System.out.println();
        UserOutput.printWrestlerStats(wrestler);

        //get name
        String name = UserInput.getName();
        wrestler.setName(name);

        boolean saveToFile = UserInput.getYesNoChoice("Would you like to save this character to a .txt file (y/n)?: ");
        if (saveToFile) {
            Logger.saveWrestlerToFile(wrestler);

        }

        boolean goAgain = UserInput.getYesNoChoice("Would you like to make another character (y/n)?: ");
        if (goAgain) run();
    }

    private Wrestler statAllocator(List<Integer> stats) {
        boolean sortDescending = false;
        String sortChoice = UserInput.getStatSortOption();
        if (sortChoice.equals("highest")) sortDescending = true;

        Wrestler finalStats = new Wrestler();
        //TODO: prompt user for whether they are happy w/ choice, if not reset the whole dang thing
        //while(true) {
        finalStats.resetStats();
        while(stats.size() > 0) {

            Collections.sort(stats);
            if (sortDescending) Collections.reverse(stats);

            UserOutput.printUnallocatedStatList(stats);

            int statToPut = stats.get(0);
            stats.remove(0);

            String statChoice = UserInput.getStatChoice(finalStats, statToPut);

            //if they are replacing a stat, get the other one back to put somewhere else
            if (!finalStats.isStatEmpty(statChoice)) stats.add(finalStats.get(statChoice));

            finalStats.changeStat(statChoice, statToPut);

        }

        //}
        return finalStats;
    }
}
