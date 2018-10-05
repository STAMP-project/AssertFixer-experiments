package ru.job4j.array;

public class Experiment {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.arraycopy(a, 2, a, 1, 3);
        System.out.println(a[0] + " ");
        System.out.println(a[1] + " ");
        System.out.println(a[2] + " ");
        System.out.println(a[3] + " ");
        System.out.println(a[4] + " ");
    }
    /*int p = 0;
        for (int k = 0; k < this.position; k++) {
        if (this.items[k].getId().equals(id)) {
            this.items[k] = null;
            p = k;
            break;
        }
    }
        System.arraycopy(this.items, p + 1, this.items, p, this.items.length - p - 1); */
}