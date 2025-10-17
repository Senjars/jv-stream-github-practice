package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().trim().split("-");
        int firstYear = Integer.parseInt(periods[0]);
        int lastYear = Integer.parseInt(periods[1]);

        boolean livedInUkrForDecade = lastYear - firstYear >= 10;

        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && livedInUkrForDecade;
    }
}
