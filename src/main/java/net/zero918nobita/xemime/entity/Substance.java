package net.zero918nobita.xemime.entity;

import net.zero918nobita.xemime.ast.Node;

import java.util.ArrayList;

/**
 * 実体を表すノードです。
 * @author Kodai Matsumoto
 */

public class Substance extends Node {
    private ArrayList<Node> members;

    public Substance(int location) {
        super(location);
    }

    public void attachAttr(Attr attr) {
        if (members == null) members = new ArrayList<>();

    }
}
