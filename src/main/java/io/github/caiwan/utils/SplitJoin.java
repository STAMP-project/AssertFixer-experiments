package io.github.caiwan.utils;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

// use Google guava instead

@Deprecated
public class SplitJoin {

    String splitDelimiter;
    String joinDelimiter;
    String enclose;
    boolean truncSpaces;

    public SplitJoin(String splitDelimiter, String joinDelimiter, String enclose, boolean truncSpaces) {
        super();
        this.splitDelimiter = splitDelimiter;
        this.joinDelimiter = joinDelimiter;
        this.enclose = enclose;
        this.truncSpaces = truncSpaces;
    }

    public String doFormat(String in) {
        List<String> result = Lists.newArrayList(Splitter.on(splitDelimiter).trimResults().omitEmptyStrings().split(in));
        result = result.stream().map(string -> enclose + string + enclose).collect(Collectors.toList());
        return Joiner.on(joinDelimiter).skipNulls().join(result);
    }

}
