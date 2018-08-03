package datawave.webservice.query.logic;

import datawave.marking.MarkingFunctions;

public abstract class BaseQueryLogicTransformer extends AbstractQueryLogicTransformer implements QueryLogicTransformer {
    
    protected MarkingFunctions markingFunctions;
    
    public BaseQueryLogicTransformer(MarkingFunctions markingFunctions) {
        if (null == markingFunctions) {
            throw new IllegalArgumentException("MarkingFunctions must be set");
        }
        this.markingFunctions = markingFunctions;
    }
}
