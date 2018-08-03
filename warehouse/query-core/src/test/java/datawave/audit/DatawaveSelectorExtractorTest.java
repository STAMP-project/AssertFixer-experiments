package datawave.audit;

import com.google.common.collect.Lists;
import java.util.List;
import datawave.webservice.query.QueryImpl;
import org.junit.Assert;
import org.junit.Test;

public class DatawaveSelectorExtractorTest {
    
    @Test
    public void extractSelectorsLuceneQuery1() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1:selector1");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1");
        Assert.assertEquals(expected, selectorList);
    }
    
    @Test
    public void extractSelectorsLuceneQuery2() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1:selector1 AND selector2 AND selector3");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1", "selector2", "selector3");
        Assert.assertEquals(expected, selectorList);
    }
    
    @Test
    public void extractSelectorsLuceneQuery3() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1:selector1 OR selector2 OR (selector3 AND selector4)");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1", "selector2", "selector3", "selector4");
        Assert.assertEquals(expected, selectorList);
    }
    
    @Test
    public void extractSelectorsNegation() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1:selector1 NOT selector2");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1");
        Assert.assertEquals(expected, selectorList);
    }
    
    @Test
    public void extractSelectorsDoubleNegation() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1:selector1 NOT (selector2 NOT selector3)");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1", "selector3");
        Assert.assertEquals(expected, selectorList);
    }
    
    @Test
    public void extractSelectorsTripleNegation() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1:selector1 NOT (selector2 NOT (selector3 NOT selector4))");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1", "selector3");
        Assert.assertEquals(expected, selectorList);
    }
    
    @Test
    public void extractSelectorsWildcard() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1:selector1 AND selector.*");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1");
        Assert.assertEquals(expected, selectorList);
    }
    
    @Test
    public void extractSelectorsJEXLQuery1() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1 == 'selector1'");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1");
        Assert.assertEquals(expected, selectorList);
    }
    
    @Test
    public void extractSelectorsJEXLQuery2() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1 == 'selector1' && _ANY_FIELD_ == 'selector2' && _ANY_FIELD_ == 'selector3'");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1", "selector2", "selector3");
        Assert.assertEquals(expected, selectorList);
    }
    
    @Test
    public void extractSelectorsJEXLQuery3() {
        
        DatawaveSelectorExtractor extractor = new DatawaveSelectorExtractor();
        QueryImpl q = new QueryImpl();
        q.setQuery("FIELD1 == 'selector1' || _ANY_FIELD_ == 'selector2' || (_ANY_FIELD_ == 'selector3' && _ANY_FIELD_ == 'selector4')");
        List<String> selectorList = extractor.extractSelectors(q);
        List<String> expected = Lists.newArrayList("selector1", "selector2", "selector3", "selector4");
        Assert.assertEquals(expected, selectorList);
    }
}
