/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.parser;

import simpleAdder.node.*;
import simpleAdder.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTInteger(@SuppressWarnings("unused") TInteger node)
    {
        this.index = 0;
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 1;
    }

    @Override
    public void caseTSemi(@SuppressWarnings("unused") TSemi node)
    {
        this.index = 2;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 3;
    }
}
