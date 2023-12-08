package entities;


public class Edge implements Comparable<Edge> {
    private int u;
    private int v;
    private int w;
    private String uKey;
    private String vKey;

    public Edge(int u, int v, int w, String uKey, String vKey) {
        this.u = u;
        this.v = v;
        this.w = w;
        this.uKey = uKey;
        this.vKey = vKey;
    }

    @Override
    public int compareTo(Edge edge) {
        if (w != edge.w) return w < edge.w ? -1 : 1;
        return 0;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public String getUKey() {
        return uKey;
    }

    public void setUKey(String uKey) {
        this.uKey = uKey;
    }

    public String getVKey() {
        return vKey;
    }

    public void setVKey(String vKey) {
        this.vKey = vKey;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                ", uKey='" + uKey + '\'' +
                ", vKey='" + vKey + '\'' +
                '}';
    }
}
