package org.jfree.chart;


public class LegendItemCollection implements java.io.Serializable , java.lang.Cloneable {
	private static final long serialVersionUID = 1365215565589815953L;

	private java.util.List items;

	public LegendItemCollection() {
		this.items = new java.util.ArrayList();
	}

	public void add(org.jfree.chart.LegendItem item) {
		this.items.add(item);
	}

	public void addAll(org.jfree.chart.LegendItemCollection collection) {
		this.items.addAll(collection.items);
	}

	public org.jfree.chart.LegendItem get(int index) {
		return ((org.jfree.chart.LegendItem) (this.items.get(index)));
	}

	public int getItemCount() {
		return this.items.size();
	}

	public java.util.Iterator iterator() {
		return this.items.iterator();
	}

	public boolean equals(java.lang.Object obj) {
		if (obj == (this)) {
			return true;
		}
		if (!(obj instanceof org.jfree.chart.LegendItemCollection)) {
			return false;
		}
		org.jfree.chart.LegendItemCollection that = ((org.jfree.chart.LegendItemCollection) (obj));
		if (!(this.items.equals(that.items))) {
			return false;
		}
		return true;
	}

	public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
		org.jfree.chart.LegendItemCollection clone = ((org.jfree.chart.LegendItemCollection) (super.clone()));
		clone.items = ((java.util.List) (org.jfree.chart.util.ObjectUtilities.deepClone(this.items)));
		return clone;
	}
}

