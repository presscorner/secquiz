package secquiz;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.Token;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class CustomOptional extends Optional {

    public CustomOptional(){
        super(new Token("", null, new Token("NULL", null)));
    }


    public CustomOptional(final CellProcessor next) {
        super(new Token("", null, new Token("NULL", null, next)));
    }

}
