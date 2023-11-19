package structures;

public class DisjointSetByRoman {
    private int[] set; // номер множества
    private int[] rnk; // ранг

    public DisjointSetByRoman(int size) {
        set = new int[size];
        rnk = new int[size];
        for (int i = 0; i < size; i++)
            set[i] = i;
    }

    /**
     * Возвращает множество, которому принадлежит x
     *
     * @param x X
     * @return множество, которому принадлежит X
     */
    int set(int x) {
        return x == set[x] ? x : (set[x] = set(set[x]));
    }

    /**
     * Если u и v лежат в разных множествах, то сливаем их и возвращаем true
     *
     * @param u
     * @param v
     * @return true, если множества слиты, false иначе
     */
    public boolean union(int u, int v) {
        if ((u = set(u)) == (v = set(v))) return false;
        if (rnk[u] < rnk[v]) {
            set[u] = v;
        } else {
            set[v] = u;
            if (rnk[u] == rnk[v]) rnk[u]++;
        }
        return true;
    }

    public int[] getSet() {
        return set;
    }

    public void setSet(int[] set) {
        this.set = set;
    }

    public int[] getRnk() {
        return rnk;
    }

    public void setRnk(int[] rnk) {
        this.rnk = rnk;
    }
}
