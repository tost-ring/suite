package suite;

import suite.suite.Subject;
import suite.suite.Suite;
import suite.suite.util.Sequence;
import suite.suite.util.Series;

public class Main {

    public static void main(String[] args) {
        var $ = Suite.inSet("a", "b", "c").inSet("a", "d", "e").inSet("a", "d", "f");
//        Suite.preDfs($).print();
        Suite.refactor($, s -> s.shift(s.direct(), s.as(String.class).toUpperCase())).print();
        $ = Suite.setAll(Sequence.of(1, 2, 3 ,4 , 5));
        Series.parallel($, $.reverse()).
                convert(s -> Suite.set(s.at(0).as(Integer.class) * s.at(1).as(Integer.class))).print();

        var $2 = Suite.inSet(1 );
        $2.setIf(Subject::absent, 2);
        $2.print();
    }
}
